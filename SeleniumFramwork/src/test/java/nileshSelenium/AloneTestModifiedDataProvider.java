package nileshSelenium;

import java.io.IOException;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tests.BaseTest;

public class AloneTestModifiedDataProvider extends BaseTest {

	
	
	@Test(dataProvider = "getData")
	public void orderZaraCoat(String email,String pass,String productName) throws InterruptedException, IOException {

		
		SelectionPage sp=lp.loginApplication(email,pass);
		List<WebElement> allProductsName = sp.productsList();
		WebElement product = sp.getProductByName(productName);
		CartPage cp =sp.addToCart(productName);
		boolean flag = cp.listOfProductInCart(productName);
		Assert.assertTrue(flag);
		CheckoutPage check =cp.goToCheckOut();
		LastPage last=check.selectCountry("ind");
		last.getOrderId();
		

	}
	
	@DataProvider
	public Object[][] getData() {
		return new Object[][] {
			{"neel7020632@gmail.com","Nileshk_54","IPHONE 13 PRO"},
			{"anshika@gmail.com","Iamking@000","ZARA COAT 3"}
			
		};
	}

	
}
