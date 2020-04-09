package Arbitre;

public class Plateau {
	private boolean tab[][];
	private int hauteur;
	private int largeur;
	
	
	// tab est initialisé à la taille demandée et remplis de true
	public Plateau(int hauteur,int largeur) {
		tab = new boolean[hauteur][largeur];
		for(int i = 0 ; i < hauteur ; i++) {
			for(int j = 0 ; j < largeur ; j++) {
				tab[i][j] = true;
			}
		}
		this.hauteur = hauteur;
		this.largeur = largeur;
	}
	
	// ligne et colonne sont des indices (0 à hauteur-1 et 0 à largeur-1)
	public boolean valeur_case(int ligne , int colonne) {
		return tab[ligne][colonne];
	}
	
	// ligne et colonne sont des indices
	public void jouer(int ligne , int colonne) {
		if(ligne >= hauteur || ligne < 0 || colonne >= largeur || colonne < 0) {
			System.out.println("il faut jouer sur le plateau !");
		}
		if(valeur_case(ligne,colonne)) {
			for(int i = ligne ; i < hauteur ; i++) {
				for(int j = colonne ; j < largeur ; j++) {
					tab[i][j] = false;
				}
			}
		}
		else {
			System.out.println("cette case est deja mangée !");
		}
	}
	
	public boolean fini(){
		return !tab[0][0];
	}

}
