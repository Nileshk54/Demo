package cucumberImplementation;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.gherkin.model.Given;

import io.cucumber.java.en.Given.Givens;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nileshSelenium.CartPage;
import nileshSelenium.CheckoutPage;
import nileshSelenium.LandingPage;
import nileshSelenium.LastPage;
import nileshSelenium.SelectionPage;
import tests.BaseTest;

public class StepDefinition extends BaseTest {

	public LandingPage lp;
	 public SelectionPage sp;
	 public List<WebElement> allProductsName ;
	 public CartPage cp; 
	 public CheckoutPage check ;
	 public LastPage last;
	 public String message;
	 
	 
	@io.cucumber.java.en.Given("I landed on Page")
	public void I_landed_on_Page() throws IOException {
		lp=launchApplication();
	}
	
	//As we are passing value as regex we will use ^ at beginning and $ at end
	
	@io.cucumber.java.en.Given("^Login with username (.+) and password (.+)$")
	public void login_with_username_password(String username,String pass) {
		sp=lp.loginApplication(username,pass);
	}
	
	@When("^added a product (.+) to cart$")
	public void addded_product_to_cart(String productName) throws InterruptedException {
		allProductsName= sp.productsList();
		WebElement product = sp.getProductByName(productName);
		cp=sp.addToCart(productName);
	}
	
	@When("^checkout (.+) and submit it$")
	public void checkout_productName_and_submit(String productname) {
		boolean flag = cp.listOfProductInCart(productname);
		Assert.assertTrue(flag);
		check=cp.goToCheckOut();
		last=check.selectCountry("ind");
		message=last.getOrderId();
	}
	
	//if value comes from examples section then we will use 
	//regex and else we will use {string} to catch the string
	
	@Then("verify the {string} is displayed")
	public void verify_message_is_displayed(String message) {
		Assert.assertEquals(message,"THANKYOU FOR THE ORDER.");
	}
	
}
