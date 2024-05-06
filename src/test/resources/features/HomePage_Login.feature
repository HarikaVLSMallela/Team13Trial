@Login @all
Feature: User is able to navigate to Home Page and Login

	  Background:
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL 
    Then Admin should land on the home page
		
		@login_positive
  	Scenario: Validate login with valid credentials
    When Admin enter valid credentials and clicks login button 
    Then Admin should land on dashboard page
 
 		
    Scenario Outline: Validate login with invalid and null credentials
    When Admin enter "<username>", "<password>" and clicks login button
    Then Admin should see "<errorMsg>"
    
    Examples: 
      | username | password | errorMsg                                       |
      | invalid  | invalid  | Invalid username and password Please try again |
      | invalid  | valid    | Invalid username and password Please try again |
      | valid    | invalid  | Invalid username and password Please try again |
      |          | valid    | Please enter your user name                    |
			| valid    |          | Please enter your password                     |
    
    @LP2UH-204
    Scenario: Validate login credentials with null username
    When Admin enters no value in username and password and clicks login button
    Then Admin should see error msg "Please enter your user name" under username field and error msg "Please enter your password" under password field 

		@LP2UH-91
    Scenario: Verify login button action through keyboard
    When Admin enter valid credentials and clicks login button through keyboard
    Then Admin should land on dashboard page

		@LP2UH-92
    Scenario: Verify login button action through mouse
    When Admin enter valid credentials and clicks login button through mouse
    Then Admin should land on dashboard page