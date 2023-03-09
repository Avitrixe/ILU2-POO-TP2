package frontiere;

import java.util.Scanner;


import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean nomAcheteurConnu = controlAcheterProduit.verifierIdentite(nomAcheteur);
		if(nomAcheteurConnu) {
			System.out.println("Je suis désolé "+ nomAcheteur + " mais il faut être un habitant du village pour commercer içi.");
		}
		else {
			if(controlAcheterProduit.verifierMarcheNonVide() == true) {
				System.out.println("Il n'y a aucun vendeur au marché.");
			}
			else {
				String produit;
				System.out.println("Quelle produit voulez-vous acheter ?");
				produit = scan.next();
				Gaulois[] vendeurs = controlAcheterProduit.trouverVendeurProduit(produit);
				if(vendeurs == null) {
					System.out.println("Aucun marchand ne vend se produit.");
				}
				else {
					System.out.println("Chez quel commercant voulez-vous acheter des " + produit + " ?");
					int j = 1;
					for(int i=0; i<vendeurs.length; i++) {
						System.out.println(j + " " + vendeurs[i].getNom());
						j++;
					}
					int choix_utilisateur = -1;
					while((choix_utilisateur < 1) || (choix_utilisateur > vendeurs.length)) {
						choix_utilisateur = Clavier.entrerEntier(" ");
					}
					System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + vendeurs[choix_utilisateur-1].getNom());
					System.out.println("Bonjour " + nomAcheteur);
					int nombreProduitAcheter = -1;
					while((nombreProduitAcheter < 1) || (controlAcheterProduit.verifierQuantiteProduit(nombreProduitAcheter, vendeurs[choix_utilisateur-1]) == false)){
						nombreProduitAcheter = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
					}
					controlAcheterProduit.acheterProduit(vendeurs[choix_utilisateur-1].getNom(), nombreProduitAcheter);
					System.out.println(nomAcheteur + " a acheté " + nombreProduitAcheter + " de " + produit + " à " + vendeurs[choix_utilisateur-1].getNom());
				}
			}
				
		}
	}
}
