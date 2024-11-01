package nileshSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LastPage {

	WebDriver driver;
	
	public LastPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="td[class='box'] tr tr:nth-child(3)")
	WebElement ordering;
	
	@FindBy(tagName = "h1")
	WebElement text;
	
	public String getOrderId() {
		System.out.println(ordering.getText());
		String message=text.getText();
		return message;
	}
	
}
