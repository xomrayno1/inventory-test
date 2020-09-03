package com.tampro.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
	private Properties properties = null;
	private static ConfigLoader  instance = null;
	String proFileName = "config.properties";
	
	private ConfigLoader() {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(proFileName);
		if(inputStream!=null) {
			properties = new Properties();
			try {
				properties.load(inputStream);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	public static ConfigLoader getInstance() {
		if(instance == null) {
			instance = new ConfigLoader();
		}
		return instance;
	}
	public String getValue(String key) {
		if(properties.containsKey(key)) {
			return properties.getProperty(key);
		}
		return null;
	}

}
