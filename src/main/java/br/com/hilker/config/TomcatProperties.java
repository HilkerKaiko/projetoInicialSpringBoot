package br.com.hilker.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="tomcat.ajp")
public class TomcatProperties {

	private Integer port;
	
	private Integer redirecPort;
	
	private String remoteAuthentication;
	
	private Boolean enabled;

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}
	
	public Integer getRedirecPort() {
		return redirecPort;
	}

	public void setRedirecPort(Integer redirecPort) {
		this.redirecPort = redirecPort;
	}

	public String getRemoteAuthentication() {
		return remoteAuthentication;
	}

	public void setRemoteAuthentication(String remoteAuthentication) {
		this.remoteAuthentication = remoteAuthentication;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "TomcatProperties [port=" + port + ", redirecPort=" + redirecPort + ", remoteAuthentication="
				+ remoteAuthentication + ", enabled=" + enabled + "]";
	}
	
}

