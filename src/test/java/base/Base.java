package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Base {
	protected static WebDriver driver;
	public static Properties property = new Properties();
	public static String host;
	public static String adminHost;
	public static FileInputStream fis;
	public static utilities.ExcelReader reader;
    protected WebDriverWait wait;

    public static void click(By by) {
		driver.findElement( by ).click();
	}

	public static boolean isDisplayed(By by){
		return driver.findElement( by ).isDisplayed();
	}

	public static String getText(By by){
		return driver.findElement(by).getText();
	}

	public static void navigateURL(String url) {
		driver.get( url );
	}
	public static void dropDownvalue(WebElement webElement, String name) {
		Select select = new Select(webElement);
		select.selectByVisibleText(name);
	}
	public static void dropDownvalue2(By by, String name) {
		Select select = new Select(driver.findElement(by));
		select.selectByValue(name);
	}
	public static void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}


	public static void delayOfElement(int time){
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

//	public static void mousehoover(WebElement webElement) {
//		Actions action = new Actions(driver);
//		WebElement element2 = driver.findElement(webElement);
//		action.moveToElement(element2).build().perform();
//	}
	   public void  fluentWaitClick(WebElement element) {
	        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(40))
	                .pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
	        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", clickableElement);
	    }

	public void fluentWaitForUrl(String expectedUrl) {
		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.urlContains(expectedUrl));
	}
	public WebElement fluentWait(WebElement by) {
		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(by));
		return element;
	}
	public static void selectDate(WebElement parentElement, By childElementLocator, String value) {
		List<WebElement> signdates = parentElement.findElements(childElementLocator);
		for (WebElement e : signdates) {
			String date = e.getText();
			if (date.equals(value)) {
				e.click();
				break;
			}
		}
	}
//	public void fluentWait(WebElement by) {
//		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(40))
//				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
//		WebElement element = wait.until(ExpectedConditions.visibilityOf(by));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].textContent;", element);
//	}

	public static boolean switchtoRightWindow(String windowTitle, List<String> hList) {
		for(String e : hList) {
			String title = driver.switchTo().window(e).getTitle();
			if(title.contains(windowTitle)) {
				System.out.println("found the right window");
				return true;
			}
		}
		return false;
	}

	public static void waitForWebdriver(WebDriver driver, WebElement element, Duration waitDuration) {
		WebDriverWait wait = new WebDriverWait(driver, waitDuration);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	public static void windowhandles() { // keep it for future use
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String childwindow : allWindowHandles) {
			if (!childwindow.equals(mainWindowHandle)) {
				driver.switchTo().window(childwindow);

			}
		}

	}
}
