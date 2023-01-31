package Grille;

public interface Grille {
	public void afficherGrille();
	public void afficherGrilleConfirm(int... coordinates);
	public String getCase(int... coordinates);
	public void setCase(String symbole, int... coordinates);
	public boolean estPlein();
}
