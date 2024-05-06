@E2E_user @all @user
Feature: End To End Admin Actions on Manage User Page
As an Admin, I want to add,edit,search user,assign it as staff/student and delete it

	 Scenario: Validate Admin can add,edit,search user,assign it as staff/student and delete it		

    Given Admin launch the browser
    When Admin gives the correct LMS portal URL 
    When Admin enter valid credentials and clicks login button 
    When Admin clicks "User" on the navigation bar
    When Admin clicks Add New User button
    When Admin enters valid data in all fields and clicks on submit button
    
		When Admin enters user name into search box.
		When Admin will see user displayed with the entered name
		
		When Admin clicks on the edit icon
		When Admin is on "User Details" pop up window to Edit
		When Update the fields with valid data and click submit
		When Admin gets message "User updated Successfully " and see the updated values in data table in Manage User
			
		When Admin enters user name into search box.		
		When Admin clicks the delete icon
		When Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion on Delete User
		When Admin clicks yes option
		Then Admin gets a message "Successful User Deleted" alert and do not see that user in the data table

