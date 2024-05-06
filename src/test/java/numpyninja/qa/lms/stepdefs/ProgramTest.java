package numpyninja.qa.lms.stepdefs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import numpyninja.qa.lms.constants.AppConstants;
import numpyninja.qa.lms.driver.DriverFactory;
import numpyninja.qa.lms.pages.DashboardPage;
import numpyninja.qa.lms.pages.DeleteProgramPage;
import numpyninja.qa.lms.pages.HomePage;
import numpyninja.qa.lms.pages.ManageBatchPage;
import numpyninja.qa.lms.pages.ManageProgramPage;
import numpyninja.qa.lms.pages.ManageUserPage;
import numpyninja.qa.lms.pages.ProgramDetailsPage;
import numpyninja.qa.lms.pojo.Program;
import numpyninja.qa.lms.utils.DynamicDataGenerator;
import numpyninja.qa.lms.utils.LoggerLoad;
import numpyninja.qa.lms.utils.RunTimeDataReader;

public class ProgramTest {

	WebDriver driver;
	SoftAssert softAssert;
	RunTimeDataReader runTimeData;
	Program prog;
	
	HomePage homePage;
	DashboardPage dashboardPage;
	ManageProgramPage manageProgramPage;
	ProgramDetailsPage programDetailsPage;
	DeleteProgramPage deleteProgramPage;
	ManageBatchPage manageBatchPage;
	ManageUserPage manageUserPage;


	String prgName_delete;
	String multipleDel_singleProg;
	List<String> multipleDel_multipleProg;
	List<String> colListBeforeSort;
	List<String> colListAfterSort;
	int totalPages_manageProg;
	String prgName_search;
	String prgmDes_search;
	


	public ProgramTest() {
		driver = DriverFactory.getDriver();
		
		homePage = new HomePage(driver);;
		dashboardPage = new DashboardPage(driver);
		manageProgramPage = new ManageProgramPage(driver);
		programDetailsPage = new ProgramDetailsPage(driver);
		deleteProgramPage = new DeleteProgramPage(driver);
		manageBatchPage = new ManageBatchPage(driver);
		manageUserPage = new ManageUserPage(driver);
		
		softAssert = new SoftAssert();
		runTimeData = new RunTimeDataReader();
		prog = new Program();
	}

	//*********************** Steps for Program Page Validation *********************************
	
	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String menuName) throws InterruptedException {
		
			Thread.sleep(2000);
		
		String menu = menuName.trim().toLowerCase();
		switch (menu) {
		case "program":
			manageProgramPage = dashboardPage.clickProgramMenu();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			break;
		case "batch":

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			manageBatchPage = dashboardPage.clickBatchMenu();
			break;
		case "user":
			manageUserPage = dashboardPage.clickUserMenu();
			break;
		case "logout":
			homePage = dashboardPage.clickLogoutMenu();
			break;
		}
		LoggerLoad.info(" Admin clicks Program on the navigation bar ");

	}

	@Then("Admin should see URL with {string}")
	public void admin_should_see_url_with(String partialURLString) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String partialURL = partialURLString.trim().toLowerCase();

		switch (partialURL) {
		case "manage program":
			Assert.assertTrue(manageProgramPage.getPageUrl().contains(partialURL)); // it's a fail
			break;
		case "manage batch":
			Assert.assertTrue(manageBatchPage.getPageUrl().contains(partialURL));
			break;
		case "manage user":
			Assert.assertTrue(manageUserPage.getPageUrl().contains(partialURL));
			break;
		case "login":
			Assert.assertTrue(homePage.getPageUrl().contains(partialURL));
			break;
		} 

		driver.quit();
		LoggerLoad.info(" Admin should see URL with Program ");
	}



	@Given("Admin is on Manage Program page")
	public void admin_is_on_manage_program_page() {
		
		Assert.assertTrue(manageProgramPage.doesHeaderExist());
		LoggerLoad.info(" Admin is on Manage Program page ");
	}
	
	@Then("Admin should see a heading with text Manage Program on the page")
	public void admin_should_see_a_heading_with_text_manage_program_on_the_page() {
	   
		Assert.assertTrue(manageProgramPage.doesHeaderExist()) ;
		LoggerLoad.info(" Admin is able to see a heading with text Manage Program on the page ");
	}


    @Then("Admin should see the text as Showing x to y of z entries along with Pagination icon below the table x- starting record number on that page y-ending record number on that page z-Total number of records\"")
    public void admin_should_see_the_text_as_showing_x_to_y_of_z_entries_along_with_pagination_icon_below_the_table_x_starting_record_number_on_that_page_y_ending_record_number_on_that_page_z_total_number_of_records() {
  
	   Assert.assertTrue(manageProgramPage.getPaginationText().contains("Showing 1"));
	   LoggerLoad.info("Admin is able to see the text as Showing x to y of z entries along with Pagination icon below the table x- starting record number on that page y-ending record number on that page z-Total number of records  ");
    }

    @Then("Admin should see the footer as In total there are z programs. z- Total number of records\"")
    public void admin_should_see_the_footer_as_in_total_there_are_z_programs_z_total_number_of_records() {
  
	   softAssert.assertTrue(manageProgramPage.getTotalRecordText().contains("In total there are "));
	   softAssert.assertTrue(manageProgramPage.getTotalRecordText().contains(" programs."));

	   softAssert.assertAll();
	   LoggerLoad.info(" Admin is able to see the footer as In total there are z programs. z- Total number of records ");
    }

	@Then("Admin should see a Delete button on the top left hand side as Disabled")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {
	  
		Assert.assertFalse(manageProgramPage.isMultipleDeleteBtnEnabled());
		LoggerLoad.info("Admin is able to see a Delete button on the top left hand side as Disabled  ");
	}

	@Then("Admin should see a +A New Program button on the program page above the data table")
	public void admin_should_see_a_a_new_program_button_on_the_program_page_above_the_data_table() {
	
		Assert.assertTrue(manageProgramPage.NewProgramBtnIsDisplay());
		LoggerLoad.info("Admin is able to see a +A New Program button on the program page above the data table  ");
	}


	
	@Then("Admin should see the number of records \\(rows of data in the table) displayed on the page are {int}")
	public void admin_should_see_the_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are(Integer expectedRows) {
	  
		int numberOfRows = 0;
		
		if(manageProgramPage.getTotalNumberOfPrograms()>5){
			numberOfRows = manageProgramPage.getCheckboxCount();
		}
		else
			System.out.println("Total number of Programs is less than 5 so this step cannot be validated");		
			System.out.println("Total number of Programs is = "+ manageProgramPage.getTotalNumberOfPrograms());		
		
		Assert.assertEquals(numberOfRows, expectedRows);	
		LoggerLoad.info(" Admin should see the number of records \\\\(rows of data in the table) displayed on the page ");
	}

	@Then("Admin should see data table on the Manage Program Page with following column headers \\(Program Name, Program Description, Program Status, Edit,Delete)")
	public void admin_should_see_data_table_on_the_manage_program_page_with_following_column_headers_program_name_program_description_program_status_edit_delete() {
	  
		Assert.assertTrue(manageProgramPage.doesHeaderExist());
		LoggerLoad.info(" Admin is able to see data table on the Manage Program Page with following column headers \\\\(Program Name, Program Description, Program Status, Edit,Delete)");
				
	}
	
	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
	  
		softAssert.assertTrue(manageProgramPage.ArrowIconProgram());
		softAssert.assertTrue(manageProgramPage.ArrowIconDescription());
		softAssert.assertTrue(manageProgramPage.ArrowIconProgramStatus());
		softAssert.assertAll();	
		LoggerLoad.info(" Admin is able to see the sort arrow icon beside to each column header except Edit and Delete ");
		
	}
	
	@Then("Admin should see check box on the left side in all rows of the data table")
	public void admin_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table() {
	  
		softAssert.assertTrue(manageProgramPage.CheckBoxTop());
		softAssert.assertTrue(manageProgramPage.CheckBox1());
		softAssert.assertTrue(manageProgramPage.CheckBox2());
		softAssert.assertTrue(manageProgramPage.CheckBox3());
		softAssert.assertTrue(manageProgramPage.CheckBox4());
		softAssert.assertTrue(manageProgramPage.CheckBox5());
		softAssert.assertAll();	
		LoggerLoad.info(" Admin is able to see check box on the left side in all rows of the data table ");
		
	}
	
	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
	  

		Assert.assertTrue(manageProgramPage.AllEditnDeleteBtn());
		LoggerLoad.info(" Admin is able to see the Edit and Delete buttons on each row of the data table ");

		int rowFound = manageProgramPage.getTotalRows();
		softAssert.assertEquals(manageProgramPage.getEditOrDeleteBtnCount("edit"), rowFound);
		softAssert.assertEquals(manageProgramPage.getEditOrDeleteBtnCount("delete"), rowFound);
		softAssert.assertAll();

	}
	
	
		
	//*********************** Steps for Navigation Validation from Manage Program to other Pages  *****************************************

	
	@When("Admin clicks on Batch link on Manage Program page")
	public void admin_clicks_on_batch_link_on_manage_program_page() {
	   
		manageBatchPage = manageProgramPage.clickBatchMenu();
		LoggerLoad.info(" Admin is able to click on Batch link on Manage Program page ");
		
		
	}

	@Then("Admin is re-directed to Batch page")
	public void admin_is_re_directed_to_batch_page() {
		
		Assert.assertTrue(manageBatchPage.manageBatchHeaderExists());
		LoggerLoad.info("Admin is able to re-directed to Batch page  ");
		
	}

	@When("Admin clicks on User link on Manage Program page")
	public void admin_clicks_on_user_link_on_manage_program_page() {
	    
		manageUserPage = manageProgramPage.clickUserMenu();
		LoggerLoad.info(" Admin clicks on User link on Manage Program page ");
	
	}
	
	@Then("Admin is re-directed to User page")
	public void admin_is_re_directed_to_user_page() {
		

		Assert.assertTrue(manageBatchPage.manageUserHeaderExists());
		LoggerLoad.info(" Admin is able to re-directed to User page ");

		Assert.assertTrue(manageUserPage.isManagerUserHeaderExist());
	    
	}

	@When("Admin clicks on Logout link on Manage Program page")
	public void admin_clicks_on_logout_link_on_manage_program_page() {
		
		homePage = manageProgramPage.clickLogoutMenu();	
		LoggerLoad.info(" Admin clicks on Logout link on Manage Program page ");
	}
	

	@Then("Admin is re-directed to Login page")
	public void admin_is_re_directed_to_login_page() {
	
		Assert.assertTrue(homePage.getPageUrl().contains("/login"));  
		LoggerLoad.info(" Admin is able to re-directed to Login page ");
	}

	//*********************** Steps for Single Deletion *****************************************

	@Then("Admin clicks on clicks <Delete> button on the data table on Manage Program page")
	public void admin_clicks_on_clicks_delete_button_on_the_data_table_on_manage_program_page() {
	    
		prog = runTimeData.getProgram();
		deleteProgramPage = manageProgramPage.clickOnDeleteBtnForProgram(prog.getProgramName());
		LoggerLoad.info(" Admin is able to click on clicks <Delete> button on the data table on Manage Program page ");
		
	}

	
	@When("Admin clicks <Delete> button on the data table for any row")
	public void admin_clicks_delete_button_on_the_data_table_for_any_row() {

		int deleteBtnCount = manageProgramPage.getEditOrDeleteBtnCount("Delete");
		System.out.println("Number of Delete buttons in current Manage Program Page = " + deleteBtnCount);

		int randomRowNumber = DynamicDataGenerator.generateRandomNumber(deleteBtnCount);
		// then select that random number row to get program name and click on delete button
		//prgName_delete = manageProgramPage.getProgramNameFromARow(randomRowNumber);
		prog =  new Program();
		prog.setProgramName(manageProgramPage.getProgramNameFromARow(randomRowNumber));

		
		deleteProgramPage = manageProgramPage.clickDeleteBtnFromARow(randomRowNumber);
		LoggerLoad.info(" Admin can clicks <Delete> button on the data table for any row ");
	}

	@Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(
			String expHeaderString) {

		softAssert.assertEquals(deleteProgramPage.getHeaderText(), expHeaderString);
		softAssert.assertTrue(deleteProgramPage.yesBtnExists());
		softAssert.assertTrue(deleteProgramPage.noBtnExists());

		softAssert.assertAll();
		LoggerLoad.info(" Admin is able to see a alert open with heading {string} along with  <YES> and <NO> button for deletion\") ");
	}

	@Then("Admin should see a message {string}")
	public void admin_should_see_a_message(String deleteDialogMsg) {

		String[] arr = deleteProgramPage.getDialogText().split(prgName_delete);
		Assert.assertTrue(deleteDialogMsg.contains(arr[0]));
		LoggerLoad.info(" Admin can see a message 'Are you sure you want to delete the selected programs' ");
	}
	

	@When("Admin clicks <YES> button on the alert")
	public void admin_clicks_yes_button_on_the_alert() {
		manageProgramPage = deleteProgramPage.clickYesBtn();
		LoggerLoad.info("Admin clicks <YES> button on the alert  ");
		
	}

	@Then("Admin gets a message {string} alert and able to see that program deleted in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_that_program_deleted_in_the_data_table(
			String deletionSuccesMsg) throws InterruptedException {
		
		softAssert.assertEquals(manageProgramPage.getFlyingMsgText(), deletionSuccesMsg);
		
		manageProgramPage.enterTextInSearchBox(prog.getProgramName());
		Thread.sleep(1000);
		
		softAssert.assertEquals(manageProgramPage.getPaginationText(), AppConstants.NO_SEARCH_RESULT_FOUND_TEXT);
		softAssert.assertAll();
		LoggerLoad.info("Admin gets a message alert and able to see that program deleted in the data table  ");
	}

	@When("Admin clicks {string} button on the alert")
	public void admin_clicks_button_on_the_alert(String buttonName) {
		String button = buttonName.trim().toLowerCase();

		if (button.equals("no")) {
			manageProgramPage = deleteProgramPage.clickNoBtn();
		} else if (button.equals("close")) {
			manageProgramPage = deleteProgramPage.clickCloseBtn();
		}
		LoggerLoad.info(" Admin clicks the button on the alert ");

	}

	@Then("Admin can see the deletion alert disappears without deleting")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting() {

		manageProgramPage.enterTextInSearchBox(prgName_delete);
		Assert.assertEquals(manageProgramPage.getPaginationText(), AppConstants.SEARCH_RESULT_FOUND_TEXT);
		LoggerLoad.info(" Admin can see the deletion alert disappears without deleting ");
	}

	//*********************** Steps for Multiple Deletion *****************************************
	
	@When("Admin clicks any checkbox in the data table")
	public void admin_clicks_any_checkbox_in_the_data_table() {

		softAssert.assertFalse(manageProgramPage.isMultipleDeleteBtnEnabled());
		int totalCheckBox = manageProgramPage.getCheckboxCount();
		System.out.println("Number of CheckBoxes in current Manage Program Page = " + totalCheckBox);

		// generate a number from 1 to deleteBtnCount
		int randomRowNumber = DynamicDataGenerator.generateRandomNumber(totalCheckBox);
		// then select that random number row to get program name and click on delete button
		multipleDel_singleProg = manageProgramPage.selectCheckboxFromARow(randomRowNumber);
		LoggerLoad.info(" Admin clicks any checkbox in the data table ");

	}

	
	@Then("Admin should see common delete option enabled under header Manage Program")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_program() {

		Assert.assertTrue(manageProgramPage.isMultipleDeleteBtnEnabled());
		LoggerLoad.info(" Admin should see common delete option enabled under header Manage Program ");
	}

	@Given("Admin clicks on Multple Delete button on Manage Program Page")
	public void admin_clicks_on_multple_delete_button_on_manage_program_page() {
		deleteProgramPage = manageProgramPage.clickMultipleDeleteBtn();
		LoggerLoad.info(" Admin clicks on Multple Delete button on Manage Program Page ");

	}
	
	@Then("Admin should see {string} on Confirm Deletion alert")
	public void admin_should_see_on_confirm_deletion_alert(String expDelMsg) {

		Assert.assertEquals(deleteProgramPage.getDialogText(), expDelMsg);
		LoggerLoad.info("Admin should see on Confirm Deletion alert  ");
	}

	@When("Admin clicks {string} button on  Confirm Deletion alert")
	public void admin_clicks_button_on_confirm_deletion_alert(String delBtnOption) {

		if (delBtnOption.trim().toLowerCase().equals("yes")) {
			manageProgramPage = deleteProgramPage.clickYesBtn();
		} 
		else if (delBtnOption.trim().toLowerCase().equals("no")) {
			manageProgramPage = deleteProgramPage.clickNoBtn();
		}
		else if (delBtnOption.trim().toLowerCase().equals("close")) {
			manageProgramPage = deleteProgramPage.clickCloseBtn();
		}
		LoggerLoad.info(" Admin clicks delete button on  Confirm Deletion alert ");

	}

	@Then("Admin should land on Manage Program page and can see the selected program is deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_deleted_from_the_data_table() {

		manageProgramPage.enterTextInSearchBox(multipleDel_singleProg);
		Assert.assertEquals(manageProgramPage.getPaginationText(), AppConstants.NO_SEARCH_RESULT_FOUND_TEXT);
		LoggerLoad.info(" Admin should land on Manage Program page and can see the selected program is deleted from the data table ");
	}

	@Then("Admin should land on Manage Program page and can see the selected program is not deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_not_deleted_from_the_data_table() {

		manageProgramPage.enterTextInSearchBox(multipleDel_singleProg);
		Assert.assertEquals(manageProgramPage.getPaginationText(), AppConstants.SEARCH_RESULT_FOUND_TEXT);
		LoggerLoad.info(" Admin should land on Manage Program page and can see the selected program is not deleted from the data table ");
	}

	@Given("Admin clicks multiple checkboxes in the data table")
	public void admin_clicks_multiple_checkboxes_in_the_data_table() {

		multipleDel_multipleProg = new ArrayList<String>();
		if (manageProgramPage.getCheckboxCount() > 1) {
			multipleDel_multipleProg.add(manageProgramPage.selectCheckboxFromARow(1));
			multipleDel_multipleProg.add(manageProgramPage.selectCheckboxFromARow(2));
		} else {
			System.out.println("Manage Program has only 1 record. Cannot execute current step");
		}

		LoggerLoad.info(" Admin clicks multiple checkboxes in the data table ");
	}

	@Then("Admin should land on Manage Program page and can see the selected programs are deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_deleted_from_the_data_table() {

		for (String deletedProgram : multipleDel_multipleProg) {

			manageProgramPage.enterTextInSearchBox(deletedProgram);
			softAssert.assertEquals(manageProgramPage.getPaginationText(), AppConstants.NO_SEARCH_RESULT_FOUND_TEXT);
		}
		softAssert.assertAll();
		LoggerLoad.info(" Admin can land on Manage Program page and can see the selected programs are deleted from the data table ");
	}

	@Then("Admin should land on Manage Program page and can see the selected programs are not deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_not_deleted_from_the_data_table() {

		for (String deletedProgram : multipleDel_multipleProg) {

			manageProgramPage.enterTextInSearchBox(deletedProgram);
			softAssert.assertEquals(manageProgramPage.getPaginationText(), AppConstants.SEARCH_RESULT_FOUND_TEXT);
		}
		softAssert.assertAll();
		LoggerLoad.info(" Admin can land on Manage Program page and can see the selected programs are not deleted from the data table ");
	}
	
//********************* Ascending/Descending Sorting Step Def *****************************
	
	@Given("Admin clicks the sort icon of {string} column")
	public void admin_clicks_the_sort_icon_of_column(String colName) {
	    
		//List before sort button is clicked
		colListBeforeSort = manageProgramPage.getTextListFromAllPages(colName);
		
		//Come back to first page
		manageProgramPage.clickOnFirstNextPreviousLastLink("first");
		
		//click on sort button next to colName
		manageProgramPage.clickSortIcon(colName, "ascending");
		
		//List after sort button is clicked
		colListAfterSort = manageProgramPage.getTextListFromAllPages(colName);
		LoggerLoad.info(" Admin clicks the sort icon of <colName> column");
		
	}
	@Then("The data get sorted on the table based on the program name column values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_ascending_order() {
		
		//Sort the unsorted list in ascending order
		Collections.sort(colListBeforeSort,String.CASE_INSENSITIVE_ORDER);	    
		Assert.assertTrue(colListBeforeSort.equals(colListAfterSort));
		LoggerLoad.info("The data get sorted on the table based on the program name column values in ascending order  ");
	}
	
	@Given("Admin clicks the sort icon of {string} column twice")
	public void admin_clicks_the_sort_icon_of_column_twice(String colName) {
		
		//List before sort button is clicked
		colListBeforeSort = manageProgramPage.getTextListFromAllPages(colName);
		
		//Come back to first page
		manageProgramPage.clickOnFirstNextPreviousLastLink("first");
		
		//click on sort button next to colName
		manageProgramPage.clickSortIcon(colName, "descending");
		
		//List after sort button is clicked
		colListAfterSort = manageProgramPage.getTextListFromAllPages(colName);
		LoggerLoad.info("Admin clicks the sort icon of {string} column twice  ");
	    
	}
	@When("The data get sorted on the table based on the program name column values in descending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_descending_order() {
	    
		//Sort the unsorted list in descending order
		//List<String> sortedList = new ArrayList<>(originalList);
		Collections.sort(colListBeforeSort, String.CASE_INSENSITIVE_ORDER);
		Collections.reverse(colListBeforeSort);	    

		Assert.assertTrue(colListBeforeSort.equals(colListAfterSort));
		LoggerLoad.info("The data get sorted on the table based on the program name column values in descending order  ");
	}
	
	//********************** Pagination Step Def *******************************
	
	@Given("There are more than {int} programs in total in Manage Program page")
	public void there_are_more_than_programs_in_total_in_manage_program_page(Integer programCount) {
		
		totalPages_manageProg=manageProgramPage.getTotalNumberOfPages();
		
		Assert.assertTrue(manageProgramPage.getTotalNumberOfPrograms()>programCount);
		System.out.println("Total number of Programs found = " + manageProgramPage.getTotalNumberOfPrograms());
		LoggerLoad.info("There are more than 5 programs in total in Manage Program page  ");
		
	}
	@Then("Admin should see the Pagination has {string} and {string} icon link to be active")
	public void admin_should_see_the_pagination_has_and_icon_link_to_be_active(String icon1, String icon2) {
		
		System.out.println(manageProgramPage.isFirstNextPreviousLastLinkIconLinkEnabled(icon1));
		softAssert.assertTrue(manageProgramPage.isFirstNextPreviousLastLinkIconLinkEnabled(icon1));
		
		System.out.println(manageProgramPage.isFirstNextPreviousLastLinkIconLinkEnabled(icon2));
		softAssert.assertTrue(manageProgramPage.isFirstNextPreviousLastLinkIconLinkEnabled(icon2));	
		softAssert.assertAll();
		LoggerLoad.info(" Admin should see the Pagination has \"Next\" and \"Last\" icon link to be active ");
	}

	
	@When("Admin clicks on {string} icon link from pagination section")
	public void admin_clicks_on_icon_link_from_pagination_section(String navIcon) {
		String icon = navIcon.trim().toLowerCase();

		if(icon.equals("last")) {
			manageProgramPage.clickOnFirstNextPreviousLastLink("last");	
		}
		else if(icon.equals("next")) {
			manageProgramPage.clickOnFirstNextPreviousLastLink("next");	
		}
		else if(icon.equals("previous")) {
			manageProgramPage.clickOnFirstNextPreviousLastLink("previous");	
		}
		else if(icon.equals("first")) {
			manageProgramPage.clickOnFirstNextPreviousLastLink("first");	
		}
		LoggerLoad.info(" Admin clicks on Next icon link from pagination section ");
	}
	
	
	@Then("Admin is navigated to Last page with {string} page link disabled")
	public void admin_is_navigated_to_last_page_with_page_link_disabled(String navIcon) {
		
		//is page number highlighted?
		softAssert.assertTrue(manageProgramPage.isPageHighlighted(totalPages_manageProg));
		
		//link disabled
		String icon = navIcon.trim().toLowerCase();

		if(icon.equals("next")) {
			manageProgramPage.isFirstNextPreviousLastLinkIconLinkEnabled("next");	
		}
		LoggerLoad.info(" Admin is navigated to Last page with Next page link disabled ");
		
	}
	
	@Then("Admin is navigated to Page {int}")
	public void admin_is_navigated_to_page(Integer pageNumber) {
		
		//is page number highlighted?
		Assert.assertTrue(manageProgramPage.isPageHighlighted(pageNumber));
		LoggerLoad.info(" Admin is navigated to Page 2 ");
	}
	
	@Given("Admin navigates to page {int}")
	public void admin_navigates_to_page(Integer pageNumber) {

		manageProgramPage.navigateToPageNumber(pageNumber);
		LoggerLoad.info("Admin navigates to page 2  ");
	}
	
	@Then("Admin is navigated to First page with {string} page link disabled")
	public void admin_is_navigated_to_first_page_with_page_link_disabled(String navIcon) {

		//is page number highlighted?
		softAssert.assertTrue(manageProgramPage.isPageHighlighted(1));
		
		//link disabled
		String icon = navIcon.trim().toLowerCase();

		if(icon.equals("previous")) {
			manageProgramPage.isFirstNextPreviousLastLinkIconLinkEnabled("previous");	
		}
		LoggerLoad.info(" Admin is navigated to First page with Previous page link disabled ");
	}
		
	}