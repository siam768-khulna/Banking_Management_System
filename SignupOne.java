package bank.management.system;

import java.awt.Color;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;



public class SignupOne extends JFrame implements  ActionListener {
	
	long random;
	JTextField nameTextField, fnameTextField, dobTextField, emailTextField, addressTextField, cityTextField, postTextField;  
	JButton next;
	JRadioButton male, fmale, married, unmarried;
	
	SignupOne() {
		
		setLayout(null);
		
		Random ran = new Random();
		random =Math.abs((ran.nextLong() % 9000L) + 1000L);
		
		JLabel formno = new JLabel("APPLICATION FORM NO. " + random );
		formno.setFont(new Font("Raleway", Font.BOLD, 38));
		formno.setBounds(140, 20, 600, 40);
		add(formno);
		
		JLabel personalDetails = new JLabel("Page 1: Personal Details ");
		personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		personalDetails.setBounds(300, 80, 400, 40);
		add(personalDetails);
		
		JLabel name = new JLabel("Name: ");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		nameTextField.setBounds(300, 140, 400, 30);
		add(nameTextField);
		
		JLabel fname = new JLabel("Fathers's Name: ");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(100, 180, 200, 30);
		add(fname);
		
		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		fnameTextField.setBounds(300, 180, 400, 30);
		add(fnameTextField);
		
		JLabel dob = new JLabel("Date of Birth: ");
		dob.setFont(new Font("Raleway", Font.BOLD, 20));
		dob.setBounds(100, 220, 200, 30);
		add(dob);
		
		dobTextField = new JTextField();
		dobTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		dobTextField.setBounds(300, 220, 400, 30);
		add(dobTextField);
		
		JLabel gender = new JLabel("Gender: ");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 260, 100, 30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300, 260, 60, 30);
		male.setBackground(Color.WHITE);
		add(male);
		
		fmale = new JRadioButton("Female");
		fmale.setBounds(450, 260, 120, 30);
		fmale.setBackground(Color.WHITE);
		add(fmale);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(fmale);
		
		JLabel email = new JLabel("Email Address: ");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 300, 200, 30);
		add(email);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		emailTextField.setBounds(300, 300, 400, 30);
		add(emailTextField);
		
		
		JLabel marital = new JLabel("Marital Status: ");
		marital.setFont(new Font("Raleway", Font.BOLD, 20));
		marital.setBounds(100, 340, 200, 30);
		add(marital);
		
		married = new JRadioButton("Married");
		married.setBounds(300, 340, 100, 30);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450, 340, 120, 30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(married);
		maritalgroup.add(unmarried);
		
		JLabel address = new JLabel("Adress: ");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 380, 100, 30);
		add(address);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		addressTextField.setBounds(300, 380, 400, 30);
		add(addressTextField);
		
		
		JLabel city = new JLabel("City: ");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 420, 100, 30);
		add(city);
		
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		cityTextField.setBounds(300, 420, 400, 30);
		add(cityTextField);
		
		
		
		JLabel post = new JLabel("Post Code: ");
		post.setFont(new Font("Raleway", Font.BOLD, 20));
		post.setBounds(100, 460, 150, 30);
		add(post);
		
		postTextField = new JTextField();
		postTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		postTextField.setBounds(300, 460, 400, 30);
		add(postTextField);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setBounds(620, 520, 80, 30);
		next.addActionListener(this);
		add(next);
		
		
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850, 800);
		setLocation(350, 20);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		String formno  = "" + random;  //lomg
		String name = nameTextField.getText();
		String fname =  fnameTextField.getText();
		String dob = dobTextField.getText();
		String gender = null;
		if (male.isSelected()) {
			gender = "Male";
		} else if (fmale.isSelected()) {
			gender = "Female";
		}
		String email = emailTextField.getText();
		String  marital =null;
		if (married.isSelected()) {
			marital = "Married";
		}	else  if  (unmarried.isSelected()) {
			marital = "Unmarried";
		}
		String address = addressTextField.getText();
		String city =  cityTextField.getText();
		String post = postTextField.getText();
		
		try {
			if (name.equals("")) {
				JOptionPane.showConfirmDialog(null, "Name is requied.");	// this is use for all fields like fname address etc.
				// I am use only for Name this is find lec-04 25.00min
			} else {
				Conn c = new Conn();
				String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"',  '"+city+"', '"+post+"')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new SignupTwo(formno).setVisible(true);
			}
			
		}  catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignupOne();
		
	}

}
