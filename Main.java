package com.company;

public class Main {

    public static void main(String[] args) {
        int n = 5;
        long f = 4;
        int[] tab = {1, 2, 3};

        //System.out.println(factorielle(f));
        //System.out.println(factorielleR(f));

        //decompte(n);
        //decompteR(n);

        System.out.println(somme(tab));
        System.out.println(sommeR(tab, 0, 0));

    }

    public static long factorielleR(long n) {
        if (n == 0)
            return 1;
        else
            return n * factorielleR(n - 1);
    }

    public static long factorielle(long n) {
        long accumulateur = 1;

        for (long i = n; i >= 1; i--)
            accumulateur *= i;

        return accumulateur;
    }

    //écrire une méthode qui fait un décompte à la console d'un entier positif
    public static void decompte(int n) {
        for (int i = n; i >= 1; i--)
            System.out.println(i);
        System.out.println("Fini!");
    }

    public static void decompteR(int n) {
        if (n == 0)
            System.out.println("Fini!");
        else {
            //cas récursif
            System.out.println(n);
            decompteR(n - 1);
        }

    }

    //somme d'un tableau d'entier, qui contient au moins un élément
    public static int somme(int[] tab) {
        int s = 0;
        for (int i = 0; i < tab.length; i++) {
            s += tab[i];
        }
        return s;
    }

    //Récursivité dans un tableau arguements: tableau, index, x
    public static int sommeR(int[] tab, int index, int somme) {
        if (index == tab.length)
            return somme;
        else {
            somme += tab[index];
            return sommeR(tab, index + 1, somme);
        }
    }

}
