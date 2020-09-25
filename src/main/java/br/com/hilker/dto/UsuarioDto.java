package br.com.hilker.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "usuario")
public class UsuarioDto {
	
	//@XmlElement(name = "cliente")
	//private ClienteDto cliente;
	
	//@XmlElementWrapper(name = "pedidos")
	//@XmlElement(name = "pedido")
	//private List<PedidoDto> pedidos;
	
	private String email;
	
	private String senha;

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "UsuarioDto [email=" + email + ", senha=" + senha + "]";
	}
	
}
