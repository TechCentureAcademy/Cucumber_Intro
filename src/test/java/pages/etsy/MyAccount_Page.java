package pages.etsy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class MyAccount_Page {
	
	private WebDriver driver;

	public MyAccount_Page() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//p[contains(text(), 'View')]")
	public WebElement viewProfile;
	
	@FindBy(xpath = "(//a[contains(@aria-label, 'Edit Profile')])[2]")
	public WebElement editProfileLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Change or remove')]")
	public WebElement changeOrRemoveLink;
	
	@FindBy(id = "new-first-name")
	public WebElement firstNameField;
	
	@FindBy(id = "new-last-name")
	public WebElement lastNameField;
	
	@FindBy(name = "save")
	public WebElement saveButton;
	
	@FindBy(id = "new-first-name-error")
	public WebElement firstNameErrorMsg;
	
	@FindBy(id = "new-last-name-error")
	public WebElement lastNameErrorMsg;

}
