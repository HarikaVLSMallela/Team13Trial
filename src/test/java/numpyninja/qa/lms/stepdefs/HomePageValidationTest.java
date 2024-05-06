package numpyninja.qa.lms.stepdefs;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import numpyninja.qa.lms.configuration.ConfigurationManager;
import numpyninja.qa.lms.constants.AppConstants;
import numpyninja.qa.lms.driver.DriverFactory;
import numpyninja.qa.lms.pages.HomePage;
import numpyninja.qa.lms.utils.LoggerLoad;

public class HomePageValidationTest {

	
	HttpURLConnection huc = null;
    int respCode;
	
	DriverFactory df;
	WebDriver driver;
	Properties prop;
	HomePage homePage;
	
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {

		prop = ConfigurationManager.initProp();		 
		df = new DriverFactory();
		driver = df.initDriver(prop);

	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		driver.get(prop.getProperty("url").trim());
	}

	@Then("Admin should land on the home page")
	public void admin_should_land_on_the_home_page() {
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.getPageUrl().contains("/login"));

	}
	
	@When("Admin gives the invalid LMS portal URL with incorrect endpoint")
	public void admin_gives_the_invalid_lms_portal_url_with_incorrect_endpoint() {
	    
		LoggerLoad.info("Invalid URL passed = "+AppConstants.INVALID_LMS_PORTAL_INCORRECT_URL);
		try {
			URL url = new URI(AppConstants.INVALID_LMS_PORTAL_INCORRECT_URL).toURL();
			huc = (HttpURLConnection) url.openConnection();  
			huc.setConnectTimeout(3000);
            huc.setRequestMethod("HEAD");
            huc.connect();
		} catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@When("Admin gives the invalid LMS portal URL with misspelled baseURL")
	public void admin_gives_the_invalid_lms_portal_url_with_misspelled_base_url() {

		LoggerLoad.info("Misspelled baseURL passed = "+AppConstants.INVALID_LMS_PORTAL_MISSPELLED_BASEURL);
		try {
			URL url = new URI(AppConstants.INVALID_LMS_PORTAL_MISSPELLED_BASEURL).toURL();
			huc = (HttpURLConnection) url.openConnection();  
			huc.setConnectTimeout(3000);
            huc.setRequestMethod("HEAD");
            huc.connect();
		} catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	@Then("Admin should recieve {int} page not found error")
	public void admin_should_recieve_page_not_found_error(Integer expResponseCode) {
		
		try {
			Assert.assertEquals(huc.getResponseCode(), expResponseCode);
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	@When("Admin gives the correct LMS portal URL endpoint")
	public void admin_gives_the_correct_lms_portal_url_endpoint() {
		try {
			URL url = new URI(prop.getProperty("url").trim()).toURL();
			huc = (HttpURLConnection) url.openConnection();
			huc.setConnectTimeout(3000);
            huc.setRequestMethod("HEAD");
            huc.connect();
		} catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer expResponseCode) {
	    
		try {
			Assert.assertTrue(huc.getResponseCode()< expResponseCode);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Then("Admin should see {string} on home page")
	public void admin_should_see_on_home_page(String expText) {
		Assert.assertEquals(homePage.getLoginHeaderText(), expText);
	}

	
	@Then("Admin should see {int} text field")
	public void admin_should_see_text_field(Integer count) {
	    
		Assert.assertEquals(homePage.numberOfTextField(), count);
	}
	
	@Then("Admin should {string} in the first text field")
	public void admin_should_in_the_first_text_field(String innerText) {
		
		Assert.assertEquals(homePage.getTextFieldInnerText("first"), innerText);
	}
	
	@Then("Admin should {string} in the second text field")
	public void admin_should_in_the_second_text_field(String innerText) {
		
		Assert.assertEquals(homePage.getTextFieldInnerText("second"), innerText);
	}
	
	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
		Assert.assertTrue(homePage.isLoginButtonPresent());

	}


}
