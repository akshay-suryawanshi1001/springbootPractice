package com.akshay.SpringbootPractice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(DepartmentNotFoundException.class)              //mention which type of exception we are handling
	public ResponseEntity<ErrorResponse> departmentNotFoundException(DepartmentNotFoundException exception, WebRequest request) {
		//we have request here in case we need to fetch any data from request in future
		ErrorResponse responseMessage = new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(responseMessage);
	}
}
