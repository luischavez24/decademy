package com.guis.decademy.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="usuarios")
public abstract class Usuario {
	@Id
	protected String id;
	
	protected String codigo;
	
	protected String nombres;
	
	protected String apPaterno;
	
	protected String apMaterno;
	
	protected String facultad;
	
	protected String especialidad;
	
	protected LocalDate fechaNacimiento;
}
