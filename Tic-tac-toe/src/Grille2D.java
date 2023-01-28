
public class Grille2D {
	private int taille;
	private String[][] mat;
	
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
	
	public String getCase(int ligne, int colonne) {
	    if (ligne < 0 || ligne >= this.taille || colonne < 0 || colonne >= this.taille) {
	        throw new IllegalArgumentException("Les indices de ligne et colonne doivent être compris entre 0 et " + (this.taille - 1));
	    }
	    return this.mat[ligne][colonne];
	}

	public Grille2D (int taille) {
		this.taille = taille;
		this.mat = new String[this.taille][this.taille];
		this.creerMatrice();		
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

	public void afficherGrille2D() {
		for(int n = 0; n < this.taille; n++) {
			System.out.print("| ");
			for(int m = 0; m < this.taille; m++) {
				System.out.print(this.mat[m][n]);	
				System.out.print(" ");
			}
			System.out.println("|");
		}	
	}
	
	public void setCase(int ligne, int colonne, String symbole) {
	    if (ligne < 0 || ligne >= this.taille || colonne < 0 || colonne >= this.taille) {
	        throw new IllegalArgumentException("Les indices de ligne et colonne doivent être compris entre 0 et " + (this.taille - 1));
	    }
	    mat[ligne][colonne] = symbole;
	}

}
