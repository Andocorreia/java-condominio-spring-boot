package com.orquestrador.condominio.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orquestrador.condominio.entity.PessoaEntity;
import com.orquestrador.condominio.entity.TelefoneEntity;

public interface TelefoneRepository extends JpaRepository<TelefoneEntity, Long> {

	Optional<Collection<TelefoneEntity>> findByPessoaId(PessoaEntity pessoaId);

}
