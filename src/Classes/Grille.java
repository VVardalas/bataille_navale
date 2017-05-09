package Classes;

public class Grille {
	
	private int[][] grille;
	private int hauteur;
	private int longueur;	
	
	public Grille(int hauteur, int longueur) {		
		super();
		grille = new int[hauteur][longueur];
		this.hauteur = hauteur;
		this.longueur = longueur;	
		initialiser();
	}
	
	public int[][] getGrille() {
		return grille;
	}
	public void setGrille(int[][] grille) { // <--- mauvaise idée, ça ^^
		this.grille = grille;
	}
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	public int getLongueur() {
		return longueur;
	}
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
	
	public boolean ajouterUnBateau(int xDebut, int yDebut, int xFin, int yFin, Bateau bateau) //un peu dangereux de préciser deux points si votre bateau n'est qu'en une dimension
	{
		if (xDebut < 0 || yDebut < 0 || xFin < 0 || yFin < 0 || xDebut > longueur || yFin > hauteur || xFin > longueur || yFin > hauteur)
		{
			return false;
		}
		else
		{
			if (pasDeBateauSurLaTrajectoire(xDebut, yDebut, xFin, yFin))
			{
				if (xDebut == xFin) // Bateau positionn� � la verticale // j'ai comme l'impression que votre document n'est pas en utf-8 :p
				{
					int yCourant = yDebut;
					while (yCourant <= yFin)
					{					
						grille[xDebut][yCourant] = bateau.getId();
						yCourant++;									
					}
				}
				else
				{
					if (yDebut == yFin) // Bateau positionn� � l'horizontale
					{
						int xCourant = xDebut;
						while (xCourant <= xFin)
						{
							grille[xCourant][yDebut] = bateau.getId();
							xCourant++;
						}				
					}
				}
				return true;
			}
			else
			{
				return false;
			}
		}				
	}
	private boolean pasDeBateauSurLaTrajectoire(int xDebut, int yDebut, int xFin, int yFin)
	{
		if (xDebut == xFin) // Bateau positionn� � la verticale
		{
			int yCourant = yDebut;
			while (yCourant <= yFin)
			{
				if(grille[xDebut][yCourant] != 0) //Si il y'a d�j� un bateau � cette position
				{
					return false;
				}			
				yCourant++;
			}
		}
		else
		{
			if (yDebut == yFin) // Bateau positionn� � l'horizontale
			{
				int xCourant = xDebut;
				while (xCourant <= xFin)
				{
					if(grille[xCourant][yDebut] != 0) //Si il y'a d�j� un bateau � cette position
					{
						return false;
					}
					xCourant++;
				}
			}
		}
		return true;
		
	}

	/**
	 * Rempli la grille avec des 0
	 * @return true si r�ussite , false sinon
	 */
	private boolean initialiser()  
	{
		if (grille != null && hauteur > 0 && longueur > 0)
		{
			for (int i = 0; i < longueur; i++)
			{
				for (int j = 0; j < hauteur; j++)
				{
					grille[i][j] = 0; // les cases d'un tableau Java sont automatiquement initialisées à 0
				}
			}
			return true;
		}
		return false;
				
	}
	

}
