package br.com.abelpinheiro.quiz.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.abelpinheiro.quiz.model.Pergunta;

public class PerguntaDto {

	private String tipoQuiz;
	private String pergunta;
	private String tipoResposta;
	private String opcao1;
	private String opcao2;
	private String opcao3;
	private String opcao4;
	private String resposta;

	public PerguntaDto(Pergunta pergunta) {
		this.tipoQuiz = pergunta.getTipoQuiz();
		this.pergunta = pergunta.getPergunta();
		this.tipoResposta = pergunta.getTipoResposta();
		this.opcao1 = pergunta.getOpcao1();
		this.opcao2 = pergunta.getOpcao2();
		this.opcao3 = pergunta.getOpcao3();
		this.opcao4 = pergunta.getOpcao4();
		this.resposta = pergunta.getResposta();
	}

	public String getTipoQuizz() {
		return tipoQuiz;
	}

	public String getPergunta() {
		return pergunta;
	}

	public String getTipoResposta() {
		return tipoResposta;
	}

	public String getOpcao1() {
		return opcao1;
	}

	public String getOpcao2() {
		return opcao2;
	}

	public String getOpcao3() {
		return opcao3;
	}

	public String getOpcao4() {
		return opcao4;
	}

	public String getResposta() {
		return resposta;
	}

	public static List<PerguntaDto> converter(List<Pergunta> pergunta) {
		return pergunta.stream().map(PerguntaDto::new).collect(Collectors.toList());
	}

}
