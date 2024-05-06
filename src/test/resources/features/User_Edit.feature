@User_Edit @all
Feature: Edit User Module
 As an Admin, I want to Edit User

	Background:
		Given Admin launch the browser
    And Admin gives the correct LMS portal URL 
    When Admin enter valid credentials and clicks login button 
    When Admin clicks "User" on the navigation bar
    When Admin clicks Add New User button
    When Admin is on  "User Details" Popup window
    When Admin enters valid data in all fields and clicks on submit button
    When Admin gets message "User added Successfully"
    When Admin clicks on the edit icon 
    When Admin is on "User details" pop up window to Edit
    

@EditUser_ValidData
Scenario: Admin checks if the fields are updated with valid data
When Update the fields with valid data and click submit
Then Admin gets message "User updated Successfully " and see the updated values in data table in Manage User

#
#@User28
#Scenario: Admin checks if the fields are updated with invalid values
#When Update the fields with invalid values and click submit
#Then Admin gets "Error message" 
#
#@User29
#Scenario: Admin checks if the mandatory fields are updated with valid data
#When Update the mandatory fields with valid values and click submit
#Then Admin gets message "User updated Successfully " and see the updated values in data table
#
#@User30
#Scenario: Admin checks if the optional fields are updated with valid data
#When Update the optional fields with valid values and click submit
#Then Admin gets message "User updated Successfully " and see the updated values in data table
#
#@User31
#Scenario: Admin validates invalid values in the text fields
#When Admin enters only numbers or special char in the text fields
#Then Admin gets "Error message"
#
#@User32
#Scenario: Admin validates Cancel button on Edit popup
#When Admin clicks Cancel button on edit popup
#Then Admin will see the User details popup disappears and can see nothing changed for particular User
#