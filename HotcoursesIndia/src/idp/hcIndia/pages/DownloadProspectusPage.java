package idp.hcIndia.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import idp.hcIndia.functionLibrary.CommonFunction;
import idp.hcIndia.utilities.FilePath;

public class DownloadProspectusPage {
	@FindBy(xpath=".//*[@id='fstname']")
	public static WebElement firstnametxt;
	
	@FindBy(xpath=".//*[@id='lstname']")
	public static WebElement lastnametxt;

	@FindBy(xpath=".//*[@id='confirmEmailId']")
	public static WebElement emailtxt;

	@FindBy(xpath=".//*[@id='yournationality']")
	public static WebElement yourCountrydrpdown;
	
	@FindBy(xpath=".//*[@id='cat2']")
	public static WebElement studyLeveldrpdown;
	
	@FindBy(xpath=".//*[@id='ldcscode']/span")
	public static WebElement subjectdrpdown;

	@FindBy(xpath=".//*[@id='dobDate']")
	public static WebElement datedrpdown;

	@FindBy(xpath=".//*[@id='dobMonth']")
	public static WebElement monthdrpdown;

	@FindBy(xpath=".//*[@id='yearOfBirth']")
	public static WebElement yeartxt;
	
	@FindBy(xpath=".//*[@id='monthRange']")
	public static WebElement preferredIntakeYeardrpdown;
	
	@FindBy(xpath=".//*[@id='subscribe']")
	public static WebElement termsAndCondidtionschkbox;

	@FindBy(xpath=".//*[@id='dp_list']/div[1]/div/div[2]/a")
	public static WebElement downloadnowbtn;
	
	@FindBy(xpath=".//*[@id='enquirydiv']/fieldset[3]/div/div[2]/a[1]")
	public static WebElement termsAndCondlink;
	
	@FindBy(xpath="..//*[@id='enquirydiv']/fieldset[3]/div/div[2]/a[2]")
	public static WebElement privacyPolicylink;

	@FindBy(xpath=".//*[@id='ULstudylevelid']/li[1]/a")
	public static WebElement studyLevelone;
	
	public static void downloadProsnewuser() throws IOException, InterruptedException
	{
	
		try {
		String Firstname=downloadprosUserData("Firstname");
		String Lastname=downloadprosUserData("Lastname");
		String Email=downloadprosUserData("Email");
		String Yourcountry=downloadprosUserData("Yourcountry");
		String Studylevel=downloadprosUserData("StudyLevel");
		String Subject=downloadprosUserData("Subject");
		String Date=downloadprosUserData("Date");
		String Month=downloadprosUserData("Month");
		String Year=downloadprosUserData("Year");
		String IntakeYear=downloadprosUserData("IntakeYear");
		
		CommonFunction.type(firstnametxt, Firstname);
		CommonFunction.type(lastnametxt, Lastname);
		CommonFunction.type(emailtxt, Email);
		//CommonFunction.selectDropdown(yourCountrydrpdown, Yourcountry);
		Thread.sleep(5000);
		CommonFunction.driver.findElement(ById.id("styLvl")).click();
		Thread.sleep(5000);
		CommonFunction.click(studyLevelone);
		}
		catch(ElementNotVisibleException env)
		{
			System.out.println("Element not found exception");
		}
		}
	
	public static String downloadprosUserData(String name) throws IOException
	{
		FileInputStream SignupInput=new FileInputStream(FilePath.enqandDPInput);
		Properties enqDPInput=new Properties();
		enqDPInput.load(SignupInput);
		return enqDPInput.getProperty(name);
		
	}
}
