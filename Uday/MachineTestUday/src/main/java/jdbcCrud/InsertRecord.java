package jdbcCrud;

import java.sql.*;
import java.util.*;

public class InsertRecord extends DataBaseConnectivity{
	void insertConnection(){
		try {
			
			Class.forName(DataBaseConnectivity.driver);
			Connection con= DriverManager.getConnection(DataBaseConnectivity.connectionUrl,DataBaseConnectivity.username,DataBaseConnectivity.password);
			PreparedStatement smt=con.prepareStatement("insert into employee(id,firstName,lastName,salary,email_id) values(?,?,?,?,?)");
			try (Scanner s = new Scanner(System.in)) {
				System.out.println("Enter ID:");
				int id=s.nextInt();
				System.out.println("Enter First Name:");
				String first=s.next();
				System.out.println("Enter Last Name:");
				String last=s.next();
				System.out.println("Enter Salary:");
				int salary=s.nextInt();
				System.out.println("Eneter Email ID:");
				String email=s.next();
				
				smt.setInt(1, id);
				smt.setString(2, first);
				smt.setString(3, last);
				smt.setInt(4,salary);
				smt.setString(5, email);
			}
			int i=smt.executeUpdate();
			System.out.println(i+"records inserted");
			con.close();
		} 
		
		catch (Exception e) {
			System.out.println(e);
			
		}
	}
	public static void main(String args[]) {
		InsertRecord ir=new InsertRecord();
		ir.insertConnection();
	}




		
	
	
	
}
