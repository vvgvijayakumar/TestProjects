package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*1) Create a connection
 * 2) create statement/query
 * 3) Execute query then store the results
 * 4) Print the results
 * 
 */

public class RetrieveDataFromDB_JDBC {

	public static void main(String[] args) throws SQLException {

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:{port}/{database_name}", "{username}",
				"{password}");

		Statement stmt = conn.createStatement();

		String s = "select * from {table_name}";

		// This will just give 1(first) record by using limit keyword
		// String s = "select * from {table_name} limit 1";

		ResultSet rs = stmt.executeQuery(s);

		// We are not sure of the number of records returned
		while (rs.next()) {

			// String type(varchar) column tyoe
			String name1 = rs.getString("{column_Name}");

			// int type column type
			int name2 = rs.getInt("{column_Name}");

			System.out.println(name1 + " " + name2);
		}

		// Closing Connection Object
		conn.close();

	}

}
