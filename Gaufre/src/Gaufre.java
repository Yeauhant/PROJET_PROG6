import java.util.Scanner;

import ai.AIType;
import Arbitre.AIPlayer;
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
		History h = new History(p.get_height(),p.get_width());
		EventsCollector control = new ControlMediator(p,h);
		
		System.out.println("Joueur 1 : tapez 1 pour un humain, 0 pour une IA : ");
		if(s.nextInt() == 1) {
			p1 = new HumanPlayer(control,s,"Joueur 1");
		} else {
			p1 = new AIPlayer(AIType.RANDOM, control);
		}
		
		System.out.println("Joueur 2 : tapez 1 pour un humain, 0 pour une IA : ");
		if(s.nextInt() == 1) {
			p2 = new HumanPlayer(control,s,"Joueur 1");
		} else {
			p2 = new AIPlayer(AIType.RANDOM, control);
		}
		
		control.addPlayer1(p1);
		control.addPlayer2(p2);
		if(true) {
			game(control);
			s.close();
		}
		else {
			//GraphicInterface.demarrer(p, control);
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
