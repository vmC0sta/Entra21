package com.example.agendaSpring.exceptions;

public class ValidaCampos extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ValidaCampos(String msg) {
        super(msg);
    }

}
