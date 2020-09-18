package br.com.hilker;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		
		configurer.defaultContentType(MediaType.APPLICATION_JSON);
		
	}
	
	/*
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		
		UtilLog.getLog().info("### Configurando Jackson ###");
		
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder.serializationInclusion(Include.ALWAYS);
		builder.modules(new JaxbAnnotationModule());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		builder.dateFormat(dateFormat);
		builder.indentOutput(true);
		
		return builder;
	}
	*/

}
