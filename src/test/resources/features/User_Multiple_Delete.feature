@all
Feature: User multiple  Delete Module
 As an Admin, I want to delete multiple User

Background:
		Given Admin launch the browser
    And Admin gives the correct LMS portal URL 
    When Admin enter valid credentials and clicks login button 
    When Admin clicks "User" on the navigation bar

@UserCommonDeletButtonValidation
Scenario: Validate Common Delete button enabled for user after clicking on any checkbox
Given: Admin is in Manage User page
When Admin clicks any checkbox in the user data table
Then Admin should see common delete option enabled under header Manage user


@DeleteMultipleSingleCheckboxYes
Scenario: Validate multiple user  deletion by selecting Single checkbox
	  Given Admin clicks any checkbox in the user data table for deletion
	  And Admin clicks on Multple Delete button on Manage User Page
	  When Admin clicks "Yes" button on  Confirm Deletion alert for User
		Then Admin should land on Manage User page and can see the selected user are deleted from the data table

@DeleteMultipleUserMultipleCheckboxYes
Scenario: Validate multiple user deletion by selecting multiple check boxes 
Given: Admin clicks any checkbox in the user data table for deletion
When Admin clicks "Yes" button on  Confirm Deletion alert for User
Then Admin should land on Manage User page and can see the selected users are deleted from the data table

@DeleteMultipleSingleCheckboxNo
Scenario: Validate multiple user  deletion by selecting Single checkbox
	  Given Admin clicks any checkbox in the user data table for deletion
	  And Admin clicks on Multple Delete button on Manage User Page
	  When Admin clicks "No" button on  Confirm Deletion alert for User
		Then Admin should land on Manage User page and can see the selected user are deleted from the data table

@DeleteMultipleUserMultipleCheckboxNo
Scenario: Validate multiple user deletion by selecting multiple check boxes 
Given: Admin clicks any checkbox in the user data table for deletion
When Admin clicks "No" button on  Confirm Deletion alert for User
Then Admin should land on Manage User page and can see the selected users are deleted from the data table
