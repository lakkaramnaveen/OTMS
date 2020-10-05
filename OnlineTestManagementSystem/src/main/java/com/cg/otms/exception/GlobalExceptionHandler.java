package com.cg.otms.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



@ControllerAdvice //this exception class will be shared across all the controllers 
public class GlobalExceptionHandler {

	@ExceptionHandler(OtmsException.class)
	public @ResponseBody ResponseEntity<ErrorInfo>  handleException(OtmsException ex,HttpServletRequest req)
	{

		String message=ex.getMessage();
		String uri= req.getRequestURI();

		ErrorInfo  obj = new ErrorInfo(LocalDateTime.now(),message,uri);
		return new ResponseEntity<>(obj,HttpStatus.NOT_FOUND);
	}


	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handle(Exception ex, 
			HttpServletRequest request, HttpServletResponse response) {
		if (ex instanceof NullPointerException) {
			String uri= request.getRequestURI();
			String message = "Bad request!! Check uri once";
			ErrorInfo  obj = new ErrorInfo(LocalDateTime.now(),message,uri);
			return new ResponseEntity<>(obj,HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}


}
