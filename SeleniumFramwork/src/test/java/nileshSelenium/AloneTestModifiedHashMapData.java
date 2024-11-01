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

public class AloneTestModifiedHashMapData extends BaseTest {

	
	
	@Test(dataProvider = "getData")
	public void orderZaraCoat(HashMap<String, String> inputHash) throws InterruptedException, IOException {

		
		SelectionPage sp=lp.loginApplication(inputHash.get("email"),inputHash.get("pass"));
		List<WebElement> allProductsName = sp.productsList();
		WebElement product = sp.getProductByName( inputHash.get("productName"));
		CartPage cp =sp.addToCart( inputHash.get("productName"));
		boolean flag = cp.listOfProductInCart( inputHash.get("productName"));
		Assert.assertTrue(flag);
		CheckoutPage check =cp.goToCheckOut();
		LastPage last=check.selectCountry("ind");
		last.getOrderId();
		

	}

	@DataProvider
	public Object[][] getData() {
		HashMap<String , String> map1=new HashMap<String , String>();
		map1.put("email","neel7020632@gmail.com");
		map1.put("pass","Nileshk_54" );
		map1.put("productName","IPHONE 13 PRO" );
		
		HashMap<String , String> map2=new HashMap<String , String>();
		map2.put("email","anshika@gmail.com");
		map2.put("pass","Iamking@000" );
		map2.put("productName","ZARA COAT 3" );
		
		return new Object[][]{{map1},{map2}};
		
	}
	
}
