package com.bootcamp.databases.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.bootcamp.databases.model.ConsultaExamen;

public interface ConsultaExamenRepository extends MongoRepository<ConsultaExamen, Integer>{

	@Query("{'idConsulta':?0 , 'idExamen':?1}")
	public List<ConsultaExamen> finfConsultaExamenaByConsultaAndExamenes(Integer idConsulta,Integer idExamen);
	
	@Query("{'idConsulta':?0")
	public List<ConsultaExamen> finfConsultaExamenaByConsult(Integer idConsulta);
}
