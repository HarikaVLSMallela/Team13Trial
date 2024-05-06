@all
Feature: Student_Assign_Module_just_validate


   Background:
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL 
    When Admin enter valid credentials and clicks login button 
    When Admin clicks "User" on the navigation bar
 
 

@ValidateAssignStudentPopUp
Scenario: Validate Assign Student Popup window
Given: Admin is in manage user page
When Admin clicks student "Assign Student" button
Then Admin should see a pop up open for assign student details with empty form along with <Save> and <Cancel> button and close (X) icon on the top right corner of the window   

@ValidateAssignStudentValues
Scenario: Validate input fields and their text boxes in Assign Student form 
Given: Admin is in manage user page
When Admin clicks student "Assign Student" button
Then Admin should see User Role as R03,and other fields Student Email id,Program Name,Batch Name and Status with respective input boxes.

@ValidateDropDownStudent
Scenario: Validate Dropdown in Assign Student Form
Given: Admin is in manage user page
When Admin clicks student "Assign Student" button
Then Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name 

@ValidateRadioButtonActiveInActive
Scenario: Validate radio button in Assign Student Form
Given: Admin is in manage user page
When Admin clicks student "Assign Student" button
Then Admin should see two radio button for Status active and inactive
