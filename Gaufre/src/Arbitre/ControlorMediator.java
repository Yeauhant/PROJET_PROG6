package Arbitre;

import Arbitre.Board;
import IHM.EvenmentsCollector;

public class ControlorMediator implements EventsCollector{
	Board gameboard;
	Player player1;
	Player player2;
	boolean current;
	
	public ControlorMediator(Board board, Player p1, Player p2) {
		gameboard = board;
		player1 = p1;
		player2 = p2;
	}
	
	@Override
	public boolean MouseClick(int l, int c) {
		while(gameboard.play(l, c));
		playerTurn();
		sendPlayerCurrent();
		if(gameboard.end()) {
			System.out.println("fin");
			return false;
		}
		return true;
	}

	private void sendPlayerCurrent() {
		if(current) {
			System.out.println("joueur 1, c'est � vous !");
		}
		else {
			System.out.println("joueur 2, c'est � vous !");
		}
		
	}

	private void playerTurn() {
		current = !current;
	}
}
