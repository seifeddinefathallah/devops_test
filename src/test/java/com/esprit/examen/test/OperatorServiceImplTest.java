package com.esprit.examen.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.services.OperateurServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class OperatorServiceImplTest {

	@Autowired
	OperateurServiceImpl OperatorService;
	
	@Test
	public void testAddOperator() {
		List<Operateur> operateurs = OperatorService.retrieveAllOperateurs();
		int expected=operateurs.size();
	Operateur r = new Operateur();
	//r.setIdOperateur();
	r.setNom("rrr");
    r.setPassword("123");
    r.setPrenom("rtt");
	//Operateur savedop=OperatorService.addOperateur(r);
	assertEquals(expected+1, OperatorService.retrieveAllOperateurs().size());
		
	} 
}
