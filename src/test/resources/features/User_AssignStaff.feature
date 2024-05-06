@User_AssignStaff @all
Feature: User Module
 As an Admin, I want to Assign User as Staff

	Background: 
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL 
    When Admin enter valid credentials and clicks login button 
    When Admin clicks "User" on the navigation bar
    When Admin clicks Add New User button
    When Admin enters valid data in all fields and clicks on submit button
		
		@AssignStaff02_EnterValidData		
		Scenario:
    When Admin clicks Assign Staff button       
    Given Admin is in "Assign User" pop up page
		When Enter all required fields with valid values and click Save button
		Then Admin gets a message "Successfully Staff Assigned" alert
    
    