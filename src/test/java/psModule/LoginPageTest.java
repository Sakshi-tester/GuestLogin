package psModule;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pages.LoginPage;
import resources.Base;

public class LoginPageTest extends Base{
	LoginPage lp;
	public WebDriver driver;

	
	private static final Logger log = LogManager.getLogger(LoginPageTest.class.getName());
	
	public LoginPageTest() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		 driver= initializeDriver();
		 lp = new LoginPage();
	}
	
	@Test
	public void checkLogin() throws IOException
	{
		
		  lp.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		  log.info("Successfully logged in");    	
	}
		
	 @AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
		
	
	
	
	
		
	}
