@Batch_Module @all

Feature: Delete Batch/Batches features

  Background: The Admin is logged in to LMS portal
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    When Admin enter valid credentials and clicks login button
    When Admin clicks "Batch" on the navigation bar

  #Feature_Delete_Batch
  	@Batch16
  	Scenario: Validate the row level delete icon
  	Given Admin should see the delete icon on row level in data table is enabled
  	When Admin search for the batch and clicks the "delete" icon
  	Then Admin sees Alert appears with yes and No option
  

  @Batch17
  Scenario: Validate accept alert
    Given Admin search for the batch to be deleted and clicks the "delete" icon
    When Admin click yes option
    Then Batch deleted alert pops and batch is no more available in data table


  @Batch17
  Scenario: Validate accept alert
    Given Admin search for the batch to be deleted and clicks the "delete" icon
    When Admin click yes option
    Then Batch deleted alert pops and batch is no more available in data table

  @Batch18
  Scenario: Validate reject alert
    Given Admin search for the batch to be deleted and clicks the "delete" icon
    When Admin click No option
    Then Admin can see Batch is still listed in data table

  #Feature_Delete_multiple_batches
  @Batch19
  Scenario: Validate the delete icon below the header
    Given Admin selects None of the checkboxes in data table are selected
    Then Admin see the delete icon under the Manage Batch header should be disabled

  @Batch20
  Scenario: Check for single row delete
    Given Admin selects One of the checkbox row
    When Admin Click delete icon below Manage Batch header
    Then Admin see that the respective row in the data table is deleted

  @Batch21
  Scenario: Check for multi row delete
    Given Admin selects Two or more checkboxes/row is selected
    When Admin Click delete icon below Manage Batch header
    Then Admin see the respective row in the data table is deleted
