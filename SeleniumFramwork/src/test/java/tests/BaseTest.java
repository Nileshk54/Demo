package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import nileshSelenium.LandingPage;

public class BaseTest {

	 public WebDriver driver;
	 public LandingPage lp ;
	 
	public WebDriver startTest() throws IOException {

	
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//java//tests//Data.properties");
		p.load(fis);
		String browserName= p.getProperty("browser");
		if(browserName.contains("chrome")) {
			ChromeOptions opt=new ChromeOptions();
			//opt.addArguments("headless");We will user chromeoptions and run it in headless mode
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(opt);
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			
		}else {
			
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	
	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		driver=startTest();
		lp=new LandingPage(driver);
		lp.goToLink();
		return lp;
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	public List<HashMap<String, String>> getJsonData(String filePath) throws IOException {
		String jsonData=FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		
		//String to HashMap Jackson DataBid
		
		ObjectMapper om =new ObjectMapper();
		List<HashMap<String, String>> data=om.readValue(jsonData, new TypeReference<List<HashMap<String,String>>>() {
		});
		
		return data;
	}

}
