package numpyninja.qa.lms.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import numpyninja.qa.lms.utils.ElementUtil;

public class BatchSortingPage {

	private WebDriver driver;
	private ElementUtil util;
	
	private By BatchNamesort = By.xpath("//thead/tr/th[2]//i");
	private By BatchDescsort = By.xpath("//thead/tr/th[3]//i");
	private By BatchStatussort = By.xpath("//thead/tr/th[4]//i");
	private By BatchNumClasssort = By.xpath("//thead/tr/th[5]//i");
	private By BatchProgNamesort = By.xpath("//thead/tr/th[6]//i");
	private By BatchNamelist = By.xpath("//tbody//td[2]");
	private By BatchDesclist = By.xpath("//tbody//td[3]");
	private By BatchStatuslist = By.xpath("//tbody//td[4]");
	private By BatchNumClasslist = By.xpath("//tbody//td[5]");
	private By BatchProgNamelist = By.xpath("//tbody//td[6]");
	
	
	public BatchSortingPage(WebDriver driver) {
		this.driver = driver;
		this.util = new ElementUtil(driver);
	}
		
	public List<String> getBtchOriginalList(String type) {
		List<String> originalList = null;
		
		if(type.equals("BatchName")) {
			List<WebElement> BatchNamlist = util.getElements(BatchNamelist);
			originalList = util.printWebElements(BatchNamlist);
		
		}else if(type.equals("BatchDescription")) {
			List<WebElement> BatchDeslist = util.getElements(BatchDesclist);
			originalList = util.printWebElements(BatchDeslist);
		
		}else if(type.equals("ProgramName")){
			List<WebElement> BatchProglist = util.getElements(BatchProgNamelist);
			originalList = util.printWebElements(BatchProglist);
		}else {
			List<WebElement> BatchStatulist = util.getElements(BatchStatuslist);
			originalList = util.printWebElements(BatchStatulist);
		}
		return originalList;	
	}

	public ArrayList<Integer> getNumclassOriginalList() {
		
		ArrayList<Integer> originalNCList = null;
		ArrayList<WebElement> BatchNclasslist = util.getElementsint(BatchNumClasslist);
		originalNCList = util.printWebElementsNC(BatchNclasslist);
		return originalNCList;
	}
	
	public List<String> getBatchSortedList(List<String> originalList) {
		
		List<String> sortedList = util.getSortedList(originalList);
		return sortedList;	
	}
	
	public ArrayList<Integer> getBatchSortedNCList(ArrayList<Integer> originalNCList) {
		
		ArrayList<Integer> sortedList = util.getSortedNCList(originalNCList);
		return sortedList;	
	}
	
	public List<String> getBatchSortListDescend(List<String> originalList) {
		
		List<String> sortedList = util.getSortedListDescending(originalList);
		return sortedList;	
	}
	
	public ArrayList<Integer> getBatchSortListNCDescend(ArrayList<Integer> originalNCList) {
		
		ArrayList<Integer> sortedList = util.getSortedListNCDescending(originalNCList);
		return sortedList;	
	}
	
	public void clickBatchNameSortAsecending(){
		
		util.doClick(BatchNamesort);
	}
	
	public void clickBatchNameSortDesecending() throws InterruptedException {
		
		util.doClick(BatchNamesort);
		Thread.sleep(1000);
		util.doClick(BatchNamesort);
	}
	
	public void clickBatchDescSortAsecending() {

		util.doClick(BatchDescsort);
	}
	
	public void clickBatchDescSortDesecending() throws InterruptedException {

		util.doClick(BatchDescsort);
		Thread.sleep(1000);
		util.doClick(BatchDescsort);
	}
	
	public void clickBatchStatusSortAsecending(){

		util.doClick(BatchStatussort);
	}
	
	public void clickBatchStatusSortDesecending() throws InterruptedException {
		
		util.doClick(BatchStatussort);
		Thread.sleep(1000);
		util.doClick(BatchStatussort);
	}
	
	public void clickBatchNumClassSortAsecending(){

		util.doClick(BatchNumClasssort);
	}
	
	public void clickBatchNumClassSortDesecending() throws InterruptedException {
		
		util.doClick(BatchNumClasssort);
		Thread.sleep(1000);
		util.doClick(BatchNumClasssort);
	}
	
	public void clickBatchProgNameSortAsecending(){

		util.doClick(BatchProgNamesort);
	}
	
	public void clickBatchProgNameStatusDesecending() throws InterruptedException {
		
		util.doClick(BatchProgNamesort);
		Thread.sleep(1000);
		util.doClick(BatchProgNamesort);
	}
		
}