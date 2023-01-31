package deroulementJeu;

public interface Jeu {
	public void deroulementJeu();
	public boolean demandePositionPion(); //renvoie true si le pion est placé false si l'utilisateur doit re entrer un pion
	public boolean checkWin();
	public boolean checkWinHoriz();
	public boolean checkWinVert();
	public boolean checkWinDiag();
}
