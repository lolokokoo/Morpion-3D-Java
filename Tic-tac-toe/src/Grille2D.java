
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
	
	public String getElemMat(int ligne, int colonne) {
		if (ligne >= 0 && colonne >= 0 && ligne < this.taille && colonne < this.taille) {
			return mat[ligne][colonne];
		}
		else return "indinces invalides";
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
}
