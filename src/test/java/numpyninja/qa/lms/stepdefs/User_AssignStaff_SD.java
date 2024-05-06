package numpyninja.qa.lms.stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import numpyninja.qa.lms.driver.DriverFactory;
import numpyninja.qa.lms.pages.AssignStaffDetailsPage;
import numpyninja.qa.lms.pages.ManageUserPage;
import numpyninja.qa.lms.pages.UserDetailsPage;
import numpyninja.qa.lms.utils.DynamicDataGenerator;
import numpyninja.qa.lms.utils.LoggerLoad;

public class User_AssignStaff_SD {

	WebDriver driver;
	SoftAssert softAssert;

	UserDetailsPage userDetailsPage;
	ManageUserPage manageUserPage;
	AssignStaffDetailsPage assignStaffDetailsPage;

	String assignStaff_Email;
	String assignStaff_Skill;
	String assignStaff_ProgramName;
	String assignStaff_BatchName;
	String assignStaff_Status;
	String assignStaff_Save;

	public User_AssignStaff_SD() {
		driver = DriverFactory.getDriver();
		softAssert = new SoftAssert();
		assignStaffDetailsPage = new AssignStaffDetailsPage(driver);
	}

	// *********** Assign Staff for valid Data *************

	@Given("Admin is in {string} pop up page")
	public void admin_is_in_pop_up_page(String pageName) {
		Assert.assertEquals(assignStaffDetailsPage.getHeaderText(), pageName);
		LoggerLoad.info("Admin is on Assign Staff Details Page");
	}

	@When("Enter all required fields with valid values and click Save button")
	public void enter_all_required_fields_with_valid_values_and_click_save_button() {
		assignStaff_Email = "riairai@gmail.com";
		assignStaff_Skill = "JAVA";
		assignStaff_ProgramName = "Julie123";
		assignStaff_BatchName = "Julie123Batch";
		assignStaff_Status = "Active";
		assignStaff_Save = "Save";
		System.out.println("Program Name is = " + assignStaff_ProgramName);
		System.out.println("EmailId is = " + assignStaff_Email);
		System.out.println("Skill is = " + assignStaff_Skill);

		manageUserPage = assignStaffDetailsPage.fillUpAssignStaffDetailsForm(assignStaff_Email, assignStaff_Skill,
				assignStaff_ProgramName, assignStaff_BatchName, assignStaff_Status, "save");
		// manageUserPage =
		// assignStaffDetailsPage.fillUpAssignStaffDetailsForm(assignStaff_Email,
		// assignStaff_Skill, assignStaff_ProgramName, assignStaff_BatchName,
		// assignStaff_Status, assignStaff_BatchName, ;
		// manageUserPage = assignStaffDetailsPage.fillUpProgramDetailsForm(addPrg_Name,
		// addPrg_Description, addPrg_Status, "Save");
		LoggerLoad.info("Enter all required fields with valid values and click Save button");
	}

	@Then("Admin gets a message {string} alert")
	public void admin_gets_a_message_alert(String expectedSuccessMessage) {
		Assert.assertEquals(assignStaffDetailsPage.getSuccessMessageText(), expectedSuccessMessage);
		LoggerLoad.info(
				"Admin is able to see the success alert 'User  has been successfully assigned to Program/Batch(es)");
	}

}
