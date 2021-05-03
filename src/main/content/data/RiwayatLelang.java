/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.content.data;

import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import lib.DBHelper;

/**
 *
 * @author fahmi
 */
public class RiwayatLelang extends javax.swing.JInternalFrame {
    Connection connection =  new DBHelper().init();
    CardLayout cardLayout;
    private String id,id_lelang,id_barang,id_user,harga,rstatus;
    /**
     * Creates new form Masyarakat
     */
    public RiwayatLelang() {
        initComponents();
        BasicInternalFrameUI ui = (BasicInternalFrameUI)getUI();
        ui.setNorthPane(null); 
        tabelmodel();
        tabel.setModel(defaultmodel);
        initidbarang();
        initiduser();
        initidlelang();
        cardLayout = (CardLayout)cards.getLayout();
    }
    int row=0;
    
    private void tabelmodel(){
        String sql = "select riwayat_lelang.id_riwayat, riwayat_lelang.id_lelang,barang.nama_barang, masyarakat.nama_lengkap, riwayat_lelang.penawaran_harga from riwayat_lelang inner join barang on riwayat_lelang.id_barang= barang.id_barang inner join masyarakat on riwayat_lelang.id_user= masyarakat.id_user;";
    try {
        ResultSet modeltabel =connection.createStatement().executeQuery(sql);
        while (modeltabel.next()) {            
            String[] modeldata={modeltabel.getString(1),modeltabel.getString(2),modeltabel.getString(3),modeltabel.getString(4),modeltabel.getString(5)};
            defaultmodel.addRow(modeldata);
        }
        modeltabel.close();
    } catch (SQLException e) {
        System.out.println(e);
    }
        
    }
    public javax.swing.table.DefaultTableModel defaultmodel = defaulttable();
        private javax.swing.table.DefaultTableModel defaulttable(){
            return new javax.swing.table.DefaultTableModel(
                    new  Object[][]{},
                    new String[]{"id_riwayat","id_lelang","nama_barang","nama_lengkap","penawaran_harga"}
            ){
            boolean[] canEdit = new boolean[]{false,false,false,false,false};
            public boolean isCellEditable(int rowIndex,int columnIndex){
            return canEdit[columnIndex];
                }};
        }
    private void initidbarang(){
        try {
            String sql = "select id_barang,nama_barang from barang";
            ResultSet rsb= connection.createStatement().executeQuery(sql);
            while(rsb.next()){
                String result =rsb.getString(1)+" | "+rsb.getString(2);
                eidbarang.addItem(result);
            }
            rsb.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private void initiduser(){
        try {
            String sql = "select id_user, nama_lengkap from masyarakat";
            ResultSet rsu= connection.createStatement().executeQuery(sql);
            while(rsu.next()){
                String result =rsu.getString(1)+" | "+rsu.getString(2);
                eiduser.addItem(result);
            }
            rsu.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private void initidlelang(){
        try {
            String sql = "select id_lelang from lelang";
            ResultSet rsp= connection.createStatement().executeQuery(sql);
            while(rsp.next()){
                eidlelang.addItem(rsp.getString(1));
            }
            rsp.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private void refreshModel(){
        defaultmodel.setRowCount(0);
        tabelmodel();
        tabel.setModel(this.defaultmodel);
    }
    private void stateTambah(){
        eid.setEnabled(true);
        eid.setText("");
        eidlelang.setSelectedIndex(0);
        eidbarang.setSelectedIndex(0);
        eiduser.setSelectedIndex(0);
        eharga.setText("");
    }
    private void stateUbah(){
        try {
            String sql = "select id_user, nama_lengkap from masyarakat where id_user ="+this.id_user;
            ResultSet rsu= connection.createStatement().executeQuery(sql);
            while(rsu.next()){
                String result =rsu.getString(1)+" | "+rsu.getString(2);
                eiduser.setSelectedItem(result);
            }
            rsu.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            String sql = "select id_barang,nama_barang from barang where id_barang ="+this.id_barang;
            ResultSet rsb= connection.createStatement().executeQuery(sql);
            while(rsb.next()){
                String result =rsb.getString(1)+" | "+rsb.getString(2);
                eidbarang.setSelectedItem(result);
            }
            rsb.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        eid.setEnabled(false);
        eid.setText(id);
        eidlelang.setSelectedItem(id_lelang);
//        eidbarang.setSelectedItem(id_barang);
//        eiduser.setSelectedItem(id_user);
        eharga.setText(harga);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cards = new javax.swing.JPanel();
        card1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        tambah = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cari = new javax.swing.JButton();
        card2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        simpan = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        eid = new javax.swing.JTextField();
        eharga = new javax.swing.JTextField();
        eidlelang = new javax.swing.JComboBox<>();
        eidbarang = new javax.swing.JComboBox<>();
        eiduser = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        cards.setLayout(new java.awt.CardLayout());

        card1.setBackground(java.awt.Color.white);
        card1.setName(""); // NOI18N

        jPanel2.setBackground(java.awt.Color.white);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_riwayat", "id_lelang", "id_barang", "id_user", "penawaran_harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel.setSelectionBackground(new java.awt.Color(21, 106, 241));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addContainerGap())
        );

        tambah.setBackground(new java.awt.Color(21, 106, 241));
        tambah.setForeground(java.awt.Color.white);
        tambah.setText("Tambah Data");
        tambah.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        tambah.setBorderPainted(false);
        tambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        jPanel3.setBackground(java.awt.Color.white);

        ubah.setBackground(new java.awt.Color(21, 106, 241));
        ubah.setForeground(java.awt.Color.white);
        ubah.setText("Ubah Data");
        ubah.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        ubah.setBorderPainted(false);
        ubah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        hapus.setBackground(new java.awt.Color(21, 106, 241));
        hapus.setForeground(java.awt.Color.white);
        hapus.setText("Hapus Data");
        hapus.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        hapus.setBorderPainted(false);
        hapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        refresh.setBackground(new java.awt.Color(21, 106, 241));
        refresh.setForeground(java.awt.Color.white);
        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icon/refresh-16.png"))); // NOI18N
        refresh.setText("Refresh");
        refresh.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        refresh.setBorderPainted(false);
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.black);
        jLabel1.setText("DATA RIWAYAT LELANG");

        jLabel2.setFont(new java.awt.Font("Open Sans", 2, 12)); // NOI18N
        jLabel2.setText("cari berdasarkan nama_user");

        cari.setBackground(new java.awt.Color(21, 106, 241));
        cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icon/search-14-24.png"))); // NOI18N
        cari.setBorderPainted(false);
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout card1Layout = new javax.swing.GroupLayout(card1);
        card1.setLayout(card1Layout);
        card1Layout.setHorizontalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(card1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(card1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cari)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(345, 345, 345))))
        );
        card1Layout.setVerticalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari)
                    .addComponent(jLabel2))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        cards.add(card1, "card1");

        card2.setBackground(java.awt.Color.white);

        jPanel1.setBackground(java.awt.Color.white);

        jLabel4.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel4.setForeground(java.awt.Color.black);
        jLabel4.setText("ID RIWAYAT");

        jLabel5.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel5.setForeground(java.awt.Color.black);
        jLabel5.setText("ID LELANG");

        jLabel6.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel6.setForeground(java.awt.Color.black);
        jLabel6.setText("ID BARANG");

        jLabel7.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel7.setForeground(java.awt.Color.black);
        jLabel7.setText("ID USER");

        jLabel8.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel8.setForeground(java.awt.Color.black);
        jLabel8.setText("PENAWARAN HARGA");

        jPanel5.setBackground(java.awt.Color.white);

        simpan.setBackground(new java.awt.Color(21, 106, 241));
        simpan.setForeground(java.awt.Color.white);
        simpan.setText("SIMPAN");
        simpan.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        simpan.setBorderPainted(false);
        simpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        batal.setBackground(new java.awt.Color(21, 106, 241));
        batal.setForeground(java.awt.Color.white);
        batal.setText("BATAL");
        batal.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        batal.setBorderPainted(false);
        batal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        keluar.setBackground(new java.awt.Color(21, 106, 241));
        keluar.setForeground(java.awt.Color.white);
        keluar.setText("KELUAR");
        keluar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        keluar.setBorderPainted(false);
        keluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(batal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        eidlelang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        eidbarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        eiduser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel9.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel9.setForeground(java.awt.Color.black);
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("FORM RIWAYAT LELANG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eharga, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(eiduser, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eidbarang, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eidlelang, javax.swing.GroupLayout.Alignment.LEADING, 0, 244, Short.MAX_VALUE)
                        .addComponent(eid, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(80, Short.MAX_VALUE))
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel9)
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(eid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(eidlelang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(eidbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(eiduser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(eharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout card2Layout = new javax.swing.GroupLayout(card2);
        card2.setLayout(card2Layout);
        card2Layout.setHorizontalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card2Layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );
        card2Layout.setVerticalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cards.add(card2, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        this.rstatus = "tambah";
        stateTambah();
        cardLayout.show(cards, "card2");
    }//GEN-LAST:event_tambahActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
        this.rstatus = "ubah";
        stateUbah();
        cardLayout.show(cards, "card2");
    }//GEN-LAST:event_ubahActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        row=tabel.getSelectedRow();
        this.id =defaultmodel.getValueAt(row,0).toString();
        String sql="select * from riwayat_lelang where id_riwayat='"+this.id+"'";
        try {
            
            ResultSet mtabel =connection.createStatement().executeQuery(sql);
            while (mtabel.next()) {
                this.id_lelang = mtabel.getString(2);
                this.id_barang = mtabel.getString(3);
                this.id_user = mtabel.getString(4);
                this.harga = mtabel.getString(5);
            }
            mtabel.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_tabelMouseClicked

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        Object[]options = {"YA","TIDAK"};
        int konfirmasi=JOptionPane.showOptionDialog(null,"Apakah Anda yakin menghapus data?","Konfirmasi",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        if(konfirmasi==JOptionPane.YES_OPTION){        
            try {
                Statement s = connection.createStatement();
                String sql = "delete from riwayat_lelang where id_riwayat='"+this.id+"'";
                s.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
                defaultmodel.removeRow(row);
                s.close();
            }catch(Exception e) {
                System.out.println(e);
            }   
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        refreshModel();
    }//GEN-LAST:event_refreshActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
        try {
            defaultmodel.setRowCount(0);
            String sql="select riwayat_lelang.id_riwayat, riwayat_lelang.id_lelang,barang.nama_barang, masyarakat.nama_lengkap, riwayat_lelang.penawaran_harga from riwayat_lelang inner join barang on riwayat_lelang.id_barang= barang.id_barang inner join masyarakat on riwayat_lelang.id_user= masyarakat.id_user where masyarakat.nama_lengkap like '%"+tcari.getText()+"%'";
            ResultSet modeltabel =connection.createStatement().executeQuery(sql);
            while (modeltabel.next()) {
                String[] modeldata={modeltabel.getString(1),modeltabel.getString(2),modeltabel.getString(3),modeltabel.getString(4),modeltabel.getString(5)};
                defaultmodel.addRow(modeldata);
            }
            modeltabel.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_cariActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        String[] hasilbarang = eidbarang.getSelectedItem().toString().split("|");
        String idbarang = hasilbarang[0];
        String[] hasiluser = eiduser.getSelectedItem().toString().split("|");
        String iduser = hasiluser[0];
        if (rstatus=="tambah"){
            Object[]options = {"YA","TIDAK"};
            int konfirmasi=JOptionPane.showOptionDialog(null,"Apakah Anda yakin menyimpan Data?","Konfirmasi",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(konfirmasi==JOptionPane.YES_OPTION){
                try {
                    String sql="insert into riwayat_lelang values('"
                    + eid.getText()+"','"
                    + eidlelang.getSelectedItem()+"','"
                    + idbarang+"','"
                    + iduser+"','"
                    + eharga.getText()+"')";
                    Statement s = connection.createStatement();
                    s.executeUpdate(sql);
                    s.close();
                    JOptionPane.showMessageDialog(rootPane, "Data berhasil disimpan!");
                    refreshModel();
                    stateTambah();
                    cardLayout.show(cards, "card1");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }else if(rstatus=="ubah"){
            Object[]options = {"YA","TIDAK"};
            int konfirmasi=JOptionPane.showOptionDialog(null,"Apakah Anda yakin mengubah Data?","Konfirmasi",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(konfirmasi==JOptionPane.YES_OPTION){
                try{
                    Statement s = connection.createStatement();
                    String sql = "update riwayat_lelang set id_lelang='"+eidlelang.getSelectedItem()+"',"+"id_barang='"+idbarang+"',"+"id_user='"+iduser+"',"+"penawaran_harga='"+eharga.getText()+"' where id_riwayat='"+eid.getText()+"'";
                    s.executeUpdate(sql);
                    s.close();
                    JOptionPane.showMessageDialog(rootPane, "Data berhasil diubah!");
                    stateTambah();
                    refreshModel();
                    cardLayout.show(cards, "card1");
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }

    }//GEN-LAST:event_simpanActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        // TODO add your handling code here:
        if(rstatus=="tambah"){
            stateTambah();
        }else if(rstatus=="ubah"){
            stateUbah();
        }
    }//GEN-LAST:event_batalActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
        cardLayout.show(cards, "card1");
    }//GEN-LAST:event_keluarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batal;
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JPanel cards;
    private javax.swing.JButton cari;
    private javax.swing.JTextField eharga;
    private javax.swing.JTextField eid;
    private javax.swing.JComboBox<String> eidbarang;
    private javax.swing.JComboBox<String> eidlelang;
    private javax.swing.JComboBox<String> eiduser;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton keluar;
    private javax.swing.JButton refresh;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambah;
    private javax.swing.JTextField tcari;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
