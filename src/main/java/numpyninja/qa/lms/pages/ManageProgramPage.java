package numpyninja.qa.lms.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import numpyninja.qa.lms.utils.ElementUtil;

public class ManageProgramPage {
	
	private WebDriver driver;
	private ElementUtil util;

	// Navigation to other menu from Manage Program Page
	private By batchMenu = By.xpath("//button[@id='batch']");
	private By userMenu = By.xpath("//button[@id='user']");
	private By logoutMenu = By.id("logout");

	// Page Header section
	private By manageProgramHeading = By.xpath("//*[text()=' Manage Program']");
	private By multipleRecordDeleteBtn = By
			.xpath("//*[text()=' Manage Program']//following-sibling::div//button[@icon='pi pi-trash']");
	private By searchBox = By.xpath("//input[@id='filterGlobal']");
	private By aNewProgramButton = By.id("new");

	// Table header sections - Column Names
	private By programNameColumn = By.xpath("//*[@psortablecolumn='programName']");
	private By programDescriptionColumn = By.xpath("//*[@psortablecolumn='programDescription']");
	private By programStatusColumn = By.xpath("//*[@psortablecolumn='programStatus']");
	private By checkBoxColumn = By.xpath("//div[@class ='p-checkbox-box']");

	// Table header section - Column Sort Icons
	private By programNameSortIcon = By.xpath("//*[@psortablecolumn='programName']//i");
	private By programDescriptionSortIcon = By.xpath("//*[@psortablecolumn='programDescription']//i");
	private By programStatusSortIcon = By.xpath("//*[@psortablecolumn='programStatus']//i");
	private By ArrowIconProgram = By.xpath("//i[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-up-alt']");
    private By ArrowIconDescription = By.xpath("//p-sorticon[@field='description']//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']");
    private By ArrowIconProgramStatus = By.xpath("//p-sorticon[@field='status']//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']");

	// Table Body section
	private By rowList = By.xpath("//tbody/tr");
	private By rowDeleteBtnList = By.xpath("//button[@id='deleteProgram']");
	private By rowEditBtnList = By.xpath("//button[@id='editProgram'] ");
	private By rowPrgNameList = By.xpath("//*[@class='p-datatable-tbody']//tr/td[2]");
	private By rowPrgDescList = By.xpath("//*[@class='p-datatable-tbody']//tr/td[3]");
	private By rowPrgStatusList = By.xpath("//*[@class='p-datatable-tbody']//tr/td[4]");

	//CheckBox
	private By checkboxList = By.xpath("//*[@class='p-datatable-tbody']//tr/td[1]//div[@role='checkbox']");
	private By AllAddnDeleteBtn = By.xpath("//div[@class='action']"); 


	private By CheckBoxTop =  By.xpath("//*[@psortablecolumn='programName']/..//*[@role='checkbox']");
	private By CheckBoxFirst =  By.xpath("(//*[@class='p-datatable-tbody']//tr/td[1]//div[@role='checkbox'])[1]");
	private By CheckBoxSecond =  By.xpath("(//*[@class='p-datatable-tbody']//tr/td[1]//div[@role='checkbox'])[2]");
	private By CheckBoxThird  =  By.xpath("(//*[@class='p-datatable-tbody']//tr/td[1]//div[@role='checkbox'])[3]");
	private By CheckBoxForth  =  By.xpath("(//*[@class='p-datatable-tbody']//tr/td[1]//div[@role='checkbox'])[4]");
	private By CheckBoxFifth  =  By.xpath("(//*[@class='p-datatable-tbody']//tr/td[1]//div[@role='checkbox'])[5]");
	
	// private By Msg = By.xpath("//div[@role='alert']");
	private By msgTitle = By.className("p-toast-summary");
	private By msgDescription = By.className("p-toast-detail");

	// Pagination section
	private By paginationEntryInfo = By.className("p-paginator-current");
	private By totalProgramText = By.className("p-datatable-footer");
	private By firstPageIcon = By.className("p-paginator-first");
	private By previousPageIcon = By.className("p-paginator-prev");
	private By nextPageIcon = By.className("p-paginator-next");
	private By lastPageIcon = By.className("p-paginator-last");
	
	//Footer section
	private By TotalNoOfProgram = By.xpath("//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']");


	public ManageProgramPage(WebDriver driver) {
		this.driver = driver;
		this.util = new ElementUtil(driver);
	}

	/* PAGE ACTION METHODS: */

	// ****************** URL, Navigation to Menu option, SuccessMsg Validation
	// functions ***********************

	public String getPageUrl() {
		return util.getPageURL();
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

	/**
	 * This method return the text inside any kind of success/warning msg
	 * @return
	 */
	public String getFlyingMsgText() {
		return (util.getElementText(msgTitle)) + " " + (util.getElementText(msgDescription));
	}

	
	
	// ****************** Page Header, Multiple Delete, SearchBox, + A New Program Button functions *************

	public Boolean doesHeaderExist() {
		return util.isElementDisplayed(manageProgramHeading);
	}

	 public boolean NewProgramBtnIsDisplay() {
			return util.isElementDisplayed(aNewProgramButton);
		
	    }
	/**
	 * This method checks if Multiple Delete Btn is enabled
	 * 
	 * @return boolean
	 */
	public boolean isMultipleDeleteBtnEnabled() {
		return util.getElement(multipleRecordDeleteBtn).isEnabled();
	}

	/**
	 * This method clicks on Multiple Delete Btn
	 */
	public DeleteProgramPage clickMultipleDeleteBtn() {
		util.doClick(multipleRecordDeleteBtn);
		return new DeleteProgramPage(driver);
	}

	/**
	 * @return String get search box innter text
	 */
	public String getSearchBoxText() {
		if (util.isElementDisplayed(searchBox)) {
			return util.getAttributeVal(searchBox, "placeholder");
		} else
			return "SearchBox was not found in Manage Program Page";
	}

	/**
	 * @param enter text in search box
	 */
	public void enterTextInSearchBox(String programName) {
		util.doSendKeys(searchBox, programName);
	}

	/**
	 * Method clicks on + A New Program button
	 * 
	 * @return object of ProgramDetailsPage
	 */
	public ProgramDetailsPage clickNewProgramButton() {
		util.doClick(aNewProgramButton);
		return new ProgramDetailsPage(driver);
	}

	// ********************* Table Header functions ***********************

	/**
	 * This method clicks on sort icon for a given column name and sorting order
	 * 
	 * @param columnName
	 * @param ascendingOrDescending
	 */
	public void clickSortIcon(String columnName, String ascendingOrDescending) {
		String colName = columnName.trim().toLowerCase();
		switch (colName) {
		case "program name":
			if (ascendingOrDescending.trim().equalsIgnoreCase("ascending")) {
				util.doClick(programNameSortIcon);
			} else if (ascendingOrDescending.trim().equalsIgnoreCase("descending")) {
				util.doClick(programNameSortIcon);
				util.doClick(programNameSortIcon);
			} else {
				System.out.println("Pass 'ascending' or 'descending' for sorting order");
				System.out.println();
			}
			break;

		case "program description":
			if (ascendingOrDescending.trim().equalsIgnoreCase("ascending")) {
				util.doClick(programDescriptionSortIcon);
			} else if (ascendingOrDescending.trim().equalsIgnoreCase("descending")) {
				util.doClick(programDescriptionSortIcon);
				util.doClick(programDescriptionSortIcon);
			} else {
				System.out.println("Pass 'ascending' or 'descending' for sorting order");
			}
			break;

		case "program status":
			if (ascendingOrDescending.trim().equalsIgnoreCase("ascending")) {
				util.doClick(programStatusSortIcon);
			} else if (ascendingOrDescending.trim().equalsIgnoreCase("descending")) {
				util.doClick(programStatusSortIcon);
				util.doClick(programStatusSortIcon);
			} else {
				System.out.println("Pass 'ascending' or 'descending' for sorting order");
			}
			break;

		default:
			System.out.println("Please pass column name properly");
			break;
		}
	}

	//****** CheckBox on left side on manage program
	

		public Boolean CheckBoxTop() {
			return util.isElementDisplayed(CheckBoxTop);
		}
		

		public Boolean CheckBox1() {
			return util.isElementDisplayed(CheckBoxFirst);
		}
		

		public Boolean CheckBox2() {
			return util.isElementDisplayed(CheckBoxSecond);
		}
		

		public Boolean CheckBox3() {
			return util.isElementDisplayed(CheckBoxThird);
		}
		

		public Boolean CheckBox4() {
			return util.isElementDisplayed(CheckBoxForth);
		}
		

		public Boolean CheckBox5() {
			return util.isElementDisplayed(CheckBoxFifth);
		}

	// ** Arrow icons (up and down) */
		public Boolean ArrowIconProgram() {
			return util.isElementDisplayed(ArrowIconProgram);
		}
		

		public Boolean ArrowIconDescription() {
			return util.isElementDisplayed(ArrowIconDescription);
		}
		
		
		public Boolean ArrowIconProgramStatus() {
			return util.isElementDisplayed(ArrowIconProgramStatus);
		}
	// ********************* Table Body functions ***********************

	// 1)Check box related:

	/**
	 * This method return number of checkboxes in table in Manage Program Page
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
	 * @return String corresponding Program Name from the given row
	 */
	public String selectCheckboxFromARow(int rowNum) {
		util.getElements(checkboxList).get(rowNum - 1).click();
		return getProgramNameFromARow(rowNum);
	}

	// 2)Program Name related:

	/**
	 * This method returns the program name for a given row
	 * 
	 * @param rowNum
	 * @return
	 */
	public String getProgramNameFromARow(int rowNum) {
		return util.getElements(rowPrgNameList).get(rowNum - 1).getText();
	}

	// 3)Program Description related:

	/**
	 * This method returns the program description for a given row
	 * 
	 * @param rowNum
	 * @return
	 */
	public String getProgramDescriptionFromARow(int rowNum) {
		
		String text = util.getElements(rowPrgDescList).get(rowNum - 1).getText();
		System.out.println(text);
		return text;
		
	}

	// 4)Program Status related:

	/**
	 * This method returns the program status for a given row
	 * 
	 * @param rowNum
	 * @return
	 */
	public String getProgramStatusFromARow(int rowNum) {
		return util.getElements(rowPrgStatusList).get(rowNum - 1).getText();
	}

	// 5)Edit/Delete buttons related:

	/**
	 * This method return number of delete or edit button in table in Manage Program
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
	public ProgramDetailsPage clickEditBtnFromARow(int rowNum) {
		util.getElements(rowEditBtnList).get(rowNum - 1).click();
		return new ProgramDetailsPage(driver);
	}

	/**
	 * This method enables user to click delete button from a given row number
	 * 
	 * @param rowNumber
	 * @return
	 */
	public DeleteProgramPage clickDeleteBtnFromARow(int rowNum) {
		util.getElements(rowDeleteBtnList).get(rowNum - 1).click();
		return new DeleteProgramPage(driver);
	}

	/**
	 * Method allows user to click on Edit button for a given program name
	 * 
	 * @param programName
	 * @return
	 */
	public ProgramDetailsPage clickOnEditBtnForProgram(String programName) {

		if (util.isElementDisplayed(By.xpath("//*[text()='" + programName + "']"))) {
			util.doClick(
					By.xpath("//*[text()='" + programName + "']/following-sibling::td[3]//button[@id='editProgram']"));
			}
		return new ProgramDetailsPage(driver);
		
	}

	/**
	 * Method allows user to click on Delete button for a given program name
	 * 
	 * @param programName
	 * @return
	 */
	public DeleteProgramPage clickOnDeleteBtnForProgram(String programName) {

		if (util.isElementDisplayed(By.xpath("//*[text()='" + programName + "']"))) {
			util.doClick(By
					.xpath("//*[text()='" + programName + "']/following-sibling::td[3]//button[@id='deleteProgram']"));
			
		}
		return new DeleteProgramPage(driver);
	}

	// 6) Whole Record:

	/**
	 * returns whole record of program name, description and status in the form of
	 * hashmap
	 * 
	 * @throws InterruptedException
	 */
	public HashMap<String, String> isAddedOrEditedProgramRecordVisible(String programName) {

		HashMap<String, String> map = null;

		String program = programName;
		String text = util.getElementText(By.className("p-paginator-bottom"));

		String[] arr = text.split(" ");
		int denominator = Integer.parseInt(arr[3]);
		int numerator = Integer.parseInt(arr[5]);
		float ceil = (float) numerator / (float) denominator;

		int totalNumberOfPages = (int) Math.ceil(ceil);

		List<WebElement> ele = util.getElements(By.xpath("//td[text()='" + program + "']"));

		forloop: for (int i = 1; i <= totalNumberOfPages; i++) {

			util.doClick(By.xpath("//button[text()='" + i + "']"));
			//System.out.println("Clicked on Page " + i);

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			ele = util.getElements(By.xpath("//td[text()='" + program + "']"));

			if (ele.size() == 1) {
				System.out.println(program + " is found on page = " + i + "in search result table");
				List<WebElement> recordElements = util.getElements(By.xpath("//*[text()='" + program + "']/../td"));

				map = new HashMap<>();
				map.put("ProgramName", recordElements.get(1).getText());
				map.put("ProgramDescription", recordElements.get(2).getText());
				map.put("ProgramStatus", recordElements.get(3).getText());

				// System.out.println(Arrays.asList(map));

				break forloop;
			} else {
				System.out.println(program + " is not found on Page = " + i + "in search result table");

			}
		}

		return map;
	}

	// 7) List of Program Name, Description and Status:

	/**
	 * This method returns list of all Program Names, Descriptions or Status Texts from all pages in Manage Program Page
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
			util.doClick(By.xpath("//button[text()='"+page+"']"));

			// Step3: get row count --> editbox count
			int totalRowInCurrentPage = getCheckboxCount();
			
			// Step4i: For loop to get program name for each row
			for (int row = 1; row <= totalRowInCurrentPage; row++) {
				

				if (colName.trim().equalsIgnoreCase("Program Name")) {
					// Step5: add each of them to a list
					list.add(getProgramNameFromARow(row));
				} else if (colName.trim().equalsIgnoreCase("Program Description")) {
					// Step5: add each of them to a list
					list.add(getProgramDescriptionFromARow(row));
				} else if (colName.trim().equalsIgnoreCase("Program Status")) {
					// Step5: add each of them to a list
					list.add(getProgramStatusFromARow(row));
				}

			} // Step6:row loop ends

		} // Step7: page loop ends

		// Step8: return List
		return list;
	}
		
	// 8)Get total number of rows in a given page:
	public int getTotalRows() {
		return util.getElementSize(rowList);
	}
	
	public Boolean AllEditnDeleteBtn() {
		return util.isElementDisplayed(AllAddnDeleteBtn);
	}
	
	// ********************* Pagination Functions ***********************

	/**
	 * @return total pagination text section
	 */
	public String getPaginationText() {
		return util.getElementText(paginationEntryInfo);
	}

	/**
	 * This method returns total number of Pages in Manage Program Page
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
	
	public int getTotalNumberOfPrograms() {
		String[] arr = util.getElementText(totalProgramText).split(" ");
		return Integer.parseInt(arr[4]);
	}
	
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
	
	
	public boolean isFirstNextPreviousLastLinkIconLinkEnabled(String iconName) {
		boolean flag = false;
		switch (iconName.trim().toLowerCase()) {
		case "first":
			flag = util.isElementEnabled(firstPageIcon);
			break;
		case "previous":
			flag = util.isElementEnabled(previousPageIcon);
			break;
		case "next":
			flag = util.isElementEnabled(nextPageIcon);
			break;
		case "last":
			flag = util.isElementEnabled(lastPageIcon);
			break;
		default:
			System.out.println("Please pass first/previous/next/last as input parameter");
			break;
		}
		return flag;
	}

	
	public void navigateToPageNumber(int pageNumber) {
		util.doClick(By.xpath("//button[text()='"+pageNumber+"']"));
	}
	
	public boolean isPageHighlighted(int pageNumber) {
		
		String classValue = util.getAttributeVal(By.xpath("//button[text()='"+pageNumber+"']"), "class");
		
		boolean isPresent=false;
		
		if(classValue.contains("p-highlight")) {
			isPresent=true;
		}
		
		return isPresent;
	
	}
	
	
	//********* Footer Functions *******************
	// ********************* Footer Functions ***********************
	
	   public boolean Pagefooter() {
			return util.isElementDisplayed(TotalNoOfProgram);		
		}
	   
	   public String getTotalRecordText() {
			return util.getElementText(TotalNoOfProgram);		
		}
	
	// *********************NEEDS TO BE FURTHER MODIFIED AFTER IMPLEMENTING
	// PAGINATION ***********************
	/*
	 * public ProgramDetailsPage clickEditButtonOfProgram(String programName) {
	 * 
	 * // Click on Program Menu first util.goToProgramMenu();
	 * 
	 * String program = programName; String text =
	 * util.getElementText(By.className("p-paginator-bottom"));
	 * 
	 * String[] arr = text.split(" "); int denominator = Integer.parseInt(arr[3]);
	 * int numerator = Integer.parseInt(arr[5]); float ceil = (float) numerator /
	 * (float) denominator;
	 * 
	 * int totalNumberOfPages = (int) Math.ceil(ceil);
	 * 
	 * List<WebElement> ele = util.getElements(By.xpath("//td[text()='" + program +
	 * "']"));
	 * 
	 * forloop: for (int i = 1; i <= totalNumberOfPages; i++) {
	 * 
	 * util.doClick(By.xpath("//button[text()='" + i + "']"));
	 * System.out.println("Clicked on Page " + i);
	 * 
	 * try { Thread.sleep(2000); } catch (InterruptedException e) {
	 * e.printStackTrace(); }
	 * 
	 * ele = util.getElements(By.xpath("//td[text()='" + program + "']"));
	 * 
	 * if (ele.size() == 1) { System.out.println(program + " is found on page = " +
	 * i); util.doClick(By .xpath("//td[text()='" + program +
	 * "']//following-sibling::td[3]//button[@id='editProgram']"));
	 * 
	 * break forloop; } else { System.out.println(program +
	 * " is not found on Page = " + i);
	 * 
	 * } }
	 * 
	 * return new ProgramDetailsPage(driver); }
	 * 
	 * public void clickDeleteButtonOfProgram(String programName) {
	 * 
	 * util.goToProgramMenu(); String program = programName; String text =
	 * util.getElementText(By.className("p-paginator-bottom"));
	 * 
	 * String[] arr = text.split(" "); int denominator = Integer.parseInt(arr[3]);
	 * int numerator = Integer.parseInt(arr[5]); float ceil = (float) numerator /
	 * (float) denominator;
	 * 
	 * int totalNumberOfPages = (int) Math.ceil(ceil);
	 * 
	 * List<WebElement> ele = util.getElements(By.xpath("//td[text()='" + program +
	 * "']"));
	 * 
	 * forloop: for (int i = 1; i <= totalNumberOfPages; i++) {
	 * 
	 * util.doClick(By.xpath("//button[text()='" + i + "']"));
	 * System.out.println("Clicked on Page " + i);
	 * 
	 * try { Thread.sleep(2000); } catch (InterruptedException e) {
	 * e.printStackTrace(); }
	 * 
	 * ele = util.getElements(By.xpath("//td[text()='" + program + "']"));
	 * 
	 * if (ele.size() == 1) { System.out.println(program + " is found on page = " +
	 * i); util.doClick(By.xpath( "//td[text()='" + program +
	 * "']//following-sibling::td[3]//button[@id='deleteProgram']"));
	 * 
	 * break forloop; } else { System.out.println(program +
	 * " is not found on Page = " + i);
	 * 
	 * } } }
	 * 
	 * public void selectCheckboxOfProgram(String programName) {
	 * 
	 * util.goToProgramMenu();
	 * 
	 * String program = programName; String text =
	 * util.getElementText(By.className("p-paginator-bottom"));
	 * 
	 * String[] arr = text.split(" "); int denominator = Integer.parseInt(arr[3]);
	 * int numerator = Integer.parseInt(arr[5]); float ceil = (float) numerator /
	 * (float) denominator;
	 * 
	 * int totalNumberOfPages = (int) Math.ceil(ceil);
	 * 
	 * List<WebElement> ele = util.getElements(By.xpath("//td[text()='" + program +
	 * "']"));
	 * 
	 * forloop: for (int i = 1; i <= totalNumberOfPages; i++) {
	 * 
	 * util.doClick(By.xpath("//button[text()='" + i + "']"));
	 * System.out.println("Clicked on Page " + i);
	 * 
	 * try { Thread.sleep(2000); } catch (InterruptedException e) {
	 * e.printStackTrace(); }
	 * 
	 * ele = util.getElements(By.xpath("//td[text()='" + program + "']"));
	 * 
	 * if (ele.size() == 1) { System.out.println(program + " is found on page = " +
	 * i); util.doClick(By.xpath("///td[text()='" + program +
	 * "']//preceding-sibling::td//div[@role='checkbox']"));//
	 * 
	 * break forloop; } else { System.out.println(program +
	 * " is not found on Page = " + i);
	 * 
	 * } } }
	 * 
	 * public String getDescOfProgram(String programName) {
	 * 
	 * util.goToProgramMenu();
	 * 
	 * String description = null; String program = programName; String text =
	 * util.getElementText(By.className("p-paginator-bottom"));
	 * 
	 * String[] arr = text.split(" "); int denominator = Integer.parseInt(arr[3]);
	 * int numerator = Integer.parseInt(arr[5]); float ceil = (float) numerator /
	 * (float) denominator;
	 * 
	 * int totalNumberOfPages = (int) Math.ceil(ceil);
	 * 
	 * List<WebElement> ele = util.getElements(By.xpath("//td[text()='" + program +
	 * "']"));
	 * 
	 * forloop: for (int i = 1; i <= totalNumberOfPages; i++) {
	 * 
	 * util.doClick(By.xpath("//button[text()='" + i + "']"));
	 * System.out.println("Clicked on Page " + i);
	 * 
	 * try { Thread.sleep(2000); } catch (InterruptedException e) {
	 * e.printStackTrace(); }
	 * 
	 * ele = util.getElements(By.xpath("//td[text()='" + program + "']"));
	 * 
	 * if (ele.size() == 1) { System.out.println(program + " is found on page = " +
	 * i); description = util.getElementText(By.xpath("//td[text()='" + program +
	 * "']//following-sibling::td[1]"));
	 * 
	 * break forloop; } else { System.out.println(program +
	 * " is not found on Page = " + i);
	 * 
	 * } }
	 * 
	 * return description; }
	 * 
	 * public String getStatusOfProgram(String programName) {
	 * util.goToProgramMenu();
	 * 
	 * String status = null; String program = programName; String text =
	 * util.getElementText(By.className("p-paginator-bottom"));
	 * 
	 * String[] arr = text.split(" "); int denominator = Integer.parseInt(arr[3]);
	 * int numerator = Integer.parseInt(arr[5]); float ceil = (float) numerator /
	 * (float) denominator;
	 * 
	 * int totalNumberOfPages = (int) Math.ceil(ceil);
	 * 
	 * List<WebElement> ele = util.getElements(By.xpath("//td[text()='" + program +
	 * "']"));
	 * 
	 * forloop: for (int i = 1; i <= totalNumberOfPages; i++) {
	 * 
	 * util.doClick(By.xpath("//button[text()='" + i + "']"));
	 * System.out.println("Clicked on Page " + i);
	 * 
	 * try { Thread.sleep(2000); } catch (InterruptedException e) {
	 * e.printStackTrace(); }
	 * 
	 * ele = util.getElements(By.xpath("//td[text()='" + program + "']"));
	 * 
	 * if (ele.size() == 1) { System.out.println(program + " is found on page = " +
	 * i); status = util.getElementText(By.xpath("//td[text()='" + program +
	 * "']//following-sibling::td[2]"));
	 * 
	 * break forloop; } else { System.out.println(program +
	 * " is not found on Page = " + i);
	 * 
	 * } }
	 * 
	 * return status; }
	 */


}