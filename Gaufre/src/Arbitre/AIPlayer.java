package Arbitre;

import IHM.EventsCollector;
import ai.AIType;
import ai.AI;
import ai.AIRandom;

public class AIPlayer implements Player {

	AI player;
	
	public AIPlayer(AIType type, EventsCollector c){
		switch(type){
		case RANDOM:
			AIRandom tmp = new AIRandom(c);
			player = tmp;
			break;
		}
	}
	
	@Override
	public void takeTurn(History h, Board gameboard) {
		player.takeTurn(h, gameboard);		
	}

}

