@all
Feature: Student_Assign_Module


   Background:
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL 
    When Admin enter valid credentials and clicks login button 
    When Admin clicks "User" on the navigation bar
    When Admin clicks Assign student button
  
    
@AssignStudentError
Scenario: Empty Form Submission
Given: Admin is in Assign Student details pop up page
When Admin clicks Save button without entering any data
Then Admin gets a "Error Message." alert 


@AssignStudentProgramError
Scenario: Validate the Assign Student form page without selecting Program
Given: Admin is in Assign Student details pop up page
When: Admin clicks "Save" button without selecting program for student
Then: Admin gets a Error message alert for student as "Program is required"

@AssignStudentBatchError
Scenario: Validate the Assign Student form page without selecting Program
Given: Admin is in Assign Student details pop up page
When: Admin clicks "Save" button without selecting batch for student
Then: Admin gets a Error message alert for student as "Batch is required" 

@AssignStudentStatusError
Scenario: Validate the Assign Student form page without giving Status
Given: Admin is in Assign Student details pop up page
When: Admin clicks "Save" button without giving status for student
Then: Admin gets a Error message alert for student as "Status is required" error

@ValidateSaveButtonAllValidFields
Scenario: Validate Save button on Assign Student form
Given: Admin is in "Assign Student" student details pop up page
When Enter all the required student fields with valid values and click Save button
Then Admin gets a message "Successfully Student Assigned" alert sucesfully student Assignment

@ValidateCancelButtonAllValidFields
Scenario: Validate Cancel button on Assign Student form
Given: Admin is in "Assign Student"  pop up page
When Enter all the required student fields with valid values and click Cancel button
Then Admin can see the Assign Student popup disappears without assigning 

@AssignStudentEmailError
Scenario: Validate the Assign Student form page without giving Student Email id
Given: Admin is in Assign Student details pop up page here
When: Admin clicks "Save" button without entering Student Email id in the student form
Then: Admin gets a Email Error message alert for student "Student Email id is required" error in student form

