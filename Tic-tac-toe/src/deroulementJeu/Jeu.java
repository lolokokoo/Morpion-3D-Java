package deroulementJeu;

/**
 * Interface permettant la gestion d'un jeu de morpion 2d et 3d
 */
public interface Jeu {
	/**
	 * La fonction principale qui permet de jouer au morpion.
	 */
	public void deroulementJeu();
	/**
	 * Vérifie les coordoonees rentrer par le joueur
	 * @return true si le pion est placable sinon false
	 */
	public boolean demandePositionPion(); //renvoie true si le pion est placé false si l'utilisateur doit re entrer un pion
	/**
	 * Appelle les trois checkwin
	 * @return true si un des trois checkwin retourne true
	 */
	public boolean checkWin();
	/**
	 * Permet de regerder toute les lignes pour voir si il y a un vainqueur.
	 * @return true si il existe une combinaison gagnante en horizontale sinon false
	 */
	public boolean checkWinHoriz();
	/**
	 * Permet de regerder toute les colonnes pour voir si il y a un vainqueur.
	 * @return true si il existe une combinaison gagnante à la verticale sinon false
	 */
	public boolean checkWinVert();
	/**
	 * Permet de regerder toute les diagonales pour voir si il y a un vainqueur.
	 * @return true si il existe une combinaison gagnante sur une diagonale sinon false
	 */
	public boolean checkWinDiag();
}
