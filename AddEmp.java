package employee.payroll;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;
import javax.swing.*;


public class AddEmp extends JFrame {

	Connection conn = null;
	ResultSet rs  = null;
	PreparedStatement pst = null;
	
	
	
	private JPanel contentPane;
	private JTextField txt_empid;
	private JTextField txt_name;
	private JTextField txt_dob;
	private JTextField txt_emailid;
	private JTextField txt_contact;
	private JTextField txt_address;
	private JTextField txt_department;
	private JTextField txt_designation;
	private JLabel lblBankAc;
	private JTextField txt_bank;
	private JButton btnNewButton;
	private JLabel lblSalary;
	private JLabel lblGender;
	private JTextField txt_salary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmp frame = new AddEmp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddEmp() {
		
		conn = database.java_database();
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee ID");
		lblNewLabel.setBounds(51, 59, 81, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(51, 93, 56, 16);
		contentPane.add(lblName);
		
		JLabel lblDob = new JLabel("D.O.B");
		lblDob.setBounds(51, 141, 56, 16);
		contentPane.add(lblDob);
		
		JLabel lblEmailId = new JLabel("Email ID");
		lblEmailId.setBounds(51, 169, 56, 16);
		contentPane.add(lblEmailId);
		
		JLabel lblNewLadesignation = new JLabel("Designation");
		lblNewLadesignation.setBounds(51, 329, 81, 16);
		contentPane.add(lblNewLadesignation);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(51, 301, 81, 16);
		contentPane.add(lblDepartment);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(51, 253, 56, 16);
		contentPane.add(lblAddress);
		
		JLabel lblContactNo = new JLabel("Contact No.");
		lblContactNo.setBounds(51, 219, 81, 16);
		contentPane.add(lblContactNo);
		
		txt_empid = new JTextField();
		txt_empid.setBounds(144, 56, 116, 22);
		contentPane.add(txt_empid);
		txt_empid.setColumns(10);
		
		txt_name = new JTextField();
		txt_name.setBounds(144, 90, 116, 22);
		txt_name.setColumns(10);
		contentPane.add(txt_name);
		
		txt_dob = new JTextField();
		txt_dob.setBounds(144, 125, 116, 22);
		txt_dob.setColumns(10);
		contentPane.add(txt_dob);
		
		txt_emailid = new JTextField();
		txt_emailid.setBounds(144, 160, 116, 22);
		txt_emailid.setColumns(10);
		contentPane.add(txt_emailid);
		
		txt_contact = new JTextField();
		txt_contact.setBounds(144, 216, 116, 22);
		txt_contact.setColumns(10);
		contentPane.add(txt_contact);
		
		txt_address = new JTextField();
		txt_address.setBounds(144, 274, 116, 22);
		txt_address.setColumns(10);
		contentPane.add(txt_address);
		
		txt_department = new JTextField();
		txt_department.setBounds(144, 301, 116, 22);
		txt_department.setColumns(10);
		contentPane.add(txt_department);
		
		txt_designation = new JTextField();
		txt_designation.setBounds(144, 326, 116, 22);
		txt_designation.setColumns(10);
		contentPane.add(txt_designation);
		
		lblBankAc = new JLabel("Bank A/C");
		lblBankAc.setBounds(51, 366, 81, 16);
		contentPane.add(lblBankAc);
		
		txt_bank = new JTextField();
		txt_bank.setBounds(144, 363, 116, 22);
		txt_bank.setColumns(10);
		contentPane.add(txt_bank);
		
		btnNewButton = new JButton("Add Record");
		btnNewButton.setBounds(578, 517, 153, 61);
		btnNewButton.addActionListener(new ActionListener() {
			private JTextComponent txt_gender;

			public void actionPerformed(ActionEvent arg0) {
			
				
				Connection conn=null;
				ResultSet rs=null;
				PreparedStatement pst=null;

				conn =database.java_database();
				Toolkit toolkit = getToolkit();
				Dimension size = toolkit.getScreenSize();
				setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);


	try { 	
	String sql ="insert into Staff_information " + "(name,Dob,Emailid," + "contact,Address,Department," + "Designation,Gender," + "Salary) values (?,?,?,?,?,?,?,?,?)";
	pst=conn.prepareStatement(sql);
	pst.setString(1,txt_name.getText());
	pst.setString(2,txt_dob.getText());
	pst.setString(3,txt_emailid.getText());
	pst.setString(4,txt_contact.getText());
	pst.setString(5,txt_address.getText());
	pst.setString(6,txt_department.getText());
	pst.setString(7,txt_designation.getText());
	pst.setString(8,Gender);
	pst.setString(9,txt_salary.getText());
	pst.execute();
	
	JOptionPane.showMessageDialog(null,"Data is saved successfully");
	
} catch (Exception e) { 
	
	JOptionPane.showMessageDialog(null,e);
	
	} finally { 
		try{ rs.close(); pst.close();
		}
		catch(Exception e){ 
			JOptionPane.showMessageDialog(null,e);
			}
		}
			
			}
		});
		contentPane.add(btnNewButton);
		
		lblSalary = new JLabel("Salary");
		lblSalary.setBounds(51, 469, 81, 16);
		contentPane.add(lblSalary);
		
		lblGender = new JLabel("Gender");
		lblGender.setBounds(51, 412, 81, 16);
		contentPane.add(lblGender);
		
		txt_salary = new JTextField();
		txt_salary.setBounds(144, 466, 116, 22);
		txt_salary.setColumns(10);
		contentPane.add(txt_salary);
		
		JRadioButton r_male = new JRadioButton("Male");
		r_male.setBounds(144, 408, 64, 25);
		JRadioButton r_female = new JRadioButton("Female");
		r_female.setBounds(144, 432, 127, 25);
		
		r_male.addActionListener(new ActionListener() {
			


			public void actionPerformed(ActionEvent arg0) {
			
				Gender = "Male";
				r_male.setSelected(true);
				r_female.setSelected(false);
			}
		});
		contentPane.add(r_male);
		
		
		r_female.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
				Gender = "Female";
				r_male.setSelected(false);
				r_female.setSelected(true);
			
			}
		});
		contentPane.add(r_female);
	}
	private String Gender;
}
