package com.bootcamp.databases.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.databases.model.Medico;
import com.bootcamp.databases.model.Paciente;
import com.bootcamp.databases.repository.PacienteRepository;
import com.bootcamp.databases.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService {

	@Autowired
	private PacienteRepository repo;
	
	@Override
	public Paciente registrar(Paciente p) throws Exception {
		return repo.save(p);
		
	}

	@Override
	public Paciente modificar(Paciente p, Integer id) throws Exception {
		
		Paciente op = repo.findById(id).orElseThrow(()->new Exception("No encontrado"));
		return repo.save(p);
		
	}

	@Override
	public Paciente buscar(int id) throws Exception {
		Optional<Paciente> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Paciente();
	}

	@Override
	public List<Paciente> listarTodos() throws Exception {
		return repo.findAll();
	}

	@Override
	public Paciente buscarByDni(String dni) {
		
		return repo.findByDni(dni);
	}

}
