package Classes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Partie {
	
	private static List<Joueur> listeJoueurs = new ArrayList<Joueur>();
	
	private static String nomGagnant;
	
	public static void executerUnTir(Joueur joueur, Joueur adversaire, int x, int y)
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
	
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("---------- BATAILLE NAVALE -----------");
		do
		{
			System.out.println(" DEBUT DE LA PARTIE ");
			System.out.println("------------------------------- ");
			String nomSaisi;
			System.out.println(" Entrer le nom du joueur 1 : ");
			nomSaisi = s.nextLine();
			Joueur joueur1 = new Joueur(nomSaisi);
			listeJoueurs.add(joueur1);
			System.out.println(" Entrer le nom du joueur 2 : ");
			nomSaisi = s.nextLine();			
			Joueur joueur2 = new Joueur(nomSaisi);
			listeJoueurs.add(joueur2);
			joueur1.setGrilleAdversaire(joueur2.getGrille());
			joueur2.setGrilleAdversaire(joueur1.getGrille());
			for (Joueur joueurCourant : listeJoueurs)
			{
				System.out.println(" PHASE DE PLACEMENT DE " + joueurCourant.getNom());
				System.out.println(" ------------------------------------------------ ");
				Grille grille = joueurCourant.getGrille();
				for(Integer idBateauCourant : joueurCourant.getListeBateaux().keySet())
				{
					Bateau bateauCourant = joueurCourant.getListeBateaux().get(idBateauCourant);
					System.out.println(" Placement du bateau de taille " + bateauCourant.getLongueur());
					boolean ok = true;
					int xDebut = -1, yDebut = -1, xFin = -1, yFin = -1;
					do{
						System.out.println(" Entrer la position X de début : ");
						try
						{
							xDebut = s.nextInt();
							ok = true;
							if (xDebut < 0 || xDebut > grille.getLongueur())
							{
								System.out.println(" La position doit etre comprise entre 0 et "  + grille.getLongueur());
								ok = false;
							}
						}catch (InputMismatchException e)
						{
							System.out.println(" La position doit etre un ENTIER VALIDE ");
							ok = false;
						}
						
					}while (!ok);
					
					do{
						System.out.println(" Entrer la position Y de début : ");
						try
						{
							yDebut = s.nextInt();
							ok = true;
							if (yDebut < 0 || yDebut > grille.getHauteur())
							{
								System.out.println(" La position doit etre comprise entre 0 et "  + grille.getHauteur());
								ok = false;
							}
						}catch (InputMismatchException e)
						{
							System.out.println(" La position doit etre un ENTIER VALIDE ");
							ok = false;
						}
						
					}while (!ok);
					
					do{
						System.out.println(" Entrer la position X de fin : ");
						try
						{
							xFin = s.nextInt();
							ok = true;
							if (xFin < 0 || xFin > grille.getLongueur())
							{
								System.out.println(" La position doit etre comprise entre 0 et "  + grille.getLongueur());
								ok = false;
							}
						}catch (InputMismatchException e)
						{
							System.out.println(" La position doit etre un ENTIER VALIDE ");
							ok = false;
						}
						
					}while (!ok);
					
					do{
						System.out.println(" Entrer la position Y de fin : ");
						try
						{
							yFin = s.nextInt();
							ok = true;
							if (yFin < 0 || yFin > grille.getHauteur())
							{
								System.out.println(" La position doit etre comprise entre 0 et "  + grille.getHauteur());
								ok = false;
							}
						}catch (InputMismatchException e)
						{
							System.out.println(" La position doit etre un ENTIER VALIDE ");
							ok = false;
						}
						
					}while (!ok);
					grille.ajouterUnBateau(xDebut, yDebut, xFin, yFin, bateauCourant);					
				}				
			}	
			
			while(nomGagnant == null)
			{
				boolean ok = true;
				for (Joueur joueurCourant : listeJoueurs)
				{
					System.out.println("Au tour de " + joueurCourant.getNom() + " de tirer !") ;
					Grille grilleAdversaire = joueurCourant.getGrilleAdversaire();
					int x = -1, y = -1 ;
					do{
						System.out.println(" Entrer la position X : ");
						try
						{
							x = s.nextInt();
							ok = true;
							if (x < 0 || x > grilleAdversaire.getHauteur())
							{
								System.out.println(" La position doit etre comprise entre 0 et "  + grilleAdversaire.getHauteur());
								ok = false;
							}
						}catch (InputMismatchException e)
						{
							System.out.println(" La position doit etre un ENTIER VALIDE ");
							ok = false;
						}						
					}while (!ok);
					do{
						System.out.println(" Entrer la position Y : ");
						try
						{
							y = s.nextInt();
							ok = true;
							if (y < 0 || y > grilleAdversaire.getHauteur())
							{
								System.out.println(" La position doit etre comprise entre 0 et "  + grilleAdversaire.getHauteur());
								ok = false;
							}
						}catch (InputMismatchException e)
						{
							System.out.println(" La position doit etre un ENTIER VALIDE ");
							ok = false;
						}						
					}while (!ok);
					if (joueurCourant == joueur1)
					{
						executerUnTir(joueur1, joueur2, x ,y);
					}
					else
					{
						executerUnTir(joueur2, joueur1, x ,y);
					}
				}				
			}			
		}while (!s.nextLine().equalsIgnoreCase("n"));
		
	}

}
