package IA;

import Arbitre.Board;
import Arbitre.History;
import Arbitre.Player;
import IHM.EventsCollector;

public class IAPlayer implements Player{
	EventsCollector control;
	
	public IAPlayer(EventsCollector c) {
		control = c;
	}
	
	@Override
	public void takeTurn(History h, Board gameboard) {	
	}
	
}
