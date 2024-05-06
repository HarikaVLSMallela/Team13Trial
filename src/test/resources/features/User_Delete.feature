@User_Delete @all
Feature: User Delete Module
 As an Admin, I want to delete a User

Background:
		Given Admin launch the browser
    And Admin gives the correct LMS portal URL 
    When Admin enter valid credentials and clicks login button 
    When Admin clicks "User" on the navigation bar
    When Admin enters user name into search box.

	@User_Confirm_PopUp
	Scenario: Admin validates row level delete icon
	When Admin clicks the delete icon
	Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion on Delete User

   @UserDel_Yes
		Scenario: Admin clicks Yes on deletion window
		Given Admin clicks the delete icon
		When Admin clicks yes option
		Then Admin gets a message "Successful User Deleted" alert and do not see that user in the data table

#@UserDel_No
#Scenario: Admin clicks No on deletion window
#Given Admin is on Confirm Deletion alert
#When Admin clicks  No option
#Then Admin will see the deletion alert disappears without deleting
#
#@UserDel_Close
#Scenario: Validate Close(X) icon on Confirm Deletion alert
#When Admin clicks on close button
#Then Admin can see the deletion alert disappears without any changes


#/*********************    @Delete_multiple_users     *********************
#
#
#Background: Admin is on dashboard page after Login and clicks user on the navigation bar
#Scenario: Validate Common Delete button enabled after clicking on any checkbox
#Given: Admin is in Manage User page
#When Admin clicks any checkbox in the data table
#Then Admin should see common delete option enabled under header Manage Program
#
#
#
#Background: Admin clicks delete button under header 
#after selecting the check box in the data 
#table
#Scenario: Validate multiple program deletion by selecting Single checkbox
#Given: Admin is on Confirm Deletion alert
#When Admin clicks <YES> button on the alert
#Then Admin should land on Manage User page and can see the selected user is deleted from the data table
#
#Scenario: Validate multiple program deletion by selecting Single checkbox
#Given: Admin is on Confirm Deletion alert
#When Admin clicks <No> button on the alert
#Then Admin should land on Manage User page and can see the selected user is not deleted from the data table
#
#Background: Admin clicks delete button under header after selecting multiple checkboxes in the data table
#Scenario: Validate multiple program deletion by selecting multiple check boxes
#Given: Admin is on Confirm Deletion alert
#When Admin clicks <YES> button on the alert
#Then Admin should land on Manage User page and can see the selected users are deleted from the data table
#
#
#Scenario: Validate multiple program deletion by selecting multiple check boxes
#Given: Admin is on Confirm Deletion alert
#When Admin clicks <No> button on the alert
#Then Admin should land on Manage User page and can see the selected users are not deleted from the data table
#