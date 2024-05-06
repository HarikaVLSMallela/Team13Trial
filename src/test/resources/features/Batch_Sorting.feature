@Batch_Sorting_Feature @all
Feature: Testing the Sorting(Data Ordering) feature of LMS application

  Background: The Admin is logged in to LMS portal
   	Given Admin launch the browser
    When Admin gives the correct LMS portal URL 
    When Admin enter valid credentials and clicks login button 
    When Admin clicks "Batch" on the navigation bar
    
  @Batch_sort01
  Scenario: Validates Sort icon for Batch name column - ascending order
    When Admin clicks the sort icon of Batch name column once
    Then The data get sorted in ascending order on the table based on the Batch name column values

  @Batch_sort02
  Scenario: Validates Sort icon for Batch name column - descending order
    When Admin clicks the sort icon of Batch name column twice
    Then The data get sorted in descending order on the table based on the Batch name column values

  @Batch_sort03
  Scenario: Validates Sort icon for Batch name column - ascending order
    When Admin clicks the sort icon of Batch Description column once
    Then The data get sorted in ascending order on the table based on the Batch Description column values

  @Batch_sort04
  Scenario: Validates Sort icon for Batch name column - descending order
    When Admin clicks the sort icon of Batch Description column twice
    Then The data get sorted in descending order on the table based on the Batch Description column values
 
  @Batch_sort05
  Scenario: Validates Sort icon for Batch name column - ascending order
    When Admin clicks the sort icon of Program Name column once
    Then The data get sorted in ascending order on the table based on the Program name column values

  @Batch_sort06
  Scenario: Validates Sort icon for Batch name column - descending order
    When Admin clicks the sort icon of Program name column twice
    Then The data get sorted in descending order on the table based on the Program name column values

  @Batch_sort07
  Scenario: Validates Sort icon for Batch name column - ascending order
    When Admin clicks the sort icon of Number of classes column once
    Then The data get sorted in ascending order on the table based on the Number of classes column values

  @Batch_sort08
  Scenario: Validates Sort icon for Batch name column - descending order
    When Admin clicks the sort icon of Number of classes column twice
    Then The data get sorted in descending order on the table based on the Number of classes column values
    
  @Batch_sort09
  Scenario: Validates Sort icon for Batch name column - ascending order
    When Admin clicks the sort icon of Status column once
    Then The data get sorted in ascending order on the table based on the Status column values

  @Batch_sort10
  Scenario: Validates Sort icon for Batch name column - descending order
    When Admin clicks the sort icon of Status column twice
    Then The data get sorted in descending order on the table based on the Status column values
    
    