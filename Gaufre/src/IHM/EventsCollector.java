package IHM;

import Arbitre.Board;
import Arbitre.Player;

public interface EventsCollector {
	boolean MouseClick(int l, int c);
	boolean endGame();
	void changeGameBoard(Board p);
	void sendPlayerCurrent();
	void playerChange(int index);
	void playerTurn();
	void printGame();
	void addPlayer1(Player p1);
	void addPlayer2(Player p2);
}