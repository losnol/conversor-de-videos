package br.com.app.input;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import com.amazonaws.auth.BasicAWSCredentials;

import br.com.app.login.credenciais.Credencials;
import br.com.app.login.credenciais.S3Sizes;
import br.com.app.utils.FileUtils;

public class VideoRawTest {

	@Test
	public void testSizes() {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(S3Sizes.THRESHOLD_SIZE.getSizeValue());

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(S3Sizes.MAX_FILE_SIZE.getSizeValue());
		upload.setSizeMax(S3Sizes.MAX_REQUEST_SIZE.getSizeValue());

		assertNotNull(factory.getSizeThreshold());
		assertNotNull(upload.getFileSizeMax());
		assertNotNull(upload.getSizeMax());

		assertTrue(factory.getSizeThreshold() > 0);
		assertTrue(upload.getFileSizeMax() > 0);
		assertTrue(upload.getSizeMax() > 0);
	}

	@Test
	public void testCredencials() {
		BasicAWSCredentials awsCredentials = new BasicAWSCredentials(Credencials.AMAZON_ACCESS_KEY.toString(),
				Credencials.AMAZON_SECRET_KEY.toString());
		assertNotNull(awsCredentials.getAWSAccessKeyId());
		assertNotNull(awsCredentials.getAWSSecretKey());

		assertTrue(awsCredentials.getAWSAccessKeyId().length() > 0);
		assertTrue(awsCredentials.getAWSSecretKey().length() > 0);
	}
	
	@Test
	public void haveError() {
		String path = (FilenameUtils.normalize(System.getProperty("user.dir") + "/src/main/webapp/"));
		String file = "error.html";
		assertTrue(FileUtils.dirHaveFile(file, path));
	}
}
