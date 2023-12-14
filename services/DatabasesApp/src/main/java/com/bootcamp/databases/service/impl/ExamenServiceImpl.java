package com.bootcamp.databases.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.databases.model.Examen;
import com.bootcamp.databases.repository.ExamenRepository;
import com.bootcamp.databases.service.ExamenService;

@Service
public class ExamenServiceImpl implements ExamenService{
	
	@Autowired
	private ExamenRepository repo;
	
	@Override
	public Examen registrar(Examen p) throws Exception {
		return repo.save(p);
		
	}

	@Override
	public Examen modificar(Examen p,Integer id) throws Exception {
		Examen op = repo.findById(id).orElseThrow(()->new Exception("No encontrado"));
		return repo.save(p);
		
	}

	@Override
	public Examen buscar(int id) throws Exception {
		Optional<Examen> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Examen();
	}

	@Override
	public List<Examen> listarTodos() throws Exception {
		return repo.findAll();
	}


}
