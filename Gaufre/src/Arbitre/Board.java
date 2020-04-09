package Arbitre;

public class Board implements Cloneable{
	private boolean tab[][];
	private int height;
	private int width;
	
	
	// tab est initialisé à la taille demandée et remplis de true
	public Board(int height,int width) {
		tab = new boolean[height][width];
		for(int i = 0 ; i < height ; i++) {
			for(int j = 0 ; j < width ; j++) {
				tab[i][j] = true;
			}
		}
		this.height = height;
		this.width = width;
	}
	
	// ligne et colonne sont des indices (0 à hauteur-1 et 0 à largeur-1)
	public boolean caseValue(int line , int column) {
		return tab[line][column];
	}
	
	// ligne et colonne sont des indices
	public boolean play(int line , int column) {
		if(line >= height || line < 0 || column >= height || column < 0) {
			System.out.println("il faut jouer sur le plateau !");
			return false;
		}
		else {
			if(caseValue(line,column)) {
				for(int i = line ; i < height ; i++) {
					for(int j = column ; j < width ; j++) {
						tab[i][j] = false;
					}
				}
				return true;
			}
			else {
				System.out.println("cette case est deja mangee !");
				return false;
			}
		}
	}
	
	public int get_height() {
		return height;
	}
	
	public int get_width() {
		return width;
	}
	
	public boolean end(){
		return !tab[0][0];
	}

	@Override
	public Board clone() {
		try {
			Board res = (Board) super.clone();
			res.tab = tab.clone();
			return res;
		} catch (CloneNotSupportedException e) {
			System.out.println("echec de clonage");
		}
		return null;
	}
}
