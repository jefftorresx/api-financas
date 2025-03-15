package com.financas.pessoais.domain.usuario.repository;

import com.financas.pessoais.domain.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    Boolean existsByEmail(String email);
}
