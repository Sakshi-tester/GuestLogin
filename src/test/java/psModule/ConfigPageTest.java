package psModule;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BackHomePage;
import pages.ConfigPage;
import pages.LoginPage;
import resources.Base;

public class ConfigPageTest extends Base {
	
	public WebDriver driver;
	LoginPage lp;
	BackHomePage bp;
	ConfigPage cp;
	private static final Logger log = LogManager.getLogger(ConfigPageTest.class.getName());

	
	public ConfigPageTest() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		 driver = initializeDriver();
		 lp = new LoginPage();
		 bp = new BackHomePage();
		 cp = new ConfigPage();
		 lp.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		 bp.clickModTab();
		 bp.searchModule(prop.getProperty("module"));
		 bp.configModule();
		
	}
	
	
	@Test(priority=1)
	
	public void verifyConfigPage() throws IOException
	{
		 
		Assert.assertEquals("CONFIGURATION", cp.verifyPageHeading());
		log.info("Successfully verify Heading of Config page");
	}
	
	@Test(priority=2)
	
	public void validateGuestLoginBtn() throws IOException
	{
		cp.viewShop();
		log.info("Navigated to Front end");

		
	}
	/*@Test(priority=3)
	
	public void validateDisableBtn()
	{
		log.debug("Disable module from config page");
		cp.disableModule();
		log.debug("Successfully disabled module at config page");
	}
	*/
   @AfterMethod
	
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	

}
