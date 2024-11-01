package nileshSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement login;



	public SelectionPage loginApplication(String email, String passWord) {
		// TODO Auto-generated method stub
		userEmail.sendKeys(email);
		userPassword.sendKeys(passWord);
		login.click();
		return new SelectionPage(driver); 
	}
	


	public void goToLink() {
		// TODO Auto-generated method stub
		driver.get("https://rahulshettyacademy.com/client");
		
	}
}
