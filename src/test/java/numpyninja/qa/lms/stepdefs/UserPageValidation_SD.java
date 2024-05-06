package numpyninja.qa.lms.stepdefs;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import numpyninja.qa.lms.constants.AppConstants;
import numpyninja.qa.lms.driver.DriverFactory;
import numpyninja.qa.lms.pages.AssignStaffDetailsPage;
import numpyninja.qa.lms.pages.DashboardPage;
import numpyninja.qa.lms.pages.HomePage;
import numpyninja.qa.lms.pages.ManageBatchPage;
import numpyninja.qa.lms.pages.ManageProgramPage;
import numpyninja.qa.lms.pages.ManageUserPage;
import numpyninja.qa.lms.pages.ProgramDetailsPage;
import numpyninja.qa.lms.pages.UserDetailsPage;
import numpyninja.qa.lms.utils.DynamicDataGenerator;
import numpyninja.qa.lms.utils.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class UserPageValidation_SD {

	WebDriver driver;

	ManageUserPage manageUserPage;
	UserDetailsPage userDetailsPage;
	AssignStaffDetailsPage assignStaffDetailsPage;
	SoftAssert softAssert;

	HashMap<String, String> map;
	String expectedDisplayedName;
	List<String> colListBeforeSort;
	List<String> colListAfterSort;

	public UserPageValidation_SD() {
		driver = DriverFactory.getDriver();
		manageUserPage = new ManageUserPage(driver);
		softAssert = new SoftAssert();

		List<String> colListBeforeSort;
		List<String> colListAfterSort;
	}

	// ********************* Manage User Page Validation
		// *****************************
	
	@Then("Admin should see the {string} in the header")
	public void admin_should_see_the_in_the_header(String ManageUser) {
		Assert.assertTrue(manageUserPage.isManagerUserHeaderExist());
		LoggerLoad.info("Admin is able to see Manage User Button on Manage User Page above Data Table");
	}

	@Then("Admin should see the {string} along with Pagination icon below the table")
	public void admin_should_see_the_along_with_pagination_icon_below_the_table(String expectedtext) {

		Assert.assertEquals(manageUserPage.getTextwithPaginationIcon(), expectedtext);
		LoggerLoad.info("Admin is able to see the text with Pagination Icon on Manage User Page below Data Table");
	}

	@Then("Admin should see the data table with {string}, Id, Name, location, Phone Number, Edit\\/Delete")
	public void admin_should_see_the_data_table_with_id_name_location_phone_number_edit_delete(
			String expectedTableHeading) {

		System.out.println("No. of recoeds " + manageUserPage.getTableColNames());
		System.out.println("Expected no of records " + expectedTableHeading);
		softAssert.assertEquals(manageUserPage.getTableColNames(), expectedTableHeading);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoggerLoad.info("Admin is able to see the Table with column names");
		// softAssert.assertEquals(manageUserPage.getTableColNames() ,
			// expectedNumberofRecords);
	}

	@Then("Admin should be able to see the Delete icon button that is disabled")
	public void admin_should_be_able_to_see_the_delete_icon_button_that_is_disabled() {

		Assert.assertTrue(manageUserPage.isTopDeleteIconDisabled());
		LoggerLoad.info("Admin is able to see the Delete icon button that is disabled on Manage User Page");
	}

	@Then("Admin should see the Add New User button above the data table")
	public void admin_should_see_the_add_new_user_button_above_the_data_table() {

		Assert.assertTrue(manageUserPage.isAddNewUserButtonExist());
		LoggerLoad.info("Admin is able to see Add New User Button on Manage User Page above Data Table");
	}

	@Then("Admin should see the + Assign staff button above the data table")
	public void admin_should_see_the_assign_staff_button_above_the_data_table() {

		Assert.assertTrue(manageUserPage.isAssignStudenetButtonExist());
		LoggerLoad.info("Admin is able to see Assign Staff Button on Manage User Page above Data Table");
	}

	@Then("Admin should see the + Assign Student button above the data table")
	public void admin_should_see_the_assign_student_button_above_the_data_table() {
		Assert.assertTrue(manageUserPage.isAssignStudenetButtonExist());
		LoggerLoad.info("Admin is able to see Assign Student Button on Manage User Page above Data Table");
	}

	@Then("Admin should see the search text box above the data table")
	public void admin_should_see_the_search_text_box_above_the_data_table() {
		Assert.assertTrue(manageUserPage.isSearchBoxExist());
		LoggerLoad.info("Admin is able to see Search Box on Manage User Page above Data Table");
	}

	@Then("Admin should see the number of records  displayed on the page are {int}")
	public void admin_should_see_the_number_of_records_displayed_on_the_page_are(Integer expectedNumberofRecords) {
		System.out.println("No. of recoeds " + manageUserPage.getNumberOfRecordsDisplayed());
		System.out.println("Expected no of records " + expectedNumberofRecords);
		softAssert.assertEquals(manageUserPage.getNumberOfRecordsDisplayed(), expectedNumberofRecords);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoggerLoad.info("Admin is able to see the number of records displayed on the page");
	}

	/**
	 * User Details Pop up with empty fields when Admin clicks Add New User
	 */
	@When("Admin clicks Add New User button")
	public void admin_clicks_add_new_user_button() {
		userDetailsPage = manageUserPage.clickAddNewUserButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
					}
		LoggerLoad.info("Admin is clicking the Add New User Button on Manage User page");
	}

	@Then("Admin should see a popup open for {string} with empty form along with <SAVE> and <CANCEL> button and Close \\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window(
			String expectedUserDetailsHeader) {
		softAssert.assertEquals(userDetailsPage.getHeaderText(), expectedUserDetailsHeader);
		softAssert.assertTrue(userDetailsPage.isFirstNameFieldEmpty());
		softAssert.assertTrue(userDetailsPage.isMiddleNameFieldEmpty());
		softAssert.assertTrue(userDetailsPage.isLastNameFieldEmpty());
		softAssert.assertTrue(userDetailsPage.isLocationFieldEmpty());
		softAssert.assertTrue(userDetailsPage.isPhoneNoFieldEmpty());
		softAssert.assertTrue(userDetailsPage.isLinkedinUrlFieldEmpty());
		softAssert.assertTrue(userDetailsPage.isEmailFieldEmpty());
		softAssert.assertTrue(userDetailsPage.isUnderGraduateFieldEmpty());
		softAssert.assertTrue(userDetailsPage.isPostGraduateFieldEmpty());
		softAssert.assertTrue(userDetailsPage.isTimeZoneFieldEmpty());
		softAssert.assertTrue(userDetailsPage.isUserCommentsFieldEmpty());
		softAssert.assertTrue(userDetailsPage.isUserRoleFieldPresent());
		softAssert.assertTrue(userDetailsPage.isUserRoleStatusFieldPresent());
		softAssert.assertTrue(userDetailsPage.isVisaStatusFieldPresent());
		softAssert.assertTrue(userDetailsPage.isSubmitButtonPresent());
		softAssert.assertTrue(userDetailsPage.isCancelUserButtonPresent());
		softAssert.assertTrue(userDetailsPage.isUserCloseButtonPresent());
		softAssert.assertAll();
		LoggerLoad.info(
				"Admin is able to see empty form along with Save, Cancel and Close (x) Icon on User Details Page");

	}

	/**
	 * Assign Staff Pop up with empty form
	 */
	@When("Admin clicks Assign Staff button")
	public void admin_clicks_assign_staff_button() {
		assignStaffDetailsPage = manageUserPage.clickAssignStaffButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LoggerLoad.info("Admin is clicking the Assign Staff Button on Manage User page");

	}

	@Then("Admin should see a popup for {string} with empty form along with <SAVE> and <CANCEL> button and Close \\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_for_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window(
			String expectedAssignStaffsHeader) {
		softAssert.assertEquals(assignStaffDetailsPage.getHeaderText(), expectedAssignStaffsHeader);
		softAssert.assertTrue(assignStaffDetailsPage.isUserRoleFieldPresent());
		softAssert.assertTrue(assignStaffDetailsPage.isStaffEmailIdFieldPresent());
		softAssert.assertTrue(assignStaffDetailsPage.isSkillFieldEmpty());
		softAssert.assertTrue(assignStaffDetailsPage.isProgramNameFieldPresent());
		softAssert.assertTrue(assignStaffDetailsPage.isBatchNameFieldPresent());
		softAssert.assertTrue(assignStaffDetailsPage.isActiveBoxExists());
		softAssert.assertTrue(assignStaffDetailsPage.isInActiveBoxExists());

		softAssert.assertTrue(assignStaffDetailsPage.isCancelButtonPresent());
		softAssert.assertTrue(assignStaffDetailsPage.isSaveButtonPresent());
		softAssert.assertTrue(assignStaffDetailsPage.isCloseButtonPresent());
		LoggerLoad.info(
				"Admin is able to see empty form along with Save, Cancel and Close (x) Icon on Assign Staff pop up");
	}

	// ******************* Manage User Header Validation
	//*******************************
	
	@Given("Admin is on Manage User Page")
	public void admin_is_on_manage_user_page() {

		Assert.assertTrue(manageUserPage.isManagerUserHeaderExist());
		LoggerLoad.info("Admin is on Manage User page");
	}

	// ********************* Ascending/Descending Sorting Step Def
	// *****************************

	@When("Admin clicks the sort icon of {string} column in User Data Table")
	public void admin_clicks_the_sort_icon_of_column_in_user_data_table(String colName) throws InterruptedException {

		// List before sort button is clicked
		colListBeforeSort = manageUserPage.getTextListFromAllPages(colName);
		Thread.sleep(5000);
		// Come back to first page
		manageUserPage.clickOnFirstNextPreviousLastLink("first");

		// click on sort button next to colName
		manageUserPage.clickSortIcon(colName, "ascending");

		// List after sort button is clicked
		colListAfterSort = manageUserPage.getTextListFromAllPages(colName);
		LoggerLoad.info("Admin clicks sort icon of  each column in Manage User page");

	}

	@Then("The data get sorted on the table based on the column name values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_column_name_values_in_ascending_order() {
		Collections.sort(colListBeforeSort,String.CASE_INSENSITIVE_ORDER);
		//Collections.sort(colListBeforeSort);
		Assert.assertTrue(colListBeforeSort.equals(colListAfterSort));
		LoggerLoad.info("Each column is sorted in Ascending Order in Manage User page");
	}

	@When("Admin clicks the sort icon of {string} column twice User Data Table")
	public void admin_clicks_the_sort_icon_of_column_twice_user_data_table(String colName) {

		// List before sort button is clicked
		colListBeforeSort = manageUserPage.getTextListFromAllPages(colName);

		// Come back to first page
		manageUserPage.clickOnFirstNextPreviousLastLink("first");

		// click on sort button next to colName
		manageUserPage.clickSortIcon(colName, "descending");

		// List after sort button is clicked
		colListAfterSort = manageUserPage.getTextListFromAllPages(colName);

		LoggerLoad.info("Admin clicks sort icon twice of each column in Manage User page");

	}

	@Then("The data get sorted on the table based on the column name values in descending order")
	public void the_data_get_sorted_on_the_table_based_on_the_column_name_values_in_descending_order() {
		// Sort the unsorted list in descending order
		Collections.sort(colListBeforeSort,String.CASE_INSENSITIVE_ORDER);
		//Collections.sort(colListBeforeSort);
		Collections.reverse(colListBeforeSort);
		Assert.assertTrue(colListBeforeSort.equals(colListAfterSort));
		LoggerLoad.info("Each column is sorted in Descending Order in Manage User page");
	}

}
