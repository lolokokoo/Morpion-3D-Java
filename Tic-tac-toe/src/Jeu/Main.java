package Jeu;
import deuxDimensions.Grille2D;
import deuxDimensions.Jeu2D;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grille2D Grille = new Grille2D(3);
		Grille.afficherGrille2D();
		Jeu2D jeu = new Jeu2D(Grille);
		jeu.deroulementJeu2D();
	}
}
