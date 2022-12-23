package jdbcCrud;

import java.sql.*;

public class RetrieveRecord extends InsertRecord {
	void retrieveConnection() {
			try {
				Class.forName(DataBaseConnectivity.driver);
				Connection con= DriverManager.getConnection(DataBaseConnectivity.connectionUrl,DataBaseConnectivity.username,DataBaseConnectivity.password);
				PreparedStatement smt=con.prepareStatement("select*from employee");
				
				ResultSet rs=smt.executeQuery();
				while(rs.next()) {
					System.out.println("id: "+rs.getInt(1)+"\nFirst Name: "+rs.getString(2)+"\nLast Name: "+rs.getString(3)+"\nSalary: "+rs.getInt(4)+"\nEmail ID: "+rs.getString(5));
					
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	}
	public static void main(String args[]) {
		RetrieveRecord rr=new RetrieveRecord();
		rr.retrieveConnection();
	}

}


