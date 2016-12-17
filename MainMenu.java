package employee.payroll;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	private JLabel lbl_emp;
	private JLabel lbl_emp_1;
	private JLabel label_emp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("Logged In As :");
		label_1.setBounds(5, 232, 92, 16);
		contentPane.add(label_1);
		
		label_emp = new JLabel("emp");
		label_emp.setBounds(96, 232, 56, 16);
		contentPane.add(label_emp);
		label_emp.setText(String.valueOf(Emp.empname).toString());
		
		
		
		JButton btnLogOut = new JButton("Logout");
		btnLogOut.setIcon(new ImageIcon(MainMenu.class.getResource("/employee/payroll/images/logout.png")));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			Login x = new Login();
			x.setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			}
		});
		btnLogOut.setBounds(317, 208, 103, 40);
		contentPane.add(btnLogOut);
	}
}
