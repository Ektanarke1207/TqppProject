package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.crm.qa.util.TimeUtil;

public class TestBase {

//***********make it public static so we can use this variables in child class also***************************//
	public static WebDriver driver;
	public static Properties prop;

//***********Public Constructor of class TestBase**************************************//
	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream in = new FileInputStream("/Users/ekta.narke/eclipse-workspace/Demo/src/"
					+ "main/java/com/crm/qa/config/config.properties");
			prop.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		}

	}

	public static void initialization() {
		String BrowserName = prop.getProperty("browser");
		if (BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			driver = new ChromeDriver();
		} // ************Just for Example Firefox exe file not
			// download**********************//
		else if (BrowserName.equals("FireFox")) {
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			driver = new FirefoxDriver();
		}
		// ************Just for Example Safari exe file not
		// download**********************//
		else if (BrowserName.equals("Safari")) {
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			driver = new SafariDriver();
		}
		// ************Just for Example InternetExplorerDriver exe file not
		// download**********************//
		else if (BrowserName.equals("InternetExplorer")) {
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("No such browser found");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TimeUtil.page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeUtil.implicitly_Wait, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}
	
	public static void MethodForSwtichWindow() throws InterruptedException {
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();

		String parentWindowId = it.next();
		System.out.println("parent window id" + parentWindowId);

		String childWindowId = it.next();
		System.out.println("child window id" + childWindowId);

		driver.switchTo().window(childWindowId);
		Thread.sleep(2000L);
		System.out.println("In MethodForSwtichWindow()" + driver.getTitle());
	}


	
}
