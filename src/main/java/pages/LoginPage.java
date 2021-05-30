package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class LoginPage extends Base{
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="submit_login")
	WebElement submitBtn;
	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	
	public BackHomePage validateLogin(String un, String pwd) throws IOException
	{
		
		email.sendKeys(un);
		password.sendKeys(pwd);
		submitBtn.click();
		return new BackHomePage();
		
	}
}
