package com.bootcamp.databases.model;

import java.time.LocalDate;
import java.util.List;


import com.bootcamp.databases.model.dto.ExamenDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConsulta;
	
	@Column(name = "fecha", nullable = false,columnDefinition = "TIMESTAMP")
	private LocalDate fecha;
	
	@ManyToOne
	@JoinColumn(name = "idMedico", nullable = false, foreignKey = @ForeignKey(name = "fkConsultaMedico"))
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name = "idEspecialidad", nullable = false, foreignKey = @ForeignKey(name = "fkConsultaEspecialidad"))
	private Especialidad especialidad;
	
	@ManyToOne
	@JoinColumn(name = "idPaciente", nullable = true, foreignKey = @ForeignKey(name = "fkConsultaPaciente"))
	private Paciente paciente;
	
	@Transient
	private List<Examen> examenes;
	
	@Transient
	private List<DetalleConsulta> detalle;

}
