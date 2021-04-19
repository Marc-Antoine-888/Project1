package com.company;

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
