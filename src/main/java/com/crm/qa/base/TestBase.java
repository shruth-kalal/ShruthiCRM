package com.crm.qa.base; //This tells Java that TestBase belongs to com.crm.qa.base package.


import java.io.FileInputStream;   //reading your config.properties
import java.io.IOException;      //reading your config.properties
import java.util.Properties;   //reading your config.properties

import org.openqa.selenium.WebDriver;//WebDriver → interface used to control the browser.
import org.openqa.selenium.chrome.ChromeDriver;//ChromeDriver → opens Chrome browser
import org.openqa.selenium.chrome.ChromeOptions; //Chrome browser options

import io.github.bonigarcia.wdm.WebDriverManager; //automatically manages the ChromeDriver.


public class TestBase       //This is the main/base class.
           {
	//4. WebDriver variable
		public static WebDriver driver;  //creates a Selenium driver variable.
		
		//5. Properties variable
	    public static Properties prop;  //store values from your config.properties

	    
	    //6 constructor
	    public TestBase() //constructor of TestBase.
	    {
	    
	        try {
	            prop = new Properties(); //creates a Properties object.
	                
	            //7. Reading config.: tells java go to this location & open config.properties
	            FileInputStream ip = new FileInputStream(
	                "src/main/java/com/crm/qa/config/config.properties");
	                
	            //8. Load properties: This loads values from config.properties into prop.
	            prop.load(ip);
	        }
	        
	        //9. Catch block: if Java can't find/read properties file, it catches the error.
	        catch (IOException e) 
	        {
	            e.printStackTrace();//prints the error details in the Eclipse console.
	        }
	    }

	    
	    //10. Initialization method: starting the browser & opening the application.
	    public static void initialization()
	    {
	    	
	        //11. Get browser name
	        String browserName = prop.getProperty("browser");

	        
	        
	        //12 check browser
	        if (browserName.equals("chrome"))
	        {

	            //Setup ChromeDriver
	            WebDriverManager.chromedriver().setup();
	            
	            //Chrome options added for Jenkins stability
	            ChromeOptions options = new ChromeOptions();
	            options.addArguments("--disable-gpu");
	            options.addArguments("--no-sandbox");
	            options.addArguments("--disable-dev-shm-usage");
	            options.addArguments("--remote-allow-origins=*");
	            
	            //opens the Chrome browser.
	            driver = new ChromeDriver(options);
	        }

	        driver.manage().window().maximize();

	        
	        //15. Open URL---gets the URL from properties file.
	        driver.get(prop.getProperty("url"));
	    }
	}

	
/*TestBase:
 * It loads configuration values such as  1) browser
 *                                       2)  URL from the properties file,
 *                                       3) initializes the WebDriver, 
 *                                       4)launches the browser,
 *                                       5) maximizes it, 
 *                                       6)opens the application URL.
 */

