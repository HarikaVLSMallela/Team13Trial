package numpyninja.qa.lms.stepdefs;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import numpyninja.qa.lms.constants.AppConstants;
import numpyninja.qa.lms.driver.DriverFactory;
import numpyninja.qa.lms.pages.ManageProgramPage;
import numpyninja.qa.lms.pages.ProgramDetailsPage;
import numpyninja.qa.lms.pojo.Program;
import numpyninja.qa.lms.utils.ExcelReaderAndWriter;
import numpyninja.qa.lms.utils.LoggerLoad;
import numpyninja.qa.lms.utils.RunTimeDataReader;
import numpyninja.qa.lms.utils.DynamicDataGenerator;

public class Program_AddTest {

	WebDriver driver;
	SoftAssert softAssert;
	RunTimeDataReader runTimeData;
	Program prog;

	ProgramDetailsPage programDetailsPage;
	ManageProgramPage manageProgramPage;

	
	String addPrg_Name;
	String addPrg_Description;
	String addPrg_Status;
	String editedPrg_Name;
	String editedPrg_Desc;
	List<Map<String, String>> testdata;

	String invalidData_progName;
    String invalidData_progDesc;
    String invalidData_status;
    String invalidData_expectedErrMsg;
	
	public Program_AddTest() {
		driver = DriverFactory.getDriver();
		softAssert = new SoftAssert();
		manageProgramPage = new ManageProgramPage(driver);
		programDetailsPage = new ProgramDetailsPage(driver);
		runTimeData = new RunTimeDataReader();
		prog = new Program();
	}
	
	@When("Admin clicks A New Program button")
	public void admin_clicks_a_new_program_button() {
		programDetailsPage = manageProgramPage.clickNewProgramButton();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LoggerLoad.info("Admin can click A New Program button");
	}
	
	@Given("Admin is on the Manage Program Page")
	public void admin_is_on_the_manage_program_page() {
		
		Assert.assertTrue(manageProgramPage.doesHeaderExist()); 
		LoggerLoad.info("Admin is able to go on the Manage Program Page");
	    
	}
	

	//****************** Program Details Popup Validation Step Def ************************************
	
	@Then("Admin should see a popup open for {string} with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window(
			String expectedProgramDetailsHeader) {

		softAssert.assertEquals(programDetailsPage.getHeaderText(), expectedProgramDetailsHeader);
		softAssert.assertTrue(programDetailsPage.isNameFieldEmpty());
		softAssert.assertTrue(programDetailsPage.isDescriptionFieldEmpty());
		// softAssert.assertTrue(programDetailsPage.areRadioButtonsUnselected());
		softAssert.assertTrue(programDetailsPage.isSaveButtonPresent());
		softAssert.assertTrue(programDetailsPage.isCancelButtonPresent());
		softAssert.assertTrue(programDetailsPage.isCloseButtonPresent());

		softAssert.assertAll();
		LoggerLoad.info("Admin is able to see a popup open for Program Details with empty form along with <SAVE> and <CANCEL> button and Close\\\\(X) Icon on the top right corner of the window");
	}
	
	@Then("Admin should see two radio button for Program Status")
	public void admin_should_see_two_radio_button_for_program_status() {
		
		softAssert.assertTrue(programDetailsPage.isActiveRadioButtonDisplayed());
		softAssert.assertTrue(programDetailsPage.isInActiveRadioButtonDisplayed());
		softAssert.assertAll();
		LoggerLoad.info("Admin is able to see two radio button for Program Status");
		
	}
	
	
	@Then("Admin should see two input fields and their respective text boxes in the program details window")
	public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window() {

		softAssert.assertTrue(programDetailsPage.isTextLabelNameExist());
		softAssert.assertTrue(programDetailsPage.isTextLabelDescriptionExist());
		softAssert.assertTrue(programDetailsPage.isNameFieldExist());
		softAssert.assertTrue(programDetailsPage.isDescriptionFieldExists());
		softAssert.assertAll();
		LoggerLoad.info("Admin is able to see two input fields and their respective text boxes in the program details window");
		
	}
	
	//****************** Add A Program Save/Cancel/Close Step Def **************
	
	@Given("Admin is on {string} Popup window")
	public void admin_is_on_popup_window(String pageName) {
		Assert.assertEquals(programDetailsPage.getHeaderText(), pageName);
		LoggerLoad.info("Admin is on Program Detail Popup window");
	}

	
	@Given("Enter all the required fields with valid values and click {string} button")
	public void enter_all_the_required_fields_with_valid_values_and_click_button(String buttonOption) {

		addPrg_Name = "SDEETT"+DynamicDataGenerator.randomTwoDigitGenerator(); 
		addPrg_Description="Automation"; 
		addPrg_Status = "Active";
		System.out.println("Program Name is = "+addPrg_Name);
		
		prog = new Program(addPrg_Name, addPrg_Description, addPrg_Status );
		
		if(buttonOption.trim().equalsIgnoreCase("Save")) {
			//manageProgramPage = programDetailsPage.fillUpProgramDetailsForm(addPrg_Name, addPrg_Description, addPrg_Status, "Save");

			manageProgramPage = programDetailsPage.fillUpProgramDetailsForm(prog.getProgramName(), prog.getProgramDescription(), prog.getProgramStatus(), "Save");

		}
		else if(buttonOption.trim().equalsIgnoreCase("Cancel")) {
			manageProgramPage = programDetailsPage.fillUpProgramDetailsForm(prog.getProgramName(), prog.getProgramDescription(), prog.getProgramStatus(), "Cancel");
		}
		else if(buttonOption.trim().equalsIgnoreCase("Close")) {
			manageProgramPage = programDetailsPage.fillUpProgramDetailsForm(prog.getProgramName(), prog.getProgramDescription(), prog.getProgramStatus(), "Close");
		}
		
		runTimeData.setProgram(prog);
		System.out.println("Program Created --> " + runTimeData.getProgram());
		LoggerLoad.info("Enter all the required fields with valid values and click cancel button");

	}

	@When("Admin gets a message {string} alert and able to see the new program added in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_the_new_program_added_in_the_data_table(String expectedSuccessMsg) throws InterruptedException {
		
		softAssert.assertEquals(manageProgramPage.getFlyingMsgText(), expectedSuccessMsg);
		manageProgramPage.enterTextInSearchBox(prog.getProgramName());
		Thread.sleep(1000);	
		
		if(manageProgramPage.getPaginationText().equalsIgnoreCase(AppConstants.SEARCH_RESULT_FOUND_TEXT)) {
			
			System.out.println(prog.getProgramName() + " has been found in search result");
			
			HashMap<String, String> map = manageProgramPage.isAddedOrEditedProgramRecordVisible(prog.getProgramName());

			System.out.println(Arrays.asList(map));

			softAssert.assertEquals(map.get("ProgramName"), prog.getProgramName());
			softAssert.assertEquals(map.get("ProgramDescription"), prog.getProgramDescription());
			softAssert.assertEquals(map.get("ProgramStatus"), prog.getProgramStatus());
	
			softAssert.assertAll();	
			LoggerLoad.info("");
			}
	}
	

	@When("Admin can see the Program details popup disappears without creating any program")
	public void admin_can_see_the_program_details_popup_disappears_without_creating_any_program() throws InterruptedException {

		manageProgramPage.enterTextInSearchBox(addPrg_Name);
		Thread.sleep(2000);	
		Assert.assertEquals(manageProgramPage.getPaginationText(), AppConstants.NO_SEARCH_RESULT_FOUND_TEXT);
		LoggerLoad.info("Admin is able to see the Program details popup disappears without creating any program");
	}
	
	//******************** Empty form Submission *********************

	@When("Admin clicks <Save> button without entering any data on Program Details Page")
	public void admin_clicks_save_button_without_entering_any_data_on_program_details_page() {

	programDetailsPage.fillUpProgramDetailsForm("", "", "", "Save");
	LoggerLoad.info("Admin is able to click <Save> button without entering any data on Program Details Page");


	}
	@Then("Admin gets error messages on Program Details Page")
	public void admin_gets_error_messages_on_program_details_page() {
		
		
		  HashMap<String, String> allErrMsgs= programDetailsPage.getErrorMsgs();
		  
		  softAssert.assertEquals(allErrMsgs.get("nameError"),
		  AppConstants.NAME_REQUIRED_ERR_PROGDETAILSPAGE);
		  
		  softAssert.assertEquals(allErrMsgs.get("descriptionError"),
		  AppConstants.DESCRIPTION_REQUIRED_ERR_PROGDETAILSPAGE);
		  
		  softAssert.assertEquals(allErrMsgs.get("statusError"),
		  AppConstants.STATUS_REQUIRED_ERR_PROGDETAILSPAGE);
		  
		  softAssert.assertAll();
		  LoggerLoad.info("Admin is getting an error messages on Program Details Page");
		 
	}
	
	@When("Admin enters only <Program Name> in text box and clicks Save button on Program Details Page")
	public void admin_enters_only_program_name_in_text_box_and_clicks_save_button_on_program_details_page() {

		programDetailsPage.fillUpProgramDetailsForm("SDET126", "", "", "Save");
		LoggerLoad.info("Admin can enters only <Program Name> in text box and clicks Save button on Program Details Page");
	}
	
	@When("Admin enters only {string} in text box and clicks Save button on Program Details Page")
	public void admin_enters_only_in_text_box_and_clicks_save_button_on_program_details_page(String editField) {
	    
		if(editField.trim().equalsIgnoreCase("Program Name")) {
			programDetailsPage.fillUpProgramDetailsForm("SDET126", "", "", "Save");
		}
		else if(editField.trim().equalsIgnoreCase("Program description")) {
			programDetailsPage.fillUpProgramDetailsForm("", "Automation Architect", "", "Save");
		}
		LoggerLoad.info("Admin is entering only Program description in text box and clicks Save button on Program Details Page");
	}
	
	@When("Admin selects only Status and clicks Save button on Program Details Page")
	public void admin_selects_only_status_and_clicks_save_button_on_program_details_page() {

		programDetailsPage.fillUpProgramDetailsForm("", "", "Active", "Save");
		LoggerLoad.info("Admin is selecting only Status and clicks Save button on Program Details Page");

	}
	
	@Then("Admin gets a message alert {string} on Program Details Page")
	public void admin_gets_a_message_alert_on_program_details_page(String ErrMsg) {

		HashMap<String, String> allErrMsgs= programDetailsPage.getErrorMsgs();
		  
		if(ErrMsg.trim().equalsIgnoreCase("Description is required")) {

			softAssert.assertEquals(allErrMsgs.get("descriptionError"),AppConstants.DESCRIPTION_REQUIRED_ERR_PROGDETAILSPAGE);
			softAssert.assertEquals(allErrMsgs.get("statusError"),AppConstants.STATUS_REQUIRED_ERR_PROGDETAILSPAGE);
		}
		else if(ErrMsg.trim().equalsIgnoreCase("Name is required")) {
			softAssert.assertEquals(allErrMsgs.get("nameError"),AppConstants.NAME_REQUIRED_ERR_PROGDETAILSPAGE);
			softAssert.assertEquals(allErrMsgs.get("statusError"),AppConstants.STATUS_REQUIRED_ERR_PROGDETAILSPAGE);

		}
		else if(ErrMsg.trim().equalsIgnoreCase("Name and Description required")) {
			softAssert.assertEquals(allErrMsgs.get("nameError"),AppConstants.NAME_REQUIRED_ERR_PROGDETAILSPAGE);
			softAssert.assertEquals(allErrMsgs.get("descriptionError"),AppConstants.DESCRIPTION_REQUIRED_ERR_PROGDETAILSPAGE);

		}
		  softAssert.assertAll();
		  LoggerLoad.info("Admin is  getting a message alert Name and Description required on Program Details Page");
	}
	
	//************************ Invalid Data (excel) Step Def ***************************
	
	@When("Admin enters data from {int} of {string} in name and desc column on Program Details Page")
	public void admin_enters_data_from_of_in_name_and_desc_column_on_program_details_page(Integer rowNum, String sheet) throws IOException {


		ExcelReaderAndWriter reader = new ExcelReaderAndWriter();
        testdata = reader.getData(sheet);
        
        invalidData_progName= testdata.get(rowNum).get("programName");
        invalidData_progDesc= testdata.get(rowNum).get("programDescription");
        invalidData_status= testdata.get(rowNum).get("programStatus");
        invalidData_expectedErrMsg = testdata.get(rowNum).get("expectedErrorMsg");
        
        programDetailsPage.fillUpProgramDetailsForm(invalidData_progName, invalidData_progDesc, invalidData_status, "Save");
        LoggerLoad.info("Admin is entering data from <rowNum> of <sheet> in name and desc column on Program Details Page");
        
	}

	
	@Then("Admin gets a Error message alert on Program Details Page for invalid data")
	public void admin_gets_a_error_message_alert_on_program_details_page_for_invalid_data() {
		
		if(invalidData_expectedErrMsg.trim().contains("special char")) {
			Assert.assertEquals(programDetailsPage.invalidDataErrMsg("Name"),AppConstants.INVALID_DATA_ERR_PROGRAM_NAME);
		}
		else if(!invalidData_expectedErrMsg.trim().contains("special char")){
			System.out.println("Inside prog description err");
			Assert.assertEquals(programDetailsPage.invalidDataErrMsg("Description"),AppConstants.INVALID_DATA_ERR_PROGRAM_DESCRIPTION);

		}

		
		LoggerLoad.info("Admin is getting an Error message alert on Program Details Page for invalid data");
	}
	
	
	//********************Boundary Testing step Def ****************************
	
	
	  @When("Admin enters {string} of {string} than {int} character length") 
	  public void admin_enters_of_than_character_length(String editBoxName, String moreOrLess, Integer characterLength) { 
			if(editBoxName.trim().equalsIgnoreCase("Program Name")) {
				
				if(moreOrLess.trim().equalsIgnoreCase("more") && characterLength==26) {
					
					String progName = "Team133333333333333333333333333";
					int stringLength = progName.length();
					System.out.println("Program character length = " + stringLength);
					if (stringLength>26) {
						
						programDetailsPage.enterTextInField("Name",progName);
					}
				}
				else {
					
					String progName = "T";
					int stringLength = progName.length();
					System.out.println("Program character length = " + stringLength);
					if (stringLength<2) {
						
						programDetailsPage.enterTextInField("Name",progName);
					}
				}
			}
			else if(editBoxName.trim().equalsIgnoreCase("Program Description")) {
				
				if(moreOrLess.trim().equalsIgnoreCase("less") && characterLength==2) {
					
					String progDesc = "T";
					int stringLength = progDesc.length();
					System.out.println("Program character length = " + stringLength);
					if (stringLength<2) {
						
						programDetailsPage.enterTextInField("Description",progDesc);
					}
				}
				
			}		  

			LoggerLoad.info("Admin is entering <editBoxName> of <moreOrLess> than <StringCharacterLength> character length");  
	  }
	 
	
	
	@Then("Admin gets an err {string} for invalid data on Program Details Page")
	public void admin_gets_an_err_for_invalid_data_on_program_details_page(String errMsg) {
		
		if(errMsg.trim().contains("special")){
			Assert.assertEquals(programDetailsPage.invalidDataErrMsg("Name"), errMsg);
		}
		else {
			Assert.assertEquals(programDetailsPage.invalidDataErrMsg("Description"), errMsg);

		}

		LoggerLoad.info("Admin is able to get an err expectedErrMsg> for invalid data on Program Details Page");
	}
	
	
}
