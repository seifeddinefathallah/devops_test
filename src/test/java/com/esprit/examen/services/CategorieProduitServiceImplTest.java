package com.esprit.examen.services;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.repositories.CategorieProduitRepository;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.assertj.core.api.Assertions;
import org.junit.*;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CategorieProduitServiceImplTest {
	@Autowired
	ICategorieProduitService CategorieProduitService;
	@Autowired
   private CategorieProduitRepository CategorieProduitRepo;
	@Test
	public void testaddCategorieProduits() {
		CategorieProduit cp;
		cp = new CategorieProduit(null, "menage","100", null);
		CategorieProduit savedCategorieProduits= CategorieProduitService.addCategorieProduit(cp);
		assertNotNull(savedCategorieProduits.getLibelleCategorie());
	}

	@Test
	public void testdeleteCategorieProduit() {
		CategorieProduit cp;
		cp = new CategorieProduit(null, "sport","500", null);
		CategorieProduit savedCategorieProduits= CategorieProduitService.addCategorieProduit(cp);
		CategorieProduitService.deleteCategorieProduit(savedCategorieProduits.getIdCategorieProduit());
		assertNull(CategorieProduitService.retrieveCategorieProduit(savedCategorieProduits.getIdCategorieProduit()));
		}

	@Test
	public void testretrieveAllCategorieProduits() throws ParseException {
		List<CategorieProduit> cp = CategorieProduitService.retrieveAllCategorieProduits();
		int expected = cp.size();
		CategorieProduit c = new CategorieProduit(null, "smart", "watch", null);
		CategorieProduit catprod = CategorieProduitService.addCategorieProduit(c);
		assertEquals(expected + 1, CategorieProduitService.retrieveAllCategorieProduits().size());
		}
	@Test
	public void testupdateCategorieProduit() {

		CategorieProduit cat = CategorieProduitRepo.findById(1L).get();
        cat.setCodeCategorie("smart");
        CategorieProduit updateCategorieProduit =  CategorieProduitRepo.save(cat);
        Assertions.assertThat(updateCategorieProduit.getCodeCategorie()).isEqualTo("smart");
	}
	@Test
	 public void testretrieveCategorieProduits(){

		CategorieProduit cat = CategorieProduitRepo.findById(1L).get();
			System.out.println(cat);
	        Assertions.assertThat(cat.getIdCategorieProduit()).isEqualTo(1L);

	    }
	@Test
    public void testgetListOfCategorieProduits(){

        List<CategorieProduit> cat = CategorieProduitRepo.findAll();
        System.out.println("la liste de CategorieProduit est" +cat);
        Assertions.assertThat(cat).isNotEmpty();

    }

}