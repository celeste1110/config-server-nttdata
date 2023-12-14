package com.bootcamp.databases.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.bootcamp.databases.model.DetalleConsulta;

public interface DetalleConsultaRepository extends MongoRepository<DetalleConsulta, Integer>{
	
	@Query("{'consultaId':?0}")
	public List<DetalleConsulta> finfDetalleConsultaByConsulta(Integer id);
	

}
