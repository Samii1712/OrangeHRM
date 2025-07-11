package com.BDD_StepDefinations;




import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;

import pages.SearchAddedUSer;


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
