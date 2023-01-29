package jeucommun;
import Grille.*;
import deroulementJeu.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grille2D Grille = new Grille2D(3);
		Grille.afficherGrille();
		Jeu jeu = new Jeu2D(Grille);
		jeu.deroulementJeu();
		//Grille3D Grille = new Grille3D(3);
		//Grille.afficherGrille();
		//System.out.println(a[0][1][0]);
	}
}
