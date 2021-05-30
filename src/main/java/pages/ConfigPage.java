package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class ConfigPage extends Base{
	
	@FindBy(css=".panel-heading")
	WebElement configPageHeading;
	
	@FindBy(id="header_shopname")
	WebElement viewShopBtn;
	
	@FindBy(xpath="//label[contains(text(),'No')]")	
	WebElement disableBtn;
	
	@FindBy(id="module_form_submit_btn")
	WebElement saveBtn;
	
	@FindBy(css=".alert.alert-success")
	WebElement grabMsg;

	public ConfigPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageHeading()
	{
		String heading= configPageHeading.getText();
		return heading;
	}
	
	public FrontHomePage viewShop() throws IOException
	{
		viewShopBtn.click();
		return new FrontHomePage();
	}
	
	public void disableModule()
	{
		disableBtn.click();
		saveBtn.click();
		
	}
	

}
