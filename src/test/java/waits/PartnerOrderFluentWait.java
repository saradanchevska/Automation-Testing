package waits;

import login.LoginButton;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

/**
 * This is a class to perform Fluent Wait in Salesforce Application
 * @author Sara.Danchevska
 *
 */

public class PartnerOrderFluentWait extends LoginButton {

	/**
	 * Automation script for creating new Partner Contract Terms in Partner Order using actions and commands: checkbox
	 * 
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	public static void main(String[] args) throws InterruptedException, IOException {

		login("Edge");

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\configuration.properties");
		Properties properties = new Properties();
		properties.load(fis);

		 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				 .withTimeout(Duration.ofSeconds(10))
				 .pollingEvery(Duration.ofSeconds(2))
				 .ignoring(NoSuchElementException.class);

		WebElement title = driver.findElement(By.xpath(properties.getProperty("class")));
		String attribute = title.getAttribute("title");

		if (!attribute.equals("Partner Order")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("app.launcer")))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("search.field")))).sendKeys("Partner Order");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("partner.order")))).click();
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("quarterly.performance")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("partner.tab")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("new.partner")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("name.partner")))).sendKeys("Partner Order Contact");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("key.partner")))).sendKeys("POC");

		WebElement first = driver.findElement(By.xpath(properties.getProperty("renew.partner")));
		JavascriptExecutor jsOne = (JavascriptExecutor) driver;
		jsOne.executeScript("arguments[0].scrollIntoView();", first);
		first.click();

		WebElement second = driver.findElement(By.xpath(properties.getProperty("cancellation.partner")));
		JavascriptExecutor jsTwo = (JavascriptExecutor) driver;
		jsTwo.executeScript("arguments[0].scrollIntoView();", second);
		second.click();

		WebElement third = driver.findElement(By.xpath(properties.getProperty("contract.partner")));
		JavascriptExecutor jsThree = (JavascriptExecutor) driver;
		jsThree.executeScript("arguments[0].scrollIntoView();", third);
		third.click();

		WebElement fourth = driver.findElement(By.xpath(properties.getProperty("renewal.partner")));
		JavascriptExecutor jsFour = (JavascriptExecutor) driver;
		jsFour.executeScript("arguments[0].scrollIntoView();", fourth);
		fourth.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("save.partner")))).click();
		
		driver.close();

	}
}