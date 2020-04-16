package ai;

import java.util.Random;

import Arbitre.Board;

/*
 * Classe AI_Random
 * Joue des coups al�atoires dans la grille game donn� � sa construction.
 * Ne choisis jamais le carr� empoisonn�, sauf si elle n'a pas le choix
 */
public class AIRandom extends AI {
	Random r;

	public AIRandom(Board game) {
		this.game = game;
		r = new Random();
	}

	@Override
	public boolean move() {
		if (!game.caseValue(0, 1) && !game.caseValue(1, 0)) {
			game.play(0, 0); // Pas d'autre choix
		} else {
			int l, c;
			int lmax = game.get_height(), cmax = game.get_width();
			while (true) {
				// On tire une case � jouer.
				l = r.nextInt(lmax);
				c = r.nextInt(cmax);
				if (c != 0 || l != 0) {
					// Si la case n'est pas celle empoisonn�e..
					if (game.caseValue(l, c)) {
						// Et qu'elle n'a pas �t� mang�e, alors on joue le coup
						game.play(l, c);
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
