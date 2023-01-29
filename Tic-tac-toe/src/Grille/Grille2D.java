package Grille;
import jeucommun.Joueur;
public class Grille2D implements Grille{
	private int taille;
	private String[][] mat;
	
	public Grille2D (int taille) {
		this.taille = taille;
		this.mat = new String[this.taille][this.taille];
		this.creerMatrice();		
	}
	
	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public String[][] getMat() {
		return mat;
	}

	public void setMat(String[][] mat) {
		this.mat = mat;
	}
	
	public String getCase(int... coordinates) {
		int ligne = coordinates[0];
        int colonne = coordinates[1];
	    if (ligne < 0 || ligne >= this.taille || colonne < 0 || colonne >= this.taille) {
	        throw new IllegalArgumentException("Les indices de ligne et colonne doivent être compris entre 0 et " + (this.taille - 1));
	    }
	    return this.mat[ligne][colonne];
	}
	
	private void creerMatrice() {
		int i = 1;
		for(int n = 0; n < this.taille; n++) {
			for(int m = 0; m < this.taille; m++) {
				this.mat[m][n] = Integer.toString(i);
				i += 1;
			}
		}
	}

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
	
	public void setCase(String symbole, int... coordinates) {
		int ligne = coordinates[0];
        int colonne = coordinates[1];
	    if (ligne < 0 || ligne >= this.taille || colonne < 0 || colonne >= this.taille) {
	        throw new IllegalArgumentException("Les indices de ligne et colonne doivent être compris entre 0 et " + (this.taille - 1));
	    }
	    mat[ligne][colonne] = symbole;
	}
	
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
	public void placerPion(int chiffre, Joueur currentplayer) {
	    if (chiffre < 1 || chiffre > this.taille * this.taille) {
	        throw new IllegalArgumentException("Le chiffre doit être compris entre 1 et " + this.taille * this.taille);
	    }
	    int colonne = (chiffre - 1) / this.taille;
	    int ligne = (chiffre - 1) % this.taille;	    
	    if (!(this.getCase(ligne, colonne).equals(Integer.toString(chiffre)))) {
	        throw new IllegalArgumentException("La case " + chiffre + " est déjà occupée");
	    }
	    this.setCase(currentplayer.getSymbole(), ligne, colonne);
	}
	
	
}
