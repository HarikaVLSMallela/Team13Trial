package numpyninja.qa.lms.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import numpyninja.qa.lms.utils.ElementUtil;

public class ManageUserPage {

	private WebDriver driver;
	private ElementUtil util;

	// Page Header section
	private By ManageUserButton = By.xpath("//div[contains(text(),\" Manage User\")]");
	private By AddNewUserButton = By.xpath("//span[contains(text(),'Add New User')]");
	private By AssignStudentButton = By.xpath("//span[contains(text(),'Assign Student')]");
	private By AssignStaffButton = By.xpath("//span[contains(text(),\"Assign Staff\")]");
	private By SearchBox = By.xpath("//input[@id='filterGlobal']");

	private By TextWithPaginationIcon = By
			.xpath("//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']/span[1]");

	private By DeleteButton_TopLeft = By.xpath("//div/button[@icon='pi pi-trash']");

	// private By EditButton = By.xpath("//span[@class='p-button-icon pi
	// pi-pencil']");
	private By sideeditIcon = By.xpath("//span[@class='p-button-icon pi pi-pencil']");
	private By sidedeleteIcon = By.xpath("(//td//span[@class='p-button-icon pi pi-trash'])");
	// private By DeleteButton = By.xpath("//button[@class='p-button-rounded
	// p-button-danger p-button p-component
	// p-button-icon-only']//span[@class='p-button-icon pi pi-trash']");

	// Table header sections - Column Names
	private By IDColumn = By.xpath("//*[@psortablecolumn='userId']");
	private By UserNameColumn = By.xpath("//*[@psortablecolumn='userFirstName']");
	private By LocationColumn = By.xpath("//*[@psortablecolumn='userLocation']");
	private By PhoneColumn = By.xpath("//*[@psortablecolumn='userPhoneNumber']");
	private By checkBoxColumn = By.xpath("//div[@class ='p-checkbox-box']");

	// Table header section - Column Sort Icons
	private By IDSortIcon = By.xpath("//*[@psortablecolumn='userId']//i");
	private By UserNameSortIcon = By.xpath("//*[@psortablecolumn='userFirstName']//i");
	private By LocationSortIcon = By.xpath("//*[@psortablecolumn='userLocation']//i");
	private By PhoneSortIcon = By.xpath("//*[@psortablecolumn='userPhoneNumber']//i");

	// Table Body section
	private By rowList = By.xpath("//tbody/tr");
	private By rowDeleteBtnList = By.xpath("(//td//span[@class='p-button-icon pi pi-trash'])");
	private By rowEditBtnList = By.xpath("//span[@class='p-button-icon pi pi-pencil']");
	private By rowIDList = By.xpath("//*[@class='p-datatable-tbody']//tr/td[2]");
	private By rowNameList = By.xpath("//*[@class='p-datatable-tbody']//tr/td[3]");
	private By rowLocationList = By.xpath("//*[@class='p-datatable-tbody']//tr/td[4]");
	private By rowPhoneList = By.xpath("//*[@class='p-datatable-tbody']//tr/td[4]");

	private By checkboxList = By.xpath("//*[@class='p-datatable-tbody']//tr/td[1]//div[@role='checkbox']");

	private By tableRows = By.xpath("//*[@class='p-datatable-tbody']/tr");
	private By tableHeadCols = By.xpath("//thead//th");
	private By tableCheckboxes = By.xpath("//*[@class='p-datatable-tbody']/tr/td[1]//div[@role='checkbox']");

	// private By addProgramSuccessMsg = By.xpath("//div[@role='alert']");
	private By successfulMsg = By.className("'p-toast-message-text");
	private By programCreatedMsg = By.className("p-toast-detail");

	// Pagination section
	private By paginationEntryInfo = By.className("p-paginator-current");
	private By firstPageIcon = By.className("p-paginator-first");
	private By previousPageIcon = By.className("p-paginator-prev");
	private By nextPageIcon = By.className("p-paginator-next");
	private By lastPageIcon = By.className("p-paginator-last");

	public ManageUserPage(WebDriver driver) {
		this.driver = driver;
		this.util = new ElementUtil(driver);
	}

	public String getSearchBoxText() {
		if (util.isElementDisplayed(SearchBox)) {
			return util.getAttributeVal(SearchBox, "placeholder");
		} else
			return "SearchBox was not found in Manage Program Page";
	}

	public void enterTextInSearchBox(String searchText) {
		util.doSendKeys(SearchBox, searchText);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getPageUrl() {
		return util.getPageURL();
	}

	public boolean isManagerUserHeaderExist() {
		return util.isElementDisplayed(ManageUserButton);
	}

	public String getTextwithPaginationIcon() {
		return util.getElementText(TextWithPaginationIcon);
	}

	public List<String> getTableColNames() {
		List<WebElement> colHeads = util.getElements(tableHeadCols);
		List<String> colHeadText = null;
		for (int i = 1; i <= colHeads.size(); i++) {
			colHeadText.add(colHeads.get(i).getText());
		}
		return colHeadText;
	}

	public boolean isTopDeleteIconDisabled() {
		return (!util.isElementEnabled(DeleteButton_TopLeft));
	}

	public boolean isAddNewUserButtonExist() {
		return util.isElementDisplayed(ManageUserButton);
	}

	public boolean isAssignStudenetButtonExist() {
		return util.isElementDisplayed(AssignStudentButton);
	}

	public boolean isAssignStaffButtonExist() {
		return util.isElementDisplayed(AssignStaffButton);
	}

	public boolean isEditIconExist() {
		return util.isElementDisplayed(sideeditIcon);
	}

	public boolean isDeleteIconExist() {
		return util.isElementDisplayed(sidedeleteIcon);
	}

	public boolean isSearchBoxExist() {
		return util.isElementDisplayed(SearchBox);
	}

	public int getNumberOfRecordsDisplayed() {
		return util.getElementSize(tableRows);

	}

	public boolean matchRecordNumberWithCheckbox() {
		int rowCountInCurrentTable = getNumberOfRecordsDisplayed();
		int checkboxCountInCurrentTable = util.getElementSize(tableCheckboxes);

		if (rowCountInCurrentTable == checkboxCountInCurrentTable) {
			return true;
		} else
			return false;
	}

	public UserDetailsPage clickAddNewUserButton() {

		util.doClick(AddNewUserButton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new UserDetailsPage(driver);
	}

	public AssignStaffDetailsPage clickAssignStaffButton() {
		util.doClick(AssignStaffButton);
		return new AssignStaffDetailsPage(driver);
	}

	// work on it later
	public UserDetailsPage clickEditIcon() {
		util.doClick(sideeditIcon);
		return new UserDetailsPage(driver);
	}

	/*
	 * public AssignStaffDetailsPage clickDeleteIcon() {
	 * util.doClick(AssignStaffButton); return new AssignStaffDetailsPage(driver); }
	 */

	/*
	 * public boolean isUserDataTableExist() { List<WebElement> userDataTable =
	 * util.getElements(By.xpath("//tr[@class='ng-star-inserted']")); return
	 * util.isElementDisplayed(userDataTable); }
	 */

	// ************************ Table Header Element Related Functions
	// ****************

	/**
	 * This method clicks on sort icon for a given column name and sorting order
	 * 
	 * @param columnName
	 * @param ascendingOrDescending
	 */
	public void clickSortIcon(String columnName, String ascendingOrDescending) {
		String colName = columnName.trim().toLowerCase();
		switch (colName) {
		case "id":
			if (ascendingOrDescending.trim().equalsIgnoreCase("ascending")) {
				util.doClick(IDSortIcon);
			} else if (ascendingOrDescending.trim().equalsIgnoreCase("descending")) {
				util.doClick(IDSortIcon);
				util.doClick(IDSortIcon);
			} else {
				System.out.println("Pass 'ascending' or 'descending' for sorting order");
			}
			break;

		case "name":
			if (ascendingOrDescending.trim().equalsIgnoreCase("ascending")) {
				util.doClick(UserNameSortIcon);
			} else if (ascendingOrDescending.trim().equalsIgnoreCase("descending")) {
				util.doClick(UserNameSortIcon);
				util.doClick(UserNameSortIcon);
			} else {
				System.out.println("Pass 'ascending' or 'descending' for sorting order");
			}
			break;

		case "location":
			if (ascendingOrDescending.trim().equalsIgnoreCase("ascending")) {
				util.doClick(LocationSortIcon);
			} else if (ascendingOrDescending.trim().equalsIgnoreCase("descending")) {
				util.doClick(LocationSortIcon);
				util.doClick(LocationSortIcon);
			} else {
				System.out.println("Pass 'ascending' or 'descending' for sorting order");
			}
			break;

		case "phone number":
			if (ascendingOrDescending.trim().equalsIgnoreCase("ascending")) {
				util.doClick(PhoneSortIcon);
			} else if (ascendingOrDescending.trim().equalsIgnoreCase("descending")) {
				util.doClick(PhoneSortIcon);
				util.doClick(PhoneSortIcon);
			} else {
				System.out.println("Pass 'ascending' or 'descending' for sorting order");
			}
			break;

		default:
			System.out.println("Please pass column name properly");
			break;
		}
	}

	public String getUserAddSuccessMsg() {
		return (util.getElementText(successfulMsg)) + " " + (util.getElementText(programCreatedMsg));
	}

	
	 public AssignStudentDetailsPage clickAssignStudentButton() {
	  util.doClick(AssignStudentButton); 
	  return new AssignStudentDetailsPage(driver); 
	  }
	  
	/*
	 * public boolean isUserDataTableExist() { List<WebElement> userDataTable =
	 * util.getElements(By.xpath("//tr[@class='ng-star-inserted']")); return
	 * util.isElementDisplayed(userDataTable); }
	 */
	  
	  
	  
	  
	  // public String getUserAddSuccessMsg() { // return (util.get) + " " +
	 // (util.getElementText(programCreatedMsg)); // }
	  
	 
	public HashMap<String, String> isAddedOrEditedUserRecordVisible(String userName) {

		HashMap<String, String> map = null;

		String user = userName;
		String text = util.getElementText(By.className("p-paginator-bottom"));

		String[] arr = text.split(" ");
		int denominator = Integer.parseInt(arr[3]);
		int numerator = Integer.parseInt(arr[5]);

		float ceil = (float) numerator / (float) denominator;

		int totalNumberOfPages = (int) Math.ceil(ceil);
		List<WebElement> ele = util.getElements(By.xpath("//td[text()='" + user + "']"));

		forloop: for (int i = 1; i <= totalNumberOfPages; i++) {

			util.doClick(By.xpath("//button[text()='" + i + "']"));
			System.out.println("Clicked on Page " + i);

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			ele = util.getElements(By.xpath("//td[text()='" + user + "']"));

			if (ele.size() == 1) {
				System.out.println(user + " is found on page = " + i);
				List<WebElement> recordElements = util.getElements(By.xpath("//*[text()='" + user + "']/../td"));// size
																													// is
																													// 6(0=checkbox,5th=edit/delete
																													// buttons)

				map = new HashMap<>();
				map.put("UserId", recordElements.get(1).getText());
				map.put("FullName", recordElements.get(2).getText());
				map.put("Location", recordElements.get(3).getText());
				map.put("PhoneNo", recordElements.get(4).getText());

				// System.out.println(Arrays.asList(map));

				break forloop;
			} else {
				System.out.println(user + " is not found on Page = " + i);

			}
		}

		return map;
	}

	public void clickEditButtonOfUser(String userName) {

		String user = userName;
		String text = util.getElementText(By.className("p-paginator-bottom"));

		String[] arr = text.split(" ");
		int denominator = Integer.parseInt(arr[3]);
		int numerator = Integer.parseInt(arr[5]);
		float ceil = (float) numerator / (float) denominator;

		int totalNumberOfPages = (int) Math.ceil(ceil);

		List<WebElement> ele = util.getElements(By.xpath("//td[text()='" + user + "']"));

		forloop: for (int i = 1; i <= totalNumberOfPages; i++) {

			util.doClick(By.xpath("//button[text()='" + i + "']"));
			System.out.println("Clicked on Page " + i);

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			ele = util.getElements(By.xpath("//td[text()='" + user + "']"));

			if (ele.size() == 1) {
				System.out.println(user + " is found on page = " + i);
				util.doClick(By.xpath("//*[text()='" + user + "']/../td[6]//button[@icon='pi pi-pencil']"));

				break forloop;
			} else {
				System.out.println(user + " is not found on Page = " + i);

			}
		}
	}

	public DeleteUserPage clickDeleteButtonOfUser(String userName) {

		String user = userName;
		String text = util.getElementText(By.className("p-paginator-bottom"));

		String[] arr = text.split(" ");
		int denominator = Integer.parseInt(arr[3]);
		int numerator = Integer.parseInt(arr[5]);

		float ceil = (float) numerator / (float) denominator;

		int totalNumberOfPages = (int) Math.ceil(ceil);
		List<WebElement> ele = util.getElements(By.xpath("//td[text()='" + user + "']"));

		forloop: for (int i = 1; i <= totalNumberOfPages; i++) {

			util.doClick(By.xpath("//button[text()='" + i + "']"));
			System.out.println("Clicked on Page " + i);

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			ele = util.getElements(By.xpath("//td[text()='" + user + "']"));

			if (ele.size() == 1) {
				System.out.println(user + " is found on page = " + i);
				util.doClick(By.xpath("//*[text()='" + user + "']/../td[6]//button[@icon='pi pi-trash']"));

				break forloop;
			} else {
				System.out.println(user + " is not found on Page = " + i);

			}
		}
		return new DeleteUserPage(driver);
	}

	public void selectCheckboxOfProgram(String userName) {

		String user = userName;
		String text = util.getElementText(By.className("p-paginator-bottom"));

		String[] arr = text.split(" ");
		int denominator = Integer.parseInt(arr[3]);
		int numerator = Integer.parseInt(arr[5]);
		float ceil = (float) numerator / (float) denominator;

		int totalNumberOfPages = (int) Math.ceil(ceil);

		List<WebElement> ele = util.getElements(By.xpath("//td[text()='" + user + "']"));

		forloop: for (int i = 1; i <= totalNumberOfPages; i++) {

			util.doClick(By.xpath("//button[text()='" + i + "']"));
			System.out.println("Clicked on Page " + i);

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			ele = util.getElements(By.xpath("//td[text()='" + user + "']"));

			if (ele.size() == 1) {
				System.out.println(user + " is found on page = " + i);
				util.doClick(By.xpath("//*[text()='" + user + "']/../td[1]"));//

				break forloop;
			} else {
				System.out.println(user + " is not found on Page = " + i);

			}
		}
	}

	// ********************* Pagination Functions ***********************

	/**
	 * @return total pagination text section
	 */
	public String getPaginationText() {
		return util.getElementText(paginationEntryInfo);
	}

	/**
	 * This method returns total number of Pages in Manage User Page
	 * 
	 * @return
	 */
	public int getTotalNumberOfPages() {

		String[] arr = getPaginationText().split(" ");
		int denominator = Integer.parseInt(arr[3]);
		int numerator = Integer.parseInt(arr[5]);
		float ceil = (float) numerator / (float) denominator;

		int totalNumberOfPages = (int) Math.ceil(ceil);
		return totalNumberOfPages;
	}

	// ********************* Table Body functions ***********************

	// 1)Check box related:

	/**
	 * This method return number of checkboxes in table in Manage User Page
	 * 
	 * @return count in int
	 */
	public int getCheckboxCount() {
		return util.getElementSize(checkboxList);
	}

	/**
	 * This method enables user to select a checkbox from a given row number
	 * 
	 * @param int rowNumber
	 * @return String corresponding User Name from the given row
	 */
	public String selectCheckboxFromARow(int rowNum) {
		util.getElements(checkboxList).get(rowNum - 1).click();
		return getUserNameFromARow(rowNum);
	}

	// 2)User ID related:

	/**
	 * This method returns the User ID for a given row
	 * 
	 * @param rowNum
	 * @return
	 */
	public String getUserIDFromARow(int rowNum) {
		return util.getElements(rowIDList).get(rowNum - 1).getText();
	}

	// 2)User Name related:

	/**
	 * This method returns the User name for a given row
	 * 
	 * @param rowNum
	 * @return
	 */
	public String getUserNameFromARow(int rowNum) {
		return util.getElements(rowNameList).get(rowNum - 1).getText();
	}

	// 3)Location related:

	/**
	 * This method returns the User Location for a given row
	 * 
	 * @param rowNum
	 * @return
	 */
	public String getLocationFromARow(int rowNum) {
		return util.getElements(rowLocationList).get(rowNum - 1).getText();
	}

	// 4)User Phone related:

	/**
	 * This method returns the User Phone for a given row
	 * 
	 * @param rowNum
	 * @return
	 */
	public String getPhoneFromARow(int rowNum) {
		return util.getElements(rowPhoneList).get(rowNum - 1).getText();
	}

	// 5)Edit/Delete buttons related:

	/**
	 * This method return number of delete or edit button in table in Manage User
	 * Page
	 * 
	 * @param "edit" or "delete"
	 * @return count in int
	 */
	public int getEditOrDeleteBtnCount(String editOrDelete) {

		String btnName = editOrDelete.trim().toLowerCase();
		if (btnName.equals("edit")) {
			return util.getElementSize(rowEditBtnList);
		} else if (btnName.equals("delete")) {
			return util.getElementSize(rowDeleteBtnList);
		} else {
			System.out.println("Please enter 'edit' or 'delete'");
			return 0;
		}


	}

	/**
	 * This method enables user to click edit button from a given row number
	 * 
	 * @param rowNumber
	 * @return
	 */
	public UserDetailsPage clickEditBtnFromARow(int rowNum) {
		util.getElements(rowEditBtnList).get(rowNum - 1).click();
		return new UserDetailsPage(driver);
	}

	/**
	 * This method enables user to click delete button from a given row number
	 * 
	 * @param rowNumber
	 * @return
	 */
	public DeleteUserPage clickDeleteBtnFromARow(int rowNum) {
		util.getElements(rowDeleteBtnList).get(rowNum - 1).click();
		return new DeleteUserPage(driver);
	}

	/**
	 * Method allows user to click on Edit button for a given user name
	 * 
	 * @param UserName
	 * @return
	 */
	public UserDetailsPage clickOnEditBtnForUser(String userName) {

		if (util.isElementDisplayed(By.xpath("//*[text()='" + userName + "']"))) {
			System.out.println("User name has been found in search result table");
			// util.doClick(By.xpath("//*[text()='" + userName +
			// "']/following-sibling::td[3]//button[@icon='pi pi-pencil']/span"));

			util.clickElementByJS(By.xpath(
					"//*[text()='" + userName + "']/following-sibling::td[3]//button[@icon='pi pi-pencil']/span"),
					driver);

		}
		return new UserDetailsPage(driver);
	}

	/**
	 * Method allows user to click on Delete button for a given User name
	 * 
	 * @param userName
	 * @return
	 */
	public DeleteUserPage clickOnDeleteBtnForUser(String userName) {

		if (util.isElementDisplayed(By.xpath("//*[text()='" + userName + "']"))) {
			util.clickElementByJS(By
					.xpath("//*[text()='" + userName + "']/following-sibling::td[3]//button[@icon='pi pi-trash']/span"),
					driver);

		}
		return new DeleteUserPage(driver);
	}

	// 6) Whole Record:

	// 7. List of ID, Name, Location Phone Number:

	/**
	 * This method returns list of all ID, Name, Location Phone Number Texts from
	 * all pages in Manage User Page
	 * 
	 * @param String column Name
	 * @return List<String>
	 */
	public List<String> getTextListFromAllPages(String colName) {

		List<String> list = new ArrayList<String>();

		// Step1: Fetch total number of pages
		int totalPage = getTotalNumberOfPages();

		// Step2:For loop for pages
		for (int page = 1; page <= totalPage; page++) {

			// Step2i: Click on first page button
			util.doClick(By.xpath("//button[text()='" + page + "']"));

			// Step3: get row count --> editbox count
			int totalRowInCurrentPage = getCheckboxCount();

			// Step4i: For loop to get program name for each row
			for (int row = 1; row <= totalRowInCurrentPage; row++) {

				if (colName.trim().equalsIgnoreCase("ID")) {
					// Step5: add each of them to a list
					list.add(getUserIDFromARow(row));
				} else if (colName.trim().equalsIgnoreCase("Name")) {
					// Step5: add each of them to a list
					list.add(getUserNameFromARow(row));
				} else if (colName.trim().equalsIgnoreCase("Location")) {
					// Step5: add each of them to a list
					list.add(getLocationFromARow(row));
				} else if (colName.trim().equalsIgnoreCase("Phone Number")) {
					// Step5: add each of them to a list
					list.add(getPhoneFromARow(row));
				}

			} // Step6:row loop ends

		} // Step7: page loop ends

		// Step8: return List
		return list;
	}

	// ************************** Pagination Function **************************
	public void clickOnFirstNextPreviousLastLink(String iconName) {
		switch (iconName.trim().toLowerCase()) {
		case "first":
			util.doClick(firstPageIcon);
			break;
		case "previous":
			util.doClick(previousPageIcon);
			break;
		case "next":
			util.doClick(nextPageIcon);
			break;
		case "last":
			util.doClick(lastPageIcon);
			break;
		default:
			System.out.println("Please pass first/previous/next/last as input parameter");
			break;
		}

	}
}


