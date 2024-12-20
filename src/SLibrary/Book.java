/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Momcilo
 */
public class Book extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public Book() {
        initComponents();
        Connect();
        Category();
        Author();
        Publisher();
        Book_Load();
        
        
        
        
        
    
    }
      
    public class CategoryItem
    {
    int id;
    String name;
    
        public CategoryItem(int id, String name)
        {
             this.id=id;
             this.name=name;
        }
    
        public String toString()
        {
            return name;
        }
    }
    
     public class AuthorItem
    {
    int id;
    String name;
    
        public AuthorItem(int id, String name)
        {
             this.id=id;
             this.name=name;
        }
    
        public String toString()
        {
            return name;
        }
    }
     
     
          public class PublisherItem
    {
    int id;
    String name;
    
        public PublisherItem(int id, String name)
        {
             this.id=id;
             this.name=name;
        }
    
        public String toString()
        {
            return name;
        }
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    
    
    
    
    public void Connect(){
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost/SLibrary","root","");
             
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    

    public void Category()
            
    {
        try {
            pst=con.prepareStatement("select * from category");
            rs=pst.executeQuery();
            
            txtcategory.removeAllItems();
            
            while(rs.next())
            {
                txtcategory.addItem(new CategoryItem(rs.getInt(1),rs.getString(2)));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public void Author()
            
    {
        try {
            pst=con.prepareStatement("select * from author");
            rs=pst.executeQuery();
            
            txtauthor.removeAllItems();
            
            while(rs.next())
            {
                txtauthor.addItem(new AuthorItem (rs.getInt(1),rs.getString(2)));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     
     public void Publisher()
            
    {
        try {
            pst=con.prepareStatement("select * from publisher");
            rs=pst.executeQuery();
            
            txtpub.removeAllItems();
            
            while(rs.next())
            {
                txtpub.addItem(new PublisherItem (rs.getInt(1),rs.getString(2)));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
    
    
    public void Book_Load(){
        
        int c;

        try {
            pst = con.prepareStatement("select b.id,b.bname,c.catname,a.name,p.name,b.contents,b.pages,b.edition from book b JOIN category c On b.category =c.id JOIN author a On b.author=a.id JOIN publisher p On b.publisher=p.id ");
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
                
             v2.add(rs.getString("b.id"));
             v2.add(rs.getString("b.bname"));
             v2.add(rs.getString("c.catname"));
             v2.add(rs.getString("a.name"));
             v2.add(rs.getString("p.name"));
             v2.add(rs.getString("b.contents"));
             v2.add(rs.getString("b.pages"));
             v2.add(rs.getString("b.edition"));
            }
            d.addRow(v2);
            
            }    
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
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
        txtname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtcontent = new javax.swing.JTextField();
        txtcategory = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtauthor = new javax.swing.JComboBox();
        txtpub = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtno = new javax.swing.JTextField();
        txtedition = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library Management System");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Book");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 175, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Category");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));
        jPanel1.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 174, 238, -1));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 570, 130, 50));

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 570, 130, 50));

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 630, 130, 50));

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 630, 130, 50));

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Name", "Category", "Author", "Publisher", "Contents", "No.of Pages", "Edition"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 850, 690));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Edition");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, -1, 40));

        txtcontent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontentActionPerformed(evt);
            }
        });
        jPanel1.add(txtcontent, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 240, -1));

        txtcategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jPanel1.add(txtcategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 240, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("Author");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setText("Publisher");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        txtauthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtauthorActionPerformed(evt);
            }
        });
        jPanel1.add(txtauthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 240, -1));

        jPanel1.add(txtpub, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 240, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("Contents");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 367, -1, 40));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 0));
        jLabel8.setText("No.of pages");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, -1, 40));
        jPanel1.add(txtno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 240, -1));
        jPanel1.add(txtedition, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 240, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setText("TugaČemerJad2024");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 690, -1, -1));

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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
      String bname=txtname.getText();
      CategoryItem citem=(CategoryItem)txtcategory.getSelectedItem();
      AuthorItem aitem=(AuthorItem)txtauthor.getSelectedItem();
      PublisherItem pitem=(PublisherItem)txtpub.getSelectedItem();
      
      String contents=txtcontent.getText();
      String pages=txtno.getText();
      String edition=txtedition.getText();
      
       
      
        
        try {
            pst = con.prepareStatement("insert into book(bname,category, author, publisher, contents, pages, edition)values(?,?,?,?,?,?,?)");
            pst.setString(1,bname);
            pst.setInt(2, citem.id);
            pst.setInt(3,aitem.id);
            pst.setInt(4,pitem.id);
            pst.setString(5, contents);
            pst.setString(6,pages);
            pst.setString(7,edition);
            
            int k = pst.executeUpdate();
            
            
            
            if(k==1){
            
                JOptionPane.showMessageDialog(this,"Book created!");
                
                txtname.setText("");
                txtcategory.setSelectedIndex(-1);
                txtauthor.setSelectedIndex(-1);
                txtpub.setSelectedIndex(-1);
                txtcontent.setText("");
                txtno.setText("");
                txtedition.setText("");
                
                Book_Load();
               
                               
                
            }
            else
            {
              JOptionPane.showMessageDialog(this,"Error");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
 
       DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
        
        int id= Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        
        txtname.setText(d1.getValueAt(selectIndex,1).toString());
       // txtcategory.setSelectedIndex(d1.getValueAt(selectIndex,2).toString());
        //txtauthor.setText(d1.getValueAt(selectIndex,3).toString());
        //txtpub.setText(d1.getValueAt(selectIndex,4).toString());
        txtcontent.setText(d1.getValueAt(selectIndex,5).toString());
        txtno.setText(d1.getValueAt(selectIndex,6).toString());
        txtedition.setText(d1.getValueAt(selectIndex,7).toString());
        
        //fali da se doda kod za kategoriju,autor i publisher da kada se klikne na tabelu upise vrednosti u textfield
         
        
        
        jButton1.setEnabled(false);//dugme add stavlja nevidljivo
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 
         DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
        
        int id= Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        
            
      String bname=txtname.getText();
      CategoryItem citem=(CategoryItem)txtcategory.getSelectedItem();
      AuthorItem aitem=(AuthorItem)txtauthor.getSelectedItem();
      PublisherItem pitem=(PublisherItem)txtpub.getSelectedItem();
      
      String contents=txtcontent.getText();
      String pages=txtno.getText();
      String edition=txtedition.getText();
        
        
        try {
            pst = con.prepareStatement("update book set bname=?,category=?, author=?, publisher=?, contents=?, pages=?, edition=? where id=?");
            pst.setString(1,bname);
            pst.setInt(2, citem.id);
            pst.setInt(3,aitem.id);
            pst.setInt(4,pitem.id);
            pst.setString(5, contents);
            pst.setString(6,pages);
            pst.setString(7,edition);
            
            int k = pst.executeUpdate();
            
            
            
            if(k==1){
            
                JOptionPane.showMessageDialog(this,"Book Updated");
                
               txtname.setText("");
                txtcategory.setSelectedIndex(-1);
                txtauthor.setSelectedIndex(-1);
                txtpub.setSelectedIndex(-1);
                txtcontent.setText("");
                txtno.setText("");
                txtedition.setText("");
                
                Book_Load();

                
                
            }
            else
            {
              JOptionPane.showMessageDialog(this,"Error");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }      
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 

        // TODO add your handling code here:
        DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
        
        int id= Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
      
        try {
            pst = con.prepareStatement("delete from Book where id=?");

            pst.setInt(1, id);
            
            int k = pst.executeUpdate();
            
            
            
            if(k==1){
            
                JOptionPane.showMessageDialog(this,"Book Deleted");
                
                txtname.setText("");
                txtcategory.setSelectedIndex(-1);
                txtauthor.setSelectedIndex(-1);
                txtpub.setSelectedIndex(-1);
                txtcontent.setText("");
                txtno.setText("");
                txtedition.setText("");
                
                Book_Load();

                
                
            }
            else
            {
              JOptionPane.showMessageDialog(this,"Error");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }      
        
        // TODO add your handling code here:
       
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtcontentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontentActionPerformed

    private void txtauthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtauthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtauthorActionPerformed

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
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox txtauthor;
    private javax.swing.JComboBox txtcategory;
    private javax.swing.JTextField txtcontent;
    private javax.swing.JTextField txtedition;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtno;
    private javax.swing.JComboBox txtpub;
    // End of variables declaration//GEN-END:variables
}

