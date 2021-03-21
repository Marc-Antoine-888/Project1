package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] data = {
                {5, 115, 15},
                {3, 223, 33},
                {1, 331, 11},
                {2, 442, 22},
                {4, 554, 44}
        };

        int[] tabIndC1 = new int[data.length];
        int[] tabIndC2 = new int[data.length];
        int[] tabIndC3 = new int[data.length];

        initIndex(tabIndC1);
        initIndex(tabIndC2);
        initIndex(tabIndC3);
        triSSS(data, tabIndC1, 0);
        triSSS(data, tabIndC2, 1);
        triSSS(data, tabIndC3, 2);
        System.out.println("------COL1------");
        affTableau(data, tabIndC1);
        System.out.println("------COL2------");
        affTableau(data, tabIndC2);
        System.out.println("------COL3------");
        affTableau(data, tabIndC3);
    }

    public static void initIndex(int[] ind){
        for (int i=0; i<ind.length; i++)
            ind[i] = i;
    }

    public static void permute(int[] tab, int i1, int i2){
        int transit = tab[i1];
        tab[i1] = tab[i2];
        tab[i2] = transit;
    }

    public static void triSSS(int[][] tab, int[] ind, int col){
        int imin;

        for (int i = 0; i < ind.length - 1; i++){
            imin = i;
            for (int j = i + 1; j < ind.length; j++)
                if (tab[ind[j]][col] < tab[ind[imin]][col])
                    imin = j;
            if (imin != i)
                permute(ind, imin, i);
        }
    }

    public static void affTableau(int[][] tab, int[] ind){
        for (int i=0; i<ind.length; i++) {
            for (int j = 0; j < tab[0].length; j++)
                System.out.print(tab[ind[i]][j] + " ");
            System.out.println();
        }
    }
}
