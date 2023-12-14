package com.bootcamp.databases.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.databases.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer>{

}
