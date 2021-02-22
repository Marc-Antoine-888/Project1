package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class Main extends JFrame {
    JFrame frame;
    JTable table;
    DefaultTableModel model;
    JButton btnGo;

    String[] colNames = {"ID", "Nom", "Description"};
    String[][] data= {
            {"1", "pdA", "Le produit A"},
            {"2", "pdB", "Le produit B"},
            {"3", "pdC", "Le produit C"},
    };

    public Main() {
        frame = new JFrame("JTable");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        model = new DefaultTableModel(data, colNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        /**
         * model = new DefaultTableModel(colNames, 0);
         * for (int i = 0; i <= 10; i++)
         * model.addRow(...);
         */

        table = new JTable(model);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(400, 100));

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e){
                if (e.getValueIsAdjusting())
                    if (e.getValueIsAdjusting())
                    tableSelectionChange();
            }
        });

        table.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
        public void keyReleased(KeyEvent e){
            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)
                tableSelectionChange();
            }
        });

        btnGo = new JButton("GO");
        btnGo.addActionListener(e -> btnGoAction());

        frame.add(btnGo);
        frame.add(scroll);
        frame.setVisible(true);
    }

    private void btnGoAction() {
        //ajouter une ligne à la fin du model
        String[] row = {"4", "pdD", "Le produit D"};
        model.addRow(row);

        model.insertRow(0, new String[] {"0", "pd0", "Le produit 0"});

        model.removeRow(1);

        System.out.println(model.getRowCount());
    }

    private void tableSelectionChange() {
        /**
        //single
        int selIndex = table.getSelectedRow();

        //statique
        for (int i=0; i<colNames.length; i++)
            System.out.println(data[selIndex][i]);
        //dynamique
        for (int iCol=0; iCol < model.getColumnCount(); iCol++)
            System.out.println(model.getValueAt(selIndex,iCol) + " ");
         */

        /**
        //Multiple
        int[] sel = table.getSelectedRows();

        //statique
        for (int iLigne = 0; iLigne < sel.length; iLigne++) {
            for (int iCol = 0; iCol < colNames.length; iCol++) {
                System.out.print((data[sel[iLigne]][iCol]) + " ");
            }
            System.out.println("");
        }

        //dynamique
        for (int iLigne = 0; iLigne < sel.length; iLigne++) {
            for (int iCol = 0; iCol < model.getColumnCount(); iCol++) {
                System.out.print((model.getValueAt(sel[iLigne], iCol) + " "));
            }
            System.out.println("");
        }
         */

        //Parcourir la ligne séelctionnée et modifier les cellules par "---"
        int index = table.getSelectedRow();
        for (int iCol = 0; iCol < model.getColumnCount(); iCol++) {
            model.setValueAt("---", index, iCol);
        }

        System.out.println(Arrays.deepToString(data));

    }


    public static void main(String[] args) {
        Main main = new Main();
    }



}
