package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utilities.ReusableActionUtils;
import Utilities.ReusableJavascriptExecutor;
import Utilities.ReusableWaitUtils;

public class BasePage {
	
	WebDriver driver;
	ReusableJavascriptExecutor js;
	ReusableWaitUtils wait;
	ReusableActionUtils act;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
		this.js = new ReusableJavascriptExecutor(driver);
		this.wait = new ReusableWaitUtils(driver, 15);
		this.act  = new ReusableActionUtils(driver);
		
		
	}

}
