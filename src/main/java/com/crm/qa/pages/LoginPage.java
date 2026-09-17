package com.crm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;   //@FindBy is used to locate web elements.
import org.openqa.selenium.support.PageFactory;  // initializes the elements declared using @FindBy.
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;


//3. Class declaration
public class LoginPage extends TestBase//means LoginPage can access variables/methods from TestBase,
{
	
	//4. Username element:  finds the username textbox 
      @FindBy(name = "username")   //Selenium identifies the element and stores it
	    WebElement username;         

	    @FindBy(name = "password")
	    WebElement password;

	    @FindBy(xpath = "//button[@type='submit']")
	    WebElement loginBtn;

	    
	    //login text: This finds the heading:
	    @FindBy(xpath = "//h5[text()='Login']")   //inside an <h5> tag.:veify login page is displayed

	    WebElement loginText;

	    
	    
	    //8. Constructor:constructor of LoginPage.
	    public LoginPage() 
	    {
	        PageFactory.initElements(driver, this); //It initializes all the @FindBy elements:
	    }

	    
	    
	    //9. Validate Login Page Title
	    public String validateLoginPageTitle()
	    {
	        return driver.getTitle();
	    }

	    
	    
	    public boolean validateLoginText()
	    {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        wait.until(ExpectedConditions.visibilityOf(loginText));

	        return loginText.isDisplayed();
	    }

	    
	    //11. Login method:It accepts two parameters:
	    
	    public void login(String un, String pwd) 
	    {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        wait.until(ExpectedConditions.visibilityOf(username));

	        username.sendKeys(un);
	        password.sendKeys(pwd);
	        loginBtn.click();
	    }
	}
	