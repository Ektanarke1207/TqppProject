import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class ReadProp {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver=null;
		
        //*****************create object of properties;*******************////
		Properties prop = new Properties();
		
		//*******create FileInputStream and pass location path config.properties file***********//
		FileInputStream in = new FileInputStream("C:\\Users\\ekta.narke\\eclipse-workspace\\Demo\\src\\main\\"
				+ "java\\com\\crm\\qa\\config\\config.properties");
		
		//***********load all the data from config.properties file into prop*****************//
		prop.load(in);
		System.out.println(prop.getProperty("url"));
		
		//********************provide BrowserName variable**************************************//
		String BrowserName = prop.getProperty("browser");
		
		
		if(BrowserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			driver = new ChromeDriver();
//			driver.get("http://demo.automationtesting.in/Register.html");
		}
		//************Just for Example Firefox exe file not download**********************//
		else if(BrowserName.equals("FireFox")) {
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			driver = new FirefoxDriver();
		}
		//************Just for Example Safari exe file not download**********************//
		else if(BrowserName.equals("Safari")) {
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			driver = new SafariDriver();
		}
		//************Just for Example InternetExplorerDriver exe file not download**********************//
		else if(BrowserName.equals("InternetExplorer")) {
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println("No such browser found");
		}
		
		
		
		driver.get(prop.getProperty("url"));

		driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/div/div[1]/div")).isDisplayed();
		driver.findElement(By.xpath(prop.getProperty("fisrtloginBtn_xpath"))).click();
		driver.findElement(By.name(prop.getProperty("email_name"))).sendKeys((prop.getProperty("email")));
		driver.findElement(By.name(prop.getProperty("password_name"))).sendKeys((prop.getProperty("password")));
		driver.findElement(By.xpath(prop.getProperty("secondloginBtn_xpath"))).click();
		
	}

}
