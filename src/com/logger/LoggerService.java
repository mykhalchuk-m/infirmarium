package com.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerService {
	public static Logger getLogger(String name) {
		Logger logger = Logger.getLogger(name);
		logger.setLevel(Level.ALL);
		logger.setUseParentHandlers(false);
		try {
			FileHandler handler = new FileHandler("./logs/" + name + ".xml");
			logger.addHandler(handler);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return logger;
	}
}
