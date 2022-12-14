package com.barclays.trade.confirmationlayer.exception;

public class MessageValidationException extends RuntimeException{

    private static final Long serialVersionUid = 1L;
    public MessageValidationException(String message){
        super(message);
    }
}
