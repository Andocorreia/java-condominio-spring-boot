package com.condominio.backend.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.condominio.backend.entity.EnderecoEntity;
import com.condominio.backend.entity.PessoaEntity;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {
	Optional<Collection<EnderecoEntity>> findByPessoaId(PessoaEntity pessoaId);
}
