package br.com.hilker.resource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FazendinhaResource {
	
	//@CrossOrigin
	@ResponseBody
	@Transactional
	@GetMapping(value = "/consulta-fazenda/{numFazenda}", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> consultaFazenda(@PathVariable("numFazenda") String numFazenda) throws Exception {
		try {
			
			//pedidoAgrupamentoDto = pagamentoBoletoService.gerarBoleto(pedidoAgrupamentoDto);
			
			return ResponseEntity.ok().body("");
			
		} catch (Exception e) {
		
		
			//return ResponseEntity.status(retorno.getStatusHttp()).body(retorno);			
			
		}
		
		
		return null;
		
	}

}
