package employee.payroll;
import java.sql.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class database {

	
	Connection conn =null;
	public static Connection  java_database(){
		try{
			
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:F:\\Employee Payroll\\mydatabase.sqlite");
			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
		
	}
	
	
	
	
}
