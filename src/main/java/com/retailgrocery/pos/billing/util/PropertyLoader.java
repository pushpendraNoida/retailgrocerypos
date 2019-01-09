package com.retailgrocery.pos.billing.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.retailgrocery.pos.billing.constants.Constants;

/**
 * 
 * @author PS
 *
 */
public class PropertyLoader {

	final static Logger logger = Logger.getLogger(PropertyLoader.class);
	
	/**
	 * 
	 * @return
	 */
	public  Map<String, String> loadProperty() {
		Map<String, String> map = new HashMap<>();
		Properties prop = new Properties();
		InputStream inputStream = null;

		try {

			inputStream = getClass().getClassLoader().getResourceAsStream(
					Constants.CONFIG_FILE);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '"
						+ Constants.CONFIG_FILE + "' not found in the classpath");
			}

			Enumeration<?> e = prop.propertyNames();

			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String value = prop.getProperty(key);
				map.put(key, value);
			}
			ConfigManagerCache.getInstance().setConfigCache(map);
		} catch (IOException ex) {
			logger.error(ex.getMessage());
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
			}
		}
		return map;
	}
	
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public static String propertyValue(String key)
	{
		PropertyLoader loader = new PropertyLoader();
		Map<String, String> map = loader.loadProperty();
		
		return map.get(key);
	}
}