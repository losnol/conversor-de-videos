package br.com.app.utils;

import java.io.IOException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import br.com.app.login.credenciais.AWSCred;

public final class servletFileUploadUtils {
	
	private servletFileUploadUtils() {
		
	}
	
	public static String uploadAWS_S3(FileItem video, String uuidValue,AmazonS3 s3client, AWSCred cred) throws IOException {
		ObjectMetadata om = new ObjectMetadata();
		om.setContentLength(video.getSize());
		String ext = FilenameUtils.getExtension(video.getName());
		String keyName = uuidValue + '.' + ext;

		s3client.putObject(new PutObjectRequest(cred.getS3BucketName(), keyName, video.getInputStream(), om));
		s3client.setObjectAcl(cred.getS3BucketName(), keyName, CannedAccessControlList.PublicRead);
		 
		return ("s3://" + cred.getS3BucketName() + "/"  + keyName);
	} 

} 
