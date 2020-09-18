package br.com.hilker.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.ajp.AbstractAjpProtocol;
import org.apache.coyote.ajp.AjpNio2Protocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

public class AppicationConfigTomcat {
	
	@Autowired
	private TomcatProperties tomcatProperties;
	
	@Bean
	public TomcatServletWebServerFactory tomcatFactory() {
		
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		
		if (tomcatProperties.getEnabled()) {
			Connector ajpConnector = new Connector(AjpNio2Protocol.class.getName());
			ajpConnector.setPort(tomcatProperties.getPort());
			ajpConnector.setSecure(false);
			ajpConnector.setAllowTrace(false);
			ajpConnector.setScheme("https");
			// ajpConnector.setEnableLookups(true);
			// ajpConnector.setUseIPVHosts(true);
			// ajpConnector.setProperty("address", "172.15.2.57");
			((AbstractAjpProtocol) ajpConnector.getProtocolHandler()).setSecretRequired(false);
			// ajpConnector.setRedirectPort(tomcatProperties.getRedirecPort());
			
			tomcat.addAdditionalTomcatConnectors(ajpConnector);
			
		}
		
		return tomcat;
		
	}

}
