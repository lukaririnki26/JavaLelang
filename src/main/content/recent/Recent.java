/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.content.recent;

import main.content.data.*;
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
public class Recent extends javax.swing.JInternalFrame {
Connection connection =  new DBHelper().init();
private String id,id_lelang,id_barang,id_user,harga;
    /**
     * Creates new form Masyarakat
     */
    public Recent() {
        initComponents();
        BasicInternalFrameUI ui = (BasicInternalFrameUI)getUI();
        ui.setNorthPane(null); 
        tabelmodel();
        tabel.setModel(defaultmodel);
    }
    int row=0;
    
    private void tabelmodel(){
        String sql = "SELECT lelang.id_lelang,barang.nama_barang,masyarakat.nama_lengkap,riwayat_lelang.penawaran_harga from riwayat_lelang INNER join lelang on riwayat_lelang.id_lelang=lelang.id_lelang INNER join barang on riwayat_lelang.id_barang=barang.id_barang INNER join masyarakat on riwayat_lelang.id_user=masyarakat.id_user";
    try {
        ResultSet modeltabel =connection.createStatement().executeQuery(sql);
        while (modeltabel.next()) {            
            String[] modeldata={modeltabel.getString(1),modeltabel.getString(2),modeltabel.getString(3),modeltabel.getString(4)};
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
                    new String[]{"id_lelang","nama_barang","nama_user","penawaran_harga"}
            ){
            boolean[] canEdit = new boolean[]{false,false,false,false,false};
            public boolean isCellEditable(int rowIndex,int columnIndex){
            return canEdit[columnIndex];
                }};
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        refresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cari = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setName(""); // NOI18N

        jPanel2.setBackground(java.awt.Color.white);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_lelang", "nama_barang", "nama_user", "penawaran_harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(java.awt.Color.white);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.black);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RIWAYAT LELANG");

        jLabel2.setFont(new java.awt.Font("Open Sans", 2, 12)); // NOI18N
        jLabel2.setText("cari berdasarkan nama barang");

        cari.setBackground(new java.awt.Color(21, 106, 241));
        cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icon/search-14-24.png"))); // NOI18N
        cari.setBorderPainted(false);
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cari)
                .addGap(31, 31, 31))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
//        // TODO add your handling code here:
//        row=tabel.getSelectedRow();
//        this.id =defaultmodel.getValueAt(row,0).toString();
//        this.id_lelang = defaultmodel.getValueAt(row,1).toString();
//        this.id_barang = defaultmodel.getValueAt(row,2).toString();
//        this.id_user = defaultmodel.getValueAt(row, 3).toString();
//        this.harga = defaultmodel.getValueAt(row, 4).toString();
    }//GEN-LAST:event_tabelMouseClicked

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        defaultmodel.setRowCount(0);
        tabelmodel();
        tabel.setModel(this.defaultmodel);
    }//GEN-LAST:event_refreshActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
        try {
            defaultmodel.setRowCount(0);
            String sql = "SELECT lelang.id_lelang,barang.nama_barang,masyarakat.nama_lengkap,riwayat_lelang.penawaran_harga from riwayat_lelang INNER join lelang on riwayat_lelang.id_lelang=lelang.id_lelang INNER join barang on riwayat_lelang.id_barang=barang.id_barang INNER join masyarakat on riwayat_lelang.id_user=masyarakat.id_user where barang.nama_barang like '%"+tcari.getText()+"%'"; 
            ResultSet modeltabel =connection.createStatement().executeQuery(sql);
            while (modeltabel.next()) {
                String[] modeldata={modeltabel.getString(1),modeltabel.getString(2),modeltabel.getString(3),modeltabel.getString(4)};
                defaultmodel.addRow(modeldata);
            }
            modeltabel.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_cariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refresh;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField tcari;
    // End of variables declaration//GEN-END:variables
}