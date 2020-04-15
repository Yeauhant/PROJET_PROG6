package Arbitre;

import IHM.EventsCollector;

public class ControlMediator implements EventsCollector{
	Board gameboard;
	Player player1;
	Player player2;
	boolean current;
	
	public ControlMediator(Board board,Player p1,Player p2) {
		gameboard = board;
		player1 = p1;
		player2 = p2;
		current = true;
	}
	
	@Override
	public boolean MouseClick(int l, int c) {
		if(gameboard.play(l, c)) {
			if(!gameboard.end()) {
				playerTurn();
			}
			return true;
		}
		return false;
	}

	public boolean endGame() {
		if(gameboard.end()) {
			if(current) {
				System.out.println("joueur 1 vous avez perdu !");
			}
			else {
				System.out.println("joueur 2 vous avez perdu !");
			}
			return true;
		}
		return false;
	}

	@Override
	public void sendPlayerCurrent() {
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

	@Override
	public void changeGameBoard(Board p) {
		gameboard = p;
	}

	@Override
	public void playerChange(int index) {
		current = index % 2 == 0;
	}
}
