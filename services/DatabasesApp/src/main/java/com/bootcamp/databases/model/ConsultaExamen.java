package com.bootcamp.databases.model;



import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection="consultaExamen")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ConsultaExamen {

	@Id
	private String id;
	
	private Integer idExamen;
	
	private Integer idConsulta;
	

}
