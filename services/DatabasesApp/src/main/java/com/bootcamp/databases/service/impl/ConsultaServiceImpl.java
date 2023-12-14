package com.bootcamp.databases.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.databases.model.Consulta;
import com.bootcamp.databases.model.ConsultaExamen;
import com.bootcamp.databases.model.DetalleConsulta;
import com.bootcamp.databases.model.Examen;
import com.bootcamp.databases.repository.ConsultaExamenRepository;
import com.bootcamp.databases.repository.ConsultaRepository;
import com.bootcamp.databases.repository.DetalleConsultaRepository;
import com.bootcamp.databases.repository.ExamenRepository;
import com.bootcamp.databases.service.ConsultaService;

@Service
public class ConsultaServiceImpl implements ConsultaService{
	
	@Autowired
	ConsultaRepository consultaRepository;
	
	@Autowired
	ConsultaExamenRepository consultaExamenRepository;
	
	@Autowired
	DetalleConsultaRepository detalleConsultaRepository;
	
	@Autowired 
	ExamenRepository examenRepository;

	@Override
	public Consulta registrar(Consulta m) throws Exception {
		
		//registrar consulta
		Consulta consuntaDB=consultaRepository.save(m);
		
		//registrar consulta examen
		if(null!=consuntaDB ) {
			
		m.getExamenes().stream().forEach(p->{
			ConsultaExamen cExamen=new ConsultaExamen();
			cExamen.setIdExamen(p.getIdExamen());
			cExamen.setIdConsulta(consuntaDB.getIdConsulta());
			 consultaExamenRepository.save(cExamen);
			
		});
		
		//registrar detalle consulta
		m.getDetalle().stream().forEach(p->{
			DetalleConsulta dconsulta=new DetalleConsulta();
			dconsulta.setDiagnostico(p.getDiagnostico());
			dconsulta.setTratamiento(p.getTratamiento());
			dconsulta.setConsultaId(consuntaDB.getIdConsulta());
			detalleConsultaRepository.save(dconsulta);
		});
		}
		
	return consuntaDB;
	}

	@Override
	public Consulta modificar(Consulta m, Integer id) throws Exception {
		Consulta op =consultaRepository.findById(id).orElseThrow(()->new Exception("No encontrado"));
		
		Consulta consuntaDB=consultaRepository.save(m);
		//registrar consulta examen
				if(null!=consuntaDB ) {
				
				//registrar detalle consulta
				m.getDetalle().stream().forEach(p->{
					DetalleConsulta dconsulta=new DetalleConsulta();
					dconsulta.setId(p.getId());
					dconsulta.setDiagnostico(p.getDiagnostico());
					dconsulta.setTratamiento(p.getTratamiento());
					
					detalleConsultaRepository.save(dconsulta);
				});
				}
		return consuntaDB;
	}

	@Override
	public Consulta buscar(int id) throws Exception {
	
		Optional<Consulta> op = consultaRepository.findById(id);
		
		Consulta consultabd=new Consulta();
		if(op.isPresent()) {
			consultabd=op.get();
			//List<ConsultaExamen> listConsultaExamen=consultaExamenRepository.finfConsultaExamenaByConsult(id);
			List<ConsultaExamen> listConsultaExamen=consultaExamenRepository.findAll().stream()
					.filter(e->e.getIdConsulta()==id).toList();
			
			List<Examen> listExamen=listConsultaExamen.stream().map(p->{
				Examen examen=examenRepository.findById(p.getIdExamen()).orElseThrow();
				return examen;
			}).toList();
			
			List<DetalleConsulta> listDetalleConsulta=detalleConsultaRepository.finfDetalleConsultaByConsulta(id);
			consultabd.setExamenes(listExamen);
			consultabd.setDetalle(listDetalleConsulta);
			
		}
		return consultabd;
	}

	@Override
	public List<Consulta> listarTodos() throws Exception {

	List<Consulta> listConsulta=consultaRepository.findAll();
	
		
		return listConsulta.stream().map(p->{
			
			//List<ConsultaExamen> listConsultaExamen=consultaExamenRepository.finfConsultaExamenaByConsult(p.getIdConsulta());
			List<ConsultaExamen> listConsultaExamen=consultaExamenRepository.findAll().stream()
					.filter(e->e.getIdConsulta()==p.getIdConsulta()).toList();
			
			List<Examen> listExamen=listConsultaExamen.stream().map(e->{
				Examen examen=examenRepository.findById(e.getIdExamen()).orElseThrow();
				return examen;
			}).toList();
				
				
			List<DetalleConsulta> listDetalleConsulta=detalleConsultaRepository.finfDetalleConsultaByConsulta(p.getIdConsulta());
			p.setExamenes(listExamen);
			p.setDetalle(listDetalleConsulta);
			
			return p;
			
			}).toList();
		
	}



}
