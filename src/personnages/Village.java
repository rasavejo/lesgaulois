package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois=0;

	public Village(String nom,int nbVillageoisMax) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMax];
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterVillageois(Gaulois g) {
		villageois[nbVillageois] = g;
		nbVillageois ++;
	}
	
	public Gaulois trouverHabitant(int n) {
		return villageois[n];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + chef.getNom() + " habitent :");
		for (int i = 0;i<nbVillageois;i++) {
			System.out.println(villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irreductibles",30);
		// Gaulois gaulois = village.trouverHabitant(30);
		// Erreur car on dépasse du tableau
		Chef abra = new Chef("Abraracourcix",6,1,village);
		village.setChef(abra);
		Gaulois aste = new Gaulois("Asterix",8);
		village.ajouterVillageois(aste);
		Gaulois obe = new Gaulois("Obelix",25);
		village.ajouterVillageois(obe);
		village.afficherVillageois();
		// Gaulois gaulois = village.trouverHabitant(1);
		// System.out.println(gaulois);
		// On obtient NULL car la case 1 est du tableau est inocupé car villageois ne contient qu'Astérix, le chef n'est pas dans le tableau
	}
	
}
