package Grille;
import java.util.Scanner;
import jeucommun.Joueur;

/**
 *	Generation d'une grille 2D avec l'interface grille
 */

public class Grille2D implements Grille{
	private int taille;
	private String[][] mat;
	
	/**
     * creation de la grille 3D
     * @param taille taille
     */
	public Grille2D (int taille) {
		this.taille = taille;
		this.mat = new String[this.taille][this.taille];
		int i = 1;
		for(int n = 0; n < this.taille; n++) {
			for(int m = 0; m < this.taille; m++) {
				this.mat[m][n] = Integer.toString(i);
				i += 1;
			}
		}	
	}
	
	public int getTaille() {
		return taille;
	}
	
	public String getCase(int... coordinates) {
		int ligne = coordinates[0];
        int colonne = coordinates[1];
	    if (ligne < 0 || ligne >= this.taille || colonne < 0 || colonne >= this.taille) {
	        throw new IllegalArgumentException("Les indices de ligne et colonne doivent être compris entre 0 et " + (this.taille - 1));
	    }
	    return this.mat[ligne][colonne];
	}

	@Override
	/**
     * Affichage de la grille
     */
	public void afficherGrille() {
		for(int n = 0; n < this.taille; n++) {
			System.out.print("| ");
			for(int m = 0; m < this.taille; m++) {
				System.out.print(this.mat[m][n]);	
				System.out.print(" ");
			}
			System.out.println("|");
		}	
	}
	
	//remplace la case par un ?
	@Override
	/**
	 * Affichage de la grille apres la décision du joueur avec un
	 * point d'interogation la ou il veut jouer son pion
	 */
	public void afficherGrilleConfirm(int... coordinates) {
		int ligne_pion = coordinates[0];
        int colonne_pion = coordinates[1];
		for(int n = 0; n < this.taille; n++) {
			System.out.print("| ");
			for(int m = 0; m < this.taille; m++) {
				if (m == ligne_pion && n == colonne_pion) {
					System.out.print("?");
				}
				else {
					System.out.print(this.mat[m][n]);	
				}
				System.out.print(" ");
			}
			System.out.println("|");
		}	
	}
	@Override
	public void setCase(String symbole, int... coordinates) {
		int ligne = coordinates[0];
        int colonne = coordinates[1];
	    if (ligne < 0 || ligne >= this.taille || colonne < 0 || colonne >= this.taille) {
	        throw new IllegalArgumentException("Les indices de ligne et colonne doivent être compris entre 0 et " + (this.taille - 1));
	    }
	    this.mat[ligne][colonne] = symbole;
	}
	
	/**
	 * verifie la si la grille est pleine.
	 */
	public boolean estPlein() {
	    int stock = 0;
	    for (int ligne = 0; ligne < this.taille; ligne++) {
	        for (int colonne = 0; colonne < this.taille; colonne++) {
	            if (this.getCase(ligne, colonne).equals("X") || this.getCase(ligne, colonne).equals("O")) {
	                stock++;
	            }
	        }
	    }
	    return stock == this.getTaille() * this.getTaille();
	}
	
	/**
	 * Place le pion du joueur courrant au coordonnee chiffre lettre
	 * @param chiffre coordonnee
	 * @param currentplayer joueuer courrant
	 * @return retoune faux si le piont n'est pas placable
	 */
	public boolean placerPion(int chiffre, Joueur currentplayer) {
	    if (chiffre < 1 || chiffre > this.taille * this.taille) {
	        throw new IllegalArgumentException("Le chiffre doit être compris entre 1 et " + this.taille * this.taille);
	    }
	    int colonne = (chiffre - 1) / this.taille;
	    int ligne = (chiffre - 1) % this.taille;	    
	    if (!(this.getCase(ligne, colonne).equals(Integer.toString(chiffre)))) {
	        throw new IllegalArgumentException("La case " + chiffre + " est déjà occupée");
	    }
	    //On demande la confirmation
	    Scanner scan = new Scanner(System.in);
	    boolean verif = false;
	    afficherGrilleConfirm(ligne, colonne);
	    do {
	    	try {
	    		System.out.println("Tapez 1 pour confirmer, 2 pour annuler");
				int confirm = scan.nextInt();
				if (confirm == 1) {
					this.setCase(currentplayer.getSymbole(), ligne, colonne);
					return true;
				}
				else {
					return false;
				}
	    	}catch (Exception e) {
				scan.nextLine();
	    	}
	    }while (verif == false);
	    scan.close();
	    return false;
	}
	
	
}
