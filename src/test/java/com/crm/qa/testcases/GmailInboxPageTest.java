package com.crm.qa.testcases;

import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.GmailHomePage;
import com.crm.qa.pages.GmailInboxPage;
import com.crm.qa.pages.GmailLoginPage;

public class GmailInboxPageTest extends TestBase {

	GmailLoginPage GmailLoginPage;
	GmailHomePage GmailHomePage;
	GmailInboxPage GmailInboxPage;

	public GmailInboxPageTest() {
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

	}

// **************@test=> POSITIVE TEST CASE************************************//

	@Test(priority = 0)
	public void SwitchWindowTest() throws InterruptedException {
		GmailInboxPage.SwitchWindow();
		Thread.sleep(2000L);
	}

	@Test(priority = 1)
	public void ComposeMailTest() throws InterruptedException {
		Thread.sleep(2000L);
		GmailInboxPage.ComposeMail(prop.getProperty("identifier"), prop.getProperty("subject"));
	}

//	@Test(priority = 2)
//	public void DraftMailTest() throws InterruptedException {
//		Thread.sleep(2000L);
//		com.crm.qa.pages.GmailInboxPage.DraftMail(prop.getProperty("DraftBoxMessage"));
//	}
//
//	@Test(priority = 3)
//	public void ClickOnSendBtnTest() throws InterruptedException {
//		Thread.sleep(2000L);
//		GmailInboxPage.ClickOnSendBtn();
//	}
	
	
	
	@Test(priority = 2)
	public void ClickOnSentItemBoxTest() throws InterruptedException {
		Thread.sleep(2000L);
		GmailInboxPage.ClickOnSentItemBox();
	}
	
// **************@test=> NEGATIVE TEST CASE************************************//

	@Test(priority = 3)
	public void InvlaidUserNameMailSendTest() throws InterruptedException {
		Thread.sleep(2000L);
		GmailInboxPage.InvlaidUserNameMailSend(prop.getProperty("InValidUseName"), prop.getProperty("subject"));
	}
	
	// **************@AfterMethod************************************//
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}

}
