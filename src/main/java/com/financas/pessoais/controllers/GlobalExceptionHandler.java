package com.financas.pessoais.controllers;

import com.financas.pessoais.excecoes.CadastroUsuarioException;
import com.financas.pessoais.excecoes.ExceptionResponse;
import com.financas.pessoais.excecoes.UsuarioJaExisteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(CadastroUsuarioException.class)
    public ResponseEntity<ExceptionResponse> handleCadastroUsuarioException(CadastroUsuarioException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(exceptionResponse.getStatus()).body(exceptionResponse);
    }


    @ExceptionHandler(UsuarioJaExisteException.class)
    public ResponseEntity<ExceptionResponse> handleUsuarioJaExisteException(UsuarioJaExisteException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(exceptionResponse.getStatus()).body(exceptionResponse);
    }
}
