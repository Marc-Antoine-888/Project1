package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //int[][] tab = new int[nblignes][nbcolonnes];
        int[][] tab = {
                {2, 4, 6},
                {1, 3, 5}
        };

        //System.out.println(Arrays.deepToString(tab));

        int[][] tab2 = new int[2][3];

        //tab[1][0] = tab[1][1];

        //System.out.println(tab[0][1]);
        //tab[iLigne][iColonne]
        //System.out.println(Arrays.deepToString(tab));

        int nbLigne = tab.length; //2
        int nbColonne = tab[0].length; //3

        //System.out.println(tab[0][2]);

        final int NB_ETU = 5;
        final int NB_NOTES = 10;

        int[][] tabnotes = new int[NB_ETU][NB_NOTES];

        //affTab(tab);
        //System.out.println(Arrays.toString(tab[0]));
        //parcoursLigne(tab, 0);
        //parcoursLigne(tab, 1);
        parcoursColonne(tab, 0);

    }

    /**
     *Lire les lignes de la colonne
     * 1ère colonne tableau[i][0]
     */
    public static void parcoursColonne(int[][] tableau, int col) {
        for (int iLigne = 0; iLigne < tableau.length; iLigne++){
            System.out.print(tableau[iLigne][col] + " ");
        }
    }

    /**
     * Lire les colonnes à la ligne donnée
     * 2e ligne tableau[1][i]
     */
    public static void parcoursLigne(int[][] tableau, int ligne){
        for (int iCol = 0; iCol < tableau[ligne].length; iCol++) {
            System.out.print(tableau[ligne][iCol] + " ");
        }
    }

    public static void affTab(int[][] tableau){
        int nbLignes = tableau.length; //nombre de lignes
        int nbColonnes = tableau[0].length; //nombre de colonnes

        for (int iLigne = 0; iLigne < nbLignes; iLigne++) { //Parcourir les lignes
            for (int iCol = 0; iCol < nbColonnes; iCol++) { //Parcourir colonnes
                System.out.print(tableau[iLigne][iCol] + " ");
            }
            System.out.println("");
        }

    }

}
