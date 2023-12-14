package com.bootcamp.databases.service;

import java.util.List;

import com.bootcamp.databases.model.ConsultaExamen;


public interface ConsultaExamenService {

	public  ConsultaExamen registrar( ConsultaExamen m) throws Exception;
	
	public  ConsultaExamen modificar(ConsultaExamen m,Integer id) throws Exception;
	
	public  ConsultaExamen buscar(int id) throws Exception;
	
	public List< ConsultaExamen> listarTodos() throws Exception;
}
