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
public class modelKunjungan {
    
    private String noKunjungModel;
    private String tglKunjungModel;
    private String tujuanKunjung;
    private String noAnggotaModel;
    
    
    koneksiDatabase koneksi = new koneksiDatabase();
    
    public modelKunjungan(){
        
    }

    public String getNoAnggotaModel() {
        return noAnggotaModel;
    }

    public void setNoAnggotaModel(String noAnggotaModel) {
        this.noAnggotaModel = noAnggotaModel;
    }

    public String getNoKunjungModel() {
        return noKunjungModel;
    }

    public void setNoKunjungModel(String noKunjungModel) {
        this.noKunjungModel = noKunjungModel;
    }

    public String getTglKunjungModel() {
        return tglKunjungModel;
    }

    public void setTglKunjungModel(String tglKunjungModel) {
        this.tglKunjungModel = tglKunjungModel;
    }

    public String getTujuanKunjung() {
        return tujuanKunjung;
    }

    public void setTujuanKunjung(String tujuanKunjung) {
        this.tujuanKunjung = tujuanKunjung;
    }
    
    public void simpanDataKunjung(){
        
        //inisialisasi query untuk insert ke db
        String sql = ("INSERT INTO datakunjungan (noAnggota, tglKunjung, tujuanKunjung) "
                + "VALUES ('"+getNoAnggotaModel()+"','"+getTglKunjungModel()+"', '"+getTujuanKunjung()+"')");
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
    public void updateDataKunjung(){
        
        //inisialisasi query untuk insert ke db
        /*String sql = ("INSERT INTO pelanggan (namaPelanggan, noHP, jenisKelamin, umur, alamat) "
                + "VALUES ('"+getNamaPelangganModel()+"', '"+getNomorHpModel()+"'"
                + ", '"+getJenisKelaminModel()+"', '"+getUmur()+"', '"+getAlamat()+"')");
        */
        String sql = "UPDATE datakunjungan SET tglKunjung = '"+getTglKunjungModel()+"'"
                + " ,tujuanKunjung = '"+getTujuanKunjung()+"'"
                + "WHERE noKunjung = '"+getNoKunjungModel()+"'";
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
    
    public void deleteDataKunjung(){
        String sql = "DELETE FROM datakunjungan WHERE noKunjung = "
                + " '"+getNoKunjungModel()+"'";
        
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
