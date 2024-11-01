package nileshSelenium;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.locks.Condition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		//Registration Started
		
		//Registration Values
		
		String Firstname="Firstname";
		String Lastname="Lastname";
		String email="neel7020632@gmail.com";
		String number="7020202552";
		String productName="IPHONE 13 PRO";
		String gender="Male";
		String passWord="Nileshk_54";
		String branch="branch";
		/*driver.findElement(By.cssSelector("div[class*='login-wrapper'] p")).click();
		driver.findElement(By.id("firstName")).sendKeys(Firstname);
		driver.findElement(By.id("lastName")).sendKeys(Lastname);
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.id("userMobile")).sendKeys(number);
		
		WebElement occupationDropdown=driver.findElement(By.cssSelector("select[formcontrolname='occupation']"));
		
		Select s=new Select(occupationDropdown);
		s.selectByValue("3: Engineer");
		driver.findElement(By.cssSelector("input[value='Male']")).click();
		driver.findElement(By.id("userPassword")).sendKeys(passWord);
		driver.findElement(By.id("confirmPassword")).sendKeys(passWord);
		driver.findElement(By.cssSelector("input[formcontrolname='required']")).click();
		driver.findElement(By.id("login")).click();
		driver.findElement(By.cssSelector(".login-section-wrapper button")).click();
		
		//Registration done*/
		
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.id("userPassword")).sendKeys(passWord);
		driver.findElement(By.id("login")).click();
		
		
		//Grabbing all 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> allProductsName=driver.findElements(By.cssSelector(".mb-3"));
		WebElement product= allProductsName.stream()
		.filter(s->s.findElement(By.cssSelector("b")).getText().equals(productName))
				.findFirst().orElse(null);
		product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		//Go to add cart
		

		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		driver.findElement(By.xpath("//ul/li[4]")).click();
		
		//Get Text 
		
		
		
		
		List<WebElement> cartItems=  driver.findElements(By.cssSelector(".cart h3"));
		 cartItems.stream().forEach(s->System.out.println(s.getText()));
		boolean flag= cartItems.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(flag);
		
		List<WebElement> orderIDS= driver.findElements(By.cssSelector(".cart p[class='itemNumber']"));
		orderIDS.stream().forEach(s->System.out.println(s.getText()));
		
		// go to checkout
		
		driver.findElement(By.cssSelector("li[class='totalRow'] button")).click();
		
		//select country
		
		driver.findElement(By.cssSelector("div[class='details__user'] input:nth-child(1)")).sendKeys("ind");
		List<WebElement>countryList= driver.findElements(By.xpath("//div[@class='details__user']//section//button"));
		
	 countryList.stream().filter(s->s.getText().equalsIgnoreCase("india")).findFirst().orElse(null).click();
 
	 driver.findElement(By.cssSelector(".actions a")).click();
	 
	 String orderID=driver.findElement(By.cssSelector("td[class='box'] tr tr:nth-child(3)")).getText();
		System.out.println(orderID);
		driver.close();
		
	}

}
