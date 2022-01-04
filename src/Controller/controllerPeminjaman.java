/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.modelPeminjaman;
import View.viewPeminjamanInternal;

/**
 *
 * @author Danu Putra
 */
public class controllerPeminjaman {
    
    private modelPeminjaman mP;
    private viewPeminjamanInternal vP;
    
    public controllerPeminjaman(viewPeminjamanInternal vP){
        this.vP = vP;
    }
    
    
    public void foreign(){
        
        vP.getNoAnggotaView().setEnabled(false);
        vP.getIdBukuView().setEnabled(false);
        
    }
    
    public void enable(){
        
        vP.getNoAnggotaView().setEnabled(true);
        vP.getIdBukuView().setEnabled(true);
        
    }
    
    public void bersihkan(){
        //memanggil variable swing di view
        vP.getIdPinjamView().setText("");
        vP.getNoAnggotaView().setText("");
        vP.getIdBukuView().setText("");
        vP.getStatusBukuView().setText("");
        vP.getTglPinjamView().setText("");
        vP.getDurasiPinjamView().setText("");
        vP.getNamaAnggotaView().setText("");
    }
    
    //fungsi kontrol button disable not clickable
    public void kontrolButton(){
        vP.getTombolSimpan().setEnabled(true);
        vP.getTombolUbah().setEnabled(false);
        vP.getTombolHapus().setEnabled(false);
        vP.getTombolBatal().setEnabled(false);
    }
    
    public void kontrolButtonDua(){
        vP.getTombolSimpan().setEnabled(false);
        vP.getTombolUbah().setEnabled(true);
        vP.getTombolHapus().setEnabled(true);
        vP.getTombolBatal().setEnabled(true);
    }
    
    public void deleteData(){
        mP = new modelPeminjaman();
        mP.setIdPinjamModel(vP.getIdPinjamView().getText());
        mP.deleteDataPinjam();
        bersihkan();
        kontrolButton();
    }
    
    public void updateData(){
        mP = new modelPeminjaman();
        mP.setIdPinjamModel(vP.getIdPinjamView().getText());
        mP.setNoAnggotaModel(vP.getNoAnggotaView().getText());
        mP.setIdBukuModel(vP.getIdBukuView().getText());
        mP.setStatusBukuModel(vP.getStatusBukuView().getText());
        mP.setTglPinjamModel(vP.getTglPinjamView().getText());
        mP.setDurasiPinjamModel(vP.getDurasiPinjamView().getText());
        
        mP.updateDataPinjam();
        bersihkan();
        kontrolButton();
    }
    
    public void simpan(){
        mP = new modelPeminjaman();
        mP.setNoAnggotaModel(vP.getNoAnggotaView().getText());
        mP.setIdBukuModel(vP.getIdBukuView().getText());
        mP.setStatusBukuModel(vP.getStatusBukuView().getText());
        mP.setTglPinjamModel(vP.getTglPinjamView().getText());
        mP.setDurasiPinjamModel(vP.getDurasiPinjamView().getText());
        
        mP.simpanDataPinjam();
        bersihkan();
        //JOptionPane.showConfirmDialog(vP, " Nama Pelanggan : "+mP.getNamaPelangganModel()+"\n Nomor Hp : "+mP.getNomorHpModel()
        //+"\n Jenis Kelamin : "+mP.getJenisKelaminModel()+"\n Umur : "+mP.getUmur()+"\n Alamat: "+mP.getAlamat());
    }
    
}
