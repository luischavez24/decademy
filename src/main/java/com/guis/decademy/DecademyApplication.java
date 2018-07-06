package com.guis.decademy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.guis.decademy.constants.TipoUsuario;
import com.guis.decademy.entity.Alumno;
import com.guis.decademy.entity.Profesor;
import com.guis.decademy.entity.Usuario;

@SpringBootApplication
public class DecademyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DecademyApplication.class, args);
	}
	
	@Bean("usuarioActual")
	public Usuario usuarioActual() {
		return new Usuario();
	}
	
	@Bean("usuarios")
	public List<Usuario> usuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Alumno("pedro.romero","Pedro", "Romero", "pedro.jpg", TipoUsuario.TIPO_ALUMNO));
		usuarios.add(new Alumno("ana.romero","Ana", "Romero", "sarah.jpg", TipoUsuario.TIPO_ADMINISTRATIVO));
		usuarios.add(new Usuario("sarah.connor","Sarah", "Connor", "sarah.jpg", TipoUsuario.TIPO_PADRE));
		usuarios.add(new Profesor("ricardo.gareca", "Ricardo", "Gareca", "ricardo.jpg", TipoUsuario.TIPO_TUTOR));
		return usuarios;
	}
}
