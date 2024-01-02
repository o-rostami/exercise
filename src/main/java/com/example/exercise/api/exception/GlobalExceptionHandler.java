package com.example.exercise.api.exception;

import com.example.exercise.api.response.CustomErrorResponse;
import com.example.exercise.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest request) {
		log.error("unexpected error ", ex);
		return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public final ResponseEntity<Object> handleGeneralException(ProductNotFoundException ex, WebRequest request) {
		log.error("product not found exception occurred with request {} and response ", request, ex);
		return buildResponseEntity(new CustomErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), ex, ex.getErrorCode()));
	}

	private ResponseEntity<Object> buildResponseEntity(CustomErrorResponse response) {
		return new ResponseEntity<>(response, response.getStatus());
	}

}
