package com.crm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

	public class HomePage extends TestBase 
	{

		
		    @FindBy(xpath = "//h6[contains(text(),'Dashboard')]")
		    WebElement homePageText;

		    @FindBy(xpath = "//span[normalize-space()='Admin']")
		    WebElement admin;

		    public HomePage()
		    {
		        PageFactory.initElements(driver, this);
		    }

		    public String validateHomePageTitle()
		    {
		        return driver.getTitle();
		    }

		    public boolean validateHomePageText()
		    {
		        return driver.getCurrentUrl().contains("dashboard");
		    }

		    public boolean validateAdmin()
		    {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.visibilityOf(admin));

		        return admin.isDisplayed();
		    }
		}