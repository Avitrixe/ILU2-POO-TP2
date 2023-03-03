package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean nomAcheteurConnu = controlAcheterProduit.verifierIdentite(nomAcheteur);
		if(nomAcheteurConnu) {
			System.out.println("Je suis d�sol�e "+ nomAcheteur + " mais il faut �tre un habitant du village pour commercer i�i.");
		}
		else {
			String produit;
			System.out.println("Quelle produit voulez-vous acheter ?");
			produit = scan.next();
			System.out.println("Chez quel commercant voulez-vous acheter des " + produit + " ?");
			System.out.println(controlAcheterProduit.trouverEtalProduit(produit));
			
		}
	}
}
