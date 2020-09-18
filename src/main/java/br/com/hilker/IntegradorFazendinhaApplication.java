package br.com.hilker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("br.com.hilker.entity")
@EnableJpaRepositories("br.com.hilker.repository") 
public class IntegradorFazendinhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegradorFazendinhaApplication.class, args);
	}

}
