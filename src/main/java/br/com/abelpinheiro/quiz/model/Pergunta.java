package br.com.abelpinheiro.quiz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Pergunta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 3, max = 25)
	private String tipoQuiz;

	@NotNull
	@Size(min = 10, max = 200)
	private String pergunta;

	@NotNull
	@Size(min = 3, max = 20)
	private String tipoResposta;

	@NotNull
	@Size(min = 3, max = 30)
	private String opcao1;

	@NotNull
	@Size(max = 30)
	private String opcao2;

	@NotNull
	@Size(max = 30)
	private String opcao3;

	@NotNull
	@Size(max = 30)
	private String opcao4;

	@NotNull
	@Size(min = 1, max = 10)
	private String resposta;

	public Long getId() {
		return id;
	}

	public void setId(Long codigo) {
		this.id = codigo;
	}

	public String getTipoQuiz() {
		return tipoQuiz;
	}

	public void setTipoQuiz(String tipoQuizz) {
		this.tipoQuiz = tipoQuizz;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getTipoResposta() {
		return tipoResposta;
	}

	public void setTipoResposta(String tipoResposta) {
		this.tipoResposta = tipoResposta;
	}

	public String getOpcao1() {
		return opcao1;
	}

	public void setOpcao1(String opcao1) {
		this.opcao1 = opcao1;
	}

	public String getOpcao2() {
		return opcao2;
	}

	public void setOpcao2(String opcao2) {
		this.opcao2 = opcao2;
	}

	public String getOpcao3() {
		return opcao3;
	}

	public void setOpcao3(String opcao3) {
		this.opcao3 = opcao3;
	}

	public String getOpcao4() {
		return opcao4;
	}

	public void setOpcao4(String opcao4) {
		this.opcao4 = opcao4;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((opcao1 == null) ? 0 : opcao1.hashCode());
		result = prime * result + ((opcao2 == null) ? 0 : opcao2.hashCode());
		result = prime * result + ((opcao3 == null) ? 0 : opcao3.hashCode());
		result = prime * result + ((opcao4 == null) ? 0 : opcao4.hashCode());
		result = prime * result + ((pergunta == null) ? 0 : pergunta.hashCode());
		result = prime * result + ((resposta == null) ? 0 : resposta.hashCode());
		result = prime * result + ((tipoQuiz == null) ? 0 : tipoQuiz.hashCode());
		result = prime * result + ((tipoResposta == null) ? 0 : tipoResposta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pergunta other = (Pergunta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (opcao1 == null) {
			if (other.opcao1 != null)
				return false;
		} else if (!opcao1.equals(other.opcao1))
			return false;
		if (opcao2 == null) {
			if (other.opcao2 != null)
				return false;
		} else if (!opcao2.equals(other.opcao2))
			return false;
		if (opcao3 == null) {
			if (other.opcao3 != null)
				return false;
		} else if (!opcao3.equals(other.opcao3))
			return false;
		if (opcao4 == null) {
			if (other.opcao4 != null)
				return false;
		} else if (!opcao4.equals(other.opcao4))
			return false;
		if (pergunta == null) {
			if (other.pergunta != null)
				return false;
		} else if (!pergunta.equals(other.pergunta))
			return false;
		if (resposta == null) {
			if (other.resposta != null)
				return false;
		} else if (!resposta.equals(other.resposta))
			return false;
		if (tipoQuiz == null) {
			if (other.tipoQuiz != null)
				return false;
		} else if (!tipoQuiz.equals(other.tipoQuiz))
			return false;
		if (tipoResposta == null) {
			if (other.tipoResposta != null)
				return false;
		} else if (!tipoResposta.equals(other.tipoResposta))
			return false;
		return true;
	}

}
