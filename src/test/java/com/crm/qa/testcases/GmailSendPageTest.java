package com.crm.qa.testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.GmailHomePage;
import com.crm.qa.pages.GmailInboxPage;
import com.crm.qa.pages.GmailLoginPage;
import com.crm.qa.pages.GmailSendPage;

public class GmailSendPageTest extends TestBase {
	GmailLoginPage GmailLoginPage;
	GmailHomePage GmailHomePage;
	GmailInboxPage GmailInboxPage;
	GmailSendPage GmailSendPage;


	
	public GmailSendPageTest() {
		// To call parent class constructor to initialise the properties i.e
		// "TestBase()" or super constructor super() is used//
		super();
	}
	
	
	
	// **************@BeforeMethod************************************//
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		// GmailLoginPage Constructor
		GmailLoginPage = new GmailLoginPage();
		GmailHomePage = GmailLoginPage.G_Login_email_1(prop.getProperty("email"), prop.getProperty("password"));
		GmailHomePage.ClickGoogleApps();
		GmailInboxPage = GmailHomePage.ClickGmailIcon();
//		GmailSendPage = GmailInboxPage.ClickOnSentItemBox();
		GmailSendPage = GmailInboxPage.ClickOnSentItemBox();

	}
	
	
	
	@Test(priority = 0)
	public void MailSearchOptionsBarTest() throws InterruptedException {
		com.crm.qa.pages.GmailSendPage.MailSearchOptionsBar();
	}
	
	@Test(priority = 1)
	public void SearchFromTest() throws InterruptedException {
		Thread.sleep(2000L);
		com.crm.qa.pages.GmailSendPage.SearchFrom(prop.getProperty("identifier"),prop.getProperty("identifier"),
				prop.getProperty("subject"),prop.getProperty("DraftBoxMessage"));
	}
	
	
	@Test(priority = 2)
	public void DeleteMailFromSentBoxTest() throws InterruptedException {
		Thread.sleep(2000L);
		GmailSendPage.DeleteMailFromSentBox();
		
	}
	
	
//********************End 2 End*******************************//
	
	
	@Test(priority = 3)
	public void EndtoEndTest() throws InterruptedException {
		Thread.sleep(2000L);
		GmailSendPage.EndtoEnd();
		
	}
	
	
	// **************@AfterMethod************************************//
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
