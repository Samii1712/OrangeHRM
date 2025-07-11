Feature: This file contains,Testcases for OrangeHRM Automation

Scenario Outline: login to orange HRM site  and  and Search enabled employees list and return it.
    When enter username "<username>" and password "<password>"
    And click on loginButton
    Then verify whether you are on DashBoardPage

    Examples: 
      | username | password |
      | Admin    | admin123 |

Scenario Outline: Add employee in PIM tab
    And Move to PIM Tab of side Bar
    And Click on AddButton
    And add EmployeDetails
    And click on SaveButton

Scenario Outline: Search added user in Employee list
    Then Move to EmployeeList Tab
    And search for the added user in RecordList
    Then Take screenshot if record Found

Scenario Outline: Navigate to Admin tab and search Enabled status Employees
    Then Navigate to Admin tab
    And Select status as "Enabled"
    And Click search button
    Then Verify "Enabled" Employees are displayed
    And Get List of "Enabled" Employees
