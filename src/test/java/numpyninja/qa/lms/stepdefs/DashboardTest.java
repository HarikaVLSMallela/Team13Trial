package numpyninja.qa.lms.stepdefs;


import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import numpyninja.qa.lms.configuration.ConfigurationManager;
import numpyninja.qa.lms.driver.DriverFactory;
import numpyninja.qa.lms.pages.DashboardPage;
import numpyninja.qa.lms.pages.HomePage;
import numpyninja.qa.lms.utils.LoggerLoad;

public class DashboardTest {
		
	Properties prop;
	WebDriver driver;
	DashboardPage dashboardPage;
	HomePage homePage;
	SoftAssert softAssert;
	
	public DashboardTest() {
		
		driver = DriverFactory.getDriver();
		prop = ConfigurationManager.initProp();
		dashboardPage = new DashboardPage(driver);
		softAssert = new SoftAssert();

	}

	@Given("Admin is in Home Page")
	public void admin_is_in_home_page() {
		
		dashboardPage.LoginHeader();
		LoggerLoad.info("Admin is on login page");
	    
	}

	@Then("Admin should see manage program as header")
	public void admin_should_see_manage_program_as_header() throws InterruptedException {
	
		Thread.sleep(3000);
		Assert.assertTrue(dashboardPage.ManageProgramHeader());
		LoggerLoad.info("Admin is able to see manage program as header");
	
	}
	
	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds...........")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer maxtime) {
	
	    long time_IN_MILLISECONDS = maxtime * 1000;
		long start = System.currentTimeMillis();
		boolean flag = false;
			driver.get(prop.getProperty("url").trim());
		
			long finish = System.currentTimeMillis();
			long totalTime = (finish - start); 
			LoggerLoad.info("Total Time for page load - "+totalTime + "Millisecond"); 
			
			if((totalTime)< time_IN_MILLISECONDS) {
				
				flag=true;
				LoggerLoad.info("navigation took place within " + maxtime + "second");
				
			}
			else 
			{   
				flag = false;
				System.out.println(" FAIL ");
			}
			
			Assert.assertTrue(flag);
			LoggerLoad.info("Maximum navigation time in millisecond, default to 30 seconds");
		
	}
	
	@Then("HTTP response >= {int}. Then the link is broken....................")
	public void http_response_then_the_link_is_broken(Integer responseTime) {
		
		/* {
      
		 driver.get(prop.getProperty("url").trim());

        // Open a connection
        HttpURLConnection connection = (HttpURLConnection) link.openConnection();

        // Get the response code
        int responseCode = connection.getResponseCode();

        // Check if the response code is >= 400
        if (responseCode >= 400) {
            System.out.println("The link is broken with response code: " + responseCode);
        } else {
            System.out.println("The link is valid with response code: " + responseCode);
            // Close the connection
            connection.disconnect();
        } 
       catch (Exception e) {
            e.printStackTrace();
        }
		
		*/
	   
	}

	@Then("Admin should see LMS -Learning management system  as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
		
	   
		Assert.assertTrue(dashboardPage.LMS_Heading());
		LoggerLoad.info("Admin is able to see LMS -Learning management system  as title");
	}	
	

	@Then("Admin should see program in the 1st place")
	public void admin_should_see_program_in_the_1st_place() {
		
				
		Assert.assertTrue(dashboardPage.FirstPlaceProgram());
		LoggerLoad.info("Admin can see program in the 1st place");
	}
	
	@Then("Admin should see batch in the 2nd place")
	public void admin_should_see_batch_in_the_2nd_place() {
		
		
		Assert.assertTrue(dashboardPage.SecondPlaceBatch());
		LoggerLoad.info("Admin can see batch in the 2nd place ");
	}

	@Then("Admin should see user in the  3rd place")
	public void admin_should_see_user_in_the_3rd_place() {
		
	 
		Assert.assertTrue(dashboardPage.ThirdPlaceUser());	
		LoggerLoad.info("Admin can see user in the 3rd place");
	}

	@Then("Admin should see logout in the 4th place")
	public void admin_should_see_logout_in_the_4th_place() {
		
	   
		Assert.assertTrue(dashboardPage.ForthPlaceLogout());
		LoggerLoad.info("Admin can see logout in the 4th place");
	}



}