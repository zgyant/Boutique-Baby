package resources;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
public class LoginG implements ActionListener{
static JFrame frameLogin=new JFrame("Login");
JButton loginButt=new JButton("LOGIN");
JButton exitButt=new JButton("EXIT");
static JTextField userArea=new JTextField(25);
JLabel titleLabel=new JLabel("LOGIN");
JPanel titlePanel=new JPanel();
JPanel fieldPanel=new JPanel();
JPanel buttPanel=new JPanel();
static JPasswordField userPass=new JPasswordField(25);
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
double width = screenSize.getWidth();
double height = screenSize.getHeight();


	public LoginG( )
	{
		frameLogin.setLayout(new GridLayout(3,1));
		frameLogin.setDefaultCloseOperation(frameLogin.EXIT_ON_CLOSE);
		frameLogin.setResizable(false);
		frameLogin.setLocation(((int)width-150)/2, ((int)height-300)/2);
		frameLogin.setUndecorated(true);
		frameLogin.setOpacity(0.97f);
		frameLogin.setSize(new Dimension(300, 320));
		
		titlePanel.add(titleLabel);
		
		titleLabel.setFont(new Font("SansSerif", Font.PLAIN, 54));
		titleLabel.setForeground(Color.darkGray);
		
		fieldPanel.add(new JLabel("Enter username"));
		fieldPanel.add(userArea);
		fieldPanel.add(new JLabel("Enter password"));
		fieldPanel.add(userPass);
		
		buttPanel.add(loginButt);
		buttPanel.add(exitButt);	
		
		frameLogin.add(titlePanel);
		frameLogin.add(fieldPanel);
		frameLogin.add(buttPanel);		
		frameLogin.setVisible(true);
		
		exitButt.addActionListener(this);
		loginButt.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exitButt)
		{
			ButtonActions.exit();
		}
		if(e.getSource()==loginButt)
		{
				try {
					ButtonActions.login();
				} catch (SQLException e1) {
		    	 	JOptionPane.showMessageDialog(null,e1);

				}
			
		}
	}
}

