package com.financas.pessoais.DTO;

public class UsuarioRespondeDTO {
    private String nome;
    private String email;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public UsuarioRespondeDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}
