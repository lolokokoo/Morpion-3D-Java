package jeucommun;

/**
 * Class joueur permettant l'identification du joueur qui joue
 */
public class Joueur {
	private String symbole;
	private String username;

/**
 * Constructeur spécifique :
 * @param symbole
 * @param username
 */
	public Joueur(String symbole, String username) {
		this.symbole = symbole;
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}

	public String getSymbole() {
		return symbole;
	}
}
