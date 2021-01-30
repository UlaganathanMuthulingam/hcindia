package idp.hcIndia.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import idp.hcIndia.functionLibrary.CommonFunction;

public class SearchResultsPage {
	
	@FindBy(xpath=".//*[@id='searchList_top']/span")
	public WebElement searchtypelist;
		
	@FindBy(xpath=".//*[@id='searchListType']/li[2]")
	public static WebElement selectSearchTypelist;
	
	@FindBy(xpath=".//*[@id='courseTitle']")
	public static WebElement subjecttxt;
	
	@FindBy(xpath=".//*[@id='hdtopstudyLevelId']")
	public static WebElement selectstudyleveldrp;
	
	@FindBy(xpath=".//*[@id='hdtopcountryId']")
	public static WebElement selectcountrydrp;
	
	@FindBy(xpath=".//*[@id='headerCoursesearch']/ul/li[4]/input")
	public  static WebElement searchIcon;
	
	@FindBy(xpath=".//*[@id='crseLnk_0']")
	public static WebElement ajaxsubjectLevel1;
	
	@FindBy(xpath=".//*[@id='topNav_mobSrch']")
	public static WebElement searchtxt;
	
	@FindBy(xpath=".//*[@id='topNav_mob_srch_div']")
	public static WebElement searchajax;
	
	public static void L1Search() throws InterruptedException
	{
		CommonFunction.logger=CommonFunction.report.startTest("Test");
	   CommonFunction.type(searchtxt, "Business and Management");
		Thread.sleep(40000);
		ArrayList<String> al=new ArrayList<String>();
		al.add(CommonFunction.gettext(searchajax));
		
		System.out.println(CommonFunction.gettext(searchajax));
		//System.out.println(searchIcon);
		//CommonFunction.click(searchIcon);
		CommonFunction.logger.log(LogStatus.INFO, CommonFunction.logger.addScreenCapture(CommonFunction.extendScreenshot()));
		
	}

}
