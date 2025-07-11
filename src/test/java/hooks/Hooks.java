package hooks;

import BrowserUtils.BrowserSetup;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import pages.Login;
import propertyBase.PropertyConfig;

public class Hooks {

	@BeforeAll
	public static void OpenBrowser() {
		BrowserSetup.launchBrowser(PropertyConfig.getProperty("browser"));
		Login.log.info("Browserlaunched..");
		BrowserSetup.driver.get(PropertyConfig.getProperty("baseUrl"));
		Login.log.info("Url Passed..");
	}
	@AfterAll
	public static void closeBrowser() {
		BrowserSetup.tearDown();
	}
}






























//@Before
//@Parameters("browser")
//public void setup(String browser) {
//    System.out.println("Running on browser: " + browser);
//}