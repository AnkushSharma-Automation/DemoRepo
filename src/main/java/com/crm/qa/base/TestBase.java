package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;


public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	
	public TestBase(){
		
		
		// Create the Object of Properties class 	
		try {		
		
		prop = new Properties();

		// Create the Object of FileInputStream class and pass the location of the file 
		FileInputStream ip = new FileInputStream("C:\\Users\\Ankush Sharma\\eclipse-workspace\\new\\FreeCRM\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			
		// .load method to load the config properties file
		prop.load(ip);
		
				
		// Handle Exceptions 			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		// Create a method to Initi..
		public static void  initilization() {
		
		// read the properties by prop.getproperty method 
		String  browserName = prop.getProperty("browser");
			
		// Conditon : if the browser is prop file is chrome the set the system prop
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\googlecrome\\chromedriver.exe");
			driver =new ChromeDriver();
		}
		else if(browserName.equals("FF")) {
			 System.setProperty("webdriver.gecko.driver", "C:\\googlecrome\\geckodriver.exe");
			 driver =new FirefoxDriver(); 
		   }
		
	
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
			
		
		
		
		
		// setting the browser prop for chrome	
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// Created the class under com.crm.qa.util for handling the timeouts  TestUtil.PAGE_LOAD_TIMEOUT/TestUtil.IMPLICIT_WAIT
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		// Launching the url from Prop file 
		driver.get(prop.getProperty("url"));
		
		}
	
	
	
}
