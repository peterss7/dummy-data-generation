package com.peterss7.datageneration.address_data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.peterss7.console.Console;
import com.peterss7.csv_helpers.Filepaths;

public class CityAndStateGenerator {
	
	public static List<String[]> getStateData(){
		
		List<String[]> stateData = new ArrayList<String[]>();
			
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(
					Filepaths.STATE_DATA_CSV.getFilepath()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] nextLine;
		
		
		int stateIndex = 1;
		try {
			reader.readNext();
			while ((nextLine = reader.readNext()) != null) {
				List<String> tempString = new ArrayList<String>();
				
				tempString.add(stateIndex + "");
				for(String element : nextLine) {
					tempString.add(element);
				}

				if (!(tempString.get(2).equals("DC"))) {
					stateData.add(tempString.toArray(new String[0]));
					stateIndex++;
				}
			}
		} catch (CsvValidationException | IOException e) {			
			e.printStackTrace();
		}
		
		return stateData;
	}

	public static String getCity(String stateName) {
		
		ArrayList<String> cities = new ArrayList<>();
		String connectionUrl = "jdbc:sqlserver://PC-ANNEXIA\\peter:1433;databaseName=DummyData;user=Annexia;password=123123";

		try (
			Connection connection = DriverManager.getConnection(connectionUrl);
		) {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(
					"SELECT CityName " + "FROM CitiesAndStates " +
					"WHERE StateName IN ('" + stateName + "')"
			);		
			
			
			
			while (rs.next()) {
				
				String city = rs.getString("CityName");		
				//Console.println(city);
				cities.add(city);
			}

			rs.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Random rand = new Random();
		
		int size = cities.size();		
		
		try {
			
			int citiesIndex = rand.nextInt(size) + 1;
			if (citiesIndex <= 0) Console.println(citiesIndex + "");
			
			if (citiesIndex == size)
				return cities.get(citiesIndex - 1);
			else if (citiesIndex == 0)
				return cities.get(1);
			else
				return cities.get(citiesIndex);
			
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
			
			return null;
		}
		
	}

}
