package io.can.usergallery.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidPageRequestParameterException.class)
	public ResponseEntity<ErrorResponse> handleCustomException(InvalidPageRequestParameterException exc) {
		ErrorResponse errorResponse = new ErrorResponse(exc.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("UTC")));
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(IllegalFilterOption.class)
	public ResponseEntity<ErrorResponse> handleCustomException(IllegalFilterOption exc) {
		ErrorResponse errorResponse = new ErrorResponse(exc.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("UTC")));
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(InvalidIdParameterException.class)
	public ResponseEntity<ErrorResponse> handleCustomException(InvalidIdParameterException exc) {
		ErrorResponse errorResponse = new ErrorResponse(exc.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("UTC")));
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCustomException(UserNotFoundException exc) {
		ErrorResponse errorResponse = new ErrorResponse(exc.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now(ZoneId.of("UTC")));
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleAllException(Exception exc) {
		ErrorResponse errorResponse = new ErrorResponse(exc.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, ZonedDateTime.now(ZoneId.of("UTC")));
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	
}
