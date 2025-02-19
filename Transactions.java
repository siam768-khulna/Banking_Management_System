package bank.management.system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import  java.awt.event.*;


public class Transactions extends JFrame implements ActionListener { 
	
	JButton deposit, withdrawl, balance, transfer, pinchange, ministatement, exit;
	String pinnumber;
	
	Transactions(String pinnumber) {
		
		this.pinnumber = pinnumber;
		
		setLayout(null);
		
		JLabel text =  new JLabel("Please select  your Transection");
		text.setFont(new Font("Raleway", Font.BOLD, 30));
		text.setBounds(120, 100, 600, 35);
		add(text);
		
		deposit = new  JButton("Deposit");
		deposit.setBounds(140, 160, 150, 30);
		deposit.addActionListener(this);
		add(deposit);
		
		withdrawl = new  JButton("Cash Withdrawl");
		withdrawl.setBounds(380, 160, 150, 30);
		withdrawl.addActionListener(this);
		add(withdrawl);
		
		balance = new  JButton("Balance");
		balance.setBounds(140, 220, 150, 30);
		balance.addActionListener(this);
		add(balance);
		
		transfer = new  JButton("Mini Statement");
		transfer.setBounds(380, 220, 150, 30);
		transfer.addActionListener(this);
		add(transfer);
		
		pinchange = new  JButton("Pin Change");
		pinchange.setBounds(140, 280, 150, 30);
		pinchange.addActionListener(this);
		add(pinchange);
		
		ministatement = new  JButton("Help Line");
		ministatement.setBounds(380, 280, 150, 30);
		ministatement.addActionListener(this);
		add(ministatement);
		
		exit = new  JButton("Exit");
		exit.setBounds(250, 340, 140, 30);
		exit.addActionListener(this);
		exit.setBackground(Color.RED);
		exit.setForeground(Color.WHITE);
		add(exit);
		
		
		setSize(650, 650);
		setLocation(300, 0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if  (ae.getSource() == exit) {
			System.exit(0);
		} else if (ae.getSource() == deposit) {
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		} else if (ae.getSource() ==  withdrawl) {
			setVisible(false);
			new Withdrawl(pinnumber).setVisible(true);	
		} else if (ae.getSource() == pinchange) {
			setVisible(false);
			new PinChange(pinnumber).setVisible(true);
		} else  if (ae.getSource() == balance) {
			setVisible(false);
			new Balance(pinnumber).setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new Transactions("");
	}
}
