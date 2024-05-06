@Program @all @program_add
Feature: Program Module
 As an Admin, I want to add/edit a Program

	Background:
    Given Admin launch the browser
    Given Admin gives the correct LMS portal URL 
    Given Admin enter valid credentials and clicks login button 
    Given Admin clicks "Program" on the navigation bar
    Given Admin clicks A New Program button
    Given Enter all the required fields with valid values and click "Save" button
   
  @editName_Yes @positive
  Scenario: Edit Program Name
	Given Admin enters existing program name in search box on Manage Program page
  Given Admin clicks Edit button of the found result
  When Admin edits the Name field and clicks save button
  Then Admin gets a message "Successful Program Updated" alert and able to see the updated name in the table for the particular program
  
  Then Admin enters existing program name in search box on Manage Program page
  Then Admin clicks on clicks <Delete> button on the data table on Manage Program page
  When Admin clicks <YES> button on the alert
	Then Admin gets a message "Successful Program Deleted" alert and able to see that program deleted in the data table
  
  
  @editDescription_Yes @positive
  Scenario: Edit Program description
  Given Admin enters existing program name in search box on Manage Program page
  Given Admin clicks Edit button of the found result
  Given Admin edits the Name field and clicks save button 
  Given Admin enters edited program name in search box on Manage Program page
  Given Admin clicks Edit button of the found edited program
  When Admin edits the Description column and clicks save button
  Then Admin gets a message "Successful Program Updated" alert and able to see the updated description in the table for the particular program
  
  Then Admin enters existing program name in search box on Manage Program page
  Then Admin clicks on clicks <Delete> button on the data table on Manage Program page
  When Admin clicks <YES> button on the alert
	Then Admin gets a message "Successful Program Deleted" alert and able to see that program deleted in the data table
  
  @editstatus_Yes @positive
  Scenario: Change Program Status 
  Given Admin enters existing program name in search box on Manage Program page
  Given Admin clicks Edit button of the found result
  Given Admin edits the Name field and clicks save button
  
  Given Admin enters edited program name in search box on Manage Program page
  Given Admin clicks Edit button of the found edited program
  Given Admin edits the Description column and clicks save button
 
  Given Admin enters edited program name in search box on Manage Program page
  Given Admin clicks Edit button of the found edited program
  When Admin changes the Status and clicks save button
  Then Admin gets a message "Successful Program Updated" alert and able to see the updated status in the table for the particular program
  
  Then Admin enters edited program name in search box on Manage Program page
  Then Admin clicks on clicks <Delete> button on the data table on Manage Program page
  When Admin clicks <YES> button on the alert
	Then Admin gets a message "Successful Program Deleted" alert and able to see that program deleted in the data table
  
  
  @EditProgramDetails_invalidData @negative
  Scenario Outline: Validate invalid values on the text column
  Given Admin enters existing program name in search box on Manage Program page
  When Admin clicks Edit button of the found result
  When Admin enters data from <rowNum> of "<sheet>" in name and desc column on Program Details Page
	Then Admin gets a Error message alert on Program Details Page for invalid data
	
	Then Admin clicks <Cancel> button on edit popup	
	Then Admin enters existing program name in search box on Manage Program page
  Then Admin clicks on clicks <Delete> button on the data table on Manage Program page
  Then Admin clicks <YES> button on the alert
	Then Admin gets a message "Successful Program Deleted" alert and able to see that program deleted in the data table
	
	Examples:
      | rowNum    | sheet                     |
      | 0         | ProgramDetails_InvalidData|
      | 1         | ProgramDetails_InvalidData|
      | 2         | ProgramDetails_InvalidData|
      | 3         | ProgramDetails_InvalidData|
      | 4         | ProgramDetails_InvalidData|
      | 5         | ProgramDetails_InvalidData|
      | 6         | ProgramDetails_InvalidData|
      | 7         | ProgramDetails_InvalidData|
      | 8         | ProgramDetails_InvalidData|
      | 9         | ProgramDetails_InvalidData|
      | 10        | ProgramDetails_InvalidData|
      | 11        | ProgramDetails_InvalidData|
      | 12        | ProgramDetails_InvalidData|
  
  
  @EditProgram_Cancel 
  Scenario: Validate Cancel button on Edit popup
	Given Admin enters existing program name in search box on Manage Program page
  Given Admin clicks Edit button of the found result
  Given Admin edits both Name and Description edit box
  When Admin clicks <Cancel> button on edit popup
  Then Admin can see the Program details popup disappears and can see nothing changed for particular program
  
  Then Admin clicks on clicks <Delete> button on the data table on Manage Program page
  Then Admin clicks <YES> button on the alert
	Then Admin gets a message "Successful Program Deleted" alert and able to see that program deleted in the data table
  
 
  