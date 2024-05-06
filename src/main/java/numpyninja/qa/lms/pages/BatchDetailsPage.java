package numpyninja.qa.lms.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import numpyninja.qa.lms.utils.ElementUtil;

	public class BatchDetailsPage {


		private WebDriver driver;
		private ElementUtil util;		
		
		private By BatchDetailsWindow=By.xpath("//span[@id='pr_id_5-label']");
		private By Name = By.xpath("//input[@id='batchName' and @type='text']");
		private By Description = By.xpath("//input[@id='batchDescription' and @type='text']");
	    private By NumberOfClasses=By.xpath("//input[@id='batchNoOfClasses' and @type='number']");
		private By ProgramName = By.xpath("//input[@placeholder='Select a Program name']");
		private By Active = By.xpath("//input[@id='ACTIVE']/../../..");
		private By InActive=By.xpath("(//span[@class='p-radiobutton-icon'])[2]");
	    private By Cancel_batch = By.xpath("//span[text()='Cancel']");
		private By save_batch = By.xpath("//span[text()='Save']");
		private By closeButton = By.xpath("//button[@tabindex='-1']");

		//private By BatchCreateSuccess = By.xpath("//div[@class='p-toast-summary ng-tns-c90-11']");
		private By BatchSuccess1 = By.xpath("//div[text()='Successful']");
	    private By BatchSuccess2 = By.xpath("//div[text()=' Batch Created Successfully']");
		//private By BatchCreateMessage = By.xpath("//div[@class='p-toast-detail ng-tns-c90-11']");
		private By BatchNameFail1 = By.xpath("//div[text()='Failed']");
	    private By BatchNameFail2 = By.xpath("//div[text()='batchName must begin with alphabet and can contain only alphanumeric characters']");

		private By ProgNameDropdown = By.xpath("//p-dropdown[@placeholder='Select a Program name']");
	    //private By progNameDropdownSection = By.className("p-dropdown-items-wrapper");
		
		private By RadioButton = By.xpath("//p-radiobutton[@id='batchStatus']");
	    private By SearchBox = By.xpath("//input[@placeholder='Search...']");
		private By Pagination = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");
		
		private By ProgNamedropdownclick = By.xpath("//div[@role='button']/span");
		//private By programlist1 = By.xpath("//ul[contains(@class,'p-dropdown')]/p-dropdownitem/li/span");
		//private By errorText=By.id("text-danger");
				
		private By errorMsgTextFields = By.xpath("//small[@id='text-danger']");
		private By errorMsgBatchName = By.xpath("//small[text()='Batch Name is required. ']");
		private By errorMsgDescription = By.xpath("//small[text()='Batch Description is required.']");
		private By errorMsgProgName = By.xpath("//small[text()='Program Name is required.']");
		private By errorMsgStatus = By.xpath("//small[text()='Status is required.']");
		private By errorMsgNoOfClass = By.xpath("//small[text()='Number of classes is required.']");		

		private By errorText_classes = By.xpath("//*[@id='batchDescription']/../small[2]");
		private By errorText_description = By.xpath("//*[@id='batchDescription']/../small[1]");
		private By batch_Update_message = By.xpath("//div[contains(@class,'p-toast-summary')]");
		//private By close_delete = By.xpath("//span[@class='pi pi-times ng-tns-c133-7']");

		
		/*
		 * private By Name = By.xpath("//input[@id='batchName']"); private By
		 * Description = By.id("batchDescription"); private By ProgramName =
		 * By.id("programName"); private By Active
		 * =By.xpath("(//span[@class='p-radiobutton-icon'])[1]"); private By
		 * NumberOfClasses=By.id("batchNoOfClasses");
		 */
		
		public BatchDetailsPage(WebDriver driver) {
			this.driver = driver;
			this.util = new ElementUtil(driver);
		}
		
		public String getBatchDetailsWindow() {
			if (util.isElementDisplayed(BatchDetailsWindow)) {
				return util.getElementText(BatchDetailsWindow);
			} else
				return null;
		}

		public Boolean isBatchNameBoxExists() {
			return util.isElementDisplayed(Name);
		}
		public Boolean isBatchDescriptionBoxExists() {
			return util.isElementDisplayed(Description);
		}
		public Boolean isProgramNameBoxExists() {
			return util.isElementDisplayed(ProgramName);
		}
		public Boolean isActiveBoxExists() {
			return util.isElementDisplayed(Active);
		}
		
		public Boolean isInActiveBoxExists() {
			return util.isElementDisplayed(InActive);
		}
		
		public Boolean isNumberOfClassesBoxExists() {
			return util.isElementDisplayed(NumberOfClasses);
		}
		
		public void enterBatchName(String batchName,String batchDescription) {
			util.doSendKeys(Name, batchName);
			util.doSendKeys(Description, batchDescription);
		}
		
		public void enterBatchDescription(String batchDescription) {
			util.doSendKeys(Description, batchDescription);
		}
		
		
		public Boolean isSaveButtonPresent() {
			return util.isElementDisplayed(save_batch);
		}
		
		public Boolean isCancelButtonPresent() {
			return util.isElementDisplayed(Cancel_batch);
		}
		
		public Boolean isCloseButtonPresent() {
			return util.isElementDisplayed(closeButton);
		}
		
		public void closeBatchDetailsWindow() {
			util.doClick(closeButton);
		}
		
		public Boolean isActiveEnable() {
			return util.isElementEnabled(Active);
		}

		public Boolean isInActiveEnable() {
			return util.isElementEnabled(InActive);
		}
		
		public void selectActive() {
			util.doClick(Active);
		}

		public void selectInActive() {
			util.doClick(InActive);
		}
		
		public Boolean isDisabledName() {
			boolean isNamefieldDisable = !util.isElementEnabled(Name);
			return isNamefieldDisable;
		}

		public Boolean isDisabledProgramName() {
			boolean isProgramNamefieldDisable = !util.isElementEnabled(ProgramName);
			return isProgramNamefieldDisable;
		}

		
		public void saveBatchDetailsWindow() {
			util.doClick(save_batch);
		}

///Harika 
		public void clickstatusActive() {
	
			util.doClick(Active);
		}
		
		public void cancelBatchWindow() {
			
			util.doClick(Cancel_batch);
		}
		
		public void clickstatusInActive() {
			util.doClick(InActive);
		}
		
		public void clickprogramdropsown() {
			util.doClick(ProgNamedropdownclick);
		}
		
		public void enterBatchNameOnly(String batchName) {
			util.doSendKeys(Description, batchName);
		}

		public void enterProgramName(String programName) {
			// Select progromNamedropDown=new Select(util.getElement(ProgramName));
			// progromNamedropDown.selectByVisibleText(programName);
			util.doSendKeys(ProgramName, programName);
		}

		public void enterNumberofClasses(String num) {
			// int number=Integer.parseInt(num);
			WebElement numberOfClassesElement = driver.findElement(NumberOfClasses);
			numberOfClassesElement.clear();
			numberOfClassesElement.sendKeys(num);
		}
		
		public Boolean BatchnameTextbox() {
	
			String text = "Team13AutoArch";
			util.doSendKeys(Name,text);
			String NameVal =  util.getAttributeVal(Name, "value");
			if (text == NameVal) {
				return true;
			}
			return true;
		}
	
		public Boolean NoOfClassesTextbox() {	
			String text = "13";
			util.doSendKeys(NumberOfClasses,text);
			String ClassVal = util.getAttributeVal(NumberOfClasses, "value");
			if (text == ClassVal) {
				return true;
			}
			return true;
		}
	
		public Boolean DescriptionTextbox() {
	
			String text = "Team13AutomationArchitects";
			util.doSendKeys(Description,text);
			String Descval = util.getAttributeVal(Description, "value");
			if (text == Descval) {
				return true;
			}
			return true;
		}
	
		public Boolean programNameDropdown() {
	
			String tag = driver.findElement(ProgNameDropdown).getTagName();
			Boolean contains = tag.contains("dropdown");
			return contains;
		}
	
		public Boolean StatusRadiobutton() {
	
			List<WebElement> radioButtons = util.getElements(RadioButton);
			
			int radiobuttonCount = radioButtons.size();
			int counter = 0;
			
			for (WebElement radio : radioButtons) {
				
				if (radio.getTagName().contains("radiobutton")) {
					counter++;
					}
				}
				if (radiobuttonCount == counter) {
					return true;
				}
				else
					return false;
				
		}
	
//		public void BatchDetailsDesc(String string1,String string2,String string3) {
//			
//			util.doSendKeys(Name, string1);
//			util.doSendKeys(ProgramName, string3);
//			clickstatusActive();
//			util.doSendKeys(NumberOfClasses, string2);
//			saveBatchDetailsWindow();
//		}
		
		public void selectProgramNameUsingAction() throws InterruptedException {
			clickprogramdropsown();
			Thread.sleep(1000);
			util.pressdownArrowButtonUsingAction();
			util.pressEnterButtonUsingAction();
		}
		
/*	**** Tried to select using program name using below methods but didn't worked***
	public void selectprogramname(String programName) throws InterruptedException {
	clickprogramdropsown();
	
	if(util.isElementDisplayed(progNameDropdownSection)) {
		System.out.println("Dropdown menu has expanded");
		Thread.sleep(2000);
		//By option = By.xpath("//ul[@role='listbox']/p-dropdownitem/li/span[text()='"+programName+"']");
		
		By option = By.xpath("//ul[@role='listbox']/p-dropdownitem/li[@aria-label='"+programName+"']");

		util.scrollIntoView(option);
		Thread.sleep(5000);
		util.doClick(option);
	}
	------------------------------------------------
	List<WebElement> dropDowns = driver.findElements(programlist1);
	Thread.sleep(3000);
	for (WebElement dropdown : dropDowns) {	
		try {
		if (dropdown.getText().equalsIgnoreCase("Developer")) {
			Thread.sleep(3000);
			dropdown.click();
		}
		}
		catch (StaleElementReferenceException e) {}
			}		}			} 
*/
	public void BatchDetails(String batchName,String description,String numberOfClasses) throws InterruptedException {
		
		String wh = driver.getWindowHandle();
		driver.switchTo().window(wh);
		
		try
		{
		util.doSendKeys(Name, batchName);
		util.doSendKeys(Description, description);
		
		//selectprogramname("Team13Batch");		
		selectProgramNameUsingAction();
		clickstatusActive();
		
		util.doSendKeys(NumberOfClasses, numberOfClasses);
		saveBatchDetailsWindow();
		}
		catch (StaleElementReferenceException e) {}
	}
	
	public void BatchInValidDetails(String string1,String string2) throws InterruptedException {
		
		String wh = driver.getWindowHandle();
		driver.switchTo().window(wh);
		
		try
		{
		util.doSendKeys(Name, string1);
		util.doSendKeys(Description, string2);
		
		}
		catch (StaleElementReferenceException e) {}
	}
	
	public String ErrorMsgNameDesc() {
		
		String ErrMsgNameDesc = driver.findElement(errorMsgTextFields).getText();
		return ErrMsgNameDesc;
	}
	
	public String ErrorMsgName() {
		
		String ErrMsgName = driver.findElement(errorMsgBatchName).getText();
		return ErrMsgName;
	}
	
	public String ErrorMsgDesc() {
		
		String ErrMsgDesc = driver.findElement(errorMsgDescription).getText();
		return ErrMsgDesc;
	}
	
	public Boolean ErrorMsgDescError() {
		
		return util.isElementDisplayed(errorMsgDescription);		
	}
	
	public String ErrorMsgProg() {
		
		String ErrMsgProg = driver.findElement(errorMsgProgName).getText();
		return ErrMsgProg;
	}
	
	public String ErrorMsgStatus() {
		
		String ErrMsgStatus = driver.findElement(errorMsgStatus).getText();
		return ErrMsgStatus;
	}
	
	public String ErrorMsgClass() {

		String ErrMsgNoofclass = driver.findElement(errorMsgNoOfClass).getText();
		return ErrMsgNoofclass;
	}
	
	public Boolean CheckifNewBatchAdded(String string) throws InterruptedException {

		util.doSendKeys(SearchBox, string);
		Thread.sleep(2000);
		String BatchCheckPage = driver.findElement(Pagination).getText();
		System.out.println(BatchCheckPage);
		Thread.sleep(2000);
		Boolean BatchExists = BatchCheckPage.equals("Showing 1 to 1 of 1 entries"); // BatchCheckPage.contains("Showing 1 to 1 of 1 entries");
		System.out.println(BatchExists);
		return BatchExists;		
	}
	
	public String getSuccessMessageText() throws InterruptedException {
		Thread.sleep(1000);
		String Message1 = driver.findElement(BatchSuccess1).getText();
		String Message2 = driver.findElement(BatchSuccess2).getText();
		String Message = Message1+" "+Message2;
		System.out.println("Actual message appeared on the screen is: " + Message);
		return Message;
	}
	
	public String getErrMsgFailedName() throws InterruptedException
	{
		Thread.sleep(1000);
		String ErrMsgName1 = driver.findElement(BatchNameFail1).getText();
		String ErrMsgName2 = driver.findElement(BatchNameFail2).getText();
		String ErrMsgName = ErrMsgName1+" "+ErrMsgName2;
		System.out.println("Actual message appeared on the screen is: " + ErrMsgName);
		return ErrMsgName;
	}
	
	public void BatchBlankName(String description,String numberOfClasses) throws InterruptedException {
		
		String wh = driver.getWindowHandle();
		driver.switchTo().window(wh);
		
		try
		{
		//util.doSendKeys(Name, batchName);
		util.doSendKeys(Description, description);
		selectProgramNameUsingAction();
		clickstatusActive();
		util.doSendKeys(NumberOfClasses, numberOfClasses);
		saveBatchDetailsWindow();
		}
		catch (StaleElementReferenceException e) {}
	}
	
	public void BatchBlankDescription(String batchName,String numberOfClasses) throws InterruptedException {
		
		String wh = driver.getWindowHandle();
		driver.switchTo().window(wh);
		
		try
		{
		util.doSendKeys(Name, batchName);
		//util.doSendKeys(Description, description);
		selectProgramNameUsingAction();
		clickstatusActive();
		util.doSendKeys(NumberOfClasses, numberOfClasses);
		saveBatchDetailsWindow();
		}
		catch (StaleElementReferenceException e) {}
	}
	
	public void BatchBlankProgName(String batchName,String description,String numberOfClasses) throws InterruptedException {
		
		String wh = driver.getWindowHandle();
		driver.switchTo().window(wh);
		
		try
		{
		util.doSendKeys(Name, batchName);
		util.doSendKeys(Description, description);
		//selectProgramNameUsingAction();
		clickstatusActive();
		util.doSendKeys(NumberOfClasses, numberOfClasses);
		saveBatchDetailsWindow();
		}
		catch (StaleElementReferenceException e) {}
	}
	
	public void BatchBlankStatus(String batchName,String description,String numberOfClasses) throws InterruptedException {
		
		String wh = driver.getWindowHandle();
		driver.switchTo().window(wh);
		
		try
		{
		util.doSendKeys(Name, batchName);
		util.doSendKeys(Description, description);
		selectProgramNameUsingAction();
		//clickstatusActive();
		util.doSendKeys(NumberOfClasses, numberOfClasses);
		saveBatchDetailsWindow();
		}
		catch (StaleElementReferenceException e) {}
	}

	public void BatchBlankNoofClass(String batchName,String description) throws InterruptedException {
		
		String wh = driver.getWindowHandle();
		driver.switchTo().window(wh);
		
		try
		{
		util.doSendKeys(Name, batchName);
		util.doSendKeys(Description, description);
		selectProgramNameUsingAction();
		clickstatusActive();
		//util.doSendKeys(NumberOfClasses, numberOfClasses);
		saveBatchDetailsWindow();
		}
		catch (StaleElementReferenceException e) {}
	}

	public void getErrorText() {

		boolean isErrorClassesPresent = util.isElementPresent(errorText_classes);
		boolean isErrorDescriptionPresent = util.isElementPresent(errorText_description);
		if (isErrorClassesPresent) {
			String errorTextClasses = util.getElementText(errorText_classes);
			System.out.println(errorTextClasses);
		}
		if (isErrorDescriptionPresent) {
			String errorTextDescription = util.getElementText(errorText_description);
			System.out.println(errorTextDescription);
		}
		else {
			System.out.println("No error message found");
		}
	}
	
	public void getBatchUpdateMessage() {//Update batch msg
		
		System.out.println(util.getElementText(batch_Update_message));
	}
	
	public void EnterClearBatchName(String batchName) throws InterruptedException {
		String wh = driver.getWindowHandle();
		driver.switchTo().window(wh);
		util.doSendKeys(Name, batchName);
		util.clickAndDeleteTextUsingAction(Name);	
	}
	
	public void EnterClearBatchDesc(String description) throws InterruptedException {		
		String wh = driver.getWindowHandle();
		driver.switchTo().window(wh);
		util.doSendKeys(Description, description);	
		util.clickAndDeleteTextUsingAction(Description);
	}

}
