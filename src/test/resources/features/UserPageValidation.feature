@all
Feature: User Page

#Feature_User_Page_Validation
	Background:
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL 
    When Admin enter valid credentials and clicks login button 
    When Admin clicks "User" on the navigation bar
    
###################### User Page Validation #################################

@User01
Scenario: Validate landing in User page
Given Admin is on Manage User Page
Then Admin should see URL with "Manage User"

@User02
Scenario: Validate the heading
Then Admin should see the "Manage user" in the header

#@User03
#Scenario: Validate the text and pagination icon below the data table
#Then Admin should see the "text" along with Pagination icon below the table 
#
#@User04
#Scenario: Validate data table headers in the User Page
#Then Admin should see the data table with "column names", Id, Name, location, Phone Number, Edit/Delete

@User05
Scenario: Validating the default state of Delete button
Then Admin should be able to see the Delete icon button that is disabled

@User06
Scenario: Validate "+ Add New user" button in User Page
Then Admin should see the Add New User button above the data table

@User07
Scenario: Validate "+ Assign staff"  button in User page
Then Admin should see the + Assign staff button above the data table

@User08
Scenario: Validate "+ Assign Student"  button in User page
Then Admin should see the + Assign Student button above the data table

@User09
Scenario: Validate search box in User page
Then Admin should see the search text box above the data table

#@User10
#Scenario: Admin validates number of data rows in the data table
#Then Admin should see the number of records  displayed on the page are 5

#@User11
#Scenario: Admin verifies Check box on the data table
#Then each row in the data table should have a checkbox
#
#@User12
#Scenario: Admin verifies edit icon on the data table
#Then Each row in the data table should have a edit icon that is enabled
#
#@User13
#Scenario: Admin verifies delete icon on the data table
#Then Each row in the data table should have a delete icon that is enabled
#



#@User15
#Scenario: Admin validates the Search with unrelated keyword
#When Admin enters the "keywords" not present in the data table on the Search box 
#Then Admin will see zero entries on the data table
#


#@Feature_Sort_User

###################### Sorting(DataOrdering)Validation #################################  
 
      
  @Sorting_User_ascending
  Scenario Outline: Validates Sorting(data ordering) on the User Data table
  When Admin clicks the sort icon of "<colName>" column in User Data Table
  Then The data get sorted on the table based on the column name values in ascending order
  
  Examples:
  |colName     |
  |ID       	 |
  |Name				 |
  |Location    |
  |Phone Number|
  
  @Sorting_User_descending
  Scenario Outline: Validates Sorting(data ordering) on the User Data table
  When Admin clicks the sort icon of "<colName>" column twice User Data Table
  Then The data get sorted on the table based on the column name values in descending order
  
  Examples:
  |colName     |
  |ID       	 |
  |Name				 |
  |Location    |
  |Phone Number|


@AddNewUser_PopUp
Scenario: Validate User Details Popup window
When Admin clicks Add New User button
Then Admin should see a popup open for "User Details" with empty form along with <SAVE> and <CANCEL> button and Close (X) Icon on the top right corner of the window


#@AddNewUser17
#Scenario: Admin validates input fields and text boxes in user details form
#Then Admin will see text boxes for the fields First Name, Middle name, Last Name, Location, phone, email, linkedin url, Undergraduate, postgraduate,time zone ,user comments
#
#@AddNewUser18
#Scenario: Admin validates drop downs in new user form
#Then Admin will see drop downs for the fields User Role, Role status, visa status on user details pop up
#
#
#@EditUser_PopUp26
#Scenario: Admin validates row level edit icon
#Then Admin is on "User details" pop up window to Edit






  


#
#@Assign_Students
#Background: Logged on the LMS portal
#Admin is on dashboard page after Login
#Admin clicks "User" from navigation bar
#Scenario: Validate Assign Student Popup window
#Given: Admin is in manage user page
#When Admin clicks "Assign Student" button
#Then Admin should see a pop up open for assign student details with empty form along with Save and Cancel button
     #and close (X) icon on the top right corner of the window
     #
#Scenario: Validate input fields and their text boxes in Assign Student form 
#Given: Admin is in manage user page
#When Admin clicks "Assign Student" button
#Then Admin should see User Role as R03,and other fields Student Email id,Program Name,Batch Name and Status with
     #respective input boxes.
     #
#Scenario: Validate Dropdown in Assign Student Form
#Given: Admin is in manage user page
#When Admin clicks "Assign Student" button
#Then Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name
#
#Scenario: Validate radio button in Assign Student Form
#Given: Admin is in manage user page
#When Admin clicks "Assign Student" button
#Then Admin should see two radio button for Status
#
#Background: Admin is on Manage User Page after clicks User on the navigation bar
#Scenario: Empty Form Submission
#Given: Admin is in Assign Student details pop up page
#When Admin clicks "Save" button with entering any data
#Then Admin gets a Error message alert 











