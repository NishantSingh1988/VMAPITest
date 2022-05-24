package com.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertyReader {
Map<String, String> propertyMap = new HashMap<String, String>();
	
	private PropertyReader() {
		FileReader fr=null;
		try {
			fr = new FileReader("src/test/resources/config/data.properties");
			Properties pr = new Properties();
			pr.load(fr);
			Set set = pr.entrySet();
			Iterator itr = set.iterator();
			
			while(itr.hasNext()) {
				Map.Entry<String, String> entry = (Map.Entry)itr.next();
				propertyMap.put(entry.getKey(), entry.getValue());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getProperty(String propertyName) {
		if(propertyMap==null) {
			return "not_found";
		}
		return propertyMap.get(propertyName);
	}
	
	private  static class ReaderHelper{
		private static final PropertyReader INSTANCE = new PropertyReader(); 
	}
	
	public static PropertyReader getInstance() {
		return ReaderHelper.INSTANCE;
	}
	
	
	public String getURL() {
		return propertyMap.get("url");
	}
	
}
