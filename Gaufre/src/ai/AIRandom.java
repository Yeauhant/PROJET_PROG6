package ai;

import java.util.Random;

import ai.AI;
import Arbitre.Board;
import Arbitre.History;
import Arbitre.Move;
import IHM.EventsCollector;

/*
 * Classe AIRandom
 * Joue des coups aléatoires dans la grille game donné à sa construction.
 * Ne choisis jamais le carré empoisonné, sauf si elle n'a pas le choix
 */
public class AIRandom extends AI {
	Random r;
	
	public AIRandom(EventsCollector c) {
		super(c);
		r = new Random();
	}

	public void takeTurn(History h, Board gameboard) {
		if (!gameboard.caseValue(0, 1) && !gameboard.caseValue(1, 0)) {
			gameboard.play(0, 0); // Pas d'autre choix
		} else {
			int l, c;
			int lmax = gameboard.get_height(), cmax = gameboard.get_width();
			while (true) {
				// On tire une case à jouer.
				l = r.nextInt(lmax);
				c = r.nextInt(cmax);
				if (c != 0 || l != 0) {
					// Si la case n'est pas celle empoisonnée..
					if (gameboard.caseValue(l, c)) {
						// Et qu'elle n'a pas été mangée, alors on joue le coup
						System.out.println("IA : coup joué en " + l + ", " + c);
						gameboard.play(l, c);
						h.addMove(new Move(l,c));
						control.playerTurn();
						return;
					}
				}
				// Sinon, on tire une nouvelle case.
			}

		}
		// Un problème est survenu.
		return;
	}
}
