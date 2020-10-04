package com.condominio.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.condominio.backend.core.enums.PerfilUsuario;
import com.condominio.backend.entity.PerfilEntity;

public interface PerfilRepository extends JpaRepository<PerfilEntity, Long> {

	Optional<PerfilEntity> findByNome(PerfilUsuario nome);

}
