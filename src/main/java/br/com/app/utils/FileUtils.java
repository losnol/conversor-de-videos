package br.com.app.utils;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FilenameUtils;

public class FileUtils {

	public static boolean dirHaveFile(String file, String path) {

		Path dirPath = Paths.get(path);
		DirectoryStream<Path> dirStream = null;

		try {
			dirStream = Files.newDirectoryStream(dirPath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (Path filePath : dirStream) {

			String filename = filePath.getFileName().toString();
			boolean fileFound = FilenameUtils.wildcardMatch(filename, file);
			if (fileFound) {
				return true;
			}
		}

		try {
			dirStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}
}
