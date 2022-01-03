/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import Controller.controllerBuku;
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
public class viewBukuInternal extends javax.swing.JInternalFrame {
    private controllerBuku cB;
    /**
     * Creates new form viewBukuInternal
     */
    private DefaultTableModel model;
    private String sql = "";
    public viewBukuInternal() {
        initComponents();
        
        cB = new controllerBuku(this);
        model = new DefaultTableModel();
        tabelBuku.setModel(model);
        model.addColumn("ID");
        model.addColumn("NAMA");
        model.addColumn("STOK");
        
        tampilDataBuku();
        cB.kontrolButton();
    }

    public JTextField getIdBukuView() {
        return idBukuView;
    }

    public JTextField getNamaBukuView() {
        return namaBukuView;
    }

    public JTextField getStokView() {
        return stokView;
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
    
    private void tampilDataBuku(){
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String sql = "Select * FROM buku";
        
        try{
            Statement stat = (Statement) koneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery (sql);
            
            while(res.next()){
                Object[] hasil;
                hasil = new Object[3];
                hasil[0] = res.getString("idBuku");
                hasil[1] = res.getString("namaBuku");
                hasil[2] = res.getString("stok");

                
                model.addRow(hasil);                
            }
        } catch (SQLException ex){
            Logger.getLogger(viewAnggotaInternal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ambilDataTabel(){
            
            int index = tabelBuku.getSelectedRow();
            
            String id = String.valueOf(tabelBuku.getValueAt(index, 0));
            String nama = String.valueOf(tabelBuku.getValueAt(index, 1));
            String stk = String.valueOf(tabelBuku.getValueAt(index, 2));
            
            idBukuView.setText(id);
            namaBukuView.setText(nama);
            stokView.setText(stk);
            
            cB.kontrolButtonDua();
        }
    
    private void tampilCariDataBuku(String data){
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        if (data.equals("")){
            sql = "SELECT * FROM buku";
        }else sql = "SELECT * FROM buku WHERE namaBuku LIKE '"+data+"%'";
        
        try{
            Statement stat = (Statement)koneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
            Object[] hasil;
            hasil = new Object[3];
            hasil[0] = res.getString("idBuku");
            hasil[1] = res.getString("namaBuku");
            hasil[2] = res.getString("stok");
            
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
        idBukuView = new javax.swing.JTextField();
        namaBukuView = new javax.swing.JTextField();
        stokView = new javax.swing.JTextField();
        tombolSimpan = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        tombolBatal = new javax.swing.JButton();
        tombolUbah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBuku = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cariBuku = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);

        jLabel1.setText("Id Buku");

        jLabel2.setText("Nama Buku");

        jLabel3.setText("Stok");

        tombolSimpan.setText("Simpan");
        tombolSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSimpanActionPerformed(evt);
            }
        });

        tombolHapus.setText("Hapus");
        tombolHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusActionPerformed(evt);
            }
        });

        tombolBatal.setText("Batal");
        tombolBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolBatalActionPerformed(evt);
            }
        });

        tombolUbah.setText("Ubah");
        tombolUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolUbahActionPerformed(evt);
            }
        });

        tabelBuku.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelBuku);

        jLabel4.setText("Cari Nama Buku");

        cariBuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariBukuKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idBukuView, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(namaBukuView, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(stokView)
                            .addComponent(cariBuku))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tombolSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tombolHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tombolUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tombolBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(30, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idBukuView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(namaBukuView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(stokView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tombolSimpan)
                            .addComponent(tombolBatal))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tombolHapus)
                            .addComponent(tombolUbah))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cariBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBukuMouseClicked
        // TODO add your handling code here:
        ambilDataTabel();
    }//GEN-LAST:event_tabelBukuMouseClicked

    private void tombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanActionPerformed
        // TODO add your handling code here:
        cB.simpanData();
        tampilDataBuku();
        cB.bersihkan();
    }//GEN-LAST:event_tombolSimpanActionPerformed

    private void tombolBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolBatalActionPerformed
        // TODO add your handling code here:
        cB.kontrolButton();
        cB.bersihkan();
    }//GEN-LAST:event_tombolBatalActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        // TODO add your handling code here:
        cB.deleteData();
        tampilDataBuku();
    }//GEN-LAST:event_tombolHapusActionPerformed

    private void tombolUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahActionPerformed
        // TODO add your handling code here:
        cB.updateData();
        tampilDataBuku();
        cB.bersihkan();
    }//GEN-LAST:event_tombolUbahActionPerformed

    private void cariBukuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariBukuKeyPressed
        // TODO add your handling code here:
        tampilCariDataBuku(cariBuku.getText());
    }//GEN-LAST:event_cariBukuKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cariBuku;
    private javax.swing.JTextField idBukuView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namaBukuView;
    private javax.swing.JTextField stokView;
    private javax.swing.JTable tabelBuku;
    private javax.swing.JButton tombolBatal;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolSimpan;
    private javax.swing.JButton tombolUbah;
    // End of variables declaration//GEN-END:variables
}