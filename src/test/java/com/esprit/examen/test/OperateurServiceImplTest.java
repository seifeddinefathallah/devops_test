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
	IStockService stockService;
	@Autowired
	IOperateurService operateurService;
	@Autowired
	private StockRepository stockRepository;
	
    @Autowired
    private OperateurRepository opRepository;
	@Test
	public void testAddStock() {
	//	List<Stock> stocks = stockService.retrieveAllStocks();
	//	int expected=stocks.size();
		Stock s = new Stock("styyyt",10,15);
		Stock savedStock= stockService.addStock(s);
		
	//	assertEquals(expected+1, stockService.retrieveAllStocks().size());
		assertNotNull(savedStock.getLibelleStock());
	//	stockService.deleteStock(savedStock.getIdStock());
		
	} 
	
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
	
	/*@Test
	public void testAddStockOptimized() {

		Stock s = new Stock("stock tttttt",10,100);
		Stock savedStock= stockService.addStock(s);
		assertNotNull(savedStock.getIdStock());
		assertSame(10, savedStock.getQte());
		assertTrue(savedStock.getQteMin()>0);
		//stockService.deleteStock(savedStock.getIdStock());
		
	} */
	
	@Test
	public void testDeleteOperateur() {
		Operateur s = new Operateur("rayen","seif","rrrrr");
		Operateur savedop= operateurService.addOperateur(s);
		stockService.deleteStock(savedop.getIdOperateur());
		assertNull(stockService.retrieveStock(savedop.getIdOperateur()));
	}
	
	@Test
	public void testDeleteStock() {
		Stock s = new Stock("stock test",30,60);
		Stock savedStock= stockService.addStock(s);
		stockService.deleteStock(savedStock.getIdStock());
		assertNull(stockService.retrieveStock(savedStock.getIdStock()));
	}
	@Test
	public void testupdateStock() {

		Stock stock = stockRepository.findById(36L).get();
		stock.setLibelleStock("stock update");
        Stock updateStock =  stockRepository.save(stock);
        Assertions.assertThat(updateStock.getLibelleStock()).isEqualTo("stock update");
	}
	
	/*@Test
	public void testupdateOperateur() {

		Operateur op = opRepository.findById(36L).get();
		op.setPassword("888");
        Operateur updateOp =  opRepository.save(op);
        Assertions.assertThat(updateOp.getLibelleStock()).isEqualTo("stock update");
	}*/
	/*@Test
	 public void testretrieveStock(){

		Stock cat = stockRepository.findById(37L).get();
			System.out.println("le Stock est"+cat);
	        Assertions.assertThat(cat.getIdStock()).isEqualTo(37L);

	    }*/
	@Test
    public void testgetListOfStock(){

        List<Stock> stock = stockRepository.findAll();
        System.out.println("la liste de Stock est" +stock);
        Assertions.assertThat(stock).isNotEmpty();

    }
}
