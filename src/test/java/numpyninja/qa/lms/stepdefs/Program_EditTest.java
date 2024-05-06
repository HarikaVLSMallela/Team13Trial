package numpyninja.qa.lms.stepdefs;

import static org.testng.Assert.assertEquals;

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
import numpyninja.qa.lms.pages.DeleteProgramPage;
import numpyninja.qa.lms.pages.ManageProgramPage;
import numpyninja.qa.lms.pages.ProgramDetailsPage;
import numpyninja.qa.lms.pojo.Program;
import numpyninja.qa.lms.utils.DynamicDataGenerator;
import numpyninja.qa.lms.utils.LoggerLoad;
import numpyninja.qa.lms.utils.RunTimeDataReader;

public class Program_EditTest {

	WebDriver driver;
	SoftAssert softAssert;
	RunTimeDataReader runTimeData;
	Program prog;
	
	ManageProgramPage manageProgramPage;
	ProgramDetailsPage programDetailsPage;
	DeleteProgramPage deleteProgramPage;
	
	HashMap<String, String> map;
	String prgName_search;
	String prgmDes_search;
	
	public Program_EditTest() {
		driver = DriverFactory.getDriver();
		
		manageProgramPage = new ManageProgramPage(driver);
		programDetailsPage = new ProgramDetailsPage(driver);
		deleteProgramPage = new DeleteProgramPage(driver);
		runTimeData = new RunTimeDataReader();
		softAssert = new SoftAssert();
		prog = new Program();
	}
	
	
	
	
	//********************* Search Validation/Functionality Step Def ********************
	
		@Then("Admin should see Search bar with text as {string}")
		public void admin_should_see_search_bar_with_text_as(String expectedInnerText) {
			assertEquals(manageProgramPage.getSearchBoxText(), expectedInnerText);
			LoggerLoad.info("Admin is able to see Search bar");
		}

		
		@When("Admin enters existing program name in search box on Manage Program page")
		public void admin_enters_existing_program_name_in_search_box_on_manage_program_page() throws InterruptedException {
			
			prgName_search ="";
			prog = runTimeData.getProgram();
			if(prog.getProgramName()==null) {	
				
				//write logic to randomly retrieve a program name from the table
				int rows = manageProgramPage.getTotalRows();
				int randomRowNumber = DynamicDataGenerator.generateRandomNumber(rows);
				prgName_search=manageProgramPage.getProgramNameFromARow(randomRowNumber);
							}
			else {
				prgName_search=prog.getProgramName();
			}

			manageProgramPage.enterTextInSearchBox(prgName_search);
			
			Thread.sleep(3000);
			LoggerLoad.info("Admin is able to enter existing program name in search box on Manage Program page");
			
		}
		
		
		@Then("Admin should see record")
		public void admin_should_see_record() {

			Assert.assertEquals(manageProgramPage.getPaginationText(), AppConstants.SEARCH_RESULT_FOUND_TEXT);			
			System.out.println(manageProgramPage.isAddedOrEditedProgramRecordVisible(prgName_search));
			LoggerLoad.info("Admin can see record");
		}


		@When("Admin enters existing programs description in search box on Manage Program page")
		public void admin_enters_existing_programs_description_in_search_box_on_manage_program_page() {
			
			prgmDes_search ="";
			
			if(prog.getProgramDescription()==null) {				
				//write logic to randomly retrieve description from the table
				int rows = manageProgramPage.getTotalRows();
				int randomRowNumber = DynamicDataGenerator.generateRandomNumber(rows);
				prgName_search=manageProgramPage.getProgramDescriptionFromARow(randomRowNumber);
			}
			else {
				prgmDes_search=prog.getProgramDescription();
			}
			
			manageProgramPage.enterTextInSearchBox(prgmDes_search);
			LoggerLoad.info("Admin is able to enter existing programs description in search box on Manage Program page ");
			
		}
		
		
		@Then("Admin should see matching record\\/s")
		public void admin_should_see_matching_record_s() throws InterruptedException {
			
			Thread.sleep(2000);
			
			int numberOfrecords=manageProgramPage.getTotalRows();
			System.out.println("Total records found = " + numberOfrecords);
			
			if(numberOfrecords==1) {
				Assert.assertTrue(manageProgramPage.getProgramDescriptionFromARow(numberOfrecords).contains(prgmDes_search));
			}
			else 
			{	System.out.println("Multiple programs found with program description containig " + prgmDes_search);
				for(int i=1; i<=numberOfrecords; i++) {
					softAssert.assertTrue(manageProgramPage.getProgramDescriptionFromARow(numberOfrecords).contains(prgmDes_search));
					
				}
				softAssert.assertAll();
				LoggerLoad.info("Admin is able to see matching record");
			}
		}
		
		//************** Program Edit Step Def ******************************


		@Then("Admin should see a popup open for Program details to edit")
		public void admin_should_see_a_popup_open_for_program_details_to_edit() {
			
			softAssert.assertTrue(programDetailsPage.isNameFieldEmpty());
		    softAssert.assertTrue(programDetailsPage.isDescriptionFieldEmpty());
		    softAssert.assertTrue(programDetailsPage.isCancelButtonPresent());
		    softAssert.assertTrue(programDetailsPage.isSaveButtonPresent());
		    softAssert.assertTrue(programDetailsPage.isCloseButtonPresent());
		    softAssert.assertAll();	
		    LoggerLoad.info("Admin is able to see a popup open for Program details to edit");
		   
		}
		


		@When("Admin clicks Edit button on the data table for any row")
		public void admin_clicks_edit_button_on_the_data_table_for_any_row() {
				   
			int editBtnCount = manageProgramPage.getEditOrDeleteBtnCount("edit");
			System.out.println("Number of Delete buttons in current Manage Program Page = " + editBtnCount);

			// generate a number from 1 to deleteBtnCount
			int randomRowNumber = DynamicDataGenerator.generateRandomNumber(editBtnCount);
			programDetailsPage = manageProgramPage.clickEditBtnFromARow(randomRowNumber);
			LoggerLoad.info("");
			LoggerLoad.info("Admin is able to clicks Edit button on the data table for any row");
		}
		
		
		@Given("Admin clicks Edit button of the found result")
		public void admin_clicks_edit_button_of_the_found_result() {
			
			programDetailsPage = manageProgramPage.clickOnEditBtnForProgram(prog.getProgramName());
			LoggerLoad.info("Admin is able to see Edit button of the found result");
		}
		

		@Then("Admin should see a popup for Program details to edit")
		public void admin_should_see_a_popup_for_program_details_to_edit() {
			
			softAssert.assertTrue(programDetailsPage.doesHeaderExist());
			
			softAssert.assertTrue(programDetailsPage.isNameFieldExist());
			softAssert.assertTrue(programDetailsPage.isDescriptionFieldExists());	
			softAssert.assertTrue(programDetailsPage.isActiveRadioButtonDisplayed());	
			softAssert.assertTrue(programDetailsPage.isInActiveRadioButtonDisplayed());	
			softAssert.assertTrue(programDetailsPage.isCancelButtonPresent());
			softAssert.assertTrue(programDetailsPage.isSaveButtonPresent());
			softAssert.assertTrue(programDetailsPage.isCloseButtonPresent());

			softAssert.assertAll();
			LoggerLoad.info("Admin is able to see a popup for Program details to edit");
		    
		}
		
		@Given("Admin is on Program Details Popup window to Edit")
		public void admin_is_on_program_details_popup_window_to_edit() {

			softAssert.assertTrue(programDetailsPage.doesHeaderExist());
			softAssert.assertEquals(programDetailsPage.getHeaderText(), AppConstants.PROGRAM_DETAILS_HEADER_TEXT);

			softAssert.assertTrue(programDetailsPage.isNameFieldExist());
			softAssert.assertTrue(programDetailsPage.isDescriptionFieldExists());	
			softAssert.assertTrue(programDetailsPage.isActiveRadioButtonDisplayed());	
			softAssert.assertTrue(programDetailsPage.isInActiveRadioButtonDisplayed());	
			softAssert.assertTrue(programDetailsPage.isCancelButtonPresent());
			softAssert.assertTrue(programDetailsPage.isSaveButtonPresent());
			softAssert.assertTrue(programDetailsPage.isCloseButtonPresent());

			softAssert.assertAll();
			LoggerLoad.info("Admin is able to go on Program Details Popup window to Edit");
		    	}

		@When("Admin edits the Name field and clicks save button")
		public void admin_edits_the_name_field_and_clicks_save_button() {
			
			String editedPrg_Name = "AutoArchTeam13";
			prog.setProgramName(editedPrg_Name);
			programDetailsPage.enterTextInField("name",prog.getProgramName());
			manageProgramPage = programDetailsPage.SaveProgram();
			System.out.println("Edited Program Name --> " + prog);
			LoggerLoad.info("");
		
		}
		
		@Given("Admin enters edited program name in search box on Manage Program page")
		public void admin_enters_edited_program_name_in_search_box_on_manage_program_page() throws InterruptedException {

			String editedPrg_Name = "EditedAutoArchTeam13";
			prog.setProgramName(editedPrg_Name);
			manageProgramPage.enterTextInSearchBox(prog.getProgramName());
			Thread.sleep(2000);
			
			map= manageProgramPage.isAddedOrEditedProgramRecordVisible(prog.getProgramName());
			prog.setProgramDescription(map.get("ProgramDescription"));
			prog.setProgramStatus(map.get("ProgramStatus"));
			LoggerLoad.info("Admin is able to enters edited program name in search box on Manage Program page");

		}
		
		@Given("Admin clicks Edit button of the found edited program")
		public void admin_clicks_edit_button_of_the_found_edited_program() {
			
			programDetailsPage = manageProgramPage.clickOnEditBtnForProgram(prog.getProgramName());
			LoggerLoad.info("Admin is able to clicks Edit button of the found edited program");

		}
		
		@Given("Admin edits the Description column and clicks save button")
		public void admin_edits_the_description_column_and_clicks_save_button() {
			
			String editedPrg_Desc = "Test1313 Edited";
			prog.setProgramDescription(editedPrg_Desc);
			
			programDetailsPage.enterTextInField("Description", prog.getProgramDescription());
			manageProgramPage = programDetailsPage.SaveProgram();
			
			System.out.println("Edited Program Name and Description --> " + prog);
			LoggerLoad.info("Admin is able to edits the Description column and clicks save button");


		}

		
		@When("Admin changes the Status and clicks save button")
		public void admin_changes_the_status_and_clicks_save_button() {

			String editedPrg_Status = "Inactive";
			prog.setProgramStatus(editedPrg_Status);
			
			programDetailsPage.selectActiveInactiveRadioButton(prog.getProgramStatus());
			manageProgramPage = programDetailsPage.SaveProgram();
			
			System.out.println("Edited Program Name, Description and Status--> " + prog);
			LoggerLoad.info("Admin is able to do changes for Status and clicks save button");

		}
		
		@Then("Admin gets a message {string} alert and able to see the updated status in the table for the particular program")
		public void admin_gets_a_message_alert_and_able_to_see_the_updated_status_in_the_table_for_the_particular_program(String expectedSuccessMsg) throws InterruptedException {
			
			softAssert.assertEquals(manageProgramPage.getFlyingMsgText(), expectedSuccessMsg);
			
			manageProgramPage.enterTextInSearchBox(prog.getProgramName());
			Thread.sleep(2000);
			
			map = manageProgramPage.isAddedOrEditedProgramRecordVisible(prog.getProgramName());

			System.out.println(Arrays.asList(map));
			softAssert.assertEquals(map.get("ProgramName"), prog.getProgramName());
			softAssert.assertEquals(map.get("ProgramDescription"), prog.getProgramDescription());
			softAssert.assertEquals(map.get("ProgramStatus"), prog.getProgramStatus());
			softAssert.assertAll();
			LoggerLoad.info("");

		}
		
		@When("Admin gets a message {string} alert and able to see the updated description in the table for the particular program")
		public void admin_gets_a_message_alert_and_able_to_see_the_updated_description_in_the_table_for_the_particular_program(String expectedSuccessMsg) throws InterruptedException {

			softAssert.assertEquals(manageProgramPage.getFlyingMsgText(), expectedSuccessMsg);
			
			manageProgramPage.enterTextInSearchBox(prog.getProgramName());
			Thread.sleep(2000);
			
			map = manageProgramPage.isAddedOrEditedProgramRecordVisible(prog.getProgramName());

			System.out.println(Arrays.asList(map));
			softAssert.assertEquals(map.get("ProgramName"), prog.getProgramName());
			softAssert.assertEquals(map.get("ProgramDescription"), prog.getProgramDescription());
			softAssert.assertEquals(map.get("ProgramStatus"), prog.getProgramStatus());
			LoggerLoad.info("");
			softAssert.assertAll();
			LoggerLoad.info("");

		}

		@Then("Admin gets a message {string} alert and able to see the updated name in the table for the particular program")
		public void admin_gets_a_message_alert_and_able_to_see_the_updated_name_in_the_table_for_the_particular_program(String expectedSuccessMsg) throws InterruptedException {
			
			softAssert.assertEquals(manageProgramPage.getFlyingMsgText(), expectedSuccessMsg);
			
			manageProgramPage.enterTextInSearchBox(prog.getProgramName());
			Thread.sleep(2000);
			
			HashMap<String, String> map = manageProgramPage.isAddedOrEditedProgramRecordVisible(prog.getProgramName());

			System.out.println(Arrays.asList(map));
			softAssert.assertEquals(map.get("ProgramName"), prog.getProgramName());
			softAssert.assertEquals(map.get("ProgramDescription"), prog.getProgramDescription());
			softAssert.assertEquals(map.get("ProgramStatus"), prog.getProgramStatus());
			softAssert.assertAll();
			LoggerLoad.info("");
			
		    
		}
		
		@Given("Admin edits both Name and Description edit box")
		public void admin_edits_both_name_and_description_edit_box() {

			programDetailsPage.enterTextInField("name","Name Edited");
			programDetailsPage.enterTextInField("description","Description Edited");
			LoggerLoad.info("Admin can edits both Name and Description edit box");

		}
		@When("Admin clicks <Cancel> button on edit popup")
		public void admin_clicks_cancel_button_on_edit_popup() {

			manageProgramPage = programDetailsPage.cancelProgram();
			LoggerLoad.info("Admin can click <Cancel> button on edit popup");


		}
		@Then("Admin can see the Program details popup disappears and can see nothing changed for particular program")
		public void admin_can_see_the_program_details_popup_disappears_and_can_see_nothing_changed_for_particular_program() throws InterruptedException {

			manageProgramPage.enterTextInSearchBox("Name Edited");
			Thread.sleep(2000);
			softAssert.assertEquals(manageProgramPage.getPaginationText(), AppConstants.NO_SEARCH_RESULT_FOUND_TEXT);
			
			manageProgramPage.enterTextInSearchBox(prog.getProgramName());
			Thread.sleep(2000);
			softAssert.assertEquals(manageProgramPage.getPaginationText(), AppConstants.SEARCH_RESULT_FOUND_TEXT);
			
			softAssert.assertAll();
			LoggerLoad.info("Admin can see the Program details popup disappears and can see nothing changed for particular program");
		}
		

}