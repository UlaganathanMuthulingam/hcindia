package idp.hcIndia.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import idp.hcIndia.functionLibrary.CommonFunction;
import idp.hcIndia.utilities.FilePath;

public class SignupPage {


	@FindBy(xpath=".//*[@id='userRegLoginPodA']/i")
	public WebElement userIcon;
	
	@FindBy(xpath=".//*[@id='userRegLoginPod']/div/ul/li[4]/a")
	public WebElement signupLnk;
	
	@FindBy(xpath=".//*[@id='firstName']")
	public WebElement firstNametxt;
	
	@FindBy(xpath=".//*[@id='lastName']")
	public WebElement lastNametxt;
	
	@FindBy(xpath=".//*[@id='email']")
	public WebElement emailTxt;
	

	@FindBy(xpath=".//*[@id='countryCode']")
	public WebElement ctyCodedrp;
	

	@FindBy(xpath=".//*[@id='registration']/fieldset[3]/div[2]/label")
	public WebElement mobileNumbertxt;
	

	@FindBy(xpath=".//*[@id='cityName']")
	public WebElement cityTxt;
	

	@FindBy(xpath=".//*[@id='password']")
	public WebElement passwordTxt;
	

	@FindBy(xpath=".//*[@id='qualCode']")
	public WebElement studyleveldrp;
	

	@FindBy(xpath=".//*[@id='monthRange']")
	public WebElement intakeYeardrp;
	

	@FindBy(xpath=".//*[@id='dobDate']")
	public WebElement datedrp;
	

	@FindBy(xpath=".//*[@id='dobMonth']")
	public WebElement monthdrp;
	

	@FindBy(xpath=".//*[@id='dobYear']")
	public WebElement yeartxt;
	
	
public void logIn() throws InterruptedException, IOException
{
	
	String FirstName=signUpTestData("FirstName");
	String LastName=signUpTestData("LastName");
	String Email=signUpTestData("Email");
	String Countrycode=signUpTestData("Countrycode");
	String MobileNumber=signUpTestData("MobileNumber");
	String City=signUpTestData("City");
	String Password=signUpTestData("Password");
	String StudyLevel=signUpTestData("StudyLevel");
	String IntakeYear=signUpTestData("IntakeYear");
	String Date=signUpTestData("Date");
	String Month=signUpTestData("Month");
	String Year=signUpTestData("Year");
	CommonFunction.click(userIcon);
	CommonFunction.click(signupLnk);
	Thread.sleep(5000);
	System.out.println();
	CommonFunction.type(firstNametxt,FirstName);
	Thread.sleep(5000);
	CommonFunction.type(lastNametxt, LastName);
	Thread.sleep(5000);
	CommonFunction.type(emailTxt, Email);
	Thread.sleep(5000);
	CommonFunction.selectDropdown(ctyCodedrp,Countrycode);
	Thread.sleep(5000);
	CommonFunction.type(mobileNumbertxt,MobileNumber);
	
}	

public static String signUpTestData(String name) throws IOException
{
	FileInputStream SignupInput=new FileInputStream(FilePath.signupInput);
	Properties input=new Properties();
	input.load(SignupInput);
	return input.getProperty(name);
	
}

public static String homePageElements(String name) throws IOException
{
	FileInputStream homepageElement=new FileInputStream(FilePath.homepageElements);
	Properties input=new Properties();
	input.load(homepageElement);
	return input.getProperty(name);
	
}

}

