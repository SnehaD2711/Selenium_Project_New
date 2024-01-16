package com.Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;


public class baseClass 
{
	
	public WebDriver driver;		//globally declare the WebDriver class object
	
	public Properties prop;
	public void initializeDriver() throws IOException
	{
		//to read the data from the pr
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\Resources\\data.properties");
																	//user.dir="F:\\eclipse_project\\selenium-framework-project"
		//to access the properties file---->to evoke the browser
		//Properties prop=new Properties();
		prop=new Properties();
		prop.load(fis);
		
	
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
	}
	@BeforeClass
	
	public void launchBrowser() throws IOException 
	{
		
		initializeDriver() ;
		driver.get(prop.getProperty("url"));
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}
	

	public String generateRandomEmail() 
	{ 
		 return System.currentTimeMillis()+"@gmail.com"; 
	}
	 

}
