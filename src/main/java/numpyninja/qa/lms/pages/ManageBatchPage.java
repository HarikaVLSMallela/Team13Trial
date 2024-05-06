package numpyninja.qa.lms.pages;

import org.openqa.selenium.Alert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import numpyninja.qa.lms.utils.ElementUtil;

public class ManageBatchPage {

	private WebDriver driver;
	private ElementUtil util;
	

	//tbody[@class='p-datatable-tbody']/tr[1]/td[7]//button[1]
	private By popUp_SuccessMsg = By.id("to be completed");
	private By editIcon =By.xpath("//tbody[@class='p-datatable-tbody']/tr[1]/td[7]//button[1]");
	//private By deleteIcon=By.xpath("//button[@class='p-button-rounded p-button-danger p-button p-component p-button-icon-only']");
	//tbody/tr[1]/td[7]/div[1]/span[2]/button[1]/span[1]
	//tbody[@class='p-datatable-tbody']/tr[td[contains(text(),'Batch002')]]/td[6]
	//tbody[@class='p-datatable-tbody']/tr[1]/td[7]//button[1]	
	//input[@id='filterGlobal']
	private By deleteIcon=By.xpath("//tbody/tr[1]/td[7]/div[1]/span[2]/button[1]/span[1]");
	
	//filterGlobal

	private By search=By.id("filterGlobal");
	private By header = By.xpath("//div[text()=' Manage Batch']");
	private By pagination = By.xpath("//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']");
		
	private By batchName = By.xpath("//th[@psortablecolumn='batchName']");
	private By batchDescription = By.xpath("//th[@psortablecolumn='batchDescription']");
	private By batchStatus = By.xpath("//th[@psortablecolumn='batchStatus']");
	private By noOfClasses = By.xpath("//th[@psortablecolumn='batchNoOfClasses']");
	private By programName = By.xpath("//th[@psortablecolumn='programName']");
	
	private By editDelete = By.xpath("//th[text()=' Edit / Delete ']");	
	private By topdeleteIcon = By.xpath("//div/button[@icon='pi pi-trash']");
	private By newBatchButton = By.xpath("//button[@label='A New Batch']");
	private By BatcheditIcon = By.xpath("//span[@class='p-button-icon pi pi-pencil']");
	private By sidedeleteIcon = By.xpath("(//td//span[@class='p-button-icon pi pi-trash'])");
	private By Batchcheckbox = By.xpath("//td//div[@role='checkbox']");	
	private By BatchDetailspopup = By.xpath("//div[@role='dialog']");
	



//	private By deleteIcon=By.xpath("//tbody[@class='p-datatable-tbody']/tr[1]/td[7]//button[2]");

		private By rowDeleteBtnList = By.xpath("//span[@class='p-button-icon pi pi-trash']");
	    private By rowEditBtnList = By.xpath("//span[@class='p-button-icon pi pi-pencil']");
		private By rowBatchList = By.xpath("//*[@class='p-datatable-tbody']//tr/td[2]");
		private By checkboxList = By.xpath("//*[@class='p-datatable-tbody']//tr/td[1]//div[@role='checkbox']");
		//button[@class='p-button-danger p-button p-component p-button-icon-only']//span[@class='p-button-icon pi pi-trash']
		//(//*[@class='p-datatable-tbody']//tr/td[7])[1]/div/span[2]/button
		//Manage Batch
		private By dialogMessage = By.xpath("//span[contains(@class,'p-confirm-dialog-message')]");
		//div[@role='alert']
		//span[contains(@class,'p-confirm-dialog-message')]
		
		private By multipleRecordDeleteBtn = By
				.xpath("//*[text()='  Manage Batch']//following-sibling::div//button[@icon='pi pi-trash']");
         
//Pagination-Siri
		private By paginationEntryInfo = By.xpath("//*[@class='p-paginator-current ng-star-inserted']");


	
	public ManageBatchPage(WebDriver driver) {
		this.driver = driver;
		this.util = new ElementUtil(driver);
	}
	
	public String getDialogText() {
		
		return util.getElementText(dialogMessage);
	}
	
	public int getEditOrDeleteBtnCount(String editOrDelete) {
		
		String btnName = editOrDelete.trim().toLowerCase();
		if(btnName.equals("edit")) {
			return util.getElementSize(rowEditBtnList);
		}
		else if(btnName.equals("delete")) {
			return util.getElementSize(rowDeleteBtnList);
		}
		else {
			System.out.println("Please enter 'edit' or 'delete'");
			return 0;
		}
	}

	public String getPageUrl() {
		
		return util.getPageURL();
	}
	
	public DeleteBatchPage clickDeleteBtnFromARow(int rowNum) {	
		util.getElements(sidedeleteIcon).get(rowNum-1).click();
		return new DeleteBatchPage(driver);
	}

	public Boolean validateSuccessPopUpMsg() {
		return util.isElementDisplayed(popUp_SuccessMsg);
	}
	
	public Boolean validateEditIconExist() {
		return util.isElementDisplayed(editIcon);
	}
	
	public Boolean validateDeleteIconExist() {

		return util.isElementDisplayed(deleteIcon);
	}
	
	public BatchDetailsPage clickEditIcon() {
		util.doClick(editIcon);
		return new BatchDetailsPage(driver);
	}

	public DeleteBatchPage clickDeleteIcon(String batchName) {
		util.doClick(deleteIcon);
		return new DeleteBatchPage(driver);
	}
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", util.getElement(deleteIcon));
		
		//util.doClick(By.xpath("//td[text()='"+batchName+"']/..//button[@icon='pi pi-trash']"));


	public BatchDetailsPage clickDeleteIcon() {
		util.doClick(deleteIcon);
		return new BatchDetailsPage(driver);
	}

	
	public void searchBatch(String batchname) {
		
		util.doSendKeys(search, batchname);
	}
	
	public String getAlertText() {
		Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.dismiss();
        return alertText;
	}
	
	public boolean manageBatchHeaderExists() {
		return util.isElementDisplayed(header);
	}
	
	public boolean manageUserHeaderExists() {
		return util.isElementDisplayed(header);
	}
	
	public Boolean HeaderValidation(String string) {

			String headertext = header.toString();
			Boolean isContent = headertext.contains(string);
			return isContent;
	}
	
	public Boolean PaginationValidation() {

			return util.isElementDisplayed(pagination);
	}
		
	public Boolean isBatchNameDisplayed() {
		
		 	return util.isElementDisplayed(batchName);
	}
	
	public Boolean isBatchDescriptionDisplayed() {
			
			return util.isElementDisplayed(batchDescription);
	}
	
	public Boolean isBatchStatusDisplayed() {
		
			return util.isElementDisplayed(batchStatus);
	}
	
	public Boolean isNoOfClassesDisplayed() {
		
			return util.isElementDisplayed(noOfClasses);
	}
	
	public Boolean isProgramNameDisplayed() {
		
			return util.isElementDisplayed(programName);
	}
	
	public Boolean isEditDeleteDisplayed() {
			
			return util.isElementDisplayed(editDelete);
	}
		
	public Boolean DeletetopIconValidation() {
			
			Boolean isDeleteIconDisabled = driver.findElement(topdeleteIcon).isEnabled();
			return isDeleteIconDisabled; 
	}
	
	public Boolean NewBatchButton() {
		
			return util.isElementDisplayed(newBatchButton);
	}

	public BatchDetailsPage clickNewBatchButton() {
		
			util.doClick(newBatchButton);
			return new BatchDetailsPage(driver);
	}
	
	public Boolean BatchDetailspopup() {
		
		return util.isElementDisplayed(BatchDetailspopup);
	}
		
	public Boolean editIconValidation() {

		List<WebElement> rowEditIcons = util.getElements(BatcheditIcon);
		int editIconCount=rowEditIcons.size();
		int counter=0;
		for (WebElement editIcon : rowEditIcons) {
			if(editIcon.isEnabled()) {
				counter++;
		if (editIcon.isEnabled()) {
				}
			}
		}
		if(editIconCount==counter) {
			return true;
		}
		else 
			return false;
		}
	
	public HashMap<String, String> isAddedOrEditedbatchRecordVisible(String batchname) {

		HashMap<String, String> map = null;

		String program = batchname;
		String text = util.getElementText(By.className("p-paginator-bottom"));

		String[] arr = text.split(" ");
		int denominator = Integer.parseInt(arr[3]);
		int numerator = Integer.parseInt(arr[5]);
		float ceil =(float) numerator / (float)denominator;
		int totalNumberOfPages = (int) Math.ceil(ceil);

		List<WebElement> ele = util.getElements(By.xpath("//td[text()='" + program + "']"));

		forloop: for (int i = 1; i <= totalNumberOfPages; i++) {
			util.doClick(By.xpath("//button[text()='" + i + "']"));
			System.out.println("Clicked on Page " + i);

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ele = util.getElements(By.xpath("//td[text()='" + program + "']"));

			if (ele.size() == 1) {
				System.out.println(program+" is found on page = " + i);
				List<WebElement> recordElements = util.getElements(By.xpath("//*[text()='" + program + "']/../td"));
				map = new HashMap<>();
				map.put("BatchName", recordElements.get(1).getText());
				map.put("BatchDescription", recordElements.get(2).getText());
				map.put("BatchStatus", recordElements.get(3).getText());
				break forloop;
			} else {
				System.out.println(program+" is not found on Page = " + i);
			}
		}
		return map;
	}

	public String getPaginationText() {
		
		return util.getElementText(paginationEntryInfo);
	}
	public void enterTextInSearchBox(String batchName) {
		
		util.doSendKeys(search, batchName);
	}
	
	public String getBatchNameFromARow(int rowNum) {	
		
		return util.getElements(rowBatchList).get(rowNum-1).getText();
	}
	public String selectCheckboxFromARow(int rowNum) {	
		
		if(rowNum<=0) {
			return null;
		}
		else {
		util.getElements(checkboxList).get(rowNum-1).click();
		return getBatchNameFromARow(rowNum);
		}
	}
	
	public boolean isMultipleDeleteBtnEnabled() {
		
		return util.getElement(topdeleteIcon).isEnabled();
	}
	
	public int getCheckboxCount() {
		
		return util.getElementSize(checkboxList);
	}
	
	public DeleteBatchPage clickMultipleDeleteBtn() {
		
		util.doClick(topdeleteIcon);
		return new DeleteBatchPage(driver);
	}

	public Boolean sidedeleteIconValidation() {
		
		List<WebElement> rowDeleteIcons = util.getElements(sidedeleteIcon);
		int DeleteIconCount=rowDeleteIcons.size();
		int counter=0;
		for (WebElement deleteIcon : rowDeleteIcons) {

			if(deleteIcon.isEnabled()) {
				counter++;
			if (deleteIcon.isEnabled()) {
			}
			}
		}
			if(DeleteIconCount==counter) {
				return true;
			}
			else 
				return false;
	}
	
	public Boolean checkboxValidation() {
		
		List<WebElement> rowCheckboxes = util.getElements(Batchcheckbox);
		int CheckboxCount=rowCheckboxes.size();
		int counter=0;
		for (WebElement checkbox : rowCheckboxes) {
			if(checkbox.isDisplayed()) {
				counter++;
				if (checkbox.isDisplayed()) {
				}
			}
		}
		if(CheckboxCount==counter) {
			return true;
		}
		else 
		return false;
	}
}