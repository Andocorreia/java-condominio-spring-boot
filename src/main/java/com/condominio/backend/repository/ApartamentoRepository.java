package com.condominio.backend.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.condominio.backend.entity.ApartamentoEntity;

public interface ApartamentoRepository extends JpaRepository<ApartamentoEntity, Long> {

	Optional<Collection<ApartamentoEntity>> findByIdIn(Collection<Long> id);

}
