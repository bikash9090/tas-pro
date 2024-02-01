package com.taspro.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	Properties pro;

	public PropertiesUtil() {
		FileInputStream filepa;
		pro = new Properties();
		try {
			filepa = new FileInputStream(
					"C:\\Users\\dipak\\git\\tas-pro\\src\\test\\resources\\config.properties");
			pro.load(filepa);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public String getemail() {
		return pro.getProperty("email");
	}

	public String getpassword() {
		return pro.getProperty("password");
	}
	public String getUrl() {
		return pro.getProperty("url");
	}
}
