package com.bootcamp.databases.service;

import java.util.List;

import com.bootcamp.databases.model.Consulta;

public interface ConsultaService {
	
	public Consulta registrar(Consulta m) throws Exception;
	
	public Consulta modificar(Consulta m,Integer id) throws Exception;
	
	public Consulta buscar(int id) throws Exception;
	
	public List<Consulta> listarTodos() throws Exception;

}
