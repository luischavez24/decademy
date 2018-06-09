package com.guis.decademy.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.guis.decademy.entity.Curso;
import com.guis.decademy.entity.Horario;

@Repository("cursosRepository")
public interface CursosRepository extends MongoRepository<Curso, String>, CursosRepositoryCustom{
	
}

interface CursosRepositoryCustom {
	
	public List<Horario> findHorarios();
}

class CursosRepositoryCustomImpl implements CursosRepositoryCustom {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Horario> findHorarios() {
		
		// Pipeline
		LookupOperation lookupCursos = Aggregation.lookup("cursos", "curso", "codigo", "curso");
		LookupOperation lookupTutor = Aggregation.lookup("tutores", "tutor", "codigo", "tutor");
		UnwindOperation unwindCursos = Aggregation.unwind("curso");
		UnwindOperation unwindTutor= Aggregation.unwind("tutor");
		
		// Creating a new aggregation
		Aggregation aggregation = Aggregation.newAggregation(lookupCursos, lookupTutor, unwindCursos,unwindTutor);
		AggregationResults<Horario> results = mongoTemplate.aggregate(aggregation, "horarios", Horario.class);
		return results.getMappedResults();
	}
	
}
