package bank.management.system;

import java.awt.Color;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;



public class SignupTwo extends JFrame implements  ActionListener {
	
	JTextField nidTextField;  
	JButton next;
	JRadioButton yes, no;
	JComboBox religion, category, occupation, education, income;
	String formno;
	
	SignupTwo(String formno) {
		
		this.formno =   formno;
		setLayout(null);
		
		setTitle("NEW ACCOUNT APPLICATION FROM - PAGE 2");
		
		
		JLabel additionallDetails = new JLabel("Page 2: Additional Details ");
		additionallDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		additionallDetails.setBounds(300, 80, 400, 40);
		add(additionallDetails);
		
		JLabel name = new JLabel("Religion: ");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		String valReligion[] = {"Muslim", "Hindu","Christian","Others"};
		religion =  new JComboBox(valReligion);
		religion.setBounds(300, 140, 400, 30);
		religion.setBackground(Color.WHITE);
		add(religion);
		
		
		JLabel fname = new JLabel("Category: ");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(100, 180, 200, 30);
		add(fname);
		
		String valcategory[] = {"General", "MSA",  "Student", "Other"};
		category = new JComboBox(valcategory);
		category.setBounds(300, 180, 400, 30);
		category.setBackground(Color.WHITE);
		add(category);
		
		JLabel dob = new JLabel("Income: ");
		dob.setFont(new Font("Raleway", Font.BOLD, 20));
		dob.setBounds(100, 220, 200, 30);
		add(dob);
		
		String incomecategory[] = {"Null", "< 1,50,000",  "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
		income = new JComboBox(incomecategory);
		income .setBounds(300, 220, 400, 30);
		income .setBackground(Color.WHITE);
		add(income );
		
		JLabel gender = new JLabel("Educational");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 260, 200, 30);
		add(gender);
		
		
		JLabel email = new JLabel("Qualification: ");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 300, 200, 30);
		add(email);
		
		String educationValues[] = {"Non-Graduation", "Graduation",  "Post-Graduation", "Other"};
		education = new JComboBox(educationValues);
		education.setBounds(300, 300, 400, 30);
		education.setBackground(Color.WHITE);
		add(education);
		
		
		
		
		JLabel marital = new JLabel("Occupation: ");
		marital.setFont(new Font("Raleway", Font.BOLD, 20));
		marital.setBounds(100, 340, 200, 30);
		add(marital);
		
		String occupationValues[] = {"Bussinessman", "GOVT. employe",  "Teacher", "Police", "Student","Retired", "Other"};
		occupation = new JComboBox(occupationValues);
		occupation.setBounds(300, 340, 400, 30);
		occupation.setBackground(Color.WHITE);
		add(occupation);
		
		
		
		JLabel nid = new JLabel("NID NO: ");
		nid.setFont(new Font("Raleway", Font.BOLD, 20));
		nid.setBounds(100, 380, 100, 30);
		add(nid);
		
		nidTextField = new JTextField();
		nidTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		nidTextField.setBounds(300, 380, 400, 30);
		add(nidTextField);
		
		
		JLabel ext = new JLabel("Exisiting Account: ");
		ext.setFont(new Font("Raleway", Font.BOLD, 20));
		ext.setBounds(100, 420, 400, 30);
		add(ext);
		
		yes = new JRadioButton("Yes");
		yes.setBounds(300, 420, 60, 30);
		yes.setBackground(Color.WHITE);
		add(yes);
		
		no = new JRadioButton("No");
		no.setBounds(450, 420, 120, 30);
		no.setBackground(Color.WHITE);
		add(no);
		
		ButtonGroup extgroup = new ButtonGroup();
		extgroup.add(yes);
		extgroup.add(no);
		
		
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
		
		String sreligion = (String) religion.getSelectedItem();
		String scategory =  (String) category.getSelectedItem();
		String sincome = (String) income.getSelectedItem();
		String seducation = (String) education.getSelectedItem();  
		String soccupation = (String) occupation.getSelectedItem();  
		String ext = null;
		if (yes.isSelected()) {
			ext= "Yes";
		} else if (no.isSelected()) {
			ext = "No";
		}
		
		String nid = nidTextField.getText();
		
		
		try {
				Conn c = new Conn();
				String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+nid+"', '"+ext+"')";
				c.s.executeUpdate(query);
				
				//Signup3  Object
				setVisible(false);
				new SignupThree(formno).setVisible(true);
			}
			
		  catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignupTwo("");
		
	}

}
