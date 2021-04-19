package com.company;

public class Main {

    public static void main(String[] args) {
        //Livre livre1 = new Livre("Le Big Data", "Pierre Delort", 12.99);
        //Livre livre2 = new Livre("Alice", "Lewis Caroll", 26.99);
        //Livre livre3 = new Livre("Python", "JP Mueller", 30.99);

        //System.out.println(livre1.toString());
        //System.out.println(livre2.toString());
        //System.out.println(livre3.toString());
        //System.out.println(Livre.getNbLivres());

        Étudiant étu1 = new Étudiant("Jean", "Bon", 18);
        Étudiant étu2 = new Étudiant("Lacour", "Déneige", 22);

        étu1.addNote(68);
        étu1.addNote(76);
        étu1.addNote(90);

        étu2.addNote(22);
        étu2.addNote(50);
        étu2.addNote(35);
        étu2.addNote(48);

        System.out.println(étu1);
        System.out.println(étu2);
    }

}

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


