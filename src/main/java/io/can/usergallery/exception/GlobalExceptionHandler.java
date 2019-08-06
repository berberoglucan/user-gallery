package io.can.usergallery.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidPageRequstParameterException.class)
	public ResponseEntity<ErrorResponse> handleCustomException(InvalidPageRequstParameterException exc) {
		ErrorResponse errorResponse = new ErrorResponse(exc.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("UTC")));
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(IllegalFilterOption.class)
	public ResponseEntity<ErrorResponse> handleCustomException(IllegalFilterOption exc) {
		ErrorResponse errorResponse = new ErrorResponse(exc.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("UTC")));
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);	
	}
	
}
