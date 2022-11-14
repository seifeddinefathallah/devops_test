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
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.OperateurRepository;
import com.esprit.examen.repositories.StockRepository;
import com.esprit.examen.services.IOperateurService;
import com.esprit.examen.services.IStockService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OperateurServiceImplTest {

	
	
	@Autowired
	IOperateurService operateurService;

	
    @Autowired
    private OperateurRepository opRepository;
	
	
	@Test
	public void testAddoperateur() {
	//	List<Stock> stocks = stockService.retrieveAllStocks();
	//	int expected=stocks.size();
		Operateur s = new Operateur("rayen","seif","rrrrr");
		Operateur savedop= operateurService.addOperateur(s);
		
	//	assertEquals(expected+1, stockService.retrieveAllStocks().size());
		assertNotNull(savedop.getIdOperateur());
		//stockService.deleteStock(savedStock.getIdStock());
		
	} 
	
	
	
	@Test
	public void testDeleteOperateur() {
		Operateur s = new Operateur("rayen","seif","rrrrr");
		Operateur savedop= operateurService.addOperateur(s);
		operateurService.deleteOperateur(savedop.getIdOperateur());
		assertNull(operateurService.retrieveOperateur(savedop.getIdOperateur()));
	}
	
	
	
	
	@Test
	public void testupdateOperateur() {

		Operateur op = opRepository.findById(36L).get();
		op.setPassword("888");
        Operateur updateOp =  opRepository.save(op);
        Assertions.assertThat(updateOp.getPassword()).isEqualTo("888");
	}
	
	
	@Test
    public void testgetListOfOperateur(){

        List<Operateur> ops= (List<Operateur>) opRepository.findAll();
        System.out.println("la liste de operateurs est" +ops);
        Assertions.assertThat(ops).isNotEmpty();

    }
}
