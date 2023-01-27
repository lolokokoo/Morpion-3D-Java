
public class Jeu2D {
	private Grille2D grille;
	Joueur joueur1 = new Joueur("X");
	Joueur joueur2 = new Joueur("O");
	Joueur currentplayer = joueur1;
	
	public Jeu2D(Grille2D grille) {
		this.grille = grille;
	}
	
	private boolean checkWin() {
		if(this.checkWinHoriz() || this.checkWinVert() || this.checkWinDiag()) {
			return true;
		}
		return false;
	}

	private boolean checkWinDiag() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean checkWinVert() {
		for(int colonne = 0; colonne < this.grille.getTaille(); colonne++) {
			int check = 0;
			for(int ligne = 0; ligne < this.grille.getTaille(); ligne++) {
				if (currentplayer.getSymbole() == this.grille.getElemMat(ligne, colonne)) {
					check += 1; //On compte combien de symbole à la suite il y'a
				}
			}
			//Si il y en a autant que la taille de la grille c'est gagné
			if (check == this.grille.getTaille()) {
				return true;
			}
		}
		//Si aucunes colones gagne on renvoie false
		return false;
	}

	private boolean checkWinHoriz() {
		// TODO Auto-generated method stub
		return false;
	}


}
