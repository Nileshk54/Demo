package abstractcomponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public void explicitWaitToAppear(By elementLocated) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocated));
		
	}
	
	public void explicitWaitToDisappear(By elementLocated) throws InterruptedException {
		Thread.sleep(2000);
		/*WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(elementLocated));*/
		
	}
	
	
	
}
