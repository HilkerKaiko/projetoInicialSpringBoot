package br.com.hilker;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import br.com.hilker.util.UtilLog;
import br.com.hilker.util.UtilRecurso;

public class SegurancaProperties {
	private static final String ARQUIVO_PROPERTIES_SERVIDOR = String.format("%s/conf/seguranca.properties",
			System.getProperty("catalina.home"));

	private static Properties segurancaProperties = new Properties();

	private SegurancaProperties() {

	}

	public static void carregarParametros() {
		try {
			File arquivo = new File(ARQUIVO_PROPERTIES_SERVIDOR);
			//if (!arquivo.exists()) {
				segurancaProperties = UtilRecurso.getProperties("seguranca");
			//} else {
				//segurancaProperties.load(new FileInputStream(arquivo));
		//	}
		} catch (Exception e) {
			UtilLog.getLog().error(e.getMessage(), e);
		}
	}

	public static String getProperty(String chave) {
		carregarParametros();
		return segurancaProperties.getProperty(chave);
	}
	
	// Login
		public static String getLoginNome() {
			carregarParametros();
			return getProperty("seguranca.login.nome");
		}

		public static String getLoginSenha() {
			carregarParametros();
			return getProperty("seguranca.login.senha");
		}


}
