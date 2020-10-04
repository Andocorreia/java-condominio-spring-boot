package com.condominio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.condominio.backend.entity.PessoaEntity;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {

}
