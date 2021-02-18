package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame {
    JFrame frame;
    JTable table;

    String[] villes = {"Alma", "Joliette", "Montréal", "Crabtee", "Bonaventure", "Sorel"};
    Integer[][] data = {
            {0, 437, 479, 444, 620, 430},
            {437, 0, 70, 8, 822, 34},
            {479, 70, 0, 63, 850, 80},
            {444, 8, 63, 0, 828, 40},
            {620, 822, 850, 828, 0, 804},
            {430, 34, 80, 40, 804, 0}
    };

public Main() {
    frame = new JFrame("Atelier 3 JTable");
    frame.setLayout(new FlowLayout());
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    frame.setSize(new Dimension(600, 400));


    table = new JTable(data, villes);

    table = new JTable(data, villes){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    JScrollPane scroll = new JScrollPane(table);
    scroll.setPreferredSize(new Dimension(400,200));

    JPanel panLabel = new JPanel();
    panLabel.setLayout(new BoxLayout(panLabel, BoxLayout.Y_AXIS));
    for (int i=0; i<villes.length; i++)
        panLabel.add(new JLabel(villes[i]));
    scroll.setRowHeaderView(panLabel);

    table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting())
                tableSelectionChange();
        }
    });

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

    public void tableSelectionChange() {
        int[] selIndex = table.getSelectedRows();
        int nMax = 0;
        int iMax = 0;
        int nMin = 0;
        int iMin = 0;

        for(int iLigne = 0; iLigne<selIndex.length; iLigne++) {
            for(int iCol = 0; iCol < villes.length; iCol++) {
                if(nMin == 0 && data[selIndex[iLigne]][iCol] != 0)
                    nMin = data[selIndex[iLigne]][iCol];

                if (nMax < data[selIndex[iLigne]][iCol] && data[selIndex[iLigne]][iCol] > 0) {
                    nMax = data[selIndex[iLigne]][iCol];
                    iMax = iCol;
                }

                if (nMin > data[selIndex[iLigne]][iCol] && data[selIndex[iLigne]][iCol] > 0) {
                    nMin = data[selIndex[iLigne]][iCol];
                    iMin = iCol;
                }
            }
        }
        System.out.println("La ville la plus loin de " + villes[selIndex[0]] + " est " + villes[iMax]);
        System.out.println("La ville la plus près de " + villes[selIndex[0]] + " est " + villes[iMin]);

    }

    public static void main(String[] args) {
        Main main = new Main();
    }

}
