package resources;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class searchForm extends javax.swing.JFrame {

    public searchForm() {
        initComponents();
        this.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        srcField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        srchtype = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultarea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);

        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        srchtype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Products", "Costumer", "Seller" }));

        resultarea.setColumns(20);
        resultarea.setRows(5);
        jScrollPane1.setViewportView(resultarea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(srchtype, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(srcField, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(srcField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(srchtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
String selected=(String) srchtype.getSelectedItem();
  String query=srcField.getText();
       if(selected.equals("Products"))
       {
         
           String sqlquery="SELECT * FROM `extra` WHERE `pname`=('"+query+"')";
            try {
               ResultSet rs=ConnectDB.st.executeQuery(sqlquery);
               while(rs.next())
               {
                  String costumer= rs.getString("cname");
                  String date=rs.getString("date");
                  String soldby=rs.getString("suser");
                  resultarea.append("Costumer Name : "+costumer + "\n"+"Date : "+date+ "\n"+"Seller Name : "+soldby+"\n"+"-------------\n");
               }
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
       }else if(selected.equals("Costumer"))
       {
           String sqlquery="SELECT * FROM `extra` WHERE `cname`=('"+query+"')";
             try {
              ResultSet rs=ConnectDB.st.executeQuery(sqlquery);
               while(rs.next())
               {
                  String date=rs.getString("date");
                  String soldby=rs.getString("suser");
                  String pname=rs.getString("pname");
                  resultarea.append("Product Name : "+pname + "\n"+"Date : "+date+ "\n"+"Seller Name : "+soldby+"\n"+"-------------\n");
               }
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
       }
       else if(selected.equals("Seller"))
       {
            String sqlquery="SELECT * FROM `extra` WHERE `suser`=('"+query+"')";
              try {
               ResultSet rs=ConnectDB.st.executeQuery(sqlquery);
               while(rs.next())
               {
                    String costumer= rs.getString("cname");
                  String date=rs.getString("date");
                   String pname=rs.getString("pname");
                  resultarea.append("Product Name : "+pname+"\n" +"Costumer Name : "+costumer + "\n"+"Date : "+date+ "\n"+"-------------\n");
               }
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
       }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea resultarea;
    private javax.swing.JTextField srcField;
    private javax.swing.JComboBox srchtype;
    // End of variables declaration//GEN-END:variables
}
