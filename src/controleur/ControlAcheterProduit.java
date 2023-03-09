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

	public void acheterProduit(String nomVendeur, int quantiteAcheter) {
		controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).acheterProduit(quantiteAcheter);
	}
	
	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	
	public Gaulois[] trouverVendeurProduit(String nomProduit) {
		Gaulois[] vendeurs;
		vendeurs = village.rechercherVendeursProduit(nomProduit);
		return vendeurs;
	}
	
	public boolean verifierProduitDansMarche(String nomProduit) {
		Gaulois[] vendeurs;
		boolean produitDansMarche;
		vendeurs = village.rechercherVendeursProduit(nomProduit);
		if(vendeurs==null) produitDansMarche = false;
		else produitDansMarche = true;
		return produitDansMarche;
	}
	
	public boolean verifierMarcheNonVide() {
		return village.donnerNbEtal() == 0;
	}
	
	public boolean verifierQuantiteProduit(int quantite, Gaulois vendeur) {
		boolean bonneQuantite;
		if((quantite > village.rechercherEtal(vendeur).getQuantite()) || (quantite < 0)) {
			bonneQuantite = false;
		}
		else {
			bonneQuantite = true;
		}
		return bonneQuantite;
	}
}
