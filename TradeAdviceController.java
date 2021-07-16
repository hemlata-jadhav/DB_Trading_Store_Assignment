package com.tradeAssignment.tradingStore.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class TradeAdviceController extends ResponseEntityExceptionHandler{
   
	 @ExceptionHandler(InvalidTradeException.class)
	 public ResponseEntity<Object> handleInvalidTradeException(InvalidTradeException e) {
	     
		 return new ResponseEntity<>(e, HttpStatus.NOT_ACCEPTABLE);
	    }
}
