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

import com.bootcamp.databases.model.Especialidad;
import com.bootcamp.databases.service.EspecialidadService;

@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {
	
private static final Logger logger = Logger.getLogger(EspecialidadController.class);
	
	@Autowired
	private EspecialidadService service;
	
	@PostMapping("/nuevo")
	public ResponseEntity<Especialidad> registrar(@RequestBody Especialidad m) {
		logger.info("Registrar nueva especialidad");
		try {
			Especialidad especialidad= service.registrar(m);
			
			return new ResponseEntity<>(especialidad,HttpStatus.CREATED);

		} catch (Exception e) {
			logger.error("No se pudo registrar la especialidad");
			logger.debug(e);
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Especialidad> actualizar(@RequestBody Especialidad m,@PathVariable Integer id) throws Exception {
		Especialidad especialidad=service.modificar(m,id);
		return ResponseEntity.ok(especialidad);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Especialidad> buscar(@PathVariable("id") int id) throws Exception {
		return ResponseEntity.ok(service.buscar(id));
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Especialidad>> listar() throws Exception {
		return ResponseEntity.ok(service.listarTodos());
	}

}
