package com.guis.decademy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.guis.decademy.entity.Alumno;

@SpringBootApplication
public class DecademyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DecademyApplication.class, args);
	}
	
	@Bean("alumnoPrueba")
	public Alumno alumnoPrueba() {
		Alumno alumnoPrueba = new Alumno("pedro.romero","Pedro", "Romero");
		return alumnoPrueba;
	}
}
