package br.com.abelpinheiro.quiz.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.abelpinheiro.quiz.controller.dto.PerguntaDto;
import br.com.abelpinheiro.quiz.model.Pergunta;
import br.com.abelpinheiro.quiz.repository.PerguntaRepository;
import br.com.abelpinheiro.quiz.service.PerguntaService;

@RestController
@RequestMapping("/perguntas")
public class PerguntaController {

	@Autowired
	private PerguntaRepository perguntaRepository;

	@Autowired
	private PerguntaService perguntaService;

	@GetMapping
	public List<PerguntaDto> listarPerguntas() {
		List<Pergunta> perguntas = perguntaRepository.findAll();
		return PerguntaDto.converter(perguntas);
	}

	@PostMapping
	public ResponseEntity<Pergunta> criarPergunta(@Valid @RequestBody Pergunta pergunta) {
		return ResponseEntity.status(HttpStatus.CREATED).body(perguntaService.criarPergunta(pergunta));
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerPergunta(@PathVariable Long codigo) {
		perguntaService.removerPergunta(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Pergunta> atualizarPergunta(@PathVariable Long codigo,
			@Valid @RequestBody Pergunta pergunta) {
		return null;
	}
}
