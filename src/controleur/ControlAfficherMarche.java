package controleur;

import villagegaulois.Village;

public class ControlAfficherMarche {
	private Village village;

	public ControlAfficherMarche(Village village) {
		this.village = village;
	}

	public String donnerInfosMarche() {
		StringBuilder chaine = new StringBuilder();
		String[] infosMarche = village.donnerEtatMarche();
		for(int i=0; i<infosMarche.length; i++) {
			chaine.append(infosMarche[i]);
		}
		return chaine.toString();
	}
}
