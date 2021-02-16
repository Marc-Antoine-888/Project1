package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] tableau = new int[3][3];
        int[][] tableau2 = new int[3][3];
        String[][] tableau3 = new String[3][4];
        initTen(tableau);
        System.out.println(Arrays.deepToString(tableau));
        System.out.println(isTabCarre(tableau));
        System.out.println(isTabDimEgal(tableau, tableau2));
        initPosition(tableau3);
        System.out.println(Arrays.deepToString(tableau3));
    }

    public static void initTen(int[][] tab) {
        int nbLignes = tab.length;
        int nbColonnes = tab[0].length;

        for (int iLigne = 0; iLigne < nbLignes; iLigne++) {
            for (int iCol = 0; iCol < nbColonnes; iCol++)
                tab[iLigne][iCol] = 10;
        }
    }

    public static void initPosition(String[][] tab) {
        int nbLignes = tab.length;
        int nbColonnes = tab[0].length;

        for (int iLigne = 0; iLigne < nbLignes; iLigne++) {
            for (int iCol = 0; iCol < nbColonnes; iCol++)
                tab[iLigne][iCol] = iLigne + ":" + iCol;
        }
    }

    public static boolean isTabCarre(int[][] tab) {
        boolean isCarre = false;
        int nbLignes;
        int nbColonnes;

        nbLignes = tab.length;
        nbColonnes = tab[0].length;

        if (nbColonnes == nbLignes) {
            isCarre = true;
        }
        return isCarre;
    }

    public static boolean isTabDimEgal(int[][] tab, int[][] tab2) {
        boolean isEgal = false;
        int tabLigne;
        int tabColonne;
        int tab2Ligne;
        int tab2Colonne;

        tabColonne = tab[0].length;
        tabLigne = tab.length;
        tab2Colonne = tab2[0].length;
        tab2Ligne = tab2.length;

        if (tabColonne == tab2Colonne && tabLigne == tab2Ligne) {
            isEgal = true;
        }
        return isEgal;
    }

}
