package com.esprit.examen.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.entities.Stock;

@Repository
public interface OperateurRepository extends CrudRepository<Operateur, Long> {

	
	//@Query("SELECT s FROM Operateur o ")
	//List<Operateur> retrieveStatusOperateurs();
}
