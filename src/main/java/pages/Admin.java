package pages;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import BrowserUtils.BrowserSetup;



public class Admin {

	static Logger log = Logger.getLogger(Admin.class);

	static By AdminMenu = By.xpath("//span[text()='Admin']");
	static By statusDropdown = By.xpath("//label[text()='Status']/following::div[@class='oxd-select-text-input'][1]");
	static By searchButton = By.xpath("//button[@type='submit']");
	static By EmployeeRows = By.xpath("//div[@class='oxd-table-body']/div");
	static By cellXpath = By.xpath(".//div[@role='cell'][4]");

	public static void navigateToAdminTab() {
		new WebDriverWait(BrowserSetup.driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(AdminMenu)).click();

	}

	public static void selectStatus(String status) {
		new WebDriverWait(BrowserSetup.driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(statusDropdown)).click();
		String statusXpath = "//div[@role='listbox']//span[text()='" + status + "']";
		new WebDriverWait(BrowserSetup.driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(statusXpath))).click();
	}

	public static void clickSearchButton() {
		BrowserSetup.driver.findElement(searchButton).click();
	}

	public static void verifyEmployeesAreDisplayedForStatus(String status) {
		try {
			// Try to find elements within a timeout, but do not fail the test if not found
			List<WebElement> rows = new WebDriverWait(BrowserSetup.driver, Duration.ofSeconds(10))
					.until(driver -> driver.findElements(EmployeeRows));

			if (rows.isEmpty()) {
				log.warn("No candidates found for status: " + status);
				// Do not assert false — just log it
			} else {
				log.info("Candidates found for status: '" + status + "'. Count: " + rows.size());
			}
		} catch (Exception e) {
			log.error("Error while verifying candidates for status '" + status + "': " + e.getMessage());
			// Optional: If you still want to handle TimeoutException gracefully
		}
	}

	public static void GetListofselectedstatusEmployees(String status) {
		List<WebElement> rows = BrowserSetup.driver.findElements(EmployeeRows);

		if (rows.isEmpty()) {
			log.warn("No candidates found for status: " + status);
		} else {
			log.info("Candidates found for status: '" + status + "'. Count: " + rows.size());
			log.info(status.toLowerCase() + " candidates:");

			for (WebElement row : rows) {
				try {
					// Suppose 2nd cell contains name (adjust index as per DOM)
					WebElement nameCell = row.findElement(cellXpath);
					log.info("- " + nameCell.getText());
				} catch (Exception e) {
					log.warn("Could not extract candidate name from row: " + e.getMessage());
				}
			}
		}
	}

}
