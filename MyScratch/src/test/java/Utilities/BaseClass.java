package Utilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
//static String browserName ;
public static WebDriver driver;
public static void setup() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://demo.guru99.com/V4/");
}

public static WebDriver getDriver() {
    return driver;
}
public static void closeBrowser() {
   
}
}
/*public static WebDriver initializeDriver() //return type of initializeDriver is WebDriver
{
	try {
		browserName=FetchDataFromProperty.getDataFromProperty().getProperty("browser");
	} catch (IOException e) {
		
	}
	if(browserName.equalsIgnoreCase("chrome"))
			{
				driver=new ChromeDriver();
				try {
					driver.get(FetchDataFromExcel.getURL(1, 0));
				} catch (IOException e) {
					
				}
				driver.manage().window().maximize();
				
			}
	if(browserName.equalsIgnoreCase("firefox"))
	{
		driver=new ChromeDriver();
		try {
			driver.get(FetchDataFromExcel.getURL(1, 0));
		} catch (IOException e) {
			
		}
		driver.manage().window().maximize();
	}
	if(browserName.equalsIgnoreCase("edge"))
	{
		driver=new ChromeDriver();
		try {
			driver.get(FetchDataFromExcel.getURL(1, 0));
		} catch (IOException e) {
				
		}
		driver.manage().window().maximize();
	}
	
	return driver;
}

public static String getTitle()
{
	String title=driver.getTitle();
	return title;
}
public static void scrollPage()
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("windows.scrollBy(0,500)","");
			
}
public static String getCurrentURL()
{
	String CURL=driver.getCurrentUrl();
	return CURL;
}
}*/
