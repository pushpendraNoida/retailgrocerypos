package com.retailgrocery.pos.billing.exception;

/**
 * 
 * @author PS
 *
 */
public class TransactionalException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private final String transactionStatus;
	private final String message;

    public TransactionalException(String message, String transactionStatus) {
        this.transactionStatus = transactionStatus;
        this.message = message;
    }

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public String getMessge() {
		return message;
	}

}
