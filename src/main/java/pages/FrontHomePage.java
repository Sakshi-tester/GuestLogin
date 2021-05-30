package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class FrontHomePage extends Base {

	@FindBy(css="input[type='text']")
	WebElement searchBox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement search;
	
	@FindBy(css=".product-miniature.js-product-miniature")
	WebElement product;
	
	String frontURL = "https://prestashop.webkul.com/ps17/ps17-moduledemo/index.php";
	
	
	public FrontHomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	//Go to front homepage
	public void goToHomePage()
	{
		driver.get(frontURL);
	}
	
	public ProductPage getProductPage() throws IOException
	{
		//searchBox.click();
		//searchBox.sendKeys("Mug");
		product.click();
		//search.click();
		return new ProductPage();
				
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
