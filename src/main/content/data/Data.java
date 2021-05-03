/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.content.data;

import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author fahmi
 */
public class Data extends javax.swing.JInternalFrame {
    /**
     * Creates new form Data
     */
    String level;
    public Data(String level) {
        initComponents();
        BasicInternalFrameUI ui = (BasicInternalFrameUI) getUI();
        ui.setNorthPane(null);
        this.level=level;
        String lev=this.level;
        if("petugas".equals(lev)) {
            bmasyarakat.setEnabled(false);
            bpetugas.setEnabled(false);
            bbarang.setEnabled(true);
            blelang.setEnabled(false);
            briwayat.setEnabled(false);
        }else if("administrator".equals(lev)){
            bmasyarakat.setEnabled(true);
            bpetugas.setEnabled(true);
            bbarang.setEnabled(true);
            blelang.setEnabled(true);
            briwayat.setEnabled(true);
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

        data = new javax.swing.JPanel();
        bmasyarakat = new javax.swing.JButton();
        bpetugas = new javax.swing.JButton();
        bbarang = new javax.swing.JButton();
        blelang = new javax.swing.JButton();
        briwayat = new javax.swing.JButton();

        setBackground(java.awt.Color.white);
        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        data.setBackground(java.awt.Color.white);
        data.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        data.setPreferredSize(new java.awt.Dimension(887, 558));

        bmasyarakat.setBackground(new java.awt.Color(21, 106, 241));
        bmasyarakat.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        bmasyarakat.setForeground(java.awt.Color.white);
        bmasyarakat.setText("Masyarakat");
        bmasyarakat.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        bmasyarakat.setBorderPainted(false);
        bmasyarakat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bmasyarakat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmasyarakatActionPerformed(evt);
            }
        });

        bpetugas.setBackground(new java.awt.Color(21, 106, 241));
        bpetugas.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        bpetugas.setForeground(java.awt.Color.white);
        bpetugas.setText("Petugas");
        bpetugas.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        bpetugas.setBorderPainted(false);
        bpetugas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bpetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpetugasActionPerformed(evt);
            }
        });

        bbarang.setBackground(new java.awt.Color(21, 106, 241));
        bbarang.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        bbarang.setForeground(java.awt.Color.white);
        bbarang.setText("Barang");
        bbarang.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        bbarang.setBorderPainted(false);
        bbarang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbarangActionPerformed(evt);
            }
        });

        blelang.setBackground(new java.awt.Color(21, 106, 241));
        blelang.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        blelang.setForeground(java.awt.Color.white);
        blelang.setText("Lelang");
        blelang.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        blelang.setBorderPainted(false);
        blelang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        blelang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blelangActionPerformed(evt);
            }
        });

        briwayat.setBackground(new java.awt.Color(21, 106, 241));
        briwayat.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        briwayat.setForeground(java.awt.Color.white);
        briwayat.setText("Riwayat Lelang");
        briwayat.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        briwayat.setBorderPainted(false);
        briwayat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        briwayat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                briwayatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dataLayout = new javax.swing.GroupLayout(data);
        data.setLayout(dataLayout);
        dataLayout.setHorizontalGroup(
            dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataLayout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addGroup(dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(briwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blelang, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bmasyarakat, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(203, 203, 203))
        );
        dataLayout.setVerticalGroup(
            dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(bmasyarakat, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(bpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(bbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(blelang, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(briwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(data, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(data, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bmasyarakatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmasyarakatActionPerformed
        // TODO add your handling code here:
        data.removeAll();        
        Masyarakat masyarakat = new Masyarakat();
        data.add(masyarakat).setVisible(true);
    }//GEN-LAST:event_bmasyarakatActionPerformed

    private void bpetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bpetugasActionPerformed
        // TODO add your handling code here:
        data.removeAll();        
        Petugas petugas = new Petugas();
        data.add(petugas).setVisible(true);
    }//GEN-LAST:event_bpetugasActionPerformed

    private void bbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbarangActionPerformed
        // TODO add your handling code here:
        data.removeAll();        
        Barang barang = new Barang();
        data.add(barang).setVisible(true);
    }//GEN-LAST:event_bbarangActionPerformed

    private void blelangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blelangActionPerformed
        // TODO add your handling code here:
        data.removeAll();        
        Lelang lelang = new Lelang();
        data.add(lelang).setVisible(true);
    }//GEN-LAST:event_blelangActionPerformed

    private void briwayatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_briwayatActionPerformed
        // TODO add your handling code here:
        data.removeAll();        
        RiwayatLelang riwayatlelang = new RiwayatLelang();
        data.add(riwayatlelang).setVisible(true);
    }//GEN-LAST:event_briwayatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbarang;
    private javax.swing.JButton blelang;
    private javax.swing.JButton bmasyarakat;
    private javax.swing.JButton bpetugas;
    private javax.swing.JButton briwayat;
    private javax.swing.JPanel data;
    // End of variables declaration//GEN-END:variables
}