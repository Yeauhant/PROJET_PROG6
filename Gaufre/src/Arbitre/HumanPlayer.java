package Arbitre;

import java.util.Scanner;

import IHM.EventsCollector;

public class HumanPlayer implements Player{
	EventsCollector control;
	
	public HumanPlayer(EventsCollector c) {
		control = c;
	}

	@Override
	public void takeTurn(History h, Board p) {
		int column = -1;
		int line = -1;
		boolean goodPlace = false;
		Scanner s = new Scanner(System.in);
		control.printGame();
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
				while(!goodPlace) {
					System.out.println("entrez la ligne puis la colonne de votre prochain coup");
					line = s.nextInt();
					column = s.nextInt();
					goodPlace = control.MouseClick(line, column);
				}
				h.addMove(new Move(line,column));
			}
		}
		s.close();
	}
	
}
