package numpyninja.qa.lms.pages;

import org.openqa.selenium.WebDriver;

import numpyninja.qa.lms.utils.ElementUtil;

public class AssignStudentPage {

	private WebDriver driver;
	private ElementUtil util;

	public AssignStudentPage(WebDriver driver, ElementUtil util) {
		this.driver = driver;
		this.util = util;
	}
}
