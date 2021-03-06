package com.guis.decademy.entity;

public class Usuario {
	
	protected String username;
	protected String nombres;
	protected String apellidos;
	protected String perfil;
	protected String tipo;
	
	public Usuario() {
		
	}
	
	public Usuario(String username, String nombres, String apellidos, String perfil, String tipo) {
		this.username = username;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.perfil = perfil;
		this.tipo = tipo;
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
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
