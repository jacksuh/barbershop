package com.jackson.schedule.barbershop.exception;

public class ValidationException  extends RuntimeException{

    public ValidationException(String mensagem) {
        super(mensagem);
    }
}
