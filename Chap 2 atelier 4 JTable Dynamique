package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;

public class Main extends JFrame {
    JFrame frame;
    JTable table;
    DefaultTableModel model;
    JButton btnConvertir;
    JButton btnPlus;
    JButton btnMoins;

    String[] colNames = {"ID", "Nom"};


    public Main() {
        frame = new JFrame("JTable");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 700);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        model = new DefaultTableModel(colNames, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(model);

        for (int i=1; i<=15; i++){
            Object[] row = {i, "ligne" + i};
            model.addRow(row);
        }

        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(400, 600));


        btnMoins = new JButton("-");
        btnMoins.addActionListener(e -> btnMoinsAction());
        btnPlus = new JButton("+");
        btnPlus.addActionListener(e -> btnPlusAction());
        btnConvertir = new JButton("Convertir");
        btnConvertir.addActionListener(e -> btnConvertirAction());

        frame.add(btnConvertir);
        frame.add(btnPlus);
        frame.add(btnMoins);
        frame.add(scroll);
        frame.setVisible(true);
    }

    private void btnMoinsAction() {
        if (!table.getSelectionModel().isSelectionEmpty()){
            int[] sel = table.getSelectedRows();

            for (int i=sel.length-1; i>=0; i--)
                model.removeRow(sel[i]);
        }
    }

    private void btnPlusAction() {
        Integer dernier = (Integer) model.getValueAt(model.getRowCount()-1, 0);

        Object[] row = {dernier+1, "ligne " + (dernier + 1)};
        model.addRow(row);
    }

    private void btnConvertirAction() {
        String[][] t2d = convertT2D(model);
        System.out.println(Arrays.deepToString(t2d));
    }

    private String[][] convertT2D(DefaultTableModel m) {
        String[][] tab = new String[m.getRowCount()][m.getColumnCount()];

        for (int i=0; i<m.getRowCount(); i++)
            for (int j=0; j<m.getColumnCount(); j++)
                tab[i][j] = String.valueOf(m.getValueAt(i,j));

        return tab;
    }

    public static void main(String[] args) {
        Main main = new Main();
    }



}
