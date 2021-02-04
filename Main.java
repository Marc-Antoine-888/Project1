package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Main extends JFrame {

    Random r = new Random();
    int nbGenere = (r.nextInt(99) + 1);

    int min = 0;
    int max = 100;
    int nbdo = 0;

    JFrame frame;
    JLabel essais;
    JButton btnQuitter;

    Dimension dimBtn = new Dimension(55, 50);
    Dimension dimQuitter = new Dimension(600, 30);
    Dimension dimMin = new Dimension(650,700);

    public Main() {

        frame = new JFrame("Nombre Mystère");
        frame.setSize(650, 700);
        frame.setMinimumSize(dimMin);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        essais = new JLabel("0/10");
        essais.setPreferredSize(dimQuitter);
        frame.add(essais, BorderLayout.NORTH);

        for (int i = 1; i<101; i++) {
            JButton btn = new JButton("" + i);
            btn.addActionListener(e -> btnAction(e));
            btn.setPreferredSize(dimBtn);
            frame.add(btn, BorderLayout.CENTER);
        }
        
        btnQuitter = new JButton("Quitter");
        btnQuitter.setPreferredSize(dimQuitter);
        btnQuitter.addActionListener(e -> btnQuitterAction());

        frame.add(btnQuitter, BorderLayout.SOUTH);

        frame.setVisible(true);

    }

    private void btnAction(ActionEvent e) {
        JButton btnAction = (JButton)e.getSource();

        int nbentre = Integer.parseInt(btnAction.getText());
        System.out.println(nbGenere);

        System.out.println(nbentre);
            nbdo++;

            if (nbentre < nbGenere) {
                min = nbentre;
            }
            else if (nbentre > nbGenere) {
                max = nbentre;
            }
            else if (nbentre == nbGenere) {
                JOptionPane.showMessageDialog(frame, "Bravo! vous avez gagné", "GG", JOptionPane.PLAIN_MESSAGE);
                nbGenere = (r.nextInt(99) + 1);
                nbdo = 0;
                min = 1;
                max = 100;
                essais.setText("(" + nbdo + "/10) " + min + " < ? < " + max + ": ");
            }

        essais.setText("(" + nbdo + "/10) " + min + " < ? < " + max + ": ");

        if (nbentre != nbGenere && nbdo >= 10) {
            JOptionPane.showMessageDialog(frame, "Vous avez perdu le nombre mystère était " + nbGenere, "Noob", JOptionPane.PLAIN_MESSAGE);
            nbGenere = (r.nextInt(99) + 1);
            nbdo = 0;
            min = 1;
            max = 100;
            essais.setText("(" + nbdo + "/10) " + min + " < ? < " + max + ": ");
        }
    }

    private void btnQuitterAction() {
        int rep = JOptionPane.showConfirmDialog(frame, "Voulez-vous vraiment quitter?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (rep == 0) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Main m = new Main();

    }

}