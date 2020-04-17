import java.util.Scanner;

import AI.AIPlayer;
import Arbitre.Board;
import Arbitre.ControlMediator;
import Arbitre.History;
import Arbitre.HumanPlayer;
import Arbitre.Player;
import IHM.EventsCollector;
import IHM.GraphicInterface;

import javax.swing.*;

public class Gaufre {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Board b = new Board(10,20);
		Scanner s = new Scanner(System.in);
		Player p1, p2;
		System.out.println("Voulez-vous mettre une IA ? (0 : Non ; 1 : Oui)");
		History h = new History(b.get_height(), b.get_width());
		EventsCollector control = new ControlMediator(b, h);

		if(s.nextInt() >= 1) {
			p1 = new HumanPlayer(control, s,"Charly");
			p2 = new AIPlayer(control);
		}
		else {
			p1 = new HumanPlayer(control, s,"Bob");
			p2 = new HumanPlayer(control, s,"Alice");
		}
		control.addPlayer1(p1);
		control.addPlayer2(p2);

		GraphicInterface g = new GraphicInterface(b, control);
		SwingUtilities.invokeLater(g);

		game(control);
		s.close();
	}
	
	private static void game(EventsCollector control){
		boolean stop = false;
		while (!stop) {
			control.sendPlayerCurrent();
			stop = control.endGame();
		}
		System.out.println("Fin de la partie.");
	}

}
