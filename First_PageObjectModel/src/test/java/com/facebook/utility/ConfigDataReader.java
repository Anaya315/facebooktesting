package com.facebook.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataReader {

	Properties prop;

	public ConfigDataReader() {
		prop = new Properties();
		File src = new File("E:\\madhavi\\MukeshOtwani\\First_PageObjectModel\\Configuration\\config.properties");
		try {
			FileInputStream is = new FileInputStream(src);
			prop.load(is);
		} catch (Exception e) {
			System.out.println("unable to read data" + e.getMessage());
		}

	}

	public String getbrowserstring() {
		return prop.getProperty("Browser");
	}

	public String geturlstring() {
		return prop.getProperty("Url");
	}
}
