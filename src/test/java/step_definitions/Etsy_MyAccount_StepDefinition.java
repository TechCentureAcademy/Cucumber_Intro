package step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.etsy.Etsy_HomePage;
import pages.etsy.MyAccount_Page;
import utilities.BrowserUtils;
import utilities.DataGenerator;

public class Etsy_MyAccount_StepDefinition extends BrowserUtils {
	
	private Etsy_HomePage homePage = new Etsy_HomePage();
	private MyAccount_Page accountPage = new MyAccount_Page();
	
	private DataGenerator generator = new DataGenerator();
	private String name;

	@When("User clicks on the Your Account icon")
	public void user_clicks_on_the_Your_Account_icon() {
		waitForVisibility(homePage.myAccount, 5);
		homePage.myAccount.click();
	}

	@Then("from the list picks the View your profile tab")
	public void from_the_list_picks_the_View_your_profile_tab() {
		waitForVisibility(accountPage.viewProfile, 5);
	    accountPage.viewProfile.click();
	}

	@Then("User clicks on Edit Profile")
	public void user_clicks_on_Edit_Profile() {
		//waitForVisibility(accountPage.editProfileLink, 5);
		accountPage.editProfileLink.click();
	}

	@Then("User clicks on Change or remove hyperlink")
	public void user_clicks_on_Change_or_remove_hyperlink() {
		waitForVisibility(accountPage.changeOrRemoveLink, 5);
		accountPage.changeOrRemoveLink.click();
	}

	@Then("User enters the First Name and the Last Name")
	public void user_enters_the_First_Name_and_the_Last_Name() {
		waitForVisibility(accountPage.firstNameField, 5);
		// clearing the first name field and entering a first name
		accountPage.firstNameField.clear();
		accountPage.firstNameField.sendKeys(generator.getFirstName());
		
		// clearing and entering the last name field
		accountPage.lastNameField.clear();
		accountPage.lastNameField.sendKeys(generator.getFirstName());
	}

	@Then("User verifies that the name was changed")
	public void user_verifies_that_the_name_was_changed() {
	   
	}
	
	@Then("User enters {string} into the field")
	public void user_enters_into_the_field(String name) {
		this.name = name;
	    if(name.contains("first")) {
	    	homePage.enterDataInTheField(generator.getFirstName() + 123, accountPage.firstNameField);
	    } else if(name.contains("last")) {
	    	homePage.enterDataInTheField(generator.getLastName() + 123, accountPage.lastNameField);
	    }
	}

	@Then("User verifies the {string}")
	public void user_verifies_the(String expectedErrorMsg) {
		String actualErrorMsg = "";
		if(name.contains("first")) {
			actualErrorMsg = accountPage.firstNameErrorMsg.getText();
	    } else if(name.contains("last")) {
	    	actualErrorMsg = accountPage.lastNameErrorMsg.getText();
	    }
		assertEquals(expectedErrorMsg, actualErrorMsg);
		}

	@Then("User verifies that the Save_Button is disabled")
	public void user_verifies_that_the_Save_Button_is_disabled() {
		waitForVisibility(accountPage.saveButton, 5);
		assertFalse(accountPage.saveButton.isEnabled());
	}
}