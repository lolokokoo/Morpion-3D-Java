package Grille;

/**
 *	Interface permettant la gestion des grilles du jeu du morpion avec les fonctions :
 *	- Affichage de la grille avant placement du joueur
 *	- Affichage de la grille modifier pour demander à l'utilisateur la confirmation de son placement
 *	- Placement du pion sur la grille 
 *	- Vérification si la grille est pleine 
 */

public interface Grille {
	/**
     * Affichage de la grille
     */
	public void afficherGrille();
	/**
	 * Affichage de la grille après la décision du joueur avec un
	 * point d'intérogation la où il veut jouer son pion
	 * @param coordinates coordonne a verifier
	 */
	public void afficherGrilleConfirm(int... coordinates);
	/**
	 * @param coordinates coordonnee
	 * @return le contenue de la case
	 */
	public String getCase(int... coordinates);
	/**
	 * @param symbole nouveau contenue de la case
	 * @param coordinates coordonnee
	 */
	public void setCase(String symbole, int... coordinates);
	/**
	 * vérifie la si la grille est pleine.
	 * @return true si la grille est pleine
	 */
	public boolean estPlein();
}
