package employee.payroll;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.lang.*;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;

/**
 *
 * @author McLican
 */
public class Login extends JFrame {
	
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pst=null;
	

	private JPanel contentPane;
	private JTextField txt_Username;
	private JComboBox txt_combo;
	private JButton btn_Login;
	private JPasswordField txt_Password;
	private JPanel panel;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		getComponents();
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
		
		
		conn=database.java_database();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("IIIT-NR PAY-SLIP\r\n");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(35, 13, 159, 45);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username\r\n");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(35, 78, 71, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(35, 134, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		txt_Username = new JTextField();
		txt_Username.setBounds(35, 99, 159, 22);
		contentPane.add(txt_Username);
		txt_Username.setColumns(10);
		
		JLabel lblDivison = new JLabel("division");
		lblDivison.setForeground(Color.WHITE);
		lblDivison.setBounds(35, 188, 56, 16);
		contentPane.add(lblDivison);
		
		
		
		txt_combo = new JComboBox();
		txt_combo.setModel(new DefaultComboBoxModel(new String[] { "Admin", "Staff"}));
		txt_combo.setBounds(35, 211, 159, 22);
		contentPane.add(txt_combo);
		
		
		btn_Login = new JButton("Login");
		btn_Login.setBounds(35, 246, 97, 25);
		
		
		
		btn_Login.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				String sql="Select id,Username,Password,division from Users where (Username= ? and Password= ? and division = ? )";
				try{
					
					int count=0;
					pst=conn.prepareStatement(sql);
					pst.setString(1,txt_Username.getText());
					pst.setString(2, txt_Password.getText());
					pst.setString(3, txt_combo.getSelectedItem().toString());
					
					
					rs=pst.executeQuery();
					while(rs.next()){
						//int id = rs.getInt(1);
						//Emp.empID = id;
						String username = rs.getString("username");
						Emp.empname = username;
						count=count+1;
					}
					String access=txt_combo.getSelectedItem().toString();
					
					if(access == "Admin"){
						if(count==1){
							JOptionPane.showMessageDialog(null,"Success");
							MainMenu j=new MainMenu();
							j.setVisible(true);
						
							setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}else{
						JOptionPane.showMessageDialog(null,"Username or Password incorrect!");
					}
					}
			
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
					
				}
				
				finally{
					
					try{
						rs.close();
						pst.close();
						
					}catch(Exception e){
				
					}
				}
				
			
				
			}
		});
		contentPane.add(btn_Login);
		
		txt_Password = new JPasswordField();
		txt_Password.setBounds(35, 153, 159, 22);
		contentPane.add(txt_Password);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 716, 433);
		contentPane.add(panel);
		
		lblNewLabel_3 = new JLabel("\r\n");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/employee/payroll/images/xz.JPG")));
		panel.add(lblNewLabel_3);
		
		
		
		
	}
}
