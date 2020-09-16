package com.orquestrador.condominio.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orquestrador.condominio.entity.ApartamentoPessoaEntity;

public interface ApartamentoPessoaRepository extends JpaRepository<ApartamentoPessoaEntity, Long> {

	Optional<Collection<ApartamentoPessoaEntity>> findByPessoaId(Long pessoaId);

}
