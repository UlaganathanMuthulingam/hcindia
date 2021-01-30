package idp.hcIndia.testScript;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import idp.hcIndia.functionLibrary.CommonFunction;
import idp.hcIndia.pages.DownloadProspectusListPage;
import idp.hcIndia.pages.LoginPage;

public class Login {
	
	@BeforeMethod 
	public void launchApp() throws IOException
	{
		CommonFunction.openBrowser();
	}
	@AfterMethod
	public void closeBrowser()
	{
		CommonFunction.closeApp();
	}
	
	
	
	@Test
	public void login() throws InterruptedException
	{
		LoginPage l1=PageFactory.initElements(CommonFunction.driver, LoginPage.class);
		//l1.invalidlogin();
		l1.validlogin();
	}

}
