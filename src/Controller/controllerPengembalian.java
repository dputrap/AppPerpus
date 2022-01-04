/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.modelPengembalian;
import View.viewPengembalianInternal;

/**
 *
 * @author Danu Putra
 */
public class controllerPengembalian {
    
    private modelPengembalian mPE;
    private viewPengembalianInternal vPI;
    
    public controllerPengembalian(viewPengembalianInternal vPI){
        this.vPI = vPI;
    }
    
    public void bersihkan(){
        //memanggil variable swing di view
        vPI.getIdPengembalianView().setText("");
        vPI.getIdPinjamView().setText("");
        vPI.getNoAnggotaView().setText("");
        vPI.getIdBukuView().setText("");
        vPI.getStatusBukuView().setText("");
        vPI.getTglPengembalianView().setText("");
        vPI.getDendaView().setText("");
        vPI.getTelatView().setText("");
    }
    
    //fungsi kontrol button disable not clickable
    public void kontrolButton(){
        vPI.getTombolSimpan().setEnabled(true);
        vPI.getTombolUbah().setEnabled(false);
        vPI.getTombolHapus().setEnabled(false);
        vPI.getTombolBatal().setEnabled(false);
    }
    
    public void kontrolButtonDua(){
        vPI.getTombolSimpan().setEnabled(false);
        vPI.getTombolUbah().setEnabled(true);
        vPI.getTombolHapus().setEnabled(true);
        vPI.getTombolBatal().setEnabled(true);
    }
    
    public void deleteData(){
        mPE = new modelPengembalian();
        mPE.setIdPengembalianModel(vPI.getIdPengembalianView().getText());
        mPE.deleteDataPinjam();
        bersihkan();
        kontrolButton();
    }
    
    public void updateData(){
        mPE = new modelPengembalian();
        mPE.setIdPengembalianModel(vPI.getIdPengembalianView().getText());
        mPE.setIdPinjamModel(vPI.getIdPinjamView().getText());
        mPE.setNoAnggotaModel(vPI.getNoAnggotaView().getText());
        mPE.setIdBukuModel(vPI.getIdBukuView().getText());
        mPE.setStatusBukuModel(vPI.getStatusBukuView().getText());
        mPE.setTglPengembalianModel(vPI.getTglPengembalianView().getText());
        mPE.setDendaModel(vPI.getDendaView().getText());
        
        mPE.updateDataPinjam();
        bersihkan();
        kontrolButton();
    }
    
    public void simpan(){
        mPE = new modelPengembalian();
        mPE.setIdPinjamModel(vPI.getIdPinjamView().getText());
        mPE.setNoAnggotaModel(vPI.getNoAnggotaView().getText());
        mPE.setIdBukuModel(vPI.getIdBukuView().getText());
        mPE.setStatusBukuModel(vPI.getStatusBukuView().getText());
        mPE.setTglPengembalianModel(vPI.getTglPengembalianView().getText());
        mPE.setDendaModel(vPI.getDendaView().getText());
        
        mPE.simpanDataPinjam();
        bersihkan();
        //JOptionPane.showConfirmDialog(vP, " Nama Pelanggan : "+mP.getNamaPelangganModel()+"\n Nomor Hp : "+mP.getNomorHpModel()
        //+"\n Jenis Kelamin : "+mP.getJenisKelaminModel()+"\n Umur : "+mP.getUmur()+"\n Alamat: "+mP.getAlamat());
    }
    
}
