import java.util.Scanner;
public class Jeu2D {
	private Grille2D grille;
	Joueur joueur2 = new Joueur("O", "Joueur 1");
	Joueur joueur1 = new Joueur("X", "Joueur 2");
	Joueur currentplayer = joueur1;
	
	public Jeu2D(Grille2D grille) {
		this.grille = grille;
	}
	
	public void deroulementJeu2D() {
		while (this.checkWin() == false && !this.estPlein()) {
			this.demandePositionPion();
			grille.afficherGrille2D();
		}
		String message = this.checkWin() ? "Bravo " + currentplayer.getUsername() : "La grille est pleine, égalité !";
		System.out.println(message);
	}
	
	
	public void demandePositionPion() {
	    Scanner scan = new Scanner(System.in);
	    System.out.println(currentplayer.getUsername() + ", où voulez-vous placer votre pion ? (entrez un numéro de case entre 1 et 9)");
	    System.out.println("Votre symbole : " + currentplayer.getSymbole());
	    try {
	        int position = scan.nextInt();
	        try {
	            placerPion(position);
	        } catch (Exception e) {
	            System.out.println("La case est déjà utilisée ou invalide, veuillez réessayer.");
	            demandePositionPion();
	        }
	    } catch (Exception e) {
	        System.out.println("Veuillez entrer un entier s'il vous plaît.");
	        scan.nextLine();
	        demandePositionPion();
	    }
	}

	
	private boolean checkWin() {
		if(this.checkWinHoriz() || this.checkWinVert() || this.checkWinDiag()) {
			return true;
		}
	    // changer de joueur
	    currentplayer = currentplayer == joueur1 ? joueur2 : joueur1;
		return false;
	}

	private boolean checkWinDiag() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean checkWinVert() {
		for (int ligne = 0; ligne < this.grille.getTaille(); ligne++) {
            int check = 0;
            for (int colonne = 0; colonne < this.grille.getTaille(); colonne++) {
                if (currentplayer.getSymbole().equals(this.grille.getCase(ligne, colonne))) {
                    check++; // On compte combien de symboles à la suite il y a
                }
                if (check == this.grille.getTaille()) {
                    return true;
                }
            }
        }
        return false;
    }


	private boolean checkWinHoriz() {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean estPlein() {
	    int stock = 0;
	    for (int ligne = 0; ligne < this.grille.getTaille(); ligne++) {
	        for (int colonne = 0; colonne < this.grille.getTaille(); colonne++) {
	            if (this.grille.getCase(ligne, colonne).equals(joueur1.getSymbole()) || this.grille.getCase(ligne, colonne).equals(joueur2.getSymbole())) {
	                stock++;
	            }
	        }
	    }
	    return stock == this.grille.getTaille() * this.grille.getTaille();
	}
	
	public void placerPion(int chiffre) {
	    if (chiffre < 1 || chiffre > this.grille.getTaille() * this.grille.getTaille()) {
	        throw new IllegalArgumentException("Le chiffre doit être compris entre 1 et " + this.grille.getTaille() * this.grille.getTaille());
	    }
	    int colonne = (chiffre - 1) / this.grille.getTaille();
	    int ligne = (chiffre - 1) % this.grille.getTaille();	    
	    if (!(this.grille.getCase(ligne, colonne).equals(Integer.toString(chiffre)))) {
	        throw new IllegalArgumentException("La case " + chiffre + " est déjà occupée");
	    }
	    this.grille.setCase(ligne, colonne, currentplayer.getSymbole());
	}
	
	
	
}
