package numpyninja.qa.lms.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import numpyninja.qa.lms.utils.ElementUtil;

public class DashboardPage {
	
	private static WebDriver driver;
	private ElementUtil util;
	

	//private By LMS_Text = By.xpath("//span[normalize-space()='LMS - Learning Management System']");

	private By programMenu = By.xpath("//*[@id='program']");
	private By batchMenu = By.xpath("//button[@id='batch']");
	private By userMenu = By.xpath("//button[@id='user']");
	private By logoutMenu = By.id("logout");
    private By PleaseLogin = By.xpath("//*[contains(text(),'Please login to LMS application')]");
	private By Search = By.xpath("//input[@id='filterGlobal']\")");
	private By HeadingManageBatch = By.xpath("//*[text()=' Manage Batch']"); 
	private By LMS_Heading = By.xpath("//span[text()=' LMS - Learning Management System ']");
	private By ManageProgram_Header = By.xpath("//div[normalize-space()='Manage Program']");
	private By NavigationBar = By.xpath("//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']");
	private By ProgramMenuBar = By.xpath("//span[normalize-space()='Program']");
	private By BatchMenuBar = By.xpath("//button[@id='batch']");
	private By UserMenuBar =  By.xpath("//button[@id='user']");
	private By LogoutMenuBar = By.id("logout");
	
	
	
	public  DashboardPage(WebDriver driver) {
		DashboardPage.driver = driver;
		this.util = new ElementUtil(driver);
	}
	
	
	public Boolean FirstPlaceProgram() {
		return util.isElementDisplayed(ProgramMenuBar);
	}
	
	public Boolean SecondPlaceBatch() {
		return util.isElementDisplayed(BatchMenuBar);
	}
	
	public Boolean ThirdPlaceUser() {
		return util.isElementDisplayed(UserMenuBar);
	}
	
	public Boolean ForthPlaceLogout() {
		return util.isElementDisplayed(LogoutMenuBar);
	}
	public boolean isLogoutMenuExist() {
		return util.isElementDisplayed(logoutMenu);
	}
	
	
	public ManageProgramPage clickProgramMenu() {
		util.goToProgramMenu();
		//util.doClick(programMenu);
		//util.clickElementByJS(programMenu, driver);
		return new ManageProgramPage(driver);	
	}
	
	public Boolean LMS_Heading() {
		return util.isElementDisplayed(LMS_Heading);
	}
	
	public ManageBatchPage clickBatchMenu() {
		util.doClick(batchMenu);
		return new ManageBatchPage(driver);	
	}
	
	public ManageUserPage clickUserMenu() {
		util.doClick(userMenu);
		return new ManageUserPage(driver);	
	}
	
	public HomePage clickLogoutMenu() {
		util.doClick(logoutMenu);
		return new HomePage(driver);	
	}
	
	
	public boolean ManageProgramHeader() {
		return util.isElementDisplayed(ManageProgram_Header);
	}
	
	public boolean IsBatchdisplay() {
		return util.isElementDisplayed(HeadingManageBatch);
	}
	
	
	public boolean IsNavigationBardisplay() {
		return util.isElementDisplayed(NavigationBar);
	}
	
	public boolean LoginHeader() {
		return util.isElementDisplayed(PleaseLogin);
	}
	
	public boolean IsUserDisplay() {
		return util.isElementDisplayed(userMenu);
	
	
	}
	public void ClickSearch() {
		
		util.doClick(Search);
	}
	
	
	/*
	 * public String Firstplace() { String ExpectedProgram = "Program"; WebElement
	 * ActualProgram = driver.findElement(programMenu);
	 * Assert.assertEquals(ActualProgram, ExpectedProgram); return ExpectedProgram;
	 * 
	 * }
	 * 
	 * public String Secondplace() { String ExpectedBatch = "Batch"; WebElement
	 * ActualBatch = driver.findElement(batchMenu); Assert.assertEquals(ActualBatch,
	 * ExpectedBatch); return ExpectedBatch;
	 * 
	 * }
	 * 
	 * public String Thirdplace() { String ExpectedUser = "User"; WebElement
	 * ActualUser = driver.findElement(userMenu); Assert.assertEquals(ActualUser,
	 * ExpectedUser); return ExpectedUser;
	 * 
	 * }
	 * 
	 * public String ForthPlace() { String ExpectedLogout = "Logout"; WebElement
	 * ActualLogout = driver.findElement(batchMenu);
	 * Assert.assertEquals(ActualLogout, ExpectedLogout); return ExpectedLogout;
	 * 
	 * 
	 * }
	 */
	
}
