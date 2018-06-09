package com.guis.decademy.entity;
import java.time.*;
public class Horario {
	
	private String id;
	
	private Tutor tutor;
	
	private Curso curso;
	
	private LocalDateTime horario;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public LocalDateTime getHorario() {
		return horario;
	}

	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}
}
