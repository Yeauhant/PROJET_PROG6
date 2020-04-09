package ai;

import java.util.Random;
import Arbitre.Plateau;

/*
 * Classe AI_Random
 * Joue des coups al�atoires dans la grille game donn� � sa construction.
 * Ne choisis jamais le carr� empoisonn�, sauf si elle n'a pas le choix
 */
public class AI_Random extends AI{
	Random r;
	
	public AI_Random(Plateau game){
		this.game = game;
		r = new Random();
	}

	@Override
	boolean move() {
		if(!game.valeur_case(0, 1) && !game.valeur_case(1, 0)){
			game.jouer(0, 0); // Pas d'autre choix
		} else {
			int l, c;
			int lmax = game.get_hauteur(), cmax = game.get_largeur();
			while(true){
				// On tire une case � jouer.
				l = r.nextInt(lmax);
				c = r.nextInt(cmax);
				if(c != 0 || l != 0){
					// Si la case n'est pas celle empoisonn�e..
					if(game.valeur_case(l, c)){
						// Et qu'elle n'a pas �t� mang�e, alors on joue le coup
						game.jouer(l, c);
						return true;
					}
				}
				// Sinon, on tire une nouvelle case.
			}
			
		}
		// Un probl�me est survenu.
		return false;
	}
}
