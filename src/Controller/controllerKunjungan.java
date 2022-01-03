/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.modelKunjungan;
import View.viewKunjunganInternal;

/**
 *
 * @author Danu Putra
 */
public class controllerKunjungan {
    
    private modelKunjungan mK;
    private viewKunjunganInternal vK;
    
    public controllerKunjungan(viewKunjunganInternal vK){
        this.vK = vK;
    }
    
    public void bersihkan(){
        //memanggil variable swing di view
        vK.getNoKunjunganView().setText("");
        vK.getTglKunjunganView().setText("");
        vK.getTujuanKunjunganView().setText("");
        vK.getNamaView().setText("");
    }
    
    //fungsi kontrol button disable not clickable
    public void kontrolButton(){
        vK.getTombolSimpan().setEnabled(true);
        vK.getTombolUbah().setEnabled(false);
        vK.getTombolHapus().setEnabled(false);
        vK.getTombolBatal().setEnabled(false);
    }
    
    public void kontrolButtonDua(){
        vK.getTombolSimpan().setEnabled(false);
        vK.getTombolUbah().setEnabled(true);
        vK.getTombolHapus().setEnabled(true);
        vK.getTombolBatal().setEnabled(true);
    }
    
    public void deleteData(){
        mK = new modelKunjungan();
        mK.setNoKunjungModel(vK.getNoKunjunganView().getText());
        mK.deleteDataKunjung();
        bersihkan();
        kontrolButton();
    }
    
    public void updateData(){
        mK = new modelKunjungan();
        mK.setNoKunjungModel(vK.getNoKunjunganView().getText());
        mK.setTglKunjungModel(vK.getTglKunjunganView().getText());
        mK.setTujuanKunjung(vK.getTujuanKunjunganView().getText());
        mK.setNamaModel(vK.getNamaView().getText());

        mK.updateDataKunjung();
        bersihkan();
        kontrolButton();
    }
    
    public void simpan(){
        mK = new modelKunjungan();
        mK.setTglKunjungModel(vK.getTglKunjunganView().getText());
        mK.setTujuanKunjung(vK.getTujuanKunjunganView().getText());
        mK.setNamaModel(vK.getNamaView().getText());
        
        mK.simpanDataKunjung();
        bersihkan();
    }
    
}
