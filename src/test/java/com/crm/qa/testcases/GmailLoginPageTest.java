package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.crm.qa.base.TestBase;
import com.crm.qa.pages.GmailLoginPage;

public class GmailLoginPageTest extends TestBase {
	GmailLoginPage GmailLoginPage;

	public GmailLoginPageTest() {
		// To call parent class constructor to initialise the properties i.e
		// "TestBase()" or super constructor super() is used//
		super();
	}

// **************@BeforeMethod************************************//
	@BeforeMethod
	public void setUp() {
		initialization();
		// LoginPage Constructor
		GmailLoginPage = new GmailLoginPage();
	}

//*******************POSITIVE TEST CASES********************//	
// ******************Test cases Started************************//

	@Test(priority = 0)
  
	public void G_Login_email_Test() throws InterruptedException {
		GmailLoginPage.G_Login_email_1(prop.getProperty("identifier"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void GmailLoginPageTitleTest() throws InterruptedException {
		GmailLoginPage.G_Login_email_1(prop.getProperty("identifier"), prop.getProperty("password"));
		Thread.sleep(2000L);
		String title = GmailLoginPage.GmailValidLoginPageTitle();
		String newtitle = title.substring(0, 14);
		Thread.sleep(3000L);
		Assert.assertEquals(newtitle, "Google Account");
		System.out.println("Excepted title of Current page :- Google Account");
		System.out.println("Actual title of Current page :-" + newtitle);

	}

//****************NEGATIVE TEST CASES****************//	
//*******************Invalid UserName and Valid Password Failed Login*****************************//
	@Test(priority = 2)
	public void LoginWithInvalidUserNameTest() throws InterruptedException {
		GmailLoginPage.LoginWithInvalidUserName(prop.getProperty("ektaautomatio@gmail.com"),
				prop.getProperty("password"));
	}

//*******************Valid UserName and Invalid Password Failed Login*****************************//
	@Test(priority = 3)
	public void LoginWithInvalidPasswordTest() throws InterruptedException {
		GmailLoginPage.LoginWithInvalidPassword(prop.getProperty("identifier"), prop.getProperty("Ekta@12"));
	}

//*******************Blank UserName Failed Login*****************************//
	@Test(priority = 4)
	public void LoginWithBlankUserNameTest() throws InterruptedException {
		GmailLoginPage.LoginWithBlankUserName(prop.getProperty("BlankUserName"));
	}

//*******************Blank Password Failed Login*****************************//
	@Test(priority = 5)
	public void LoginWithBlankPasswordTest() throws InterruptedException {
		GmailLoginPage.LoginWithBlankPassword(prop.getProperty("identifier"), prop.getProperty("BlankPassword"));
		
	}

	// **************@AfterMethod************************************//
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
