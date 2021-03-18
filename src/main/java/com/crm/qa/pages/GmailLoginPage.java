package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
//import com.crm.qa.base.GmailInboxPage;

public class GmailLoginPage extends TestBase {
	
	@FindBy(name = "identifier")
	WebElement identifier;
	
	@FindBy(name = "password")
    WebElement password;
	
	@FindBy (xpath = "//div[@class='VfPpkd-RLmnJb']")
	WebElement NextBtn_xpath;
	

	
	public GmailLoginPage() {
		//to initialize the Elements of Page Factory there is method i.e initElement
		// driver comes from Testbase class and (this) the current class object
		// All the above variables will comes in driver
		// instead of "this" we can also write "LoginPage.class"
		PageFactory.initElements(driver, this);
	
	}
	
//********************Positive Test Case***********************************//
	public String GmailValidLoginPageTitle() throws InterruptedException {
		Thread.sleep(5000L);
		return driver.getTitle();
	
	}
	
	
	public GmailHomePage G_Login_email_1 (String username, String pass) throws InterruptedException  {
		identifier.sendKeys(prop.getProperty("identifier"));
		NextBtn_xpath.click();
		Thread.sleep(2000L);
		password.sendKeys(prop.getProperty("password"));
		Thread.sleep(2000L);
		NextBtn_xpath.click();
		return new GmailHomePage();

	}
	
	public GmailHomePage LoginWithInvalidUserName(String Invalidusername, String Validpass) throws InterruptedException {
		identifier.sendKeys("ektaautomati@gmail.com");
		NextBtn_xpath.click();
		password.sendKeys(prop.getProperty("password"));
		Thread.sleep(2000L);
		NextBtn_xpath.click();
		return new GmailHomePage();
	}
	
	public GmailHomePage LoginWithInvalidPassword(String Validusername, String Invalidpass) throws InterruptedException {
		identifier.sendKeys(prop.getProperty("identifier"));
		NextBtn_xpath.click();
		password.sendKeys("password");
		Thread.sleep(2000L);
		NextBtn_xpath.click();
		return new GmailHomePage();
	}

//********************Negative Test Case***********************************//
	public void LoginWithBlankUserName(String username) throws InterruptedException {
		identifier.sendKeys(prop.getProperty("BlankUserName"));
		NextBtn_xpath.click();

	}
	
	public void LoginWithBlankPassword(String Email_id,String BlankPassword) throws InterruptedException {
		identifier.sendKeys(prop.getProperty("identifier"));
		NextBtn_xpath.click();
		password.sendKeys(prop.getProperty("BlankPassword"));
		NextBtn_xpath.click();
System.out.println("Out of Login Page Test");
	}

	

}
