package com.esprit.examen.test;

import static org.junit.Assert.*;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Operateur;

import com.esprit.examen.repositories.OperateurRepository;
import com.esprit.examen.services.IOperateurService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OperateurServiceImplTest.class )
public class OperateurServiceImplTest {
	
	
	@Autowired
	IOperateurService operateurService;
	@Autowired
	private OperateurRepository operateurRepository;
	
	
	@Test
	public void testAddoperateur() {
	//	List<Stock> stocks = stockService.retrieveAllStocks();
	//	int expected=stocks.size();
		Operateur o = new Operateur("rrrr","tttt","ttr122");
		Operateur savedOperateur= operateurService.addOperateur(o);
		
		assertNotNull(savedOperateur.getIdOperateur());
	//	stockService.deleteStock(savedStock.getIdOperateur());
		
	} 
	
	/*@Test
	public void testAddOperateurOptimized() {

		Operateur o = new Operateur("rrr","10","tthfgvt");
		Operateur savedOperateur= operateurService.addOperateur(o);
		assertNotNull(savedOperateur.getIdOperateur());
		//operateurService.deleteOperateur(savedOperateur.getIdOperateur());
		
	} 
	
	@Test
	public void testDeleteStock() {
		Operateur o = new Operateur("stock test","10","ttt");
		Operateur savedOperateur= operateurService.addOperateur(o);
		operateurService.deleteOperateur(savedOperateur.getIdOperateur());
		//assertNull(operateurService.retrieveOperateur(savedOperateur.getIdOperateur()));
	}
	@Test
	public void testupdateOperrateur() {

		Operateur o = operateurRepository.findById(36L).get();
		o.setPassword("8");
		Operateur updateOperateur =  operateurRepository.save(o);
        Assertions.assertThat(updateOperateur.getPassword()).isEqualTo("8");
	}
	@Test
	 public void testretrieveStock(){

		Operateur cat = operateurRepository.findById(37L).get();
			System.out.println("la liste des opérateurs est"+cat);
	        Assertions.assertThat(cat.getIdOperateur()).isEqualTo(37L);

	    }
    @Test
    public void testgetListOfOperateur(){

        List<Operateur> op = (List<Operateur>) operateurRepository.findAll();
        System.out.println("la liste des operateurs est" +op);
      //  Assertions.assertThat(stock).isNotEmpty();

    }*/
}