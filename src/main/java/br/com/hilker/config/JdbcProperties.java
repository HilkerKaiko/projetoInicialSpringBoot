package br.com.hilker.config;


import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="jdbc")
public class JdbcProperties {
	
	private List<Server> server = new ArrayList<>();
	
	public static class Server{
		
		private String driverClassName;
		
		private String url;
		
		private String user;
		
		private String pass;
		
		private String maxIdle;
		
		private String maxTotal;

		private String removeAbandonedOnBorrow;
		
		private String removeAbandonedTimeout;
		
		private String removeAbandonedOnMaintenance;
		
		private String maxWaitMillis;
		
		private String jndi;

		public String getDriverClassName() {
			return driverClassName;
		}

		public void setDriverClassName(String driverClassName) {
			this.driverClassName = driverClassName;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}

		public String getMaxIdle() {
			return maxIdle;
		}

		public void setMaxIdle(String maxIdle) {
			this.maxIdle = maxIdle;
		}

		public String getMaxTotal() {
			return maxTotal;
		}

		public void setMaxTotal(String maxTotal) {
			this.maxTotal = maxTotal;
		}

		public String getRemoveAbandonedOnBorrow() {
			return removeAbandonedOnBorrow;
		}

		public void setRemoveAbandonedOnBorrow(String removeAbandonedOnBorrow) {
			this.removeAbandonedOnBorrow = removeAbandonedOnBorrow;
		}

		public String getRemoveAbandonedTimeout() {
			return removeAbandonedTimeout;
		}

		public void setRemoveAbandonedTimeout(String removeAbandonedTimeout) {
			this.removeAbandonedTimeout = removeAbandonedTimeout;
		}
		
		public String getRemoveAbandonedOnMaintenance() {
			return removeAbandonedOnMaintenance;
		}

		public void setRemoveAbandonedOnMaintenance(String removeAbandonedOnMaintenance) {
			this.removeAbandonedOnMaintenance = removeAbandonedOnMaintenance;
		}
	
		public String getMaxWaitMillis() {
			return maxWaitMillis;
		}

		public void setMaxWaitMillis(String maxWaitMillis) {
			this.maxWaitMillis = maxWaitMillis;
		}

		public String getJndi() {
			return jndi;
		}

		public void setJndi(String jndi) {
			this.jndi = jndi;
		}

		@Override
		public String toString() {
			return "Server [driverClassName=" + driverClassName + ", url=" + url + ", user=" + user + ", pass=" + pass
					+ ", maxIdle=" + maxIdle + ", maxTotal=" + maxTotal + ", removeAbandonedOnBorrow="
					+ removeAbandonedOnBorrow + ", removeAbandonedTimeout=" + removeAbandonedTimeout
					+ ", removeAbandonedOnMaintenance=" + removeAbandonedOnMaintenance + ", maxWaitMillis="
					+ maxWaitMillis + ", jndi=" + jndi + "]";
		}
	}

	public List<Server> getServer() {
		return server;
	}

	public void setServer(List<Server> jdbc) {
		this.server = jdbc;
	}

	@Override
	public String toString() {
		return "JdbcProperties [server=" + server + "]";
	}
}
