package pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BrowserUtils.BrowserSetup;

import keyword.Keywords;

public class Login {

	public static Logger log = Logger.getLogger(Login.class);

	static By userNameInput = By.xpath("//input[@name='username']");
	static By passwordInput = By.xpath("//input[@name='password']");
	static By LoginButton = By.xpath("//button[@type='submit']");
	static By Dashboard = By.xpath("//h6[text()='Dashboard']");
	static By PIMMenu = By.xpath("//span[text()='PIM']");

	public static void EnterUsername(String userName, String Password) {

		Keywords.waitTillPresence(userNameInput);
		Keywords.enterText(userNameInput, userName);
		Keywords.enterText(passwordInput, Password);
		log.info("entered username and Password..");
	}

	public static void clickLogin() {
		Keywords.click(LoginButton);
		log.info("Clicked on Login...");
	}

	public static void verifySuccessFullLogin() {
		String Actual = Keywords.getText(Dashboard);
		String expected = "Dashboard";
		Assert.assertEquals(Actual, expected);
		log.info("Dashboard page visited..");

	}

	public static void clickOnPIMMenu() {
		new WebDriverWait(BrowserSetup.driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(PIMMenu)).click();
		log.info("PIM tab visited...");
	}
}
