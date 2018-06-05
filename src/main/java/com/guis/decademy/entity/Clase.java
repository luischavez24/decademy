package com.guis.decademy.entity;

public class Clase {
	
	private String tema;
	
	private String descripcion;

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return String.format("Clase [tema=%s, descripcion=%s]", tema, descripcion);
	}
}
