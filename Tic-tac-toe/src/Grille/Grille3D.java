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
		//On affiche les lettre correspondant aux num des grilles
		System.out.print("  ");
		for (int i = 0; i <taille; i++) {
			char c = (char) (i + 'a');
			String s = Character.toString(c);
			System.out.print(s);
			int espace = 0;
			while (espace < taille*3 -1) {
				System.out.print(" ");
				espace++;
			}
		}
		System.out.println("");
		//On affiche les n grilles
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
	public void placerPion(int chiffre, String lettre, Joueur currentplayer) {
		
	    int profondeur = lettre - 'a' + 1;
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

