@Add_Batch_Module @all
Feature: Add New Batch Feature Validation

  Background: The Admin is logged on to the LMS portal
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Given Admin enter valid credentials and clicks login button
    When Admin clicks "Batch" on the navigation bar
    When Admin clicks "+ A New Batch" button
    Given Admin should be able to see a new pop up with Batch details

  @AddBatch01
  Scenario: Check if the fields exist in pop-up
    Then The pop up should include the field- Name as text box

  @AddBatch02
  Scenario: Check if the fields exist in pop-up
    Then The pop up should include the field- Number of classes as text box

  @AddBatch03
  Scenario: Check if the fields exist in pop-up
    Then The pop up should include the field- Description as text box

  @AddBatch04
  Scenario: Check if the fields exist in pop-up
    Then The pop up should include the field- Program Name as drop down

  @AddBatch05
  Scenario: Check if the fields exist in pop-up
    Then The pop up should include the field- Status as radio button

  @AddBatch06
  Scenario Outline: Check if description is optional field
    When Admin should be able to fill values "<BatchName>", "<NumberOfClasses>", ProgramName, status except Description and click save
    Then Admin should be able to see the newly added "<Batch>" in the data table in Manage Batch page

    Examples: 
      | BatchName  | NumberOfClasses | Batch      |
      | AA06Team13 |              13 | AA06Team13 |

  @AddBatch07
  Scenario Outline: Check if the program details are added in data table
    When Admin should be able to fill valid "<BatchName>","<Description>","<NumberOfClasses>", status and click save
    Then Admin should be able to see the newly added "<Batch>" in the data table with successful message in Manage Batch page

    Examples: 
      | BatchName       | Description           | NumberOfClasses | Batch           |
      | Team13mayAutArcht | Automation Architects |               9 | Team13mayAutArcht |

  @AddBatch08
  Scenario Outline: Check for error messages for invalid fields
    When Admin enters Invalid Values for "<BatchName>","<Description>","<NumberOfClasses>" clicks save
    Then Admin gets a Error message for the invalid data fields Name and Description

    Examples: 
      | BatchName    | Description | NumberOfClasses |
      |       137890 | AutoArchs   |               5 |
      | *&^*&(       | AutoArchs   |               5 |
      |              | AutoArchs   |               5 |
      | Team013AuAt6 | 13autoatch  |               5 |
      | Team013AuAt6 | ^&&*&*      |               5 |
      | Team013AuAt6 |             |               5 |
      | Team013AuAt6 | AutoArchs   |               0 |
      | Team013AuAt6 | AutoArchs   | &*(*(*          |
      | Team013AuAt6 | AutoArchs   | Hjkhj           |
      | Team013AuAt6 | AutoArchs   |                 |

  @AddBatch09
  Scenario Outline: Check if the batch details are added in data table
    When Fill "<Description>", "<NumberOfClasses>", Status, ProgName fields with valid values except Name as blank and click save
    Then Admin gets an Error message for the Name field

    Examples: 
      | Description           | NumberOfClasses |
      | Automation Architects |               9 |

  @AddBatch10
  Scenario Outline: Check if the batch details are added in data table
    When Fill "<Name>", "<NumberOfClasses>", Status, ProgName fields with valid values except Description as blank and click save
    Then Admin gets an Error message for the Description field

    Examples: 
      | Name                  | NumberOfClasses |
      | Team13AutoArchitect06 |               9 |

  @AddBatch11
  Scenario Outline: Check if the batch details are added in data table
    When Fill "<Name>","<Description>","<NumberOfClasses>", Status fields with valid values except Program name as blank and click save
    Then Admin gets an Error message for the Program name field

    Examples: 
      | Name                  | Description           | NumberOfClasses |
      | Team13AutoArchitect06 | Automation Architects |               5 |

  @AddBatch12
  Scenario Outline: Check if the batch details are added in data table
    When Fill "<Name>","<Description>","<NumberOfClasses>", Program Name fields with valid values except Status as blank and click save
    Then Admin gets an Error message for the Status field

    Examples: 
      | Name                  | Description           | NumberOfClasses |
      | Team13AutoArchitect06 | Automation Architects |               5 |

  @AddBatch13
  Scenario Outline: Check if the batch details are added in data table
    When Fill "<Name>","<Description>", Program Name fields with valid values except Number of Classes as blank and click save
    Then Admin gets an Error message for the Number of Classes field

    Examples: 
      | Name                  | Description           |
      | Team13AutoArchitect06 | Automation Architects |

  ##### Additional Scenarios #####
  @Additional_AddBatch01
  Scenario Outline: Check for the error messagewhen you erase data in the Name field
    When Admin Enters and clears data in "<Name>" field and clicks on save
    Then Admin should be able to see an error message for "Name" field

    Examples: 
      | Name            |
      | Team13AutoArch0 |

  @Additional_AddBatch02
  Scenario Outline: Check for the error messagewhen you erase data in the Description field
    When Admin Enters and clears data in "<Description>" and clicks on save
    Then Admin should be able to see an error message for "Description" field

    Examples: 
      | Description           |
      | Automation Architects |