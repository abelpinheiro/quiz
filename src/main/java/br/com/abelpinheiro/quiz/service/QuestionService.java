package br.com.abelpinheiro.quiz.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.abelpinheiro.quiz.model.Question;
import br.com.abelpinheiro.quiz.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	public Page<Question> listarPerguntas(String tipoQuiz, Pageable pageable) {
		if (tipoQuiz == null) {
			return questionRepository.findAll(pageable);
		} else {
			return questionRepository.findByQuizType(tipoQuiz, pageable);
		}
	}

	public void randomQuestion() {
		Long qtd = questionRepository.count();
	}

	public Question createQuestion(Question pergunta) {
		Question perguntaSalva = questionRepository.save(pergunta);
		return perguntaSalva;
	}

	public void deleteQuestion(Long codigo) {
		questionRepository.deleteById(codigo);

	}

	public ResponseEntity<Question> updateQuestion(Long id, @Valid Question question) {
		Optional<Question> questionOptional = questionRepository.findById(id);

		if (!questionOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		question.setId(id);
		questionRepository.save(question);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
