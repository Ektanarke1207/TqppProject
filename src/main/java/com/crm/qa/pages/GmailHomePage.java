package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
//import com.crm.qa.pages.GmailInboxPage;
import org.openqa.selenium.interactions.Actions;

public class GmailHomePage extends TestBase{

	@FindBy (xpath = "//a[@aria-label= 'Google apps']")
	WebElement SelectGoogleApps;

	@FindBy (xpath = "//span[contains(text(), 'Gmail')]")
	WebElement SelectGmailIcon;
	
	public GmailHomePage (){
		
		PageFactory.initElements(driver, this);
	}
	

	
	public void ClickGoogleApps() {
		 Actions actions = new Actions(driver);
		 actions.moveToElement(SelectGoogleApps);
		 actions.clickAndHold().perform();
//		SelectGoogleApps.click();
	
	}
	
	public GmailInboxPage ClickGmailIcon() throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@role='presentation']")));
		Thread.sleep(2000L);
		SelectGmailIcon.click();
		System.out.println("Out of Home Page Test");
		return new GmailInboxPage();
	
	}


	
	
}
