package com.bootcamp.databases.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.databases.model.Examen;

public interface ExamenRepository extends JpaRepository<Examen, Integer>{

}
