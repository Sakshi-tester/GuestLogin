package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.Base;

public class CheckoutPage extends Base {
	WebDriverWait wait;
	String txt= "Order as a guest";
	
	@FindBy(css="a.btn.btn-primary")
	WebElement proceedCheckout;
	
	@FindBy(css=".nav-link.active")
	WebElement guesttext;
	
	@FindBy(name="firstname")
	WebElement firstName;
	
	@FindBy(name="lastname")
	WebElement lastName;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="psgdpr")
	WebElement checkbox;
	
	@FindBy(name="continue")
	WebElement continueBtn;
	
	@FindBy(name="address1")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="id_country")
	WebElement country;
	
	@FindBy(name="id_state")
	WebElement dropDown;
	
	@FindBy(name="confirm-addresses")
	WebElement confrmAddress;
	
	@FindBy(name="postcode")
	WebElement zipcode;
	
	@FindBy(name="confirmDeliveryOption")
	WebElement confrmShipping;
	
	@FindBy(id="payment-option-1")
	WebElement selectPayment;
	
	@FindBy(id="conditions_to_approve[terms-and-conditions]")
	WebElement checkBox;
	
	@FindBy(css=".btn.btn-primary.center-block")
	WebElement confirmBtn;
	
	@FindBy(id="wkgetnewacc")
	WebElement newAccountBtn;
	
	@FindBy(css="div.alert.alert-success")
	WebElement mailText;
	
	String checkoutPageURL = "https://prestashop.webkul.com/ps17/ps17-moduledemo/index.php?"
			+"controller=cart&action=show";
	
	
	
	public CheckoutPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public void goToCheckoutPage()
	{
		
	    driver.get(checkoutPageURL);	
	}
	
	
	public void personalInfo(String first, String Last, String Email)
	{
		proceedCheckout.click();
		String text= guesttext.getText();
		
		if(txt.equals(text))
		{
			firstName.sendKeys(first);
			lastName.sendKeys(Last);
			email.sendKeys(Email);
			checkbox.click();
			continueBtn.click();	
		}
		else
		{
			System.out.println("Match not found");
		}
	}
	
	public void addAddress(String Address, String Country, String Zipcode, String City, String State) throws InterruptedException
	{
		
		address.sendKeys(Address);
		Select select = new Select(country);
		select.selectByVisibleText(Country);
		city.sendKeys(City);
		zipcode.sendKeys(Zipcode);
		Thread.sleep(3000);
		Select s = new Select(dropDown);
		Thread.sleep(3000);
		s.selectByVisibleText(State);
		confrmAddress.click();	
		
	}
	
	public void shippingMethod()
	{
		confrmShipping.click();	
		
	}
	
	public void paymentMethod()
	{
		selectPayment.click();
		checkBox.click();
		confirmBtn.click();
	
	}
	
	public void getnewAccount()
	{
		newAccountBtn.click();
	}
	
	public String getMailText()
	{
		String txt= mailText.getText();
		return txt;
	}
	

}
