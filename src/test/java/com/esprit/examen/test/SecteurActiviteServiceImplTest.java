package com.esprit.examen.test;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;
import com.esprit.examen.services.ISecteurActiviteService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SecteurActiviteServiceImplTest {
	@Autowired
	ISecteurActiviteService secteurActiviteService;
	@Autowired
    private SecteurActiviteRepository secteurActiviteRepository;
	
	@Test
	public void testaddSecteurActivite() {
	
		//SecteurActivite s = new SecteurActivite(null, "stock test","azerty", null);
		SecteurActivite s = new SecteurActivite();
		s.setCodeSecteurActivite("stock test");
		s.setLibelleSecteurActivite("azerty");
		SecteurActivite savedStock= secteurActiviteService.addSecteurActivite(s);
		assertNotNull(savedStock.getLibelleSecteurActivite());
		//stockService.deleteStock(savedStock.getIdStock());
		
	} 
	/*@Test
	public void testdeleteSecteurActivite(){

		SecteurActivite s = secteurActiviteRepository.findById(2L).get();

		secteurActiviteRepository.delete(s);

        //employeeRepository.deleteById(1L);

		SecteurActivite secteur1 = null;

        Optional<SecteurActivite> optionalSecteur = secteurActiviteRepository.findById(2L);

        if(optionalSecteur.isPresent()){
        	secteur1 = optionalSecteur.get();
        }

        Assertions.assertThat(secteur1).isNull();
    }*/
	/*@Test
	public void testupdateSecteurActivite(){

		SecteurActivite secteur = secteurActiviteRepository.findById(1L).get();

		SecteurActivite.setCodeSecteurActivite("azerty");

		SecteurActivite updateSecteurActivite =  secteurActiviteRepository.save(secteur);

        Assertions.assertThat(updateSecteurActivite.getEmail()).isEqualTo("ram@gmail.com");

    }*/
}
