package br.com.app.login.credenciais;

public final class AWSCred {

	private static final long serialVersionUID = 1L;
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 140; // 140MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 150; // 150MB
	private final String UUID_STRING;
	private final String AMAZON_ACCESS_KEY;
	private final String AMAZON_SECRET_KEY;
	private final String S3_BUCKET_NAME;

	public AWSCred(String UUID_STRING, String AMAZON_ACCESS_KEY, String AMAZON_SECRET_KEY, String S3_BUCKET_NAME) {
		this.UUID_STRING = UUID_STRING;
		this.AMAZON_ACCESS_KEY = AMAZON_ACCESS_KEY;
		this.AMAZON_SECRET_KEY = AMAZON_SECRET_KEY;
		this.S3_BUCKET_NAME = S3_BUCKET_NAME;
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

	public String getUuidString() {
		return UUID_STRING;
	}

	public String getAmazonAccessKey() {
		return AMAZON_ACCESS_KEY;
	}

	public String getAmazonSecretKey() {
		return AMAZON_SECRET_KEY;
	}

	public String getS3BucketName() {
		return S3_BUCKET_NAME;
	}

}
