package com.financas.pessoais.exception;

public class UsuarioJaExisteException extends RuntimeException {
    public UsuarioJaExisteException(String mensagem) {
        super(mensagem);
    }
}
