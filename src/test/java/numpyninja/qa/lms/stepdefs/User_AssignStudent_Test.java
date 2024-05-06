package numpyninja.qa.lms.stepdefs;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import numpyninja.qa.lms.pages.DashboardPage;
import numpyninja.qa.lms.pages.DeleteMultipleUser;
import numpyninja.qa.lms.pages.DeleteProgramPage;
import numpyninja.qa.lms.pages.HomePage;
import numpyninja.qa.lms.pages.ManageBatchPage;
import numpyninja.qa.lms.pages.ManageProgramPage;
import numpyninja.qa.lms.pages.ManageUserPage;
import numpyninja.qa.lms.pages.ProgramDetailsPage;
import numpyninja.qa.lms.utils.DynamicDataGenerator;
import numpyninja.qa.lms.utils.LoggerLoad;
import numpyninja.qa.lms.constants.AppConstants;
import numpyninja.qa.lms.driver.DriverFactory;
import numpyninja.qa.lms.pages.AssignStudentDetailsPage;

public class User_AssignStudent_Test {
	
	WebDriver driver;
	DashboardPage dashboardPage;
	ManageProgramPage manageProgramPage;
	ManageBatchPage manageBatchPage;
	ManageUserPage manageUserPage;
	HomePage homePage;
	ProgramDetailsPage programDetailsPage;
	SoftAssert softAssert;
	//UserDetailsPage userDetailsPage;
	AssignStudentDetailsPage AssignStudentDetailsPage;
	
	String addPrg_Name;
	String addPrg_Description;
	String addPrg_Status;
	String multiplesingleProgUser;
	DeleteMultipleUser DeleteMultipleUser;
    
	
	public User_AssignStudent_Test() {
		driver = DriverFactory.getDriver();
		manageUserPage = new ManageUserPage(driver);
		AssignStudentDetailsPage = new AssignStudentDetailsPage(driver);
		softAssert = new SoftAssert();
	}
	@When("Admin clicks Save button without entering any data")
	public void admin_clicks_save_button_with_entering_any_data() {
		LoggerLoad.info( "Admin clicks Save button without entering any data");

		 AssignStudentDetailsPage.clickSaveButton();
	}
	@Then("Admin gets a {string} alert")
	public void admin_gets_a_alert(String expectedString) {
		LoggerLoad.info( "Admin gets a {string} alert");
		
		  HashMap<String, String> allErrMsgs= AssignStudentDetailsPage.getErrorMsgsForStudent();
			LoggerLoad.info( "Admin gets a {string} alert after page object");
System.out.println(allErrMsgs.toString());
		  softAssert.assertEquals(allErrMsgs.get("Email Error"),
		  AppConstants.EMAIL_ID_REQUIRED);
		  
		  softAssert.assertEquals(allErrMsgs.get("Program Error"),
		  AppConstants.PROGRAM_NAME_REQUIRED);
		  
		  softAssert.assertEquals(allErrMsgs.get("Batch name error"),
		  AppConstants.BATCH_NAME_REQUIRED);
		  
		  softAssert.assertEquals(allErrMsgs.get("status error"),
		  AppConstants.STATUS_REQUIRED);
		  
		 // softAssert.assertAll();	    
	}
	
	@When("Enter all the required student fields with valid values and click Save button")
	public void enter_all_the_required_student_fields_with_valid_values_and_click_save_button() {
		LoggerLoad.info( "Enter all the required student fields with valid values and click Save button");

		AssignStudentDetailsPage = AssignStudentDetailsPage.fillUpStudentDetailsForm("","AAB2Abcdnumpynumpynumpy","bjirehnbjv","Active","Save");
	}

	
	@Then("Admin gets a message {string} alert sucesfully student Assignment")
	public void admin_gets_a_message_alert_sucesfully_student_assignment(String string) {
		LoggerLoad.info( "Admin gets a message {string} alert sucesfully student Assignment");

		/*HashMap<String, String> map = manageProgramPage.isAddedOrEditedProgramRecordVisible(addPrg_Name);
		System.out.println(Arrays.asList(map));
		softAssert.assertEquals(map.get("ProgramName"), addPrg_Name);
		softAssert.assertEquals(map.get("ProgramDescription"), addPrg_Description);
		softAssert.assertEquals(map.get("ProgramStatus"), addPrg_Status);

		softAssert.assertAll();	*/
	}
	@When("Admin clicks Assign student button")
	public void admin_clicks_assign_student_button() {
		AssignStudentDetailsPage = manageUserPage.clickAssignStudentButton();
		LoggerLoad.info( "Admin clicks Assign student button");

		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
	///*************************************Validate pop window************************************
	@When("Admin clicks student {string} button")
	public void admin_clicks_student_button(String string) {
	    // Write code here that turns the phrase above into concrete actions
		LoggerLoad.info(" Admin clicks student {string} button\"");
		AssignStudentDetailsPage = manageUserPage.clickAssignStudentButton();
		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	}
	@Then("Admin should see a pop up open for assign student details with empty form along with <Save> and <Cancel> button and close \\(X) icon on the top right corner of the window")
	public void admin_should_see_a_pop_up_open_for_assign_student_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
		// softAssert.assertEquals(userDetailsPage.getHeaderText(), expectedUserDetailsHeader);
		LoggerLoad.info(" Admin should see a pop up open for  for assign student details ");
		softAssert.assertTrue(AssignStudentDetailsPage.isBatchPresent());
		softAssert.assertTrue(AssignStudentDetailsPage.isRadioActiveButtonPresent());
		softAssert.assertTrue(AssignStudentDetailsPage.isRadioInActiveButtonPresent());
		softAssert.assertTrue(AssignStudentDetailsPage.isEmailIDPresent());
		softAssert.assertTrue(AssignStudentDetailsPage.isProgramTextPresent());
		softAssert.assertTrue(AssignStudentDetailsPage.isSaveCancelButtonPresent());
		softAssert.assertTrue(AssignStudentDetailsPage.isStudentUserRolePresent());
		softAssert.assertAll();
	}
	@When("Enter all the required student fields with valid values and click Cancel button")
	public void enter_all_the_required_student_fields_with_valid_values_and_click_cancel_button() {
		LoggerLoad.info(" click Cancel button");
		AssignStudentDetailsPage.clickCancelButton();

	}
	@Then("Admin can see the Assign Student popup disappears without assigning")
	public void admin_can_see_the_assign_student_popup_disappears_without_assigning() {
		LoggerLoad.info("Admin can see the Assign Student popup disappears without assigning ");
		softAssert.assertFalse(AssignStudentDetailsPage.isAssignStudentPresent());
	    
	}
	
	@Then("Admin should see User Role as R03,and other fields Student Email id,Program Name,Batch Name and Status with respective input boxes.")
	public void admin_should_see_user_role_as_r03_and_other_fields_student_email_id_program_name_batch_name_and_status_with_respective_input_boxes() {
		LoggerLoad.info(" Admin should see User Role as R03,and other fields Student Email  ");
		softAssert.assertTrue(AssignStudentDetailsPage.isBatchPresent());
		softAssert.assertTrue(AssignStudentDetailsPage.isEmailValuePresent());
		softAssert.assertTrue(AssignStudentDetailsPage.isstatusTextPresent());
		softAssert.assertTrue(AssignStudentDetailsPage.isProgramValuePresent());
		softAssert.assertTrue(AssignStudentDetailsPage.isRoleTextPresent());
		softAssert.assertAll();
   
	}
	
	//**************************validate dropdown
	@Then("Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name")
	public void admin_should_see_drop_down_boxes_with_valid_datas_for_student_email_id_program_name_and_batch_name() {
		LoggerLoad.info( "Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name");

	}
	
	@Then("Admin should see two radio button for Status active and inactive")
	public void admin_should_see_two_radio_button_for_status_active_and_inactive() {
		LoggerLoad.info( "Admin should see two radio button for Status active and inactive");
		softAssert.assertTrue(AssignStudentDetailsPage.isRadioActiveButtonPresent());
		softAssert.assertTrue(AssignStudentDetailsPage.isRadioInActiveButtonPresent());
		softAssert.assertAll();

	}

  //************************************Delete Multiple user

	
	@When("Admin clicks any checkbox in the user data table")
	public void admin_clicks_any_checkbox_in_the_user_data_table() {
		LoggerLoad.info( "Admin clicks any checkbox in the user data table");
		/*int totalCheckBox = AssignStudentDetailsPage.getCheckboxCount();
		System.out.println("Number of CheckBoxes in current Manage user Page = " + totalCheckBox);

		// generate a number from 1 to deleteBtnCount
		int randomRowNumber = DynamicDataGenerator.generateRandomNumber(totalCheckBox);
		// then select that random number row to get user name and click on delete button
		multiplesingleProgUser = AssignStudentDetailsPage.selectCheckboxFromARow(randomRowNumber);*/
	}

	@Then("Admin should see common delete option enabled under header Manage user")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_user() {
		LoggerLoad.info( "Admin should see common delete option enabled under header Manage user");
		softAssert.assertTrue(AssignStudentDetailsPage.isDeleteButtonPresent());

	}
	///*******************Multiple Deletion using single checkbox
	
	@Given("Admin clicks on Multple Delete button on Manage User Page")
	public void admin_clicks_on_multple_delete_button_on_manage_user_page() {
		LoggerLoad.info( "Admin clicks on Multple Delete button on Manage User Page");
		DeleteMultipleUser = AssignStudentDetailsPage.clickMultipleUserDeleteBtn();

	}
	@When("Admin clicks {string} button on  Confirm Deletion alert for User")
	public void admin_clicks_button_on_confirm_deletion_alert_for_user(String delBtnOption) {
		LoggerLoad.info( "Admin clicks {string} button on  Confirm Deletion alert for User");
		if (delBtnOption.trim().toLowerCase().equals("yes")) {
			AssignStudentDetailsPage = DeleteMultipleUser.clickYesBtn();
		} 
		else if (delBtnOption.trim().toLowerCase().equals("no")) {
			AssignStudentDetailsPage = DeleteMultipleUser.clickNoBtn();
		}
		else if (delBtnOption.trim().toLowerCase().equals("close")) {
			AssignStudentDetailsPage = DeleteMultipleUser.clickCloseBtn();
		}

	}
	@Given("Admin clicks any checkbox in the user data table for deletion")
	public void admin_clicks_any_checkbox_in_the_user_data_table_for_deletion() {
		LoggerLoad.info( "Admin clicks any checkbox in the user data table for deletion");
		LoggerLoad.info( "Calling mutiple user button enabled");
		Boolean val = AssignStudentDetailsPage.isMultipleDeleteBtnPresent();
        System.out.println("value present" +val);
		softAssert.assertFalse(AssignStudentDetailsPage.isMultipleDeleteBtnEnabled());
		int totalCheckBox = AssignStudentDetailsPage.getCheckboxCount();
		System.out.println("Number of CheckBoxes in current Manage Program Page = " + totalCheckBox);

		// generate a number from 1 to deleteBtnCount
		int randomRowNumber = DynamicDataGenerator.generateRandomNumber(totalCheckBox);
		// then select that random number row to get program name and click on delete button
		multiplesingleProgUser = AssignStudentDetailsPage.selectCheckboxFromARow(randomRowNumber);
	}
	@Then("Admin should land on Manage User page and can see the selected users are deleted from the data table")
	public void admin_should_land_on_manage_user_page_and_can_see_the_selected_users_are_deleted_from_the_data_table() {
		LoggerLoad.info( "Admin should land on Manage User page and can see the selected users are deleted from the data table");
		Assert.assertEquals(AssignStudentDetailsPage.getPaginationText(), AppConstants.NO_SEARCH_RESULT_FOUND_TEXT);

	}
	@Then("Admin should land on Manage User page and can see the selected user are deleted from the data table")
	public void admin_should_land_on_manage_user_page_and_can_see_the_selected_user_are_deleted_from_the_data_table() {
		LoggerLoad.info( "Admin should land on Manage User page and can see the selected users are deleted from the data table");
		Assert.assertEquals(AssignStudentDetailsPage.getPaginationText(), AppConstants.NO_SEARCH_RESULT_FOUND_TEXT);

	}

	
}
