package br.com.app.login.credenciais;

public enum S3Sizes {

	THRESHOLD_SIZE(1024 * 1024 * 3), MAX_FILE_SIZE(1024 * 1024 * 140), MAX_REQUEST_SIZE(1024 * 1024 * 150); 
	private final int sizeValue;

	private S3Sizes(final int i) {
		sizeValue = i;
	}

	public int getSizeValue() {
		return sizeValue;
	}
}
