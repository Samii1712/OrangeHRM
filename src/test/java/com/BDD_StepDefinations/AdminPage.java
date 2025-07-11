package com.BDD_StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Admin;

public class AdminPage {
     
	@Then("Navigate to Admin tab")
	public void navigate_To_Admin_Tab() {
		Admin.navigateToAdminTab();
	}

	@And("Select status as {string}")
	public void select_Status(String status) {
		Admin.selectStatus(status);
	}

	@And("Click search button")
	public void click_Search_Button() {
		Admin.clickSearchButton();
	}

	@Then("Verify {string} Employees are displayed")
	public void verify_employees_are_displayed(String status) {
	    Admin.verifyEmployeesAreDisplayedForStatus(status);
	}
	@And("Get List of {string} Employees")
	public void Get_List_of_Employees(String status) {
		Admin.GetListofselectedstatusEmployees(status);
	}

}
