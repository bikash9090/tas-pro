package com.taspro.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	Properties prop;

	public PropertiesUtil() {
		
		String path = System.getProperty("usre.dir")+"\\src\\test\\resources\\config.properties";
		FileInputStream filepa;
		prop = new Properties();
		
		try {
			filepa = new FileInputStream(path);	// Established the stream connection with properties file.
			prop.load(filepa);					// Loaded the inputStrem of properties file.
		} catch (FileNotFoundException e) {
			System.out.println("The properties file not found! on the path : "+path);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO exception occured! during operation on the file : "+path);
			e.printStackTrace();
		}
	}

	public String getemail() {
		return prop.getProperty("email");
	}

	public String getpassword() {
		return prop.getProperty("password");
	}
	
	public String getUrl() {
		return prop.getProperty("url");
	}
}
