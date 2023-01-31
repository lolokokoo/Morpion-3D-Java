package jeucommun;
import Grille.*;
import java.util.Scanner;
import deroulementJeu.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Grille2D Grille = new Grille2D(2);
		//Jeu jeu = new Jeu2D(Grille);
		//jeu.deroulementJeu();
		//Grille3D grille = new Grille3D(2);
		//Jeu3D jeu = new Jeu3D(grille);
		//jeu.deroulementJeu();
		
		Scanner scan_choix_jeu = new Scanner(System.in);
		boolean jeu_fini = false;
		boolean saisie_valide = false;
		int taille;
		int choix_jeu;
		do {
			try {
				System.out.println("Quelle taille de grille ?");
				taille = scan_choix_jeu.nextInt();
				System.out.println("Voulez vous jouer en 2D ou en 3D ? Tapez 2 ou 3");
				choix_jeu = scan_choix_jeu.nextInt();
				if (choix_jeu == 3) {
					saisie_valide = true;
					Grille3D grille = new Grille3D(taille);
					Jeu jeu = new Jeu3D(grille);
					jeu.deroulementJeu();
				}
				else if (choix_jeu == 2){
					saisie_valide = true;
					Grille2D grille = new Grille2D(taille);
					Jeu jeu = new Jeu2D(grille);
					jeu.deroulementJeu();
				}
			}
			catch (Exception e){
		        System.out.println("Veuillez saisir des données valides.");
				scan_choix_jeu.nextLine();
			}
			
			if (saisie_valide == true) {
				saisie_valide = false;
				do {
					try {
						System.out.println("Voulez vous rejouer ? Tapez 1 pour rejouer, 2 pour arreter");
						int rejouer = scan_choix_jeu.nextInt();
						if (rejouer == 2) {
							jeu_fini = true;
						}
						saisie_valide = true;
					} catch (Exception e) {
						System.out.println("Veuillez saisir des données valides.");
						saisie_valide = false;
						scan_choix_jeu.nextLine();
					}
				} while (!saisie_valide);
			}
		}while (!jeu_fini || !saisie_valide);
	
	}
}
