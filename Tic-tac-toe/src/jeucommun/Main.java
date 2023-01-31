package jeucommun;
import Grille.*;
import java.util.Scanner;
import deroulementJeu.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan_choix_jeu = new Scanner(System.in);
		boolean jeu_fini = false;
		boolean saisie_valide = false;
		int taille;
		int choix_jeu;
		do {
			try {
				//On demande la taille de la grille
				System.out.println("Quelle taille de grille ?");
				taille = scan_choix_jeu.nextInt();
				//On demande 2D ou 3D
				System.out.println("Voulez vous jouer en 2D ou en 3D ? Tapez 2 ou 3");
				choix_jeu = scan_choix_jeu.nextInt();
				//Si 3D on lance le jeu 3D
				if (choix_jeu == 3) {
					saisie_valide = true;
					Grille3D grille = new Grille3D(taille);
					Jeu jeu = new Jeu3D(grille);
					jeu.deroulementJeu();
				}
				//Si 2D on lance le jeu 2D
				else if (choix_jeu == 2){
					saisie_valide = true;
					Grille2D grille = new Grille2D(taille);
					Jeu jeu = new Jeu2D(grille);
					jeu.deroulementJeu();
				}
			}
			//Si l'utilisateur ne rentre pas ce qu'il faut on redemande
			catch (Exception e){
		        System.out.println("Veuillez saisir des données valides.");
				scan_choix_jeu.nextLine();
			}
			//Fin de partie, on demande si rejouer
			if (saisie_valide == true) {
				saisie_valide = false;
				do {
					try {
						System.out.println("Voulez vous rejouer ? Tapez 1 pour rejouer, 2 pour arreter");
						int rejouer = scan_choix_jeu.nextInt();
						//Si 2, On arrete le jeu sinon on refait une partie
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
		scan_choix_jeu.close();
	}
}
