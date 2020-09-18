package br.com.hilker.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="datasource")
public class DataSourceProperties {

	private Parametros ase;
	
	private Parametros postgre;
	
	public static class Parametros {
		
		private String jndi;
		
		private String persistenceUnit;

		public String getJndi() {
			return jndi;
		}

		public void setJndi(String jndi) {
			this.jndi = jndi;
		}

		public String getPersistenceUnit() {
			return persistenceUnit;
		}

		public void setPersistenceUnit(String persistenceUnit) {
			this.persistenceUnit = persistenceUnit;
		}

		@Override
		public String toString() {
			return "Parametros [jndi=" + jndi + ", persistenceUnit=" + persistenceUnit + "]";
		}
		
	}

	public Parametros getAse() {
		return ase;
	}

	public void setAse(Parametros ase) {
		this.ase = ase;
	}

	public Parametros getPostgre() {
		return postgre;
	}

	public void setPostgre(Parametros postgre) {
		this.postgre = postgre;
	}

	@Override
	public String toString() {
		return "DataSourceProperties [ase=" + ase + ", postgre=" + postgre + "]";
	}
	
}

