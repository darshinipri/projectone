package com.onebil.fms.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onebil.fms.dto.ResponseDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler()
	
	ResponseDTO handler(Exception e) {
		ResponseDTO response = new ResponseDTO();
		response.setError(true);
		response.setResponse(e.getMessage());
		return response;
	}

}
