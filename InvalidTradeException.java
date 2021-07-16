package com.tradeAssignment.tradingStore.exception;

public class InvalidTradeException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    
    public InvalidTradeException() {

        super(String.format("Invalid Trade : "));
    }
    
}
