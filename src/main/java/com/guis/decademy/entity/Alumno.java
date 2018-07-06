package com.guis.decademy.entity;

import java.util.ArrayList;
import java.util.List;

public class Alumno extends Usuario{
	
	private List<Curso> cursos;
	
	private List<ResultadoExamen> resultados;
	
	public Alumno(String username, String nombres, String apellidos, String perfil, String tipo) {
		super(username, nombres, apellidos, perfil, tipo);
		resultados = new ArrayList<>();
		cursos = new ArrayList<>();
	}

	public List<ResultadoExamen> getResultados() {
		return resultados;
	}
	
	public void addResultado(ResultadoExamen resultado) {
		resultados.add(resultado);
	}
	public void setResultados(List<ResultadoExamen> resultados) {
		this.resultados = resultados;
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
