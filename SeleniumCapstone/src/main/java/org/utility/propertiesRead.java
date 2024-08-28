package org.utility;

import java.io.FileReader;
import java.util.Properties;

public class propertiesRead {
	public static String properties(String choice) throws Exception {
		Properties p = null;
		try {
			String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\Configure.properties";
			FileReader reader = new FileReader(filePath);
			p = new Properties();
			p.load(reader);
		} catch (Exception e) {
			System.out.print(e);
		}
		return p.getProperty(choice);
	}
}
