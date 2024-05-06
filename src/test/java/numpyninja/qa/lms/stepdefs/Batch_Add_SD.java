package numpyninja.qa.lms.stepdefs;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import numpyninja.qa.lms.driver.DriverFactory;
import numpyninja.qa.lms.pages.ManageBatchPage;
import numpyninja.qa.lms.utils.ElementUtil;
import numpyninja.qa.lms.utils.LoggerLoad;
import numpyninja.qa.lms.pages.BatchDetailsPage;

public class Batch_Add_SD {

	
	WebDriver driver;
	ManageBatchPage manageBatchPage;
	BatchDetailsPage batchDetailsPage;
	SoftAssert softAssert;
	ElementUtil util;
	
	public Batch_Add_SD() {
		driver = DriverFactory.getDriver();
		manageBatchPage = new ManageBatchPage(driver);
		batchDetailsPage = new BatchDetailsPage(driver);
		softAssert = new SoftAssert();
	}
	
	public Batch_Add_SD(WebDriver driver) {
		this.driver = driver;
		this.util = new ElementUtil(driver);
	}
//@AddBatch01	
	@Then("The pop up should include the field- Name as text box")
	public void the_pop_up_should_include_the_field_name_as_text_box() {
	    
		Assert.assertTrue(batchDetailsPage.BatchnameTextbox());
		LoggerLoad.info("Batch Name field is type of text and text box");
	}

//@AddBatch02
	@Then("The pop up should include the field- Number of classes as text box")
	public void the_pop_up_should_include_the_field_number_of_classes_as_text_box() {
	    
		Assert.assertTrue(batchDetailsPage.NoOfClassesTextbox());
		LoggerLoad.info("Batch Number of classes field is type of number and text box");	    
	}

//@AddBatch03
	@Then("The pop up should include the field- Description as text box")
	public void the_pop_up_should_include_the_field_description_as_text_box() {
	    
		Assert.assertTrue(batchDetailsPage.DescriptionTextbox());
		LoggerLoad.info("Batch Description field is type of text and text box");	    
	}


//@AddBatch04
	@Then("The pop up should include the field- Program Name as drop down")
	public void the_pop_up_should_include_the_field_program_name_as_drop_down() {
		   
		Assert.assertTrue(batchDetailsPage.programNameDropdown());   
		LoggerLoad.info("Batch Program Name is type of drop down");	    
	}

//@AddBatch05
	@Then("The pop up should include the field- Status as radio button")
	public void the_pop_up_should_include_the_field_status_as_radio_button() {
	   
		Assert.assertTrue(batchDetailsPage.StatusRadiobutton());   
		LoggerLoad.info("Batch Status field is type of Radio Button");
	}

//@AddBatch06	
	@When("Admin should be able to fill values {string}, {string}, ProgramName, status except Description and click save")
	public void admin_should_be_able_to_fill_values_program_name_status_except_description_and_click_save(String BatchName, String NumberOfClasses) throws InterruptedException {
	      
		batchDetailsPage.BatchBlankDescription(BatchName, NumberOfClasses);
		LoggerLoad.info("Admin Enters data in all fields except Description as optional");	    
	}

	@Then("Admin should be able to see the newly added {string} in the data table in Manage Batch page")
	public void admin_should_be_able_to_see_the_newly_added_batch_in_the_data_table_in_manage_batch_page(String Batch) throws InterruptedException {
		
		softAssert.assertEquals(batchDetailsPage.ErrorMsgDesc(), "Batch Description is required.");
		Thread.sleep(2000);
		batchDetailsPage.cancelBatchWindow();
		Assert.assertEquals(batchDetailsPage.CheckifNewBatchAdded(Batch), true);
		LoggerLoad.info("Admin gets an Error as Batch Description is required and Not able to find the Batch in data table");	
	}

//@AddBatch07
	@When("Admin should be able to fill valid {string},{string},{string}, status and click save")
	public void admin_should_be_able_to_fill_valid_status_and_click_save(String BatchName, String Description, String NumberOfClasses) throws InterruptedException {
  
		batchDetailsPage.BatchDetails(BatchName, Description, NumberOfClasses);
		LoggerLoad.info("Admin Enters valid data in all fields and clicks on save to create a Batch");	
	}

	@Then("Admin should be able to see the newly added {string} in the data table with successful message in Manage Batch page")
	public void admin_should_be_able_to_see_the_newly_added_batch_in_the_data_table_with_successful_message_in_manage_batch_page(String Batch) throws InterruptedException {

		String ExpectedMsg1 = "Successful";
		String ExpectedMsg2 = "Batch Created Successfully";
		String ExpectedMessage = ExpectedMsg1+" "+ExpectedMsg2;
		softAssert.assertEquals(batchDetailsPage.getSuccessMessageText(),ExpectedMessage);
		softAssert.assertTrue(batchDetailsPage.CheckifNewBatchAdded(Batch));
		LoggerLoad.info("Admin sees the newly added Batch in Manage Batch page data table");
	}

//@AddBatch08
	@When("Admin enters Invalid Values for {string},{string},{string} clicks save")
	public void admin_enters_invalid_values_for_and_clicks_save(String BatchName, String Description, String NumberofClass) throws InterruptedException {
	 	    
		batchDetailsPage.BatchDetails(BatchName, Description, NumberofClass);
		LoggerLoad.info("Admin Enters valid data in all fields and clicks on save to create a Batch");	
	}

	@Then("Admin gets a Error message for the invalid data fields Name and Description")
	public void admin_gets_a_error_message_for_the_invalid_data_field() throws InterruptedException {

		String ExpectedErrMsg1 = "This field should start with an alphabet and min 2 character.";
		String ExpectedErrMsg2 = "Number of classes is required.";
		
		String ExpectedMsg1 = "Failed";
		String ExpectedMsg2 = "batchName must begin with alphabet and can contain only alphanumeric characters";
		String ExpectedMsgName = ExpectedMsg1+" "+ExpectedMsg2;
		
		try
		{
		if(batchDetailsPage.ErrorMsgNameDesc().contains(ExpectedErrMsg1)) {
			Assert.assertTrue(batchDetailsPage.ErrorMsgNameDesc().contains(ExpectedErrMsg1));			
		}
		else if(batchDetailsPage.ErrorMsgClass().contains(ExpectedErrMsg2))  {
			Assert.assertTrue(batchDetailsPage.ErrorMsgClass().contains(ExpectedErrMsg2));
		}
		else
			Assert.assertEquals(batchDetailsPage.getErrMsgFailedName(),ExpectedMsgName);
		}
		catch (StaleElementReferenceException e) {}
		LoggerLoad.info("Admin Enters invalid data and captures Error Messages for respective field");		
	}

//@AddBatch09
	@When("Fill {string}, {string}, Status, ProgName fields with valid values except Name as blank and click save")
	public void fill_status_prog_name_fields_with_valid_values_except_name_as_blank_and_click_save(String Desc, String NumClass) throws InterruptedException {
	    
		batchDetailsPage.BatchBlankName(Desc,NumClass);
		LoggerLoad.info("Admin Enters valid data in all fields except leaving Name field Blank");	
	}

	@Then("Admin gets an Error message for the Name field")
	public void admin_gets_an_error_message_for_the_name_field() {
		
		String ExpectedErrMsg = "Batch Name is required.";
		Assert.assertEquals(batchDetailsPage.ErrorMsgName(),ExpectedErrMsg);   
		LoggerLoad.info("Batch is not created as Name field is required but left blank");	    
	}

//@AddBatch10
	@When("Fill {string}, {string}, Status, ProgName fields with valid values except Description as blank and click save")
	public void fill_status_prog_name_fields_with_valid_values_except_description_as_blank_and_click_save(String Name, String NumClass) throws InterruptedException {

		batchDetailsPage.BatchBlankDescription(Name,NumClass);
		LoggerLoad.info("Admin Enters valid data in all fields except leaving Description field Blank");	
	}

	@Then("Admin gets an Error message for the Description field")
	public void admin_gets_an_error_message_for_the_description_field() {
	    
		String ExpectedErrMsg = "Batch Description is required.";
		Assert.assertEquals(batchDetailsPage.ErrorMsgDesc(),ExpectedErrMsg);   
		LoggerLoad.info("Batch is not created as Description field is required but left blank");
	}

//@AddBatch11
	@When("Fill {string},{string},{string}, Status fields with valid values except Program name as blank and click save")
	public void fill_status_fields_with_valid_values_except_program_name_as_blank_and_click_save(String Name, String Desc, String NumClass) throws InterruptedException {

		batchDetailsPage.BatchBlankProgName(Name,Desc,NumClass);
		LoggerLoad.info("Admin Enters valid data in all fields except leaving Program Name field Blank");		    
	}

	@Then("Admin gets an Error message for the Program name field")
	public void admin_gets_an_error_message_for_the_program_name_field() {
	    
		String ExpectedErrMsg = "Program Name is required.";
		Assert.assertEquals(batchDetailsPage.ErrorMsgProg(),ExpectedErrMsg);   
		LoggerLoad.info("Batch is not created as Program Name field is required but left blank");
	}

//@AddBatch12
	@When("Fill {string},{string},{string}, Program Name fields with valid values except Status as blank and click save")
	public void fill_program_name_fields_with_valid_values_except_status_as_blank_and_click_save(String Name, String Desc, String NumClass) throws InterruptedException {

		batchDetailsPage.BatchBlankStatus(Name,Desc,NumClass);
		LoggerLoad.info("Admin Enters valid data in all fields except leaving Status field Blank");		    
	}

	@Then("Admin gets an Error message for the Status field")
	public void admin_gets_an_error_message_for_the_status_field() {
	    
		String ExpectedErrMsg = "Status is required.";
		Assert.assertEquals(batchDetailsPage.ErrorMsgStatus(),ExpectedErrMsg);   
		LoggerLoad.info("Batch is not created as Status field is required but left blank");
	}

//@AddBatch13
	@When("Fill {string},{string}, Program Name fields with valid values except Number of Classes as blank and click save")
	public void fill_program_name_fields_with_valid_values_except_number_of_classes_as_blank_and_click_save(String Name, String Desc) throws InterruptedException {

		batchDetailsPage.BatchBlankNoofClass(Name,Desc);
		LoggerLoad.info("Admin Enters valid data in all fields except leaving Name field Blank");		    
	}

	@Then("Admin gets an Error message for the Number of Classes field")
	public void admin_gets_an_error_message_for_the_number_of_classes_field() {
	    
		String ExpectedErrMsg = "Number of classes is required.";
		Assert.assertEquals(batchDetailsPage.ErrorMsgClass(),ExpectedErrMsg);   
		LoggerLoad.info("Batch is not created as Number of classes field is required but left blank");
	}
	
//Additional Scenarios
	
	@When("Admin Enters and clears data in {string} field and clicks on save")
	public void admin_enters_and_clears_data_in_name_field_and_clicks_on_save(String Name) throws InterruptedException {

		batchDetailsPage.EnterClearBatchName(Name);
	}

	@Then("Admin should be able to see an error message for {string} field")
	public void admin_should_be_able_to_see_an_error_message_as(String Name) {
		
		String ExpectedErrMsg = "This field should start with an alphabet and min 2 character.";
		Assert.assertTrue(batchDetailsPage.ErrorMsgNameDesc().contains(ExpectedErrMsg));	
	}

	@When("Admin Enters and clears data in {string} and clicks on save")
	public void admin_enters_and_clears_data_in_description_field_and_clicks_on_save(String Description) throws InterruptedException {
		
		batchDetailsPage.EnterClearBatchDesc(Description);
	}
}
