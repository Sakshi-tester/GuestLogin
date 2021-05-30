package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class BackHomePage extends Base{
	
	@FindBy(id="subtab-AdminParentModulesSf")
	WebElement moduleTab;
	
	@FindBy(xpath="//a[contains(text(),'Module Manager')]")
	WebElement moduleManagerTab;
	
	@FindBy(css=".pstaggerAddTagInput ")
	WebElement modSearchBox;
	
	@FindBy(id="module-search-button")
	WebElement searchBtn;
	
	@FindBy(css=".btn-group.module-actions")
	WebElement configureBtn;
	
	
	public BackHomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickModTab()
	{
		moduleTab.click();
		moduleManagerTab.click();
		
		
	}
	
	public void searchModule(String modName)
	{
		modSearchBox.sendKeys(modName);
		searchBtn.click();
	}
	
	
	public ConfigPage configModule() throws IOException
	{
		configureBtn.click();
		return new ConfigPage();
	}
	
	
	
	

}
