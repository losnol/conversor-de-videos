package br.com.app.index;

import static org.junit.Assert.assertTrue;

import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import br.com.app.utils.FileUtils;

public class IndexTest {

	@Test
	public void haveIndex() {
		String path = (FilenameUtils.normalize(System.getProperty("user.dir") + "/src/main/webapp/"));
		String file = "index.html";
		assertTrue(FileUtils.dirHaveFile(file, path));
	}
}
