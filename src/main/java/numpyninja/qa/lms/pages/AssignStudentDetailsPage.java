package numpyninja.qa.lms.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import numpyninja.qa.lms.utils.ElementUtil;
import numpyninja.qa.lms.utils.LoggerLoad;

public class AssignStudentDetailsPage {
	private WebDriver driver;
	private ElementUtil util;
	
	private By AssignStudentButton = By.xpath("//span[contains(text(),\"Assign Student\")]");

	private By studentUserRole = By.xpath("//input[@name='roleId']");
	private By studentEmail = By.xpath("//span[contains(text(),'Select Email ID')]");
	
	private By radioActiveButton = By.xpath("//form/div[5]/div[2]");
	private By radioInActiveButton = By.xpath("//form/div[5]/div[3]");

	private By studentProgramName = By.xpath("//input[@id='programName']");

	private By studentBatchName = By.xpath("//input[@id='batchName']");
	private By saveButton = By.xpath("//*[contains(text(),'Save')]");
	private By cancelButton = By.xpath("//*[contains(text(),'Cancel')]");
	private By emailIDRequiredError = By.xpath("*[contains(text(),' User Email Id is required. ')]");
	
	private By selectStudentEmailID = By.xpath("//p-dropdown/div/div/span");
	private By selectProgram = By.xpath("//form/div[3]");

	private By selectBatch = By.xpath("//form/div[4]");
	
	private By serachEmailIDBUtton = By.xpath("//form/div[3]/input");
	
	private By giveEmailID = By.xpath("//li");

	//private By errorEmailList = By.xpath("//div[contains(text(),' User Email Id is required. ')]");
	////div[@class='ng-star-inserted']
	private By errorEmailList = By.xpath("/div[@class='ng-star-inserted']");

	//errorProgram
	private By errorProgram = By.xpath("//div[contains(text(),' Program Name is required.')]");

	
	//*************************** POP WIndows ************************
	private By programText = By.xpath("//input[@id='programName']");
	
	private By emailIDText = By.xpath("//span[contains(text(),'Select Email ID')]");
    
	private By batchIdText = By.xpath("//input[@id='batchName']");

	private By roleIdStudent = By.xpath("//input[@name='roleId']");
	
	
	//******************Values ******************************
	private By programName = By.xpath("//label[contains(text(),'Program Name')");
	private By batchName = By.xpath("//label[contains(text(),'Batch Name')]");
	private By emailTextVisible = By.xpath("//label[contains(text(),'Student Email Id')]");
	private By statusText = By.xpath("//label[contains(text(),'Status : ')]");
////label[contains(text(),'User Role')]
	private By roleText = By.xpath("//label[contains(text(),'User Role')]");

	private By assignTextNotVisible = By.xpath("//span[contains(text(),'Assign Student')]");
	
	
	///*************************multiple user deletion
	private By deleteButton = By.xpath("//*[text()=' Manage User']//following-sibling::div//button[@icon='pi pi-trash']");
	////*[@class='p-datatable-tbody']//tr/td[1]//div[@role='checkbox']
	
	private By deleteCheckBoxButton = By.xpath("//*[@class='p-datatable-tbody']//tr/td[1]//div[@role='checkbox']");
	private By rowPrgNameList = By.xpath("//*[@class='p-datatable-tbody']//tr/td[2]");
	private By multipleUserDeleteBtn = By
			.xpath("//*[text()=' Manage User']//following-sibling::div//button[@icon='pi pi-trash']");
	private By paginationEntryInfo = By.className("p-paginator-current");

	
	public AssignStudentDetailsPage(WebDriver driver) {
		this.driver = driver;
		this.util = new ElementUtil(driver);
	}
	
	/*public void dropdownValues() {
		util.selectDropDOwnOption(null);
	}
	public Boolean isStudentProgramNamePresent() {
		return util.isElementDisplayed(studentProgramName);
	}*/
	
	public Boolean isProgramValuePresent()
	{
		return util.isElementDisplayed(programName);
	}
	public Boolean isEmailValuePresent()
	{
		return util.isElementDisplayed(emailTextVisible);
	}
	public Boolean isBatchValuePresent()
	{
		return util.isElementDisplayed(batchName);
	}
	public Boolean isstatusTextPresent()
	{
		return util.isElementDisplayed(statusText);
	}
	public Boolean isRoleTextPresent()
	{
		return util.isElementDisplayed(roleText);
	}
	public Boolean isAssignStudentPresent()
	{
		return util.isElementDisplayed(assignTextNotVisible);
	}
	
	public Boolean isStudentUserRolePresent() {
		/*(try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		return util.isElementDisplayed(studentUserRole);
	}

	public Boolean isRadioActiveButtonPresent() {
		
		return util.isElementDisplayed(radioActiveButton);
	}
public Boolean isRadioInActiveButtonPresent() {
		
		return util.isElementDisplayed(radioInActiveButton);
	}
	
	public Boolean isEmailIDPresent()
	{
		return util.isElementDisplayed(emailIDText);
	}
	public Boolean isProgramTextPresent()
	{
		return util.isElementDisplayed(programText);
	}
	
	public Boolean isBatchPresent()
	{
		return util.isElementDisplayed(batchIdText);
	}
	
	
	public Boolean isSaveCancelButtonPresent()
	{
		return util.isElementDisplayed(statusText);
	}
	
	
	public String emptyErrorEmail()

	{
		try {
			util.wait(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return util.getElementText(emailIDRequiredError);
	}
public void clickSaveButton() {
		
		 util.doClick(saveButton);
	}
public void clickCancelButton() {
	
	 util.doClick(cancelButton);
}
public void clickActiveStatus() {
	
	 util.doClick(radioActiveButton);
}
public Boolean isErrorMessageDisplayed() {
	
	return util.isElementDisplayed(radioActiveButton);
}
public AssignStudentDetailsPage fillUpStudentDetailsForm( String userEmail, String userProgram, String userBatch, String saveOrCancel, String activeInActive) {


	selectEmailId(userEmail);		
	selectProgramName(userProgram);
	selectBatchName(userBatch);
	switch (activeInActive.trim().toLowerCase()) {
	case "Active":
		util.doClick(radioActiveButton);
		break;
	case "InActive":
		util.doClick(radioInActiveButton);
		break;
	default:
		System.out.println("No Active/InActive button");
	}
	
	switch (saveOrCancel.trim().toLowerCase()) {
		case "Save":
		util.doClick(saveButton);
		break;
	case "Cancel":
		util.doClick(cancelButton);
		break;
	default:
		System.out.println("No Save/Cancel button");
	}

	return new AssignStudentDetailsPage(driver);

}


public void selectEmailId(String optionText)  {
	util.doClick(selectStudentEmailID);
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//util.doClick(serachEmailIDBUtton);
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	util.doSendKeys(serachEmailIDBUtton,"java.m@gmail.com");
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	util.doClick(giveEmailID);;
	/*if(util.isElementDisplayed(By.className("p-dropdown-panel"))) {	
		util.doClick(By.xpath("//p-dropdownitem/li/span[text()='"+optionText+"']"));
	}*/
	//util.selectEmail();
	
}

public void selectProgramName(String optionText) {
	util.doClick(selectProgram);
	//util.doClick(serachEmailIDBUtton);
	//util.doSendKeys(serachEmailIDBUtton,"email.com");
	//util.selectDropDOwnOption();
	
	//if(util.isElementDisplayed(By.className("p-dropdown-items"))) {	
	//	util.doClick(By.xpath("//p-dropdownitem/li/span[text()='"+optionText+"']"));
//}
}

public void selectBatchName(String optionText) {
	util.doClick(selectBatch);
	
//	if(util.isElementDisplayed(By.className("p-dropdown-panel"))) {	
	//	util.doClick(By.xpath("//p-dropdownitem/li/span[text()='"+optionText+"']"));
	}

public HashMap<String, String> getErrorMsgsForStudent() {
	
	  HashMap<String, String> map = new HashMap<>(); 
	  StringBuffer buffer = new StringBuffer(""); 
	  
	  List<WebElement> errList = util.getElements(errorEmailList);
	  for(WebElement ele:errList) { 
		  if(ele.getText().contains("User Email Id is required.")) {
			  System.out.println("Email Text");
			  System.out.println(ele.getText());
			  map.put("email error", ele.getText()); 
		  } 
		  else if(ele.getText().contains("Program")) { 
			  map.put("programerror", ele.getText());
		  }
		  else if(ele.getText().contains("Batch")) { 
			  map.put("Batch", ele.getText());
		  }
		  else if(ele.getText().contains("Status")) { 
			  map.put("StatusError", ele.getText());
		  }
		  else if(ele.getText().contains("Program") || ele.getText().contains("special char")){
			 buffer.append(ele.getText()); 		  
		  }
	  
	  map.put("nameError", buffer.toString()); 
	  }
	  
	  return map;
	 
}

//***********************multiple deletion

/**
 * This method enables user to select a checkbox from a given row number
 * 
 * @param int rowNumber
 * @return String corresponding Program Name from the given row
 */
public String getProgramNameFromARow(int rowNum) {
	return util.getElements(rowPrgNameList).get(rowNum - 1).getText();
}
public String selectCheckboxFromARow(int rowNum) {
	util.getElements(deleteCheckBoxButton).get(rowNum - 1).click();
	return getProgramNameFromARow(rowNum);
}
public Boolean isDeleteButtonPresent() {
	LoggerLoad.info( "Delete button present");
	LoggerLoad.info( deleteButton.toString());
	return  util.getElement(deleteButton).isEnabled();
	

	//return  util.isElementDisplayed(deleteButton);
} 
public int getCheckboxCount() {
	return util.getElementSize(deleteCheckBoxButton);
}
/**
 * This method clicks on Multiple Delete Btn
 */
public DeleteMultipleUser clickMultipleUserDeleteBtn() {
	util.doClick(multipleUserDeleteBtn);
	return new DeleteMultipleUser(driver);
}
/**
 * This method checks if Multiple Delete Btn is enabled
 * 
 * @return boolean
 */
public boolean isMultipleDeleteBtnEnabled() {
	return util.getElement(multipleUserDeleteBtn).isEnabled();
}
/**
 * @return total pagination text section
 */
public String getPaginationText() {
	return util.getElementText(paginationEntryInfo);
}
public boolean isMultipleDeleteBtnPresent() {
	return util.isElementDisplayed(multipleUserDeleteBtn);
}

}
