package com.company;

public class Main {

    public static void main(String[] args) {
        int[] tab = {1, 2, 3, 4};

        //System.out.println(puissance(3));
        //System.out.println(puissanceR(3));

        //System.out.println(palindrome("kayak"));
        //System.out.println(palindromeR("kayak"));

        //triangle(8);
        //triangleR(8,0);

        //System.out.println(estTrieCroissant(tab));
        //System.out.println(estTrieCroissantR(tab, 0));

        //System.out.println(maximumR(tab, 0, 0));
        //System.out.println(minimumR(tab, 0, 0));

        //System.out.println(sommeNumerique(2019));
        //System.out.println(racineNumerique(2019));
        //System.out.println(sommeNumeriqueR(2019));
        //System.out.println(racineNumeriqueR(2019));
        
    }

    public static long puissance(int n) {
        int puissance = 1;

        for (int i = 0; i < n; i++)
            puissance *= 2;

        return puissance;
    }

    public static long puissanceR(long n) {
        if (n == 0)
            return 1;
        else
            return 2 * puissanceR(n - 1);
    }

    public static boolean palindrome(String mot) {
        boolean isPalindrome = true;
        int debut = 0;
        int fin = mot.length() - 1;
        while (isPalindrome && debut <= fin) {
            if (mot.charAt(debut) != mot.charAt(fin))
                isPalindrome = false;
            else {
                debut++;
                fin--;
            }
        }
        return isPalindrome;
    }

    public static boolean palindromeR(String mot) {
        if (mot.length() == 0 || mot.length() == 1)
            return true;
        else if (mot.charAt(0) != mot.charAt(mot.length() - 1))
            return false;
        else
            return palindromeR(mot.substring(1, mot.length() - 1));
    }

    public static void triangle(int nbLignes) {
        int blanc;
        int etoile;

        for (int i = 0; i <= nbLignes; i++) {
            blanc = nbLignes - i;
            etoile = nbLignes - blanc;
            for (int j = blanc; j > 0; j--)
                System.out.print(" ");
            for (int k = etoile; k > 0; k--)
                System.out.print("*");
            System.out.println();
        }

    }

    public static void triangleR(int nbLignes, int noLigne) {
        int blanc;
        int etoile;

        if (nbLignes != noLigne) {
            blanc = nbLignes - noLigne - 1;
            etoile = nbLignes - blanc;
            for (int i = blanc; i > 0; i--)
                System.out.print(" ");
            for (int k = etoile; k > 0; k--)
                System.out.print("*");
            System.out.println();
            triangleR(nbLignes, noLigne + 1);
        }
    }

    public static boolean estTrieCroissant(int[] tab) {
        boolean estCroissant = true;
        int i = 0;

        if (tab.length > 1) {
            while ((i + 1) < tab.length && estCroissant) {
                if ((tab[i] < tab[i + 1]))
                    i++;
                else
                    estCroissant = false;
            }
        }

        return estCroissant;
    }

    public static boolean estTrieCroissantR(int[] tab, int i) {
        if (tab.length == 1 || (i + 1) > tab.length - 1)
            return true;
        else if (tab[i] > tab[i + 1])
            return false;
        else
            return estTrieCroissantR(tab, i + 1);
    }

    public static int maximumR(int[] tab, int i, int max) {
        if (i == tab.length)
            return max;
        else {
            if (tab[i] > max)
                return maximumR(tab, i + 1, tab[i]);
            else
                return maximumR(tab, i + 1, max);
        }
    }

    //marche même pas
    public static int minimumR(int[] tab, int i, int min) {
        if (i == tab.length)
            return min;
        else {
            if (tab[i] < min)
                return minimumR(tab, i + 1, tab[i]);
            else
                return minimumR(tab, i + 1, min);
        }
    }

    public static int sommeNumerique(int n) {
        int somme = 0;
        while (n != 0) {
            somme += n % 10;
            n /= 10;
        }
        return somme;
    }

    public static int racineNumerique(int n) {
        int s = sommeNumerique(n);
        while (s > 10) {
            s = sommeNumerique(s);
        }
        return s;
    }

    public static int sommeNumeriqueR(int n) {
        if (n == 0)
            return 0;
        else
            return (n % 10) + sommeNumeriqueR(n / 10);
    }

    public static int racineNumeriqueR(int n) {
        if (sommeNumeriqueR(n) < 10)
            return sommeNumeriqueR(n);
        else
            return racineNumeriqueR(sommeNumeriqueR(n));
    }


}
