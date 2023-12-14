package com.bootcamp.databases.model;


import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="detalleConsulta")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DetalleConsulta {
	
	@Id
	private String id;
	
	private String diagnostico;
	
	private String tratamiento;
	
	private Integer consultaId;


}
