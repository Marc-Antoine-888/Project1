package com.company;

public class Main {

    public static void main(String[] args) {
        int[] tableau = {-5, -2, -1, 0, 2, 8, 9, 10, 12, 40};
        int valeur = 9;
        int result = 0;

        result = fouilleDichotomique(tableau, valeur);

        System.out.println(result);
    }

    public static int fouilleDichotomique(int[] tableau, int valeur) {
        int debut = 0;
        int fin = tableau.length - 1;
        int milieu = 0;
        boolean trouve = false;

        while (debut <= fin && !trouve) {
            milieu = (debut + fin) / 2;

            if (valeur == tableau[milieu])
                trouve = true;
            else if (valeur < tableau[milieu])
                fin = milieu - 1;
            else
                debut = milieu + 1;
        }

        if (trouve)
            return milieu;
        else
            return -1;
    }

}
