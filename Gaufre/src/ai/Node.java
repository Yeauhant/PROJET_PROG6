package ai;

import java.util.ArrayList;

public class Node<E> {

	private E element;
	private ArrayList<Node<E>> nodes;
	
	/* Constructeur */
	public Node(E elm) {
		element = elm;
		nodes = new ArrayList<Node<E>>();
	}
	
	/* Renvoie l'élement du noeud */
	public E getElement() {
		return element;
	}
	
	/* Renvoie la liste des fils du noeud*/
	public ArrayList<Node<E>> nodes(){
		return nodes;
	}
	
	/* Renvoie un noeud à la liste des fils */
	public void addNode(E element) {
		nodes.add(new Node<E>(element));
	}
	
	/* Test si deux noeuds sont égaux c'est à dire si ils ont le même élément */
	public boolean equals(Node<E> n) {
		return (element == n.element);
	}
	
	/* Renvoie l'élément du noeud en String */
	public String toString() {
		return element.toString();
	}
	
}
