package extentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {

	ExtentReports er;

	@Test
	public void demo() {
		ExtentTest ex=er.createTest("initial demo");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		ex.fail("Failed");
		driver.close();
		er.flush();
	}

	@BeforeTest
	public void report() {
		// ExtentReports , ExtentSparkReport
		String filePath = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter esr = new ExtentSparkReporter(filePath);
		esr.config().setReportName("Automation Result");
		esr.config().setDocumentTitle("ReportsAutomation");
		// ExtentSparkReport will create a html file

		er = new ExtentReports();
		er.attachReporter(esr);
		er.setSystemInfo("tester", "Nilesh Khalate");
	}

}
