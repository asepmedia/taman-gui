package com.company.models;

import com.company.Koneksi;

import java.sql.ResultSet;

public class DataPoint {
    public int poin;

    Koneksi koneksi = new Koneksi();

    public DataPoint() {
        getPoin();
    }

    public int getPoin() {
        try {
            String getPoint = "SELECT poin FROM poin";
            ResultSet rs = koneksi.stm.executeQuery(getPoint);

            while(rs.next()) {
                setPoin(rs.getInt("poin"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return poin;
    }

    public DataPoint updatePoint(int poin) {
        try {
            String updatePoin = "UPDATE poin SET poin = poin + %s";
            updatePoin = String.format(updatePoin, poin);

            koneksi.stm.execute(updatePoin);
            System.out.println("Menambahkan poin : " + poin);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }

    public DataPoint setPoin(int poin) {
        this.poin = poin;
        return this;
    }
}
