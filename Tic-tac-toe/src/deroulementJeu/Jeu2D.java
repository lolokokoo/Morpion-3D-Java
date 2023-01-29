package deroulementJeu;
import java.util.Scanner;
import Grille.Grille2D;
import jeucommun.Joueur;

public class Jeu2D implements Jeu{
	private Grille2D grille;
	Joueur joueur1 = new Joueur("X", "Joueur 1");
	Joueur joueur2 = new Joueur("O", "Joueur 2");
	Joueur currentplayer = joueur2;
	
	public Jeu2D(Grille2D grille) {
		this.grille = grille;
	}
	
	public void deroulementJeu() {
		//On continue de jouer tant que la grille est pas pleine ou que personne n'a gagné
		while (this.checkWin() == false && !grille.estPlein()) {
			this.demandePositionPion();
			grille.afficherGrille();
		}
		String message = this.checkWin() ? "Bravo " + currentplayer.getUsername() : "La grille est pleine, égalité !";
		System.out.println(message);
	}
	
	
	public void demandePositionPion() {
	    Scanner scan = new Scanner(System.in);
	    System.out.println(currentplayer.getUsername() + ", où voulez-vous placer votre pion ? (entrez un numéro de case entre 1 et 9)");
	    System.out.println("Votre symbole : " + currentplayer.getSymbole());
	    try {
	        int position = scan.nextInt();
	        try {
	            grille.placerPion(position, currentplayer);
	        } catch (Exception e) {
	        	grille.afficherGrille();
	            System.out.println("La case est déjà utilisée ou invalide, veuillez réessayer.");
	            demandePositionPion();
	        }
	    } catch (Exception e) {
        	grille.afficherGrille();
	        System.out.println("Veuillez entrer un entier s'il vous plaît.");
	        scan.nextLine();
	        demandePositionPion();
	    } 
	}

	
	private boolean checkWin() {
		if(this.checkWinHoriz() || this.checkWinVert() || this.checkWinDiag()) {
			return true;
		}
	    // changer de joueur si personne ne gagne
	    currentplayer = currentplayer == joueur1 ? joueur2 : joueur1;
		return false;
	}

	private boolean checkWinDiag() {
		int check = 0;
		//Diagonale haut-gauche to bas-droite
		for (int indice = 0; indice < this.grille.getTaille(); indice++) {
			if (currentplayer.getSymbole().equals(this.grille.getCase(indice, indice))) {
                check++; // On compte combien de symboles à la suite il y a
            }
            if (check == this.grille.getTaille()) {
                return true;
            }
		}
		//Diagonale haut-droit to bas-gauche
		check = 0;
		for (int indice = 0; indice < this.grille.getTaille(); indice++) {
			if (currentplayer.getSymbole().equals(this.grille.getCase(indice, this.grille.getTaille() - indice - 1))) {
                check++; // On compte combien de symboles à la suite il y a
            }
            if (check == this.grille.getTaille()) {
                return true;
            }
		}
		return false;
	}

	private boolean checkWinVert() {
		for (int ligne = 0; ligne < this.grille.getTaille(); ligne++) {
            int check = 0;
            for (int colonne = 0; colonne < this.grille.getTaille(); colonne++) {
                if (currentplayer.getSymbole().equals(this.grille.getCase(ligne, colonne))) {
                    check++; // On compte combien de symboles à la suite il y a
                }
                if (check == this.grille.getTaille()) {
                    return true;
                }
            }
        }
        return false;
    }

	private boolean checkWinHoriz() {
		for (int colonne = 0; colonne < this.grille.getTaille(); colonne++) {
            int check = 0;
            for (int ligne = 0; ligne < this.grille.getTaille(); ligne++) {
                if (currentplayer.getSymbole().equals(this.grille.getCase(ligne, colonne))) {
                    check++; // On compte combien de symboles à la suite il y a
                }
                if (check == this.grille.getTaille()) {
                    return true;
                }
            }
        }
        return false;
	}
}
