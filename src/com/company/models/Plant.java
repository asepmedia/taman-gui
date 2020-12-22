package com.company.models;

import javax.swing.*;
import java.awt.*;

public class Plant{
    int statusTumbuh;//0-4
    int jumlahAir;
    int jumlahPupuk;
    String jenis;

    public Plant()
    {
        statusTumbuh = 0;
        jumlahAir = 0;
        jumlahPupuk = 0;
    }

    public void panen() {
        statusTumbuh = 0;
        jumlahAir = 0;
        jumlahPupuk = 0;
    }

    public void beriAir()
    {
        jumlahAir++;
        cekKondisiTumbuh();
        System.out.println(jumlahAir);
    }
    public void beriPupuk()
    {
        jumlahPupuk++;
        cekKondisiTumbuh();
    }
    public void cekKondisiTumbuh()
    {
        //cek kecukupan air dan pupuk
        if(jumlahAir >=3 && jumlahPupuk >=1)
        {
            tumbuh();
        }
    }
    public void tumbuh()
    {
        if(statusTumbuh <5)
        {
            jumlahAir = jumlahAir - 3;
            jumlahPupuk = jumlahPupuk - 1;
            statusTumbuh++;
        }
    }
    public void displayPlant()
    {
        System.out.println(getStatusTumbuhText());
        System.out.println("Jumlah Air:" + jumlahAir);
        System.out.println("Jumlah Pupuk:" + jumlahPupuk);
    }
    public String getStatusTumbuhText()
    {
        switch(statusTumbuh) {
            case 0:
                return "Benih";
            case 1:
                return "Tunas";
            case 2:
                return "Tanaman Kecil";
            case 3:
                return "Tanaman Dewasa";
        }
        return "Berbunga";
    }
    public int getStatusTumbuh()
    {
        return statusTumbuh;
    }
    public String getImagePath()
    {
        String tImagePath = "img/soil.png";
        switch(statusTumbuh) {
            case 0:
                tImagePath = "img/soil.png";
                break;
            case 1:
                tImagePath = "img/seed.png";
                break;
            case 2:
                tImagePath = "img/sprout.png";
                break;
            case 3:
                tImagePath = "img/small.png";
                break;
            case 4:
                tImagePath = "img/big.png";
                break;
            case 5:
                tImagePath = "img/blossom.png";
                break;
        }
        return tImagePath;
    }

    public ImageIcon createImageIcon(String path, String description) {
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

    public int getJumlahAir() {
        return jumlahAir;
    }

    public int getJumlahPupuk() {
        return jumlahPupuk;
    }

    public String getJenis() {
        return jenis;
    }
}
