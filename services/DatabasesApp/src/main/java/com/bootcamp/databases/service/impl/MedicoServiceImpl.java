package com.bootcamp.databases.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.databases.model.Medico;
import com.bootcamp.databases.repository.MedicoRepository;
import com.bootcamp.databases.service.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService {

	@Autowired
	private MedicoRepository repo;
	
	@Override
	public Medico registrar(Medico m) throws Exception {
		
		return repo.save(m);
		
	}

	@Override
	public Medico  modificar(Medico m,Integer id) throws Exception {
		Medico op = repo.findById(id).orElseThrow(()->new Exception("No encontrado"));
		
		return repo.save(m);
		
	}

	@Override
	public Medico buscar(int id) throws Exception {
		Optional<Medico> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Medico();
	}

	@Override
	public List<Medico> listarTodos() throws Exception {
		return repo.findAll();
	}

}
