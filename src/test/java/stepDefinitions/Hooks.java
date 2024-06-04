package stepDefinitions;


import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Hooks extends Base {
	@Before
	public void setup() {

		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\config\\app.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		switch (property.getProperty("browser")) {
		case "chrome":
			ChromeOptions chromeOption = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOption);

			driver.manage().window().maximize();
			break;
		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			//firefoxOptions.setHeadless(true);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(firefoxOptions);
			break;
		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(edgeOptions);
			driver.manage().window().maximize();

			break;
		case "ie":
			InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver(internetExplorerOptions);
			break;
		default:

		}
		
		host = property.getProperty("baseUrl");
		adminHost = property.getProperty("adminBaseUrl");
	}

	@After
	public void tearDown(Scenario scenario) {
		try {
			if (scenario.isFailed()) {
				String screenshotName = scenario.getName().replaceAll(" ", "_");
				scenario.log("Test failed. Taking screenshot...");
				TakesScreenshot ts = (TakesScreenshot) driver;
				byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", screenshotName);
			}
			//driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
