package com.bootcamp.databases.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.databases.model.Medico;
import com.bootcamp.databases.service.MedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	private static final Logger logger = Logger.getLogger(MedicoController.class);
	
	@Autowired
	private MedicoService service;
	
	@PostMapping("/nuevo")
	public ResponseEntity<Medico> registrar(@RequestBody Medico m) {
		logger.info("Registrar nuevo médico");
		try {
			Medico medico= service.registrar(m);
			return new ResponseEntity<>(medico,HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("No se pudo registrar el médico");
			logger.debug(e);
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Medico> actualizar(@RequestBody Medico m,@PathVariable Integer id) throws Exception {
		Medico medico=service.modificar(m,id);
		return ResponseEntity.ok(medico);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Medico> buscar(@PathVariable("id") int id) throws Exception {
		return ResponseEntity.ok(service.buscar(id));
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Medico>> listar() throws Exception {
		return ResponseEntity.ok(service.listarTodos());
	}

}
