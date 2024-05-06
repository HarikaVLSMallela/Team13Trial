@Program @all
Feature: Program Module
 As an Admin, I want to navigate to Program Page and add/edit/delete Program

	Background:
    Given Admin launch the browser
    Given Admin gives the correct LMS portal URL 
    Given Admin enter valid credentials and clicks login button 
    When Admin clicks "Program" on the navigation bar
    
    
   ##################### Manage Program Validation ################################
    
		Scenario: Validate landing in Program page
		Given Admin is on Manage Program page		
    Then Admin should see URL with "Manage Program"
    
    ###################### Seach box feature and functionality validation ***********************

	  @ProgValidation_searchInnerText
	  Scenario: Verify Search bar on the Program page
	  Then Admin should see Search bar with text as "Search..."
	  
	  @ProgSearchFunctionality_ProgName
	  Scenario: Verify Search bar on the Program page
	  When Admin enters existing program name in search box on Manage Program page
	  Then Admin should see record
	  
	  @ProgSearchFunctionality_ProgDesc
	  Scenario: Verify Search bar on the Program page
	  When Admin enters existing programs description in search box on Manage Program page
	  Then Admin should see matching record/s
	  
	  ######################## Program Details Through Edit Btn Validation ##################
	  @ValidateEditFeature
   	Scenario: Validate Edit Feature
   	When Admin clicks Edit button on the data table for any row
   	Then Admin should see a popup for Program details to edit
	  

	  ##################### Delete Program ################################
 
  	@ProgDel_deleteFeature
  	Scenario: Verify Delete Feature
	  When Admin clicks <Delete> button on the data table for any row
	  Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion
  
	  @ProgDel_deleteMsg
	  Scenario: Validate details for Confirm Deletion form
	  When Admin clicks <Delete> button on the data table for any row
	  Then Admin should see a message "Are you sure you want to delete <Program name>?"
  
 		@ProgDel_clickYes
  	Scenario: Click Yes on deletion window
	  Given Admin clicks <Delete> button on the data table for any row
	  When Admin clicks <YES> button on the alert
	  Then Admin gets a message "Successful Program Deleted" alert and able to see that program deleted in the data table
  
 		@ProgDel_clickNo @ProgDel_clickClose
  	Scenario Outline: Validate Click No AND Cancel/Close(X) icon on Confirm Deletion window
	  Given Admin clicks "Program" on the navigation bar
	  And Admin is on Manage Program page
	  And Admin clicks <Delete> button on the data table for any row
	  When Admin clicks "buttonName" button on the alert
	  Then Admin can see the deletion alert disappears without deleting
  	
  	Examples:
      | buttonName|
      | No        |
      | Close     |
  
 	  ##################### Multiple Delete Program ################################
 
 		@MultipleProgDel_buttonEnabled
  	Scenario: Validate Common Delete button enabled after clicking on any checkbox
	  Given Admin is on Manage Program page
	  When Admin clicks any checkbox in the data table
	  Then Admin should see common delete option enabled under header Manage Program
	  
 		@MultipleProgDel_confirmDelMsg @Additional
  	Scenario: Validate message on Confirm Deletion alert
	  Given Admin clicks any checkbox in the data table
	  When Admin clicks on Multple Delete button on Manage Program Page
		Then Admin should see "Are you sure you want to delete the selected programs?" on Confirm Deletion alert	  

 		@MultipleProgDel_singleRecordYES
  	Scenario: Validate multiple program deletion by selecting Single checkbox
	  Given Admin clicks any checkbox in the data table
	  And Admin clicks on Multple Delete button on Manage Program Page
	  When Admin clicks "YES" button on  Confirm Deletion alert 
		Then Admin should land on Manage Program page and can see the selected program is deleted from the data table
	
 		@MultipleProgDel_singleRecordNO
  	Scenario: Validate multiple program deletion by selecting Single checkbox
	  Given Admin clicks any checkbox in the data table
	  And Admin clicks on Multple Delete button on Manage Program Page
	  When Admin clicks "NO" button on  Confirm Deletion alert 
		Then Admin should land on Manage Program page and can see the selected program is not deleted from the data table
	
		@MultipleProgDel_singleRecordCloseIcon @Additional
  	Scenario: Validate multiple program deletion by selecting Single checkbox
	  Given Admin clicks any checkbox in the data table
	  And Admin clicks on Multple Delete button on Manage Program Page
	  When Admin clicks "Close" button on  Confirm Deletion alert 
		Then Admin should land on Manage Program page and can see the selected program is not deleted from the data table
	
	
 		@MultipleProgDel_multipleRecordYES
  	Scenario: Validate multiple program deletion by selecting multiple check boxes
	  Given Admin clicks multiple checkboxes in the data table
	  And Admin clicks on Multple Delete button on Manage Program Page
	  When Admin clicks "YES" button on  Confirm Deletion alert 
		Then Admin should land on Manage Program page and can see the selected programs are deleted from the data table
	
 		@MultipleProgDel_multipleRecordNO
  	Scenario: Validate multiple program deletion by selecting multiple check boxes
	  Given Admin clicks multiple checkboxes in the data table
	  And Admin clicks on Multple Delete button on Manage Program Page
	  When Admin clicks "NO" button on  Confirm Deletion alert 
		Then Admin should land on Manage Program page and can see the selected programs are not deleted from the data table

		@MultipleProgDel_multipleRecordClose
  	Scenario: Validate multiple program deletion by selecting multiple check boxes
	  Given Admin clicks multiple checkboxes in the data table
	  And Admin clicks on Multple Delete button on Manage Program Page
	  When Admin clicks "Close" button on  Confirm Deletion alert 
		Then Admin should land on Manage Program page and can see the selected programs are not deleted from the data table
		
	###################### Sorting(DataOrdering)Validation #################################  
 
      
  	@Sorting_ascending
  	Scenario Outline: Validates Sorting(data ordering) on the Program Data table
  	When Admin clicks the sort icon of "<colName>" column
  	Then The data get sorted on the table based on the program name column values in ascending order
  
  	Examples:
  	|colName            |
  	|Program Name       |
  	|Program Description|
  	|Program Status     |
  
	  @Sorting_descending
	  Scenario Outline: Validates Sorting(data ordering) on the Program Data table
	  When Admin clicks the sort icon of "<colName>" column twice
	  Then The data get sorted on the table based on the program name column values in descending order
	  
	  Examples:
	  |colName       |
	  |Program Name  |
	  |Program Desc  |
	  |Program Status|
	    
	  ########################## Pagination ####################################################
	  
	  @Pagination_NextIconActivation @Pagination_LastIconActivation @done
	  Scenario: Verify Next and Last page link activation
	  Given There are more than 5 programs in total in Manage Program page
	  Then Admin should see the Pagination has "Next" and "Last" icon link to be active
	
	  @Pagination_Next @done
	  Scenario: Verify Next Page link functionality
	  Given There are more than 5 programs in total in Manage Program page
	  When Admin clicks on "Next" icon link from pagination section
	  Then Admin is navigated to Page 2
	
		@Pagination_Last  @done
	  Scenario: Verify Last Page link functionality
	  Given There are more than 5 programs in total in Manage Program page
	  When Admin clicks on "Last" icon link from pagination section
	  Then Admin is navigated to Last page with "Next" page link disabled
	  
	  
	  @Pagination_PreviousIconActivation @Pagination_FirstIconActivation @done
	  Scenario: Verify Previous and Start page link activation
	  Given There are more than 5 programs in total in Manage Program page
	  When Admin navigates to page 2
	  Then Admin should see the Pagination has "Previous" and "First" icon link to be active
	  
	  @Pagination_Previous @done
	  Scenario: Verify Next page link
	  Given There are more than 5 programs in total in Manage Program page
	  And Admin navigates to page 2
	  When Admin clicks on "Previous" icon link from pagination section
	  Then Admin is navigated to Page 1
	  
	 
	  @Pagination_First @wip
	  Scenario: Verify First Page link functionality
	  Given There are more than 5 programs in total in Manage Program page
	  And Admin clicks on "Last" icon link from pagination section
	  When Admin clicks on "First" icon link from pagination section
	  Then Admin is navigated to First page with "Previous" page link disabled
  
  ###########################  Navigation from Manage Page to Other Pages ########################################################
  
	  #@NavigationValidationFromManageProgramToOtherPages_30
	  #Scenario: Batch link on navigation bar
	  #Given Admin clicks "Program" on the navigation bar
	  #And Admin is on Manage Program page
	  #When Admin clicks on Batch link on Manage Program page
	  #Then Admin is re-directed to Batch page
	  #
	  @wip
	  @NavigationValidationFromManageProgramToOtherPages_31
	  Scenario: User link on navigation bar
	  When Admin clicks on User link on Manage Program page
	  Then Admin is re-directed to User page
	  #
	  #@NavigationValidationFromManageProgramToOtherPages_32
	  #Scenario: Logout link on navigation bar
	  #Given Admin clicks "Program" on the navigation bar
	  #And Admin is on Manage Program page
	  #When Admin clicks on Logout link on Manage Program page
	  #Then Admin is re-directed to Login page
