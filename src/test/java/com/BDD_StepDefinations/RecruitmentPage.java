package com.BDD_StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Recruitment;

public class RecruitmentPage {
     
//	@And("Move to Recruitment tab")
//	public void Move_to_Recruitment_tab() {
//		Recruitment.MoveToRecruitmentTab();
//	}
//	
//	@Then("From record List return the shortlisted Candidates List")
//	public void Return_Shortlisted_List() {
//		
//	}
	
	@Then("Navigate to Recruitment tab")
	public void navigate_To_Recruitment_Tab() {
		Recruitment.navigateToRecruitmentTab();
	}

	@And("Open Candidates menu")
	public void open_Candidates_Menu() {
		Recruitment.openCandidatesMenu();
	}

	@And("Select status as {string}")
	public void select_Status(String status) {
		Recruitment.selectStatus(status);
	}

	@And("Click search button")
	public void click_Search_Button() {
		Recruitment.clickSearchButton();
	}

	@Then("Verify {string} candidates are displayed")
	public void verify_candidates_are_displayed(String status) {
	    Recruitment.verifyCandidatesAreDisplayedForStatus(status);
	}
	@And("Get List of {string} Candidates")
	public void Get_List_of_Candidates(String status) {
		Recruitment.GetListofslectedstatusCandidates(status);
	}

}
