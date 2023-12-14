package com.bootcamp.databases.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.databases.model.Especialidad;
import com.bootcamp.databases.repository.EspecialidadRepository;
import com.bootcamp.databases.service.EspecialidadService;

@Service
public class EspecialidadServiceImpl implements EspecialidadService{
	
	@Autowired
	private EspecialidadRepository repo;
	
	@Override
	public Especialidad registrar(Especialidad p) throws Exception {
		return repo.save(p);
		
	}

	@Override
	public Especialidad modificar(Especialidad p,Integer id) throws Exception {
		Especialidad op = repo.findById(id).orElseThrow(()->new Exception("No encontrado"));
		return repo.save(p);
		
	}

	@Override
	public Especialidad buscar(int id) throws Exception {
		Optional<Especialidad> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Especialidad();
	}

	@Override
	public List<Especialidad> listarTodos() throws Exception {
		return repo.findAll();
	}
}
