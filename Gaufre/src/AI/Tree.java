package AI;

import java.util.ArrayList;

public class Tree<E> {
	
	private Node<E> root;
	
	public Tree(E element) {
		root = new Node<E>(element);
	}
	
	/* Cette fonction prend un �lement E elm et 
	 * renvoie toutes les occurences de elm dans l'arbre */
	public ArrayList<Node<E>> occurence(E element){
		return occurence(element, root);
	}
	
	private ArrayList<Node<E>> occurence(E element, Node<E> n){
		ArrayList<Node<E>> current = new ArrayList<Node<E>>();
		
		if(n.getElement() == element) current.add(n);
		
		for(int i = 0; i < current.size() ; i++) current.addAll(occurence(element, (Node<E>) n.nodes().get(i)));
		
		return current;
	}
	
	public Node<E> root(){
		return root;
	}
	
	
}
