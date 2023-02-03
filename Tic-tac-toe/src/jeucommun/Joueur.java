package jeucommun;

/**
 * Class joueur permettant l'identification du joueur qui joue
 */
public class Joueur {
	private String symbole;
	private String username;

/**
 * Constructeur spécifique :
 * @param symbole symbole du joueur
 * @param username identifiant pour diférencier les joueurs
 */
	public Joueur(String symbole, String username) {
		this.symbole = symbole;
		this.username = username;
	}
	
	/**
	 * 
	 * @return retourne le username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @return retourne le symbole
	 */
	public String getSymbole() {
		return symbole;
	}
}
