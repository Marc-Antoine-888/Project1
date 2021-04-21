package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Jeux> listeJeux = new ArrayList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        listeJeux.add(new Jeux("Driven", "Course", 2001));
        listeJeux.add(new Jeux("Alice", "Aventure", 2001));
        listeJeux.add(new Jeux("Pong", "Sport", 1972));
        listeJeux.add(new Jeux("Imperialist", "Simulation", 1985));
        listeJeux.add(new Jeux("Epic Mickey", "Action", 2010));

        writeFile("data/jeux.dat");

        readFile("data/jeux.dat");

        for (Jeux j: listeJeux)
            System.out.println(j.toString());
    }

    public static void writeFile(String filename) throws IOException {
        ObjectOutputStream sortie = new ObjectOutputStream(new FileOutputStream(filename));
        sortie.writeObject(listeJeux);
        sortie.close();
    }

    public static void readFile(String fileName) throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream entree = new ObjectInputStream(new FileInputStream(fileName));
            listeJeux.clear();
            listeJeux = (ArrayList<Jeux>) entree.readObject();
            entree.close();

        } catch (FileNotFoundException e) {
            System.out.println("Aucun fichier charge");
        }
    }

}
