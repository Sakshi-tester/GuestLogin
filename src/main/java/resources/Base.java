package resources;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.google.common.io.Files;



public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Sakshi\\eclipse-workspace\\PSGuestLogin\\src\\main\\java\\resources\\config.properties");
		prop.load(fis);
		
	 String browserName = prop.getProperty("browser");
	 
	 if(browserName.equals("chrome"))
	 {
		 System.setProperty("webdriver.chrome.driver","D:\\Selenium\\selenium-java-3.141.59\\chromedriver.exe");
			driver = new ChromeDriver();
	 }
	 else if(browserName.equals("firefox")) 
	 {
		 
	 }
	    driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	

	
	}
	
	
	


