package com.crm.qa.util;

import org.apache.log4j.PropertyConfigurator;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenerateLogs {

	public static void main(String[] args) {
//The getLogger() method of a Logger class used find or create a logger
		Logger log = Logger.getLogger(GenerateLogs.class);

		// PropertiesConfigurator is used to configure logger from properties file
		PropertyConfigurator.configure("log4j.properties");

		// Log in console in and log file
		log.debug("Log4j appender configuration is successful !!");

		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		log.info("Launch Browser");

		driver.get("https://www.google.com/");
		log.info("Google url has been lunched");

		String title = driver.getTitle();
		System.out.println("tittle vale is: " + title);
		log.info("tittle vale is: " + title);

		if (title.equals("Google")) {
			System.out.println("Correct title is google");
			log.info("Correct title is google and test case passed");
		} else {
			System.out.println("not correct title ,correct tittle is Google");
			log.info("not correct title ,correct title is Google and test case failed");
		}

	}

}
