package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String infosMarche[] = controlAfficherMarche.donnerInfosMarche();
		if(infosMarche.length == 0) {
			System.out.println("Le march� est vide, revenez plus tard.");
		}
		else {
			System.out.println(nomAcheteur + " vous trouverez au march�:\n");
			int i = 0;
			while(i < infosMarche.length) {
				System.out.println("- " + infosMarche[i ++] + " qui vend " + infosMarche[i ++] + " " + infosMarche[i ++]);
			}
		}

	}
}
