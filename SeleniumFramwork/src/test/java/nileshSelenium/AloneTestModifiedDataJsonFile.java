package nileshSelenium;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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

public class AloneTestModifiedDataJsonFile extends BaseTest {

	
	
	@Test(dataProvider = "getData")
	public void orderZaraCoat(HashMap<String, String> data) throws InterruptedException, IOException {

		
		SelectionPage sp=lp.loginApplication(data.get("email"),data.get("pass"));
		List<WebElement> allProductsName = sp.productsList();
		WebElement product = sp.getProductByName(data.get("productName"));
		CartPage cp =sp.addToCart(data.get("productName"));
		boolean flag = cp.listOfProductInCart(data.get("productName"));
		Assert.assertTrue(flag);
		CheckoutPage check =cp.goToCheckOut();
		LastPage last=check.selectCountry("ind");
		last.getOrderId();
		

	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data=getJsonData(System.getProperty("user.dir")+"//src//test//java//data//Order.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}

	
}
