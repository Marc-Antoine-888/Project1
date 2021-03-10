package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] tab = {7,2,1,4,8,5,3,6};
        System.out.println(Arrays.toString(tab));
        quickSort(tab, 0, tab.length-1);
        System.out.println(Arrays.toString(tab));
    }

    public static int partition(int[]tab, int g, int d) {
        int pivot = tab[d];
        for (int i = g; i < d; i++) {
            if (tab[i] < pivot) {
                permute(tab, g, i);
                g++;
            }
        }
        permute(tab, g, d);
        System.out.println(Arrays.toString(tab));
        return g;
    }

    public static void quickSort(int[] tab, int gauche, int droite) {
        if (gauche < droite) {
            int index = partition(tab, gauche, droite);
            quickSort(tab, gauche, index - 1);
            quickSort(tab, index + 1, droite);
        }
    }

    public static void permute(int[] tab, int g, int d) {
        int permute = tab[g];
        tab[g] = tab[d];
        tab[d] = permute;
    }

}