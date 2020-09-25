package br.com.hilker.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="MensagemRetorno")
public class MensagemRetorno {

	private Integer statusHttp;
	
	private String mensagem;

	public Integer getStatusHttp() {
		return statusHttp;
	}

	public void setStatusHttp(Integer statusHttp) {
		this.statusHttp = statusHttp;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	@Override
	public String toString() {
		return "MensagemRetorno [statusHttp=" + statusHttp + ", mensagem="
				+ mensagem + "]";
	}
}
	
