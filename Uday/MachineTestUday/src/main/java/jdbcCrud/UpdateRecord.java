package jdbcCrud;

import java.sql.*;
import java.util.*;
public class UpdateRecord extends DeleteRecord {
	void updateConnection() {
		try {
			Class.forName(DataBaseConnectivity.driver);
			Connection con = DriverManager.getConnection(DataBaseConnectivity.connectionUrl,
					DataBaseConnectivity.username, DataBaseConnectivity.password);
			PreparedStatement smt = con.prepareStatement(
					"update employee set firstName=?,lastName=?,salary=?,email_id=? where id=?");

			try (Scanner s = new Scanner(System.in)) {
				System.out.println("Enter ID:");
				int uid=s.nextInt();
				
				System.out.println("Enter First Name:");
				String fname=s.next();
				System.out.println("Enter Last Name:");
				String lname=s.next();
				System.out.println("Enter Salary:");
				int sl=s.nextInt();
				System.out.println("Enter Email ID:");
				String em=s.next();
				
				smt.setString(1, fname);
				smt.setString(2, lname);
				smt.setInt(3, sl);
				smt.setString(4, em);
				smt.setInt(5, uid);


				smt.executeUpdate();
				System.out.println("Record for ID number:"+uid);
			}
			con.close();
		}

		catch (Exception e) {
			System.out.println(e);

		}
	}

	public static void main(String args[]) {
		UpdateRecord ur = new UpdateRecord();
		ur.updateConnection();
	}

}
