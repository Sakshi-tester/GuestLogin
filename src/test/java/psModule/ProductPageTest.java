package psModule;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pages.ProductPage;
import resources.Base;

public class ProductPageTest extends Base {
    ProductPage pp;
    ProductPageTest pt;
	public WebDriver driver;

    
    private static final Logger log = LogManager.getLogger(ProductPageTest.class.getName());
	
	
	public ProductPageTest() throws IOException {
		super();	
	}
	
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		  driver = initializeDriver();
		  pp= new ProductPage();
		  pt = new ProductPageTest();
		  pp.goToProductPage();
		  
	}
	
	@Test
	public void addProductToCart()
	{
		log.info("Product added to the cart");
		pp.addProductToCart();
		pp.addProductToCart();
	}
	
	 @AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
		
	
	
}
