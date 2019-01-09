package com.retailgrocery.pos.billing.util;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @author PS
 *
 */
public class ConfigManagerCache {

	private static ConfigManagerCache instance;
	
	private Map<String, String> configCache = new HashMap<>();

	/**
	 * constructor
	 */
	private ConfigManagerCache() {
	}

	
	/**
	 * 
	 * @return
	 */
	public static synchronized ConfigManagerCache getInstance() {
		if (instance == null) {
			instance = new ConfigManagerCache();
		}
		return instance;
	}

	/**
	 * 
	 * @return
	 */
	public Map<String, String> getConfigCache() {
		return configCache;
	}

	/**
	 * 
	 * @param configCache
	 */
	public void setConfigCache(Map<String, String> configCache) {
		this.configCache = configCache;
	}
}
