/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.FileInputStream;
import java.sql.DriverManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Danu Putra
 */
public class koneksiDatabase {
    //inisialisasi variabel dengan Connection file class JDBC
    public static Connection conn;
    //kemudian fungsi class Propertien untuk memanggil file konfig database yang kita buat sebelumnya
    private static Properties propert = new Properties();
    //inisialisasi variable statement
    public Statement stm;
    //membuat fungsi untuk koneksi ke database
    public static Connection getKoneksi()throws SQLException{
        //cek apakah ada koneksi
        if(conn == null){
            try{
            //load file konfigurasiDatabase.properties
            propert.load(new FileInputStream("C:\\Users\\Danu Putra\\OneDrive\\Documents\\NetBeansProjects\\AppPerpus\\src\\Database\\konfigurasiDatabase.properties"));
            }catch (IOException ex){
                Logger.getLogger(koneksiDatabase.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("error mengambil file"+ex);
                
                System.err.println("error membaca file file"+ex);
           }
            //inisialisasi koneksi database
            conn = DriverManager.getConnection(propert.getProperty("jdbc.url"),propert.getProperty("jdbc.username"),propert.getProperty("jdbc.password"));
        
        }
        return conn;
    }
    public static void main(String[] args) throws SQLException{
        if (getKoneksi().equals(conn)){
            System.out.println("sukses terkoneksi");
        }
    }
    
    public void login(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/perpus", "root", "");
            stm = conn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
        }
    }
    
}
