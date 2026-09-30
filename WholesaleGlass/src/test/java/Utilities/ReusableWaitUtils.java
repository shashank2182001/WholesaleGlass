package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableWaitUtils {

	public WebDriverWait wait ;

	public ReusableWaitUtils(WebDriver driver, int time) 
	{
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	}


	// wait and click 
	public void  elementToBeClickable(WebElement element) 
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	//wait 
	public void elementToBeClickableWait(WebElement element) 
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	//visibility
	public void visibilityOf(WebElement menuDropdowns) 
	{
		wait.until(ExpectedConditions.visibilityOf(menuDropdowns));
	}

	//text
	public void textToBePresentInElement(WebElement element, String text) 
	{
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	//stale
	public void staleClick(WebElement element) 
	{
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}
		catch(Exception e )
		{
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element))).click();
		}
	
	
	}




}
