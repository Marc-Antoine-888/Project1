package com.company;

import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");
        int[][] tab = {
                {76, 68, 81, 91, 65, 96, 107, 94, 98, 107, 96, 130},
                {55, 51, 59, 65, 66, 67, 69, 82, 72, 61, 72, 67},
                {71, 63, 70, 72, 76, 90, 89, 96, 89, 80, 92, 92},
                {87, 68, 84, 84, 78, 78, 95, 91, 73, 89, 86, 102},
        };
        String[] ville = {"Québec", "Toronto", "Joliette", "Gaspé"};
        afficherTab(tab);
        System.out.println();

        for (int i=0; i< tab.length; i++){
            System.out.println("Total " + ville[i] + ": " + sommeUneLigne(tab,i));
        }
        System.out.println();

        for (int i=0; i< tab.length; i++){
            System.out.println("Moyenne " + ville[i] + ": " + df.format(moyenneUneLigne(tab,i)));
        }
        System.out.println();

        for (int i=0; i< tab.length; i++){
            System.out.println("Max " + ville[i] + ": " + maxLigne(tab,i));
        }
        System.out.println();

        for (int i=0; i< tab.length; i++) {
            System.out.println("Min " + ville[i] + ": " + minLigne(tab, i));
        }
    }

    public static void afficherTab(int[][] tab){
        int nbLignes = tab.length;
        int nbColonnes = tab[0].length;

        for (int iLigne = 0; iLigne < nbLignes; iLigne++) {
            for (int iCol = 0; iCol < nbColonnes; iCol++)
                System.out.print(tab[iLigne][iCol] + " ");
            System.out.println();
        }
    }

    public static int sommeUneLigne(int[][] tab, int ligne){
        int somme=0;

        for (int iCol = 0; iCol < tab[ligne].length; iCol++)
            somme = somme + tab[ligne][iCol];
        return somme;
    }

    public static double moyenneUneLigne(int[][] tab, int ligne){
        double moyenne=0;

        for (int iCol = 0; iCol < tab[ligne].length; iCol++)
            moyenne = moyenne + tab[ligne][iCol];
        moyenne = moyenne / tab[ligne].length;

        return moyenne;
    }

    public static int maxLigne(int[][] tab, int ligne){
        int iMax=0;
        int nMax=0;

        for (int i = 0; i < tab[ligne].length-1; i++){
            iMax=i;
            nMax=(tab[ligne][i]);
            for (int j = i+1; j < tab[ligne].length; j++){
                if ((tab[ligne][j]) > (tab[ligne][iMax])){
                    iMax=j;
                }
                nMax = (tab[ligne][j]);
            }
            if (iMax !=i) {
                permute(tab,ligne,iMax,i);
            }
        }
        nMax=(tab[ligne][0]);
        return nMax;
    }

    public static int minLigne(int[][] tab, int ligne){
        int iMin=0;
        int nMin=0;

        for (int i = 0; i < tab[ligne].length-1; i++){
            iMin=i;
            nMin=(tab[ligne][i]);
            for (int j = i+1; j < tab[ligne].length; j++){
                if ((tab[ligne][j]) < (tab[ligne][iMin])){
                    iMin=j;
                }
                nMin = (tab[ligne][j]);
            }
            if (iMin !=i) {
                permute(tab,ligne,iMin,i);
            }
        }
        nMin=(tab[ligne][0]);
        return nMin;
    }

    public static void permute(int[][] tab, int ligne, int i1, int i2){
        int permute = tab[ligne][i1];
        tab[ligne][i1] = tab[ligne][i2];
        tab[ligne][i2] = permute;
    }
}
