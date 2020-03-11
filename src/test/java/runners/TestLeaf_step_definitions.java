package runners;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.TestLeaf_HomePage;

public class TestLeaf_step_definitions {
	
	TestLeaf_HomePage homePage = new TestLeaf_HomePage();
	String url = "http://testleaf.herokuapp.com/";
	

	@Given("the User is on the homePage")
	public void the_User_is_on_the_homePage() {
	    homePage.goToHomePage(url);
	}

	@Given("verifying that title is {string}")
	public void verifying_that_title_is(String title) {
	    homePage.verifyTitle(title);
	}

	@Then("the User is clicking on the Edit button")
	public void the_User_is_clicking_on_the_Edit_button() {
	   homePage.clickOnEditElement();
	}
}