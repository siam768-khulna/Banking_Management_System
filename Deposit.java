package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class Deposit extends  JFrame implements ActionListener {
	
	JTextField amount;
	JButton deposit, back;
	String pinnumber;
	
	Deposit(String pinnumber) {
		
		this.pinnumber = pinnumber;
		
		setLayout(null);
		
		JLabel text = new JLabel("Enter the amount you want to deposit:");
		text.setFont(new Font ("System", Font.BOLD, 22));
		text.setBounds(100, 100, 400, 30);
		add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 20));
		amount.setBounds(500, 100, 150, 30);
		add(amount);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(550, 300, 100, 30);
		deposit.addActionListener(this);
		add(deposit);
		
		back = new JButton("Back");
		back.setBounds(110, 300, 100, 30);
		back.addActionListener(this);
		add(back);
		
		setSize(800, 600);
		setLocation(300, 0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()  == deposit) {
			String  number = amount.getText();
			Date date = new Date();
			if (number.equals("") ) {
				JOptionPane.showMessageDialog(null, "Please  enter the amount you wantto deposit");
			} else {
				try {
				Conn conn = new Conn();
				String query = "insert into bank values ('"+pinnumber+"','"+date+"', 'Deposit', '"+number+"')"; 
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null,  "BDT " +number+" Deposited Successfully");
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
			}  catch (Exception e) {
				System.out.println(e);
				}
			}
			
			
		} else  if (ae.getSource() == back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new Deposit("");
	}

}
