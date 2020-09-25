package br.com.hilker.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.hilker.dto.MensagemRetorno;
import br.com.hilker.dto.UsuarioDto;
import br.com.hilker.entity.Usuario;
import br.com.hilker.repository.UsuarioRepo;
import br.com.hilker.util.UtilLog;

@RestController
//@RequestMapping("/api")
public class UsuarioResource {
	
	@Autowired
	private UsuarioRepo usuarioRepo;
	
	@CrossOrigin
	@ResponseBody
	@PostMapping(value = "/valida-usuario", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> validaUsuario(@RequestBody UsuarioDto usuarioDto) throws Exception {

		try {
			
			UtilLog.getLog().info("Iniciou o endpoint");
						
			Optional<Usuario> usuario = usuarioRepo.consultarPorParametros(usuarioDto.getEmail(), usuarioDto.getSenha());
			
			if (usuario.isPresent()) {
				
				return ResponseEntity.ok().build();
				
			} else {
				
				Optional<Usuario> usuarioEmail = usuarioRepo.consultarPorEmail(usuarioDto.getEmail());
				
				
				
				if (usuarioEmail.isPresent()) {
					
					MensagemRetorno mensagemRetorno = new MensagemRetorno();
					mensagemRetorno.setStatusHttp(HttpStatus.FORBIDDEN.value());
					mensagemRetorno.setMensagem("Senha incorreta.");
					return ResponseEntity.status(HttpStatus.FORBIDDEN).body(mensagemRetorno);

				} else {
					
					MensagemRetorno mensagemRetorno = new MensagemRetorno();
					mensagemRetorno.setStatusHttp(HttpStatus.FORBIDDEN.value());
					mensagemRetorno.setMensagem("Usuário não cadastrado.");
					return ResponseEntity.status(HttpStatus.FORBIDDEN).body(mensagemRetorno);
				}

			}
			
			
		} catch (Exception e) {
						
			return ResponseEntity.badRequest().build();
			
		}
	}

}
