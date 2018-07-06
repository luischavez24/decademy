package com.guis.decademy.entity;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Usuario{
	
	private List<Curso> cursos;
	
	public Profesor(String username, String nombres, String apellidos, String perfil) {
		super(username, nombres, apellidos, perfil);
		cursos = new ArrayList<>();
	}
	
	public void addCurso(Curso curso) {
		cursos.add(curso);
	}
	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
}
