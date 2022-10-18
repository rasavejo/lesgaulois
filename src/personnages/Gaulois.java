package personnages;


public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees = 0;
	private Equipement trophees[] = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "'" + texte + "'");
	}
	
	private String prendreParole() {
	return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesObtenu = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesObtenu != null && i < tropheesObtenu.length; i++,nbTrophees++) {
		this.trophees[nbTrophees] = tropheesObtenu[i];
		}
		}
		

	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + String.valueOf(forcePotion) + " fois decuplee");
	}
	
	public void faireUneDonation(Musee musee) {
		if (nbTrophees > 0) parler("Je donne au musee tous mes trophees :");
		for (int i = 0;i<nbTrophees;i++) {
			musee.donnerTrophee(this, trophees[i]);
			System.out.println("-" + trophees[i].toString());
			trophees[i] = null;
		}
		nbTrophees = 0;
	}
	
	
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force
		+ ", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix",8);
		System.out.println(asterix.getNom());
		asterix.parler("WOUHOU");
		Romain romain = new Romain("Romain",1);
		asterix.frapper(romain);
		asterix.boirePotion(3);
	}
}
