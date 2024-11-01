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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tests.BaseTest;

public class AloneTestModified extends BaseTest {

	
	String productName = "IPHONE 13 PRO";
	@Test
	public void orderZaraCoat() throws InterruptedException, IOException {

		
		SelectionPage sp=lp.loginApplication("neel7020632@gmail.com","Nileshk_54");
		List<WebElement> allProductsName = sp.productsList();
		WebElement product = sp.getProductByName(productName);
		CartPage cp =sp.addToCart(productName);
		boolean flag = cp.listOfProductInCart(productName);
		Assert.assertTrue(flag);
		CheckoutPage check =cp.goToCheckOut();
		LastPage last=check.selectCountry("ind");
		String message=last.getOrderId();
		Assert.assertEquals(message,"Thankyou for the order.");
			
	}

	@Test(dependsOnMethods = {"orderZaraCoat"})
	public void orderHistory() {
		SelectionPage sp=lp.loginApplication("neel7020632@gmail.com","Nileshk_54");
		OrderPage op=sp.orderButton();
		String productOrderedName= op.orderedProductName();
		Assert.assertEquals(productOrderedName, productName);
	}
	
}
