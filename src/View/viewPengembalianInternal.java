/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.controllerPengembalian;
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
public class viewPengembalianInternal extends javax.swing.JInternalFrame {
private controllerPengembalian cPE;
    /**
     * Creates new form viewInternalPengembalian
     */
    private DefaultTableModel model;
    private String sql = "";
    public viewPengembalianInternal() {
        initComponents();
        
        cPE = new controllerPengembalian(this);
        model = new DefaultTableModel();
        tabelPengembalian.setModel(model);
        model.addColumn("ID KEMBALI");
        model.addColumn("ID PINJAM");
        model.addColumn("NO ANGGOTA");
        model.addColumn("ID BUKU");
        model.addColumn("STATUS BUKU");
        model.addColumn("TGL");
        model.addColumn("DENDA");
        model.addColumn("NAMA");
        
        tampilDataPengembalian();
        cPE.kontrolButton();
        
    }

    public JTextField getDendaView() {
        return dendaView;
    }

    public void setDendaView(JTextField dendaView) {
        this.dendaView = dendaView;
    }

    public JTextField getIdBukuView() {
        return idBukuView;
    }

    public JTextField getIdPengembalianView() {
        return idPengembalianView;
    }

    public JTextField getIdPinjamView() {
        return idPinjamView;
    }

    public JTextField getNoAnggotaView() {
        return noAnggotaView;
    }

    public JTextField getStatusBukuView() {
        return statusBukuView;
    }

    public JTextField getTglPengembalianView() {
        return tglPengembalianView;
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

    public JTextField getTelatView() {
        return telatView;
    }

    public JButton getTombolHitung() {
        return tombolHitung;
    }
    
    private void tampilDataPengembalian(){
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String sql = "SELECT anggota.noAnggota, anggota.nama, buku.idBuku, peminjaman.idPinjam, pengembalian.idPengembalian, "
                + "pengembalian.statusBuku, pengembalian.tglPengembalian, pengembalian.denda "
                + "FROM anggota, buku, peminjaman, pengembalian "
                + "WHERE anggota.noAnggota = pengembalian.noAnggota AND "
                + "buku.idBuku = pengembalian.idBuku AND "
                + "peminjaman.idPinjam = pengembalian.idPinjam";
        
        try{
            Statement stat = (Statement) koneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery (sql);
            
            while(res.next()){
                Object[] hasil;
                hasil = new Object[8];
                hasil[0] = res.getString("idPengembalian");
                hasil[1] = res.getString("idPinjam");
                hasil[2] = res.getString("noAnggota");
                hasil[3] = res.getString("idBuku");
                hasil[4] = res.getString("statusBuku");
                hasil[5] = res.getString("tglPengembalian");
                hasil[6] = res.getString("denda");
                hasil[7] = res.getString("nama");
                
                
                model.addRow(hasil);                
            }
        } catch (SQLException ex){
            Logger.getLogger(viewAnggotaInternal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ambilDataTabel(){
            
            int index = tabelPengembalian.getSelectedRow();
            
            String idpe = String.valueOf(tabelPengembalian.getValueAt(index, 0));
            String idp = String.valueOf(tabelPengembalian.getValueAt(index, 1));
            String noa = String.valueOf(tabelPengembalian.getValueAt(index, 2));
            String idb = String.valueOf(tabelPengembalian.getValueAt(index, 3));
            String sta = String.valueOf(tabelPengembalian.getValueAt(index, 4));
            String tgl = String.valueOf(tabelPengembalian.getValueAt(index, 5));
            String den = String.valueOf(tabelPengembalian.getValueAt(index, 6));
            String nama = String.valueOf(tabelPengembalian.getValueAt(index, 7));

            
            idPengembalianView.setText(idpe);
            idPinjamView.setText(idp);
            noAnggotaView.setText(noa);
            idBukuView.setText(idb);
            statusBukuView.setText(sta);
            tglPengembalianView.setText(tgl);
            dendaView.setText(den);
            cariNamaView.setText(nama);
           
            cPE.kontrolButtonDua();
        }
        
        private void tampilCariDataPengembalian(String data){
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        if (data.equals("")){
            sql = "SELECT anggota.noAnggota, buku.idBuku, peminjaman.idPinjam, pengembalian.idPengembalian, "
                + "pengembalian.statusBuku, pengembalian.tglPengembalian, pengembalian.denda "
                + "FROM anggota, buku, peminjaman, pengembalian "
                + "WHERE anggota.noAnggota = pengembalian.noAnggota AND "
                + "buku.idBuku = pengembalian.idBuku AND "
                + "peminjaman.idPinjam = pengembalian.idPinjam";
        }else sql = "SELECT anggota.noAnggota, anggota.nama, buku.idBuku, peminjaman.idPinjam, pengembalian.idPengembalian, "
                + "pengembalian.statusBuku, pengembalian.tglPengembalian, pengembalian.denda "
                + "FROM anggota, buku, peminjaman, pengembalian "
                + "WHERE anggota.noAnggota = pengembalian.noAnggota AND "
                + "buku.idBuku = pengembalian.idBuku AND "
                + "peminjaman.idPinjam = pengembalian.idPinjam AND "
                + "anggota.nama LIKE '"+data+"%'";
        
        try{
            Statement stat = (Statement)koneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
            Object[] hasil;
            hasil = new Object[8];
            hasil[0] = res.getString("idPengembalian");
            hasil[1] = res.getString("idPinjam");
            hasil[2] = res.getString("noAnggota");
            hasil[3] = res.getString("idBuku");
            hasil[4] = res.getString("statusBuku");
            hasil[5] = res.getString("tglPengembalian");
            hasil[6] = res.getString("denda");
            hasil[7] = res.getString("nama");
            
            model.addRow(hasil);
            }
        }
        catch (SQLException ex){
                Logger.getLogger(viewPeminjamanInternal.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPengembalian = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        tombolHitung = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idPengembalianView = new javax.swing.JTextField();
        idPinjamView = new javax.swing.JTextField();
        noAnggotaView = new javax.swing.JTextField();
        idBukuView = new javax.swing.JTextField();
        tglPengembalianView = new javax.swing.JTextField();
        dendaView = new javax.swing.JTextField();
        statusBukuView = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        telatView = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        tombolUbah = new javax.swing.JButton();
        tombolBatal = new javax.swing.JButton();
        tombolSimpan = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cariNamaView = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Menu Pengembalian");

        jPanel1.setBackground(java.awt.Color.pink);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tabel Pengembalian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 1, 14))); // NOI18N

        tabelPengembalian.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelPengembalian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPengembalianMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelPengembalian);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hitung Denda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 1, 14))); // NOI18N

        tombolHitung.setText("Hitung");
        tombolHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHitungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tombolHitung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tombolHitung, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Data Pengembalian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 1, 14))); // NOI18N

        jLabel1.setText("ID Pengembalian");

        jLabel2.setText("ID Pinjam");

        jLabel3.setText("No Anggota");

        jLabel4.setText("ID Buku");

        idPengembalianView.setEditable(false);

        dendaView.setEditable(false);

        jLabel5.setText("Status Buku");

        jLabel6.setText("Tanggal Pengembalian");

        jLabel7.setText("Denda");

        jLabel10.setText("Telat (Hari)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noAnggotaView, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idPinjamView, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idBukuView, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(idPengembalianView, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(statusBukuView, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tglPengembalianView, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dendaView, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(telatView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(statusBukuView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tglPengembalianView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dendaView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(telatView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(idPengembalianView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(idPinjamView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(noAnggotaView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idBukuView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proses", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 1, 14))); // NOI18N

        tombolUbah.setText("Ubah");
        tombolUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolUbahActionPerformed(evt);
            }
        });

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

        tombolHapus.setText("Hapus");
        tombolHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tombolHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tombolSimpan))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tombolBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolSimpan)
                    .addComponent(tombolUbah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolHapus)
                    .addComponent(tombolBatal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cari Nama Anggota", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 1, 14))); // NOI18N

        jLabel8.setText("Cari Nama");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(cariNamaView, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cariNamaView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanActionPerformed
        // TODO add your handling code here:
        cPE.simpan();
        tampilDataPengembalian();
        cPE.bersihkan();
    }//GEN-LAST:event_tombolSimpanActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        // TODO add your handling code here:
        cPE.deleteData();
        tampilDataPengembalian();
    }//GEN-LAST:event_tombolHapusActionPerformed

    private void tombolUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahActionPerformed
        // TODO add your handling code here:
        cPE.updateData();
        tampilDataPengembalian();
        cPE.bersihkan();
    }//GEN-LAST:event_tombolUbahActionPerformed

    private void tombolBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolBatalActionPerformed
        // TODO add your handling code here:
        cPE.kontrolButton();
        cPE.bersihkan();
    }//GEN-LAST:event_tombolBatalActionPerformed

    private void tombolHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHitungActionPerformed
        // TODO add your handling code here:
        int denda;
        int a = 1000;
        int b = (Integer.parseInt(getTelatView().getText()));
        denda = a*b;
        dendaView.setText(String.valueOf(denda));
    }//GEN-LAST:event_tombolHitungActionPerformed

    private void tabelPengembalianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPengembalianMouseClicked
        // TODO add your handling code here:
        ambilDataTabel();
    }//GEN-LAST:event_tabelPengembalianMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cariNamaView;
    private javax.swing.JTextField dendaView;
    private javax.swing.JTextField idBukuView;
    private javax.swing.JTextField idPengembalianView;
    private javax.swing.JTextField idPinjamView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField noAnggotaView;
    private javax.swing.JTextField statusBukuView;
    private javax.swing.JTable tabelPengembalian;
    private javax.swing.JTextField telatView;
    private javax.swing.JTextField tglPengembalianView;
    private javax.swing.JButton tombolBatal;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolHitung;
    private javax.swing.JButton tombolSimpan;
    private javax.swing.JButton tombolUbah;
    // End of variables declaration//GEN-END:variables
}
