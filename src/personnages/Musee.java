package personnages;

public class Musee {
	private Trophee[] tableauTrophee = new Trophee[200];
	private int nbTrophee = 0;
	
	public void donnerTrophee(Gaulois gaulois,Equipement equipement) {
		Trophee trophee = new Trophee(gaulois,equipement);
		tableauTrophee[nbTrophee] = trophee;
		nbTrophee ++;
	}
	
	public String extraireInstructionCaml() {
		String texte = "let musee = [\n";
		for (int i=0;i<nbTrophee;i++) {
			texte +="\"";
			texte += tableauTrophee[i].donnerNom();
			texte += "\", \"";
			texte += tableauTrophee[i].getEquipement().toString();
			texte += "\"";
			if (i==nbTrophee-1) texte += ";";
			texte += "\n";
		}
		texte += "]";
		return texte;
	}
}
