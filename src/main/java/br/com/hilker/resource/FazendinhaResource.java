package br.com.hilker.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.hilker.entity.Fazenda;
import br.com.hilker.repository.FazendaRepo;

@RestController
public class FazendinhaResource {
	
	@Autowired
	private FazendaRepo fazendaRepo;
	
	@CrossOrigin
	@ResponseBody
	@Transactional
	@GetMapping(value = "/consulta-fazenda/{numFazenda}", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> consultaFazenda(@PathVariable("numFazenda") Long numFazenda) throws Exception {
		try {
			
			Optional<Fazenda> fazendas = fazendaRepo.findById(numFazenda);
			
			if (fazendas.isPresent()) {
				
				return ResponseEntity.ok().body(fazendas);
				
			} else {
				
				return ResponseEntity.ok().body("");
			}
			
			
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao consultar fazenda");
		
		
			//return ResponseEntity.status(retorno.getStatusHttp()).body(retorno);			
			
		}
				
	}

}
