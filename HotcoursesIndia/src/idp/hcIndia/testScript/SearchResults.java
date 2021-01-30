package idp.hcIndia.testScript;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import idp.hcIndia.functionLibrary.CommonFunction;
import idp.hcIndia.pages.SearchResultsPage;

public class SearchResults {
	@BeforeClass
	 public void initializeReport() {
	  
		CommonFunction.report = new ExtentReports(new File("src/idp/hcIndia/testReports").getAbsolutePath() + "\\" +CommonFunction.dateformat.format(CommonFunction.date) + "_TestReport.html");
	  //Adding system info
	  CommonFunction.report.addSystemInfo("OS", "WINDOWS");
	  CommonFunction.report.addSystemInfo("BROWSER", "CHROME");
	  CommonFunction.report.addSystemInfo("PROJECT_NAME", "HCV");
	  
	 }
	@AfterClass
	public void closeReport()
	{
		CommonFunction.report.endTest(CommonFunction.logger);
		CommonFunction.report.flush();
		
	}
	
	@BeforeMethod
	public void openbrow() throws IOException
	{
		CommonFunction.openBrowser();
	}
	
	@AfterMethod
	public void closebrow()
	{
		CommonFunction.closeApp();
	}
	
	@Test (enabled=true)
	public void searchresultchecking() throws IOException, InterruptedException
	{
		SearchResultsPage SearchResults=PageFactory.initElements(CommonFunction.driver, SearchResultsPage.class);
		SearchResults.L1Search();
		Thread.sleep(5000);
	CommonFunction.captureScreenshot("TestSuccessfulLogin_Pass");
	}

}
	

