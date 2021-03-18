package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

import com.crm.qa.pages.GmailLoginPage;

import com.crm.qa.pages.GmailHomePage;
import com.crm.qa.pages.GmailInboxPage;

public class GmailHomePageTest extends TestBase {

	GmailLoginPage GmailLoginPage;
	GmailHomePage GmailHomePage;
	GmailInboxPage GmailInboxPage;

	public GmailHomePageTest() {
		super();
	}

	// **************@BeforeMethod************************************//
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		// LoginPage Constructor
		GmailLoginPage = new GmailLoginPage();
		GmailHomePage = GmailLoginPage.G_Login_email_1(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test(priority = 0)
	public void VerifyClickOnGoogleAppTest() throws InterruptedException {

		GmailHomePage.ClickGoogleApps();
		Thread.sleep(2000L);

	}

	@Test(priority = 1)
	public void VerifyClickOnGmailIconTest() throws InterruptedException {
		Thread.sleep(2000L);
		GmailInboxPage = GmailHomePage.ClickGmailIcon();

	}

	// **************@AfterMethod************************************//
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
