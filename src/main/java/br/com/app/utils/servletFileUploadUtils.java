package br.com.app.utils;

import java.io.IOException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import br.com.app.login.credenciais.Credencials;

public final class servletFileUploadUtils {

	private servletFileUploadUtils() {
	}

	public static String uploadAWS_S3(FileItem video, String uuidValue, AmazonS3 s3client) throws IOException {
		ObjectMetadata om = new ObjectMetadata();
		om.setContentLength(video.getSize());
		String ext = FilenameUtils.getExtension(video.getName());
		String keyName = uuidValue + '.' + ext;

		s3client.putObject(
				new PutObjectRequest(Credencials.S3_BUCKET_NAME.toString(), keyName, video.getInputStream(), om));
		s3client.setObjectAcl(Credencials.S3_BUCKET_NAME.toString(), keyName, CannedAccessControlList.PublicRead);

		return ("s3://" + Credencials.S3_BUCKET_NAME.toString() + "/" + keyName);
	}
}
