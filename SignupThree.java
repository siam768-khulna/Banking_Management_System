package bank.management.system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;



public class SignupThree extends JFrame implements ActionListener {
	
	JRadioButton r1, r2, r3,   r4;
	JCheckBox c1,  c2, c3, c4, c5, c6, c7;
	JButton submit, cancel;
	String formno;
	
	SignupThree(String formno) {
		this.formno = formno;
		
		setLayout(null);
		
		JLabel l1 = new JLabel("Page 3: Account Details");
		l1.setFont(new Font("Raleway",   Font.BOLD, 22));
		l1.setBounds(240, 40,  400,   40);
		add(l1);
		
		
		JLabel type = new JLabel("Account Type");
		type.setFont(new Font("Raleway",   Font.BOLD, 22));
		type.setBounds(100, 120, 200,   40);
		add(type);
		
		r1 = new JRadioButton("Saving  Account");
		r1.setFont(new Font ("Raleway", Font.BOLD, 16));
		r1.setBackground(Color.WHITE);
		r1.setBounds(100, 170, 210, 20);
		add(r1);
		
		r2 = new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font ("Raleway", Font.BOLD, 16));
		r2.setBackground(Color.WHITE);
		r2.setBounds(350, 170, 210, 20);
		add(r2);
		
		r3 = new JRadioButton("Current  Account");
		r3.setFont(new Font ("Raleway", Font.BOLD, 16));
		r3.setBackground(Color.WHITE);
		r3.setBounds(100, 210,210, 20);
		add(r3);
		
		r4 = new JRadioButton("Recurring Deposit Account");
		r4.setFont(new Font ("Raleway", Font.BOLD, 16));
		r4.setBackground(Color.WHITE);
		r4.setBounds(350, 210, 240, 20);
		add(r4);
		
		ButtonGroup groupaccount = new ButtonGroup();
		groupaccount.add(r1);
		groupaccount.add(r2);
		groupaccount.add(r3);
		groupaccount.add(r4);
		
		JLabel card = new JLabel("Card Number");
		card.setFont(new Font("Raleway",   Font.BOLD, 22));
		card.setBounds(100, 290, 200,  40);
		add(card);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-5357");
		number.setFont(new Font("Raleway",   Font.BOLD, 22));
		number.setBounds(270, 290, 350,  40);
		add(number);
		
		JLabel carddetail = new JLabel("Your 16-digit pin number");
		carddetail.setFont(new Font("Raleway",   Font.BOLD, 12));
		carddetail.setBounds(100, 320, 350,  20);
		add(carddetail);
		
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway",   Font.BOLD, 22));
		pin.setBounds(100, 330, 200,  40);
		add(pin);
		
		
		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway",   Font.BOLD, 22));
		pnumber.setBounds(270, 330, 200,  20);
		add(pnumber);
		
		
		
		JLabel pindetail = new JLabel("Your 4 Digit Password");
		pindetail.setFont(new Font("Raleway",   Font.BOLD, 12));
		pindetail.setBounds(100, 370, 200,  20);
		add(pindetail);
		
		JLabel services = new JLabel("Services Required:");
		services.setFont(new Font("Raleway",   Font.BOLD, 22));
		services.setBounds(100, 420, 200,  40);
		add(services);
		
		c1 = new JCheckBox("ATM  CARD");
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font ("Raleway",  Font.BOLD, 16));
		c1.setBounds(100,  460,  200, 30);
		add(c1);
		
		c2 = new JCheckBox("Internet Banking");
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font ("Raleway",  Font.BOLD, 16));
		c2.setBounds(350,  460,  200, 30);
		add(c2);
		
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setBackground(Color.WHITE);
		c3.setFont(new Font ("Raleway",  Font.BOLD, 16));
		c3.setBounds(100,  500,  200, 30);
		add(c3);
		
		c4 = new JCheckBox("SMS Alert");
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font ("Raleway",  Font.BOLD, 16));
		c4.setBounds(350,  500,  200, 30);
		add(c4);
		
		c5 = new JCheckBox("Cheque Book");
		c5.setBackground(Color.WHITE);
		c5.setFont(new Font ("Raleway",  Font.BOLD, 16));
		c5.setBounds(100,  540,  200, 30);
		add(c5);
		
		c6 = new JCheckBox("E-Staitment");
		c6.setBackground(Color.WHITE);
		c6.setFont(new Font ("Raleway",  Font.BOLD, 16));
		c6.setBounds(350,  540,  200, 30);
		add(c6);

		submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font ("Raleway", Font.BOLD, 15));
		submit.setBounds(200, 600, 100, 30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font ("Raleway", Font.BOLD, 15));
		cancel.setBounds(450, 600, 100, 30);
		cancel.addActionListener(this);
		add(cancel);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850, 820);
		setLocation(350,0);
		setVisible(true);
		 
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == submit) {
			String atype = null;
	        if(r1.isSelected()){ 
	            atype = "Saving Account";
	        }
	        else if(r2.isSelected()){ 
	            atype = "Fixed Deposit Account";
	        }
	        else if(r3.isSelected()){ 
	            atype = "Current Account";
	        }else if(r4.isSelected()){ 
	            atype = "Recurring Deposit Account";
	        }
	        
	        Random   random = new Random();
	        String cardnumber =  ""+ Math.abs((random.nextLong() % 90000000L)+ 4353576900000000L);
	        
	        String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
	        
	        String facility = "";
	        if(c1.isSelected()){ 
	            facility = facility + " ATM Card";
	        }
	        if(c2.isSelected()){ 
	            facility = facility + " Internet Banking";
	        }
	        if(c3.isSelected()){ 
	            facility = facility + " Mobile Banking";
	        }
	        if(c4.isSelected()){ 
	            facility = facility + " SMS Alerts";
	        }
	        if(c5.isSelected()){ 
	            facility = facility + " Cheque Book";
	        }
	        if(c6.isSelected()){ 
	            facility = facility + " E-Statement";
	        }
	        
	        try {
	        	if (atype.equals("")) {
	        		JOptionPane.showMessageDialog(null, "Account Type is Required");
	   	        	} else {
	   	        		Conn conn = new Conn();
	   	        		
	   	        		String query1 = "insert into signupthree values('"+formno+"', '"+atype+"', '"+cardnumber+"', '"+pinnumber+"',  '"+facility+"')";
	   	        		String query2 = "insert into login values('"+formno+"',  '"+cardnumber+"', '"+pinnumber+"')";
	   	        		conn.s.executeUpdate(query1);
	   	        		conn.s.executeUpdate(query2);
	   	        		
	   	        		JOptionPane.showMessageDialog(null, "Card Number: "+ cardnumber + "\n Pin: "+ pinnumber) ;
	   	        		
	   	        		setVisible(false);
	   	        		new Deposit(pinnumber).setVisible(false);
	   	        		
	   	        	}
	        	
	        } catch (Exception e) {
	        	System.out.println(e);
	        }
	        

		} else if (ae.getSource() == cancel) {
			setVisible(false);
			new Login().setVisible(false);
			
		}
	}
	public static void main(String[] args) {
		new SignupThree("");
	}
}
