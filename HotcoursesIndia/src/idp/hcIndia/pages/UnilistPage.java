package idp.hcIndia.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import idp.hcIndia.functionLibrary.CommonFunction;

public class UnilistPage {
	@FindBy(xpath=".//*[@id='drop4']")
	public WebElement countryDrp;

	@FindBy(xpath=".//*[@id='srch']/div/div[2]/div/h1")
	public WebElement unipagetitle;
	
	
	public void unilistSearch()
	{
		CommonFunction.selectDropdown(countryDrp, "UK");
	}
	
	
	
}
