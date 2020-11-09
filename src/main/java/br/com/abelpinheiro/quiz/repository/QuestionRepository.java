package br.com.abelpinheiro.quiz.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.abelpinheiro.quiz.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	Page<Question> findByQuizType(String quizType, Pageable pageable);
}
