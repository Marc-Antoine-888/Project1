package com.company;

import java.util.Arrays;
import java.io.*;
import java.util.Scanner;

public class Main {

    static int n1, n2;

    static String[][] tabBieres = new String[5][4];
    static int nbBieres;

    public static void main(String[] args) throws IOException {

        exercice1();
        exercice2();

    }

    private static void exercice1() throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Entrez le début et la fin");
        n1 = scan.nextInt();
        n2 = scan.nextInt();

        writeFile("texte/nombres.txt");
        readFile("texte/nombres.txt");
    }

    private static void exercice2() throws IOException{
        readFileBieres("texte/bieres.txt");
        System.out.println(Arrays.deepToString(tabBieres));
    }

    //Méthode exercice 1

    public static void writeFile(String fileName) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
        for (int i = n1; i <= n2; i++){
            writer.write(String.valueOf(i));
            writer.newLine();
        }
        writer.close();
    }

    public static void readFile(String fileName) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
        reader.close();
    }

    //Méthode exercice 2

    private static void readFileBieres(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String[] tab;
        String line;
        nbBieres = 0;

        while((line = reader.readLine()) != null){
            tab = line.split("/");
            tabBieres[nbBieres][0] = tab[0];
            tabBieres[nbBieres][1] = tab[1];
            tabBieres[nbBieres][2] = tab[2];
            tabBieres[nbBieres][3] = tab[3];

            nbBieres++;
        }

        reader.close();
    }

}
