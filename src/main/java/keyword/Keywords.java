package keyword;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;


import BrowserUtils.BrowserSetup;
import propertyBase.PropertyConfig;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Keywords {

    public static Logger log = Logger.getLogger(Keywords.class);

    public static WebElement getElement(By locator) {
        return BrowserSetup.driver.findElement(locator);
    }

    public static void navigateTo(String locatorUrlName) {
    	BrowserSetup.driver.get(PropertyConfig.getProperty(locatorUrlName));
        log.info("URL Passed and application is opening...");
    }

    public static void click(By locator) {
        getElement(locator).click();
    }

    public static void doubleClick(By locator) {
        new Actions(BrowserSetup.driver).doubleClick(getElement(locator)).perform();
    }

    public static void rightClick(By locator) {
        new Actions(BrowserSetup.driver).contextClick(getElement(locator)).perform();
    }

    public static void enterText(By locator, String text) {
        getElement(locator).sendKeys(text);
        log.info("Text entered: " + text);
    }

    public static void clearText(By locator) {
        getElement(locator).clear();
    }

    public static String getText(By locator) {
        return getElement(locator).getText();
    }

    public static void selectDropdownByVisibleText(By locator, String text) {
        new Select(getElement(locator)).selectByVisibleText(text);
        log.info("Dropdown selected: " + text);
    }

    public static void mouseHover(By locator) {
        new Actions(BrowserSetup.driver).moveToElement(getElement(locator)).perform();
        log.info("Mouse hovered over element");
    }
    
    public static void holdKey(Keys key) {
    	Actions action = new Actions(BrowserSetup.driver);
    	action.keyDown(key).perform();
    	log.info("🔐 held on key :"+key);
    }
    
    public static void releaseKey(Keys key) {
    	Actions action = new Actions(BrowserSetup.driver);
    	action.keyUp(key).perform();
    	log.info(key + " Key released");
    }

    public static void pressEnter(By locator) {
        getElement(locator).sendKeys(Keys.ENTER);
        log.info("Pressed Enter key");
    }

    public static void sendSpecialKey(By locator, Keys key) {
        getElement(locator).sendKeys(key);
        log.info("Sent special key: " + key.name());
    }

    public static void verifyText(String actual, String expected) {
        if (actual.equals(expected)) {
            log.info("✔ Text matched! ✅ Expected: '" + expected + "', Found: '" + actual + "'");
        } else {
            log.error("❌ Text Mismatch! Expected: '" + expected + "', Found: '" + actual + "'");
            Assert.fail("Text does not match.");
        }
    }

    public static void verifyElementPresent(By locator) {
        if (getElement(locator).isDisplayed()) {
            log.info("Element is present");
        } else {
            log.error("Element not visible");
        }
    }

    public static void verifyTitle(String expectedTitle) {
        String actual = BrowserSetup.driver.getTitle();
        Assert.assertEquals(actual, expectedTitle);
        log.info("✔ Page title verified: " + expectedTitle);
    }

    public static void verifyCurrentURL(String expectedURL) {
        String actual = BrowserSetup.driver.getCurrentUrl();
        Assert.assertEquals(actual, expectedURL);
        log.info("✔ URL verified: " + expectedURL);
    }

    public static void waitTillPresence(By locator) {
        new WebDriverWait(BrowserSetup.driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitTillClickable(By locator) {
        new WebDriverWait(BrowserSetup.driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitTillVisible(By locator) {
        new WebDriverWait(BrowserSetup.driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static boolean isdisplayed(By locator) {
    	return getElement(locator).isDisplayed();
    }
    
    public static boolean isEnabled(By locator) {
    	return getElement(locator).isEnabled();
    }
    
    public static boolean isSelected(By locator) {
    	return getElement(locator).isSelected();
    }
    
    public static void acceptAlert() {
        Alert alert = BrowserSetup.driver.switchTo().alert();
        alert.accept();
        log.info("Alert accepted");
    }

    public static void dismissAlert() {
        Alert alert = BrowserSetup.driver.switchTo().alert();
        alert.dismiss();
        log.info("Alert dismissed");
    }

    public static void switchToFrameByIndex(int index) {
    	BrowserSetup.driver.switchTo().frame(index);
        log.info("Switched to iframe index: " + index);
    }

    public static void switchToFrameByNameOrID(String nameOrID) {
    	BrowserSetup.driver.switchTo().frame(nameOrID);
        log.info("Switched to iframe: " + nameOrID);
    }

    public static void switchToWindow(String index) {
        String handle = BrowserSetup.driver.getWindowHandles().toArray()[Integer.parseInt(index)].toString();
        BrowserSetup.driver.switchTo().window(handle);
        log.info("Switched to window index: " + index);
    }
    
    public static void ScrollBy(int value) {
    	BrowserSetup.driver.executeScript("window.scrollBy(0,"+value+")");
    }
    

    public static void scrollToElement(By locator) {
        WebElement element = getElement(locator);
        ((JavascriptExecutor) BrowserSetup.driver).executeScript("arguments[0].scrollIntoView(true);", element);
        log.info("Scrolled to element: " + locator.toString());
    }
    

    public static void moveSliderToValue(int expectedValue) {
        WebElement slider = BrowserSetup.driver.findElement(By.xpath("//div[@id='slider']/span"));
        int width = BrowserSetup.driver.findElement(By.id("slider")).getSize().width;
        int maxValue = 100;
        double percentage = (expectedValue * 1.0) / maxValue;
        int xOffset = (int) (width * percentage);

        new Actions(BrowserSetup.driver).clickAndHold(slider).moveByOffset(xOffset - 1, 0).release().perform();
        log.info("✔ Slider moved to " + expectedValue);
    }

    public static void takeScreenshot(String fileName) {
        Screenshot src = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500))
                .takeScreenshot(BrowserSetup.driver);
        BufferedImage img = src.getImage();

        String path = System.getProperty("user.dir") + "/src/Screenshots/" + fileName + "_"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH-mm-ss")) + ".png";

        try {
            ImageIO.write(img, "png", new File(path));
            log.info("📸 Screenshot taken: " + path);
        } catch (IOException e) {
            log.error("❌ Screenshot failed. File path not found: " + path);
            e.printStackTrace();
        }
    }
    
    public static void uploadFile(By locator, String filePath) {
        getElement(locator).sendKeys(filePath);
        log.info("File selected for upload: " + filePath);
    }
} 
