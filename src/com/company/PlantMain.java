package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.company.adapter.PlantAdapter;
import com.company.models.Anggrek;
import com.company.models.Mawar;
import com.company.models.Melati;
import com.company.models.Plant;

public class PlantMain {
    JFrame jFrame = new JFrame("Latihan");
    JList<Plant> plants = new JList<>();
    DefaultListModel<Plant> model = new DefaultListModel<>();
    Plant selectedPlant;

    JLabel label = new JLabel();
    JLabel labelIcon = new JLabel();
    JButton labelJumlahAir = new JButton();
    JButton labelJumlahPupuk = new JButton();
    JButton labelStatus = new JButton();

    JPanel panel = new JPanel();
    JSplitPane splitPane = new JSplitPane();


    public PlantMain() {
        try {
            ArrayList<Plant> listPlant = new ArrayList<>();
            listPlant.add(new Mawar());
            listPlant.add(new Anggrek());
            listPlant.add(new Melati());

            listPlant.forEach(p -> {
                model.addElement(p);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        plants.setCellRenderer(new PlantAdapter());
        plants.setModel(model);

        plants.getSelectionModel().addListSelectionListener(e -> {
            selectedPlant = plants.getSelectedValue();
            JButton btnBeriAir = new JButton("Beri Air");
            JButton btnBeriPupuk = new JButton("Beri Pupuk");
            JButton btnPanen = new JButton("Panen");

            //set label
            labelJumlahAir.setText("Air : " + selectedPlant.getJumlahAir());
            labelJumlahPupuk.setText("Pupuk : " + selectedPlant.getJumlahPupuk());
            labelStatus.setText("Status : " + selectedPlant.getStatusTumbuhText());

            labelIcon.setIcon(createImageIcon(selectedPlant.getImagePath(), ""));
            labelIcon.setText(selectedPlant.getJenis());
            labelIcon.setHorizontalTextPosition(JLabel.CENTER);
            labelIcon.setVerticalTextPosition(JLabel.BOTTOM);

            label.setIcon(createImageIcon(selectedPlant.getImagePath(), ""));
            label.setPreferredSize(new Dimension(400, 80));
            label.setLayout(new BorderLayout());
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.BOTTOM);

            JPanel panelDetail = new JPanel();
            GridLayout gridLayout = new GridLayout(2, 2);
            panelDetail.setLayout(gridLayout);
            panelDetail.setPreferredSize(new Dimension(400, 100));
            panelDetail.add(btnBeriAir);
            panelDetail.add(btnBeriPupuk);
//            panelDetail.add(btnPanen);
            panelDetail.repaint();
            label.add(panelDetail);
            panel.repaint();

            btnBeriAir.addActionListener(new ActionListener() {
                int passed = 0;
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Beri Air");
                    selectedPlant.beriAir();
                    labelJumlahAir.setText("Air : " + selectedPlant.getJumlahAir());
                    labelJumlahPupuk.setText("Pupuk : " + selectedPlant.getJumlahPupuk());
                    labelStatus.setText("Status : " + selectedPlant.getStatusTumbuhText());
                    splitPane.repaint();
                    labelIcon.setIcon(createImageIcon(selectedPlant.getImagePath(), ""));
                    labelIcon.repaint();
                }
            });

            btnBeriPupuk.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectedPlant.beriPupuk();
                    labelJumlahAir.setText("Air : " + selectedPlant.getJumlahAir());
                    labelJumlahPupuk.setText("Pupuk : " + selectedPlant.getJumlahPupuk());
                    labelStatus.setText("Status : " + selectedPlant.getStatusTumbuhText());
                    splitPane.repaint();
                    labelIcon.setIcon(createImageIcon(selectedPlant.getImagePath(), ""));
                    labelIcon.repaint();
                }
            });
        });

        splitPane.setLeftComponent(new JScrollPane(plants));
        panel.add(labelIcon);
        panel.add(labelStatus);
        panel.add(labelJumlahAir);
        panel.add(labelJumlahPupuk);
        panel.add(label);
        splitPane.setRightComponent(panel);

        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.add(splitPane);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setSize(1000, 700);
    }


    protected ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            ImageIcon imageIcon = new ImageIcon(imgURL, description);
            Image image = imageIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            imageIcon = new ImageIcon(newimg);  // transform it back
            return imageIcon;
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PlantMain::new);
    }
}