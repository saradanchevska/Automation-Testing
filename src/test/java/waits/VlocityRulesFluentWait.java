package waits;

import login.LoginButton;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

/**
 * This is a class to perform Fluent Wait in Salesforce Application
 * @author Sara.Danchevska
 *
 */

public class VlocityRulesFluentWait extends LoginButton {

	/**
	 * Automation script for creating new Vlocity Rule in CPQ using actions and commands: dropdown
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

		if (!attribute.equals("Configure Price Quote (CPQ)")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("app.launcer")))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("search.field")))).sendKeys("CPQ");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("cpq")))).click();
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("order.space")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("vlocity.tab")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("new.vlocity")))).click();
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("rule.name")))).sendKeys("Account Rule");
		
		WebElement first = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("dropdown.type"))));
		Select type = new Select(first);
		type.selectByIndex(2);
		
		WebElement second = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("dropdown.order"))));
		Select order = new Select(second);
		order.selectByIndex(2);
		
		WebElement third = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("dropdown.active"))));
		Select active = new Select(third);
		active.selectByIndex(1);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("save.rule")))).click();
		
		driver.close();
			
	}

}