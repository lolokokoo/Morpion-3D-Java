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
		while (!grille.estPlein() && !this.checkWin()) {
			while (!this.demandePositionPion()) { //Si le pion est pas valide on redemande
				this.demandePositionPion();
			}
		}
	}
	@Override
	public boolean demandePositionPion() {
		grille.afficherGrille();
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
	@Override
	public boolean checkWin() {
		if(this.checkWinHoriz() || this.checkWinVert() || this.checkWinDiag()) {
			return true;
		}
	    // changer de joueur si personne ne gagne
	    currentplayer = currentplayer == joueur1 ? joueur2 : joueur1;
		return false;
	}
	
	@Override
	public boolean checkWinVert() {
		//On vérfie sur chacunes de faces 2D
		for (int profondeur = 0; profondeur < this.grille.getTaille(); profondeur++) {
			for (int colonne = 0; colonne < this.grille.getTaille(); colonne++) {
	            int check = 0;
	            for (int ligne = 0; ligne < this.grille.getTaille(); ligne++) {
	                if (currentplayer.getSymbole().equals(this.grille.getCase(ligne, colonne, profondeur))) {
	                    check++; // On compte combien de symboles à la suite il y a
	                }
	                if (check == this.grille.getTaille()) {
	                    return true;
	                }
	            }
	        }
		}
		//On vérfie les combinaison 3D (Exemple combinaison a1 b1 c1)
		for (int ligne = 0; ligne < this.grille.getTaille(); ligne++) {
            int check = 0;
            for (int colonne = 0; colonne < this.grille.getTaille(); colonne++) {
            	for (int profondeur = 0; profondeur < this.grille.getTaille(); profondeur++) {
	                if (currentplayer.getSymbole().equals(this.grille.getCase(ligne, colonne, profondeur))) {
	                    check++; // On compte combien de symboles à la suite il y a
	                }
	                if (check == this.grille.getTaille()) {
	                    return true;
	                }
            	}
            }
		}
		return false;
    }
	@Override
	public boolean checkWinHoriz() {
		//On vérfie sur chacunes de faces 2D
		for (int profondeur = 0; profondeur < this.grille.getTaille(); profondeur++) {
			for (int ligne = 0; ligne < this.grille.getTaille(); ligne++) {
	            int check = 0;
	            for (int colonne = 0; colonne < this.grille.getTaille(); colonne++) {
	                if (currentplayer.getSymbole().equals(this.grille.getCase(ligne, colonne, profondeur))) {
	                    check++; // On compte combien de symboles à la suite il y a
	                }
	                if (check == this.grille.getTaille()) {
	                    return true;
	                }
	            }
			}
		}
		//Pas de combinaison 3D horizontalement
		return false;
	}
	@Override
	public boolean checkWinDiag() {
		//On vérfie sur chacunes de faces 2D
		for (int profondeur = 0; profondeur < this.grille.getTaille(); profondeur++) {
			int check = 0;
			//Diagonale haut-gauche to bas-droite
			for (int indice = 0; indice < this.grille.getTaille(); indice++) {
				if (currentplayer.getSymbole().equals(this.grille.getCase(indice, indice, profondeur))) {
	                check++; // On compte combien de symboles à la suite il y a
	            }
	            if (check == this.grille.getTaille()) {
	                return true;
	            }
			}
			//Diagonale haut-droit to bas-gauche
			check = 0;
			for (int indice = 0; indice < this.grille.getTaille(); indice++) {
				if (currentplayer.getSymbole().equals(this.grille.getCase(indice, this.grille.getTaille() - indice - 1, profondeur))) {
	                check++; // On compte combien de symboles à la suite il y a
	            }
	            if (check == this.grille.getTaille()) {
	                return true;
	            }
			}
		}
		//Combinaisons 3D :
		//Combinaison sur la colonne
		for (int colonne = 0; colonne < this.grille.getTaille(); colonne++) {
			//Combianaison de type (000 101 202) => a1 b4 c7   face devant coin haut gauche to face derriere coin bas gauche
			int check = 0;
			for (int indice = 0; indice < this.grille.getTaille(); indice++) {
				if (currentplayer.getSymbole().equals(this.grille.getCase(indice, colonne, indice))) {
	                check++; // On compte combien de symboles à la suite il y a
	            }
	            if (check == this.grille.getTaille()) {
	                return true;
	            }
			}
			//Combianaison de type (200 101 002) => a7 b4 c1
			int ligne = grille.getTaille() - 1;
			int profondeur = 0;
			check = 0;
			while (ligne != -1) {
				if (currentplayer.getSymbole().equals(this.grille.getCase(ligne, colonne, profondeur))) {
	                check++; // On compte combien de symboles à la suite il y a
	            }
	            if (check == this.grille.getTaille()) {
	                return true;
	            }
	            ligne--;
	            profondeur ++;
			}
		}
		//Les 4 diagonales reliant les coins du cubes : 
		//Diagonales centrale (000 111 222) => a1 b5 c9
		int check = 0;
		for (int indice = 0; indice < this.grille.getTaille(); indice++) {
			if (currentplayer.getSymbole().equals(this.grille.getCase(indice, indice, indice))) {
                check++; // On compte combien de symboles à la suite il y a
            }
            if (check == this.grille.getTaille()) {
                return true;
            }
		}
		//Diagonales centrale (200 111 022) => a7 b5 c3
		check = 0;
		int ligne = this.grille.getTaille() - 1;
		for (int indice = 0; indice < this.grille.getTaille(); indice++) {
			if (currentplayer.getSymbole().equals(this.grille.getCase(ligne, indice, indice))) {
                check++; // On compte combien de symboles à la suite il y a
            }
            if (check == this.grille.getTaille()) {
                return true;
            }
            ligne--;
		}
		//Diagonales centrale (220 111 002) => a9 b5 c1
		check = 0;
		int profondeur = this.grille.getTaille() - 1;
		for (int indice = 0; indice < this.grille.getTaille(); indice++) {
			if (currentplayer.getSymbole().equals(this.grille.getCase(indice, indice, profondeur))) {
                check++; // On compte combien de symboles à la suite il y a
            }
            if (check == this.grille.getTaille()) {
                return true;
            }
            profondeur--;
		}
		//Diagonales centrale (020 111 202) => a3 b5 c7	
		check = 0;
		int colonne = this.grille.getTaille() - 1;
		for (int indice = 0; indice < this.grille.getTaille(); indice++) {
			if (currentplayer.getSymbole().equals(this.grille.getCase(indice, colonne, indice))) {
                check++; // On compte combien de symboles à la suite il y a
            }
            if (check == this.grille.getTaille()) {
                return true;
            }
            colonne--;
		}
		//Si aucune de ces combinaisons
		return false;
	}
}
