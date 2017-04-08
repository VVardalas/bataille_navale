package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sun.java_cup.internal.runtime.Scanner;

public class Partie {

	private List<Joueur> listeJoueurs = new ArrayList<Joueur>();
	
	private String nomGagnant;
	
	public void executerUnTir(Joueur joueur, Joueur adversaire, int x, int y)
	{
		int idBateau = joueur.tir(x, y);
		if (idBateau > 0)
		{
			Map<Integer, Bateau> listeBateaux = adversaire.getListeBateaux();
			Bateau bateauTouche = listeBateaux.get(idBateau);
			int casesRestantes = bateauTouche.retirerUneCase();
			if (casesRestantes == 0)
			{
				listeBateaux.remove(idBateau);
				if (listeBateaux.isEmpty())
				{
					nomGagnant = joueur.getNom();
				}
			}
		}
	}
	
	public static void main(String[] args) {

	}

}
