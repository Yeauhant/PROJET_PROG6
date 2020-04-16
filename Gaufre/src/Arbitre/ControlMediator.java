package Arbitre;

import IHM.EventsCollector;

public class ControlMediator implements EventsCollector{
	Board gameboard;
	Player player1;
	Player player2;
	boolean current;
	History h;
	
	public ControlMediator(Board board,History h) {
		gameboard = board;
		current = true;
		this.h = h;
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
			player1.takeTurn(h,gameboard);
		}
		else {
			player2.takeTurn(h,gameboard);
		}
	}

	@Override
	public void playerTurn() {
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


	@Override
	public void printGame() {
		System.out.print("  ");
		for(int j = 0 ; j < gameboard.get_width() ; j++) {
			System.out.print(j + " ");
		}
		System.out.println();
		for(int i = 0 ; i < gameboard.get_height() ; i++) {
			System.out.print(i + " ");
			for(int j = 0 ; j < gameboard.get_height() ; j++) {
				if(gameboard.caseValue(i, j)) {
					System.out.print("1 ");
				}
				else {
					System.out.print("0 ");
				}				
			}
			System.out.println();
		}
	}

	@Override
	public void addPlayer1(Player p1) {
		player1 = p1;
	}

	@Override
	public void addPlayer2(Player p2) {
		player2 = p2;
	}
}
