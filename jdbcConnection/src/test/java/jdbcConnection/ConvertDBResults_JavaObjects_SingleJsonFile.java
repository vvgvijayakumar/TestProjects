package jdbcConnection;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

/*1) Create a connection
 * 2) create statement/query
 * 3) Execute query then store the results
 * 4) Print the results
 * 
 */

//Multiple Objects to Single Json File
public class ConvertDBResults_JavaObjects_SingleJsonFile {

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
		// For JsonArray and Json Object we need to add : GSON and Json Simple

		// Creating JSONArray Object
		JSONArray jarray = new JSONArray();

		// Creating JSON Object
		JSONObject jobject = new JSONObject();

		for (int i = 0; i < ar.size(); i++) {

			// converting java object into jsonstring

			Gson g = new Gson();
			String jsonString = g.toJson(ar.get(i));

			jarray.add(jsonString);// Add json string to json array

		}

		jobject.put("data", jarray);

		jobject.toJSONString();// Convverts into complete json format

		String jsonformatted = jobject.toJSONString().replace("\\\"", "\"");// removed escape characters

		String finaljson = jsonformatted.replace("\"{", "{").replace("}\"", "}");// Final Json formatted string

		// Closing Connection Object
		conn.close();

	}

}
