package pages;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BrowserUtils.BrowserSetup;
import keyword.Keywords;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class SearchAddedUSer {

	static Logger log = Logger.getLogger(SearchAddedUSer.class);

	static By SearchButton = By.xpath("//button[@type='submit']");
	static By EmployeeName = By.xpath("(//input[@placeholder='Type for hints...'])[1]");
	static By RecordListcontainer = By.xpath("//div[@class='orangehrm-container']");
	static By RedordID = By.xpath("//div[@class='oxd-table-cell oxd-padding-cell'][2]");
	static By suggestedList = By.xpath("//div[@role='listbox']");
	static By suggestedOption1 = By.xpath("//div[@role='option'][1]");
	static By recordFoundText = By.xpath("//span[text()='(1) Record Found']");

	public static void SearchAddedPIMUserRecord() {

		String firstName = PIM.enteredFirstName;
		WebElement nameInput;
		try {
			nameInput = new WebDriverWait(BrowserSetup.driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(EmployeeName));
		} catch (TimeoutException e) {
			throw new AssertionError("Employee name input not visible in time", e);
		}
		nameInput.clear();
		nameInput.sendKeys(firstName); // Only enter first name for hint trigger

		Keywords.waitTillVisible(suggestedList);

		// Automatically select the first option from the dropdown (usually full name
		// including middle name)
		WebElement suggestedOption = BrowserSetup.driver.findElement(suggestedOption1);
		String selectedName = suggestedOption.getText(); // For logging/debugging
		log.info("Selecting suggested name: " + selectedName);

		suggestedOption.click();

		BrowserSetup.driver.findElement(SearchButton).click();

	}

	public static String GetCurrentTimeanddate() {
		LocalDateTime localdatetime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		String formattednow = localdatetime.format(formatter);
		return formattednow;

	}

	public static void captureRecord() {

		BrowserSetup.driver.executeScript("window.scrollBy(0,500)");

		String recordFound = BrowserSetup.driver.findElement(recordFoundText).getText();

		if (recordFound.equalsIgnoreCase("(1) Record Found")) {
			Keywords.log.info("Record found: taking screenshot...");
			Screenshot sc = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500))
					.takeScreenshot(BrowserSetup.driver);
			BufferedImage img = sc.getImage();
			try {
				ImageIO.write(img, "png", new File("src/userRecords/recordFound.png" + GetCurrentTimeanddate()));
			} catch (IOException e) {
				log.error("Screenshot saving failed.");
				e.printStackTrace();
			}
		} else {
			log.error("Record not found — screenshot not taken.");
		}

		log.info("Screenshopt captured and saved...");
	}
}
