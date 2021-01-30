package idp.hcIndia.utilities;

import java.io.File;

public class FilePath {
	public static final String chromeDriver=new File("E:\\HotcoursesIndia\\HotcoursesIndia\\src\\idp\\hcIndia\\resources\\chromedriver.exe").getAbsolutePath();
	public static final String firefoxDriver=new File("/HotcoursesIndia/src/idp/hcIndia/resources/geckodriver.exe").getAbsolutePath();
	public static final String ieDriver=new File("/HotcoursesIndia/src/idp/hcIndia/resources/IEDriverServer.exe").getAbsolutePath();
	public static final File excelFile=new File("F:\\New folder\\DayFourteen\\src\\com\\hcv\\testData\\ExcelCheck.xlsx").getAbsoluteFile();
	public static final File propertiesFile=new File("E:\\HotcoursesIndia\\HotcoursesIndia\\src\\idp\\hcIndia\\testData\\browserDetails.properties").getAbsoluteFile();
	public static final File enqandDPInput=new File("src/idp/hcIndia/testData/EnquiryDPtestdata.properties").getAbsoluteFile();
	public static final File signupInput=new File("E:\\HotcoursesIndia\\HotcoursesIndia\\src\\idp\\hcIndia\\testData\\SignupUserDetails.properties").getAbsoluteFile();
	public static final File homepageElements=new File("src/idp/hcIndia/testData/homepageElement.properties").getAbsoluteFile();
	public static final File screenshot=new File("F:\\New folder\\DayFourteen\\src\\com\\hcv\\screenshots").getAbsoluteFile();
}
