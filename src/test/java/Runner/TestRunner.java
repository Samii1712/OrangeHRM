package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/features",
	    glue = {"com.BDD_StepDefinations","hooks"},
		plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
	)
	public class TestRunner extends AbstractTestNGCucumberTests {
	}
