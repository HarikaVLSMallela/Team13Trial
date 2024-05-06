package numpyninja.qa.lms.stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import numpyninja.qa.lms.driver.DriverFactory;
import numpyninja.qa.lms.pages.ManageBatchPage;
import numpyninja.qa.lms.utils.LoggerLoad;

public class Batch_PageValidation_SD {

	
	WebDriver driver;
	ManageBatchPage manageBatchPage;
	SoftAssert softAssert;
	
	public Batch_PageValidation_SD() {
		driver = DriverFactory.getDriver();
		manageBatchPage = new ManageBatchPage(driver);
		softAssert = new SoftAssert();
	}
	@Then("Admin should be able to see the {string} in the header")
	public void admin_should_be_able_to_see_the_in_the_header(String Header) {
		
		manageBatchPage.HeaderValidation(Header);
		LoggerLoad.info("Admin is able to see Manage Batch Page in the header");

	}
	@Then("Admin should see the pagination controls under the data table")
	public void admin_should_see_the_pagination_controls_under_the_data_table() {
	    
			Assert.assertTrue(manageBatchPage.PaginationValidation());
			LoggerLoad.info("Admin is able to see pagination controls under the data table on Manage Batch Page");
	}

	@Then("Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, Edit, Delete")
	public void admin_should_see_the_data_table_with_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {
		
			softAssert.assertTrue(manageBatchPage.isBatchNameDisplayed());
			softAssert.assertTrue(manageBatchPage.isBatchDescriptionDisplayed());
			softAssert.assertTrue(manageBatchPage.isBatchStatusDisplayed());
			softAssert.assertTrue(manageBatchPage.isNoOfClassesDisplayed());
			softAssert.assertTrue(manageBatchPage.isProgramNameDisplayed());
			softAssert.assertTrue(manageBatchPage.isEditDeleteDisplayed());
			softAssert.assertAll();
			LoggerLoad.info("Admin is able to see the Batch data table with headers on Manage Batch Page");
	}

	@Then("Admin should be able to see the {string} icon button that is disabled")
	public void admin_should_be_able_to_see_the_icon_button_that_is_disabled(String string) {
	    
			Assert.assertFalse(manageBatchPage.DeletetopIconValidation());
			LoggerLoad.info("Admin is able to see the Delete icon button that is disabled on Manage Batch Page");
	}

	@Then("Admin should be able to see the {string} button")
	public void admin_should_be_able_to_see_the_button(String string) {
	    
			Assert.assertTrue(manageBatchPage.NewBatchButton());
			LoggerLoad.info("Admin is able to see New Batch Button on Manage Batch Page");
	}

	@Then("Admin should be able to see Each row in the data table should have a checkbox")
	public void admin_should_be_able_to_see_each_row_in_the_data_table_should_have_a_checkbox() {
	    
			Assert.assertTrue(manageBatchPage.checkboxValidation());
			LoggerLoad.info("Admin is able to see the checkbox on Manage Batch Page for each row");
	}

	@Then("Admin should be able to see Each row in the data table should have a edit icon that is enabled")
	public void admin_should_be_able_to_see_each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() {
	    
			Assert.assertTrue(manageBatchPage.editIconValidation());
			LoggerLoad.info("Admin is able to see the Edit icon on Manage Batch Page");
	}

	@Then("Admin should be able to see Each row in the data table should have a delete icon that is enabled")
	public void admin_should_be_able_to_see_each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() {
	    
			Assert.assertTrue(manageBatchPage.sidedeleteIconValidation());
			LoggerLoad.info("Admin is able to see delete icon that is enabled for each row on on Manage Batch Page");
	}

	@When("Admin clicks {string} button")
	public void admin_clicks_button(String string) {
	    
			manageBatchPage.clickNewBatchButton();
			LoggerLoad.info("Admin is able to click on New Batch Button on Manage Batch Page");
	}

	@Then("Admin should be able to see a new pop up with Batch details")
	public void admin_should_be_able_to_see_a_new_pop_up_with_batch_details() {
	    
			Assert.assertTrue(manageBatchPage.BatchDetailspopup());
			LoggerLoad.info("Admin is able to see new popup with Batch Details window with respective fields");
	}
	
	
}
