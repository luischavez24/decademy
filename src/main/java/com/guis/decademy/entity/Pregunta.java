package com.guis.decademy.entity;

import java.util.ArrayList;
import java.util.List;

public class Pregunta {
	
	private String pregunta;
	private List<String> opciones;
	private int respuesta;
	
	public Pregunta () {
		opciones = new ArrayList<>();
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public int getRespuesta() {
		return respuesta;
	}

	public List<String> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<String> opciones) {
		this.opciones = opciones;
	}

	public void setRespuesta(int respuesta) {
		this.respuesta = respuesta;
	}
	
	public void addOpcion(String opcion) {
		this.opciones.add(opcion);
	}
}
