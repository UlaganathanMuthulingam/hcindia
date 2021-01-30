package idp.hcIndia.testScript;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import idp.hcIndia.functionLibrary.CommonFunction;
import idp.hcIndia.pages.DownloadProspectusListPage;
import idp.hcIndia.pages.DownloadProspectusPage;

public class DownloadProspectus {

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

	@Test
	public static void dplistregression() throws InterruptedException, IOException,ElementNotVisibleException
	{
		DownloadProspectusListPage p1=PageFactory.initElements(CommonFunction.driver, DownloadProspectusListPage.class);
		DownloadProspectusPage p2=PageFactory.initElements(CommonFunction.driver, DownloadProspectusPage.class);
		p1.DPlist();
		p2.downloadProsnewuser();
		
	}


}
