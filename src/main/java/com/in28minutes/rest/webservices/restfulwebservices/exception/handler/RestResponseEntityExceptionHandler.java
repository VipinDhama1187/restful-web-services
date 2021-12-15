package com.in28minutes.rest.webservices.restfulwebservices.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.in28minutes.rest.webservices.restfulwebservices.dto.BaseResponse;
import com.in28minutes.rest.webservices.restfulwebservices.exception.UserAlreadyExistsException;
import com.in28minutes.rest.webservices.restfulwebservices.exception.UserNotFoundException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(value 
		      = { Exception.class })
		    protected ResponseEntity<Object> handleAllException(
		      RuntimeException ex, WebRequest request ){
		        BaseResponse<String> bodyOfResponse = new BaseResponse<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		        return handleExceptionInternal(ex, bodyOfResponse, 
		                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
		    }
	
	@ExceptionHandler(value 
		      = { UserNotFoundException.class })
		    protected ResponseEntity<Object> handleUserNotFoundException(
		      RuntimeException ex, WebRequest request ){
		        BaseResponse<String> bodyOfResponse = new BaseResponse<String>(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		        return handleExceptionInternal(ex, bodyOfResponse, 
		                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
		    }
	
	@ExceptionHandler(value 
		      = { UserAlreadyExistsException.class })
		    protected ResponseEntity<Object> handleUserAlreadyExistsException(
		      RuntimeException ex, WebRequest request ){
		        BaseResponse<String> bodyOfResponse = new BaseResponse<String>(ex.getMessage(), HttpStatus.CONFLICT.value());
		        return handleExceptionInternal(ex, bodyOfResponse, 
		                new HttpHeaders(), HttpStatus.OK, request);
		    }
	
}
