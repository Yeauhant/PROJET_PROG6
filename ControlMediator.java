package Arbitre;

import IHM.EvenmentsCollector;

public class ControlMediator implements EvenmentsCollector{
	Board gameboard;
	Player player1;
	Player player2;
	boolean current;
	
	public ControlMediator(Board board,Player p1,Player p2) {
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
			System.out.println("joueur 1, c'est à vous !");
		}
		else {
			System.out.println("joueur 2, c'est à vous !");
		}
		
	}

	private void playerTurn() {
		current = !current;
	}
}
