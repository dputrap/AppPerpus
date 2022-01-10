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
public class modelPeminjaman {
    
    private String idPinjamModel;
    private String noAnggotaModel;
    private String idBukuModel;
    private String statusBukuModel;
    private String tglPinjamModel;
    private String durasiPinjamModel;
    
    koneksiDatabase koneksi = new koneksiDatabase();
    
    public modelPeminjaman(){
        
    }

    public String getIdPinjamModel() {
        return idPinjamModel;
    }

    public void setIdPinjamModel(String idPinjamModel) {
        this.idPinjamModel = idPinjamModel;
    }

    public String getNoAnggotaModel() {
        return noAnggotaModel;
    }

    public String getStatusBukuModel() {
        return statusBukuModel;
    }

    public void setStatusBukuModel(String statusBukuModel) {
        this.statusBukuModel = statusBukuModel;
    }

    public void setNoAnggotaModel(String noAnggotaModel) {
        this.noAnggotaModel = noAnggotaModel;
    }

    public String getIdBukuModel() {
        return idBukuModel;
    }

    public void setIdBukuModel(String idBukuModel) {
        this.idBukuModel = idBukuModel;
    }

    public String getTglPinjamModel() {
        return tglPinjamModel;
    }

    public void setTglPinjamModel(String tglPinjamModel) {
        this.tglPinjamModel = tglPinjamModel;
    }

    public String getDurasiPinjamModel() {
        return durasiPinjamModel;
    }

    public void setDurasiPinjamModel(String durasiPinjamModel) {
        this.durasiPinjamModel = durasiPinjamModel;
    }
    
    public void simpanDataPinjam(){
        
        //inisialisasi query untuk insert ke db
        String sql = ("INSERT INTO peminjaman (noAnggota, idBuku, statusBuku, tglPinjam, durasiPinjam) "
                + "VALUES ('"+getNoAnggotaModel()+"', "
                + "'"+getIdBukuModel()+"', "
                + "'"+getStatusBukuModel()+"', "
                + "'"+getTglPinjamModel()+"', "
                + "'"+getDurasiPinjamModel()+"')");
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
    
    public void deleteDataPinjam(){
        String sql = "DELETE FROM peminjaman WHERE idPinjam = "
                + " '"+getIdPinjamModel()+"'";
        
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
    
    public void updateDataPinjam(){
        
        String sql = "UPDATE peminjaman SET noAnggota = '"+getNoAnggotaModel()+"'"
                + " ,idBuku = '"+getIdBukuModel()+"'"
                + " ,statusBuku = '"+getStatusBukuModel()+"'"
                + " ,tglPinjam = '"+getTglPinjamModel()+"'"
                + " ,durasiPinjam = '"+getDurasiPinjamModel()+"' WHERE idPinjam = '"+getIdPinjamModel()+"'";
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
    
}
