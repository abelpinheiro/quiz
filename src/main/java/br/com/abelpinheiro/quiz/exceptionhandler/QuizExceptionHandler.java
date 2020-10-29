package br.com.abelpinheiro.quiz.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class QuizExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(value = { EmptyResultDataAccessException.class })
	public ResponseEntity<Object> EmptyResultDataAccessException(EmptyResultDataAccessException ex,
			WebRequest request) {

		String messageUser = messageSource.getMessage("recurso.nao-encontrado", null, LocaleContextHolder.getLocale());
		String messageDeveloper = ex.toString();

		List<Erro> erros = Arrays.asList(new Erro(messageUser, messageDeveloper));

		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	private List<Erro> createErrorList(BindingResult bindingResult) {
		List<Erro> erros = new ArrayList<>();

		for (FieldError fieldErro : bindingResult.getFieldErrors()) {
			System.out.println("AINDA N TA FEITO");
		}
		return erros;
	}

	public static class Erro {

		private String messageUser;
		private String messageDeveloper;

		public Erro(String messageUser, String messageDeveloper) {
			this.messageUser = messageUser;
			this.messageDeveloper = messageDeveloper;
		}

		public String getMessageUser() {
			return messageUser;
		}

		public String getMessageDeveloper() {
			return messageDeveloper;
		}

	}
}
