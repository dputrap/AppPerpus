/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.controllerKunjungan;
import Database.koneksiDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danu Putra
 */
public class viewKunjunganInternal extends javax.swing.JInternalFrame {
    private controllerKunjungan cK;
    private String sql = "";
    /**
     * Creates new form viewKunjunganInternal
     */
    private DefaultTableModel model;
    public viewKunjunganInternal() {
        initComponents();
        
        cK = new controllerKunjungan(this);
        model = new DefaultTableModel();
        tabelKunjungan.setModel(model);
        model.addColumn("NO");
        model.addColumn("TGL");
        model.addColumn("TUJUAN");
        model.addColumn("NOANGGOTA");
        model.addColumn("NAMA");

        tampilDataKunjungan();
        cK.kontrolButton();
        
    }

    public JTextField getNamaAnggota() {
        return namaAnggota;
    }

    public JTextField getNamaView() {
        return noAnggotaView;
    }

    public JTextField getNoAnggotaView() {
        return noAnggotaView;
    }

    public JTextField getNoKunjunganView() {
        return noKunjunganView;
    }

    public JTextField getTglKunjunganView() {
        return tglKunjunganView;
    }

    public JButton getTombolBatal() {
        return tombolBatal;
    }

    public JButton getTombolHapus() {
        return tombolHapus;
    }

    public JButton getTombolSimpan() {
        return tombolSimpan;
    }

    public JButton getTombolUbah() {
        return tombolUbah;
    }

    public JTextField getTujuanKunjunganView() {
        return tujuanKunjunganView;
    }
    
     private void tampilDataKunjungan(){
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String sql = "SELECT anggota.noAnggota, anggota.nama, datakunjungan.noKunjung, "
                + "datakunjungan.tglKunjung, datakunjungan.tujuanKunjung FROM anggota, datakunjungan "
                + "WHERE anggota.noAnggota = datakunjungan.noAnggota";
        
        try{
            Statement stat = (Statement) koneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery (sql);
            
            while(res.next()){
                Object[] hasil;
                hasil = new Object[5];
                hasil[0] = res.getString("noKunjung");
                hasil[1] = res.getString("tglKunjung");
                hasil[2] = res.getString("tujuanKunjung");
                hasil[3] = res.getString("noAnggota");
                hasil[4] = res.getString("nama");

                model.addRow(hasil);                
            }
        } catch (SQLException ex){
            Logger.getLogger(viewKunjunganInternal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        private void ambilDataTabel(){
            
            int index = tabelKunjungan.getSelectedRow();
            
            String no = String.valueOf(tabelKunjungan.getValueAt(index, 0));
            String tgl = String.valueOf(tabelKunjungan.getValueAt(index, 1));
            String tjn = String.valueOf(tabelKunjungan.getValueAt(index, 2));
            String noa = String.valueOf(tabelKunjungan.getValueAt(index, 3));
            String nama = String.valueOf(tabelKunjungan.getValueAt(index, 4));

            noKunjunganView.setText(no);
            tglKunjunganView.setText(tgl);
            tujuanKunjunganView.setText(tjn);
            noAnggotaView.setText(noa);
            namaView.setText(nama);
            
            cK.kontrolButtonDua();
        }
        
        private void tampilCariDataKunjungan(String data){
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        if (data.equals("")){
            sql = "SELECT anggota.noAnggota, anggota.nama, datakunjungan.noKunjung, "
                + "datakunjungan.tglKunjung, datakunjungan.tujuanKunjung FROM anggota, datakunjungan "
                + "WHERE anggota.noAnggota = datakunjungan.noAnggota";
            
        }else sql = "SELECT anggota.noAnggota, anggota.nama, datakunjungan.noKunjung, "
                + "datakunjungan.tglKunjung, datakunjungan.tujuanKunjung FROM anggota, datakunjungan "
                + "WHERE anggota.noAnggota = datakunjungan.noAnggota AND "
                + "anggota.nama LIKE '"+data+"%'";
        
        try{
            Statement stat = (Statement)koneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
            Object[] hasil;
            hasil = new Object[5];
            hasil[0] = res.getString("noKunjung");
            hasil[1] = res.getString("tglKunjung");
            hasil[2] = res.getString("tujuanKunjung");
            hasil[3] = res.getString("noAnggota");
            hasil[4] = res.getString("nama");
            
            model.addRow(hasil);
            }
        }
        catch (SQLException ex){
                Logger.getLogger(viewListKunjungan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        noKunjunganView = new javax.swing.JTextField();
        tglKunjunganView = new javax.swing.JTextField();
        tujuanKunjunganView = new javax.swing.JTextField();
        noAnggotaView = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKunjungan = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        namaAnggota = new javax.swing.JTextField();
        tombolUbah = new javax.swing.JButton();
        tombolSimpan = new javax.swing.JButton();
        tombolBatal = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        namaView = new javax.swing.JTextField();

        setClosable(true);

        jLabel1.setText("No Kunjungan");

        jLabel2.setText("Tanggal Kunjungan");

        jLabel3.setText("Tujuan Kunjungan");

        noKunjunganView.setEditable(false);

        jLabel4.setText("No Anggota");

        tabelKunjungan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelKunjungan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKunjunganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelKunjungan);

        jLabel5.setText("Cari Nama Anggota");

        namaAnggota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                namaAnggotaKeyPressed(evt);
            }
        });

        tombolUbah.setText("Ubah");
        tombolUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolUbahActionPerformed(evt);
            }
        });

        tombolSimpan.setText("Simpan");
        tombolSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSimpanActionPerformed(evt);
            }
        });

        tombolBatal.setText("Batal");
        tombolBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolBatalActionPerformed(evt);
            }
        });

        tombolHapus.setText("Hapus");
        tombolHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusActionPerformed(evt);
            }
        });

        jLabel6.setText("Nama Anggota");

        namaView.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tombolBatal)
                            .addComponent(tombolUbah))
                        .addGap(21, 21, 21)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tombolSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tombolHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tujuanKunjunganView, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(noKunjunganView, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tglKunjunganView, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noAnggotaView)
                            .addComponent(namaView))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(namaAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 289, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(noKunjunganView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(namaAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tglKunjunganView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tujuanKunjunganView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(noAnggotaView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namaView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tombolUbah)
                            .addComponent(tombolSimpan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tombolBatal)
                            .addComponent(tombolHapus)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombolUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahActionPerformed
        // TODO add your handling code here:
        cK.updateData();
        tampilDataKunjungan();
        cK.bersihkan();
    }//GEN-LAST:event_tombolUbahActionPerformed

    private void tombolBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolBatalActionPerformed
        // TODO add your handling code here:
        cK.kontrolButton();
        cK.bersihkan();
    }//GEN-LAST:event_tombolBatalActionPerformed

    private void tombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanActionPerformed
        // TODO add your handling code here:
        cK.simpan();
        tampilDataKunjungan();
        cK.bersihkan();
    }//GEN-LAST:event_tombolSimpanActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        // TODO add your handling code here:
        cK.deleteData();
        tampilDataKunjungan();
    }//GEN-LAST:event_tombolHapusActionPerformed

    private void tabelKunjunganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKunjunganMouseClicked
        // TODO add your handling code here:
        ambilDataTabel();
    }//GEN-LAST:event_tabelKunjunganMouseClicked

    private void namaAnggotaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaAnggotaKeyPressed
        // TODO add your handling code here:
        tampilCariDataKunjungan(namaAnggota.getText());
    }//GEN-LAST:event_namaAnggotaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namaAnggota;
    private javax.swing.JTextField namaView;
    private javax.swing.JTextField noAnggotaView;
    private javax.swing.JTextField noKunjunganView;
    private javax.swing.JTable tabelKunjungan;
    private javax.swing.JTextField tglKunjunganView;
    private javax.swing.JButton tombolBatal;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolSimpan;
    private javax.swing.JButton tombolUbah;
    private javax.swing.JTextField tujuanKunjunganView;
    // End of variables declaration//GEN-END:variables
}
