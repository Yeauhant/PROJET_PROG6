package IHM;

import Arbitre.Board;

public interface EventsCollector {
	boolean MouseClick(int l, int c);
	boolean endGame();
	void changeGameBoard(Board p);
	void sendPlayerCurrent();
	void playerChange(int index);
}