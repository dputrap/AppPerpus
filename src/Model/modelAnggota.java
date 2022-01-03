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
public class modelAnggota {
    String noAnggotaModel;
    String namaModel;
    String kelasModel;
    String ttlModel;
    String alamatModel;
    
    koneksiDatabase koneksi = new koneksiDatabase();
    
    public modelAnggota(){
        
    }

    public String getNoAnggotaModel() {
        return noAnggotaModel;
    }

    public void setNoAnggotaModel(String noAnggotaModel) {
        this.noAnggotaModel = noAnggotaModel;
    }

    public String getNamaModel() {
        return namaModel;
    }

    public void setNamaModel(String namaModel) {
        this.namaModel = namaModel;
    }

    public String getKelasModel() {
        return kelasModel;
    }

    public void setKelasModel(String kelasModel) {
        this.kelasModel = kelasModel;
    }

    public String getTtlModel() {
        return ttlModel;
    }

    public void setTtlModel(String ttlModel) {
        this.ttlModel = ttlModel;
    }

    public String getAlamatModel() {
        return alamatModel;
    }

    public void setAlamatModel(String alamatModel) {
        this.alamatModel = alamatModel;
    }

    public koneksiDatabase getKoneksi() {
        return koneksi;
    }

    public void setKoneksi(koneksiDatabase koneksi) {
        this.koneksi = koneksi;
    }
    
    public void simpanDataAnggota(){
        
        //inisialisasi query untuk insert ke db
        String sql = ("INSERT INTO anggota (noAnggota, nama, kelas, ttl, alamat) "
                + "VALUES ('"+getNoAnggotaModel()+"', '"+getNamaModel()+"'"
                + ", '"+getKelasModel()+"', '"+getTtlModel()+"', '"+getAlamatModel()+"')");
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
    public void updateDataAnggota(){
        
        //inisialisasi query untuk insert ke db
        /*String sql = ("INSERT INTO pelanggan (namaPelanggan, noHP, jenisKelamin, umur, alamat) "
                + "VALUES ('"+getNamaPelangganModel()+"', '"+getNomorHpModel()+"'"
                + ", '"+getJenisKelaminModel()+"', '"+getUmur()+"', '"+getAlamat()+"')");
        */
        String sql = "UPDATE anggota SET noAnggota = '"+getNoAnggotaModel()+"'"
                + " ,nama = '"+getNamaModel()+"'"
                + " ,kelas = '"+getKelasModel()+"'"
                + " ,ttl = '"+getTtlModel()+"'"
                + " ,alamat = '"+getAlamatModel()+"' WHERE noAnggota = '"+getNoAnggotaModel()+"'";
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
    
    public void deleteDataAnggota(){
        String sql = "DELETE FROM anggota WHERE noAnggota = "
                + " '"+getNoAnggotaModel()+"'";
        
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
