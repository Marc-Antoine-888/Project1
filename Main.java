package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Main extends JFrame {
    JFrame frame;
    JList listCh;
    JList listChSort;
    JButton btnFouiller;
    JLabel labSeq;
    JLabel labDic;
    JTextField txfTimeSeq;
    JTextField txfTimeDic;
    JTextField txfVal;
    JPanel panEast;
    JPanel panCenter;
    JPanel panWest;

    final int NB = 500;
    public String[] tableauCh = new String[NB];
    public String[] tableauChSort = new String[NB];

    public Main() {
        frame = new JFrame("Chapitre 2 Atelier 6");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(650, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        for (int i = 0; i < tableauCh.length; i++) {
            tableauCh[i] = genereChaine();

        }

        for (int i = 0; i < tableauCh.length; i++) {
            tableauChSort[i] = tableauCh[i];
        }

        triSSSUpString();


        panEast = new JPanel();
        panEast.setPreferredSize(new Dimension(200, 600));
        panCenter = new JPanel();
        panCenter.setPreferredSize(new Dimension(200, 600));
        panWest = new JPanel();
        panWest.setPreferredSize(new Dimension(200, 600));

        listCh = new JList(tableauCh);
        listCh.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listCh.addListSelectionListener(e -> listChSelectionChange(e));
        listCh.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)
                    System.out.println(listCh.getSelectedValue());
            }
        });

        listChSort = new JList(tableauChSort);
        listChSort.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        btnFouiller = new JButton("Fouiller");
        btnFouiller.setSize(100,30);
        btnFouiller.addActionListener(e -> btnFouillerAction());

        txfVal = new JTextField();
        txfVal.setPreferredSize(new Dimension(200, 30));

        txfTimeSeq = new JTextField();
        txfTimeSeq.setPreferredSize(new Dimension(200, 30));

        txfTimeDic = new JTextField();
        txfTimeDic.setPreferredSize(new Dimension(200, 30));

        labSeq = new JLabel("Fouille séquentielle");
        labSeq.setPreferredSize(new Dimension(200, 30));

        labDic = new JLabel("Fouille dichotomique");
        labDic.setPreferredSize(new Dimension(200, 30));

        JScrollPane scrollCh = new JScrollPane(listCh);
        scrollCh.setPreferredSize(new Dimension(200, 500));
        JScrollPane scrollChSort = new JScrollPane(listChSort);
        scrollChSort.setPreferredSize(new Dimension(200, 500));

        panEast.add(txfVal);
        panEast.add(btnFouiller);
        panEast.add(labSeq);
        panEast.add(txfTimeSeq);
        panEast.add(labDic);
        panEast.add(txfTimeDic);

        panWest.add(scrollCh);

        panCenter.add(scrollChSort);

        frame.add(panWest, BorderLayout.WEST);
        frame.add(panCenter, BorderLayout.CENTER);
        frame.add(panEast, BorderLayout.EAST);

        frame.setVisible(true);

    }

    private void listChSelectionChange(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) {
            System.out.println(listCh.getSelectedValue());
            txfVal.setText(listCh.getSelectedValue().toString());
        }

    }

    private void btnFouillerAction(){

        fouilleSeq(tableauCh, txfVal.getText());
        fouilleDic(tableauChSort, txfVal.getText());
    }

    public void fouilleSeq(String[] tableau, String valeur) {
        long tempsDebut, tempsFin, duree;
        tempsDebut = System.nanoTime();
        int i = 0;
        boolean trouve = false;

        while (!trouve && i < tableau.length) {
            if (valeur.equals(tableau[i])){
               trouve = true;
            } else {
                i++;
            }

            tempsFin = System.nanoTime();
            duree = tempsFin - tempsDebut;

            if (trouve) {
                txfTimeSeq.setText(String.valueOf(duree));
            } else {
                txfTimeSeq.setText("-1");
            }
        }
    }

    public void fouilleDic(String[] tab, String valeur) {
        long tempsDebut, tempsFin, duree;
        tempsDebut = System.nanoTime();
        int debut = 0;
        int fin = tab.length - 1;
        int milieu = 0;
        boolean trouve = false;

        while (debut <= fin && !trouve) {
            milieu = (debut + fin) / 2;

            if (valeur.equals(tab[milieu]))
                trouve = true;
            else if (valeur.compareTo(tab[milieu]) < 1)
                fin = milieu - 1;
            else
                debut = milieu + 1;
        }

        tempsFin = System.nanoTime();
        duree = tempsFin - tempsDebut;

        if (trouve) {
            txfTimeDic.setText(String.valueOf(duree));
        } else {
            txfTimeDic.setText("-1");
        }

    }

    public static String genereChaine() {
        final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        String result = "";
        int index;
        for (int i = 0; i < 10; i++) {
            index = random.nextInt(ALPHA.length());
            result += ALPHA.charAt(index);
        }
        return result;
    }

    public void triSSSUpString() {
        int iMin; //Indice de la première chaîne par ordre alphabétique

        String[] tabMots = tableauChSort; //Tableau de chaînes de mots de txaMots

        if ((tabMots[0]).isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Le tableau est vide", "Erreur tableau vide", JOptionPane.ERROR_MESSAGE);
        } else {
            for (int i = 0; i < tabMots.length - 1; i++) {
                iMin = i;

                for (int j = i + 1; j < tabMots.length; j++)
                    if (tabMots[j].compareTo(tabMots[iMin]) < tabMots[iMin].compareTo(tabMots[j]))
                        iMin = j;

                if (iMin != i) {
                    permuteString(tabMots, iMin, i);
                }
            }
        }
        tableauChSort = tabMots;
    }

    public void permuteString(String[] tabMots, int i1, int i2) {
        String permute = tabMots[i1];
        tabMots[i1] = tabMots[i2];
        tabMots[i2] = permute;
    }

    public static void main(String[] args) {
        Main main = new Main();
    }




}
