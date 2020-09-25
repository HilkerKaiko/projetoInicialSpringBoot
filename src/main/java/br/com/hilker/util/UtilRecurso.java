package br.com.hilker.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UtilRecurso {
	
	public static ClassLoader getClassLoader(){
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		if(loader == null){
			loader = ClassLoader.getSystemClassLoader();
		}
		return loader;
	}
	
	public static String convertePacoteDiretorio(String pacote){
		StringBuffer sb = new StringBuffer(pacote);
		for(int i = 0; i < sb.length(); i++){
			char caracter = sb.charAt(i);
			if(caracter == '.'){
				sb.replace(i, i+1, "/");
			}
		}
		return sb.toString();
	}
	
	public static InputStream getInputStreamRecursoDiretorio(String pacoteClasse) throws Exception{
		try {
			return getClassLoader().getResourceAsStream(pacoteClasse);
		} catch (Exception e) {
			UtilLog.getLog().error("erro ao buscar propriedades", e);
			throw new Exception(e.getMessage(), e);
		}
	}
	
	public static InputStream getInputStreamRecurso(String pacoteClasse, String extensao) throws Exception{
		return getInputStreamRecursoDiretorio(convertePacoteDiretorio(pacoteClasse)+extensao);
	}
	
	public static Properties getProperties(String pacoteArquivo) throws Exception {
		Properties prop = new Properties();
		InputStream is = getInputStreamRecurso(pacoteArquivo, ".properties");
		try {
			if(is != null){
				prop.load(is);
				is.close();
			}else{
				throw new Exception("Arquivo '" + pacoteArquivo + ".properties' nÃ£o encontrado.");
			}
		} catch (IOException e) {
			UtilLog.getLog().error("erro ao buscar propriedades: " + pacoteArquivo, e);
			throw new Exception(e.getMessage(), e);
		} catch (RuntimeException e) {
			UtilLog.getLog().error("erro ao buscar propriedades: " + pacoteArquivo, e);
			throw new Exception(e.getMessage(), e);
		}
		return prop;        
	}

}
