package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class Main extends JFrame {

    JFrame frame;
    JList listeDroite;
    JList listeGauche;
    JTextField txfAjout;
    JComboBox cmbBox;
    JButton btnAjouter;
    JButton btnGVD;
    JButton btnPGVD;
    JButton btnDVG;
    JButton btnPDVG;
    JButton btnQuitter;
    DefaultListModel mdlGauche;
    DefaultListModel mdlDroite;
    JPanel panHaut;
    JPanel panDroite;
    JPanel panCenter;
    JPanel panGauche;
    JPanel panBas;

    String[] dataG = {"Ananas", "Melon", "Cantaloupe", "Pomme", "Banane", "Raison", "Mangue", "Pamplemousse", "Melon", "Clémentine"};
    String[] dataD = {"Fruit"};
    String[] cmb = {"Début", "Milieu", "Fin"};

    Dimension dimBtn = new Dimension(50, 30);
    Dimension dimQuitter = new Dimension(350, 30);
    Dimension dimMin = new Dimension(450, 350);
    Dimension dimTxf = new Dimension(100,30);
    Dimension dimListe = new Dimension(150, 200);

    public Main() {

        frame = new JFrame("Nombre Mystère");
        frame.setSize(450, 350);
        frame.setMinimumSize(dimMin);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        cmbBox = new JComboBox(cmb);
        cmbBox.setSelectedItem("Début");

        btnAjouter = new JButton("Ajouter");
        btnAjouter.addActionListener(e -> btnAjouterAction());
        btnAjouter.setPreferredSize(dimTxf);

        btnGVD = new JButton(">");
        btnGVD.addActionListener(e -> btnGVDAction());
        btnGVD.setPreferredSize(dimBtn);

        btnPGVD = new JButton(">>");
        btnPGVD.addActionListener(e -> btnPGVDAction());
        btnPGVD.setPreferredSize(dimBtn);

        btnDVG = new JButton("<");
        btnDVG.addActionListener(e -> btnDVGAction());
        btnDVG.setPreferredSize(dimBtn);

        btnPDVG = new JButton("<<");
        btnPDVG.addActionListener(e -> btnPDVGAction());
        btnPDVG.setPreferredSize(dimBtn);

        txfAjout = new JTextField("txfAjout");
        txfAjout.setPreferredSize(dimTxf);

        mdlGauche = new DefaultListModel();
        for (String elem: dataG) {
            mdlGauche.addElement(elem);
        }

        listeGauche = new JList<>(mdlGauche);
        listeGauche.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listeGauche.setPreferredSize(dimListe);
        listeGauche.setPreferredSize(new Dimension(150, 350));

        mdlDroite = new DefaultListModel();
        for (String elem: dataD) {
            mdlDroite.addElement(elem);
        }
        listeDroite = new JList<>(mdlDroite);
        listeDroite.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listeDroite.setPreferredSize(dimListe);
        listeDroite.setPreferredSize(new Dimension(150, 350));
        
        btnQuitter = new JButton("Quitter");
        btnQuitter.setPreferredSize(dimQuitter);
        btnQuitter.addActionListener(e -> btnQuitterAction());

        panHaut = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panDroite = new JPanel(new FlowLayout());
        panCenter = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        panGauche = new JPanel(new FlowLayout());
        panBas = new JPanel(new FlowLayout());

        panHaut.add(txfAjout);
        panHaut.add(cmbBox);
        panHaut.add(btnAjouter);

        panDroite.add(listeDroite);
        panDroite.add(new JScrollPane(listeDroite));

        panCenter.add(btnGVD);
        panCenter.add(btnPGVD);
        panCenter.add(btnDVG);
        panCenter.add(btnPDVG);

        panGauche.add(listeGauche);
        panGauche.add(new JScrollPane(listeGauche));

        panBas.add(btnQuitter);

        frame.add(panHaut, BorderLayout.NORTH);
        frame.add(panDroite, BorderLayout.EAST);
        frame.add(panCenter, BorderLayout.CENTER);
        frame.add(panGauche, BorderLayout.WEST);
        frame.add(panBas, BorderLayout.SOUTH);

        frame.setVisible(true);

    }

    private void btnPDVGAction() {
        int[] indselD = listeDroite.getSelectedIndices();

        if (listeDroite.isSelectionEmpty())
            JOptionPane.showMessageDialog(frame, "Aucun élément sélectionné", "Attention", JOptionPane.WARNING_MESSAGE);
        else {
            indselD = listeDroite.getSelectedIndices();

            //add elements selected to list1
            for (int iElem: indselD)
                mdlGauche.addElement(mdlDroite.getElementAt(iElem));

            //remove elements selected from list2
            for (int i=indselD.length-1; i>=0; i--)
                mdlDroite.removeElementAt(indselD[i]);
        }
    }


    private void btnDVGAction() {
        if (listeDroite.isSelectionEmpty())
            JOptionPane.showMessageDialog(frame, "Aucun élément sélectionné", "Attention", JOptionPane.WARNING_MESSAGE);
        else {
            mdlGauche.insertElementAt(listeDroite.getSelectedValue(), 0);
            mdlDroite.removeElement(listeDroite.getSelectedValue());
        }
    }

    private void btnPGVDAction() {
        int[] indselG = listeGauche.getSelectedIndices();

        if (listeGauche.isSelectionEmpty())
            JOptionPane.showMessageDialog(frame, "Aucun élément sélectionné", "Attention", JOptionPane.WARNING_MESSAGE);
        else {
            indselG = listeGauche.getSelectedIndices();

            //add elements selected to list2
            for (int iElem: indselG)
                mdlDroite.addElement(mdlGauche.getElementAt(iElem));

            //remove elements selected from list1
            for (int i=indselG.length-1; i>=0; i--)
                mdlGauche.removeElementAt(indselG[i]);
        }
    }

    private void btnGVDAction() {
        if (listeGauche.isSelectionEmpty())
            JOptionPane.showMessageDialog(frame, "Aucun élément sélectionné", "Attention", JOptionPane.WARNING_MESSAGE);
        else {
            mdlDroite.insertElementAt(listeGauche.getSelectedValue(), 0);
            mdlGauche.removeElement(listeGauche.getSelectedValue());
        }
    }

    private void btnAjouterAction() {
        if (txfAjout.getText().equals("")) {
            JOptionPane.showMessageDialog(frame, "Le text field est vide", "Erreur text field vide", JOptionPane.ERROR_MESSAGE);
        } else if (cmbBox.getSelectedItem() == "Début") {
            mdlGauche.insertElementAt(txfAjout.getText(), 0);
            dataG[0] = txfAjout.getText();
        } else if (cmbBox.getSelectedItem() == "Milieu") {
            mdlGauche.insertElementAt(txfAjout.getText(), mdlGauche.getSize() / 2);
            dataG[mdlGauche.getSize() / 2] = txfAjout.getText();
        } else if (cmbBox.getSelectedItem() == "Fin") {
            mdlGauche.insertElementAt(txfAjout.getText(), mdlGauche.getSize());
            dataG[mdlGauche.getSize() - 2] = txfAjout.getText();
            System.out.println(dataG);
        }
    }

    private void btnQuitterAction() {
        int rep = JOptionPane.showConfirmDialog(frame, "Voulez-vous vraiment quitter?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (rep == 0) System.exit(0);
    }

    public static void main(String[] args) {
        Main m = new Main();
    }

}