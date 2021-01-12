package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Koneksi {
    public Connection con;
    public Statement stm;
    public Koneksi(){
        try {
            String url ="jdbc:mysql://127.0.0.1:3310/latihanajava";
            String user="root";
            String pass="secret";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
            stm = con.createStatement();
            System.out.println("koneksi berhasil;");
        } catch (Exception e) {
            System.err.println("koneksi gagal" +e.getMessage());
        }
    }
}
