package com.guis.decademy.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cursos")
public class Curso {
	
	@Id
	public String id;
	
	public String codigo;
	
	public String curso;
	
	public List<Clase> clases;
}
