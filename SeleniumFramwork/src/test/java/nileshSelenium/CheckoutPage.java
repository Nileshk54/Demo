package nileshSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	String actualName="India";
	WebDriver driver;
	public CheckoutPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="div[class='details__user'] input:nth-child(1)")
	WebElement listName;
	
	@FindBy(xpath ="//div[@class='details__user']//section//button")
	List<WebElement> countryListed;
	
	 
	 @FindBy(css=".actions a")
	WebElement submit;
	 
	public LastPage selectCountry(String countryName) {
		listName.sendKeys(countryName);
		countryListed.stream().filter(s->s.getText().equalsIgnoreCase(actualName)).findFirst().orElse(null).click();
		submit.click();
		return new LastPage(driver);
	}

	
	
}
