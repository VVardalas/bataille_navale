package Classes;

public class Bateau {
//	Property
	private int casesRestantes;
	
	private int longueur;
	
	private int id;
	
	private static int compteurIdBateau = 1;
	
	public Bateau(int longueur) 
	{
		super();
		this.casesRestantes = longueur;
		this.longueur = longueur;
		this.id = compteurIdBateau++;
	}

//Getters/Setters
	public int getCasesRestantes() {
		return casesRestantes;
	}

	public void setCasesRestantes(int casesRestantes) {
		this.casesRestantes = casesRestantes;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
// Methodes
	
	public int retirerUneCase()
	{
		casesRestantes--;
		return casesRestantes;
	}
	
}
