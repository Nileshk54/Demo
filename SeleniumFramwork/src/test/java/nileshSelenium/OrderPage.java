package nileshSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//tbody//td[2]")
	WebElement orderedProduct;
	
	public String orderedProductName() {
		return orderedProduct.getText();
	}
	
}
