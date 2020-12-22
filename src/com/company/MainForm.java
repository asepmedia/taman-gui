package com.company;

import javax.swing.*;
import java.net.URI;
import java.net.URL;

public class MainForm {
    private JFrame jFrame = new JFrame("Aplikasi Garden");
    private JPanel jPanel = new JPanel();

    public MainForm() {
        JButton btnBeriAir = new JButton("Siram");
        JButton btnSiram = new JButton("Pupuk");

        JLabel namaKelompok = new JLabel("Bibit");
        namaKelompok.setIcon(createIcon("img/seed.png"));
        namaKelompok.setHorizontalTextPosition(JLabel.CENTER);
        namaKelompok.setVerticalTextPosition(JLabel.BOTTOM);

        jPanel.add(namaKelompok);
        jPanel.add(btnBeriAir);
        jPanel.add(btnSiram);

        jFrame.add(jPanel);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(500, 400);
        jFrame.setVisible(true);
    }

    public ImageIcon createIcon(String path) {
        ImageIcon imageIcon = null;

        try {
            URL rsc = getClass().getResource(path);
            imageIcon = new ImageIcon(rsc);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return imageIcon;

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainForm::new);
    }
}
