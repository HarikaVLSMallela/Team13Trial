@User_Add @user @all
Feature: Add User Module
 As an Admin, I want to add new User

	Background:
		Given Admin launch the browser
    And Admin gives the correct LMS portal URL 
    When Admin enter valid credentials and clicks login button 
    When Admin clicks "User" on the navigation bar
    When Admin clicks Add New User button
    
  @Additional_User_EnterAll_Valid_Data
	Scenario: Admin checks if user is created when valid datas are entered
	When Admin enters valid data in all fields and clicks on submit button
	Then Admin gets message "User added Successfully"
	
@Additional_User_Only_Mandatory_fields
Scenario: Check if user is created when only mandatory fields are entered with valid data
When Admin enters mandatory fields in the form and clicks on submit button
Then Admin gets message "User added Successfully"
	
	#@User20
#Scenario: Admin checks if user is created when only optional fields are entered with valid data
#Given Admin is on  User details pop up
#When Admin skips to add value in mandatory field
#Then Admin will see "error message" below the test field and the field will be highlighed in red color
#
#@User21
#Scenario: Admin checks if user is created when invalid data is entered in all of the fields
#Given Admin is on  User details pop up
#When Admin enters invalid data in all of the fields in the form and clicks on submit button
#Then Admin gets "error message" and user is not created
#
#@User22
#Scenario: Empty form submission
#Given Admin is on  User details pop up
#When Admin clicks on submit button without entering data 
#Then user is not created and Admin gets "error message"
#
#@User23
#Scenario: Admin validates Cancel/Close(X) icon on User Details form
#Given Admin is on  User details pop up
#When Admin clicks Cancel/Close(X) Icon on User Details form 
#Then User Details popup window will be closed without saving
#
#@User24
#Scenario: Admin validates Cancel button on User Details form
#Given Admin is on  User details pop up
#When Admin clicks Cancel button 
#Then Admin can see the User details popup disappears without adding any user
#
#@User25
#Scenario: Admin checks if the user details are added in data table
#Given Admin is on  User details pop up
#When Fill in all the fields with valid values and click submit
#Then The newly added user will be present in the data table in Manage User page

