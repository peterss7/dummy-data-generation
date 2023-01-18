package com.peterss7.datageneration.address_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ZipGenerator {

	public static ArrayList<String[]> getZipsByStateAbv(String stateAbv) {

		ArrayList<String[]> zipData = new ArrayList<>();
		String connectionUrl = "jdbc:sqlserver://PC-ANNEXIA\\peter:1433;databaseName=DummyData;user=Annexia;password=123123";

		try (
			Connection connection = DriverManager.getConnection(connectionUrl);
		) {
			
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(
					"SELECT * " + "FROM Zips " +
					"WHERE StateAbv IN ('" + stateAbv + "')"
			);		
			int count = 0;
			while (rs.next()) {
				
				String zip = rs.getString("Zip");
				String stateAbbreviation = rs.getString("StateAbv");			

				String[] dataLine = new String[2];
				
				dataLine[0] = zip;
				dataLine[1] = stateAbv;

				zipData.add(dataLine);
				count++;

			}

			rs.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return zipData;
		
	}
}


