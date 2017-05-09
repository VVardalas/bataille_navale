package Classes;

import java.util.HashMap;
import java.util.Map;

public class Joueur {
	
//	Property
	private Map<Integer, Bateau> listeBateaux;
	private String nom;
	private Grille grille;
	private Grille grilleAdversaire;
	
	public Joueur(String nom)
	{
		super();
		this.nom = nom;
		listeBateaux = new HashMap<Integer,Bateau>();
		grille = new Grille(15,15); //Pas paramètrable du coup ? :c
		remplirListeBateaux();
	}

//	Getters/Setters
	public Map<Integer, Bateau> getListeBateaux() {
		return listeBateaux;
	}

	public void setListeBateaux(Map<Integer, Bateau> listeBateaux) {
		this.listeBateaux = listeBateaux;
	}	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Grille getGrille() {
		return grille;
	}

	public void setGrille(Grille grille) {
		this.grille = grille;
	}

	public Grille getGrilleAdversaire() {
		return grilleAdversaire;
	}

	public void setGrilleAdversaire(Grille grilleAdversaire) {
		this.grilleAdversaire = grilleAdversaire;
	}
	
// Methodes
	
	private void remplirListeBateaux()
	{
		// une petite boucle for ?
		Bateau bateau1 = new Bateau(2);
		listeBateaux.put(bateau1.getId(), bateau1);
		
		Bateau bateau2 = new Bateau(2);
		listeBateaux.put(bateau2.getId(), bateau2);
		
		Bateau bateau3 = new Bateau(3);
		listeBateaux.put(bateau3.getId(), bateau3);
		
		Bateau bateau4 = new Bateau(4);
		listeBateaux.put(bateau4.getId(), bateau4);
		
		Bateau bateau5 = new Bateau(5);
		listeBateaux.put(bateau5.getId(), bateau5);
	}
	
	/**
	 * Effectue un tir a la position x , y sur la grille de l'adversaire
	 * @param x Coordonn�e x
	 * @param y Coordonn�e y
	 * @return -1 si erreur, 0 si rat� , id du bateau touch� sinon
	 */
	public int tir(int x, int y)
	{
		int retour;
		if (grilleAdversaire == null || x < 0 || y < 0 || x > grilleAdversaire.getLongueur() || y > grilleAdversaire.getHauteur()) // quand vous testerez cette fonction, vous aurez des surprises :p 
		{
			retour = -1;
		}
		else
		{
			retour = grilleAdversaire.getGrille()[x][y];
			if (retour > 0)
			{				
				grilleAdversaire.getGrille()[x][y] = 0;
			}
		}
		return retour;
	}
	
	
}
