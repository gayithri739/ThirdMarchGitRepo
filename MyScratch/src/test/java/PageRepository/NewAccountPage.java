package PageRepository;

import java.io.FileInputStream;

import java.util.Map;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccountPage {
	WebDriver driver;
	public NewAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	 @FindBy(linkText="New Account")
	  WebElement newAccountLink;
	
	@FindBy(xpath="//input[@name='cusid']")
	WebElement Cust_id;;
	
	@FindBy(xpath="//select[@name='selaccount']")
	WebElement Acc_type;
	
	@FindBy(xpath="//input[@name='inideposit']")
	WebElement Int_dep;
	
	@FindBy(xpath="//input[@value='submit']")
	WebElement Submit;
	
	@FindBy(xpath="//td[text()='Account ID']/following-sibling::td")
	WebElement generatedAccountID;
	
	
	
	public void clickonNewAccount()
	{
		newAccountLink.click();
	}
	 public void enterCustomerId(String customerID)
	 {
		 Cust_id.sendKeys(customerID);
	 }
	 public void selectAccountType(String accType)
	 {
		 Acc_type.sendKeys(accType);
	 }
	 public void enterInitialDeposit(String intAmount)
	 	{
		 Int_dep.sendKeys(intAmount);
	    }

	    public void clickSubmit() {
	    	Submit.click();
	    }
	    public String generatedAccountID()
		{
	    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    	    return wait.until(
	    	        ExpectedConditions.visibilityOf(generatedAccountID)
	    	    ).getText();
	
		}
	   
}
	

