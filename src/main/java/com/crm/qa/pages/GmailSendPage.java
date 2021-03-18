package com.crm.qa.pages;


import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.GmailHomePage;
import com.crm.qa.pages.GmailInboxPage;
//import com.crm.qa.base.TestBase;


public class GmailSendPage extends TestBase{

	GmailInboxPage GmailInboxPage;
	
	@FindBy(xpath = "//button[@data-tooltip='Show search options']")
	static WebElement MailSearchOptionsBar_xpath;	

	
	@FindBy(xpath = "//input[@class='ZH nr aQa']")
	static WebElement SearchFrom_xpath;
	
	@FindBy(xpath = "//input[@class='ZH nr aQf']")
	static WebElement SearchTo_xpath;

	@FindBy(xpath = "//input[@class='ZH nr aQd']")
	static WebElement SearchSubject_xpath;
	
	@FindBy(xpath = "//input[@class='ZH nr aQb']")
	static WebElement SearchMailDraft_xpath;
	
	@FindBy(xpath = "//div[@data-tooltip='Search Mail']")
	static WebElement SearchBtn_xpath;
	
	
	@FindBy(xpath = "//div[@aria-label=\"Delete\"]")
	static WebElement DeletemailBtn_xpath;
	
	
	@FindBy(xpath = "//td[@data-tooltip=\"Select\"]")
	static List <WebElement> DeletemailList_xpath;
	
	@FindBy(xpath = "//div[@class=\"T-I J-J5-Ji aoO v7 T-I-atl L3\"]")
	static WebElement SendBtn_xpath;
	
	public GmailSendPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public static void MailSearchOptionsBar() {
		WebElement SearchOptionsBar = driver.findElement(By.xpath("//button[@data-tooltip='Show search options']"));
		SearchOptionsBar.click();
	

	}
	 public static void SearchFrom(String usernameFrom, String usernameTo, String SubjectTitle, String Message) throws InterruptedException {

		 GmailSendPage.MailSearchOptionsBar();
		 Thread.sleep(2000L);
//		 driver.findElement(By.xpath("//input[@class='ZH nr aQa']")).sendKeys(prop.getProperty("identifier"));

		 
		 SearchFrom_xpath.sendKeys(prop.getProperty("identifier"));
		 SearchTo_xpath.sendKeys(prop.getProperty("identifier"));
		 SearchSubject_xpath.sendKeys(prop.getProperty("subject"));
		 SearchMailDraft_xpath.sendKeys(prop.getProperty("DraftBoxMessage"));
		 SearchBtn_xpath.click();
		 
	 }
	 

	 

	 
	 public static void DeleteMailFromSentBox() throws InterruptedException {
		 Thread.sleep(2000L);

		 Thread.sleep(2000L);          
		 driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div[3]/div[2]/div[1]/div/div/div[1]/div/div[1]/span")).click();
		 driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji nX T-I-ax7 T-I-Js-Gs mA' and @data-tooltip='Delete']")).click();
		                              
	 
	 }
	 
	//********************End 2 End*******************************//
	 
	 public void EndtoEnd() throws InterruptedException{
		 com.crm.qa.pages.GmailInboxPage.SwitchWindow();
		 System.out.println("Out of SwitchWindow");
		 
		 Thread.sleep(2000L);
		 com.crm.qa.pages.GmailInboxPage.ComposeMail(prop.getProperty("identifier"), prop.getProperty("subject"));
		 System.out.println("Out of ComposeMail");
		 
		 
		 Thread.sleep(2000L);
		 com.crm.qa.pages.GmailInboxPage.ClickOnSentItemBox();
		 System.out.println("Out of ClickOnSentItemBox");
		 
		 Thread.sleep(2000L);
		 com.crm.qa.pages.GmailSendPage.MailSearchOptionsBar();
		 System.out.println("Out of MailSearchOptionsBar");
		 
		WebDriverWait InputoptionWait = new WebDriverWait(driver, 30);
		InputoptionWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='ZH nr aQa']")));
		 
		
		 Thread.sleep(2000L);
		 driver.findElement(By.xpath("//input[@class='ZH nr aQa']")).sendKeys("ektaautomation@gmail.com");
		 driver.findElement(By.xpath("//input[@class='ZH nr aQf']")).sendKeys("ektaautomation@gmail.com");
		 driver.findElement(By.xpath("//input[@class='ZH nr aQd']")).sendKeys("Test_Mail");
		 driver.findElement(By.xpath("//input[@class='ZH nr aQb']")).sendKeys("Hello IVL!!!!");
		 SearchBtn_xpath.click();

		 
	     System.out.println("Out of SearchFrom");
		 
		 Thread.sleep(2000L);
		 com.crm.qa.pages.GmailSendPage.DeleteMailFromSentBox();
		 System.out.println("Out of DeleteMailFromSentBox");
		 System.out.println("Out of Send Page Test");
		 
	 }
		 
		 
	
	 }








