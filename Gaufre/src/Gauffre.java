import java.util.Scanner;

import Arbitre.Board;
import Arbitre.ControlMediator;
import Arbitre.HumanPlayer;
import Arbitre.Player;
import IHM.EvenmentsCollector;
import IHM.GraphicInterface;

public class Gauffre {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Board p = new Board(10,10);
		Player p1 = new HumanPlayer();
		Player p2 = new HumanPlayer();
		EvenmentsCollector control = new ControlMediator(p,p1,p2);
		if(true) {
			game(p,control);
		}
		else {
			GraphicInterface.demarrer(p, control);
		}
	}

	private static void game(Board p,EvenmentsCollector control){
		boolean stop = false;
		Scanner s = new Scanner(System.in);
		int line,column;
		boolean goodPlace = false;
		while(!stop) {
			printGame(p);
			goodPlace = false;
			while(!goodPlace) {
				line = s.nextInt();
				column = s.nextInt();
				goodPlace = control.MouseClick(line, column);
			}
			stop = control.endGame();
		}
		System.out.println("fin");
		s.close();
	}

	private static void printGame(Board p) {
		System.out.print("  ");
		for(int j = 0 ; j < p.get_width() ; j++) {
			System.out.print(j + " ");
		}
		System.out.println();
		for(int i = 0 ; i < p.get_height() ; i++) {
			System.out.print(i + " ");
			for(int j = 0 ; j < p.get_height() ; j++) {
				if(p.caseValue(i, j)) {
					System.out.print("1 ");
				}
				else {
					System.out.print("0 ");
				}				
			}
			System.out.println();
		}
	}
}
