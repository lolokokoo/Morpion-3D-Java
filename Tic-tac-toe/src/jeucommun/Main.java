package jeucommun;
import Grille.*;
import deroulementJeu.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Grille2D Grille = new Grille2D(2);
		//Jeu jeu = new Jeu2D(Grille);
		//jeu.deroulementJeu();
		Grille3D grille = new Grille3D(2);
		Jeu3D jeu = new Jeu3D(grille);
		jeu.deroulementJeu();
	}
}
