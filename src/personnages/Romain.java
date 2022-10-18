package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement equipements[] = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		assert force >= 0;
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	public int getForce() {
		return force;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "'" + texte + "'");
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// precondition
		if (force > 0) {
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		 if (force > 0) {
		 parler("Aie");
		 } else {
		 equipementEjecte = ejecterEquipement();
		 parler("J'abandonne...");
		 }
			// post condition la force a diminuer
		assert force < oldForce;
		return equipementEjecte;
			}
		else return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if ((nbEquipement != 0)) {
		texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de ";
		for (int i = 0; i < nbEquipement;i++) {
			if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
				resistanceEquipement += 8;
			} 
			if ((equipements[i] != null && equipements[i].equals(Equipement.CASQUE))) {
				resistanceEquipement += 5;
			}
		}
		texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup < 0 ) forceCoup = 0;
		return forceCoup;
		}

	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'�quipement de " + nom + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
				}
			}
		return equipementEjecte;
				}

	
	private void donner(Equipement equipement,int position) {
		equipements[position] = equipement;
		nbEquipement ++;
		System.out.println("Le soldat " + nom + " s'equipe d'un " + equipement + " .");
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2 :
			System.out.println("Le soldat " + nom + " est deja bien proteege !");
			break;
		case 1 :
			if ((equipements[0] == equipement) || (equipements[1] == equipement)) {
				System.out.println("Le soldat " + nom + " possede deja un " + equipement + " .");
			}
			else {
				if (equipements[0] == null) donner(equipement,0);
				else donner(equipement,1);
			}
			break;
		case 0 :
			donner(equipement,0);
			break;
		}
	}
	
	public static void main(String[] args) {
		Romain romain = new Romain("Romain",6);
		romain.parler("Je m'apelle ROMAIN");
		romain.recevoirCoup(1);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		romain.sEquiper(Equipement.CASQUE);
		romain.sEquiper(Equipement.CASQUE);
		romain.sEquiper(Equipement.BOUCLIER);
		romain.sEquiper(Equipement.CASQUE);
	}
}
