package br.com.app.utils;

import static org.junit.Assert.*;

import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

public class ErrorUtilsTest {

	@Test
	public void haveError() {
		String path = (FilenameUtils.normalize(System.getProperty("user.dir") + "/src/main/webapp/"));
		String file = "error.html";
		assertTrue(FileUtils.dirHaveFile(file, path));
	}

}
