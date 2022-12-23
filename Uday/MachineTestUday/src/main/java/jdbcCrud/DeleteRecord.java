package jdbcCrud;

import java.sql.*;
import java.util.*;
public class DeleteRecord extends RetrieveRecord {
	void deleteConnection(){
		try {
			Class.forName(DataBaseConnectivity.driver);
			Connection con= DriverManager.getConnection(DataBaseConnectivity.connectionUrl,DataBaseConnectivity.username,DataBaseConnectivity.password);
			PreparedStatement smt=con.prepareStatement("delete from employee where id=?");
			try (Scanner s = new Scanner(System.in)) {
				System.out.println("Enter ID:");
				int iid=s.nextInt();
				smt.setInt(1, iid);
				
				
				smt.executeUpdate();
				System.out.println("ID: "+iid+" Deleted Successfully.");
			}
			con.close();
		} 
		
		catch (Exception e) {
			System.out.println(e);
			
		}
	}
	public static void main(String args[]) {
		DeleteRecord dr=new DeleteRecord();
		dr.deleteConnection();
		
	}
}
