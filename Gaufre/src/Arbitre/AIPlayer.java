package Arbitre;

import ai.AIType;
import ai.AI;
import ai.AIRandom;

public class AIPlayer implements Player {

	AI player;
	
	
	AIPlayer(AIType type, Board game){
		switch(type){
		case RANDOM:
			player = new AIRandom(game);
			break;
		}
	}
	
	@Override
	public void takeTurn() {
		while(!player.move());
	}

}
