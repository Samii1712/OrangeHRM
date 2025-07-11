package com.BDD_StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.PIM;


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

