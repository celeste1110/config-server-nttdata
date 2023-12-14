package com.bootcamp.databases.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExamenDto {
	
	private Integer idExamen;
		
	private String nombre;
	
	private String descripcion;

}
