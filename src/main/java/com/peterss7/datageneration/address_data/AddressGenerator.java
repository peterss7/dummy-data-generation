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
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.fluttercode.datafactory.impl.DataFactory;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

public class AddressGenerator {

	private static DataFactory df = new DataFactory();
	private static int stateIndex;
	private static String address;
	private static String city;
	private static String state;
	private static List<String[]> stateData;
	private static String zip;

	public AddressGenerator(){
		
		setAddress();
		setStateData();
		setState();
		setCity();		
		setZip();		
		
	}
	public void setAddress() {
		address = df.getAddress();
	}

	public String getAddress() {

		return address;
	}
	
	public String getZip() {
	
		return zip;
		
	}
	
	public void setStateIndex(int index) {
		stateIndex = index;
	}
	
	public int getStateIndex() {
		return stateIndex;
	}
	
	public static void setZip() {
		
		List<String[]> stateZips = 
			ZipGenerator.getZipsByStateAbv(stateData.get(stateIndex)[2]); 
		
		zip = stateZips.get((new Random()).nextInt(stateZips.size()))[0];
	}
	
	@Override
	public String toString() {
		return "AddressGenerator [getAddress()=" +  getAddress() + "\ngetCity()=" + getCity() + 
			", getState()=" + getState() + ", getZip()= " + getZip() + "]";
	}
	public void setStateData() {		
		stateData = CityAndStateGenerator.getStateData();
	}
	
	public void setState() {
		state = stateData.get(stateIndex)[1];
	}
	
	public String getState() {
		return state;
	}
	
	public static String getStateAbv() {
		return stateData.get(stateIndex)[2];
	}
	
	public int getStateId() {
		return stateIndex;
	}
	public void setCity() {
		city = CityAndStateGenerator.getCity(state);
	}
	public String getCity() {
		return city;
	}
	


}
