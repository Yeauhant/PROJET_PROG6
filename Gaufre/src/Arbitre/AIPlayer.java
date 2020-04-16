package Arbitre;

import IHM.EventsCollector;
import ai.AIType;
import ai.AI;
import ai.AIRandom;

public class AIPlayer implements Player {

	AIPlayer player;
	
	
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

}
