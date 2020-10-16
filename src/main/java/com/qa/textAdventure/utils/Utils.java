package com.qa.textAdventure.utils;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils {
	private final static Logger LOGGER = LogManager.getLogger();

	private final Scanner scanner;
	private String errorMSG = "Error - Please enter a number";

	public Utils(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public Utils() {
		scanner = new Scanner(System.in);
	}

	public Long getLong() {
		String input = getString();
		Long longInput = null;
		do {
			try {
				longInput = Long.parseLong(input);
			} catch (NumberFormatException nfe) {
				LOGGER.info(errorMSG);
			}
		} while (longInput == null);
		return longInput;
	}

	public String getString() {
		return scanner.nextLine();
	}

	public Double getDouble() {
		String input = getString();
		Double doubleInput = null;
		do {
			try {
				doubleInput = Double.parseDouble(input);
			} catch (NumberFormatException nfe) {
				LOGGER.info(errorMSG);
			}
		} while (doubleInput == null);
		return doubleInput;
	}
	
	public int getInt() {
		String input = getString();
		Integer intInput = null;
		do {
			try {
				intInput = Integer.parseInt(input);
			} catch (NumberFormatException nfe) {
				LOGGER.info(errorMSG);
			}
		} while (intInput == null);
		return intInput;
	}
	public Boolean getBoolean() {
		String input = getString();
		Boolean boolInput = null;
		do {
			try {
				boolInput = Boolean.parseBoolean(input);
			} catch (NumberFormatException nfe) {
				LOGGER.info("Error - Please enter TRUE or FALSE");
			}
		} while (boolInput == null);
		return boolInput;
	}

}
