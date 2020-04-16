package ai;

import Arbitre.Board;
import Arbitre.History;
import IHM.EventsCollector;

public class AI {
	EventsCollector control;
	
	public AI(EventsCollector c) {
		control = c;
	}
	
	public void takeTurn(History h, Board gameboard){
		System.out.println("Pas de comportement d'IA défini.");
	}
}
