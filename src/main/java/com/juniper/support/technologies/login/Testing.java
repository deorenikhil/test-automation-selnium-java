package com.juniper.support.technologies.login;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class Testing {

	
    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    	//System.setProperty("webdriver.firefox.marionette","/Users/ndeore/Documents/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		//System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
    	System.out.println("Here1");
       // String baseUrl = "http://demo.guru99.com/test/newtours/";
        //String baseUrl = "http://staging-aswb.juniper.net";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        
        
        
       
        //close Fire fox
        //driver.close();
       
    }
	@Test
	public void test() {
		WebDriver driver = new FirefoxDriver();
		
        // launch Fire fox and direct it to the Base URL
       
        
       
		
	}

}
