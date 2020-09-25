package com.orquestrador.condominio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orquestrador.condominio.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
	Optional<UsuarioEntity> findByUsuario(String usuario);

}
