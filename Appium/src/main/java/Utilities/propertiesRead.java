package Utilities;

import java.io.FileReader;
import java.util.Properties;

public class propertiesRead {
	public static String properties(String choice) {
		Properties p = null;
		try {
			String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Configure.properties";
			FileReader reader = new FileReader(filePath);
			p = new Properties();
			p.load(reader);
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return p.getProperty(choice);
	}
}
