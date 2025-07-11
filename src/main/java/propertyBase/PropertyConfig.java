package propertyBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertyConfig {

	public static Properties config;
	static Logger log = Logger.getLogger(PropertyConfig.class);

 public static String getProperty(String key) {

		config = new Properties();
		String value = null;
		try {
			FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
			config.load(fis);
			value = config.getProperty(key);
		} catch (FileNotFoundException e) {
			log.error("Unable to open Property file");
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return value;
	}
}
