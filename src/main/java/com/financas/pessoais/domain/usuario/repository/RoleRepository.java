package com.financas.pessoais.domain.usuario.repository;

import com.financas.pessoais.domain.usuario.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
