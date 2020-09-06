package resources;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class ButtonActions {

//exit code	
public static void exit()
{
	System.exit(2);
	
}
//login code
public  static void login() throws SQLException
{
	String username=LoginG.userArea.getText();
	String password=LoginG.userPass.getText();
	ConnectDB cdb=new ConnectDB();
	ResultSet rs;
	
	
	String sqlquery="SELECT * FROM users where username='" + username + "' and password='" + password + "'";
	
    rs = ConnectDB.st.executeQuery(sqlquery);
    
    if (rs.next())
    {
                        
    			DashGUI ag=new DashGUI();
                        String type=rs.getString("type");
                        if(type.equals("admin"))
                        {
                        DashGUI.adminWelcome.setText("Welcome Admin");
                         DashGUI.usernamedash.setText(username);
                        LoginG.frameLogin.setVisible(false);
                        }
                        else
                        {
                           DashGUI.adminWelcome.setText("Welcome User"); 
                            DashGUI.usernamedash.setText(username);
                           DashGUI.jMenuItem1.setEnabled(false);
                            DashGUI.jMenuItem2.setEnabled(false);
                           DashGUI.addFrame.setVisible(false);
                           LoginG.frameLogin.setVisible(false);
                        }
    			
                        
    }
    else
    {
    	JOptionPane.showMessageDialog(null,"Username & Password not valid");	
    	
    }
    
    
    
}


}
