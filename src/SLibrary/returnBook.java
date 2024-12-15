/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SLibrary;

import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Momcilo
 */
public class returnBook extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public returnBook() {
        initComponents();
        Connect();
        Return_Load();
      
   
          
    
    }

    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    
    
    
    
    public void Connect(){
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost/SLibrary","root","");
             
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(returnBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(returnBook.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    
    
   

    
    
    public void Return_Load(){
        
        int c;

        try {
            pst = con.prepareStatement("select l.id,m.name,b.name,l.issuedate,l.returndate from lendbook l JOIN member m ON l.memberid=m.id JOIN book b ON l.bookid=b.id");
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d=(DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            while(rs.next())
            {
            
                Vector v2 = new Vector();
            
            for(int i=1; i<=c; i++)
            {
                
             v2.add(rs.getString("id"));
             v2.add(rs.getString("mid"));
             v2.add(rs.getString("mname"));
             v2.add(rs.getString("bname"));
             v2.add(rs.getString("returndate"));
             v2.add(rs.getString("elp"));
             v2.add(rs.getString("fine"));
            }
            d.addRow(v2);
            
            }    
        } catch (SQLException ex) {
            Logger.getLogger(returnBook.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtmid = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtmname = new javax.swing.JLabel();
        txtbook = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtelp = new javax.swing.JTextField();
        txtfine = new javax.swing.JTextField();
        txtrdate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Return Book");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Member ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 175, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Member Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        txtmid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmidActionPerformed(evt);
            }
        });
        txtmid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmidKeyPressed(evt);
            }
        });
        jPanel1.add(txtmid, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 174, 238, -1));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 130, 50));

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 130, 50));

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 530, 130, 50));

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 130, 50));

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Member ID", "Member Name", "Book", "ReturnBook", "Days Elap", "Fine"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 850, 610));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("Book");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("Fine");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, -1, 40));

        txtmname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtmname.setForeground(new java.awt.Color(255, 255, 255));
        txtmname.setText("jLabel4");
        jPanel1.add(txtmname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 240, -1));

        txtbook.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtbook.setForeground(new java.awt.Color(255, 255, 255));
        txtbook.setText("jLabel8");
        jPanel1.add(txtbook, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 240, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setText("Return Date");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, 40));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 0));
        jLabel10.setText("Days Elapsed");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, 40));

        txtelp.setText("jTextField1");
        jPanel1.add(txtelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 240, -1));

        txtfine.setText("jTextField1");
        jPanel1.add(txtfine, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 240, -1));
        jPanel1.add(txtrdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 240, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1312, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
 
        String mid = txtmid.getText();
        String membername = txtmname.getText();
        String bookname = txtbook.getText();
        String returndate = txtrdate.getDateFormatString();
       String elpdays = txtelp.getText();
       String fine = txtfine.getText();
      
        
        try {
            pst = con.prepareStatement("insert into returnbook(mid,mname,bname,returndate,elp,fine)values(?,?,?,?,?,?)");
            pst.setString(1,mid);
            pst.setString(2, membername);          
            pst.setString(3, bookname);
            pst.setString(4,returndate);
            pst.setString(5, elpdays);
            pst.setString(6,fine);
            
            int k = pst.executeUpdate();
            
            pst = con.prepareStatement("delete from lendbook where memberid = ?");
                    pst.setString(1, mid);
                    pst.executeUpdate();
          
            
            
            
            if(k==1){
            
                JOptionPane.showMessageDialog(this,"Return Book Success!");
                
            txtmid.setText("");
            txtmname.setText("");
            txtbook.setText("");
            txtrdate.setDateFormatString("");
            txtelp.setText("");
            txtfine.setText("");
            
            txtmid.requestFocus();
            
                
            
               
                               
                
            }
            else
            {
              JOptionPane.showMessageDialog(this,"Error");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(returnBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
 
     
        
        jButton1.setEnabled(false);//dugme add stavlja nevidljivo
        
  
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 
    
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 
        
      
       
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtmidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmidActionPerformed

    private void txtmidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmidKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
     
        String id = txtmid.getText();
        
        try {
            pst = con.prepareStatement("select m.name,b.bname,l.returndate,DATEDIFF(now(),l.returndate) as elap from lendbook l JOIN member m ON l.memberid = m.id JOIN book b ON l.bookid = b.id and l.memberid=?");
            pst.setString(1, id);
            rs = pst.executeQuery();
            
            if(rs.next() == false)
            {
                JOptionPane.showMessageDialog(this, "Member ID Not Found");
            }
            else
            {
                String mname = rs.getString("m.name");
                String bname = rs.getString("b.bname");
                txtmname.setText(mname.trim());
                txtmname.setText(bname.trim());
                
                String date = rs.getString("l.returndate");
                
                txtrdate.setDateFormatString(id);
                
                String elp = rs.getString("elap");
                
                int elaped = Integer.parseInt(elp);
                
                if(elaped > 0)
                {
                    txtelp.setText(elp);
                    int fine = elaped * 100;
                    txtfine.setText(String.valueOf(fine));
                }
                else
                {
                 txtelp.setText("0");
                 txtfine.setText("0");
                    
                }
                
                

            }
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(returnBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
        
    }//GEN-LAST:event_txtmidKeyPressed

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
            java.util.logging.Logger.getLogger(returnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(returnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(returnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(returnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new returnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel txtbook;
    private javax.swing.JTextField txtelp;
    private javax.swing.JTextField txtfine;
    private javax.swing.JTextField txtmid;
    private javax.swing.JLabel txtmname;
    private com.toedter.calendar.JDateChooser txtrdate;
    // End of variables declaration//GEN-END:variables
}

