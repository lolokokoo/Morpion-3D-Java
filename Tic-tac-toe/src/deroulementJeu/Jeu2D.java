package deroulementJeu;
import java.util.Scanner;
import Grille.Grille2D;
import jeucommun.Joueur;

/**
 * Gestion du jeu 2D
 */
public class Jeu2D implements Jeu{
	private Grille2D grille;

	Joueur joueur1 = new Joueur("X", "Joueur 1");
	Joueur joueur2 = new Joueur("O", "Joueur 2");
	Joueur currentplayer = joueur1;
    Scanner scan = new Scanner(System.in);
	
    /**
	 * @param grille grille2D
	 */
	public Jeu2D(Grille2D grille) {
		this.grille = grille;
	}
	
	@Override
	/**
	 * La fonction principale qui permet de jouer au morpion.
	 */
	public void deroulementJeu() {
		//On continue de jouer tant que la grille est pas pleine ou que personne n'a gagné
		while (!this.checkWin() && !grille.estPlein()) {
			grille.afficherGrille();
			boolean valider_placement = false;
			while (!valider_placement) { //Si le pion est pas valide on redemande
				valider_placement = this.demandePositionPion();	
			}
			if(!this.checkWin()) {
				currentplayer = currentplayer == joueur1 ? joueur2 : joueur1;
			}
		}
		grille.afficherGrille();
		String message = this.checkWin() ? "Bravo " + currentplayer.getUsername() : "La grille est pleine, égalité !";
		System.out.println(message);
	}
	
	@Override
	/**
	 * Vérifie les coordoonees rentrer par le joueur
	 * @return true si le pion est placable sinon false
	 */
	public boolean demandePositionPion() {
	    System.out.println(currentplayer.getUsername() + ", où voulez-vous placer votre pion ? (entrez un numéro de case entre 1 et 9)");
	    System.out.println("Votre symbole : " + currentplayer.getSymbole());
	    try {
	        int position = scan.nextInt();
	        try {
	        	if (!grille.placerPion(position, currentplayer)) {
	        		grille.afficherGrille();
	        		return false;
	        	}
	            return true;
	        } catch (Exception e) {
	        	grille.afficherGrille();
	            System.out.println("La case est déjà utilisée ou invalide, veuillez réessayer.");
	            scan.nextLine();
	            return false;
	        }
	    } catch (Exception e) {
        	grille.afficherGrille();
	        System.out.println("Veuillez entrer un entier s'il vous plaît.");
	        scan.nextLine();
	        return false;
	    } 
	}

	@Override
	/**
	 * Appelle les trois checkwin
	 * @return true si un des trois checkwin retourne true
	 */
	public boolean checkWin() {
		if(this.checkWinHoriz() || this.checkWinVert() || this.checkWinDiag()) {
			return true;
		}
		return false;
	}
	@Override
	/**
	 * Permet de regerder toute les diagonales pour voir si il y a un vainqueur.
	 * @return true si il existe une combinaison gagnante sur une diagonale sinon false
	 */
	public boolean checkWinDiag() {
		int check = 0;
		//Diagonale haut-gauche to bas-droite
	 	for (int indice = 0; indice < this.grille.getTaille(); indice++) {
			if (currentplayer.getSymbole().equals(grille.getCase(indice, indice))) {
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
	@Override
	/**
	 * Permet de regerder toute les colonnes pour voir si il y a un vainqueur.
	 * @return true si il existe une combinaison gagnante à la verticale sinon false
	 */
	public boolean checkWinVert() {
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
	@Override
	/**
	 * Permet de regerder toute les lignes pour voir si il y a un vainqueur.
	 * @return true si il existe une combinaison gagnante en horizontale sinon false
	 */
	public boolean checkWinHoriz() {
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
