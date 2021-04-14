package com.company;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * C4 Atelier 2 - ArrayList
 * Objectif: Compléter les trois méthodes delNegatifs, copyNegatifs, moveNegatifs
 * Contrainte: Ne pas modifier le main
 * Session H2021
 * @author France Beaudoin
 */
public class Main {
    public static Integer[] tab1 = {-1,3,25,142,22,-10,-33,49,60};
    public static Integer[] tab2 = {1,3,25,142,22,-10,-33,49,60};
    public static Integer[] tab3 = {1,3,25,142,22,-10,-33,49,-60};
    public static Integer[] tab4 = {-1,-3,-25,-142,-32,-33,-49,-60};
    public static ArrayList<Integer> liste1 = new ArrayList<>(Arrays.asList(tab1));
    public static ArrayList<Integer> liste2 = new ArrayList<>(Arrays.asList(tab2));
    public static ArrayList<Integer> liste3 = new ArrayList<>(Arrays.asList(tab3));
    public static ArrayList<Integer> liste4 = new ArrayList<>(Arrays.asList(tab4));

    public static void main(String[] args) {
        System.out.println("Listes de départ:");
        System.out.println("liste1: " + liste1);
        System.out.println("liste2: " + liste2);
        System.out.println("liste3: " + liste3);
        System.out.println("liste4: " + liste4);

        System.out.println("\nSupprimer les entiers négatifs");
        delNegatifs(liste1);
        delNegatifs(liste2);
        delNegatifs(liste3);
        delNegatifs(liste4);
        System.out.println("liste1: " + liste1);
        System.out.println("liste2: " + liste2);
        System.out.println("liste3: " + liste3);
        System.out.println("liste4: " + liste4);

        System.out.println("\nCopier les entiers négatifs");
        //Réinitialiser les liste avec les valeurs de départ
        liste1 = new ArrayList<>(Arrays.asList(tab1));
        liste2 = new ArrayList<>(Arrays.asList(tab2));
        liste3 = new ArrayList<>(Arrays.asList(tab3));
        liste4 = new ArrayList<>(Arrays.asList(tab4));
        ArrayList<Integer> listDestination = new ArrayList<>();

        //Copier les entiers négatifs
        copyNegatifs(liste1, listDestination);
        System.out.println("liste1:\t\t\t" + liste1);
        System.out.println("destination:\t" + listDestination);
        listDestination.clear();

        copyNegatifs(liste2, listDestination);
        System.out.println("liste2:\t\t\t" + liste2);
        System.out.println("destination:\t" + listDestination);
        listDestination.clear();

        copyNegatifs(liste3, listDestination);
        System.out.println("liste3:\t\t\t" + liste3);
        System.out.println("destination:\t" + listDestination);
        listDestination.clear();

        copyNegatifs(liste4, listDestination);
        System.out.println("liste4:\t\t\t" + liste4);
        System.out.println("destination:\t" + listDestination);

        System.out.println("\nDéplacer les entiers négatifs");
        //Réinitialiser les liste avec les valeurs de départ
        liste1 = new ArrayList<>(Arrays.asList(tab1));
        liste2 = new ArrayList<>(Arrays.asList(tab2));
        liste3 = new ArrayList<>(Arrays.asList(tab3));
        liste4 = new ArrayList<>(Arrays.asList(tab4));
        listDestination.clear();

        //Déplacer les entiers négatifs
        moveNegatifs(liste1, listDestination);
        System.out.println("liste1:\t\t\t" + liste1);
        System.out.println("destination:\t" + listDestination);
        listDestination.clear();

        moveNegatifs(liste2, listDestination);
        System.out.println("liste2:\t\t\t" + liste2);
        System.out.println("destination:\t" + listDestination);
        listDestination.clear();

        moveNegatifs(liste3, listDestination);
        System.out.println("liste3:\t\t\t" + liste3);
        System.out.println("destination:\t" + listDestination);
        listDestination.clear();

        moveNegatifs(liste4, listDestination);
        System.out.println("liste4:\t\t\t" + liste4);
        System.out.println("destination:\t" + listDestination);
    }

    /**
     * Supprime les entiers négatifs de la liste reçue
     * @param list liste d'entiers
     */
    public static void delNegatifs(ArrayList<Integer> list){
        int i = 0;
        while (i < list.size()) {
            if (list.get(i) < 0) {
                list.remove(i);
            } else {
                i++;
            }
        }
    }

    /**
     * Copie les entiers négatifs d'une liste source vers une liste destination
     * @param listSrc liste d'entiers source
     * @param listDest liste d'entiers destination
     */
    public static void copyNegatifs(ArrayList<Integer> listSrc, ArrayList<Integer> listDest){
        for (Integer elem: listSrc) {
            if (elem < 0) {
                listDest.add(elem);
            }
        }
    }

    /**
     * Déplace les entiers négatifs d'une liste source vers une liste destination
     * @param listSrc liste d'entiers source
     * @param listDest liste d'entiers destination
     */
    public static void moveNegatifs(ArrayList<Integer> listSrc, ArrayList<Integer> listDest){
        int i = 0;
        while (i < listSrc.size()) {
            if (listSrc.get(i) < 0) {
                listDest.add(listSrc.get(i));
                listSrc.remove(i);
            } else {
                i++;
            }
        }
    }

}
