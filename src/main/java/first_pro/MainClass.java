package first_pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainClass {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		// Step 1 : Load the mysql jdbc driver

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = null;

		// Step 2 : Getting Connection Object
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/petpals", "root", "Rishitha@14");

		Statement stmt = null;
		// Step 3: Getting statement object
		stmt = con.createStatement();
		
		//String updateQuery = "UPDATE pets SET breed = 'house' WHERE petid = '102'";
		//String deleteQuery = "Delete from pets where petid = 110";
		//String insertQuery = "insert into pets values (110,'Rittu',1,'Field','Mouse',1)";
        //stmt.executeUpdate(insertQuery);
        //stmt.executeUpdate(updateQuery);
        //stmt.executeUpdate(deleteQuery);

		// Step 4 : Executing the query
		String query = "select * from pets where petage <= 2";
		ResultSet rs = null;

		rs = stmt.executeQuery(query);

		while (rs.next()) {
			System.out.println("ID       : " + rs.getString("petid"));
			System.out.println("Name     : " + rs.getString("petname"));
			System.out.println("AGE      : " + rs.getString("petage"));
			System.out.println("BREED    : " + rs.getString("breed"));
			System.out.println("______________________________________");
		}

		rs.close();
		stmt.close();
		con.close();
	}
}