package ai;

import java.util.Vector;

import Arbitre.Board;

/*
 * Classe ConfigVector
 * Construit le vecteur de bits associés à la configuration donnée en argument.
 * Nécessite un plateau et l'id du joueur courant :
 * 1 si c'est le tour de celui qui construit le vecteur, 0 sinon
 */

public class ConfigVector {

	Vector<Character> Vect;
	
	public ConfigVector(Board Game, char Turn){
		Vect = new Vector<Character>(Game.get_height()+Game.get_width()+1);
		
		Assemble(Game, Turn);		
	}
	
	private void Assemble(Board Game, char Turn){
		Vect.add(Turn);
		
		/*
		 * On construit le profil en parcourant le plateau.
		 * On commence en bas à gauche.
		 * S'il y a encore une case, on place 0 dans le vecteur et avance
		 * vers la droite.
		 * Sinon, on y ajoute 1 et on va vers le haut.
		 */
		int l = Game.get_height(), c = 0;
		
		while (l >= 0 && c < Game.get_width()){
			/* On est tout en haut. On va à droite. */
			if(l < 0){
				Vect.add((char) 0);
				c++;
			}
			/* On est tout à droite. On va en haut. */
			else if (c >= Game.get_width()) {
				Vect.add((char) 1);
				l--;
			}
			/* Sinon, on regarde s'il y a un carré de gaufre ici. */
			else {
				if(Game.caseValue(l, c)){
					Vect.add((char) 0);
					c++;					
				} else {
					Vect.add((char) 1);
					l--;
				}
			}
			
		}
		
	}
	
}
