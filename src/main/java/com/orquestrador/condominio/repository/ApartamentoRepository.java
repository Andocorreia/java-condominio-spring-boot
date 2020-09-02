package com.orquestrador.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orquestrador.condominio.entity.ApartamentoEntity;

public interface ApartamentoRepository extends JpaRepository<ApartamentoEntity, Long> {

}
