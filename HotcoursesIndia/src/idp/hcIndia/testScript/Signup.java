package idp.hcIndia.testScript;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import idp.hcIndia.functionLibrary.CommonFunction;
import idp.hcIndia.pages.SignupPage;

public class Signup {

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
	
	@Test (enabled=true)
	public void testSuccessfulLogin() throws IOException
	{
	try
	{
		SignupPage signup=PageFactory.initElements(CommonFunction.driver, SignupPage.class);
		signup.logIn();
		Thread.sleep(5000);
	CommonFunction.captureScreenshot("TestSuccessfulLogin_Pass");
	}
	catch(Exception e)

	{
	System.out.println("Test failed:"+e);
	CommonFunction.captureScreenshot("TestSuccessfulLogin_Fail");
}
}

}
