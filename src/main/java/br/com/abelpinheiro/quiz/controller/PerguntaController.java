package br.com.abelpinheiro.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.abelpinheiro.quiz.controller.dto.PerguntaDto;
import br.com.abelpinheiro.quiz.model.Pergunta;
import br.com.abelpinheiro.quiz.repository.PerguntaRepository;

@RestController
@RequestMapping("/perguntas")
public class PerguntaController {

	@Autowired
	private PerguntaRepository perguntaRepository;

	@GetMapping
	public List<PerguntaDto> lista() {
		List<Pergunta> perguntas = perguntaRepository.findAll();
		return PerguntaDto.converter(perguntas);
	}
}
