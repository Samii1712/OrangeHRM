package pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BrowserUtils.BrowserSetup;
import propertyBase.PropertyConfig;

public class Login {
    
	static Logger log = Logger.getLogger(Login.class);
	
	static By userNameInput =  By.xpath("//input[@name='username']");
	static By passwordInput = By.xpath("//input[@name='password']");
	static By LoginButton =   By.xpath("//button[@type='submit']");
	static By Dashboard = By.xpath("//h6[text()='Dashboard']");
	static By PIMMenu = By.xpath("//span[text()='PIM']");
	
	public static void launchBrowser() {
		BrowserSetup.launchBrowser(PropertyConfig.getProperty("browser"));
		log.info("Browserlaunched");
	}
	
	public static  void EnterURL() {
		BrowserSetup.driver.get(PropertyConfig.getProperty("baseUrl"));
	}
    public static void EnterUsername(String userName, String Password) {
    	 new WebDriverWait(BrowserSetup.driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(
    			 userNameInput));
    	 BrowserSetup.driver.findElement(userNameInput).sendKeys(userName);
    	 BrowserSetup.driver.findElement(passwordInput).sendKeys(Password);
         log.info("entered username and Password..");
    }
    public static void clickLogin() {
    	BrowserSetup.driver.findElement(LoginButton).click();
        log.info("Clicked on Login...");
    }
    public static void verifySuccessFullLogin() {
    	 String Actual = BrowserSetup.driver.findElement(Dashboard).getText();
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
