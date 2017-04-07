package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Classes.Bateau;
import Classes.Grille;

public class TestsGrille {
	
	private Grille grille;
	
	@Before
	public void setUp()
	{
		grille = new Grille(10,10);
	}

	@Test
	public void testLargeurNegative() 
	{
		assertNull(new Grille(-2,5));		
	}
	
	@Test
	public void testHauteurNegative() 
	{
		assertNull(new Grille(5,-3));		
	}
	
	@Test
	public void testXOrigineNegatif() 
	{
		Bateau bateau = new Bateau(6);
		assertFalse(grille.ajouterUnBateau(-5,2,11,2, bateau));
	}
	
	@Test
	public void testYOrigineNegatif() 
	{
		Bateau bateau = new Bateau(6);
		assertFalse(grille.ajouterUnBateau(5,-2,11,2, bateau));
	}
	
	@Test
	public void testXArriveeNegatif() 
	{
		Bateau bateau = new Bateau(6);
		assertFalse(grille.ajouterUnBateau(5,2,-11,2, bateau));
	}
	
	@Test
	public void testYArriveeeNegatif() 
	{
		Bateau bateau = new Bateau(6);
		assertFalse(grille.ajouterUnBateau(5,2,11,-2, bateau));
	}
	
	@Test
	public void testBateauDepasseGrille() 
	{
		Bateau bateau = new Bateau(6);
		assertFalse(grille.ajouterUnBateau(5,2,11,2, bateau));
	}
	
	@Test
	public void testBateauEnDehorsDeGrille() 
	{
		Bateau bateau = new Bateau(6);
		assertFalse(grille.ajouterUnBateau(11,15,11,21, bateau));
	}
	
	@Test
	public void testValeursGrillesValides() 
	{
		grille.initialiser();
		for (int i = 0; i < grille.getLongueur(); i++)
		{
			for (int j = 0; j < grille.getHauteur(); j++)
			{
				assertNotNull(grille.getGrille()[i][j]);
			}
		}
	}
	
	@Test
	public void testBateauDejaPresent() 
	{
		Bateau bateau1 = new Bateau(3);
		grille.ajouterUnBateau(2,5,5,5, bateau1);
		Bateau bateau2 = new Bateau(3);
		assertFalse(grille.ajouterUnBateau(1,5,4,5, bateau2));
	}

}
