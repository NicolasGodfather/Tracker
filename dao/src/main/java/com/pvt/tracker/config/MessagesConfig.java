package com.pvt.tracker.config;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Class for load files with localization message. Access 2 language:
 * rus, eng. English language load default.
 */
public class MessagesConfig {

	private static final Logger logger = Logger.getLogger(MessagesConfig.class);
	private Properties props;
	
	public MessagesConfig () {
		props = new Properties();
		setLanguage(Lang.EN);
	}
	
	public enum Lang {
		EN, RU;		
	}
	
	public String message(String name) {
		return props.getProperty(name);
	}
	
	public void setLanguage(Lang lang) {
		logger.info("Loading messages file: messages_" + lang + ".properties");
		try {
			props.load(MessagesConfig.class.getClassLoader().getResourceAsStream("messages_" + lang + ".properties"));
			logger.info("Messages loaded!");
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
	
}
