package PageRepository;

import java.util.Map;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage1 {
	 WebDriver driver;

	    public NewCustomerPage1(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(name="uid")
	    WebElement username;

	    @FindBy(name="password")
	    WebElement password;

	    @FindBy(name="btnLogin")
	    WebElement loginBtn;

	    @FindBy(linkText="New Customer")
	    WebElement newCustomerLink;

	    @FindBy(name="name")
	    WebElement custName;

	    @FindBy(xpath="//input[@value='f']")
	    WebElement femaleRadio;
	    
	    @FindBy(xpath = "//input[@value='m']")
	    WebElement maleRadio;

	    @FindBy(name="dob")
	    WebElement dob;

	    @FindBy(name="addr")
	    WebElement address;

	    @FindBy(name="city")
	    WebElement city;

	    @FindBy(name="state")
	    WebElement state;

	    @FindBy(name="pinno")
	    WebElement pin;

	    @FindBy(name="telephoneno")
	    WebElement mobile;

	    @FindBy(name="emailid")
	    WebElement email;

	    @FindBy(name="password")
	    WebElement custPassword;

	    @FindBy(name="sub")
	    WebElement submitBtn;

	    @FindBy(xpath="//p[contains(text(),'Customer Registered')]")
	    WebElement successMsg;
	    
	    @FindBy(xpath = "//td[text()='Customer ID']/following-sibling::td")
	    WebElement customerIdValue;
	   
	  public void login(String user, String pass) {
	        username.sendKeys(user);
	        password.sendKeys(pass);
	        loginBtn.click();
	    }

	    public void clickNewCustomer() {
	        newCustomerLink.click();
	    }

	    public void enterCustomerDetails(Map<String, String> data) {

	        custName.sendKeys(data.get("name"));
	        femaleRadio.click();
	        dob.sendKeys(data.get("dob"));
	        address.sendKeys(data.get("address"));
	        city.sendKeys(data.get("city"));
	        state.sendKeys(data.get("state"));
	        pin.sendKeys(data.get("pin"));
	        mobile.sendKeys(data.get("mobile"));

	        String randomEmail = generateRandomEmail();
	        email.sendKeys(randomEmail);

	        custPassword.sendKeys(data.get("password"));
	        submitBtn.click();
	    }

	    public boolean isCustomerCreated() {
	        return successMsg.isDisplayed();
	    }

	    public String generateRandomEmail() {
	        Random rand = new Random();
	        int num = rand.nextInt(1000);
	        return "test" + num + "@gmail.com";
	    }
	    public String getCustomerId() {
	        return customerIdValue.getText();
	}
}

