package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

	
public class LoginPageTest extends TestBase
     {
	LoginPage loginPage;

	
    public LoginPageTest()
    {
        super();
    }

    
    
    @BeforeMethod
    public void setUp() 
    {
        initialization();

        loginPage = new LoginPage();
    }

    
    
    @Test(priority = 1)
    public void loginPageTitleTest() 
    {

        String title = loginPage.validateLoginPageTitle();

        System.out.println("Page Title: " + title);

        Assert.assertEquals(title, "OrangeHRM");
    }
    

    @Test(priority = 2)
    public void loginTextTest()
    {

        boolean flag = loginPage.validateLoginText();

        Assert.assertTrue(flag);
    }
    
    

    @Test(priority = 3)
    public void loginTest()
    {

        loginPage.login(
            prop.getProperty("username"),
            prop.getProperty("password")
        );

        System.out.println("Login successful");
    }
    
    

    @AfterMethod
    public void tearDown() 
    {

        driver.quit();
    }
}
