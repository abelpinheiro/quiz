package br.com.abelpinheiro.quiz.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.abelpinheiro.quiz.controller.dto.PerguntaDto;
import br.com.abelpinheiro.quiz.model.Pergunta;

@RestController
public class PerguntaController {

	@RequestMapping("/perguntas")
	public List<PerguntaDto> lista(){
		Pergunta pergunta = new Pergunta("", "", "", "", "", "", "", "");
		return PerguntaDto.converter(Arrays.asList(pergunta));
	}
}
