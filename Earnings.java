package employee.payroll;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;




import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JButton;

public class Earnings extends JFrame {
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;


	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Employee Id");
	private JTextField txt_dob;
	private JTextField txt_name;
	private JTextField txt_search;
	private JTextField txt_basic;
	private JTextField txt_dep;
	private JTable table_Earnings;
	private JTextField txt_payband;
	private JTextField txt_agp_gp;
	private JTextField txt_ta;
	private JTextField txt_arrear;
	private JTextField txt_otherallowance;
	private JTextField txt_totalpay;
	private JLabel label_emp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Earnings frame = new Earnings();
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
	public Earnings() {
		
		conn=database.java_database();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, 
        size.height/2 - getHeight()/2);
        Update_table();
        label_emp.setText(String.valueOf(Emp.emp).toString());



		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setBounds(12, 13, 92, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(12, 81, 44, 16);
		contentPane.add(lblName);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setBounds(12, 104, 76, 16);
		contentPane.add(lblDateOfBirth);
		
		txt_dob = new JTextField();
		txt_dob.setBounds(94, 104, 116, 22);
		contentPane.add(txt_dob);
		txt_dob.setColumns(10);
		
		txt_name = new JTextField();
		txt_name.setBounds(94, 75, 116, 22);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		txt_search = new JTextField();
		txt_search.setBounds(94, 13, 217, 22);
		contentPane.add(txt_search);
		txt_search.setColumns(10);
		
		JLabel lblBasicPay = new JLabel("Basic Salary:");
		lblBasicPay.setBounds(12, 133, 76, 16);
		contentPane.add(lblBasicPay);
		
		txt_basic = new JTextField();
		txt_basic.setBounds(94, 130, 116, 22);
		contentPane.add(txt_basic);
		txt_basic.setColumns(10);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(12, 162, 76, 16);
		contentPane.add(lblDepartment);
		
		txt_dep = new JTextField();
		txt_dep.setBounds(94, 159, 116, 22);
		contentPane.add(txt_dep);
		txt_dep.setColumns(10);
		
		table_Earnings = new JTable();
		table_Earnings.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"", "New column", "New column", "New column"
			}
		));
		table_Earnings.setBounds(43, 226, 217, 85);
		contentPane.add(table_Earnings);
		
		JLabel lblPaybandPay = new JLabel("Payband pay:");
		lblPaybandPay.setBounds(288, 81, 92, 16);
		contentPane.add(lblPaybandPay);
		
		txt_payband = new JTextField();
		txt_payband.setBounds(377, 78, 116, 22);
		contentPane.add(txt_payband);
		txt_payband.setColumns(10);
		
		JLabel lblAgpgp = new JLabel("AGP/GP:");
		lblAgpgp.setBounds(288, 107, 56, 16);
		contentPane.add(lblAgpgp);
		
		txt_agp_gp = new JTextField();
		txt_agp_gp.setBounds(377, 107, 116, 22);
		contentPane.add(txt_agp_gp);
		txt_agp_gp.setColumns(10);
		
		JLabel lblTa = new JLabel("TA:");
		lblTa.setBounds(288, 136, 56, 16);
		contentPane.add(lblTa);
		
		txt_ta = new JTextField();
		txt_ta.setBounds(377, 133, 116, 22);
		contentPane.add(txt_ta);
		txt_ta.setColumns(10);
		
		JLabel lblArrearOfDa = new JLabel("Arrear of DA:");
		lblArrearOfDa.setBounds(288, 165, 92, 16);
		contentPane.add(lblArrearOfDa);
		
		txt_arrear = new JTextField();
		txt_arrear.setBounds(377, 162, 116, 22);
		contentPane.add(txt_arrear);
		txt_arrear.setColumns(10);
		
		JLabel lblOtherAllowance = new JLabel("Other Allowance:");
		lblOtherAllowance.setBounds(281, 194, 99, 16);
		contentPane.add(lblOtherAllowance);
		
		txt_otherallowance = new JTextField();
		txt_otherallowance.setBounds(377, 194, 116, 22);
		contentPane.add(txt_otherallowance);
		txt_otherallowance.setColumns(10);
		
		JLabel lblTotalPay = new JLabel("Total Earnings:\r\n\r\n");
		lblTotalPay.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalPay.setBounds(534, 133, 105, 16);
		contentPane.add(lblTotalPay);
		
		txt_totalpay = new JTextField();
		txt_totalpay.setText("0.00\r\n");
		txt_totalpay.setBounds(633, 133, 67, 22);
		contentPane.add(txt_totalpay);
		txt_totalpay.setColumns(10);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(534, 190, 97, 25);
		contentPane.add(btnCalculate);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(534, 239, 97, 25);
		contentPane.add(btnSave);
		
		JLabel lblLoggedInAs = new JLabel("logged in as:");
		lblLoggedInAs.setBounds(22, 324, 105, 16);
		contentPane.add(lblLoggedInAs);
		
		label_emp = new JLabel("emp");
		label_emp.setBounds(109, 324, 56, 16);
		contentPane.add(label_emp);
	}
	
	private void Update_table() {
	    try{
	        String sql ="select * from allowance";
	        pst=conn.prepareStatement(sql);
	        rs=pst.executeQuery();
	        table_Earnings.setModel(DbUtils.resultSetToTableModel(rs));
	    }
	    catch(Exception e){
	    JOptionPane.showMessageDialog(null, e);
	    }
	    finally {
	            
	            try{
	                rs.close();
	                pst.close();
	                
	            }
	            catch(Exception e){
	                
	            }
	        }
	    }
	    


	
}
