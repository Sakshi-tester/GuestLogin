package psModule;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BackHomePage;
import pages.LoginPage;
import resources.Base;

public class BackHomePageTest extends Base {
	public WebDriver driver;
    LoginPage lp;
	static BackHomePage bp;
	private static final Logger log = LogManager.getLogger(BackHomePageTest.class.getName());

	
	public BackHomePageTest() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		 driver= initializeDriver();
		 lp = new LoginPage();
		 bp = new BackHomePage();
		 lp.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test()
	
	public void verifyTabClick() throws IOException 
	{
		
		bp.clickModTab();
		log.debug("Module button is clicked successfully");

		bp.searchModule(prop.getProperty("module"));
		log.info("Successfully searched module by name");

		bp.configModule();
		log.info("Successfully configured module");	
	}
	
	@AfterMethod
	
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	

}
