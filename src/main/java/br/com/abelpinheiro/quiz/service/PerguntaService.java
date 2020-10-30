package br.com.abelpinheiro.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.abelpinheiro.quiz.model.Pergunta;
import br.com.abelpinheiro.quiz.repository.PerguntaRepository;

@Service
public class PerguntaService {

	@Autowired
	private PerguntaRepository perguntaRepository;

	public Pergunta criarPergunta(Pergunta pergunta) {
		Pergunta perguntaSalva = perguntaRepository.save(pergunta);
		return perguntaSalva;
	}

	public void removerPergunta(Long codigo) {
		perguntaRepository.deleteById(codigo);

	}

}
