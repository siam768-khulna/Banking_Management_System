package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class Withdrawl extends  JFrame implements ActionListener {
	
	JTextField amount;
	JButton withdraw, back;
	String pinnumber;
	
	Withdrawl(String pinnumber) {
		
		this.pinnumber = pinnumber;
		
		setLayout(null);
		
		JLabel text = new JLabel("Enter the amount you want to Withdraw:");
		text.setFont(new Font ("System", Font.BOLD, 22));
		text.setBounds(100, 100, 450, 30);
		add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 20));
		amount.setBounds(530, 100, 150, 30);
		add(amount);
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(550, 300, 100, 30);
		withdraw.addActionListener(this);
		add(withdraw);
		
		back = new JButton("Back");
		back.setBounds(110, 300, 100, 30);
		back.addActionListener(this);
		add(back);
		
		setSize(800, 600);
		setLocation(300, 0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()  == withdraw) {
			String  number = amount.getText();
			Date date = new Date();
			if (number.equals("") ) {
				JOptionPane.showMessageDialog(null, "Please  enter the amount you want to withdraw");
			} else {
				try {
				Conn conn = new Conn();
				String query = "insert into bank values ('"+pinnumber+"','"+date+"', 'Withdrawl', '"+number+"')"; 
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null,  "BDT " +number+" Withdraw Successfully");
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
		new Withdrawl("");
	}

}
