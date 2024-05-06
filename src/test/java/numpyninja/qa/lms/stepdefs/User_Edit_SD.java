package numpyninja.qa.lms.stepdefs;

import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import numpyninja.qa.lms.driver.DriverFactory;
import numpyninja.qa.lms.pages.DeleteUserPage;
import numpyninja.qa.lms.pages.ManageUserPage;
import numpyninja.qa.lms.pages.UserDetailsPage;
import numpyninja.qa.lms.utils.LoggerLoad;

public class User_Edit_SD {

	WebDriver driver;
	SoftAssert softAssert;
	
	UserDetailsPage userDetailsPage;
	ManageUserPage manageUserPage;
	DeleteUserPage deleteUserPage;
	
	String addUsr_firstName;
	String addUsr_middleName;
	String addUsr_lastName;
	String addUsr_location;
	String addUsr_phoneNo;
	String addUsr_linkedIn;
	String addUsr_userRole;
	String addUsr_roleStatus;
	String addUsr_visaStatus;
	String addUsr_email;
	String addUsr_underGraduate;
	String addUsr_postGraduate;
	String addUsr_timeZone;
	String addUsr_comments;
	String search_Text;
	
	HashMap<String, String> map;
	String expectedDisplayedName;


	public User_Edit_SD() {
		driver = DriverFactory.getDriver();
		softAssert = new SoftAssert();
		manageUserPage = new ManageUserPage(driver);
		userDetailsPage = new UserDetailsPage(driver);
	}
	

	
	
	
	
	
				
	
}
