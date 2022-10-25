package com.ecomerce.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ecomerce.exception.ResourceBadRequestException;
import com.ecomerce.exception.ResourceNotFoundException;
import com.ecomerce.model.error.MensagemError;
import com.ecomerce.utils.ConversorDeData;

public class ResteExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<MensagemError> handlerResourceNotFoundException(ResourceNotFoundException ex){
		
		String dataHora = ConversorDeData.converterDateParaDataEHora(new Date());
		
		// Constroi o objeto de erro com base na exception.
		MensagemError erro =  new MensagemError(dataHora, 404, "Not Found", ex.getMessage());
		
		// Aqui eu estou devolvendo o objeto de erro montado com o status especifico que desejo, neste caso é o not found 404
		return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ResourceBadRequestException.class)
	public ResponseEntity<MensagemError> handlerBadRequestException(ResourceBadRequestException ex){
		
		String dataHora  = ConversorDeData.converterDateParaDataEHora(new Date());
		MensagemError erro =  new MensagemError(dataHora, 400, "Bad Request", ex.getMessage());
				
		return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
	}
	
	// Tratamento geral maroto que estamos fazendo para qualquer excption não tratada.
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MensagemError> handlerBadRequestException(Exception ex){
		String dataHora  = ConversorDeData.converterDateParaDataEHora(new Date());
		MensagemError erro =  new MensagemError(dataHora, 500, "Internal Server Error", ex.getMessage());
				
		return new ResponseEntity<>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
