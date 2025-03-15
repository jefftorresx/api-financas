package com.financas.pessoais.domain.categoria.repository;

import com.financas.pessoais.domain.categoria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    boolean existsByNome(String nome);
}
