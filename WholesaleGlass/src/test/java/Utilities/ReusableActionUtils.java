package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ReusableActionUtils {
	
	Actions actions;
	
	public ReusableActionUtils (WebDriver driver) 
	{
		this.actions = new Actions(driver);
	}

	//hover action
	public void hoverOverElement(WebElement element) {
		actions.moveToElement(element).perform();
	}
	
	//double click
	public void doubleClickOnElement(WebElement element) {
		actions.doubleClick(element).perform();
	}
	
	//right click/context click
	public void rightClickTheElement(WebElement element) {
		actions.contextClick(element).perform();
	}
	
	//left click
	public void clickOnElement(WebElement element) {
		actions.moveToElement(element).click().perform();
	}
	
	//click hold and release the element
	
	public void clickHoldAndReleaseElement(WebElement element) {
		
		actions.clickAndHold(element).perform();
		//Now release the element
		actions.release(element).perform();
		
	}
	
	// drag and drop the element
	
	public void dragAndDrop(WebElement source, WebElement target) {
		actions.dragAndDrop(source, target).perform();
	}

}
