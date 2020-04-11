package Arbitre;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class History {
	List<Move> past;
	List<Move> futur;
	int height;
	int width;
	
	public History(int h, int w) {
		past = new ArrayList<Move>();
		height = h;
		width = w;
	}
	
	public void addMove(Move m) {
		past.add(m);
		futur = null;
	}
	
	public Board undo(int index,Board b) {
		if(index < past.size()) {
			futur = past.subList(index, past.size());
			past = past.subList(0, index);
			b = new Board(height,width);
			for(int i = 0 ; i < index ; i++) {
				b.play(past.get(i).line,past.get(i).column);
			}
			return b;
		}
		return b;
	}
	
	public Board redo(int index,Board b) {
		int size = futur.size();
		if(index < size) {
			Move m;
			for(int i = 0 ; i <= index ; i++) {
				m = futur.get(i);
				past.add(m);
				b.play(m.line, m.column);
			}
			futur = futur.subList(index + 1 , size);
			return b;
		}
		return b;
	}
	

	public void printPast() {
		if(past != null) {
			Iterator<Move> i = past.iterator();
			Move m;
			int j = 0;
			while(i.hasNext()) {
				m = i.next();
				System.out.print(j + ": ");
				System.out.println(m.line + " " + m.column);
				j++;
			}
		}
	}
	
	public void printFutur() {
		if(futur != null) {
			Iterator<Move> i = futur.iterator();
			Move m;
			int j = 0;
			while(i.hasNext()) {
				m = i.next();
				System.out.print(j + ": ");
				System.out.println(m.line + " " + m.column);
				j++;
			}
		}
	}
}
