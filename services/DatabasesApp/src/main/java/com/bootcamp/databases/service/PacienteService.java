package com.bootcamp.databases.service;

import java.util.List;

import com.bootcamp.databases.model.Paciente;

public interface PacienteService {
	
	public Paciente registrar(Paciente p) throws Exception;
	
	public Paciente modificar(Paciente p,Integer id) throws Exception;
	
	public Paciente buscar(int id) throws Exception;
	
	public List<Paciente> listarTodos() throws Exception;
	
	public Paciente buscarByDni(String dni);

}
