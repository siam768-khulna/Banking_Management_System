package bank.management.system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




public class PinChange extends JFrame implements ActionListener {
	
	JPasswordField  pin, repin;
	JButton change, back;
	String pinnumber;
	
	PinChange(String  pinnumber) {
		
		this.pinnumber = pinnumber;
		setLayout(null);
		
		setSize(700, 650);
		setLocation(300, 0);
		setVisible(true);
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setForeground(Color.BLACK);
		text.setFont(new Font("System",  Font.BOLD, 16));
		text.setBounds(200, 200, 200, 35);
		add(text);
		
		JLabel pintext = new JLabel("NEW PIN:");
		pintext.setForeground(Color.BLACK);
		pintext.setFont(new Font("System",  Font.BOLD, 16));
		pintext.setBounds(150, 250, 200, 35);
		add(pintext);
		
		pin = new JPasswordField();
		pin.setFont(new Font("Raleway", Font.BOLD, 25));
		pin.setBounds(300, 250, 130, 25);
		add(pin);
		
		JLabel repintext = new JLabel("Re-Enter New PIN:");
		repintext.setForeground(Color.BLACK);
		repintext.setFont(new Font("System",  Font.BOLD, 16));
		repintext.setBounds(150, 280, 200, 35);
		add(repintext);
		
		repin = new JPasswordField();
		repin.setFont(new Font("Raleway", Font.BOLD, 25));
		repin.setBounds(300, 280, 130, 25);
		add(repin);
		
		 change = new JButton("CHANGE");
		change.setBounds(330, 320, 100, 25);
		change.addActionListener(this);
		add(change);
		
		 back = new JButton("BACK");
		back.setBounds(150, 320, 100, 25);
		back.addActionListener(this);
		add(back);
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == change) {
			
		
		
			try {
				String npin = pin.getText();
				String rpin = repin.getText();
			
					if (!npin.equals(rpin)) {
						JOptionPane.showMessageDialog(null, "Entered PIN does not match");
						return;
					}
					if (npin.equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter new PIN");
						return;
					}
					
					if  (rpin.equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter new PIN");
						return;
					}
					
					Conn conn = new Conn();
					String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
					String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
					String query3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
					
					conn.s.execute(query1);
					conn.s.execute(query2);
					conn.s.execute(query3);
					
					JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
					
					setVisible(false);
					new Transactions(rpin).setVisible(true);
					
					
				} catch (Exception  e) {
					System.out.println(e);
				}
			} else {
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
			}
	}
	
	public static void main(String[] args) {
		new  PinChange("").setVisible(true);
	}
}
