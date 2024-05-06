package numpyninja.qa.lms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import numpyninja.qa.lms.utils.ElementUtil;

public class DeleteBatchPage {

	//code for deleting single and multiple batches
	private WebDriver driver;
	private ElementUtil util;

	private By confirmTextHeader = By.className("p-dialog-title");
	//private By dialogMessage = By.className("p-confirm-dialog-message");
//	private By noButton = By.xpath("//span[text()='No']/..");
//	private By yesButton = By.xpath("//span[text()='Yes']/..");
	
	private By noButton = By.xpath("//span[@class='p-button-icon p-button-icon-left pi pi-times']");
	private By yesButton = By.xpath("//button[contains(@class, 'p-confirm-dialog-accept')]");
	private By closeButton = By.className("p-dialog-header-close");
	//button[@class='ng-tns-c133-17 p-confirm-dialog-reject p-ripple p-button p-component ng-star-inserted']
	//span[@class='p-confirm-dialog-message ng-tns-c133-60']
	
	//div[@class='p-toast-message-text ng-tns-c90-46 ng-star-inserted']
	//button[@class='ng-tns-c133-165 p-confirm-dialog-accept p-ripple p-button p-component ng-star-inserted']
	
	public DeleteBatchPage(WebDriver driver) {
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
	
	
	
	public boolean noBtnExists() {
		return util.isElementDisplayed(noButton);
	} 
	
	public boolean yesBtnExists() {
		return util.isElementDisplayed(yesButton);
	} 
	
	public boolean closeBtnExists() {
		return util.isElementDisplayed(closeButton);
	} 
	
	public ManageBatchPage clickNoBtn() {
		util.doClick(noButton);
		return new ManageBatchPage(driver);
	} 
	
	public ManageBatchPage clickYesBtn() {
	//	util.isElementDisplayed(yesButton);
		util.doClick(yesButton);
		return new ManageBatchPage(driver);
	} 
	
	public ManageBatchPage clickCloseBtn() {
		util.isElementDisplayed(closeButton);
		return new ManageBatchPage(driver);
	} 
	
	public String getYesLabel() {
		return util.getElementText(yesButton);
	}

	
	public String getNoLabel() {
		return util.getElementText(noButton);
	}
}
