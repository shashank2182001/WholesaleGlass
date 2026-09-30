package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;

public class ReusableJavascriptExecutor {
	
	public JavascriptExecutor js;
	
	public ReusableJavascriptExecutor(WebDriver driver) 
	{
		this.js = (JavascriptExecutor) driver;
	}
	
	public void jsClick(WebElement element) 
	{
		js.executeScript("arguments[0].click()", element);
	}
	
	public void jsScroll(WebElement element) 
	{
		js.executeScript("arguments[0].scrollIntoView({block:'center'})", element );
	}
	
	public void jsSlider(WebElement element, String value)
	{
		js.executeScript(String.format("arguments[0].value='%s';",value)+
				"arguments[0].dispatchEvent(new Event('input'));" +
				"arguments[0].dispatchEvent(new Event('change'));"+"arguments[0].scrollIntoView({block:'center'})"
				,element);
	}
}
