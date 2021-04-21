package com.company;

public class Main {

    public static void main(String[] args) {
        Livre l1 = new Livre("Blockchain", "Laurent Leloup");
        l1.addChapitre("1 Le blockchain c'est quoi?", 25);
        l1.addChapitre("2 Le blockchain aujourd'hui", 50);
        l1.addChapitre("3 Le blockchain demain", 22);

        Livre l2 = new Livre("Player one", "Ernest Cline");
        l2.addChapitre("0010", 11);
        l2.addChapitre("0006", 10);
        l2.addChapitre("0007", 33);
        l2.addChapitre("0004", 27);

        System.out.println(l1.toString());
        System.out.println("\n" + l2.toString());
    }

}
