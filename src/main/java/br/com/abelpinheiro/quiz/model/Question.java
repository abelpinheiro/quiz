package br.com.abelpinheiro.quiz.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String quizType;

	@NotNull
	@Size(min = 10, max = 200)
	private String question;

	@Enumerated(EnumType.STRING)
	private AnswerTypeEnum answerType;

	@NotNull
	@Size(min = 1)
	private String[] choices;

	@NotNull
	@Size(min = 1)
	private int[] answers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuizType() {
		return quizType;
	}

	public void setQuizType(String quizType) {
		this.quizType = quizType;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public AnswerTypeEnum getAnswerType() {
		return answerType;
	}

	public void setAnswerType(AnswerTypeEnum answerType) {
		this.answerType = answerType;
	}

	public String[] getChoices() {
		return choices;
	}

	public void setChoices(String[] choices) {
		this.choices = choices;
	}

	public int[] getAnswers() {
		return answers;
	}

	public void setAnswers(int[] answers) {
		this.answers = answers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answerType == null) ? 0 : answerType.hashCode());
		result = prime * result + Arrays.hashCode(answers);
		result = prime * result + Arrays.hashCode(choices);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((quizType == null) ? 0 : quizType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (answerType != other.answerType)
			return false;
		if (!Arrays.equals(answers, other.answers))
			return false;
		if (!Arrays.equals(choices, other.choices))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (quizType == null) {
			if (other.quizType != null)
				return false;
		} else if (!quizType.equals(other.quizType))
			return false;
		return true;
	}

}
