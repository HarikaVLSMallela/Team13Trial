@HomePage @all
Feature: User is able to navigate to Home Page and Login

	  Scenario: Verify admin is able to land on home page
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL 
    Then Admin should land on the home page
    
    @404 @incorrectendpoint
    Scenario: Verify admin is able to land on home page
    Given Admin launch the browser
    When Admin gives the invalid LMS portal URL with incorrect endpoint
    Then Admin should recieve 404 page not found error 
    
    @404 @misspelledbaseURL
    Scenario: Verify admin is able to land on home page
    Given Admin launch the browser
    When Admin gives the invalid LMS portal URL with misspelled baseURL
    Then Admin should recieve 404 page not found error 
    
    @400
    Scenario: Verify for broken link
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL endpoint
    Then HTTP response >= 400. Then the link is broken 
   
    
    @PleaselogintoLMSapplication
    Scenario: Validate sign in content
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL 
    Then Admin should see "Please login to LMS application" on home page
    
    @twoTextField
    Scenario: Verify text field is present
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL 
    Then Admin should see 2 text field      
    
    @InnerText_1stField
    Scenario: Verify text on the first text field
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL 
    Then Admin should "User" in the first text field
  
    @InnerText_2ndField
    Scenario: Verify text on the second text field
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL 
    Then Admin should "password" in the second text field      
    
    @verifyLoginBtn
    Scenario: verify Login is present
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL 
    Then Admin should see login button 
    
    ###### Following scenarios have not been automated either:
    
    ###### 1)Due to requirement of usage of third party library/API like Tesseract or Google Spell Check API which
    ######  could potentially expose framework to security risk factors
    ###### 2)Because some could be better validated during manual testing in matter of minutes instead of using automation labor hours			
    
    #Scenario: Verify the text spelling in the page 
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL 
    #Then Admin should see correct spellings in all fields
    #
    #Scenario: Verify the company logo 
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL 
    #Then Admin should see logo on the left side
    #
    #Scenario: Verify application name
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL 
    #Then Admin should see  LMS - Learning Management System
    #
    #Scenario: Verify company name
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL 
    #Then Admin should see company name below the app name 
    #
    #Scenario: Verify asterik next to password text
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL 
    #Then Admin should see "*" symbol next to password text      
    # 
    #Scenario: Verify asterik next to user text
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL 
    #Then Admin should see "*" symbol next to user text 

    #Scenario: Verify the alignment input field for the login
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL 
    #Then Admin should see input field on the centre of the page     
    #
    #Scenario: Verify the alignment of the login button
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL 
    #Then Admin should see login button on the centre of the page
    #
    #Scenario: Verify input descriptive test in user field
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL 
    #Then Admin should see user in gray color        
    #
    #Scenario: Verify input descriptive test in password field
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL 
    #Then Admin should see password in gray color   
      