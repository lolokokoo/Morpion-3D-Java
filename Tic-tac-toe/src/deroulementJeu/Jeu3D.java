package deroulementJeu;

import java.util.Scanner;

import Grille.Grille3D;
import jeucommun.Joueur;

public class Jeu3D implements Jeu{

	private Grille3D grille;
	Joueur joueur1 = new Joueur("X", "Joueur 1");
	Joueur joueur2 = new Joueur("O", "Joueur 2");
	Joueur currentplayer = joueur2;
	Scanner scan = new Scanner(System.in);



	public Jeu3D(Grille3D grille) {
		this.grille = grille;
	}
	@Override
	public void deroulementJeu() {
		while (!grille.estPlein()) {
			grille.afficherGrille();
			while (!this.demandePositionPion()) { //Si le pion est pas valide on redemande
				this.demandePositionPion();
			}
		}
	}
	
	public boolean demandePositionPion() {
	    System.out.println(currentplayer.getUsername() + ", où voulez-vous placer votre pion ? Par exemple a1 ");
	    System.out.println("Votre symbole : " + currentplayer.getSymbole());
	    try {
	        String position = scan.nextLine();
	        String lettre = String.valueOf(position.charAt(0)); //On récupére la lettre sous forme de String
	        int nombre = Integer.parseInt(position.substring(1)); //On récupére le nombre
	        try {
	            grille.placerPion(nombre, lettre, currentplayer);
	            return true;
	        } catch (Exception e) {
	        	grille.afficherGrille();
	            System.out.println("La case est déjà utilisée ou invalide, veuillez réessayer.");
	            return false;
	        }
	    } catch (Exception e) {
        	grille.afficherGrille();
	        System.out.println("Veuillez entrer un entier et une lettre valide s'il vous plaît. Par exemple a1");
	        return false;
	    } 
	}
}
