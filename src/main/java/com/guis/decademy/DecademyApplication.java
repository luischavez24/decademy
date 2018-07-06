package com.guis.decademy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.guis.decademy.entity.Alumno;
import com.guis.decademy.entity.Curso;
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
		usuarios.add(new Alumno("pedro.romero","Pedro", "Romero", "pedro.jpg"));
		usuarios.add(new Alumno("ana.romero","Ana", "Romero", "sarah.jpg"));
		usuarios.add(new Usuario("sarah.connor","Sarah", "Connor", "sarah.jpg"));
		usuarios.add(new Profesor("ricardo.gareca", "Ricardo", "Gareca", "ricardo.jpg"));
		return usuarios;
	}
	
	@Bean("cursos")
	public List<Curso> cursos() {
		List<Curso> cursos = new ArrayList<>();
		cursos.add(new Curso("algo3", "Algoritmica 3","Desarrollar algoritmos con la finalidad de fortalecer los conocimientos adquiridos, poniendo énfasis en la eficiencia algorítmica, y las habilidades de elaboración de soluciones algorítmicas a problemas basados en un conjunto de componentes que deben interactuar entre si.", "algoritmica.png")
				.addProfesores(new Profesor("victor.bustamante", "Victor", "Bustamante", "http://sistemas.unmsm.edu.pe/fisi/adjuntos/paginas/Bustamante_Victor.jpg"))
				.addProfesores(new Profesor("santiago.moquillaza", "Santiago", "Moquillaza", "http://sistemas.unmsm.edu.pe/fisi/adjuntos/paginas/MoquillazaSantiago.jpg"))
				.addProfesores(new Profesor("jorge.chavez", "Jorge", "Chavez", "http://sistemas.unmsm.edu.pe/fisi/adjuntos/paginas/Jorge_Chavez.jpg")));
		
		cursos.add(new Curso("ia", "Sistemas Operativos","En este curso aprenderemos los conceptos básicos asociados a la Inteligencia Artificial, las escuelas predominantes en esta área. Así como distintos algoritmos para la generación de la inteligencia en el computador", "sistemas_operativos.png")
				.addProfesores(new Profesor("victor.bustamante", "Victor", "Bustamante", "http://sistemas.unmsm.edu.pe/fisi/adjuntos/paginas/Bustamante_Victor.jpg"))
				.addProfesores(new Profesor("ricardo.gareca", "Ricardo", "Gareca", "/img/ricardo.jpg"))
				.addProfesores(new Profesor("jorge.chavez", "Jorge", "Chavez", "http://sistemas.unmsm.edu.pe/fisi/adjuntos/paginas/Jorge_Chavez.jpg")));
		cursos.add(new Curso("so", "Inteligencia Artificial", "Conocerás como se estructura un Sistema Operativo, la forma como trabaja internamente el sistema operativo la gestión de los procesos. Daremos un vistazo a los SO predominantes en el mercado actualmente", "inteligencia_artificial.png")
				.addProfesores(new Profesor("victor.bustamante", "Victor", "Bustamante", "http://sistemas.unmsm.edu.pe/fisi/adjuntos/paginas/Bustamante_Victor.jpg"))
				.addProfesores(new Profesor("jorge.diaz", "Jorge", "Diaz Muñante", "http://sistemas.unmsm.edu.pe/fisi/adjuntos/paginas/Diaz_Jorge.jpg"))
				.addProfesores(new Profesor("jorge.chavez", "Jorge", "Chavez", "http://sistemas.unmsm.edu.pe/fisi/adjuntos/paginas/Jorge_Chavez.jpg")));
				
		return cursos;
	}
	
	@Bean("profesores")
	public List<Profesor> profesores() {
		List<Profesor> profesores = new ArrayList<>();
		profesores.add(new Profesor("jorge.diaz", "Jorge", "Diaz Muñante", "http://sistemas.unmsm.edu.pe/fisi/adjuntos/paginas/Diaz_Jorge.jpg"));
		profesores.add(new Profesor("santiago.moquillaza", "Santiago", "Moquillaza", "http://sistemas.unmsm.edu.pe/fisi/adjuntos/paginas/MoquillazaSantiago.jpg"));
		profesores.add(new Profesor("victor.bustamante", "Victor", "Bustamante", "http://sistemas.unmsm.edu.pe/fisi/adjuntos/paginas/Bustamante_Victor.jpg"));
		profesores.add(new Profesor("jorge.chavez", "Jorge", "Chavez", "http://sistemas.unmsm.edu.pe/fisi/adjuntos/paginas/Chavez_Jorge.jpg"));
		profesores.add(new Profesor("ricardo.gareca", "Ricardo", "Gareca", "ricardo.jpg"));
		return profesores;
	}
}
