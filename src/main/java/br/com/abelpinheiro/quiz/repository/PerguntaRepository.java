package br.com.abelpinheiro.quiz.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.abelpinheiro.quiz.model.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {

	Page<Pergunta> findByTipoQuiz(String tipoQuiz, Pageable pageable);
}
