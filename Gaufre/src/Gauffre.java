import java.util.Scanner;

import Arbitre.Board;
import Arbitre.ControlMediator;
import Arbitre.History;
import Arbitre.HumanPlayer;
import Arbitre.Player;
import IA.IAPlayer;
import IHM.EventsCollector;
import IHM.GraphicInterface;

public class Gauffre {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Board p = new Board(10,10);
		Scanner s = new Scanner(System.in);
		Player p1,p2;
		System.out.println("voulez vous mettre un IA ?");
		History h = new History(p.get_height(),p.get_width());
		EventsCollector control = new ControlMediator(p,h);
		if(s.nextInt() == 1) {
			p1 = new HumanPlayer(control,s,"Jean");
			p2 = new IAPlayer(control);
		}
		else {
			p1 = new HumanPlayer(control,s,"Jean");
			p2 = new HumanPlayer(control,s,"Jacques");
		}
		control.addPlayer1(p1);
		control.addPlayer2(p2);
		if(true) {
			game(control);
			s.close();
		}
		else {
			GraphicInterface.demarrer(p, control);
		}
	}
	
	private static void game(EventsCollector control){
		boolean stop = false;
		while(!stop) {
			control.sendPlayerCurrent();
			stop = control.endGame();
		}
		System.out.println("fin");
	}

}
