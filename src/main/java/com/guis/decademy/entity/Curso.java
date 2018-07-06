package com.guis.decademy.entity;

import java.util.ArrayList;
import java.util.List;

public class Curso {
	private String idCurso;
	private String nombre;
	private String descripcion;
	private String perfil;
	private List<Profesor> profesores;
	
	public Curso () {
		profesores = new ArrayList<>();
	}
	
	public Curso(String idCurso, String nombre, String descripcion, String perfil) {
		this.idCurso = idCurso;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.perfil = perfil;
		profesores = new ArrayList<>();
	}
	public String getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}
	
	public Curso addProfesores(Profesor profesor) {
		this.profesores.add(profesor);
		return this;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	
}
