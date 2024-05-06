package numpyninja.qa.lms.driver;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

	public WebDriver driver;
	private Properties prop;
	public BroswerOptionsManager optionsManager;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();


	public WebDriver initDriver(Properties prop) {
		
		String browserName = "chrome";
		System.out.println("Browser name is = " + browserName);
		
		optionsManager = new BroswerOptionsManager(prop);

		if (browserName.trim().equalsIgnoreCase("chrome")) {
			//driver = new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}
		else if (browserName.trim().equalsIgnoreCase("firefox")) {
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));

		}
		else if (browserName.trim().equalsIgnoreCase("safari")) {
			tlDriver.set(new SafariDriver());

		}
		else if (browserName.trim().equalsIgnoreCase("edge")) {
			tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));

		}
		else {
			System.out.println("Plz pass the right browser");
		}
			
		  getDriver().manage().deleteAllCookies();
		  getDriver().manage().window().maximize();		 
		
		  return getDriver();
		
	}
	
	public synchronized static WebDriver getDriver() {
		return tlDriver.get();
	}

}
