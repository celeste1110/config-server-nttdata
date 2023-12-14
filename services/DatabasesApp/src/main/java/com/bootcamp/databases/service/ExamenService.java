package com.bootcamp.databases.service;

import java.util.List;

import com.bootcamp.databases.model.Examen;

public interface ExamenService {
	
public Examen registrar(Examen m) throws Exception;
	
	public Examen modificar(Examen m,Integer id) throws Exception;
	
	public Examen buscar(int id) throws Exception;
	
	public List<Examen> listarTodos() throws Exception;

}
