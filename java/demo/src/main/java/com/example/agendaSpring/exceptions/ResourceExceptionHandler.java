package com.example.agendaSpring.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ValidaCampos.class)
    public ResponseEntity<StandardError> validaDadosException(ValidaCampos e, HttpServletRequest req) {
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setError("Campo inválido");
        err.setMessage(e.getMessage());
        err.setPath(req.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(RecursoNaoEncontrado.class)
    public ResponseEntity<StandardError> RecursoNaoEncontradoException(RecursoNaoEncontrado e, HttpServletRequest req) {
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setError("Campo inválido");
        err.setMessage(e.getMessage());
        err.setPath(req.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
    @ExceptionHandler(ValidaCampoExistente.class)
    public ResponseEntity<StandardError> validaDadosException(ValidaCampoExistente e, HttpServletRequest req) {
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setError("Campo inválido");
        err.setMessage(e.getMessage());
        err.setPath(req.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}