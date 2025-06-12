Feature: This file contains , Testcases for Login Page

Scenario: login to orange HRM site

    Given Open Browser
    And Pass url
    When enter username "<username>" and password "<password>" 
    And click on loginButton
    Then verify whether you are on DashBoardPage
    And Move to PIM Tab of side Bar
    And Click on AddButton
    And add EmployeDetails
    And click on SaveButton
    Then Move to EmployeeList Tab
    And search for the added user in RecordList
    Then Take screenshot if record Found
    Then Navigate to Recruitment tab
    And Open Candidates menu
    And Select status as "Shortlisted"
    And Click search button
    Then Verify "Shortlisted" candidates are displayed
    And Get List of "shorlisted" Candidates
    
 Examples:
  | username | password |
  | Admin    | admin123 |