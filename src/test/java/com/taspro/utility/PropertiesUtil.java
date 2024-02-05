package com.taspro.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.taspro.base.Constants;

public class PropertiesUtil {
	Properties pro;

	public PropertiesUtil() {

		String path = Constants.PROPERTIES_FILE_PATH;
		FileInputStream filepa;
		pro = new Properties();
		
		try {
			filepa = new FileInputStream(path);
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

	public String getBrowser() {
		return pro.getProperty("browser");
	}
}