package br.com.hilker.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	//@Autowired
	//private ThreadInicializaServico threadInicializaServico;
	
	//@Override
	//public void run(ApplicationArguments args) throws Exception {
	//	threadInicializaServico.start();
	//}

}

