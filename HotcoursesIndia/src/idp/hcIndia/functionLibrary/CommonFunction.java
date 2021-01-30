package idp.hcIndia.functionLibrary;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import idp.hcIndia.utilities.FilePath;

public class CommonFunction {

	public static WebDriver driver;
	public static ExtentReports report;
	 public static ExtentTest logger;
	 public static Actions action=new Actions(driver);
	 
	 public static DateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss");
	 public static Date date = new Date();
	
	 
	 public static String extendScreenshot() {
	  
	  UUID uuid = UUID.randomUUID();
	  String screenpath = new File("src/idp/hcIndia/screenshots").getAbsolutePath() +"\\" +uuid +".png";
	  File screen1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  try {
	   FileUtils.copyFile(screen1, new File(screenpath));
	  }catch (IOException e) {
	   System.out.println(e);
	  }
	  return screenpath;
	 }
	 
	
	public static String getProperty(String name) throws IOException
	{
		FileInputStream Finput= new FileInputStream(FilePath.propertiesFile);
		Properties prop=new Properties();
		prop.load(Finput);
		return prop.getProperty(name);
		
	}
	
	public static void closeApp()
	{
		driver.close();
		driver.quit();
	}

	
	public static void openBrowser() throws IOException 
	{
		String appUrl=getProperty("url");
		String browserName=getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
	
			System.setProperty("webdriver.chrome.driver",FilePath.chromeDriver);
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(appUrl);
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			
			System.setProperty("Webdriver.gecko.driver",FilePath.firefoxDriver);
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(appUrl);
		}
		
		else if(browserName.equalsIgnoreCase("ie"))
		{
			
			System.setProperty("Webdriver.ie.driver",FilePath.ieDriver);
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(appUrl);
		}
		
		else
		{
			System.out.println("Please enter valid config details");
		}
	}

	public static void captureScreenshot(String fileName) throws IOException
	{
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File(FilePath.screenshot+"//"+fileName+".png"));
		
	}


	public static String getData(String sheet,int row,int col) throws IOException
	{
		String result=null;
		try {
		FileInputStream fis=new FileInputStream(FilePath.excelFile);
		//File format .xls=HSS//F
		//File format .xlsx=XSSF
				XSSFWorkbook w=new XSSFWorkbook(fis);
				XSSFSheet s=w.getSheet(sheet);
				XSSFRow r=s.getRow(row);
				XSSFCell c=r.getCell(col);			
				if(c!=null)
				{
				result=c.toString();
				System.out.println(result);
				}
				}
		catch (IOException e) {
		System.out.println("File not found");
		}
		return result;
		}

	//Action commands

	public static void type(WebElement element,String value)
	{
		element.sendKeys(value);
	}

	public static void click(WebElement element)
	{
		element.click();
	}


	public static void clear(WebElement element)
	{
		element.clear();
	}

	public static void navigateForward()
	{
		driver.navigate().forward();
	}

	public static void navigateBack()
	{
		driver.navigate().back();
	}

	public static void refreshPage()
	{
		driver.navigate().refresh();
	}

	public static void selectDropdown(WebElement element,String option)
	{
		new Select(element).selectByVisibleText(option);
	}

	public static void acceptAlert()
	{
		Alert popup=driver.switchTo().alert();
		popup.accept();
	}

	public static void dismissAlert()
	{
		Alert popup=driver.switchTo().alert();
		popup.dismiss();
	}

	public static void waitUntilElementVisible(WebElement element,int second)
	{
	WebDriverWait wait=new WebDriverWait(driver, second);
	wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitUntilElementClickable(WebElement element,int second)
	{
	WebDriverWait wait=new WebDriverWait(driver, second);
	wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	//Storage commands:


	public static String gettitle(){
	return driver.getTitle();
	}
	public static String getUrl(){
	return driver.getCurrentUrl();
	}

	// text or label or link or paragraph
	public static String gettext(WebElement element){
	return element.getText();
	}

	// value present in text field, checkbox, rediobutton, button label.
	public static String getValue(WebElement element){
	return element.getAttribute("value");
	}

	//Tooltip:
	public static String getTooltip(WebElement element){
	return element.getAttribute("title");
	}

	//Dropdown and listbox values:
	public static String getDropdownOption(WebElement element){
	return new Select(element).getFirstSelectedOption().getText();
	}

	public static List<WebElement> getAllDropdownValues(WebElement element){
	return new Select(element).getOptions();
	}
	public static List<WebElement> getListselectedValues(WebElement element){
	return new Select(element).getAllSelectedOptions();
	}

	//Alert:
	public static String getAlertMessages(){
	Alert popup = driver.switchTo().alert();
	return popup.getText();
	}

	public static boolean isSelected(WebElement element){
	try{
	element.isSelected();
	return true;
	}catch(Exception e){
	return false;
	}
	}

	public static boolean isDisplayed(WebElement element){
	try{
	element.isDisplayed();
	return true;
	}catch(Exception e){
	return false;
	}
	}

	public static boolean isEnabled(WebElement element){
	try{
	element.isEnabled();
	return true;
	}catch(Exception e){
	return false;
	}
	} 
	public static boolean isAlertPresent(){
	try{
	Alert popup = driver.switchTo().alert();
	return true;
	}catch(Exception e){
	return false;
	}

	}
	
	public void mouseClick(WebElement element)
	{
		action.moveToElement(element).click().build().perform();
	}
	
	public void mouseDoubleClick(WebElement element)
	{
		action.moveToElement(element).doubleClick().build().perform();
		action.moveToElement(element);
		action.perform();
		
	}
	
	public void mouseOverelement(WebElement element)
	{
		action.moveToElement(element);
		action.perform();
	}
	
	
	
	

}


