package com.company;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.ItemEvent;
import java.util.Arrays;
import java.util.regex.*;

public class Main extends JFrame {

    JFrame frame;
    JComboBox cmbBox;
    JRadioButton radCroissant;
    JRadioButton radDécroissant;
    ButtonGroup radGroupe;
    JButton btnTri;
    JTextField txfMax;
    JTextField txfMin;
    JTextField txfMoy;
    JTextField txfValeur;
    JTextArea txaTab;
    JButton btnChercher;
    JButton btnQuitter;

    JPanel panDroite;
    JPanel panGauche;

    Dimension dimMin = new Dimension(500,400);
    Dimension dimTxa = new Dimension(250,600);
    Dimension dimTxf = new Dimension(200, 30);
    Dimension dimBtn = new Dimension(150, 25);
    Dimension dimDroite = new Dimension(250, 350);
    Dimension dimGauche = new Dimension(250, 400);

    public Main() {

        frame = new JFrame("Atelier 2 Swing Tableaux");
        frame.setSize(500, 400);
        frame.setMinimumSize(dimMin);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        Border Bordure = BorderFactory.createLineBorder(Color.BLACK, 1);

        panDroite = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panDroite.setPreferredSize(dimDroite);
        panGauche = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panGauche.setPreferredSize(dimGauche);

        txfMax = new JTextField();
        txfMax.setEditable(false);
        txfMax.setPreferredSize(dimTxf);

        txfMin = new JTextField();
        txfMin.setEditable(false);
        txfMin.setPreferredSize(dimTxf);

        txfMoy = new JTextField();
        txfMoy.setEditable(false);
        txfMoy.setPreferredSize(dimTxf);

        txfValeur = new JTextField("txfValeur");
        txfValeur.setPreferredSize(dimTxf);

        txaTab = new JTextArea();
        txaTab.setPreferredSize(dimTxa);
        txaTab.setBorder(Bordure);
        txaTab.setLineWrap(true);
        txaTab.setWrapStyleWord(true);

        radGroupe = new ButtonGroup();

        radCroissant = new JRadioButton("Croissant", true);
        radDécroissant = new JRadioButton("Décroissant");

        radGroupe.add(radCroissant);
        radGroupe.add(radDécroissant);

        String[] tab = {"Vider", "Garnir", "Nombres 1..100", "Nombres -25..25"};
        cmbBox = new JComboBox(tab);
        cmbBox.addItemListener(e -> cmbItemSelectedChange(e));
        cmbBox.setSelectedItem("Vider");
        cmbBox.setPreferredSize(dimTxf);

        btnTri = new JButton("Trier");
        btnTri.setPreferredSize(dimBtn);
        btnTri.addActionListener(e -> btnTriAction());

        btnChercher = new JButton("Chercher");
        btnChercher.setPreferredSize(dimBtn);
        btnChercher.addActionListener(e -> btnChercherAction());

        btnQuitter = new JButton("Quitter");
        btnQuitter.setPreferredSize(dimBtn);
        btnQuitter.addActionListener(e -> btnQuitterAction());

        panDroite.add(txaTab);

        panGauche.add(cmbBox);
        panGauche.add(radCroissant);
        panGauche.add(radDécroissant);
        panGauche.add(btnTri);
        panGauche.add(txfMin);
        panGauche.add(txfMax);
        panGauche.add(txfMoy);
        panGauche.add(txfValeur);
        panGauche.add(btnChercher);
        panGauche.add(btnQuitter);

        frame.add(panDroite, BorderLayout.EAST);
        frame.add(panGauche, BorderLayout.WEST);

        frame.setVisible(true);



    }

    private void btnChercherAction() {
        int i = 0; //Position du tableau i
        int j = 0; //Position du tableau j
        int nbMatchsTrouve = 0; //Nombres de matchs trouvés
        String[] Fouille = new String[100]; //Tableau de chaînes qui contient les matchs trouvés

        String[] tabMots = txaTab.getText().split("\n");
        while (i < tabMots.length) {
            if (tabMots[i].equals(String.valueOf(txfValeur.getText()))) {
                nbMatchsTrouve++;
                Fouille[i] = String.valueOf((i) + 1);
                if (nbMatchsTrouve >= 1) {
                    System.out.println("Trouvé à l'indice " + String.valueOf(Integer.parseInt(Fouille[j]) - 1));
                } else if (nbMatchsTrouve == 0) {
                    System.out.println("Non trouvé");
                }
            }
            i++;
        }

    }

    private void btnTriAction() {
        if (radCroissant.isSelected()) {
            int iMin; //Indice de la première chaîne par ordre alphabétique

            String[] tabMots = txaTab.getText().split("\n"); //Tableau de chaînes de mots de txaMots

            if ((tabMots[0]).isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Le text area de mots est vide", "Erreur text area vide", JOptionPane.ERROR_MESSAGE);
            } else {
                for (int i = 0; i < tabMots.length - 1; i++) {
                    iMin = i;

                    for (int j = i + 1; j < tabMots.length; j++)
                        if (tabMots[j].compareTo(tabMots[iMin]) < tabMots[iMin].compareTo(tabMots[j]))
                            iMin = j;

                    if (iMin != i) {
                        permuteString(tabMots, iMin, i);

                        txaTab.setText(null);

                        for (String elem : tabMots) {
                            txaTab.append(elem + "\n");
                        }
                    }
                }
            }
        } else if (radDécroissant.isSelected()) {
            int iMax; //Indice de la dernière chaîne par ordre alphabétique

            String[] tabMots = txaTab.getText().split("\n"); //Tableau des chaînes de mots de txaMots

            if ((tabMots[0]).isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Le text area de mots est vide", "Erreur text area vide", JOptionPane.ERROR_MESSAGE);
            } else {
                for (int i = 0; i < tabMots.length - 1; i++) {
                    iMax = i;

                    for (int j = i + 1; j < tabMots.length; j++)
                        if (tabMots[j].compareTo(tabMots[iMax]) > tabMots[iMax].compareTo(tabMots[j]))
                            iMax = j;

                    if (iMax != i) {
                        permuteString(tabMots, iMax, i);

                        txaTab.setText(null);

                        for (String elem : tabMots) {
                            txaTab.append(elem + "\n");
                        }
                    }
                }
            }
        }
    }

    public void permuteString(String[] tabMots, int i1, int i2) {
        String permute = tabMots[i1];
        tabMots[i1] = tabMots[i2];
        tabMots[i2] = permute;
    }

    private void btnQuitterAction() {
        int rep = JOptionPane.showConfirmDialog(frame, "Voulez-vous vraiment quitter?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (rep == 0) {
            System.exit(0);
        }
    }

    private void cmbItemSelectedChange(ItemEvent e) {
        String[] garnir = {"10", "50", "2", "33", "-27", "144", "57", "25"};
        int i = 1;
        int j = -25;

        if (e.getStateChange() == ItemEvent.SELECTED)
            System.out.println(cmbBox.getSelectedItem());

        if (cmbBox.getSelectedItem() == "Vider") {
            txaTab.setText("");
        } else if (cmbBox.getSelectedItem() == "Garnir") {
            txaTab.setText(String.valueOf(garnir));
        } else if (cmbBox.getSelectedItem() == "Nombres 1..100") {
            do {
                txaTab.append(String.valueOf(i) + "\n");
                i++;
            } while (i < 11);
        } else if (cmbBox.getSelectedItem() == "Nombres -25..25") {
            while (j < 26) {
                txaTab.append(String.valueOf(j) + "\n");
                j++;
            }
        }

        max();
        min();
        moyenne();

    }

    public int max() {
        int nMax = 0; //Plus grand entier de txaNombres
        int iMax; //Indice du plus grand entier de txaNombres

        String[] tabNombres = txaTab.getText().split("\n"); //Tableau de chaînes de nombres de txaNombres

        if (!(tabNombres[0]).isEmpty()) {

            for (int i = 0; i < tabNombres.length - 1; i++) {
                iMax = i;

                for (int j = i + 1; j < tabNombres.length; j++) {
                    if (Integer.parseInt(tabNombres[j]) > Integer.parseInt(tabNombres[iMax])) {
                        iMax = j;
                    }
                }
                if (iMax != i) {
                    permuteNombres(tabNombres, iMax, i);
                }
            }

            nMax = Integer.parseInt(tabNombres[0]);

        }

        txfMax.setText(String.valueOf(nMax));
        return nMax;
    }

    public int min() {
        int nMin = 0; //Plus petit entier de txaNombres
        int iMin; //Indice du plus petit entier de txaNombres

        String[] tabNombres = txaTab.getText().split("\n"); //Tableau de chaînes de nombres de txaNombres

        if (!(tabNombres[0]).isEmpty()) {

            for (int i = 0; i < tabNombres.length - 1; i++) {
                iMin = i;

                for (int j = i + 1; j < tabNombres.length; j++) {
                    if (Integer.parseInt(tabNombres[j]) < Integer.parseInt(tabNombres[iMin])) {
                        iMin = j;
                    }
                }
                if (iMin != i) {
                    permuteNombres(tabNombres, iMin, i);
                }
            }

            nMin = Integer.parseInt(tabNombres[0]);

        }

        txfMin.setText(String.valueOf(nMin));
        return nMin;
    }

    public void permuteNombres(String[] tabNombre, int i1, int i2) {
        String permute = tabNombre[i1];
        tabNombre[i1] = tabNombre[i2];
        tabNombre[i2] = permute;
    }

    public double moyenne() {
        double moy = 0;

        String[] tabNombres = txaTab.getText().split("\n");

        for(int a = 0; a < tabNombres.length; a++) {
            moy = moy + Integer.parseInt(tabNombres[a]);
        }

        moy = moy / tabNombres.length;

        txfMoy.setText(String.valueOf(moy));
        return moy;
    }

    public static void main(String[] args) {Main m = new Main();}

}