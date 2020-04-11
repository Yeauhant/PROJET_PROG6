import java.util.Scanner;

import Arbitre.Board;
import Arbitre.ControlMediator;
import Arbitre.History;
import Arbitre.HumanPlayer;
import Arbitre.Move;
import Arbitre.Player;
import IHM.EventsCollector;
import IHM.GraphicInterface;

public class Gauffre {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Board p = new Board(10,10);
		Player p1 = new HumanPlayer();
		Player p2 = new HumanPlayer();
		EventsCollector control = new ControlMediator(p,p1,p2);
		if(true) {
			game(p,control);
		}
		else {
			GraphicInterface.demarrer(p, control);
		}
	}

	private static void game(Board p,EventsCollector control){
		boolean stop = false;
		History h = new History(p.get_height(),p.get_width());
		Scanner s = new Scanner(System.in);
		int line = -1;
		int column = -1;
		boolean goodPlace = false;
		while(!stop) {
			control.sendPlayerCurrent();
			printGame(p);
			System.out.println("voulez vous retourner en arrière ?");
			if(s.nextInt() == 1) {
				h.printPast();
				System.out.println("avant quelle etape ?");
				control.changeGameBoard(h.undo(s.nextInt(),p));
			}
			else {
				System.out.println("voulez vous retourner en avant ?");
				if(s.nextInt() == 1) {
					h.printFutur();
					System.out.println("après quelle etape ?");
					control.changeGameBoard(h.redo(s.nextInt(),p));
				}
				else {
					goodPlace = false;
					while(!goodPlace) {
						System.out.println("entrez la ligne puis la colonne de votre prochain coup");
						line = s.nextInt();
						column = s.nextInt();
						goodPlace = control.MouseClick(line, column);
					}
					h.addMove(new Move(line,column));
					stop = control.endGame();
				}
			}
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
