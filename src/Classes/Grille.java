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
	}
	
	public int[][] getGrille() {
		return grille;
	}
	public void setGrille(int[][] grille) {
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
	
	public boolean ajouterUnBateau(int xDebut, int yDebut, int xFin, int yFin, Bateau bateau)
	{
		if (xDebut < 0 || yDebut < 0 || xFin < 0 || yFin < 0 || xDebut > longueur || yFin > hauteur || xFin > longueur || yFin > hauteur)
		{
			return false;
		}
		else
		{
			if (pasDeBateauSurLaTrajectoire(xDebut, yDebut, xFin, yFin))
			{
				if (xDebut == xFin) // Bateau positionné à la verticale
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
					if (yDebut == yFin) // Bateau positionné à l'horizontale
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
		if (xDebut == xFin) // Bateau positionné à la verticale
		{
			int yCourant = yDebut;
			while (yCourant <= yFin)
			{
				if(grille[xDebut][yCourant] != 0) //Si il y'a déjà un bateau à cette position
				{
					return false;
				}			
				yCourant++;
			}
		}
		else
		{
			if (yDebut == yFin) // Bateau positionné à l'horizontale
			{
				int xCourant = xDebut;
				while (xCourant <= xFin)
				{
					if(grille[xCourant][yDebut] != 0) //Si il y'a déjà un bateau à cette position
					{
						return false;
					}
					xCourant++;
				}
			}
		}
		return true;
		
	}
	

}
