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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.databases.model.Paciente;
import com.bootcamp.databases.model.dto.FilterPaciente;
import com.bootcamp.databases.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	

	private static final Logger logger = Logger.getLogger(PacienteController.class);
	
	@Autowired
	private PacienteService service;
	
	@PostMapping("/nuevo")
	public ResponseEntity<Paciente> registrar(@RequestBody Paciente p) {
		logger.info("Registrar nuevo paciente");
		try {
			Paciente paciente= service.registrar(p);
			return new ResponseEntity<>(paciente,HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("No se pudo registrar al paciente");
			logger.debug(e);
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Paciente> actualizar(@RequestBody Paciente p,@PathVariable Integer id) throws Exception {
		Paciente paciente=service.modificar(p,id);
		return ResponseEntity.ok(paciente);
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Paciente> buscar(@RequestParam("id") int id) throws Exception {
		return ResponseEntity.ok(service.buscar(id));
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Paciente>> listar() throws Exception {
		return ResponseEntity.ok(service.listarTodos());
	}
	
	@PostMapping("/filter")
	public ResponseEntity<Paciente> filter(@RequestBody FilterPaciente request) throws Exception {
		
		return ResponseEntity.ok(service.buscarByDni(request.getDni()));
	}


}
