
package com.crm.qa.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.TestBase;

public class GmailInboxPage extends TestBase {

	JavascriptExecutor exe = (JavascriptExecutor) driver;

	@FindBy(xpath = "//div[@aria-label='Main menu']")
	static WebElement MenuBtn;

	@FindBy(xpath = "//textarea[@name='to']")
	static WebElement To_xpath;

	@FindBy(name = "subjectbox")
	static WebElement Subject_xpath;

	@FindBy(xpath = "//div[@aria-label='Message Body']")
	static WebElement DraftBox_xpath;

	@FindBy(xpath = "//div[@class=\"T-I J-J5-Ji aoO v7 T-I-atl L3\"]")
	static WebElement SendBtn_xpath;

	@FindBy(xpath = "//textarea[@name='to']")
	static WebElement Invalid_To_xpath;

	@FindBy(xpath = "//a[@aria-label='Sent']")
	static WebElement SentItemBoxbtn_xpath;

	public GmailInboxPage() {
		PageFactory.initElements(driver, this);
	}
	
	

	public static void SwitchWindow() {
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();

		String parentWindowId = it.next();
		System.out.println("parent window id" + parentWindowId);

		String childWindowId = it.next();
		System.out.println("child window id" + childWindowId);

		driver.switchTo().window(childWindowId);

		System.out.println(driver.getTitle());

//		WebDriverWait SwitchWindowwait = new WebDriverWait(driver, 30);
//		SwitchWindowwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Compose')]")));
		// click on the compose button as soon as the "compose" button is visible
//		driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();
	}

	public static void ComposeMail(String email, String SubjectText) throws InterruptedException {
		Thread.sleep(2000L);
		GmailInboxPage.SwitchWindow();
		
		WebDriverWait SwitchWindowwait = new WebDriverWait(driver, 30);
		SwitchWindowwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Compose')]")));
		// click on the compose button as soon as the "compose" button is visible
		driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();
		

		System.out.println(driver.getTitle());
		WebDriverWait ComposeMailwait = new WebDriverWait(driver, 30);
		ComposeMailwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='to']")));
		System.out.println(driver.getTitle());

		To_xpath.sendKeys(prop.getProperty("identifier"));
		String clickopentab = Keys.chord(Keys.CONTROL, Keys.ENTER);

		Subject_xpath.sendKeys(prop.getProperty("subject"));
		
		
		Thread.sleep(2000L);
		System.out.println(driver.getTitle());
		WebDriverWait DraftMailwait = new WebDriverWait(driver, 30);
		DraftMailwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Message Body']")));

		DraftBox_xpath.sendKeys(prop.getProperty("DraftBoxMessage"));
		SendBtn_xpath.click();
	}

//	public static void DraftMail(String message) throws InterruptedException {
//
//		
//		Thread.sleep(2000L);
//		GmailInboxPage.ComposeMail(prop.getProperty("identifier"), prop.getProperty("subject"));
//		
//		Thread.sleep(2000L);
//		System.out.println(driver.getTitle());
//		WebDriverWait DraftMailwait = new WebDriverWait(driver, 30);
//		DraftMailwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Message Body']")));
//
//		DraftBox_xpath.sendKeys(prop.getProperty("DraftBoxMessage"));
//		SendBtn_xpath.click();
//	}

//	public static void ClickOnSendBtn() throws InterruptedException {
//		GmailInboxPage.DraftMail(prop.getProperty("DraftBoxMessage"));
//		SendBtn_xpath.click();
//
//	}
	
	public static GmailSendPage ClickOnSentItemBox() throws InterruptedException {
		GmailInboxPage.MethodForSwtichWindow();
		
		WebDriverWait SentItemBoxwait = new WebDriverWait(driver, 30);
		SentItemBoxwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Sent']")));
		
		
		Thread.sleep(2000L);
		SentItemBoxbtn_xpath.click();
		Thread.sleep(2000L);
		System.out.println(driver.getTitle());
		return new GmailSendPage();

	}

	public static void InvlaidUserNameMailSend(String Invaildemail, String SubjectText) throws InterruptedException {

		Thread.sleep(2000L);
		GmailInboxPage.MethodForSwtichWindow();
		
		WebDriverWait SwitchWindowwait = new WebDriverWait(driver, 30);
		SwitchWindowwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Compose')]")));
		// click on the compose button as soon as the "compose" button is visible
		driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();
		
		Invalid_To_xpath.sendKeys(prop.getProperty("InValidUseName"));
		Subject_xpath.sendKeys(prop.getProperty("subject"));
		DraftBox_xpath.sendKeys(prop.getProperty("DraftBoxMessage"));
		SendBtn_xpath.click();
		System.out.println("Out of Inbox Page Test");
	}





}
