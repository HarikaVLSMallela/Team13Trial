package numpyninja.qa.lms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import numpyninja.qa.lms.utils.ElementUtil;

public class DeleteMultipleUser {
	private WebDriver driver;
	private ElementUtil util;
	
	private By confirmTextHeader = By.className("p-dialog-title");
	private By dialogMessage = By.className("p-confirm-dialog-message");
	private By noButton = By.xpath("//span[text()='No']/..");
	private By yesButton = By.xpath("//span[text()='Yes']/..");
	private By closeButton = By.className("p-dialog-header-close");
	

	public DeleteMultipleUser(WebDriver driver) {
		this.driver = driver;
		this.util = new ElementUtil(driver);
	}
	
	public boolean confirmHeaderExists() {
		return util.isElementDisplayed(confirmTextHeader);
	} 
	
	public String getHeaderText() {
		if(confirmHeaderExists()) {
			return util.getElementText(confirmTextHeader);
		}
		else {
			return "Header doesn't exists";
		}
	}
	
	public String getDialogText() {
		return util.getElementText(dialogMessage);
	}
	
	public boolean noBtnExists() {
		return util.isElementDisplayed(noButton);
	} 
	
	public boolean yesBtnExists() {
		return util.isElementDisplayed(yesButton);
	} 
	
	public boolean closeBtnExists() {
		return util.isElementDisplayed(closeButton);
	} 
	
	public AssignStudentDetailsPage clickNoBtn() {
		util.doClick(noButton);
		return new AssignStudentDetailsPage(driver);
	} 
	
	public AssignStudentDetailsPage clickYesBtn() {
		util.doClick(yesButton);
		return new AssignStudentDetailsPage(driver);
	} 
	
	public  AssignStudentDetailsPage clickCloseBtn() {
		util.doClick(closeButton);
		return new AssignStudentDetailsPage(driver);
	} 

}
