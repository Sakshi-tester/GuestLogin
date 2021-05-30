package psModule;

import java.io.IOException;

import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ProductPage;
import resources.Base;

public class CheckoutPageTest extends Base {
	 CheckoutPage cp;
	 ProductPage pp;
	 CheckoutPageTest cpt;
	 
	 public WebDriver driver;

	
	 private static final Logger log = LogManager.getLogger(CheckoutPageTest.class.getName());
	
	
	public CheckoutPageTest() throws IOException {
		super();	
	}
	
	
	@BeforeClass
	public void setUp() throws IOException, InterruptedException
	{
	
		driver= initializeDriver();
		pp = new ProductPage();
		pp.goToProductPage();
		pp.addProductToCart();
		cp = new CheckoutPage();
		cpt= new CheckoutPageTest();
		Thread.sleep(3000);
	   
	
	}
	
	@Test(priority=1)
	
	public void verifyCreateAccountBtn() throws InterruptedException
	{
		cp.goToCheckoutPage();
		log.info("Landed to the checkout page");
		cp.personalInfo("abc", "abc","sakshigupta.tester150@webkul.com");
		log.info("Successfully entered information");
		cp.addAddress("123, main street", "India", "201 231", "noida", "Assam");
		log.info("Successfully entered address");
		cp.shippingMethod();
		log.info("Redirected to the shipping method ");

		cp.paymentMethod();
		log.info("Redirected to the payment method ");

		//click and verify on create new account button
		cp.getnewAccount();
		log.info("Successfully validated create new account button ");

	}
	
	@Test(priority=2)
	
	public void verifyMailSentText() throws InterruptedException
	{
		
		Thread.sleep(2000);
		Assert.assertEquals("Please check your email to change your password", cp.getMailText());
		log.error("Getting incorrect message after clicking button");

	}
		
	
	    @AfterClass
		public void tearDown()
		{
			driver.quit();
		}
		
	
	
	
	
	
	

}
