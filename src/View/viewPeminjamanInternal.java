/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.controllerPeminjaman;
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
public class viewPeminjamanInternal extends javax.swing.JInternalFrame {
    private controllerPeminjaman cP;
    /**
     * Creates new form viewInternalPeminjaman
     */
    private DefaultTableModel model;
    private String sql = "";
    public viewPeminjamanInternal() {
        initComponents();
        
        
        cP = new controllerPeminjaman(this);
        model = new DefaultTableModel();
        tabelPeminjaman.setModel(model);
        model.addColumn("ID PINJAM");
        model.addColumn("NO ANGGOTA");
        model.addColumn("ID BUKU");
        model.addColumn("TGL");
        model.addColumn("DURASI");
        model.addColumn("NAMA");
        
        tampilDataPinjam();
        cP.kontrolButton();
        
    }

    public JTextField getDurasiPinjamView() {
        return durasiPinjamView;
    }

    public JTextField getIdBukuView() {
        return idBukuView;
    }

    public JTextField getIdPinjamView() {
        return idPinjamView;
    }

    public JTextField getNoAnggotaView() {
        return noAnggotaView;
    }

    public JTextField getTglPinjamView() {
        return tglPinjamView;
    }

    public JButton getTombolBatal() {
        return tombolBatal;
    }

    public JButton getTombolHapus() {
        return tombolHapus;
    }

    public JTextField getCariNama() {
        return cariNama;
    }

    public JTextField getNamaAnggotaView() {
        return namaAnggotaView;
    }

    public JButton getTombolSimpan() {
        return tombolSimpan;
    }

    public JButton getTombolUbah() {
        return tombolUbah;
    }
    
    private void tampilDataPinjam(){
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String sql = "Select anggota.noAnggota, anggota.nama, buku.idBuku, peminjaman.idPinjam, "
                + "peminjaman.tglPinjam, peminjaman.durasiPinjam FROM anggota, buku, peminjaman "
                + "WHERE anggota.noAnggota = peminjaman.noAnggota AND "
                + "buku.idBuku = peminjaman.idBuku";
        
        try{
            Statement stat = (Statement) koneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery (sql);
            
            while(res.next()){
                Object[] hasil;
                hasil = new Object[6];
                hasil[0] = res.getString("idPinjam");
                hasil[1] = res.getString("noAnggota");
                hasil[2] = res.getString("idBuku");
                hasil[3] = res.getString("tglPinjam");
                hasil[4] = res.getString("durasiPinjam");
                hasil[5] = res.getString("nama");
                
                model.addRow(hasil);                
            }
        } catch (SQLException ex){
            Logger.getLogger(viewAnggotaInternal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ambilDataTabel(){
            
            int index = tabelPeminjaman.getSelectedRow();
            
            String idp = String.valueOf(tabelPeminjaman.getValueAt(index, 0));
            String noa = String.valueOf(tabelPeminjaman.getValueAt(index, 1));
            String idb = String.valueOf(tabelPeminjaman.getValueAt(index, 2));
            String tgl = String.valueOf(tabelPeminjaman.getValueAt(index, 3));
            String drs = String.valueOf(tabelPeminjaman.getValueAt(index, 4));
            String nama = String.valueOf(tabelPeminjaman.getValueAt(index, 5));
            
            idPinjamView.setText(idp);
            noAnggotaView.setText(noa);
            idBukuView.setText(idb);
            tglPinjamView.setText(tgl);
            durasiPinjamView.setText(drs);
            namaAnggotaView.setText(nama);
            
            cP.kontrolButtonDua();
        }
    
    private void tampilCariDataPinjam(String data){
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        if (data.equals("")){
            sql = "Select anggota.noAnggota, anggota.nama, buku.idBuku, peminjaman.idPinjam, "
                + "peminjaman.tglPinjam, peminjaman.durasiPinjam FROM anggota, buku, peminjaman "
                + "WHERE anggota.noAnggota = peminjaman.noAnggota AND "
                + "buku.idBuku = peminjaman.idBuku";
        }else sql = "Select anggota.noAnggota, anggota.nama, buku.idBuku, peminjaman.idPinjam, "
                + "peminjaman.tglPinjam, peminjaman.durasiPinjam FROM anggota, buku, peminjaman "
                + "WHERE anggota.noAnggota = peminjaman.noAnggota AND "
                + "buku.idBuku = peminjaman.idBuku AND "
                + "anggota.nama LIKE '"+data+"%'";
        
        try{
            Statement stat = (Statement)koneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
            Object[] hasil;
            hasil = new Object[6];
            hasil[0] = res.getString("idPinjam");
            hasil[1] = res.getString("noAnggota");
            hasil[2] = res.getString("idBuku");
            hasil[3] = res.getString("tglPinjam");
            hasil[4] = res.getString("durasiPinjam");
            hasil[5] = res.getString("nama");
            
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        idPinjamView = new javax.swing.JTextField();
        noAnggotaView = new javax.swing.JTextField();
        idBukuView = new javax.swing.JTextField();
        tglPinjamView = new javax.swing.JTextField();
        durasiPinjamView = new javax.swing.JTextField();
        tombolBatal = new javax.swing.JButton();
        tombolSimpan = new javax.swing.JButton();
        tombolUbah = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPeminjaman = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        namaAnggotaView = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cariNama = new javax.swing.JTextField();

        setClosable(true);

        jLabel1.setText("ID Pinjam");

        jLabel2.setText("No Anggota");

        jLabel3.setText("ID Buku");

        jLabel4.setText("Tanggal Pinjam");

        jLabel5.setText("Durasi Pinjam");

        idPinjamView.setEditable(false);

        tombolBatal.setText("Batal");
        tombolBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolBatalActionPerformed(evt);
            }
        });

        tombolSimpan.setText("Simpan");
        tombolSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSimpanActionPerformed(evt);
            }
        });

        tombolUbah.setText("Ubah");
        tombolUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolUbahActionPerformed(evt);
            }
        });

        tombolHapus.setText("Hapus");
        tombolHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel6.setText("Pilihan Operasi");

        tabelPeminjaman.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPeminjamanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelPeminjaman);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Input Data Peminjaman");

        jLabel8.setText("Nama Anggota");

        jLabel9.setText("Cari Nama");

        cariNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariNamaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(noAnggotaView)
                            .addComponent(idBukuView)
                            .addComponent(tglPinjamView)
                            .addComponent(durasiPinjamView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idPinjamView, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(namaAnggotaView, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(cariNama))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tombolUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tombolSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tombolBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tombolHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(61, 61, 61))))
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idPinjamView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(namaAnggotaView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(noAnggotaView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(idBukuView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tglPinjamView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(durasiPinjamView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tombolSimpan)
                            .addComponent(tombolUbah)
                            .addComponent(tombolBatal)
                            .addComponent(tombolHapus))))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombolUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahActionPerformed
        // TODO add your handling code here:
        cP.updateData();
        tampilDataPinjam();
        cP.bersihkan();
    }//GEN-LAST:event_tombolUbahActionPerformed

    private void tombolBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolBatalActionPerformed
        // TODO add your handling code here:
        cP.kontrolButton();
        cP.bersihkan();
    }//GEN-LAST:event_tombolBatalActionPerformed

    private void tombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanActionPerformed
        // TODO add your handling code here:
        cP.simpan();
        tampilDataPinjam();
        cP.bersihkan();
    }//GEN-LAST:event_tombolSimpanActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        // TODO add your handling code here:
        cP.deleteData();
        tampilDataPinjam();
    }//GEN-LAST:event_tombolHapusActionPerformed

    private void tabelPeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPeminjamanMouseClicked
        // TODO add your handling code here:
        ambilDataTabel();
    }//GEN-LAST:event_tabelPeminjamanMouseClicked

    private void cariNamaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariNamaKeyPressed
        // TODO add your handling code here:
        tampilCariDataPinjam(cariNama.getText());
    }//GEN-LAST:event_cariNamaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cariNama;
    private javax.swing.JTextField durasiPinjamView;
    private javax.swing.JTextField idBukuView;
    private javax.swing.JTextField idPinjamView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namaAnggotaView;
    private javax.swing.JTextField noAnggotaView;
    private javax.swing.JTable tabelPeminjaman;
    private javax.swing.JTextField tglPinjamView;
    private javax.swing.JButton tombolBatal;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolSimpan;
    private javax.swing.JButton tombolUbah;
    // End of variables declaration//GEN-END:variables
}
