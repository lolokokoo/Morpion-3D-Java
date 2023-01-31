package Grille;
import jeucommun.Joueur;
import java.util.Scanner;

public class Grille3D implements Grille{
    private int taille;
    private String[][][] cube;

    public Grille3D(int taille) {
    	this.taille = taille;
    	this.cube = new String[taille][taille][taille];
    	for (int profondeur = 0; profondeur < taille; profondeur++) {
    		int chiffre = 1;
    		for (int ligne = 0; ligne < taille; ligne++) {
    			for (int colonne = 0; colonne < taille; colonne++) {
		    		cube[ligne][colonne][profondeur] = Integer.toString(chiffre);
		    		chiffre++;
		    	}
	    	}
    	}
    }
    
    public int getTaille() {
		return taille;
	}

	@Override
	public void afficherGrille() {
		//On affiche les lettre correspondant aux num des grilles
		int espace = 0;
		while (espace < taille/2 -1) {
			System.out.print(" ");
			espace++;
		}
		System.out.print("      ");
		for (int i = 0; i <taille; i++) {
			char c = (char) (i + 'a');
			String s = Character.toString(c);
			System.out.print(s);
			espace = 0;
			while (espace < taille*4) {
				System.out.print(" ");
				espace++;
			}
		}
		System.out.println("");
		//On affiche les n grilles
		for (int ligne = 0; ligne < taille; ligne++) {
			
			for (int profondeur = 0; profondeur < taille; profondeur++) {
				System.out.print("|  ");
				for (int colonne = 0; colonne < taille; colonne++) {
					System.out.print(this.cube[ligne][colonne][profondeur]);	
					System.out.print("  ");
		    	}
				System.out.print("|");
	    	}
			
			System.out.println();
    	}
	}
	
	//remplace la case par un ?
	@Override
	public void afficherGrilleConfirm(int... coordinates) {
		int ligne_pion = coordinates[0];
        int colonne_pion = coordinates[1];
        int profondeur_pion = coordinates[2];
		int espace = 0;
		while (espace < taille/2 -1) {
			System.out.print(" ");
			espace++;
		}
		System.out.print("      ");
		for (int i = 0; i <taille; i++) {
			char c = (char) (i + 'a');
			String s = Character.toString(c);
			System.out.print(s);
			espace = 0;
			while (espace < taille*4) {
				System.out.print(" ");
				espace++;
			}
		}
		System.out.println("");
		//On affiche les n grilles
		for (int ligne = 0; ligne < taille; ligne++) {
			
			for (int profondeur = 0; profondeur < taille; profondeur++) {
				System.out.print("|  ");
				for (int colonne = 0; colonne < taille; colonne++) {
					if (ligne == ligne_pion && colonne == colonne_pion && profondeur == profondeur_pion) {
						System.out.print("?");
					}
					else {
						System.out.print(this.cube[ligne][colonne][profondeur]);	
					}
					System.out.print("  ");
		    	}
				System.out.print("|");
	    	}
			
			System.out.println();
    	}
	}
	@Override
	public String getCase(int... coordinates) {
		int ligne = coordinates[0];
        int colonne = coordinates[1];
        int profondeur = coordinates[2];
	    if (ligne < 0 || ligne >= this.taille || colonne < 0 || colonne >= this.taille || profondeur < 0 || profondeur >= this.taille) {
	        throw new IllegalArgumentException("Les indices de ligne, colonne et profondeur doivent être compris entre 0 et " + (this.taille - 1));
	    }
	    return this.cube[ligne][colonne][profondeur];
	}
	@Override
	public void setCase(String symbole, int... coordinates) {
		int ligne = coordinates[0];
        int colonne = coordinates[1];
        int profondeur = coordinates[2];
	    if (ligne < 0 || ligne >= this.taille || colonne < 0 || colonne >= this.taille || profondeur < 0 || profondeur >= this.taille) {
	        throw new IllegalArgumentException("Les indices de ligne, colonne et profondeur doivent être compris entre 0 et " + (this.taille - 1));
	    }
	    cube[ligne][colonne][profondeur] = symbole;
	}
	
	public boolean placerPion(int chiffre, String lettre, Joueur currentplayer) { 
		char charVar = lettre.charAt(0);
	    int profondeur = charVar - 'a' ; // profondeur = 0 si a, 1 si b, 2 si c ...
	    if (chiffre < 1 || chiffre > this.taille * this.taille || profondeur < 0 || profondeur > this.taille - 1) {
	        throw new IllegalArgumentException("Le chiffre doit être compris entre 1 et " + this.taille * this.taille + "Et la lettre doit être valide");
	    }
	    int ligne = (chiffre - 1) / this.taille;
	    int colonne = (chiffre - 1) % this.taille;
	    if (!(this.getCase(ligne, colonne, profondeur).equals(Integer.toString(chiffre)))) {
	        throw new IllegalArgumentException("La case " + chiffre + " est déjà occupée");
	    }
	    //On demande la confirmation
	    Scanner scan = new Scanner(System.in);
	    boolean verif = false;
	    afficherGrilleConfirm(ligne, colonne, profondeur);
	    do {
	    	try {
	    		System.out.println("Tapez 1 pour confirmer, 2 pour annuler");
				int confirm = scan.nextInt();
				if (confirm == 1) {
					this.setCase(currentplayer.getSymbole(), ligne, colonne, profondeur);
					return true;
				}
				else {
					return false;
				}
	    	}catch (Exception e) {
				scan.nextLine();
	    	}
	    }while (verif == false);
	    scan.close();
	    return false;
	}
	
	@Override
	public boolean estPlein() {
	    int stock = 0;
	    for (int ligne = 0; ligne < this.taille; ligne++) {
	        for (int colonne = 0; colonne < this.taille; colonne++) {
	        	for (int profondeur = 0; profondeur < this.taille; profondeur++) {
	        		if (this.getCase(ligne, colonne, profondeur).equals("X") || this.getCase(ligne, colonne, profondeur).equals("O")) {
		                stock++;
		            }
	        	}
	        }
	    }
	    return stock == this.getTaille() * this.getTaille() * this.getTaille();
	}

	
}

