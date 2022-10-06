package personnages;

public class Romain {
	private String nom;
	private int force;
	
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
	
	public static void main(String[] args) {
		Romain romain = new Romain("Romain",6);
		romain.parler("Je m'apelle ROMAIN");
		romain.recevoirCoup(1);
	}
}