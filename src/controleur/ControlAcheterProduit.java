package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public void acheterProduit(String nomAcheteur) {

	}
	
	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	
	public String trouverEtalProduit(String nomProduit) {
		StringBuilder chaine = new StringBuilder();
		Gaulois[] vendeur = village.rechercherVendeursProduit(nomProduit);
		for(int i=0; i<vendeur.length; i++) {
			chaine.append(i+1 + " " + vendeur[i].getNom() + "\n");
		}
		return chaine.toString();
	}
}
