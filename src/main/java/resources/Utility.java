package resources;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import resources.Base;

public class Utility extends Base {
	public static String screenshotpath;
	
	
	public void scrollWebPage() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		
	}
	
	public static String getScreenshotPath(String screenshotName, WebDriver driver) throws IOException
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {

            //Create unique file name and store in under screenshot folder of root directory
            screenshotpath = "./Screenshots/"+screenshotName+".png";
            
            //Copy the file to destination
           FileHandler.copy(scrFile, new File(screenshotpath));
            System.out.println("Screenshot taken");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            

		
		
		
		
		/*TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(source, new File("./Screenshots/"+screenshotName+".png"));
		System.out.println("Screenshot taken");
		return screenshotName;
	*/
		
	}
	return screenshotpath;
	}}
	
	
	


