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
	public void recevoirCoup(int forceCoup) {
		assert force >= 0;
		int t = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
	}
		assert t-force > 0;
	}
	
	private void donner(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement ++;
		System.out.println("Le soldat " + nom + " s'equipe d'un " + equipement + " .");
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2 :
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		case 1 :
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " .");
			}
			else {
				donner(equipement);
			}
			break;
		case 0 :
			donner(equipement);
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