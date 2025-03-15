package com.financas.pessoais.enums;

public enum ValoresRole {
    BASICO(2L),
    ADMIN(1L);

    Long id;
     ValoresRole(Long n){
        id = n;
    }

    public Long getId() {
        return id;
    }
}
