package numpyninja.qa.lms.stepdefs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.core.logging.Logger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import numpyninja.qa.lms.constants.AppConstants;
import numpyninja.qa.lms.driver.DriverFactory;
import numpyninja.qa.lms.pages.BatchDetailsPage;
import numpyninja.qa.lms.pages.DeleteBatchPage;
import numpyninja.qa.lms.pages.ManageBatchPage;
import numpyninja.qa.lms.utils.DynamicDataGenerator;
import numpyninja.qa.lms.utils.LoggerLoad;

public class Batch_Edit_Delete_SD {

	WebDriver driver;
	ManageBatchPage manageBatchPage;
	SoftAssert softAssert;
	String username_ValidFlag;
	String password_ValidFlag;
	BatchDetailsPage batchDetailsPage;
	DeleteBatchPage deleteBatchPage;


	String batch_delete="TeamAutArcht13006";

	String multipleDel_singleBatch;
	List<String> multipleDel_multipleBat;
	String edit_batch = "TeamAutArcht13006";
	String addBatch_Description;
	String editBatch_Name = "testing";

	public Batch_Edit_Delete_SD() {
		driver = DriverFactory.getDriver();
		manageBatchPage = new ManageBatchPage(driver);
		softAssert = new SoftAssert();
	}

	@Given("Admin should see the edit icon on row level in data table is enabled")
	public void admin_should_see_the_edit_icon_on_row_level_in_data_table_is_enabled() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		manageBatchPage.searchBatch(edit_batch);
		Assert.assertTrue(manageBatchPage.validateEditIconExist());
		System.out.println("validated");
		LoggerLoad.info("Edit icon validated");

	}

	@When("Admin clicks the {string} icon	of the batch")
	public void admin_clicks_the_icon_of_the_batch(String icon) {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (icon.equalsIgnoreCase("edit")) {
			batchDetailsPage = manageBatchPage.clickEditIcon();
			System.out.println("clicked edit");
			LoggerLoad.info("clicked edit");
		} else {
			deleteBatchPage = manageBatchPage.clickDeleteIcon(edit_batch);
			System.out.println("clicked delete");
			LoggerLoad.info("clicked delete");

		}
	}

	@Given("Admin clicks the {string} icon	on the batch")
	public void admin_clicks_the_icon_on_the_batch(String icon) {

		manageBatchPage.searchBatch(edit_batch);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (icon.equalsIgnoreCase("edit")) {
			batchDetailsPage = manageBatchPage.clickEditIcon();
			System.out.println("clicked edit");
			LoggerLoad.info("clicked edit");

		} else {
			deleteBatchPage = manageBatchPage.clickDeleteIcon(edit_batch);
			System.out.println("clicked delete");
			LoggerLoad.info("clicked delete");
		}

	}

	@When("Admin clicks the {string} icon")
	public void admin_clicks_the_icon(String icon) {
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

//		if(icon.equalsIgnoreCase("edit")) {
//		batchDetailsPage =  manageBatchPage.clickEditIcon();
//		System.out.println("clicked edit");
//		}
//		else {
//			batchDetailsPage=  manageBatchPage.clickDeleteIcon();
//			System.out.println("clicked delete");
//		}

		int deleteBtnCount = manageBatchPage.getEditOrDeleteBtnCount("Delete");
		System.out.println("Number of Delete buttons in current Manage Batch Page = " + deleteBtnCount);

		int randomRowNumber = DynamicDataGenerator.generateRandomNumber(deleteBtnCount);

		batch_delete = manageBatchPage.getBatchNameFromARow(randomRowNumber);
		deleteBatchPage = manageBatchPage.clickDeleteBtnFromARow(randomRowNumber);

	}

	@When("Admin search for the batch and clicks the {string} icon")
	public void admin_search_for_the_batch_and_clicks_the_icon(String string) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			
		}
		// manageBatchPage.searchBatch(edit_batch);
		deleteBatchPage = manageBatchPage.clickDeleteIcon(edit_batch);
		System.out.println("clicked delete");
		LoggerLoad.info("clicked delete");

	}

	@Given("Admin search for the batch to be deleted and clicks the {string} icon")
	public void admin_search_for_the_batch_to_be_deleted_and_clicks_the_icon(String string) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			
		}
		manageBatchPage.searchBatch(edit_batch);

		deleteBatchPage = manageBatchPage.clickDeleteIcon(edit_batch);
		// deleteBatchPage = manageBatchPage.clickDeleteBtnFromARow(1);
		System.out.println("clicked delete");
		LoggerLoad.info("clicked delete");
	}

	@When("Admn enter data in Name field")
	public void admn_enter_data_in_name_field() {

		batchDetailsPage.enterBatchNameOnly(editBatch_Name);
	}

	@Then("Admin see the field should be disabled")
	public void admin_see_the_field_should_be_disabled() {

		Assert.assertTrue(batchDetailsPage.isDisabledName());

	}

	@When("Admn enter data in Name {string}")
	public void admn_enter_data_in_name(String batchOrProgram) {

		if (batchOrProgram.equalsIgnoreCase("Batch")) {
			batchDetailsPage.enterBatchNameOnly(editBatch_Name);
		} else if (batchOrProgram.equalsIgnoreCase("Program")) {
			batchDetailsPage.enterProgramName(batchOrProgram);
		}

	}

	@Then("Admin see the {string} should be disabled")
	public void admin_see_the_should_be_disabled(String batchOrProgram) {

		if (batchOrProgram.equalsIgnoreCase("Batch")) {
			Assert.assertTrue(batchDetailsPage.isDisabledName());
		} else if (batchOrProgram.equalsIgnoreCase("Program")) {
			Assert.assertTrue(batchDetailsPage.isDisabledProgramName());
		}

	}

	@When("Admin select different status field	option and click save")
	public void admin_select_different_status_field_option_and_click_save() {
		if (batchDetailsPage.isActiveEnable()) {
			batchDetailsPage.selectInActive();
		} else if (batchDetailsPage.isInActiveEnable()) {
			batchDetailsPage.selectActive();

		}

		batchDetailsPage.saveBatchDetailsWindow();
LoggerLoad.info("testing status field");
	}

	@Given("Admin clicks on {string} icon")
	public void admin_clicks_on_icon(String string) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		batchDetailsPage = manageBatchPage.clickEditIcon();
		System.out.println("clicked edit");
		LoggerLoad.info("clicked edit");
	}

	@Then("Admin should see a new pop up with {string} appears")
	public void admin_should_see_a_new_pop_up_with_appears(String expectedBatchDetailsHeader) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			
		}
		softAssert.assertEquals(batchDetailsPage.getBatchDetailsWindow(), expectedBatchDetailsHeader);
		softAssert.assertTrue(batchDetailsPage.isBatchNameBoxExists());
		softAssert.assertTrue(batchDetailsPage.isBatchDescriptionBoxExists());
		softAssert.assertTrue(batchDetailsPage.isProgramNameBoxExists());
		softAssert.assertTrue(batchDetailsPage.isActiveBoxExists());
		softAssert.assertTrue(batchDetailsPage.isInActiveBoxExists());
		softAssert.assertTrue(batchDetailsPage.isNumberOfClassesBoxExists());
		softAssert.assertTrue(batchDetailsPage.isSaveButtonPresent());
		softAssert.assertTrue(batchDetailsPage.isCancelButtonPresent());
		softAssert.assertTrue(batchDetailsPage.isCloseButtonPresent());
		batchDetailsPage.closeBatchDetailsWindow();

		LoggerLoad.info("validating batch details");
		// softAssert.assertAll();
	}

	@When("Admin should update the Batch fields with valid values descriptions as {string} number of clasess as {string} and click save")
	public void admin_should_update_the_batch_fields_with_valid_values_descriptions_as_number_of_clasess_as_and_click_save(
			String description, String num) {
		manageBatchPage.searchBatch(edit_batch);
		batchDetailsPage = manageBatchPage.clickEditIcon();
		batchDetailsPage.enterBatchDescription(description);
		batchDetailsPage.enterNumberofClasses(num);
		batchDetailsPage.saveBatchDetailsWindow();

	}

	@When("Admin should update the fields with valid values and click save")
	public void admin_should_update_the_fields_with_valid_values_and_click_save() {

	}

	@When("Admin should update the {string} fields with values descriptions as {string}  and click save")
	public void admin_should_update_the_fields_with_values_descriptions_as_and_click_save(String batch,
			String description) {

		manageBatchPage.searchBatch(batch);
		batchDetailsPage = manageBatchPage.clickEditIcon();
		batchDetailsPage.enterBatchDescription(description);
		batchDetailsPage.saveBatchDetailsWindow();
		LoggerLoad.info("validating descripting field");

	}

	@Then("Admin should be able to see an error message")
	public void admin_should_be_able_to_see_an_error_message() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			
		}
		batchDetailsPage.getErrorText();
		LoggerLoad.info("validating error message");
		// batchDetailsPage.closeBatchDetailsWindow();
	}

	@Then("Admin should see the updated batch details should appear on the data table")
	public void admin_should_see_the_updated_batch_details_should_appear_on_the_data_table() {
		HashMap<String, String> map = manageBatchPage.isAddedOrEditedbatchRecordVisible(edit_batch);
		System.out.println(Arrays.asList(map));
		batchDetailsPage.getBatchUpdateMessage();
		LoggerLoad.info("validating error message");


	}

	@When("Admin should update the BatchName fields with valid values descriptions as {string} number of clasess as {string} and click save")
	public void admin_should_update_the_batch_name_fields_with_valid_values_descriptions_as_number_of_clasess_as_and_click_save(
			String description, String num) {
		manageBatchPage.searchBatch(edit_batch);
		batchDetailsPage = manageBatchPage.clickEditIcon();
		batchDetailsPage.enterBatchDescription(description);
		batchDetailsPage.enterNumberofClasses(num);
		batchDetailsPage.saveBatchDetailsWindow();
		LoggerLoad.info("editing batch with description and number of classes");

	}

	@When("Admin should update the BatchName fields with values descriptions as {string}  and click save")
	public void admin_should_update_the_batch_name_fields_with_values_descriptions_as_and_click_save(
			String description) {

		manageBatchPage.searchBatch(edit_batch);
		batchDetailsPage = manageBatchPage.clickEditIcon();
		batchDetailsPage.enterBatchDescription(description);
		addBatch_Description = description;
		batchDetailsPage.saveBatchDetailsWindow();

	}

	@When("Admin should update the BatchName fields with values number of classes as {string}  and click save")
	public void admin_should_update_the_batch_name_fields_with_values_number_of_classes_as_and_click_save(
			String numOfClasses) {
		manageBatchPage.searchBatch(edit_batch);
		batchDetailsPage = manageBatchPage.clickEditIcon();
		batchDetailsPage.enterNumberofClasses(numOfClasses);
		batchDetailsPage.saveBatchDetailsWindow();

	}

	@Then("Admin should see the description field is optional in update.")
	public void admin_should_see_the_description_field_is_optional_in_update() {
		batchDetailsPage.getErrorText();
		batchDetailsPage.closeBatchDetailsWindow();
		LoggerLoad.info("checking description is optional");
		// HashMap<String, String> map =
		// manageBatchPage.isAddedOrEditedbatchRecordVisible(edit_batch);
		// softAssert.assertEquals(map.get("ProgramDescription"), addBatch_Description);

	}

	
	@Given("Admin should see the delete icon on row level in data table is enabled")
	public void admin_should_see_the_delete_icon_on_row_level_in_data_table_is_enabled() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(manageBatchPage.validateDeleteIconExist());
		System.out.println("validated delete");

	}

	@Then("Admin sees Alert appears with yes and No option")
	public void admin_sees_alert_appears_with_yes_and_no_option() {
//		Alert alert = driver.switchTo().alert();
//		Assert.assertTrue(alert.getText().contains("Yes"));
//		Assert.assertTrue(alert.getText().contains("No"));
//        alert.dismiss();

		// manageBatchPage.getAlertText();

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			
		}

		LoggerLoad.info(manageBatchPage.getDialogText());

		deleteBatchPage.getYesLabel();
		deleteBatchPage.getNoLabel();
		softAssert.assertEquals(deleteBatchPage.getYesLabel(), "Yes", "yes is present");
		softAssert.assertEquals(deleteBatchPage.getNoLabel(), "No", "No is present");

		// Assert.assertTrue(deleteBatchPage.getDialogText().contains(arr[0]));

	}

	@When("Admin click yes option")
	public void admin_click_yes_option() {

       try {
		Thread.sleep(1000);
	} catch (Exception e) {
		
	}

		manageBatchPage = deleteBatchPage.clickYesBtn();
		//System.out.println("Clicked yes");
		LoggerLoad.info("Clicked yes");

	}

	@Given("Admin selects None of the checkboxes in data table are selected")
	public void admin_selects_none_of_the_checkboxes_in_data_table_are_selected() {
		
		multipleDel_singleBatch = manageBatchPage.selectCheckboxFromARow(-1);

	}

	@Then("Batch deleted alert pops and batch is no more available in data table")
	public void batch_deleted_alert_pops_and_batch_is_no_more_available_in_data_table() throws InterruptedException {
		
		Thread.sleep(1000);
			
		System.out.println(manageBatchPage.getDialogText());

		manageBatchPage.enterTextInSearchBox(edit_batch);

			Thread.sleep(1000);
		
		softAssert.assertEquals(manageBatchPage.getPaginationText(), AppConstants.NO_SEARCH_RESULT_FOUND_TEXT);
	}
	
	@When("Admin click No option")
	public void admin_click_no_option() {

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		manageBatchPage = deleteBatchPage.clickNoBtn();

	}

	@Then("Admin can see Batch is still listed in data table")
	public void admin_can_see_batch_is_still_listed_in_data_table() {

		manageBatchPage.enterTextInSearchBox(edit_batch);
		softAssert.assertEquals(manageBatchPage.getPaginationText(), AppConstants.SEARCH_RESULT_FOUND_TEXT);
		softAssert.assertAll();

	}

	// multi delete
	@Given("Admin selects One of the checkbox row")
	public void admin_selects_one_of_the_checkbox_row() {

		softAssert.assertFalse(manageBatchPage.isMultipleDeleteBtnEnabled());
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			
		}
		int totalCheckBox = manageBatchPage.getCheckboxCount();
		System.out.println("Number of CheckBoxes in current Manage Batch Page = " + totalCheckBox);
		LoggerLoad.info(" number of classes in the manage batch page");

		int randomRowNumber = DynamicDataGenerator.generateRandomNumber(totalCheckBox);
		multipleDel_singleBatch = manageBatchPage.selectCheckboxFromARow(randomRowNumber);
		System.out.println(multipleDel_singleBatch);

	}

	@Then("Admin see the delete icon under the Manage Batch header should be disabled")
	public void admin_see_the_delete_icon_under_the_manage_batch_header_should_be_disabled() {

		Assert.assertFalse(manageBatchPage.isMultipleDeleteBtnEnabled());

	}

	@When("Admin Click delete icon below Manage Batch header")
	public void admin_click_delete_icon_below_manage_batch_header() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			
		}
		deleteBatchPage = manageBatchPage.clickMultipleDeleteBtn();
		deleteBatchPage.clickYesBtn();
		System.out.println(manageBatchPage.getDialogText());
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			
		}

	}

	@Then("Admin see that the respective row in the data table is deleted")
	public void admin_see_that_the_respective_row_in_the_data_table_is_deleted() {

		manageBatchPage.enterTextInSearchBox(multipleDel_singleBatch);


		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		softAssert.assertEquals(manageBatchPage.getPaginationText(), AppConstants.NO_SEARCH_RESULT_FOUND_TEXT);
		softAssert.assertAll();

	}

	@Given("Admin selects Two or more checkboxes\\/row is selected")
	public void admin_selects_two_or_more_checkboxes_row_is_selected() {

		multipleDel_multipleBat = new ArrayList<String>();

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			
		}
		if (manageBatchPage.getCheckboxCount() > 1) {
			multipleDel_multipleBat.add(manageBatchPage.selectCheckboxFromARow(1));
			multipleDel_multipleBat.add(manageBatchPage.selectCheckboxFromARow(2));
		} else {
			System.out.println("Manage Batch has only 1 record. Cannot execute current step");
			LoggerLoad.info("Manage Batch has only 1 record. Cannot execute current step");
		}

	}

	@Then("Admin see the respective row in the data table is deleted")
	public void admin_see_the_respective_row_in_the_data_table_is_deleted() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			
		}
		for (String deletedProgram : multipleDel_multipleBat) {
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				
			}
			manageBatchPage.enterTextInSearchBox(deletedProgram);

			softAssert.assertEquals(manageBatchPage.getPaginationText(), AppConstants.NO_SEARCH_RESULT_FOUND_TEXT);
		}
		LoggerLoad.info("checking multi delete");
		 softAssert.assertAll();

	}
	

}
