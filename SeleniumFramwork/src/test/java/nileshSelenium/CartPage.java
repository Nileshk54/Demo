package nileshSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="li[class='totalRow'] button")
	WebElement submit;
	
	By cartLocatorname=By.cssSelector(".cart h3");
	
	public boolean listOfProductInCart(String productName) {
		List<WebElement> cartItems=  driver.findElements(cartLocatorname);
		boolean flag= cartItems.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		return flag;
	}
	

	
	public CheckoutPage goToCheckOut() {
		submit.click();
		return new CheckoutPage(driver);
	}
	
}
