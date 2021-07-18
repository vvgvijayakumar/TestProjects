package jdbcConnection;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*1) Create a connection
 * 2) create statement/query
 * 3) Execute query then store the results
 * 4) Print the results
 * 
 */

//Multiple Objects to Multiple Json Files
public class ConvertDBResults_JavaObjects_JsonFiles {

	public static void main(String[] args)
			throws SQLException, JsonGenerationException, JsonMappingException, IOException {

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:{port}/{database_name}", "{username}",
				"{password}");

		Statement stmt = conn.createStatement();

		// This will just give 1(first) record by using limit keyword
		String s = "select * from {table_name}";

		ResultSet rs = stmt.executeQuery(s);

		ArrayList<CustomerDetails> ar = new ArrayList<CustomerDetails>();

		// We are not sure of the number of records returned
		while (rs.next()) {

			// String type(varchar) column tyoe
			String name1 = rs.getString("{column_Name}");

			// int type column type
			int name2 = rs.getInt("{column_Name}");

			// For every iteration new object will be created
			CustomerDetails cd = new CustomerDetails();

			cd.setBookName(name1);
			cd.setAmount(name2);
			cd.setLocation("");
			cd.setPurchaseDate("");

			ar.add(cd);
		}

		// Using Jackson API , convert java object into JSON File
		// Maven dependencies : Jackson core, Jackson Databind, Jackson annotations

		for (int i = 0; i < ar.size(); i++) {

			File jsonFile = new File(
					System.getProperty("user.dir") + "\\Personal_workspace\\jdbcConnection\\custInfo" + i + ".json");

			ObjectMapper om = new ObjectMapper();

			om.writeValue(jsonFile, ar.get(i));
		}

		// Closing Connection Object
		conn.close();

	}

}
