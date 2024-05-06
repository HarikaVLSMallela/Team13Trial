package numpyninja.qa.lms.stepdefs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import numpyninja.qa.lms.driver.DriverFactory;
import numpyninja.qa.lms.pages.BatchSortingPage;
import numpyninja.qa.lms.utils.LoggerLoad;

public class Batch_Sorting_SD {

	
	WebDriver driver;
	BatchSortingPage batchSort;
	SoftAssert softAssert;
	
	public Batch_Sorting_SD() {
		driver = DriverFactory.getDriver();
		batchSort = new BatchSortingPage(driver);
		softAssert = new SoftAssert();
	}
	
	@When("Admin clicks the sort icon of Batch name column once")
	public void admin_clicks_the_sort_icon_of_batch_name_column_once() {
	    
		batchSort.clickBatchNameSortAsecending();
		LoggerLoad.info("Admin clicks on Batch Name Sort Icon");
	}

	@Then("The data get sorted in ascending order on the table based on the Batch name column values")
	public void the_data_get_sorted_in_ascending_order_on_the_table_based_on_the_batch_name_column_values() {
	    
		List<String> originalList = batchSort.getBtchOriginalList("BatchName");
		List<String> sortedList = batchSort.getBatchSortedList(originalList);
		Assert.assertTrue(originalList.equals(sortedList));
		LoggerLoad.info("Admin Sorted Batch Name in ascending order ");
	}

	@When("Admin clicks the sort icon of Batch name column twice")
	public void admin_clicks_the_sort_icon_of_batch_name_column_twice() throws InterruptedException {
	    
		batchSort.clickBatchNameSortDesecending();
		LoggerLoad.info("Admin clicks on Batch Name Sort Icon");	   
	}

	@Then("The data get sorted in descending order on the table based on the Batch name column values")
	public void the_data_get_sorted_in_descending_order_on_the_table_based_on_the_batch_name_column_values() {
	    
		List<String> originalList = batchSort.getBtchOriginalList("BatchName");
		List<String> sortedList = batchSort.getBatchSortListDescend(originalList);
		Assert.assertTrue(originalList.equals(sortedList));	  
		LoggerLoad.info("Admin Sorted Batch Name in descending order");
	}

	@When("Admin clicks the sort icon of Batch Description column once")
	public void admin_clicks_the_sort_icon_of_batch_description_column_once() {
	    
		batchSort.clickBatchDescSortAsecending();
		LoggerLoad.info("Admin clicks on Batch Description Sort Icon");

	}
	
	@Then("The data get sorted in ascending order on the table based on the Batch Description column values")
	public void the_data_get_sorted_in_ascending_order_on_the_table_based_on_the_batch_description_column_values() {
	    
		List<String> originalList = batchSort.getBtchOriginalList("BatchDescription");
		List<String> sortedList = batchSort.getBatchSortedList(originalList);
		Assert.assertTrue(originalList.equals(sortedList));
		LoggerLoad.info("Admin Sorted Batch Description in ascending order");
	}

	@When("Admin clicks the sort icon of Batch Description column twice")
	public void admin_clicks_the_sort_icon_of_batch_description_column_twice() throws InterruptedException {
	    
		batchSort.clickBatchDescSortDesecending();
		LoggerLoad.info("Admin clicks on Batch Desciption Sort Icon");
	}
	
	@Then("The data get sorted in descending order on the table based on the Batch Description column values")
	public void the_data_get_sorted_in_descending_order_on_the_table_based_on_the_batch_descriton_column_values() {
	    
		List<String> originalList = batchSort.getBtchOriginalList("BatchDescription");
		List<String> sortedList = batchSort.getBatchSortListDescend(originalList);
		Assert.assertTrue(originalList.equals(sortedList));	
		LoggerLoad.info("Admin sorted Batch Description in descending order");
	}

	@When("Admin clicks the sort icon of Program Name column once")
	public void admin_clicks_the_sort_icon_of_program_name_column_once() {
	    
		batchSort.clickBatchProgNameSortAsecending();
		LoggerLoad.info("Admin clicks on Program Name Sort Icon");

	}

	@Then("The data get sorted in ascending order on the table based on the Program name column values")
	public void the_data_get_sorted_in_ascending_order_on_the_table_based_on_the_program_name_column_values() {
	    
	    List<String> originalList = batchSort.getBtchOriginalList("ProgramName");
		List<String> sortedList = batchSort.getBatchSortedList(originalList);
		Assert.assertTrue(originalList.equals(sortedList));
		LoggerLoad.info("Admin sorted Program Name in ascending order");
	}

	@When("Admin clicks the sort icon of Program name column twice")
	public void admin_clicks_the_sort_icon_of_program_name_column_twice() throws InterruptedException {
	    
		batchSort.clickBatchProgNameStatusDesecending();
		LoggerLoad.info("Admin clicks on Program Name Sort Icon");
	}

	@Then("The data get sorted in descending order on the table based on the Program name column values")
	public void the_data_get_sorted_in_descending_order_on_the_table_based_on_the_program_name_column_values() {
	    
		List<String> originalList = batchSort.getBtchOriginalList("ProgramName");
		List<String> sortedList = batchSort.getBatchSortListDescend(originalList);
		Assert.assertTrue(originalList.equals(sortedList));	
		LoggerLoad.info("Admin sorted Program Name in descending order");
	}

	@When("Admin clicks the sort icon of Number of classes column once")
	public void admin_clicks_the_sort_icon_of_number_of_classes_column_once() {
	    
		batchSort.clickBatchNumClassSortAsecending();
		LoggerLoad.info("Admin clicks on NoOfClass Sort Icon");	   
	}

	@Then("The data get sorted in ascending order on the table based on the Number of classes column values")
	public void the_data_get_sorted_in_ascending_order_on_the_table_based_on_the_number_of_classes_column_values() {
	    
	   ArrayList<Integer> originalList = batchSort.getNumclassOriginalList();
	   ArrayList<Integer> sortedList = batchSort.getBatchSortedNCList(originalList);
	   Assert.assertTrue(originalList.equals(sortedList));
	   LoggerLoad.info("Admin sorted Number of Class in ascending order");	   
	}

	@When("Admin clicks the sort icon of Number of classes column twice")
	public void admin_clicks_the_sort_icon_of_number_of_classes_column_twice() throws InterruptedException {
	    
		batchSort.clickBatchNumClassSortDesecending();
		LoggerLoad.info("Admin clicks on NoOfClass Sort Icon");
	}

	@Then("The data get sorted in descending order on the table based on the Number of classes column values")
	public void the_data_get_sorted_in_descending_order_on_the_table_based_on_the_number_of_classes_column_values() {
	    
		ArrayList<Integer> originalList = batchSort.getNumclassOriginalList();
		ArrayList<Integer> sortedList = batchSort.getBatchSortListNCDescend(originalList);
		Assert.assertTrue(originalList.equals(sortedList));	
		LoggerLoad.info("Admin sorted Number of classes in descending order");
	}

	@When("Admin clicks the sort icon of Status column once")
	public void admin_clicks_the_sort_icon_of_status_column_once() {
	    
		batchSort.clickBatchStatusSortAsecending();
		LoggerLoad.info("Admin clicks on Status Sort Icon");
	}

	@Then("The data get sorted in ascending order on the table based on the Status column values")
	public void the_data_get_sorted_in_ascending_order_on_the_table_based_on_the_status_column_values() {
		  
		List<String> originalList = batchSort.getBtchOriginalList("Status");
		List<String> sortedList = batchSort.getBatchSortedList(originalList);
		Assert.assertTrue(originalList.equals(sortedList));
		LoggerLoad.info("Admin sorted Status in ascending order");	   
	}

	@When("Admin clicks the sort icon of Status column twice")
	public void admin_clicks_the_sort_icon_of_status_column_twice() throws InterruptedException {
	    
		batchSort.clickBatchStatusSortDesecending();
		LoggerLoad.info("Admin clicks on Status Sort Icon");
	}

	@Then("The data get sorted in descending order on the table based on the Status column values")
	public void the_data_get_sorted_in_descending_order_on_the_table_based_on_the_status_column_values() {

		List<String> originalList = batchSort.getBtchOriginalList("Status");
		List<String> sortedList = batchSort.getBatchSortListDescend(originalList);
		Assert.assertTrue(originalList.equals(sortedList));
		LoggerLoad.info("Admin sorted Status in descending order");
	}
	
}
