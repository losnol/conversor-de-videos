package br.com.app.login.credenciais;

public final class AWSCred {
	
	private static final long serialVersionUID = 1L;
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 140; // 140MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 150; // 150MB
	private static final String UUID_STRING = "uuid";
	private static final String AMAZON_ACCESS_KEY = "AKIAJSSITP7FQOEGQTOA";
	private static final String AMAZON_SECRET_KEY = "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";
	private static final String S3_BUCKET_NAME = "videoconvertertowebformat";
	
	private AWSCred() {
		
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID; 
	}
	public static int getThresholdSize() {
		return THRESHOLD_SIZE;
	}
	public static int getMaxFileSize() {
		return MAX_FILE_SIZE;
	}
	public static int getMaxRequestSize() {
		return MAX_REQUEST_SIZE;
	}
	public static String getUuidString() {
		return UUID_STRING; 
	}
	public static String getAmazonAccessKey() {
		return AMAZON_ACCESS_KEY;
	}
	public static String getAmazonSecretKey() {
		return AMAZON_SECRET_KEY;
	}
	public static String getS3BucketName() {
		return S3_BUCKET_NAME;
	}

}
