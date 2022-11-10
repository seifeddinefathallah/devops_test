package com.esprit.examen.test;





import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;
import com.esprit.examen.services.OperateurServiceImpl;

@SpringBootTest
public class OperatorServiceImplTest {

	@Autowired
	OperateurServiceImpl OperatorService;
	
	@Autowired
	OperateurRepository operateurRepo;
	
	@Test
	public void testAddOperator() {
	//	List<Operateur> operateurs = OperatorService.retrieveAllOperateurs();
	//	int expected=operateurs.size();
	Operateur r = new Operateur();
	//r.setIdOperateur();
	r.setNom("rrr");
    r.setPassword("123");
    r.setPrenom("rtt");
    Operateur savedO= OperatorService.addOperateur(r);
	OperatorService.deleteOperateur(savedO.getIdOperateur());
	
		
	} 
	
	@Test
	public void testUpdateOperateur() {
		Operateur r = new Operateur();
		r.setNom("rrr");
	    r.setPassword("123");
	    r.setPrenom("yyy");
	   
	}
	
	/*@Test
	public void testDeleteOperateur() {
	    Operateur c = new Operateur("Salhi", "Ahmed","aa11");
       	Operateur operateurS = OperatorService.addOperateur(c);
		OperatorService.deleteOperateur(operateurS.getIdOperateur());
		assertNull(OperatorService.retrieveOperateur(operateurS.getIdOperateur()));
	}*/
	
	/*@Test
	 public void testretrieveOp(){

		Operateur op = operateurRepo.findById(1L).get();
			System.out.println("l'operateur est"+op);
	       // Assertions.assertThat(op.getIdStock()).isEqualTo(37L);

	    }*/
	
}
