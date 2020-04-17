package Arbitre;

import java.util.Scanner;

import IHM.EventsCollector;

public class HumanPlayer implements Player{
	EventsCollector control;
	Scanner entry;
	String name;
	
	public HumanPlayer(EventsCollector c, Scanner s, String n) {
		control = c;
		entry = s;
		name = n;
	}

	@Override
	public void takeTurn(History h, Board p) {
		/*int column = -1;
		int line = -1;
		boolean goodPlace = false;
		control.printGame();
		System.out.println(name);

		System.out.println("voulez vous retourner en arrière ?");

		if(entry.nextInt() == 1) {
			h.printPast();
			System.out.println("avant quelle etape ?");
			control.changeGameBoard(h.undo(entry.nextInt(),p));
		}
		else {
			System.out.println("voulez vous retourner en avant ?");
			if(entry.nextInt() == 1) {
				h.printFutur();
				System.out.println("après quelle etape ?");
				control.changeGameBoard(h.redo(entry.nextInt(),p));
			}
			else {
				while(!goodPlace) {
					System.out.println("entrez la ligne puis la colonne de votre prochain coup");
					line = entry.nextInt();
					column = entry.nextInt();
					goodPlace = control.MouseClick(line, column);
				}
				h.addMove(new Move(line,column));
			}
		}*/
	}

	@Override
	public boolean move() {
		return false;
	}

}
