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

import com.bootcamp.databases.model.Consulta;
import com.bootcamp.databases.service.ConsultaService;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
	
private static final Logger logger = Logger.getLogger(ConsultaController.class);
	
	@Autowired
	private ConsultaService service;
	
	@PostMapping("/nuevo")
	public ResponseEntity<Consulta> registrar(@RequestBody Consulta m) {
		System.out.println("entro1");
		logger.info("Registrar nueva consulta");
		try {
			System.out.println("entro2");
			Consulta consulta= service.registrar(m);
			
			System.out.println("entro3");
			return new ResponseEntity<>(consulta,HttpStatus.CREATED);

		} catch (Exception e) {
			System.out.println("entro4");
			logger.error("No se pudo registrar la consulta");
			logger.debug(e);
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Consulta> actualizar(@RequestBody Consulta consulta,@PathVariable Integer id) throws Exception {
		Consulta consultaM=service.modificar(consulta,id);
		return ResponseEntity.ok(consultaM);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Consulta> buscar(@PathVariable("id") int id) throws Exception {
		return ResponseEntity.ok(service.buscar(id));
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Consulta>> listar() throws Exception {
		return ResponseEntity.ok(service.listarTodos());
	}

}
