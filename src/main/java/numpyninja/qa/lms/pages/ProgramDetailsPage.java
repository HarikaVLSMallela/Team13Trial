package numpyninja.qa.lms.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import numpyninja.qa.lms.utils.ElementUtil;

public class ProgramDetailsPage {

	private WebDriver driver;
	private ElementUtil util;
	
	//Header
	private By headerText = By.xpath("//span[contains(text(),'Program Details')]");
	
	//Name edit field
	private By textField_NameLabel = By.xpath("//label[text()='Name']");
	private By Namefield_Program = By.xpath("//input[@id='programName']");
	
	//Description edit field
	private By textField_DescriptionLabel = By.xpath("//label[text()='Description']");
	private By Description_Program = By.xpath("//input[@id='programDescription']");
	
	//Radio Buttons
	private By Active = By.xpath("(//span[@class='p-radiobutton-icon'])[1]/..");
	private By Inactive = By.xpath("(//span[@class='p-radiobutton-icon'])[2]/..");
	
	//Save, Cancel, Close Btns
	private By cancelButton = By.xpath("//span[text()='Cancel']");
	private By saveButton = By.xpath("//span[text()='Save']");
	private By closeButton = By.xpath("//button[@tabindex='-1']");
	
	//Error Msg xpaths
	private By errorList = By.tagName("small");
	private By invalidDataerrormsg_ProgName = By.xpath("//label[@for='programName']/following-sibling::small");
	private By invalidDataerrormsg_ProgDesc = By.xpath("//label[@for='programDescription']/following-sibling::small");	
	
	
	
	public ProgramDetailsPage(WebDriver driver) {
		this.driver = driver;
		this.util = new ElementUtil(driver);
	}

	//************************* Element Present And Get Header Text Function *********************

	public boolean isNameFieldExist() {
		return util.isElementDisplayed(Namefield_Program);
	}

	public boolean isTextLabelNameExist() {
		return util.isElementDisplayed(textField_NameLabel);
	}
	
	public boolean isDescriptionFieldExists() {
		return util.isElementDisplayed(Description_Program);

	}
	
	public boolean isTextLabelDescriptionExist() {
		return util.isElementDisplayed(textField_DescriptionLabel);
	}
	
	public boolean isActiveRadioButtonDisplayed() {
		return util.isElementDisplayed(Active);
	}
	
	public boolean isInActiveRadioButtonDisplayed() {
		return util.isElementDisplayed(Inactive);
	}
	
	
	public Boolean isSaveButtonPresent() {
		return util.isElementDisplayed(saveButton);
	}

	public Boolean isCancelButtonPresent() {
		return util.isElementDisplayed(cancelButton);
	}

	public Boolean isCloseButtonPresent() {
		return util.isElementDisplayed(closeButton);
	}

	public boolean doesHeaderExist() {
		return util.isElementDisplayed(headerText);
	}

	
	public ManageProgramPage SaveProgram() {
		util.doClick(saveButton);
		return new ManageProgramPage(driver);
	}
	
	public ManageProgramPage cancelProgram() {
		util.doClick(cancelButton);
		return new ManageProgramPage(driver);
	}
	
	

	public String getHeaderText() {
		if (doesHeaderExist()) {
			return util.getElementText(headerText);
		} else
			return null;
	}
	
	//************************* Edit Box Empty Function *********************

	public Boolean isNameFieldEmpty() {
		if (util.isElementDisplayed(Namefield_Program) && util.getElementText(Namefield_Program).isEmpty()) {
			System.out.println("Program Name field is empty");
			return true;
		} else
			return false;
	}

	public Boolean isDescriptionFieldEmpty() {
		if (util.isElementDisplayed(Description_Program) && util.getElementText(Description_Program).isEmpty()) {
			System.out.println("Program Description field is empty");
			return true;
		} else
			return false;
	}
	
	//************************* Edit Box Empty Function *********************

	public void enterTextInField(String fieldName, String value) {
		
		switch (fieldName.trim().toLowerCase()) {
		case "name":
			util.doSendKeys(Namefield_Program, value);
			break;
		case "description":
			util.doSendKeys(Description_Program, value);
			break;
		default:
			break;
		}
	}
	
	public void selectActiveInactiveRadioButton(String radioBtnName) {
		
		switch (radioBtnName.trim().toLowerCase()) {
		case "active":
			util.doClick(Active);
			break;
		case "inactive":
			util.doClick(Inactive);
			break;
		default:
			break;
		}
		 
	}
	
	
	
	public ManageProgramPage fillUpProgramDetailsForm(String name, String description, String activeOrInactive, String saveOrCancelOrClose) {

		util.doSendKeys(Namefield_Program, name);
		util.doSendKeys(Description_Program, description);

		switch (activeOrInactive.trim().toLowerCase()) {
		case "active":

			util.doClick(Active);
			break;

		case "inactive":
			
			util.doClick(Inactive);
			break;

		default:
			System.out.println("No radio button selected");
		}

		switch (saveOrCancelOrClose.trim().toLowerCase()) {
		case "save":
			util.doClick(saveButton);
			break;
		case "cancel":
			util.doClick(cancelButton);
			break;
		case "close":
			util.doClick(closeButton);
			break;
		default:
			System.out.println("No Save/Cancel/Close button clicked");
		}

		return new ManageProgramPage(driver);

	}





	/*
	 * public Boolean areRadioButtonsUnselected() { int count =
	 * util.getElementSize(uncheckedRadioButtonStatus); if(count==0 &&
	 * util.isElementDisplayed(Active) && util.isElementDisplayed(Inactive)) {
	 * System.out.println("Radio buttons are present and unselected"); return true;
	 * } else return false; }
	 */

	
	//************************* Error Msg Function *********************
	
	
	public HashMap<String, String> getErrorMsgs() {
	
		  HashMap<String, String> map = new HashMap<>(); 
		  StringBuffer buffer = new StringBuffer(""); 
		  
		  List<WebElement> errList = util.getElements(errorList);
		  
		  for(WebElement ele:errList) { 
			  if(ele.getText().contains("Description")) {
				  map.put("descriptionError", ele.getText()); 
			  } 
			  else if(ele.getText().contains("Status")) { 
				  map.put("statusError", ele.getText());
			  } 			 			   
			  else if(ele.getText().contains("Program") || ele.getText().contains("special char")){
				 buffer.append(ele.getText()); 		  
			  }
		  
		  map.put("nameError", buffer.toString()); 
		  }
		  
		  return map;	 
	}
	

	
	public String invalidDataErrMsg(String fieldName) {
		String msg = null;
		
		switch (fieldName.trim().toLowerCase()) {
		
		case "name":
			
			if(util.isElementDisplayed(invalidDataerrormsg_ProgName)) {
				return util.getElementText(invalidDataerrormsg_ProgName);
			}
			else { System.out.println("Err msg for Program Name not displayed");
			}
			break;
			
		case "description":
			
			if(util.isElementDisplayed(invalidDataerrormsg_ProgDesc)) {
				return util.getElementText(invalidDataerrormsg_ProgDesc);
			}
			else {
				System.out.println("Err msg for Program Description not displayed");
			}
			break;


		default:
			System.out.println("Plz enter edit box name correctly");
			break;
		}
		
		return msg;


	}
}

