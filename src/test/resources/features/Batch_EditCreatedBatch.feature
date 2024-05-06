@Batch_Edit_Module @all

Feature: Edit Created Batch Feature
  
  Background: The Admin is logged in to LMS portal
  Given Admin launch the browser
  When Admin gives the correct LMS portal URL 
  #Then Admin should land on the home page
  When Admin enter valid credentials and clicks login button 
  #Then Admin should land on dashboard page
  When Admin clicks "Batch" on the navigation bar
		
	@EditBatch01
	Scenario: Validate row level edit icon		
	Given Admin should see the edit icon on row level in data table is enabled
	When Admin clicks the "edit" icon	of the batch
	Then Admin should see a new pop up with "Batch Details" appears

	@EditBatch02
	Scenario: Check if the fields are updated		
	Given Admin clicks the "edit" icon	on the batch	
	When Admin should update the Batch fields with valid values descriptions as "ABC" number of clasess as "2" and click save	
	Then Admin should see the updated batch details should appear on the data table
 

	@EditBatch03
	Scenario Outline: Check if the update throws error with invalid valued	and no values in the mandatory field	
	Given Admin clicks the "edit" icon	on the batch	
	When Admin should update the BatchName fields with valid values descriptions as "<Description>" number of clasess as "<Num>" and click save	
	Then Admin should be able to see an error message
   Examples: 
		|Description|Num|
	   |1				 |1	 |
	   |||
		
	@EditBatch04
	Scenario Outline: Check if description field is optional in update		
	Given Admin clicks the "edit" icon	on the batch	
	When Admin should update the BatchName fields with values descriptions as "<Description>"  and click save		
	Then Admin should see the description field is optional in update.
   Examples: 
		|Description|
		|				 |
		|Q|
	

#Additional Scenarios

#	@Additional_EditBatch01            covered in examples
#	Scenario: Check if Batch is updating without any data	in the description field	
#	Given Admin clicks the "edit" icon	
#	When Erase data from description field	
#	Then Error message should appear as "Batch Description is required.This field should start with an alphabet and min 2 character."
#
#	@Additional_EditBatch02             covered in examples
#	Scenario: Check if Batch is updating with only one character in the description field	
#	Given Admin clicks the "edit" icon	
#	When Enter one character in description field	
#	Then Error message should appear as "This field should start with an alphabet and min 2 character."
#	
	@Additional_EditBatch03
	Scenario Outline: Check if Batch is updating without any data	in the Number of Classes field and invalid data
	Given Admin clicks the "edit" icon	on the batch	
	When Admin should update the BatchName fields with values number of classes as "<Number of Classes>"  and click save	
	Then Admin should be able to see an error message
	Examples:
	| Number of Classes |
	||
	|0|
	|Num|
	|&*^&*|
	|      |
	|hjhj8990|
#	
#	@Additional_EditBatch04 covered in above examples
#	Scenario Outline: Check if Batch is updating with invalid data in Number of Classes field
#	Given Admin clicks the "edit" icon	
#	When Enter data in <Number of Classes> field	
#	Then Error message should appear as "Number of classes is required."
#	
#	Examples:
#	| Number of Classes |
#	|0|
#	|Num|
#	|&*^&*|
#	|      |
#	|hjhj8990|
#	
	@Additional_EditBatch05
	Scenario Outline: Check if Batch is updating Batch Name field	and 	Program Name field
	Given Admin clicks the "edit" icon	on the batch	
	When Admn enter data in Name "<Name>"	
	Then Admin see the "<field>" should be disabled
	Examples:
	|Name| field |
	|Batch|Batch Name|
	|Program|Program Name|
	
#	@Additional_EditBatch06 covered in above
#	Scenario: Check if Batch is updating Program Name field		
#	Given Admin clicks the "edit" icon	on the batch
#	When Admin Select data from Program Name dropdown
#	Then Admin see program Name  field should be disabled
#	
	
	
	@Additional_EditBatch07
	Scenario: Check if Batch is updating Status field		
	Given Admin clicks the "edit" icon	on the batch
	When Admin select different status field	option and click save
	Then Admin should see the updated batch details should appear on the data table
	
	