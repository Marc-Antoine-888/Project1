package com.company;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;


public class Main extends JFrame {
    JFrame frame;
    JLabel labNom;
    JTextField txfNom;
    JButton btnInfo;

    public Main() {
        frame = new JFrame("Chapitre 6 - Atelier 1");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        JLabel labMsg = new JLabel("Entrez votre nom ");
        txfNom = new JTextField();
        txfNom.setPreferredSize(new Dimension(275, 30));

        btnInfo = new JButton("Saisir Info");
        btnInfo.addActionListener(e -> btnInfoAction());

        labNom = new JLabel();

        frame.add(labMsg);
        frame.add(txfNom);
        frame.add(btnInfo);
        frame.add(labNom);
        frame.setVisible(true);
    }

    private void btnInfoAction() {
        Main2 main2 = new Main2(txfNom.getText());
        if (main2.getisOK()) {
            Date dateNaissance = main2.getDateNaissance();
            LocalDate dateN = dateNaissance.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            long nbJours = dateN.until(LocalDate.now(), ChronoUnit.DAYS);
            long age = dateN.until(LocalDate.now(), ChronoUnit.YEARS);
            labNom.setText("Vous avez " + age + " ans, vous êtes né depuis " + nbJours + " jours.");

        } else {
            labNom.setText("");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
    }

}
