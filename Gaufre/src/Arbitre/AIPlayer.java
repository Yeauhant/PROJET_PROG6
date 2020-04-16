package Arbitre;

import IHM.EventsCollector;
import AI.AIType;
import AI.AIRandom;

public class AIPlayer implements Player {

	Player player;
	
	
	AIPlayer(AIType type, EventsCollector c){
		switch(type){
			case RANDOM:
				player = new AIRandom(c);
				break;
		}
	}
	
	@Override
	public void takeTurn(History h, Board gameboard) {
		while(!player.move());		
	}

	@Override
	public boolean move() {
		return false;
	}

}
