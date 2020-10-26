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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

	@PostMapping
	public ResponseEntity<Pergunta> criar(@Valid @RequestBody Pergunta pergunta) {
		Pergunta perguntaSalva = perguntaRepository.save(pergunta);
		return ResponseEntity.status(HttpStatus.CREATED).body(perguntaSalva);
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		perguntaRepository.deleteById(codigo);
	}
}
