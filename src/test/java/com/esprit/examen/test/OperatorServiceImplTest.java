package com.esprit.examen.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.services.OperateurServiceImpl;

@SpringBootTest
public class OperatorServiceImplTest {

	@Autowired
	OperateurServiceImpl OperatorService;
	
	
	@Test
	public void testAddOperator() {
	
	Operateur r = new Operateur();
	
	r.setNom("rrr");
    r.setPassword("123");
    r.setPrenom("rtt");
	
		
	} 
}