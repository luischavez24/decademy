package com.guis.decademy.entity;

import java.time.LocalDate;

public class ResultadoExamen {
	
	private String idCurso;
	
	private int idTema;
	
	private double porcentajeBuenas;
	
	private double porcentajeMalas;
	
	private double porcentajeIncompletas;
	
	private LocalDate fechaExamen;

	public String getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}

	public int getIdTema() {
		return idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}

	public double getPorcentajeBuenas() {
		return porcentajeBuenas;
	}

	public void setPorcentajeBuenas(double porcentajeBuenas) {
		this.porcentajeBuenas = porcentajeBuenas;
	}

	public double getPorcentajeMalas() {
		return porcentajeMalas;
	}

	public void setPorcentajeMalas(double porcentajeMalas) {
		this.porcentajeMalas = porcentajeMalas;
	}

	public double getPorcentajeIncompletas() {
		return porcentajeIncompletas;
	}

	public void setPorcentajeIncompletas(double porcentajeIncompletas) {
		this.porcentajeIncompletas = porcentajeIncompletas;
	}

	public LocalDate getFechaExamen() {
		return fechaExamen;
	}

	public void setFechaExamen(LocalDate fechaExamen) {
		this.fechaExamen = fechaExamen;
	}
}
