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

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Étudiant {
    DecimalFormat df = new DecimalFormat("0.00");
    private String nom;
    private String prenom;
    private int age;
    private ArrayList<Integer> notes;


    public Étudiant(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.notes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public void addNote(int note) {
        notes.add(note);
    }

    public ArrayList<Integer> getNotes() {
        return notes;
    }

    public double moyenneNotes() {
        double total = 0;
        double moyenne;

        for (Integer note : notes) {
            total += note;
        }
        moyenne = total / notes.size();
        return moyenne;
    }

    @Override
    public String toString() {
        return "Étudiant{" +
                "nom=" + nom +", prenom=" + prenom + ", age=" + age + ", notes=" + notes + '}'+ " moyenne = " + df.format(moyenneNotes());
    }


}
