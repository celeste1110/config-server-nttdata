package com.bootcamp.databases.service;

import java.util.List;

import com.bootcamp.databases.model.Medico;

public interface MedicoService {
	
	public Medico registrar(Medico m) throws Exception;
	
	public Medico modificar(Medico m,Integer id) throws Exception;
	
	public Medico buscar(int id) throws Exception;
	
	public List<Medico> listarTodos() throws Exception;

}
