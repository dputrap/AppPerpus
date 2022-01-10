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
public class modelPengembalian {
    
    private String idPengembalianModel;
    private String idPinjamModel;
    private String noAnggotaModel;
    private String idBukuModel;
    private String tglPengembalianModel;
    private String statusBukuModel;
    private String dendaModel;
    
    koneksiDatabase koneksi = new koneksiDatabase();
    
    public modelPengembalian(){
        
    }

    public String getIdPengembalianModel() {
        return idPengembalianModel;
    }

    public void setIdPengembalianModel(String idPengembalianModel) {
        this.idPengembalianModel = idPengembalianModel;
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

    public void setNoAnggotaModel(String noAnggotaModel) {
        this.noAnggotaModel = noAnggotaModel;
    }

    public String getIdBukuModel() {
        return idBukuModel;
    }

    public void setIdBukuModel(String idBukuModel) {
        this.idBukuModel = idBukuModel;
    }

    public String getTglPengembalianModel() {
        return tglPengembalianModel;
    }

    public void setTglPengembalianModel(String tglPengembalianModel) {
        this.tglPengembalianModel = tglPengembalianModel;
    }

    public String getStatusBukuModel() {
        return statusBukuModel;
    }

    public void setStatusBukuModel(String statusBukuModel) {
        this.statusBukuModel = statusBukuModel;
    }

    public String getDendaModel() {
        return dendaModel;
    }

    public void setDendaModel(String dendaModel) {
        this.dendaModel = dendaModel;
    }
    
    public void simpanDataPinjam(){
        
        //inisialisasi query untuk insert ke db
        String sql = ("INSERT INTO pengembalian (idPinjam, noAnggota, idBuku, statusBuku, "
                + "tglPengembalian, denda) "
                + "VALUES ('"+getIdPinjamModel()+"', "
                + "'"+getNoAnggotaModel()+"', "
                + "'"+getIdBukuModel()+"', "
                + "'"+getStatusBukuModel()+"', "
                + "'"+getTglPengembalianModel()+"', "
                + "'"+getDendaModel()+"')");
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
        String sql = "DELETE FROM pengembalian WHERE idPengembalian = "
                + " '"+getIdPengembalianModel()+"'";
        
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
        
        String sql = "UPDATE pengembalian SET idPinjam = '"+getIdPinjamModel()+"'"
                + " ,noAnggota = '"+getNoAnggotaModel()+"'"
                + " ,idBuku = '"+getIdBukuModel()+"'"
                + " ,statusBuku = '"+getStatusBukuModel()+"'"
                + " ,tglPengembalian = '"+getTglPengembalianModel()+"'"
                + " ,denda = '"+getDendaModel()+"' WHERE idPengembalian = '"+getIdPengembalianModel()+"'";
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
