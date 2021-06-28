package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentPropertLoader {
	InputStream inputStream;

	public static String getPropertyValue(String propertyName) throws IOException {
		
		String propFileName = "C:\\Users\\09191H744\\git\\Selenium_Project_MoneyControl\\seleniumHandsOn\\src\\main\\resources\\Config\\config.properties";
		
		File file = new File(propFileName);
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return prop.getProperty(propertyName);
	}
}
