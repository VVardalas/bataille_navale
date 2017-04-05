package Classes;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
	
//	Property
	private List<Bateau> listBateaux = new ArrayList<Bateau>();

//	Getters/Setters
	public List<Bateau> getListBateaux() {
		return listBateaux;
	}

	public void setListBateaux(List<Bateau> listBateaux) {
		this.listBateaux = listBateaux;
	}
	
}
