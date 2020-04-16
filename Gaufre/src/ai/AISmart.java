package ai;

import java.util.Random;
import java.util.Hashtable;

import Arbitre.Board;
import ai.Tree;
import ai.ConfigVector;
import ai.ConfigNode;

/*
 * Classe AISmart
 * 
 * 
 */
public class AISmart extends AI {
	Board game;
	Random r;
	Hashtable<ConfigVector, Node<ConfigNode>> hashVec;
	Tree t;
	
	public AISmart(Board game) {
		this.game = game;
		r = new Random();
		/* création de t et de hashVec, calcul des noeuds et ajout dans la hashtable */
	}

	@Override
	public boolean move() {
		
		//ConfigVector vect = new ConfigVector(game, 1);
		
		return false;
	}
}
