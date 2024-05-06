package numpyninja.qa.lms.stepdefs;

import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import numpyninja.qa.lms.constants.AppConstants;
import numpyninja.qa.lms.driver.DriverFactory;
import numpyninja.qa.lms.pages.DeleteUserPage;
import numpyninja.qa.lms.pages.ManageProgramPage;
import numpyninja.qa.lms.pages.ManageUserPage;
import numpyninja.qa.lms.pages.ProgramDetailsPage;
import numpyninja.qa.lms.pages.UserDetailsPage;
import numpyninja.qa.lms.pojo.User;
import numpyninja.qa.lms.utils.DynamicDataGenerator;
import numpyninja.qa.lms.utils.LoggerLoad;

public class User_Add_SD {

	WebDriver driver;
	SoftAssert softAssert;

	UserDetailsPage userDetailsPage;
	ManageUserPage manageUserPage;
	DeleteUserPage deleteUserPage;

	String addUsr_id;
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

	HashMap<String, String> map;
	String expectedDisplayedName;
	User user;

	public User_Add_SD() {
		driver = DriverFactory.getDriver();
		softAssert = new SoftAssert();
		manageUserPage = new ManageUserPage(driver);
		userDetailsPage = new UserDetailsPage(driver);
	}
	
	// *********** User Creation for valid Data *************

	@Given("Admin is on  {string} Popup window")
	public void admin_is_on_popup_window(String pageName) {
		Assert.assertEquals(userDetailsPage.getHeaderText(), pageName);
		LoggerLoad.info("Admin is on User Details Page");
	}

	@When("Admin enters valid data in all fields and clicks on submit button")
	public void admin_enters_valid_data_in_all_fields_and_clicks_on_submit_button() throws InterruptedException {

		int rand1 = DynamicDataGenerator.randomTwoDigitGenerator();
		int rand2 = DynamicDataGenerator.randomTwoDigitGenerator();

		addUsr_id = "";
		addUsr_firstName = "Edwincddb";
		addUsr_middleName = "Agacddab";
		addUsr_lastName = "Middledb";
		addUsr_location = "Texas";
		addUsr_phoneNo = rand1 + "556" + rand2 + "560";
		addUsr_linkedIn = "https://www.linkedin.com/in/ria-irai-9a8607227/";
		addUsr_userRole = "R02";
		addUsr_roleStatus = "Active";
		addUsr_visaStatus = "H4-EAD";
		addUsr_email = DynamicDataGenerator.getRandomEmailId();
		addUsr_underGraduate = "BCA";
		addUsr_postGraduate = "MCA";
		addUsr_timeZone = "EST";
		addUsr_comments = "User is a Staff";

		user = new User(addUsr_id, addUsr_firstName, addUsr_middleName, addUsr_lastName, addUsr_location,
				addUsr_phoneNo, addUsr_linkedIn, addUsr_userRole, addUsr_roleStatus, addUsr_visaStatus, addUsr_email,
				addUsr_underGraduate, addUsr_postGraduate, addUsr_timeZone, addUsr_comments);

		System.out.println("User First Name is = " + addUsr_firstName);

		manageUserPage = userDetailsPage.fillUpUserDetailsForm(addUsr_firstName, addUsr_middleName, addUsr_lastName,
				addUsr_location, addUsr_phoneNo, addUsr_linkedIn, addUsr_userRole, addUsr_roleStatus, addUsr_visaStatus,
				addUsr_email, addUsr_underGraduate, addUsr_postGraduate, addUsr_timeZone, addUsr_comments, "Submit");
		/*
		 * manageUserPage = userDetailsPage.fillUpUserDetailsForm( addUsr_firstName,
		 * addUsr_middleName, addUsr_lastName, addUsr_location, addUsr_phoneNo,
		 * addUsr_linkedIn, addUsr_userRole, addUsr_roleStatus, addUsr_visaStatus,
		 * addUsr_email, addUsr_underGraduate, addUsr_postGraduate, addUsr_timeZone,
		 * addUsr_comments, "Submit");
		 * 
		 */
		LoggerLoad.info("Admin enters valid data in all fields and clicks on submit button");
	}

	@Then("Admin gets message {string}")
	public void admin_gets_message(String successMsg) {

		// softAssert.assertEquals(manageUserPage.getUserAddSuccessMsg(), successMsg);

		manageUserPage.enterTextInSearchBox(user.getUserFirstName());

		// expectedDisplayedName = addUsr_firstName + " " + addUsr_lastName;
		expectedDisplayedName = user.getUserFirstName() + " " + user.getUserLastName();

		map = manageUserPage.isAddedOrEditedUserRecordVisible(expectedDisplayedName);
		System.out.println(Arrays.asList(map));

		System.out.println("From record = " + map.get("FullName"));
		System.out.println("Tesdata = " + expectedDisplayedName);

		System.out.println("From record = " + map.get("Location"));
		System.out.println("Tesdata = " + user.getUserLocation());

		System.out.println("From record = " + map.get("PhoneNo"));
		System.out.println("Tesdata = " + user.getUserPhone());

		softAssert.assertEquals(map.get("FullName"), expectedDisplayedName);
		softAssert.assertEquals(map.get("Location"), user.getUserLocation());
		softAssert.assertEquals(map.get("PhoneNo"), user.getUserPhone());
		/*
		 * softAssert.assertEquals(map.get("Location"), addUsr_location);
		 * softAssert.assertEquals(map.get("PhoneNo"), addUsr_phoneNo);
		 */

		softAssert.assertAll();
		LoggerLoad.info("Admin gets message User added Successfully ");
	}

	// ************* User Creation with only Mandatory fields *********

	@When("Admin enters mandatory fields in the form and clicks on submit button")
	public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_submit_button() throws Exception {
		addUsr_firstName = "Edwin";
		addUsr_middleName = "";
		addUsr_lastName = "Clement";
		addUsr_location = "Texas";
		addUsr_phoneNo = "345567789";
		addUsr_linkedIn = "";
		addUsr_userRole = "R03";
		addUsr_roleStatus = "Active";
		addUsr_visaStatus = "H4-EAD";
		addUsr_email = "";
		addUsr_underGraduate = "";
		addUsr_postGraduate = "";
		addUsr_timeZone = "";
		addUsr_comments = "";

		System.out.println("User First Name is = " + addUsr_firstName);

		manageUserPage = userDetailsPage.fillUpUserDetailsForm(addUsr_firstName, addUsr_middleName, addUsr_lastName,
				addUsr_location, addUsr_phoneNo, addUsr_linkedIn, addUsr_userRole, addUsr_roleStatus, addUsr_visaStatus,
				addUsr_email, addUsr_underGraduate, addUsr_postGraduate, addUsr_timeZone, addUsr_comments, "Submit");
		LoggerLoad.info("Admin entered mandatory fields in the form for User creation and clicks on submit button ");
	}

	// ************ user Delete - Sinlge step def ***********************

	@When("Admin clicks the delete icon")
	public void admin_clicks_the_delete_icon() throws InterruptedException {

		String fullName = user.getUserFirstName() + " " + user.getUserLastName();
		System.out.println("Username to be deleted = " + fullName);
		deleteUserPage = manageUserPage.clickOnDeleteBtnForUser(fullName);
		Thread.sleep(5000);
		LoggerLoad.info("Admin clicks the delete icon");
	}

	@Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion on Delete User")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion_on_delete_user(
			String expHeaderString) {

		softAssert.assertEquals(deleteUserPage.getHeaderText(), expHeaderString);
		softAssert.assertTrue(deleteUserPage.yesBtnExists());
		softAssert.assertTrue(deleteUserPage.noBtnExists());

		softAssert.assertAll();
		LoggerLoad.info(
				"Admin able see a alert open with heading Confirm along with  <YES> and <NO> button for deletion");
	}

	@When("Admin clicks yes option")
	public void admin_clicks_yes_option() {

		manageUserPage = deleteUserPage.clickYesBtn();
		LoggerLoad.info("Admin clicks yes option");
	}

	@Then("Admin gets a message {string} alert and do not see that user in the data table")
	public void admin_gets_a_message_alert_and_do_not_see_that_user_in_the_data_table(String successMsg)
			throws Exception {

		// softAssert.assertEquals(manageUserPage.getUserAddSuccessMsg(), successMsg);

		manageUserPage.enterTextInSearchBox(user.getUserFirstName());
		Thread.sleep(2000);
		softAssert.assertEquals(manageUserPage.getPaginationText(), AppConstants.NO_SEARCH_RESULT_FOUND_TEXT);

		softAssert.assertAll();
		LoggerLoad.info(
				"Admin gets a message \"Successful User Deleted\" alert and is not able to see that user in the data table");

	}
//**************************** Search by user's first name ************************************

	@When("Admin enters user name into search box.")
	public void admin_enters_user_nameinto_search_box() throws InterruptedException {

		manageUserPage.enterTextInSearchBox(user.getUserFirstName());
		Thread.sleep(5000);
		LoggerLoad.info("Admin enters user name into search box");
		
	}

	@Then("Admin will see user displayed with the entered name")
	public void admin_will_see_user_displayed_with_the_entered_name() {

		map = manageUserPage.isAddedOrEditedUserRecordVisible(expectedDisplayedName);

		if (manageUserPage.getPaginationText().equalsIgnoreCase(AppConstants.SEARCH_RESULT_FOUND_TEXT)) {

			softAssert.assertEquals(map.get("FullName"), expectedDisplayedName);
			softAssert.assertEquals(map.get("Location"), user.getUserLocation());
			softAssert.assertEquals(map.get("PhoneNo"), user.getUserPhone());

			System.out.println(map.get("UserId"));
			System.out.println(map.get("FullName"));
			System.out.println(map.get("Location"));
			System.out.println(map.get("PhoneNo"));

		}
		user.setUserId(map.get("UserId"));
		LoggerLoad.info("Admin is able to see user displayed with the entered name");

	}

	// **************************** Edit User ************************************

	@When("Admin clicks on the edit icon")
	public void admin_clicks_on_the_edit_icon() throws InterruptedException {

		expectedDisplayedName = user.getUserFirstName() + " " + user.getUserLastName();
		userDetailsPage = manageUserPage.clickOnEditBtnForUser(expectedDisplayedName);
		LoggerLoad.info("Admin clicks User name to be edited in the search box");
	}

	@When("Admin is on {string} pop up window to Edit")
	public void admin_is_on_pop_up_window_to_edit(String expectedHeaderText) {

		softAssert.assertEquals(userDetailsPage.getHeaderText(), expectedHeaderText);
		// Assert.assertTrue(userDetailsPage.isFirstNameFieldNotEmpty());

		LoggerLoad.info("Admin is able to see User Edit Details Page");
	}

	@When("Update the fields with valid data and click submit")
	public void update_the_fields_with_valid_data_and_click_submit() {
		// addUsr_firstName = "Ria";
		// addUsr_middleName = "Arul";
		addUsr_lastName = "Edtyy";
		addUsr_location = "Georgia";
		// addUsr_phoneNo = "345567456";
		// addUsr_linkedIn = "https://www.linkedin.com/in/ria-irai-9a8607227/";
		// addUsr_userRole = "R02";
		// addUsr_roleStatus = "Active";
		// addUsr_visaStatus = "H4-EAD";
		addUsr_email = "riairai@gmail.com";
		// addUsr_underGraduate = "BCA";
		// addUsr_postGraduate = "MCA";
		// addUsr_timeZone = "EST";
		// addUsr_comments ="User is a Staff";

		user.setUserLastName(addUsr_lastName);
		user.setUserLocation(addUsr_location);
		user.setUserEmail(addUsr_email);

		System.out.println("User First Name is = " + addUsr_firstName);
		System.out.println("Location is = " + addUsr_location);

		manageUserPage = userDetailsPage.EditUserForEnteredTextInSearchBox(addUsr_lastName, addUsr_location,
				addUsr_email, "Submit");

		LoggerLoad.info("Admin entered the valid datas to be edited");
	}

	@Then("Admin gets message {string} and see the updated values in data table in Manage User")
	public void admin_gets_message_and_see_the_updated_values_in_data_table_in_manage_user(String successMsg)
			throws InterruptedException {

		// softAssert.assertEquals(manageUserPage.getUserAddSuccessMsg(), successMsg);

		manageUserPage.enterTextInSearchBox(user.getUserFirstName());
		Thread.sleep(5000);

		expectedDisplayedName = user.getUserFirstName() + " " + user.getUserLastName();
		System.out.println("Displayed named after editing is = " + expectedDisplayedName);
		// expectedDisplayedName = addUsr_firstName + " " + addUsr_lastName;

		map = manageUserPage.isAddedOrEditedUserRecordVisible(expectedDisplayedName);
		System.out.println(Arrays.asList(map));

		softAssert.assertEquals(map.get("UserId"), user.getUserId());
		softAssert.assertEquals(map.get("FullNamest"), expectedDisplayedName);
		softAssert.assertEquals(map.get("Location"), user.getUserLocation());
		softAssert.assertEquals(map.get("PhoneNo"), user.getUserPhone());

		softAssert.assertAll();
		LoggerLoad.info("User edited Successfully and Admin could see the updated values in data table");
		Thread.sleep(5000);

	}

}
