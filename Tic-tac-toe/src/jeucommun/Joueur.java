package jeucommun;

public class Joueur {
	private String symbole;
	private String username;

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
