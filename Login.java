package bank.management.system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import  java.sql.*;

public class Login extends JFrame implements ActionListener{
	
	JButton login, signup, clear;
	JTextField cardTextField;
	JPasswordField pinTextField;
	
	
	Login() {
		
	
		setTitle("INERNET BANKING");
		setLayout(null);
		
		JLabel text = new JLabel("Welcome to Internet Banking");
		text.setFont(new Font("Osward", Font.BOLD, 38));
		text.setBounds(150, 20, 600, 50);
		add(text);
		
		JLabel cardno = new JLabel("Card NO:");
		cardno.setFont(new Font("Raleway", Font.BOLD, 28));
		cardno.setBounds(100, 100, 200, 40);
		add(cardno);
		
		cardTextField = new JTextField();
		cardTextField.setBounds(250, 105, 300, 40);
		cardTextField.setFont(new Font ("Arial", Font.BOLD, 20));
		add(cardTextField);
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway", Font.BOLD, 28));
		pin.setBounds(100, 160, 200, 40);
		
		add(pin);
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(250, 160, 300, 40);
		pinTextField.setFont(new Font ("Arial", Font.BOLD, 20));
		add(pinTextField);

		login = new JButton("SIGN IN");
		login.setBounds(250, 250, 100, 30);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setBounds(450, 250, 100, 30);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGN UP");
		signup.setBounds(335, 320, 130, 30);
		signup.setBackground(Color.BLUE);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		
		
		
		setSize(800, 500);
		setVisible(true);
		setLocation(350, 200);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		} else if (ae.getSource() == login) {
			Conn conn = new  Conn ();
			String cardnumber = cardTextField.getText();
			String pinnumber = pinTextField.getText();
			String query = "select * from login where cardnumber ='"+cardnumber+"' and pin =  '"+pinnumber+"'";
			
			try {
				ResultSet rs = conn.s.executeQuery(query);
				if (rs.next()) {
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}  else {
					JOptionPane.showMessageDialog(null, "Incorrect card Number  or  Pin");
				}
				
			}  catch (Exception e) {
				System.out.println(e);
			}
			
		} else if (ae.getSource() == signup) {
			setVisible(false);
			new SignupOne().setVisible(true);
		}
	}
	public static void main(String[] args) {
		new Login();
	}
}
