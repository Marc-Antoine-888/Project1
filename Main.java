package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class Main extends JFrame {

    JFrame frame;
    JList liste;
    JTextField txfMin;
    JTextField txfMax;
    JTextField txfMoy;
    JButton btnGo;
    JButton btnSelecTout;
    JCheckBox chbMulti;
    JButton btnQuitter;
    JPanel pandroit;

    Dimension dimBtn = new Dimension(70, 50);
    Dimension dimQuitter = new Dimension(350, 30);
    Dimension dimMin = new Dimension(700, 400);
    Dimension dimTxf = new Dimension(350,30);
    Dimension dimListe = new Dimension(200, 400);
    Dimension dimPan = new Dimension(350,400);

    Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public Main() {

        frame = new JFrame("Nombre Mystère");
        frame.setSize(700, 400);
        frame.setMinimumSize(dimMin);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        pandroit = new JPanel(new FlowLayout((FlowLayout.CENTER)));
        pandroit.setPreferredSize(dimPan);


        liste = new JList(data);
        liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        liste.setPreferredSize(dimListe);
        liste.setPreferredSize(new Dimension(300, 400));
        liste.addListSelectionListener(e -> ListSelectionChange(e));
        liste.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    System.out.println(liste.getSelectedValue());
                }
            }
        });


        txfMin = new JTextField("txfMin");
        txfMin.setPreferredSize(dimTxf);

        txfMoy = new JTextField("txfMoy");
        txfMoy.setPreferredSize(dimTxf);

        txfMax = new JTextField("txfMax");
        txfMax.setPreferredSize(dimTxf);

        chbMulti = new JCheckBox("Multisélection");
        chbMulti.setSelected(false);

        btnGo = new JButton("Go");
        btnGo.setPreferredSize(dimBtn);
        btnGo.addActionListener(e -> btnGoAction());

        btnSelecTout = new JButton("Sélectionner tout");
        btnSelecTout.setPreferredSize(dimQuitter);
        btnSelecTout.addActionListener(e -> btnSelecToutAction());
        
        btnQuitter = new JButton("Quitter");
        btnQuitter.setPreferredSize(dimQuitter);
        btnQuitter.addActionListener(e -> btnQuitterAction());


        frame.add(liste, BorderLayout.WEST);

        pandroit.add(txfMin);
        pandroit.add(txfMax);
        pandroit.add(txfMoy);
        pandroit.add(btnGo);
        pandroit.add(chbMulti);
        pandroit.add(btnSelecTout);
        pandroit.add(btnQuitter);

        frame.add(pandroit, BorderLayout.EAST);


        frame.setVisible(true);

    }

    private void ListSelectionChange(ListSelectionEvent e) {
        if (e.getValueIsAdjusting())
            System.out.println(liste.getSelectedValue());

        if(chbMulti.isSelected()) {
            liste.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        }
    }

    private void btnGoAction() {
        int[] indSel = liste.getSelectedIndices();
        int nbsel = indSel.length;
        int moy = 0;
        int indmax = liste.getMaxSelectionIndex();
        int indmin = liste.getMinSelectionIndex();

        for (int i = 0; i < indSel.length; i++) {
            moy = moy + (data[indSel[i]]);
            txfMoy.setText(String.valueOf(moy / nbsel));
        }

        txfMin.setText(String.valueOf(data[indmin]));
        txfMax.setText(String.valueOf(data[indmax]));
    }

    private void btnSelecToutAction() {
        int i = 0;
        int j = 8;
        liste.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        liste.setSelectionInterval(i, j);
    }

    private void btnQuitterAction() {
        int rep = JOptionPane.showConfirmDialog(frame, "Voulez-vous vraiment quitter?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (rep == 0) System.exit(0);
    }

    public static void main(String[] args) {
        Main m = new Main();

    }

}