package ai;

import java.util.Random;

import Arbitre.Board;
import Arbitre.History;
import IHM.EventsCollector;

/*
 * Classe AIRandom
 * Joue des coups al�atoires dans la grille game donn� � sa construction.
 * Ne choisis jamais le carr� empoisonn�, sauf si elle n'a pas le choix
 */
public class AIRandom extends AIPlayer {
	
	Random r;
	
	public AIRandom(EventsCollector c) {
		super(c);
		r = new Random();
	}


	@Override
	public void takeTurn(History h, Board gameboard) {
		if (!gameboard.caseValue(0, 1) && !gameboard.caseValue(1, 0)) {
			gameboard.play(0, 0); // Pas d'autre choix
		} else {
			int l, c;
			int lmax = gameboard.get_height(), cmax = gameboard.get_width();
			while (true) {
				// On tire une case � jouer.
				l = r.nextInt(lmax);
				c = r.nextInt(cmax);
				if (c != 0 || l != 0) {
					// Si la case n'est pas celle empoisonn�e..
					if (gameboard.caseValue(l, c)) {
						// Et qu'elle n'a pas �t� mang�e, alors on joue le coup
						gameboard.play(l, c);
						return;
					}
				}
				// Sinon, on tire une nouvelle case.
			}

		}
		// Un probl�me est survenu.
		return;
	}
}
