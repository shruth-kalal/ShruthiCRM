package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
//import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase

{
	
	
	    LoginPage loginPage;
	    HomePage homePage;
	   // TestUtil testUtil;

	    public HomePageTest() 
	    {
	        super();
	    }

	    //test case should be separated--independent with each other
	    //before each t.c---launch browser &login
	    //@test---execute t.c
	    //after t.c---close browser
	    /*1)@beforeMethod
	     * @test1
	     * @AfterMethod
	     * 
	     * 
	     * 2)@beforeMethod
	     * @test2
	     * @AfterMethod
	     */
	    @BeforeMethod
	    public void setUp()
	    {
	        initialization();
            //testUtil = new TestUtil();
	        loginPage = new LoginPage();

	        loginPage.login(
	            prop.getProperty("username"),
	            prop.getProperty("password"));
	        

	        homePage = new HomePage();
	    }

	    
	    
	    @Test(priority = 1)
	    public void homePageTitleTest() 
	    {

	        String title = homePage.validateHomePageTitle();

	        System.out.println("Home Page Title: " + title);

	        Assert.assertEquals(title, "OrangeHRM");
	    }

	    
	    
	    @Test(priority = 2)
	    public void homePageTextTest() 
	    {
	        boolean flag = homePage.validateHomePageText();

	        Assert.assertTrue(flag);
	    }
	    
	    

	    @Test(priority = 3)
	    public void adminTest()
	    {

	        boolean flag = homePage.validateAdmin();

	        Assert.assertTrue(flag);
	    }
	    
	    

	    @AfterMethod
	    public void tearDown() {

	        driver.quit();
	    }
	}
	