package com.company;

public class Main {

    public static void main(String[] args) {
        int[] tableau1 = {1, 2, 3, 4, 5};
        int[] tableau2 = {5, 21, 37, 38, 45};
        int[] tableau3 = {5, 21, 37, 38, 45};
        int[] tableau4 = {-4, -2, 1, 3, 6, 8};
        int[] tableau5 = {0, 1, 2, 3, 4, 5, 6, 8, 9};
        int[] tableau6 = {17, 20, 26, 31, 44, 54, 55, 77, 93};
        int[] tableau7 = {1, 10, 12, 22, 23, 31, 33, 44, 55, 56, 60, 75, 80, 88, 90, 91};
        int[] tableau8 = {10, 31, 35, 36, 41, 46, 55, 63, 66, 68, 73, 75, 76, 81, 107, 200};
        System.out.println(fouilleDichotomique(tableau1, 4));
        System.out.println(fouilleDichotomique(tableau2, 66));
        System.out.println(fouilleDichotomique(tableau3, 4));
        System.out.println(fouilleDichotomique(tableau4, 1));
        System.out.println(fouilleDichotomique(tableau5, 6));
        System.out.println(fouilleDichotomique(tableau6, 17));
        System.out.println(fouilleDichotomique(tableau7, 91));
        System.out.println(fouilleDichotomique(tableau8, 41));

    }

    public static String fouilleDichotomique(int[] tableau, int valeur) {
        int debut = 0;
        int fin = tableau.length - 1;
        int milieu = 0;
        int nbr = 0;
        boolean trouve = false;

        while (debut <= fin && !trouve) {
            milieu = (debut + fin) / 2;
            nbr++;

            if (valeur == tableau[milieu])
                trouve = true;
            else if (valeur < tableau[milieu])
                fin = milieu - 1;
            else
                debut = milieu + 1;
        }

        if (trouve)
            return String.valueOf("Index: " + milieu + " nombre d'itérations: " + nbr);
        else
            return String.valueOf("Index: " + -1 + " nombre d'itérations: " + nbr);
    }

}
