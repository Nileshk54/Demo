package nileshSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponents;

public class SelectionPage extends AbstractComponents{
	
	WebDriver driver;

	public SelectionPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css=".mb-3")
	List<WebElement> allProductsName;
	
	@FindBy (xpath = "//ul/li[3]")
	WebElement order;
	
	@FindBy(xpath = "//ul/li[4]")
	WebElement cartClick;
	
	By elementLocal=By.cssSelector(".mb-3");
	By invisible=By.cssSelector(".ng-animating");
	By cartButton=By.xpath("//ul/li[4]");
	
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	
	public List<WebElement> productsList() {
		explicitWaitToAppear(elementLocal);
		return allProductsName;
	}
	
	public WebElement getProductByName(String productName) {
		WebElement product= productsList().stream()
				.filter(s->s.findElement(By.cssSelector("b")).getText().equals(productName))
						.findFirst().orElse(null);
		return product;
	}
	
	public CartPage addToCart(String productName) throws InterruptedException {
		WebElement product=getProductByName(productName);
		product.findElement(addToCart).click();
		explicitWaitToDisappear(invisible);
		cartClick.click();
		return  new CartPage(driver);
	}
	
	public OrderPage orderButton() {
		order.click();
		return new OrderPage(driver);
	}

	
	
	
}
