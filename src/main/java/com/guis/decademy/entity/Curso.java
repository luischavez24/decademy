package com.guis.decademy.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cursos")
public class Curso {
	
	@Id
	private String id;
	
	private String codigo;
	
	private String curso;
	
	private List<Clase> clases;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	@Override
	public String toString() {
		return String.format("Curso [id=%s, codigo=%s, curso=%s, clases=%s]", id, codigo, curso, clases);
	}
}
