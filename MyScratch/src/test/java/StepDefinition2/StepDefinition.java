package StepDefinition2;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageRepository.LoginPage;
import PageRepository.Logout;

import PageRepository.NewAccountPage;
import PageRepository.NewCustomerPage;
import PageRepository.NewCustomerPage1;
import Utilities.BaseClass;
import Utilities.FetchCustIdFromExcel;
import Utilities.WriteDataToExcel;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass{
	 	
	 NewCustomerPage1 cusPage;
	 NewAccountPage accPage;
	 Logout logout;
	
	
	@Given("user launches the browser")
	public void user_launches_the_browser() {
		 setup();
		  driver = BaseClass.getDriver(); 
		 cusPage = new NewCustomerPage1(BaseClass.getDriver());
		 accPage=new NewAccountPage(BaseClass.getDriver());	                                                                                                
	}
	@Given("user logs into application")
	public void user_logs_into_application() {
		 if (getDriver() == null) {
		        setup();
		    }
		 	cusPage = new NewCustomerPage1(getDriver()); 
		 	cusPage.login("mngr655006", "Avegujy");
	}
	 

	@When("user navigates to new customer page")
	public void user_navigates_to_new_customer_page() {
		cusPage.clickNewCustomer();
	}

	@When("user enters customer details")
	public void user_enters_customer_details(DataTable table) {
		 Map<String, String> data = table.asMap(String.class, String.class);
		 cusPage.enterCustomerDetails(data);
	}

	@Then("customer should be created successfully")
	public void customer_should_be_created_successfully() throws IOException {
		 if(cusPage.isCustomerCreated()) {
	            System.out.println("Customer Created Successfully");
	        } else {
	            System.out.println("Customer Creation Failed");
	        }
		 String custId = cusPage.getCustomerId();
		    System.out.println("Generated Customer ID: " + custId);

		    WriteDataToExcel.writeCustomerId(custId);

		   
	} 
	
	@Given("user is on the homepage of an application")
	public void user_is_on_the_homepage_of_an_application() {
	   
	}
	@Given("user clicks on New Account link")
	public void user_clicks_on_new_account_link() {
		 if(accPage == null) {
		      
		       accPage = new NewAccountPage(driver);
		   }

		  // accPage = new NewAccountPage(BaseClass.getDriver());
		   accPage.clickonNewAccount();
	}
	@Then("user creates new account using customer id from excel")
	public void user_creates_new_account_using_customer_id_from_excel() throws IOException {
		if (accPage == null) {
			accPage = new NewAccountPage(BaseClass.getDriver());
        }
		String custId = FetchCustIdFromExcel.getCustomerId();
		    System.out.println("Customer ID from Excel: " + custId);
		    accPage.enterCustomerId(custId);
		    accPage.selectAccountType("Savings");
		    accPage.enterInitialDeposit("5000");
		    accPage.clickSubmit();
	
		   
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	       WebElement accountIdElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Account ID']/following-sibling::td")));
	        String accId=accPage.generatedAccountID();
	        System.out.println("Generated Account ID: " + accId);

	        WriteDataToExcel.writeAccountId(accId);
	        
	}     
	@When("user logs out after account creation")
    public void user_logs_out_after_account_creation() {
    	logout = new Logout(getDriver());
    	 logout.LogoutLink();
    }

    @Then("browser is closed")
    public void browser_is_closed() {
    	driver.quit();
    }

	       
	}    






