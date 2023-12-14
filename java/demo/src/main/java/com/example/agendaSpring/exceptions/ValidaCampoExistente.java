package com.example.agendaSpring.exceptions;

public class ValidaCampoExistente extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ValidaCampoExistente(String msg) {
        super(msg);
    }
}
