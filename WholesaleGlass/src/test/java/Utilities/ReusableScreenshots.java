package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import TestBase.BaseClass;

public class ReusableScreenshots
{

	public static String screenshot(String testName) throws IOException, InterruptedException 
	{
		Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = new String("./screenshots/" + testName + ".png");
		FileUtils.copyFile(source, new File(destination));
		return destination;

	}
	
	public static String instantscreenshot(String testName) throws IOException, InterruptedException 
	{
		TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = new String(".//screenshots//" + testName + ".png");
		FileUtils.copyFile(source, new File(destination));
		return destination;

	}
}
