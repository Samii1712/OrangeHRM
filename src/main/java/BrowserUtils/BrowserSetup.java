package BrowserUtils;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;



public class BrowserSetup {
	public static RemoteWebDriver driver;
	public static Logger log = Logger.getLogger(BrowserSetup.class);
	
	
	public static RemoteWebDriver launchBrowser(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			ChromeOptions options = new ChromeOptions();
		    options.addArguments("--incognito");
		    
		    driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("Microsoft edge")) {
			driver = new EdgeDriver();
			 log.info("Launching Microsoft edge Browser...");

		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			 log.info("Launching firefox Browser...");

		} else {
			log.error("Error: Invalid browser name: " + browserName + ". Defaulting to Chrome.");

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	
	}
	
	public static void tearDown() {
		  driver.quit();
		}
	
}
