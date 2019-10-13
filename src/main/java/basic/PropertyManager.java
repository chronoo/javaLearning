package basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * PropertyManager - считывает значения из файла *.properties
 */
public class PropertyManager {
	public static Properties getProperties(String path) {
	    Properties properties = new Properties();
	    FileInputStream inputStream;
	
	    try {
	        inputStream = new FileInputStream(path);
	        properties.load(inputStream);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    return properties;
	}    
}