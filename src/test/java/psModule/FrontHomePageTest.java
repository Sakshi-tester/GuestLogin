package psModule;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FrontHomePage;
import resources.Base;
import resources.Utility;



public class FrontHomePageTest extends Base {
	public WebDriver driver;
	FrontHomePage fpt;
    Utility u;
	
	private static final Logger log = LogManager.getLogger(FrontHomePageTest.class.getName());
	
	public FrontHomePageTest() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		  driver= initializeDriver();
		  fpt= new FrontHomePage();
		  
		  fpt.goToHomePage();
		
		u.scrollWebPage();
			  
	}
	
	@Test
	
	public void verifyGuestLoginBtn() throws IOException
	{
		
		fpt.getProductPage();
		log.info("Redirected to product page");
		
	}
	
	 @AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
		
	
}
