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

import com.bootcamp.databases.model.Examen;
import com.bootcamp.databases.service.ExamenService;


@RestController
@RequestMapping("/examen")
public class ExamenController {
	
private static final Logger logger = Logger.getLogger(ExamenController.class);
	
	@Autowired
	private ExamenService service;
	
	@PostMapping("/nuevo")
	public ResponseEntity<Examen> registrar(@RequestBody Examen m) {
		logger.info("Registrar nuevo examen");
		try {
			Examen examen= service.registrar(m);
			
			return new ResponseEntity<>(examen,HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("No se pudo registrar el examen");
			logger.debug(e);
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Examen> actualizar(@RequestBody Examen m,@PathVariable Integer id) throws Exception {
		Examen examen=service.modificar(m,id);
		return ResponseEntity.ok(examen);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Examen> buscar(@PathVariable("id") int id) throws Exception {
		return ResponseEntity.ok(service.buscar(id));
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Examen>> listar() throws Exception {
		return ResponseEntity.ok(service.listarTodos());
	}
	

}
