package pages;

import java.time.Duration;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BrowserUtils.BrowserSetup;

public class PIM {
	static Logger log = Logger.getLogger(PIM.class);

	
	static By Addbutton = By.xpath("//button[contains(.,'Add')]");
	static By AddEmployeeTab = By.xpath("//h6[text()='Add Employee']");
	static By FirstName = By.xpath("//input[@name='firstName']");
	static By MiddleName = By.xpath("//input[@name='middleName']");
	static By LastName = By.xpath("//input[@name='lastName']");
	static By userID = By.xpath("//label[text()='Employee Id']/../following-sibling::div//input");
	static By saveUserDetails = By.xpath("//button[@type='submit']");
	static By EdituserDetails = By.xpath("//h6[text()='Personal Details']");
	static By EmployeeListTab = By.xpath("//a[text()='Employee List']");
	static By EmployeeID = By.xpath("//label[text()='Employee Id']");

	public static String enteredFirstName;
	public static String enteredMiddleName;
	public static String enteredLastName;
	public static String randomNumber;

	public static String randomString() {
		return RandomStringUtils.randomAlphabetic(6).toLowerCase();
	}

	public static String randomNumber() {
		Random ran = new Random();
		return String.valueOf(1000 + ran.nextInt(9000)); // 4-digit number
	}

	

	public static void clickAdduserButton() {
		new WebDriverWait(BrowserSetup.driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(Addbutton)).click();
		log.info("Clicked Adduser Button...");
	}

	public static void AdduserDetails() {
		new WebDriverWait(BrowserSetup.driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.presenceOfElementLocated(AddEmployeeTab));

		enteredFirstName = randomString();
		enteredMiddleName = randomString();
		enteredLastName = randomString();
		randomNumber = randomNumber();

		BrowserSetup.driver.findElement(FirstName).sendKeys(enteredFirstName);
		BrowserSetup.driver.findElement(MiddleName).sendKeys(enteredMiddleName);
		BrowserSetup.driver.findElement(LastName).sendKeys(enteredLastName);

		WebElement empIdInput = new WebDriverWait(BrowserSetup.driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(userID));

		empIdInput.clear();
		empIdInput.sendKeys(randomNumber);
		
		log.info("Added user details...");
	}

	public static void clickSave() {
		BrowserSetup.driver.findElement(saveUserDetails).click();

		new WebDriverWait(BrowserSetup.driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(EdituserDetails));
	log.info("User added Successfully...");
	}

	public static void moveToEmployeeListTab() {
		BrowserSetup.driver.findElement(EmployeeListTab).click();
		new WebDriverWait(BrowserSetup.driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(EmployeeID));
	log.info("moved to employee list...");
	}
}
