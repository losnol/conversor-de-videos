package br.com.app.testes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class MainTeste {

	public static void main(String[] args) {
		BufferedReader reader;
		try {
			URL url = MainTeste.class.getClassLoader().getResource("credencials");
			System.out.println(url.getPath());
			reader = new BufferedReader(new FileReader(url.getPath()));
			String line = reader.readLine();
			while (line != null) {
				if (!line.startsWith("#"))
				System.out.println(line);
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}