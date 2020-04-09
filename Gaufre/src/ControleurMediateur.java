package Arbitre;

import IHM.CollecteurEvenements;

public class ControleurMediateur implements CollecteurEvenements{
	Plateau jeu;
	
	public ControleurMediateur(Plateau p) {
		jeu = p;
	}
	
	@Override
	public void clicSouris(int l, int c) {
		jeu.jouer(l, c);
		if(jeu.fini()) {
			System.out.println("fin");
		}
	}
}
