package com.epicbe.gestioneenergia.auth.exception;

import org.springframework.http.HttpStatus;

public class MyAPIException extends RuntimeException {
	
	private HttpStatus status;
    private String message;
    
    public MyAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public MyAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }
    
    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
