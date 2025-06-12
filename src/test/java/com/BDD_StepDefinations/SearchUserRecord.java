package com.BDD_StepDefinations;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import pages.SearchAddedUSer;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class SearchUserRecord {
	
	   @And("search for the added user in RecordList")
	    public void search_for_the_added_user_in_record_list() {
		 SearchAddedUSer.SearchAddedPIMUserRecord();
	    }

	    @Then("Take screenshot if record Found")
	    public void takescreenshot() {
	    	SearchAddedUSer.captureRecord();
	    }
}
