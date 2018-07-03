package com.guis.decademy.entity;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
	private String username;
	private String nombres;
	private String apellidos;
	private List<ResultadoExamen> resultados;
	
	public Alumno(String username, String nombres, String apellidos) {
		this.username = username;
		this.nombres = nombres;
		this.apellidos = apellidos;
		resultados = new ArrayList<>();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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
}
