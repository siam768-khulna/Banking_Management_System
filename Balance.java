package bank.management.system;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class Balance extends JFrame implements ActionListener {
	
	JButton back;
	String pinnumber;
	
	Balance(String pinnumber) {
		
		this.pinnumber = pinnumber;
		
		setLayout(null);
		
		back =  new JButton("Back");
		back.setBounds(100, 300, 150, 30);
		back.addActionListener(this);
		add(back);
		
		Conn c = new Conn();
		int balance = 0;
		try  {
			ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
			while(rs.next()) {
				if (rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				} else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			
		}
		
		JLabel text = new JLabel("Your Current Account balance is BDT "+ balance);
		text.setForeground(Color.BLACK);
		text.setBounds(100, 100, 400, 30);
		add(text);
		
		
		setSize(650, 600);
		setLocation(300, 0);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transactions(pinnumber).setVisible(true);
	}
	public static void main(String[] args) {
		new Balance("");
	}
}
