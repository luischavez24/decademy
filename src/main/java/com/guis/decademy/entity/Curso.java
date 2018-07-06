package com.guis.decademy.entity;

public class Curso {
	private String idCurso;
	private String nombre;
	private String descripcion;
	private String temaActual;

	public Curso(String idCurso, String nombre, String descripcion, String temaActual) {
		super();
		this.idCurso = idCurso;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.temaActual = temaActual;
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

	public String getTemaActual() {
		return temaActual;
	}

	public void setTemaActual(String temaActual) {
		this.temaActual = temaActual;
	}	
	
}
