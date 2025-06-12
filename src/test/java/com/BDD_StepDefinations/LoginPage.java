package com.BDD_StepDefinations;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login;
import pages.PIM;

public class LoginPage {

	public static RemoteWebDriver driver = null;

	Logger log = Logger.getLogger(LoginPage.class);

    @Given("Open Browser")
    public void OpenBrowser() {
    	Login.launchBrowser();
    }
    @And("Pass url")
    public void PassURL() {
    	Login.EnterURL();
    }
	@When("enter username {string} and password {string}")
	public void enter_username_and_password(String username, String password) {
		Login.EnterUsername(username, password);

	}

	@And("click on loginButton")
	public void click_on_loginButton() {
		Login.clickLogin();
	}

	@Then("verify whether you are on DashBoardPage")
	public void verify_whether_you_are_on_DashBoardPage() {
		Login.verifySuccessFullLogin();
	}

	@And("Move to PIM Tab of side Bar")
	public void MovetoPIM() {
		Login.clickOnPIMMenu();

	}

}
