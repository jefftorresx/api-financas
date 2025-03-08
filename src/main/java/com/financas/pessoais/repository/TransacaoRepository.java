package com.financas.pessoais.repository;

import com.financas.pessoais.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    public Transacao findById(long id);
}
