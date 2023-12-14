package com.bootcamp.databases.service;

import java.util.List;

import com.bootcamp.databases.model.DetalleConsulta;

public interface DetalleConsultaService {
	
	public  DetalleConsulta registrar( DetalleConsulta m) throws Exception;
	
	public  DetalleConsulta modificar( DetalleConsulta m,Long id) throws Exception;
	
	public  DetalleConsulta buscar(int id) throws Exception;
	
	public List< DetalleConsulta> listarTodos() throws Exception;

}
