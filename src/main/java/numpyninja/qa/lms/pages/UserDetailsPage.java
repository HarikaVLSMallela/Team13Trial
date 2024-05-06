package numpyninja.qa.lms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import numpyninja.qa.lms.utils.ElementUtil;

public class UserDetailsPage {

	private WebDriver driver;

	private ElementUtil util;

	private By userDetailsHeaderText = By.xpath("//span[contains(text(),'User Details')]");
	private By userDetails_Emptyform = By
			.xpath("//form[@class='ng-untouched ng-pristine ng-invalid ng-star-inserted']");
	// pr_id_178-label
	private By firstNamefield_User = By.xpath("//input[@data-placeholder='First name']");
	private By middleNamefield_User = By.xpath("//input[@data-placeholder='Middle name']");
	private By lastNamefield_User = By.xpath("//input[@data-placeholder='Last name']");
	private By locationfield_User = By.xpath("//input[@data-placeholder='Location']");
	private By phoneNofield_User = By.xpath("//input[@data-placeholder='Phone no']");
	private By linkedInUrlfield_User = By.xpath("//input[@data-placeholder='LinkedIn Url']");

	private By userRolefield_User = By.xpath("//*[@id='roleId']");
	private By userRoleDropdownIcon = By.xpath("//*[@id='roleId']//div[@role='button']");

	private By roleStatusfield_User = By.xpath("//*[@id='userRoleStatus']");
	private By roleStatusDropdownIcon = By.xpath("//*[@id='userRoleStatus']//div[@role='button']");

	private By visaStatusfield_User = By.xpath("//*[@id='userVisaStatus']");
	private By visaStatusfieldDropdownIcon = By.xpath("//*[@id='userVisaStatus']//div[@role='button']");

	private By emailfield_User = By.xpath("//input[@data-placeholder='Email address']");
	private By underGraduatefield_User = By.xpath("//input[@data-placeholder='Under Graduate']");
	private By postGraduatefield_User = By.xpath("//input[@data-placeholder='Post Graduate']");
	private By timeZonefield_User = By.xpath("//input[@data-placeholder='Time Zone']");
	private By userCommentsfield_User = By.xpath("//input[@data-placeholder='User Comments']");

	private By Cancel_user = By.xpath("//span[text()='Cancel']");
	private By submit_user = By.xpath("//span[text()='Submit']");
	private By UsercloseButton = By.xpath("//button[@tabindex='-1']");

	public UserDetailsPage(WebDriver driver) {
		this.driver = driver;
		this.util = new ElementUtil(driver);
	}

	public ManageUserPage fillUpUserDetailsForm(String firstName, String middleName, String lastName, String location,
			String phoneNo, String linkedInUrl, String userRoleOption, String roleStatusOption, String visaStatusOption,
			String email, String underGraduate, String postGraduate, String timeZone, String userComments,
			String submitOrCancelOrClose) throws InterruptedException {

		util.doSendKeys(firstNamefield_User, firstName);
		util.doSendKeys(middleNamefield_User, middleName);
		util.doSendKeys(lastNamefield_User, lastName);
		util.doSendKeys(locationfield_User, location);
		util.doSendKeys(phoneNofield_User, phoneNo);
		util.doSendKeys(linkedInUrlfield_User, linkedInUrl);
		util.doSendKeys(emailfield_User, email);
		util.doSendKeys(underGraduatefield_User, underGraduate);
		util.doSendKeys(postGraduatefield_User, postGraduate);
		util.doSendKeys(timeZonefield_User, timeZone);
		util.doSendKeys(userCommentsfield_User, userComments);

		selectUserRoleOption(userRoleOption);
		selectUserRoleStatusOption(roleStatusOption);
		selectUserVisaStatusOption(visaStatusOption);

		Thread.sleep(1000);
		util.scrollToBottomOfPage();

		switch (submitOrCancelOrClose.trim().toLowerCase()) {
		case "submit":
			util.doClick(submit_user);
			break;
		case "cancel":
			util.doClick(Cancel_user);
			break;
		case "close":
			util.doClick(UsercloseButton);
			break;
		default:
			System.out.println("No Submit/Cancel/Close button");
		}

		return new ManageUserPage(driver);

	}

	public void selectUserRoleOption(String optionText) {
		util.doClick(userRoleDropdownIcon);

		if (util.isElementDisplayed(By.className("p-dropdown-panel"))) {
			util.doClick(By.xpath("//p-dropdownitem/li/span[text()='" + optionText + "']"));
		}
	}

	public void selectUserRoleStatusOption(String optionText) {
		util.doClick(roleStatusDropdownIcon);

		if (util.isElementDisplayed(By.className("p-dropdown-items"))) {
			util.doClick(By.xpath("//p-dropdownitem/li/span[text()='" + optionText + "']"));
		}
	}

	public void selectUserVisaStatusOption(String optionText) {
		util.doClick(visaStatusfieldDropdownIcon);

		if (util.isElementDisplayed(By.className("p-dropdown-panel"))) {
			util.doClick(By.xpath("//p-dropdownitem/li/span[text()='" + optionText + "']"));
		}
	}

	public ManageUserPage EditUserForEnteredTextInSearchBox(String lastName, String location, String email,
			String submitOrCancelOrClose) {
		isFirstNameFieldNotEmpty();
		util.doSendKeys(lastNamefield_User, lastName);
		util.doSendKeys(locationfield_User, location);
		util.doSendKeys(emailfield_User, email);

		switch (submitOrCancelOrClose.trim().toLowerCase()) {
		case "submit":
			util.doClick(submit_user);
			break;
		case "cancel":
			util.doClick(Cancel_user);
			break;
		case "close":
			util.doClick(UsercloseButton);
			break;
		default:
			System.out.println("No Submit/Cancel/Close button");
		}

		return new ManageUserPage(driver);
	}

	public Boolean isFirstNameFieldNotEmpty() {
		boolean flag = util.getElementText(firstNamefield_User).isEmpty();
		if (util.isElementDisplayed(firstNamefield_User) && !flag) {
			System.out.println("User First Name field is Not empty");
			return true;
		} else
			return false;
	}

	/*
	 * public void getFirstNameEditBoxText() { boolean
	 * if(util.getElementText(firstNamefield_User).isEmpty()) {
	 * 
	 * }
	 */

	public String getHeaderText() {
		if (util.isElementDisplayed(userDetailsHeaderText)) {
			return util.getElementText(userDetailsHeaderText);
		} else
			return null;
	}

	public Boolean isFirstNameFieldEmpty() {
		if (util.isElementDisplayed(firstNamefield_User) && util.getElementText(firstNamefield_User).isEmpty()) {
			System.out.println("User First Name field is empty");
			return true;
		} else
			return false;
	}

	public Boolean isMiddleNameFieldEmpty() {
		if (util.isElementDisplayed(middleNamefield_User) && util.getElementText(middleNamefield_User).isEmpty()) {
			System.out.println("User Middle Name field is empty");
			return true;
		} else
			return false;
	}

	public Boolean isLastNameFieldEmpty() {
		if (util.isElementDisplayed(lastNamefield_User) && util.getElementText(lastNamefield_User).isEmpty()) {
			System.out.println("User Last Name field is empty");
			return true;
		} else
			return false;
	}

	public Boolean isLocationFieldEmpty() {
		if (util.isElementDisplayed(locationfield_User) && util.getElementText(locationfield_User).isEmpty()) {
			System.out.println("User Location field is empty");
			return true;
		} else
			return false;
	}

	public Boolean isPhoneNoFieldEmpty() {
		if (util.isElementDisplayed(phoneNofield_User) && util.getElementText(phoneNofield_User).isEmpty()) {
			System.out.println("User Phone field is empty");
			return true;
		} else
			return false;
	}

	public Boolean isLinkedinUrlFieldEmpty() {
		if (util.isElementDisplayed(linkedInUrlfield_User) && util.getElementText(linkedInUrlfield_User).isEmpty()) {
			System.out.println("User LinkedIn Url field is empty");
			return true;
		} else
			return false;
	}

	public Boolean isEmailFieldEmpty() {
		if (util.isElementDisplayed(emailfield_User) && util.getElementText(emailfield_User).isEmpty()) {
			System.out.println("User Email field is empty");
			return true;
		} else
			return false;
	}

	public Boolean isUnderGraduateFieldEmpty() {
		if (util.isElementDisplayed(underGraduatefield_User)
				&& util.getElementText(underGraduatefield_User).isEmpty()) {
			System.out.println("User Under Graduate field is empty");
			return true;
		} else
			return false;
	}

	public Boolean isPostGraduateFieldEmpty() {
		if (util.isElementDisplayed(postGraduatefield_User) && util.getElementText(postGraduatefield_User).isEmpty()) {
			System.out.println("User Post Graduate field is empty");
			return true;
		} else
			return false;
	}

	public Boolean isTimeZoneFieldEmpty() {
		if (util.isElementDisplayed(timeZonefield_User) && util.getElementText(timeZonefield_User).isEmpty()) {
			System.out.println("User Time Zone field is empty");
			return true;
		} else
			return false;
	}

	public Boolean isUserCommentsFieldEmpty() {
		if (util.isElementDisplayed(userCommentsfield_User) && util.getElementText(userCommentsfield_User).isEmpty()) {
			System.out.println("User Comments field is empty");
			return true;
		} else
			return false;
	}

	public Boolean isUserRoleFieldPresent() {
		return util.isElementDisplayed(userRolefield_User);
	}

	public Boolean isUserRoleStatusFieldPresent() {
		return util.isElementDisplayed(roleStatusfield_User);
	}

	public Boolean isVisaStatusFieldPresent() {
		return util.isElementDisplayed(visaStatusfield_User);
	}

	public Boolean isSubmitButtonPresent() {
		return util.isElementDisplayed(submit_user);
	}

	public Boolean isCancelUserButtonPresent() {
		return util.isElementDisplayed(Cancel_user);
	}

	public Boolean isUserCloseButtonPresent() {
		return util.isElementDisplayed(UsercloseButton);
	}

	public void enterFirstName(String FirstName) {
		util.doSendKeys(firstNamefield_User, FirstName);

	}
}
