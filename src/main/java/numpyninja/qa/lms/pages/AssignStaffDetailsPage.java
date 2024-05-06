package numpyninja.qa.lms.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.StaleElementReferenceException;

import numpyninja.qa.lms.utils.ElementUtil;

public class AssignStaffDetailsPage {

	private WebDriver driver;
	private ElementUtil util;
	
	private By AssignStaffDetailsHeaderText = By.xpath("//span[contains(text(),'Assign User')]");
	private By userRolefield_staff = By.xpath("//*[@id='roleId']");
	private By staffEmailfield_staff = By.xpath("//*[@id='userId']//div//span[contains(text(),'Select Email Id')]");
	private By staffEmailDropDownIcon = By.xpath("//*[@id='userId']//div//div[@role='button']/span");
	
	//public List<WebElement> EmailDropdownList = By.xpath("//ul[contains(@class,'p-dropdown')]/p-dropdownitem");
	
	//@FindBys(value = { @FindBy(how = How.XPATH,using="//ul[contains(@class,'p-dropdown')]/p-dropdownitem/li/span")}) public List<WebElement> EmailDropdownList;
	
	private By skillfield_staff = By.xpath("//input[@id='skillName']");
	
	private By programNamefield_staff = By.xpath("//span[contains(text(),'Select a Program name ')]");
	private By programNameDropDownIcon = By.xpath("//*[@id='programName']//div//div[@role='button']/span");
	
	private By batchNamefield_staff = By.xpath("//*[@id='batchName']//div[contains(text(),'Select Batch Name')]");
	private By batchNameDropDownIcon = By.xpath("//*[@id='batchName']//div/..//span");
	
	private By ActiveStatus_staff = By.xpath("(//span[@class='p-radiobutton-icon'])[1]/..");
	private By InactiveStatus_staff = By.xpath("(//span[@class='p-radiobutton-icon'])[2]/..");
	
	private By Cancel_staff = By.xpath("//span[text()='Cancel']");
	private By save_staff = By.xpath("//span[text()='Save']");
	private By staffcloseButton = By.xpath("//button[@tabindex='-1']");
	private By AssignStaff_SuccessMessage = By.xpath("//div[contains(text(),'User  has been successfully assigned/Updated to Program/Batch(es)')]");

	private By itemlist = By.xpath("//ul[contains(@class,'p-dropdown')]/p-dropdownitem/li/span");
	
	public AssignStaffDetailsPage(WebDriver driver) {
		this.driver = driver;
		this.util = new ElementUtil(driver);
	}
	
	/*public void selectStaffEmailUsingAction() throws InterruptedException {
		util.doClick(staffEmailDropDownIcon);
		Thread.sleep(3000);
		util.pressdownArrowButtonUsingAction();
		util.pressEnterButtonUsingAction();
	}
	
	public void selectProgramNameUsingAction() throws InterruptedException {
		util.doClick(programNameDropDownIcon);
		Thread.sleep(3000);
		util.pressdownArrowButtonUsingAction();
		util.pressEnterButtonUsingAction();
	}
	
	public void selectBatchNameUsingAction() throws InterruptedException {
		util.doClick(batchNameDropDownIcon);
		Thread.sleep(5000);
		util.pressdownArrowButtonUsingAction();
		util.pressEnterButtonUsingAction();
	}
	
	*/
	
	public void selectStaffEmailOption(String optionText) {
		util.doClick(staffEmailDropDownIcon);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(util.isElementDisplayed(By.xpath("//ul[@role='listbox']/.."))) {	
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
			util.doClick(By.xpath("//p-dropdownitem/li/span[text()='"+optionText+"']"));
			//util.doClick(By.xpath("//li[@aria-label='"+optionText+"']"));

		}
	}
	
	public void selectProgramNameOption(String optionText) {
		util.doClick(programNameDropDownIcon);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(util.isElementDisplayed(By.xpath("//ul[@role='listbox']/.."))) {	
			util.doClick(By.xpath("//p-dropdownitem/li/span[text()='"+optionText+"']"));
		}
	}
	
	public void selectBatchNameOption(String optionText) {
		util.doClick(batchNameDropDownIcon);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(util.isElementDisplayed(By.xpath("//ul[@role='listbox']/.."))) {	
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			util.doClick(By.xpath("//li[@aria-label='"+optionText+"']//div[@class='p-checkbox-box']"));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			util.doClick(By.className("p-multiselect-close-icon"));
		}
	}
	
	public void enterStaffSkill(String optionText) {
		util.doSendKeys(skillfield_staff, optionText);
	}
	
	
	public ManageUserPage fillUpAssignStaffDetailsForm(String staffEmail, String skill, String programName, String batchName, String activeOrInactive, String saveOrCancelOrClose) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectStaffEmailOption(staffEmail);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		enterStaffSkill(skill);
		//util.doSendKeys(skillfield_staff, "Ctrl+Clear");
		//util.doSendKeys(skillfield_staff, skill);
		
		selectProgramNameOption(programName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectBatchNameOption(batchName);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*try {
			selectStaffEmailUsingAction();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		enterStaffSkill(skill);
		
		try {
			selectProgramNameUsingAction();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			selectBatchNameUsingAction();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		switch (activeOrInactive.trim().toLowerCase()) {
		case "active":

			util.doClick(ActiveStatus_staff);
			break;

		case "inactive":
			
			util.doClick(InactiveStatus_staff);
			break;

		default:
			System.out.println("No radio button selected");
		}

		switch (saveOrCancelOrClose.trim().toLowerCase()) {
		case "save":
			util.doClick(save_staff);
			break;
		case "cancel":
			util.doClick(Cancel_staff);
			break;
		case "close":
			util.doClick(staffcloseButton);
			break;
		default:
			System.out.println("No Save/Cancel/Close button");
		}

		return new ManageUserPage(driver);
		
	}

	
	public String getHeaderText() {
		if (util.isElementDisplayed(AssignStaffDetailsHeaderText)) {
			return util.getElementText(AssignStaffDetailsHeaderText);
		} else
			return null;
	}
	
	public Boolean isUserRoleFieldPresent() {
		return util.isElementDisplayed(userRolefield_staff);
	}
	
	public Boolean isStaffEmailIdFieldPresent() {
		return util.isElementDisplayed(staffEmailfield_staff);
	}
	
	public Boolean isSkillFieldEmpty() {
		if (util.isElementDisplayed(skillfield_staff) && util.getElementText(skillfield_staff).isEmpty()) {
			return true;
		} else
			return false;
	}
	
	public Boolean isProgramNameFieldPresent() {
		return util.isElementDisplayed(programNamefield_staff);
	}
	
	public Boolean isBatchNameFieldPresent() {
		return util.isElementDisplayed(batchNamefield_staff);
	}
	
	public Boolean isActiveBoxExists() {
		return util.isElementDisplayed(ActiveStatus_staff);
	}
	
	public Boolean isInActiveBoxExists() {
		return util.isElementDisplayed(InactiveStatus_staff);
	}
	
	public Boolean isSaveButtonPresent() {
		return util.isElementDisplayed(save_staff);
	}
	
	public Boolean isCancelButtonPresent() {
		return util.isElementDisplayed(Cancel_staff);
	}
	
	public Boolean isCloseButtonPresent() {
		return util.isElementDisplayed(staffcloseButton);
	}
	
	public String getSuccessMessageText() {
		String message = util.getElementText(AssignStaff_SuccessMessage);
		System.out.println("Actual message appeared on the screen is: " + message);
		return message;
	}
}
