package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber",glue="cucumberImplementation"
,monochrome = true,plugin= {"html:target/cucumber.html"})

public class TestNGRunner extends AbstractTestNGCucumberTests{

	
	
	
}
