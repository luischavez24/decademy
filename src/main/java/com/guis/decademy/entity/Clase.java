package com.guis.decademy.entity;

import java.util.List;

public class Clase {

	private Tutor tutor;
	
	private Grupo grupo;
	
	private Tema tema;
	
	private List<Archivo> archivos;
	
	private ClaseVirtual claseVirtual;

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public List<Archivo> getArchivos() {
		return archivos;
	}

	public void setArchivos(List<Archivo> archivos) {
		this.archivos = archivos;
	}

	public ClaseVirtual getClaseVirtual() {
		return claseVirtual;
	}

	public void setClaseVirtual(ClaseVirtual claseVirtual) {
		this.claseVirtual = claseVirtual;
	}
	
}
