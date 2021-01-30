package idp.hcIndia.pages;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import idp.hcIndia.functionLibrary.CommonFunction;

public class DownloadProspectusListPage {
	
	
	@FindBy(xpath=".//*[@id='drop4']")
	public static WebElement Countrydrpdown;
	
	@FindBy(xpath=".//*[@id='dp_list']/div[1]/div/div[2]/a")
	public static WebElement DownloadProspectusbtn;

	@FindBy(xpath=".//*[@id='menu1']/li[7]/a")
	public static WebElement CountryUKdrpdown;
	
	@FindBy(xpath=".//*[@id='srch']/div/div/div/h1")
	public static WebElement DPlistpagetitle;
	
	
	public static void DPlist() throws InterruptedException
	{	
		CommonFunction.driver.get("https://www.hotcoursesabroad.com/india/international/university-prospectus.html");
		Thread.sleep(5000);
		CommonFunction.logger=CommonFunction.report.startTest("Download Prospectus page opened");
		CommonFunction.click(Countrydrpdown);
		
		Thread.sleep(5000);
		if(CountryUKdrpdown.getText().equals("UK"))
		{
		CommonFunction.click(CountryUKdrpdown);
		}
		if(DPlistpagetitle.getText().equalsIgnoreCase("Downloads UK University Prospectuses"))
				{
			CommonFunction.logger.log(LogStatus.PASS, DPlistpagetitle.getText());
				}
		else
		{
			CommonFunction.logger.log(LogStatus.FAIL,DPlistpagetitle.getText());
		}
CommonFunction.click(DownloadProspectusbtn);

	}


}
