package com.orquestrador.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orquestrador.condominio.entity.TelefoneEntity;

public interface TelefoneRepository extends JpaRepository<TelefoneEntity, Long> {

}
