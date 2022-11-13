package com.esprit.examen.services;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.services.FournisseurServiceImpl;

import java.util.*;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;


@SpringBootTest(classes =FournisseurServiceImplMockTest.class)
@ExtendWith(MockitoExtension.class)
 class FournisseurServiceImplMockTest {
	@Mock
    FournisseurRepository fournisseurRepository;

    @InjectMocks
    FournisseurServiceImpl fournisseurServiceImpl;

    Fournisseur fournisseur = new Fournisseur(null, "f1", "l1", null, null, null, null);

    List<Fournisseur> listFournisseur = new ArrayList<Fournisseur>() {
        {
            add(new Fournisseur(null, "f2", "l2", null, null, null, null));
            add(new Fournisseur(null, "f3", "l3", null, null, null, null));
        }
    };
    @Test
    void testretrieveFournisseur() {
        when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(fournisseur));
        Fournisseur fournisseur1 = fournisseurServiceImpl.retrieveFournisseur(1L);
        Assertions.assertNotNull(fournisseur1);
    }


    @Test
    void retrieveAllFournisseurs() {
        List<Fournisseur> fournisseurs = new ArrayList();
        fournisseurs.add(new Fournisseur());
        when(fournisseurRepository.findAll()).thenReturn(fournisseurs);
        List<Fournisseur> expected = fournisseurServiceImpl.retrieveAllFournisseurs();
        Assertions.assertEquals(expected, fournisseurs);
        verify(fournisseurRepository).findAll();
    }
    @Test
    void testaddFournisseur() {
        Fournisseur fournisseur = new Fournisseur(null, "f3", "l3", null, null, null, null);
        when(fournisseurRepository.save(isA(Fournisseur.class))).thenAnswer(invocation -> (Fournisseur) invocation.getArguments()[0]);
        Fournisseur returnedObj = fournisseurServiceImpl.addFournisseur(fournisseur);
        ArgumentCaptor<Fournisseur> savedObjectArgument = ArgumentCaptor.forClass(Fournisseur.class);
        verify(fournisseurRepository, times(1)).save(savedObjectArgument.capture());
        verifyNoMoreInteractions(fournisseurRepository);
        Fournisseur savedRestObject = savedObjectArgument.getValue();
        Assertions.assertNotNull(savedRestObject);
    }
    @Test
    void testdeleteFournisseur() {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setLibelle("new test");
        fournisseur.setIdFournisseur(1L);
        when(fournisseurRepository.findById(fournisseur.getIdFournisseur())).thenReturn(Optional.of(fournisseur));
        Fournisseur fournisseur1 = fournisseurServiceImpl.retrieveFournisseur(1L);
        fournisseurServiceImpl.deleteFournisseur(fournisseur1.getIdFournisseur());
        verify(fournisseurRepository).deleteById(fournisseur1.getIdFournisseur());
    }
}
