@all
Feature: Dashboard Page 

Background:
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL 
    When Admin should land on the home page
    When Admin enter valid credentials and clicks login button 
    When Admin should see manage program as header 


	@DB_20
  Scenario:Verify after login  admin lands on manage program as dashboard page
  Then Admin should see manage program as header
  
  @DB_01
  Scenario: Verify the response time 
  Then   Maximum navigation time in milliseconds, defaults to 30 seconds...........
  
  @DB_02
  Scenario: Verify broken link
  Then  HTTP response >= 400. Then the link is broken....................
  
  @DB_03
  Scenario: Verify LMS title 
  Then Admin should see LMS -Learning management system  as title 

  @DB_08
  Scenario: Validate navigation bar order  1st Program
  Then Admin should see program in the 1st place
  
  @DB_09
  Scenario: Validate navigation bar order  1st Program
  Then  Admin should see batch in the 2nd place 
  
  @DB_10
  Scenario: Validate navigation bar order  1st Program
  Then Admin should see user in the  3rd place
  
  @DB_11
  Scenario: Validate navigation bar order  1st Program
  Then Admin should see logout in the 4th place
  

  @Logout_13
  Scenario: Validate login with valid credentials
  When Admin clicks "Logout" on the navigation bar
  Then Admin should see URL with "login"

		###### Following scenarios have not been automated either:
    
    ###### 1)Due to requirement of usage of third party library/API like Tesseract or Google Spell Check API which
    ######  could potentially expose framework to security risk factors
    ###### 2)Because some could be better validated during manual testing in matter of minutes instead of using automation labor hours	

  #	Scenario: Verify  LMS title alignment 
  #	Then LMS title should be on the top left corner of page
  
	#	Scenario: Validate navigation bar text 
  #	Then Admin should see correct spelling in navigation bar text
  
  #	Scenario: Validate LMS title has correct spelling ang space 
  #	Then Admin should see correct spelling and space in LMS title
  
  #	Scenario: Validate alignment for navigation bar 
  #	Then Admin should see the navigation bar text on the top right side


  
  
  
  
  
  