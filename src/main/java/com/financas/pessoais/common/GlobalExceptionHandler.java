package com.financas.pessoais.common;

import com.financas.pessoais.exception.CadastroUsuarioException;
import com.financas.pessoais.exception.UsuarioJaExisteException;
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
