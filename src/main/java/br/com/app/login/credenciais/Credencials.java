package br.com.app.login.credenciais;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import br.com.app.index.Index;

public enum Credencials {

	AMAZON_ACCESS_KEY {

		public String toString() {
			URL url = Index.class.getClassLoader().getResource("credencials");
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader(url.getPath()));
				String line = reader.readLine();
				while (line != null) {
					if (!line.startsWith("#"))
						return line;
					line = reader.readLine();
				}
			} catch (IOException e) {
				System.out.println("Arquivo de credencial inválido.");
			} finally {
				try {
					reader.close();
				} catch (IOException e) {
					throw new IllegalArgumentException("Arquivo de credencial vazio. Favor preencher");
				}
			}
			throw new IllegalArgumentException("Arquivo de credencial vazio. Favor preencher");
		}
	},

	AMAZON_SECRET_KEY {
		public String toString() {
			URL url = Index.class.getClassLoader().getResource("credencials");
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader(url.getPath()));
				String line = reader.readLine();
				int li = 0;
				while (line != null) {
					if (!line.startsWith("#")) {
						if (li == 1)
							return line;
						li++;
					}
					line = reader.readLine();
				}
			} catch (IOException e) {
				System.out.println("Arquivo de credencial inválido.");
			} finally {
				try {
					reader.close();
				} catch (IOException e) {
					throw new IllegalArgumentException("Arquivo de credencial vazio. Favor preencher");
				}
			}
			throw new IllegalArgumentException("Arquivo de credencial vazio. Favor preencher");
		}
	},

	S3_BUCKET_NAME {
		public String toString() {
			URL url = Index.class.getClassLoader().getResource("credencials");
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader(url.getPath()));
				String line = reader.readLine();
				int li = 0;
				while (line != null) {
					if (!line.startsWith("#")) {
						if (li == 2)
							return line;
						li++;
					}
					line = reader.readLine();
				}
			} catch (IOException e) {
				System.out.println("Arquivo de credencial inválido.");
			} finally {
				try {
					reader.close();
				} catch (IOException e) {
					throw new IllegalArgumentException("Arquivo de credencial vazio. Favor preencher");
				}
			}
			throw new IllegalArgumentException("Arquivo de credencial vazio. Favor preencher");
		}
	};

}