package br.com.abelpinheiro.quiz.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.abelpinheiro.quiz.model.Question;
import br.com.abelpinheiro.quiz.service.QuestionService;

@RestController
@RequestMapping("/perguntas")
public class PerguntaController {

	@Autowired
	private QuestionService questionService;

	@GetMapping
	public Page<Question> getQuestions(@RequestParam(required = false) String quizType,
			@RequestParam(required = false) String page, @RequestParam(required = false) String size,
			@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable pageable) {
		return questionService.listarPerguntas(quizType, pageable);
	}

	@PostMapping
	public ResponseEntity<Question> createQuestion(@Valid @RequestBody Question question) {
		return ResponseEntity.status(HttpStatus.CREATED).body(questionService.createQuestion(question));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteQuestion(@PathVariable Long id) {
		questionService.deleteQuestion(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @Valid @RequestBody Question question) {
		ResponseEntity<Question> responseQuestion = questionService.updateQuestion(id, question);
		return responseQuestion;
	}
}
