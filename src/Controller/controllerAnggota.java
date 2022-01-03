/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.modelAnggota;
import View.viewAnggotaInternal;

/**
 *
 * @author Danu Putra
 */
public class controllerAnggota {
    
    private modelAnggota mA;
    private viewAnggotaInternal vA;
    
    public controllerAnggota(viewAnggotaInternal vA){
        this.vA = vA;
    }
    
    public void bersihkan(){
        //memanggil variable swing di view
        vA.getNoAnggotaView().setText("");
        vA.getNamaView().setText("");
        vA.getKelasView().setText("");
        vA.getTtlView().setText("");
        vA.getAlamatView().setText("");
    }
    
    //fungsi kontrol button disable not clickable
    public void kontrolButton(){
        vA.getTombolSimpan().setEnabled(true);
        vA.getTombolUbah().setEnabled(false);
        vA.getTombolHapus().setEnabled(false);
        vA.getTombolBatal().setEnabled(false);
    }
    
    public void kontrolButtonDua(){
        vA.getTombolSimpan().setEnabled(false);
        vA.getTombolUbah().setEnabled(true);
        vA.getTombolHapus().setEnabled(true);
        vA.getTombolBatal().setEnabled(true);
    }
    
    public void deleteData(){
        mA = new modelAnggota();
        mA.setNoAnggotaModel(vA.getNoAnggotaView().getText());
        mA.deleteDataAnggota();
        bersihkan();
        kontrolButton();
    }
    
    public void simpanData(){
        mA = new modelAnggota();
        mA.setNoAnggotaModel(vA.getNoAnggotaView().getText());
        mA.setNamaModel(vA.getNamaView().getText());
        mA.setKelasModel(vA.getKelasView().getText());
        mA.setTtlModel(vA.getTtlView().getText());
        mA.setAlamatModel(vA.getAlamatView().getText());
        
        mA.simpanDataAnggota();
    }
    
    public void updateData(){
        mA = new modelAnggota();
        mA.setNoAnggotaModel(vA.getNoAnggotaView().getText());
        mA.setNamaModel(vA.getNamaView().getText());
        mA.setKelasModel(vA.getKelasView().getText());
        mA.setTtlModel(vA.getTtlView().getText());
        mA.setAlamatModel(vA.getAlamatView().getText());
        
        mA.updateDataAnggota();
    }
    
}
