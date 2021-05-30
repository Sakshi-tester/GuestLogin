package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class ProductPage extends Base {
	
	@FindBy(css=".h1")
	WebElement productName;
	
	@FindBy(css=".btn.btn-primary.add-to-cart")
	WebElement addToCartBtn;
	
	@FindBy(linkText="Proceed to checkout")
	WebElement proceedCheckoutBtn;
	
	
	
	String productpageURL = "https://prestashop.webkul.com/ps17/ps17-moduledemo/index.php?"
			+"id_product=3&id_product_attribute=13&rewrite=the-best-is-yet-to-come-framed-poster&controller=product";
	
	public ProductPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public void goToProductPage()
	{
		driver.get(productpageURL);
	}
	
	
	
	public String getProductName()
	{
		String name =productName.getText();
		return name;
	}
	
	public void addProductToCart()
	{
		addToCartBtn.click();
	}
	
	public CheckoutPage proceedToCheckout() throws IOException
	{
		proceedCheckoutBtn.click();
		return new CheckoutPage();
	}
	

}
