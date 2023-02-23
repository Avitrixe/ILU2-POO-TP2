package frontiere;

import controleur.ControlLibererEtal;
import villagegaulois.Etal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if(!vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		}
		else {
			String[] etalOccupe = controlLibererEtal.libererEtal(nomVendeur);
			if(etalOccupe[0] == "true") {
				System.out.println("Vous avez vendu " + etalOccupe[4] + " sur " + etalOccupe[3] + " " + etalOccupe[2] + ".");
				System.out.println("En revoir " + nomVendeur + ", passez une bonne journée !");
			}
		}
	}

}
