package com.esprit.examen.test;



import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.OperateurRepository;
import com.esprit.examen.services.IOperateurService;





@SpringBootTest
public class OperatorServiceImplTest {

	@Autowired
	IOperateurService operateurService;
	@Autowired
	private OperateurRepository opRepository;
	@Test
	public void testAddOperateur() {
	//	List<Stock> stocks = stockService.retrieveAllStocks();
	//	int expected=stocks.size();
		Operateur s = new Operateur("stock test","ee","100");
		Operateur savedop= operateurService.addOperateur(s);
		
	//	assertEquals(expected+1, stockService.retrieveAllStocks().size());
    	assertNotNull(savedop.getIdOperateur());
		//operateurService.deleteOperateur(savedop.getIdOperateur());
		
	} 
	
	@Test
    public void testgetListOfOperateur(){

        Iterable<Operateur> operateurs = opRepository.findAll();
        System.out.println("la liste de operateur est" +operateurs);
      //  Assertions.assertThat(stock).isNotEmpty();

    }
	
}
