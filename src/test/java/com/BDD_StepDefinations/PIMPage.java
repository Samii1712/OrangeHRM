package com.BDD_StepDefinations;



import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import javax.imageio.ImageIO;
import java.io.File;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.PIM;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class PIMPage {
   
    @And("Click on AddButton")
    public void clickAddButton() {
    PIM.clickAdduserButton();
    }

    @And("add EmployeDetails")
    public void AddDetails() {
    	PIM.AdduserDetails();
    }

    @And("click on SaveButton")
    public void clickOnAddButton() {
    	PIM.clickSave();
    }

    @Then("Move to EmployeeList Tab")
    public void MovetoEmployeeList() {
    	PIM.moveToEmployeeListTab();
    }

   
}

