package idp.hcIndia.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.LogStatus;

import idp.hcIndia.functionLibrary.CommonFunction;

public class LoginPage {

	@FindBy(xpath=".//*[@id='userRegLoginPodA']/i")
	public static WebElement userIcon;
	
	@FindBy(xpath=".//*[@id='userRegLoginPod']/div/ul/li[3]/a")
	public static WebElement loginLink;
	
	@FindBy(xpath=".//*[@id='email']")
	public static WebElement emailtxt;
	
	@FindBy(xpath=".//*[@id='password']")
	public static WebElement passwordtxt;
	
	@FindBy(xpath=".//*[@id='password_eye']")
	public static WebElement showpasswordicn;
	
	@FindBy(xpath=".//*[@id='rememberMe']")
	public static WebElement rememberMechkbox;
	
	@FindBy(xpath=".//*[@id='user']/div/span/input")
	public static WebElement loginbtn;
	
	@FindBy(xpath=".//*[@id='user']/p[1]/a")
	public static WebElement forgotpasswordlnk;
	
	@FindBy(xpath=".//*[@id='an1_register_signin']")
	public static WebElement Registerlnk;
	
	@FindBy(xpath=".//*[@id='invalidlogin_err']")
	public static WebElement invalidmsglbl;
	
	
	public static void invalidlogin() throws InterruptedException
	{
		CommonFunction.click(userIcon);
		Thread.sleep(5000);
		CommonFunction.click(loginLink);
		Thread.sleep(5000);
		CommonFunction.type(emailtxt, "ulaganathan@hctest.com");
		CommonFunction.type(passwordtxt, "world");
		Thread.sleep(5000);
		CommonFunction.click(loginbtn);
		Thread.sleep(5000);
		CommonFunction.logger.log(LogStatus.PASS,invalidmsglbl.getText());
	}
	

	public static void validlogin() throws InterruptedException
	{
		CommonFunction.click(userIcon);
		Thread.sleep(5000);
		CommonFunction.click(loginLink);
		Thread.sleep(5000);
		CommonFunction.type(emailtxt, "ulaganathan.m@hotcourses.co.in");
		CommonFunction.type(passwordtxt, "worldnathan");
		Thread.sleep(5000);
		CommonFunction.click(loginbtn);
		Thread.sleep(5000);
		CommonFunction.gettitle().toString();
		CommonFunction.logger.log(LogStatus.PASS,invalidmsglbl.getText());
	}


	@DataProvider(name = "Authentication")
	 
	  public static Object[][] credentials() {
	 
	        return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};
	 
	  }

}
