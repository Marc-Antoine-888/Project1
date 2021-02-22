package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class Main extends JFrame {
    JFrame frame;
    JTable table;

    String[] colNames = {"Prénom", "Nom", "Âge"};

    String[][] data= {
            {"Déneige", "Lacour", "35"},
            {"Jean", "Bon", "50"},
            {"Alex", "Thérieur", "2"},
            {"Alain", "Dlapen", "22"},
            {"Amphès", "Lacour", "11"},
            {"toto", "Info", "22"},
            {"tata", "Info", "22"},
            {"titi", "Info", "23"},
            {"Alice", "Fréchette", "24"},
    };

    public Main() {
        frame = new JFrame("JTable");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        //Jtable non éditable
        table = new JTable(data, colNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        //mono sélection
        //table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //gérer taille JTable
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(400, 100));

        //gérer taille colonne
        TableColumn col = table.getColumn("Prénom");
        col.setPreferredWidth(200);

        //écouteur sur sélection JTable
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting())
                    tableSelectionChange();
            }
        }); //table.getSelectionModel().addListSelectionListener(e -> tableSelectionChange()); fait la même chose

        //Écouteur flèche haut/bas
        table.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)
                    tableSelectionChange();
            }
        });

        frame.add(scroll);

        frame.setVisible(true);
    }

    public void tableSelectionChange(){
        //afficher la ligne sélectionner
        /**int selIndex = table.getSelectedRow();
        System.out.println(Arrays.toString(data[selIndex]));

        //parcourir les éléments de la ligne sélectionnée
        for (int iCol = 0; iCol < colNames.length; iCol++) {
            System.out.print(data[selIndex][iCol] + " ");
        }*/
        int[] sel = table.getSelectedRows();
        //System.out.println(Arrays.toString(sel));

        //Afficher les lignes sélectionnées
        //for (int i=0; i < sel.length; i++) {
            //System.out.println(Arrays.toString(data[sel[i]]));
        //}

        //Afficher les éléments des lignes sélectionnées
        for (int iLigne=0; iLigne<sel.length; iLigne++) {
            for (int iCol=0; iCol<colNames.length; iCol++) {
                System.out.print(data[sel[iLigne]][iCol] + " ");
            }
        }

    }

    public static void main(String[] args) {
        Main main = new Main();
    }



}
