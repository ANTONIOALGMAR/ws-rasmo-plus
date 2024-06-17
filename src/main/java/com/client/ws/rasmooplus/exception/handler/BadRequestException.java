package com.client.ws.rasmooplus.exception.handler;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message){
        super(message);
    }
}
