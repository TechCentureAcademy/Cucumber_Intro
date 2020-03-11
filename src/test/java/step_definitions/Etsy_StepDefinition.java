package step_definitions;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.etsy.Etsy_HomePage;
import utilities.ConfigurationReader;

public class Etsy_StepDefinition {
	
	String Home_Page_url = ConfigurationReader.getProperty("url");
	private Etsy_HomePage homePage = new Etsy_HomePage();
	
	@Given("User is on the home page")
	public void user_is_on_the_home_page() {
		homePage.goToPage(Home_Page_url);
	}

	@When("User clicks on the {string} button")
	public void user_clicks_on_the_button(String button) throws InterruptedException {
		WebElement clickOnButton = null;
	   if(button.equals("Sign in")) {
		   clickOnButton = homePage.SignInButton;
	   } else if(button.equals("Sign in Login")) {
		   clickOnButton = homePage.submitLoginButton;
	   }
	   clickOnButton.click();
//	   Thread.sleep(2000);
	}

	@Then("User enters valid {string} and {string}")
	public void user_enters_valid_and(String userID, String password) throws InterruptedException {
		// entering userID to the email field
//		Thread.sleep(2000);
	    homePage.enterDataInTheField(userID, homePage.email);
	    
	    // entering password to the password field
	    homePage.enterDataInTheField(password, homePage.password);
	}
	
	@Then("User verifies that he is on the account page")
	public void user_verifies_that_he_is_on_the_account_page() throws InterruptedException {
	    String expectedOutput = "You";
	    Thread.sleep(2000);
	    String actualOutput = homePage.myAccount.getText().trim();
	    System.out.println("the actual output is: " + actualOutput);
	    assertEquals(expectedOutput, actualOutput);
	}
	
	@Then("User enters valid username and password")
	public void user_enters_valid_username_and_password(Map<String, String> dataTable) {
		// entering userID to the email field
	    homePage.enterDataInTheField(dataTable.get("userName"), homePage.email);
	    
	    // entering password to the password field
	    homePage.enterDataInTheField(dataTable.get("password"), homePage.password);
	}
	
	@Then("User enters valid username and password")
	public void user_enters_valid_username_and_password1() {
		// entering userID to the email field
	    homePage.enterDataInTheField(ConfigurationReader.getProperty("userid"), homePage.email);
	    
	    // entering password to the password field
	    homePage.enterDataInTheField(ConfigurationReader.getProperty("password"), homePage.password);
	}

}
