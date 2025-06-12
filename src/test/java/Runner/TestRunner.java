package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/features",
	    glue = {"com.BDD_StepDefinations","Hooks"}
	)
	public class TestRunner extends AbstractTestNGCucumberTests {
	}
