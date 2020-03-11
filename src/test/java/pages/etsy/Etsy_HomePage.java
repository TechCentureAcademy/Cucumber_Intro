package pages.etsy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class Etsy_HomePage {

	private WebDriver driver;

	public Etsy_HomePage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(text(), 'Sign in')]")
	public WebElement SignInButton;
	
	@FindBy(xpath = "//button[contains(text(), 'Sign in')]")
	public WebElement CartButton;
	
	@FindBy(xpath = "//*[@id='join_neu_email_field']")
	public WebElement email;
	
	@FindBy(id = "join_neu_password_field")
	public WebElement password;
	
	@FindBy(name = "submit_attempt")
	public WebElement submitLoginButton;
	
	@FindBy(xpath = "//span[contains(text(), 'You')]")
	public WebElement myAccount;
	
	public void goToPage(String url) {
		driver.get(url);
	}
	
	public void enterDataInTheField(String data, WebElement field) {
		field.sendKeys(data);
	}

}
