@Program @all @program_add

Feature: Program Module
 As an Admin, I want to add a Program

	Background:
    Given Admin launch the browser
    Given Admin gives the correct LMS portal URL 
    Given Admin enter valid credentials and clicks login button 
    Given Admin clicks "Program" on the navigation bar
    When Admin clicks A New Program button
 
	  @AddNewProgram_Yes @positive
	  Scenario: Validate Save button on Program Details form
	  Given Admin is on "Program Details" Popup window
	  When Enter all the required fields with valid values and click "Save" button
	  Then Admin gets a message "Successful Program Created" alert and able to see the new program added in the data table
  
  	Then Admin clicks on clicks <Delete> button on the data table on Manage Program page
  	When Admin clicks <YES> button on the alert
		Then Admin gets a message "Successful Program Deleted" alert and able to see that program deleted in the data table
  
	  @AddNewProgram_Cancel
	  Scenario: Validate Save button on Program Details form
	  Given Enter all the required fields with valid values and click "Cancel" button
	  When Admin can see the Program details popup disappears without creating any program
  
	  @AddNewProgram_Close
	  Scenario: Validate invalid values on the text column
	  And Enter all the required fields with valid values and click "Close" button
	  When Admin can see the Program details popup disappears without creating any program
     
  	@AddNewProgram_Buttonvalidation
		Scenario: Validate Program Details Popup window
		Then Admin should see a popup open for "Program Details" with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window
   
  	@AddNewProgram_textBoxvalidation
		Scenario: Validate input fields and their text boxes in Program details form 
		Then Admin should see two input fields and their respective text boxes in the program details window
		
		@AddNewProgram_radioButtonvalidation
		Scenario: Validate radio button for Program Status
		Then Admin should see two radio button for Program Status

		@emptyForm
		Scenario: Empty form submission
		When Admin clicks <Save> button without entering any data on Program Details Page
		Then Admin gets error messages on Program Details Page
		
		@OnlyProgName_formSubmission
		Scenario: Enter only Program Name
		When Admin enters only "Program Name" in text box and clicks Save button on Program Details Page
		Then Admin gets a message alert "Description is required" on Program Details Page  
		

		@OnlyProgDesc_formSubmission
		Scenario: Enter only Program Description
		When Admin enters only "Program description" in text box and clicks Save button on Program Details Page
		Then Admin gets a message alert "Name is required" on Program Details Page



		@OnlyProgStatus_formSubmission
		Scenario: Select Status only
		When Admin selects only Status and clicks Save button on Program Details Page
		Then Admin gets a message alert 'Name and Description required' on Program Details Page


		@ProgramDetails_invalidData @excel @negative
		Scenario Outline: Validate invalid values on the text column
		When Admin enters data from <rowNum> of "<sheet>" in name and desc column on Program Details Page
		Then Admin gets a Error message alert on Program Details Page for invalid data
	
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
    
  	@ProgramDetails_invalidData @boundary_testing @negative
		Scenario Outline:: Boundary Testing for Program Name field
		When Admin enters "<editBoxName>" of "<moreOrLess>" than <StringCharacterLength> character length
		Then Admin gets an err "<expectedErrMsg>" for invalid data on Program Details Page		

		Examples:
		|editBoxName        | moreOrLess| StringCharacterLength|expectedErrMsg|
		|Program Name       | more	    |   26                 |This field should start with an alphabet, no special char and min 2 char.|
		|Program Name       | less	    |   2                  |This field should start with an alphabet, no special char and min 2 char.|
		|Program Description| less	    |   2                  |This field should start with an alphabet and min 2 char.|
   
   
  