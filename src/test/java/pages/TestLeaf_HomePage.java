package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class TestLeaf_HomePage {
	
	private WebDriver driver;
	public TestLeaf_HomePage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath = "//h5[.='Edit']")
	WebElement editButton;
	
	public void clickOnEditElement() {
		editButton.click();
	}
	
	public void goToHomePage(String url) {
		driver.get(url);
	}
	
	public void verifyTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle, actualTitle);
	}

}