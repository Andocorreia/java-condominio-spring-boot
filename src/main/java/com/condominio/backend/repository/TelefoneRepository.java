package com.condominio.backend.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.condominio.backend.entity.PessoaEntity;
import com.condominio.backend.entity.TelefoneEntity;

public interface TelefoneRepository extends JpaRepository<TelefoneEntity, Long> {

	Optional<Collection<TelefoneEntity>> findByPessoaId(PessoaEntity pessoaId);

}
