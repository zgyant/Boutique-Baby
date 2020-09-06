/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static resources.ConnectDB.st;

/**
 *
 * @author Jayant
 */
public class dataBase {
    Connection con;
    public dataBase()throws SQLException
    {
        con = DriverManager.getConnection("jdbc:mysql://localhost/adi", "root", "");
             st = con.createStatement(); 
         String sqlCreate1=("CREATE TABLE IF NOT EXISTS `users` (\n" +
" `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
" `username` varchar(20) NOT NULL,\n" +
" `password` varchar(20) NOT NULL,\n" +
" `type` varchar(6) NOT NULL,\n" +
" PRIMARY KEY (`id`),\n" +
" UNIQUE KEY `username` (`username`)\n" +
") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1");
    st.execute(sqlCreate1);
//second table    
      String sqlCreate2=("CREATE TABLE IF NOT EXISTS `datas` (\n" +
" `id` varchar(150) NOT NULL,\n" +
" `itemname` varchar(50) NOT NULL,\n" +
" `color` varchar(20) NOT NULL,\n" +
" `descr` varchar(1000) NOT NULL,\n" +
" `price` mediumtext NOT NULL,\n" +
" `material` varchar(50) NOT NULL,\n" +
" `manuf` varchar(50) NOT NULL,\n" +
" `length` varchar(50) NOT NULL,\n" +
" `size` varchar(50) NOT NULL,\n" +
" `weight` varchar(50) NOT NULL,\n" +
" UNIQUE KEY `id` (`id`)\n" +
") ENGINE=InnoDB DEFAULT CHARSET=latin1");
    st.execute(sqlCreate2);
   //third table
    
      String sqlCreate3=("CREATE TABLE IF NOT EXISTS `extra` (\n" +
" `cname` varchar(50) NOT NULL,\n" +
" `addr` varchar(50) NOT NULL,\n" +
" `postc` varchar(50) NOT NULL,\n" +
" `phone` varchar(50) NOT NULL,\n" +
" `email` varchar(50) NOT NULL,\n" +
" `pname` varchar(50) NOT NULL,\n" +
" `date` varchar(50) NOT NULL,\n" +
" `suser` varchar(50) NOT NULL\n" +
") ENGINE=InnoDB DEFAULT CHARSET=latin1");
    st.execute(sqlCreate3);
    
    
    
    
    }
    
}
