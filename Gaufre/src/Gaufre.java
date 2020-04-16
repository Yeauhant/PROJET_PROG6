import java.util.Scanner;

import ai.AIPlayer;
import Arbitre.Board;
import Arbitre.ControlMediator;
import Arbitre.History;
import Arbitre.HumanPlayer;
import Arbitre.Player;
import IHM.EventsCollector;
import IHM.GraphicInterface;

public class Gaufre {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Board p = new Board(10,10);
		Scanner s = new Scanner(System.in);
		Player p1,p2;
		System.out.println("voulez vous mettre un IA ?");
		History h = new History(p.get_height(),p.get_width());
		EventsCollector control = new ControlMediator(p,h);
		if(s.nextInt() == 1) {
			p1 = new HumanPlayer(control);
			p2 = new AIPlayer(control);
		}
		else {
			p1 = new HumanPlayer(control);
			p2 = new HumanPlayer(control);
		}
		control.addPlayer1(p1);
		control.addPlayer2(p2);
		s.close();
		if(true) {
			game(control);
		}
		else {
			//GraphicInterface.demarrer(p, control);
		}
	}
	
	private static void game(EventsCollector control){
		boolean stop = false;
		while(!stop) {
			control.sendPlayerCurrent();
			control.playerTurn();
		}
		System.out.println("fin");
	}

}
