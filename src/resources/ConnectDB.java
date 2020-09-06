package resources;
import java.sql.*;

import javax.swing.JOptionPane;

public class ConnectDB {
        String host="jdbc:mysql://localhost/";
	String user="root";
	String password="";
	String driver = "com.mysql.jdbc.Driver";
	Connection con;
	static Statement st;	
	{
	
	 try {
 
             con = DriverManager.getConnection(host, user, password);
             st = con.createStatement();        
            String sqldb="CREATE DATABASE IF NOT EXISTS `adi`";
                st.execute(sqldb);
                dataBase db=new dataBase();
             } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null,ex);   
                 System.exit(2);
     } 
}
	
}
