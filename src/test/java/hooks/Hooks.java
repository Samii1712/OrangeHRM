package hooks;

import BrowserUtils.BrowserSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.Login;

public class Hooks {

	@Before
	public void OpenBrowser() {
		Login.launchBrowser();
	}
	@After
	public void closeBrowser() {
		BrowserSetup.closeBrowser();
	}
}
