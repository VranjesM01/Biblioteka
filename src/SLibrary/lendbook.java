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
public class lendbook extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public lendbook() {
        initComponents();
        Connect();
        book();
        Issuebook_Load();
   
          
    
    }

    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    
    
    
    
    public void Connect(){
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost/SLibrary","root","");
             
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(lendbook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(lendbook.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    
    
    public class BookItem
    {
        int id;
        String name;
        
        public BookItem(int id, String name)
        {
            this.id = id;
            this.name = name;
            
            
        }
        
        public String toString()
        {
            return name;
                }
    }
    
    
    public void book()
    {
         try {
            pst=con.prepareStatement("select * from book");
            rs=pst.executeQuery();
            
            txtbook.removeAllItems();
            
            while(rs.next())
            {
                txtbook.addItem(new BookItem (rs.getInt(1),rs.getString(2)));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }


    
    
    public void Issuebook_Load(){
        
        int c;

        try {
            pst = con.prepareStatement("select l.id,m.name,b.bname,l.issuedate,l.returndate from lendbook l JOIN member m ON l.memberid =m.id JOIN book b ON l.bookid=b.id");
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
                
             v2.add(rs.getString("l.id"));
             v2.add(rs.getString("m.name"));
             v2.add(rs.getString("b.bname"));
             v2.add(rs.getString("l.issuedate"));
             v2.add(rs.getString("l.returndate"));
            }
            d.addRow(v2);
            
            }    
        } catch (SQLException ex) {
            Logger.getLogger(lendbook.class.getName()).log(Level.SEVERE, null, ex);
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

        txtrdate = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtbook = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        txtmember = new javax.swing.JTextField();
        txtissuedate = new com.toedter.calendar.JDateChooser();
        txtreturndate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library Management System");

        txtrdate.setBackground(new java.awt.Color(0, 102, 102));
        txtrdate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Issue Book");
        txtrdate.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Member ID");
        txtrdate.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Member Name");
        txtrdate.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidKeyPressed(evt);
            }
        });
        txtrdate.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 174, 238, -1));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        txtrdate.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 130, 50));

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        txtrdate.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 570, 130, 50));

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        txtrdate.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 570, 130, 50));

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Member Name", "Book", "Issue Date", "ReturnDate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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

        txtrdate.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 850, 610));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("Book");
        txtrdate.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setText("Date");
        txtrdate.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, -1));

        txtbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbookActionPerformed(evt);
            }
        });
        txtrdate.add(txtbook, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 240, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("Return Date");
        txtrdate.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, 40));
        txtrdate.add(txtmember, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 240, -1));
        txtrdate.add(txtissuedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 240, -1));
        txtrdate.add(txtreturndate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 240, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtrdate, javax.swing.GroupLayout.PREFERRED_SIZE, 1312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtrdate, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String mid = txtid.getText();
        BookItem bitem = (BookItem) txtbook.getSelectedItem();
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
        String issuedate = date_format.format(txtissuedate.getDate());
       
        
        SimpleDateFormat date_format1 = new SimpleDateFormat("yyyy-MM-dd");
        String returndate = date_format.format(txtreturndate.getDate());
        
        
      
       
      
        
        try {
            pst = con.prepareStatement("insert into lendbook(memberid,bookid,issuedate,returndate)values(?,?,?,?)");
            pst.setString(1,mid);
            pst.setInt(2, bitem.id);          
            pst.setString(3, issuedate);
            pst.setString(4,returndate);
            int k = pst.executeUpdate();
            
            
            
            if(k==1){
            
                JOptionPane.showMessageDialog(this,"Book Issued!");
                
                txtid.setText("");
                txtbook.setSelectedIndex(-1);
                txtmember.setText("");
                Issuebook_Load();
                
            
               
                               
                
            }
            else
            {
              JOptionPane.showMessageDialog(this,"Error");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(lendbook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
 
      DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
        
        int id= Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        
        txtid.setText(d1.getValueAt(selectIndex,0).toString());
        txtmember.setText(d1.getValueAt(selectIndex,1).toString());
        //txtbook.setText(d1.getValueAt(selectIndex,3).toString());
        //txtissuedate.setText(d1.getValueAt(selectIndex,4).toString());
        //txtreturndate.setText(d1.getValueAt(selectIndex,5).toString());
        
         
        
        
        jButton1.setEnabled(false);//dugme add stavlja nevidljivo
        
        
     
        
  
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 
        
       DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
        
        int id= Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        
        // TODO add your handling code here:
       
        
        try {
            pst = con.prepareStatement("delete from lendbook where id=?");
            pst.setInt(1, id);
           
            
            int k = pst.executeUpdate();
            
            
            
            if(k==1){
            
                JOptionPane.showMessageDialog(this,"Record deleted!");
                
               txtid.setText("");
               txtmember.setText("");
               txtbook.setSelectedIndex(-1);
               txtissuedate.requestFocus();
               txtreturndate.requestFocus();
               Issuebook_Load();
               jButton1.setEnabled(true); 
               
                               
                
            }
            else
            {
              JOptionPane.showMessageDialog(this,"Error");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
       
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbookActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyPressed
            // TODO add your handling code here:
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        
        String mid = txtid.getText();
        
            try {
                pst = con.prepareStatement("select * from member where id = ?");
                 pst.setString(1, mid);
                 rs = pst.executeQuery();
                 
                 if(rs.next()==false)
                 {
                     JOptionPane.showMessageDialog(this, "Member ID not found");
                 }
                 else
                 {
                     String membername = rs.getString("name");
                     txtmember.setText(membername.trim());
                 }
                       
                 
                 
            } catch (SQLException ex) {
                Logger.getLogger(lendbook.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        jButton1.setEnabled(true);
        }
    }//GEN-LAST:event_txtidKeyPressed

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
            java.util.logging.Logger.getLogger(lendbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lendbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lendbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lendbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lendbook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox txtbook;
    private javax.swing.JTextField txtid;
    private com.toedter.calendar.JDateChooser txtissuedate;
    private javax.swing.JTextField txtmember;
    private javax.swing.JPanel txtrdate;
    private com.toedter.calendar.JDateChooser txtreturndate;
    // End of variables declaration//GEN-END:variables
}

