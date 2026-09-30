package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.BaseClass;

public class extentReportManager implements ITestListener {

	    public ExtentSparkReporter sparkReporter;
	    public ExtentReports extent;
	    public ExtentTest test;
	    String repName;

	    @Override
	    public void onStart(ITestContext testContext) {

	        String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date());
	        repName = "Test-Report-" + timeStamp + ".html";

	        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);
	        sparkReporter.config().setDocumentTitle("Automation Report");
	        sparkReporter.config().setReportName("Functional Testing");
	        sparkReporter.config().setTheme(Theme.DARK);

	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test = extent.createTest(result.getMethod().getMethodName());
	        test.assignCategory(result.getMethod().getGroups());
	        test.log(Status.PASS, "Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        test = extent.createTest(result.getMethod().getMethodName());
	        test.assignCategory(result.getMethod().getGroups());
	        test.log(Status.FAIL, "Test Failed");
	        test.log(Status.INFO, result.getThrowable().getMessage());

	        try {
	            BaseClass base = (BaseClass) result.getInstance();
	            String imgPath = base.captureScreen(result.getMethod().getMethodName());
	            test.addScreenCaptureFromPath(imgPath);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test = extent.createTest(result.getMethod().getMethodName());
	        test.assignCategory(result.getMethod().getGroups());
	        test.log(Status.SKIP, "Test Skipped");
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	        String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName; 			//change the path for other folder
		    File extentReport = new File(pathOfExtentReport);
		    try 
		    {
		    	Desktop.getDesktop().browse(extentReport.toURI());
		    }
		    catch(IOException e )
		    {
		    	e.printStackTrace();
		    }

	    }
	}


