/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.modelBuku;
import View.viewBukuInternal;

/**
 *
 * @author Danu Putra
 */
public class controllerBuku {
   
    private modelBuku mB;
    private viewBukuInternal vB;
    
    public controllerBuku(viewBukuInternal vB){
        this.vB = vB;
    }
    
    public void bersihkan(){
        //memanggil variable swing di view
        vB.getIdBukuView().setText("");
        vB.getNamaBukuView().setText("");
        vB.getStokView().setText("");

    }
    
    //fungsi kontrol button disable not clickable
    public void kontrolButton(){
        vB.getTombolSimpan().setEnabled(true);
        vB.getTombolUbah().setEnabled(false);
        vB.getTombolHapus().setEnabled(false);
        vB.getTombolBatal().setEnabled(false);
    }
    
    public void kontrolButtonDua(){
        vB.getTombolSimpan().setEnabled(false);
        vB.getTombolUbah().setEnabled(true);
        vB.getTombolHapus().setEnabled(true);
        vB.getTombolBatal().setEnabled(true);
    }
    
    public void deleteData(){
        mB = new modelBuku();
        mB.setIdBukuModel(vB.getIdBukuView().getText());
        mB.deleteDataBuku();
        bersihkan();
        kontrolButton();
    }
    
    public void simpanData(){
        mB = new modelBuku();
        mB.setIdBukuModel(vB.getIdBukuView().getText());
        mB.setNamaBukuModel(vB.getNamaBukuView().getText());
        mB.setStok(vB.getStokView().getText());

        mB.simpanDataBuku();
    }
    
    public void updateData(){
        mB = new modelBuku();
        mB.setIdBukuModel(vB.getIdBukuView().getText());
        mB.setNamaBukuModel(vB.getNamaBukuView().getText());
        mB.setStok(vB.getStokView().getText());
        
        mB.updateDataBuku();
    }
}
