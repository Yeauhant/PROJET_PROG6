package ai;

import Arbitre.Board;
import Arbitre.History;
import Arbitre.Player;
import IHM.EventsCollector;

public class AIPlayer implements Player{
	EventsCollector control;
	
	public AIPlayer(EventsCollector c) {
		control = c;
	}
	
	@Override
	public void takeTurn(History h, Board gameboard) {	
		
	}
	
}
