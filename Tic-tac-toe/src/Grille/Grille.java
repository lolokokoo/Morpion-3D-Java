package Grille;

public interface Grille {
	public void afficherGrille();
	String getCase(int... coordinates);
	void setCase(String symbole, int... coordinates);
	public boolean estPlein();
}
