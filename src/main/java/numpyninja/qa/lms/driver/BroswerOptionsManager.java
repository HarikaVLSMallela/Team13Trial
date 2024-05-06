package numpyninja.qa.lms.driver;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BroswerOptionsManager {
	
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;

	
	public BroswerOptionsManager(Properties prop) {
		this.prop = prop;
	}
	
	public ChromeOptions getChromeOptions() {
		
		co= new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			co.addArguments("--headless");
		}
		
		return co;
	}
	
	public FirefoxOptions getFirefoxOptions() {
		
		fo= new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			fo.addArguments("--headless");
		}
		
		return fo;
	}

	
	public EdgeOptions getEdgeOptions() {
		
		eo= new EdgeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			eo.addArguments("--headless");
		}
		
		return eo;
	}
	
}
