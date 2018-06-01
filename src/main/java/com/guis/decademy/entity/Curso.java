package com.guis.decademy.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cursos")
public class Curso {
	
	@Id
	public String id;
	
	public String codigoCurso;
	
	public String nombreCurso;
}
