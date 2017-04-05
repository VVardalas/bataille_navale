package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Classes.Joueur;
import Classes.Bateau;

public class TestsBateau {
	
	Joueur joueur;
	Bateau bateau01;
	
	@Before
	public void setUp(){
		joueur = new Joueur();
		bateau01 = new Bateau();
	}

	@Test
	public void testRetirerListIfCoule() {
		
		int sizeListBefore =  joueur.getListBateaux().size();
		bateau01.setCasesRestantes(0);
		assertNotEquals(sizeListBefore, joueur.getListBateaux().size());
		
	}
	
	
	//

}
