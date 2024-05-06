package numpyninja.qa.lms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import numpyninja.qa.lms.utils.ElementUtil;

public class HomePage {

	private WebDriver driver;
	private ElementUtil util;

	private By loginPageHeaderText = By.xpath("//form/p");
	private By invalidCredentialErrMsg = By.id("errormessage");
	private By emailId = By.id("username");
	private By passwordBox = By.id("password");
	private By submitBtn = By.id("login");

	private By nullEmailIdErrMsg = By.id("mat-error-0");
	private By nullPasswordErrMsg = By.id("mat-error-1");
	
	private By textFields = By.className("cdk-text-field-autofill-monitored");


	// 2.public constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.util = new ElementUtil(driver);
	}

	// 3.public methods
	public String getPageUrl() {
		String pageURL = util.getPageURL();
		return pageURL;
	}

	public Boolean isLoginHeaderTextExist() {
		return util.isElementDisplayed(loginPageHeaderText);
	}
	
	public String getLoginHeaderText() {
		return util.getElementText(loginPageHeaderText);
	}

	public DashboardPage doLogin(String email, String password) {
		
		util.doSendKeys(emailId, email);
		util.doSendKeys(passwordBox, password);
		util.doClick(submitBtn);

		return new DashboardPage(driver);
	}

	public String getNullEmailIdErrMsg() {
		if (util.isElementDisplayed(nullEmailIdErrMsg)) {
			return util.getElementText(nullEmailIdErrMsg);
		} else
			return null;
	}

	public String getNullPasswordErrMsg() {
		if (util.isElementDisplayed(nullPasswordErrMsg)) {
			return util.getElementText(nullPasswordErrMsg);
		} else
			return null;
	}

	public String getInvalidCredentialErrMsg() {
		if (util.isElementDisplayed(invalidCredentialErrMsg)) {
			return util.getElementText(invalidCredentialErrMsg);
		} else
			return null;
	}
	
	public DashboardPage doLoginWithMouseClick(String email, String password) {
		util.doSendKeys(emailId, email);
		util.doSendKeys(passwordBox, password);
		util.mouseclickUsingAction(submitBtn);

		return new DashboardPage(driver);
	}
	
	public DashboardPage doLoginWithPressEnter(String email, String password) {
		util.doSendKeys(emailId, email);
		util.doSendKeys(passwordBox, password);
		util.pressdownButtonUsingAction(submitBtn);

		return new DashboardPage(driver);
	}
	
	public int numberOfTextField() {
		return util.getElementSize(textFields);
	}
	
	public String getTextFieldInnerText(String firstOrSecond) {
		
		if(firstOrSecond.equalsIgnoreCase("first")) {
		 return util.getElements(emailId).get(0).getAttribute("data-placeholder");
		}
		else if(firstOrSecond.equalsIgnoreCase("second")) {
			return util.getElements(emailId).get(1).getAttribute("data-placeholder");
		}
		else {
				return "Please enter 'first' or 'second' as String argument";
		}
	}
	
	public boolean isLoginButtonPresent() {
		return util.isElementDisplayed(submitBtn);
	}
}
