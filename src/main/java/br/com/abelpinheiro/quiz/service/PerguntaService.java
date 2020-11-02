package br.com.abelpinheiro.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.abelpinheiro.quiz.model.Pergunta;
import br.com.abelpinheiro.quiz.repository.PerguntaRepository;

@Service
public class PerguntaService {

	@Autowired
	private PerguntaRepository perguntaRepository;

	public Page<Pergunta> listarPerguntas(String tipoQuiz, Pageable pageable) {
		if (tipoQuiz == null) {
			return perguntaRepository.findAll(pageable);
		} else {
			return perguntaRepository.findByTipoQuiz(tipoQuiz, pageable);
		}
	}

	public Pergunta criarPergunta(Pergunta pergunta) {
		Pergunta perguntaSalva = perguntaRepository.save(pergunta);
		return perguntaSalva;
	}

	public void removerPergunta(Long codigo) {
		perguntaRepository.deleteById(codigo);

	}

}
