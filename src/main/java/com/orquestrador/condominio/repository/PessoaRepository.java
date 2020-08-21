package com.orquestrador.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orquestrador.condominio.entity.PessoaEntity;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {

}
