package model;

import java.io.Serializable;

public class ModelQuizz implements Serializable{
	private static final long serialVersionUID = 1L;
	private String pergunta;
	private String resposta;
	
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	
	

}
