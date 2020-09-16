package com.orquestrador.condominio.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orquestrador.condominio.entity.EnderecoEntity;
import com.orquestrador.condominio.entity.PessoaEntity;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {
	Optional<Collection<EnderecoEntity>> findByPessoaId(PessoaEntity pessoaId);
}
