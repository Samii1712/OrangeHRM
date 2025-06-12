package pages;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebElement;


import BrowserUtils.BrowserSetup;

public class Recruitment {
	
	  static Logger log  = Logger.getLogger(Recruitment.class);
	  
	  static By RecruitmentMenu = By.xpath("//span[text()='Recruitment']");
      static By CandidatesTab =  By.xpath("//a[contains(text(),'Candidates')]");
      static By statusDropdown = By.xpath("//label[text()='Status']/following::div[@class='oxd-select-text-input'][1]");
      static By searchButton = By.xpath("//button[@type='submit']");
      static By candidateRows = By.xpath("//div[@class='oxd-table-body']/div");
      
	  
	  public static void navigateToRecruitmentTab() {
		  new WebDriverWait(BrowserSetup.driver, Duration.ofSeconds(10)).until(
				  ExpectedConditions.elementToBeClickable(RecruitmentMenu)).click();
		 
		}
	  public static  void openCandidatesMenu() {
		  new WebDriverWait(BrowserSetup.driver, Duration.ofSeconds(10)).until(
				  ExpectedConditions.elementToBeClickable(CandidatesTab)).click();
		}
	  public static void selectStatus(String status) {
		  new WebDriverWait(BrowserSetup.driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(statusDropdown)).click();
		    String statusXpath = "//div[@role='listbox']//span[text()='" + status + "']";
		    new WebDriverWait(BrowserSetup.driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(statusXpath))).click();
		}
	  public static void clickSearchButton() {
		  BrowserSetup.driver.findElement(searchButton).click();
		}
	  public static void verifyCandidatesAreDisplayedForStatus(String status) {
		    List<WebElement> rows = new WebDriverWait(BrowserSetup.driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.presenceOfAllElementsLocatedBy(candidateRows));

		    Assert.assertTrue(rows.size() > 0, "No candidates found for status: " + status);
		    log.info("Candidates found for status: '" + status + "'. Count: " + rows.size());
		}
	  public static void GetListofslectedstatusCandidates(String status) {
		  List<WebElement> rows = BrowserSetup.driver.findElements(candidateRows);

		    if (rows.size() == 0) {
		        log.warn("No candidates found for status: " + status);
		    } else {
		        log.info("Candidates found for status: '" + status + "'. Count: " + rows.size());
		        log.info(status.toLowerCase() + " candidates:");
		        
		        for (WebElement row : rows) {
		            try {
		                // Suppose 2nd cell contains name (adjust index as per DOM)
		                WebElement nameCell = row.findElement(By.xpath(".//div[@role='cell'][3]"));
		                log.info("- " + nameCell.getText());
		            } catch (Exception e) {
		                log.warn("Could not extract candidate name from row: " + e.getMessage());
		            }
		        }
		    }
	  }
}
