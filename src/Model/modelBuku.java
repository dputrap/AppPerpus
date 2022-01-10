/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.koneksiDatabase;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Danu Putra
 */
public class modelBuku {
    
    String idBukuModel;
    String namaBukuModel;
    String stok;
    
    koneksiDatabase koneksi = new koneksiDatabase();
    
    public modelBuku(){
        
    }

    public String getIdBukuModel() {
        return idBukuModel;
    }

    public void setIdBukuModel(String idBukuModel) {
        this.idBukuModel = idBukuModel;
    }

    public String getNamaBukuModel() {
        return namaBukuModel;
    }

    public void setNamaBukuModel(String namaBukuModel) {
        this.namaBukuModel = namaBukuModel;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public koneksiDatabase getKoneksi() {
        return koneksi;
    }

    public void setKoneksi(koneksiDatabase koneksi) {
        this.koneksi = koneksi;
    }
    
    public void simpanDataBuku(){
        
        //inisialisasi query untuk insert ke db
        String sql = ("INSERT INTO buku (idBuku, namaBuku, stok) "
                + "VALUES ('"+getIdBukuModel()+"', "
                + "'"+getNamaBukuModel()+"', "
                + "'"+getStok()+"')");
        try{
        //preparedstatement
        PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
        eksekusi.execute();
        
        //pemberitahuan jika berhasil
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (SQLException ex){
            //Logger.getLogger(modelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan \n "+ex);
        }
        
        }
    public void updateDataBuku(){
        
        String sql = "UPDATE buku SET idBuku = '"+getIdBukuModel()+"'"
                + " ,namaBuku = '"+getNamaBukuModel()+"'"
                + " ,stok = '"+getStok()+"' WHERE idBuku = '"+getIdBukuModel()+"'";
        try{
        //preparedstatement
        PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
        eksekusi.execute();
        
        //pemberitahuan jika berhasil
        JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
        } catch (SQLException ex){
            //Logger.getLogger(modelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data Gagal Diupdate \n "+ex);
        }
        
        }
    
    public void deleteDataBuku(){
        String sql = "DELETE FROM buku WHERE idBuku = "
                + " '"+getIdBukuModel()+"'";
        
        try{
        //preparedstatement
        PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
        eksekusi.execute();
        
        //pemberitahuan jika berhasil
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException ex){
            //Logger.getLogger(modelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus \n "+ex);
        }
    }
}
