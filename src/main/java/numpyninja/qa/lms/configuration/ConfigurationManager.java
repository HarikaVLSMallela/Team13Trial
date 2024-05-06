package numpyninja.qa.lms.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigurationManager {

	private static Properties prop;
	private static FileInputStream ip;

	public static Properties initProp() {
		
		try {
			prop = new Properties();
		
		String envName = System.getProperty("env");
		
		
			if(envName == null) {
				System.out.println("No environment has been given. Hence, running test on QA environment");		
				ip = new FileInputStream("src\\test\\resources\\config\\config_qa.properties");
				
			}
			else 
			{
				System.out.println("Running test on "+envName+" environment");
				
					switch (envName.toLowerCase().trim()) {
					case "qa":
						ip = new FileInputStream("src\\test\\resources\\config\\config_qa.properties");
						break;
					case "dev":
						ip = new FileInputStream("src\\test\\resources\\config\\config_dev.properties");
						break;
					case "stage":
						ip = new FileInputStream("src\\test\\resources\\config\\config_stage.properties");
						break;
					case "uat":
						ip = new FileInputStream("src\\test\\resources\\config\\config_uat.properties");
						break;	
					case "integration":
						ip = new FileInputStream("src\\test\\resources\\config\\config_integration.properties");
						break;
						
					default:
						System.out.println("Please padd the right env name .." + envName);
					}				
			}
			
			prop.load(ip);
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
		
	}
}
