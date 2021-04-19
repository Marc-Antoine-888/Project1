package com.company;

public class Livre {

    private String titre;
    private String auteur;
    private double prix;

    private static int nbLivres;

    public Livre(String titre, String auteur, double prix) {
        this.titre = titre;
        this.auteur = auteur;
        this.prix = prix;
        nbLivres++;
    }

    public static int getNbLivres() {
        return nbLivres;
    }

    public static void setNbLivres(int nbLivres) {
        Livre.nbLivres = nbLivres;
    }

    @Override
    public String toString() {
        return titre + ", " + auteur + ", " + prix;
    }
}
