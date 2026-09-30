package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	Properties p;
	Logger logger;
	
	public static WebDriver driver;
	
	@Parameters({"os", "br"})
	@BeforeClass(groups="BaseClass")
	
	public void setUp(String os, String br) throws IOException {
		
		//Initializing BaseClass Setup
		logger = LogManager.getLogger(this.getClass());
		logger.info("Base Class Initialized");
		
		
		//Reding config.properties file
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		//Open incognito
		
		//Chrome options to open incognito
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				
				switch(br.toLowerCase()) {
				case "chrome":
					driver = new ChromeDriver(options);
					break;
				case "edge":
					driver = new EdgeDriver();
					break;
				case "firefox":
					driver = new FirefoxDriver();
					break;
				}
				
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				driver.get(p.getProperty("url"));
				driver.manage().window().maximize();
		
	}
	
	@AfterClass
	
	public void tearDown() {
		driver.quit();
	}
	
	//Screenshot for when test case failed
	public String captureScreen(String tname) {
		
		String timeStamp = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+ tname +"_"+timeStamp+".png";
		File targetFile = new File(targetFilePath) ;
		
		sourceFile.renameTo(targetFile);
		return targetFilePath;		
	}

}
