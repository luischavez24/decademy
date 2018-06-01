package com.guis.decademy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.guis.decademy.entity.Curso;

@Repository("cursosRepository")
public interface CursosRepository extends MongoRepository<Curso, String>{
	
	public Curso findByNombreCurso(String nombreCurso);
}
