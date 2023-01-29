package Grille;
import jeucommun.Joueur;

public class Grille3D {
    private int taille;
    private String[][][] cube;

    public Grille3D(int taille) {
    	this.taille = taille;
    	this.cube = new String[taille][taille][taille];
    	for (int profondeur = 0; profondeur < taille; profondeur++) {
    		int chiffre = 1;
    		for (int ligne = 0; ligne < taille; ligne++) {
    			for (int colonne = 0; colonne < taille; colonne++) {
		    		cube[ligne][colonne][profondeur] = Integer.toString(chiffre);
		    		chiffre++;
		    	}
	    	}
    	}
    }
    
    public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public String[][][] getCube() {
		return cube;
	}

	public void setCube(String[][][] cube) {
		this.cube = cube;
	}
	
	public void afficherGrille() {
		for (int ligne = 0; ligne < taille; ligne++) {
			System.out.print("| ");
			for (int profondeur = 0; profondeur < taille; profondeur++) {
				for (int colonne = 0; colonne < taille; colonne++) {
					System.out.print(this.cube[ligne][colonne][profondeur]);	
					System.out.print(" ");
		    	}
				System.out.print("| ");
	    	}
			System.out.println();
    	}
	}
	
	public String getCase(int... coordinates) {
		int ligne = coordinates[0];
        int colonne = coordinates[1];
        int profondeur = coordinates[2];
	    if (ligne < 0 || ligne >= this.taille || colonne < 0 || colonne >= this.taille || profondeur < 0 || profondeur >= this.taille) {
	        throw new IllegalArgumentException("Les indices de ligne, colonne et profondeur doivent être compris entre 0 et " + (this.taille - 1));
	    }
	    return this.cube[ligne][colonne][profondeur];
	}
	
	public void setCase(String symbole, int... coordinates) {
		int ligne = coordinates[0];
        int colonne = coordinates[1];
        int profondeur = coordinates[2];
	    if (ligne < 0 || ligne >= this.taille || colonne < 0 || colonne >= this.taille || profondeur < 0 || profondeur >= this.taille) {
	        throw new IllegalArgumentException("Les indices de ligne, colonne et profondeur doivent être compris entre 0 et " + (this.taille - 1));
	    }
	    cube[ligne][colonne][profondeur] = symbole;
	}
}

