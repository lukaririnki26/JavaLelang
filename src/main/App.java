/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import lib.DBHelper;
import main.content.about.About;
import main.content.account.Account;
import main.content.data.Data;
import main.content.home.Home;
import main.content.home.HomeAdmin;
import main.content.home.HomePetugas;
import main.content.recent.Recent;
import main.content.report.Report;

/**
 *
 * @author fahmi
 */
public class App extends javax.swing.JFrame {
Connection connection = new DBHelper().init();
String rnama,ruser,rpass;

    /**
     * Creates new form Home
     */
    
    public String id,level;
    public App(String id,String level ) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.id=id;
        this.level=level;
        String lev=this.level;
        
          
        if("masyarakat".equals(lev)){
            content.removeAll();
            Home h = new Home(id);
            content.add(h).setVisible(true);
            data.setEnabled(false);
            report.setEnabled(false);
            try {
            String sql1="select nama_lengkap,username,password from masyarakat where id_user='"+id+"'";
            ResultSet rs1=connection.createStatement().executeQuery(sql1);
            while (rs1.next()) {
                this.rnama = rs1.getString(1);
                this.ruser = rs1.getString(2);
                this.rpass = rs1.getString(3);
                }
                createQr("qr1");
                rs1.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }else if("petugas".equals(lev)){
            content.removeAll();
            HomePetugas h2 = new HomePetugas(id);
            content.add(h2).setVisible(true);
            data.setEnabled(true);
            report.setEnabled(true);   
            try {
            String sql2="select nama_petugas,username,password from petugas where id_petugas='"+id+"'";
            ResultSet rs2=connection.createStatement().executeQuery(sql2);
            while (rs2.next()) {
                this.rnama = rs2.getString(1);
                this.ruser = rs2.getString(2);
                this.rpass = rs2.getString(3); 
                }
                createQr("qr");
                rs2.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }else if("administrator".equals(lev)){
            content.removeAll();
            HomeAdmin h3 = new HomeAdmin();
            content.add(h3).setVisible(true);
            data.setEnabled(true);
            report.setEnabled(true);
            try {
                
            String sql2="select nama_petugas,username,password from petugas where id_petugas='"+id+"'";
            ResultSet rs2=connection.createStatement().executeQuery(sql2);
            while (rs2.next()) {
                this.rnama = rs2.getString(1);
                this.ruser = rs2.getString(2);
                this.rpass = rs2.getString(3);
                }
                createQr("qr2");
                rs2.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        
    }
    private void createQr(String dat){
        Charset charset = Charset.forName("ISO-8859-1");
        CharsetEncoder encoder = charset.newEncoder();
        String data=null;
        byte[] b=null;
        BitMatrix matrix = null;
        int h = 150;
        int w = 150;
        com.google.zxing.Writer writer = new QRCodeWriter();
        String filepath = "src/qr/"+dat+".png";  
        File file = new File(filepath);
        try {
            ByteBuffer bb = encoder.encode(CharBuffer.wrap(""
                                                        +"|   Nama Petugas  : "+this.rnama+"    |"
                                                        +"|   Username      : "+this.ruser+"    |"
                                                        + "   Password      : "+this.rpass+"    |"
                                                        + ""));
            b = bb.array();
        } catch (CharacterCodingException e) {
            System.out.println("disini");
        }
        try {
            data = new String(b,"ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            System.out.print("disini1");
        }
        try {
            matrix = writer.encode(data, BarcodeFormat.QR_CODE, w, h);
        } catch (com.google.zxing.WriterException e) {
        }
        try {
            MatrixToImageWriter.writeToFile(matrix, "PNG", file);
            
        } catch (Exception e) {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        home = new javax.swing.JLabel();
        data = new javax.swing.JLabel();
        account = new javax.swing.JLabel();
        about = new javax.swing.JLabel();
        report = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        recent = new javax.swing.JLabel();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.white);

        jPanel1.setBackground(java.awt.Color.white);

        jPanel2.setBackground(java.awt.Color.blue);
        jPanel2.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel2.setMinimumSize(new java.awt.Dimension(873, 137));

        jLabel1.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icon/store-icon.png"))); // NOI18N
        jLabel1.setText("APLIKASI LELANG");

        jPanel6.setBackground(new java.awt.Color(21, 106, 241));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.darkGray));
        jPanel6.setLayout(null);

        home.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        home.setForeground(java.awt.Color.white);
        home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        home.setText("Home");
        home.setAlignmentY(0.0F);
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });
        jPanel6.add(home);
        home.setBounds(10, 0, 80, 30);

        data.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        data.setForeground(java.awt.Color.white);
        data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        data.setText("Data");
        data.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dataMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dataMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dataMouseEntered(evt);
            }
        });
        jPanel6.add(data);
        data.setBounds(110, 0, 70, 30);

        account.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        account.setForeground(java.awt.Color.white);
        account.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        account.setText("Account");
        account.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        account.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountMouseClicked(evt);
            }
        });
        jPanel6.add(account);
        account.setBounds(510, 0, 80, 30);

        about.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        about.setForeground(java.awt.Color.white);
        about.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        about.setText("About");
        about.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        about.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutMouseClicked(evt);
            }
        });
        jPanel6.add(about);
        about.setBounds(310, 0, 70, 30);

        report.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        report.setForeground(java.awt.Color.white);
        report.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        report.setText("Report");
        report.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportMouseClicked(evt);
            }
        });
        jPanel6.add(report);
        report.setBounds(410, 0, 70, 30);

        logout.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        logout.setForeground(java.awt.Color.white);
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setText("Logout");
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        jPanel6.add(logout);
        logout.setBounds(610, 0, 80, 30);

        exit.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        exit.setForeground(java.awt.Color.white);
        exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit.setText("Exit");
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        jPanel6.add(exit);
        exit.setBounds(710, 0, 70, 30);

        recent.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        recent.setForeground(java.awt.Color.white);
        recent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        recent.setText("Recent");
        recent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        recent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recentMouseClicked(evt);
            }
        });
        jPanel6.add(recent);
        recent.setBounds(210, 0, 70, 30);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        content.setBackground(java.awt.Color.white);
        content.setAlignmentX(CENTER_ALIGNMENT);
        content.setAlignmentY(CENTER_ALIGNMENT);
        content.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        content.setMinimumSize(new java.awt.Dimension(873, 511));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 871, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataMouseClicked
        // TODO add your handling code here:
        String lev=this.level;
        if("petugas".equals(lev)){ 
            content.removeAll();
            Data d = new Data(level);
            content.add(d).setVisible(true);
        }else if("administrator".equals(lev)){
            content.removeAll();
            Data d = new Data(level);
            content.add(d).setVisible(true);
        }
       
    }//GEN-LAST:event_dataMouseClicked

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        // TODO add your handling code here:
     String lev=this.level;
     if("masyarakat".equals(lev)){
        content.removeAll();
        Home h = new Home(id);
        content.add(h).setVisible(true);
     }else if("petugas".equals(lev)){
        content.removeAll();
        HomePetugas h2 = new HomePetugas(id);
        content.add(h2).setVisible(true);
     }
     else if("administrator".equals(lev)){
        content.removeAll();
        HomeAdmin h3 = new HomeAdmin();
        content.add(h3).setVisible(true);
        }
    }//GEN-LAST:event_homeMouseClicked

    private void dataMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_dataMouseEntered

    private void dataMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataMouseExited
        // TODO add your handling code here:
        
    }//GEN-LAST:event_dataMouseExited

    private void dataMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_dataMousePressed

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        Object[] options={"YA","TIDAK"};
        int konfirmasi=JOptionPane.showOptionDialog(null, "apakah anda yakin ingin Logout?","Konfirmasi", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE ,null, options,options[0]);
        if (konfirmasi==JOptionPane.YES_OPTION) {
            id = "";
            level = "";
            dispose();
            new Login().show(); ;
        }   
    }//GEN-LAST:event_logoutMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        // TODO add your handling code here:
        Object[] options={"YA","TIDAK"};
        int konfirmasi=JOptionPane.showOptionDialog(null, "apakah anda yakin ingin keluar?","Konfirmasi", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE ,null, options,options[0]);
        if (konfirmasi==JOptionPane.YES_OPTION) {
            System.exit(0);
        }  
    }//GEN-LAST:event_exitMouseClicked

    private void aboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMouseClicked
        // TODO add your handling code here:
        content.removeAll();
        About ab = new About();
        content.add(ab).setVisible(true);
    }//GEN-LAST:event_aboutMouseClicked

    private void accountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountMouseClicked
        // TODO add your handling code here:
        content.removeAll();
        Account ac = new Account(id,level);
        content.add(ac).setVisible(true);
    }//GEN-LAST:event_accountMouseClicked

    private void recentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recentMouseClicked
        // TODO add your handling code here:
        content.removeAll();
        Recent r = new Recent();
        content.add(r).setVisible(true);
    }//GEN-LAST:event_recentMouseClicked

    private void reportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMouseClicked
        // TODO add your handling code here:
         String lev=this.level;
        if("petugas".equals(lev)){ 
            content.removeAll();
            Report re = new Report();
            content.add(re).setVisible(true);
        }else if("administrator".equals(lev)){
            content.removeAll();
            Report re = new Report();
            content.add(re).setVisible(true);
        }
        
    }//GEN-LAST:event_reportMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App("","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel about;
    private javax.swing.JLabel account;
    private javax.swing.JPanel content;
    private javax.swing.JLabel data;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel recent;
    private javax.swing.JLabel report;
    // End of variables declaration//GEN-END:variables
}
