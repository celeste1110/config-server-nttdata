package com.bootcamp.databases.service;

import java.util.List;

import com.bootcamp.databases.model.Especialidad;


public interface EspecialidadService {
	
	public Especialidad registrar(Especialidad m) throws Exception;
	
	public Especialidad modificar(Especialidad m,Integer id) throws Exception;
	
	public Especialidad buscar(int id) throws Exception;
	
	public List<Especialidad> listarTodos() throws Exception;

}
