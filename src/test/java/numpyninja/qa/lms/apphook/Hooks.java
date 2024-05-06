package numpyninja.qa.lms.apphook;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import numpyninja.qa.lms.driver.DriverFactory;
import numpyninja.qa.lms.utils.LoggerLoad;


public class Hooks {

	WebDriver driver;

	@Before()
	public void setUp() {
	}


	@AfterStep
	public void afterstep(Scenario scenario) {
		driver = DriverFactory.getDriver();
		if (scenario.isFailed()) {
			LoggerLoad.error("Steps Failed , Taking Screenshot");
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "My screenshot");
			Allure.addAttachment("Myscreenshot",new String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		}
	}


	@After()
	public void tearDown(Scenario scenario) throws InterruptedException {

		driver = DriverFactory.getDriver();
		Thread.sleep(5000);
		driver.quit();
	}
	}

