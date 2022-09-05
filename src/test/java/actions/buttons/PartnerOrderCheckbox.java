package actions.buttons;

import login.LoginButton;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is a class to perform checkbox in Selenium
 * @author Sara.Danchevska
 *
 */

public class PartnerOrderCheckbox extends LoginButton {

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

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("class"))));
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

		WebElement renew = driver.findElement(By.xpath(properties.getProperty("renew.partner")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", renew);
		renew.click();

		WebElement cancellation  = driver.findElement(By.xpath(properties.getProperty("cancellation.partner")));
		JavascriptExecutor jsOne = (JavascriptExecutor) driver;
		jsOne.executeScript("arguments[0].scrollIntoView();", cancellation );
		cancellation.click();

		WebElement contract  = driver.findElement(By.xpath(properties.getProperty("contract.partner")));
		JavascriptExecutor jsTwo = (JavascriptExecutor) driver;
		jsTwo.executeScript("arguments[0].scrollIntoView();", contract );
		contract.click();

		WebElement renewal  = driver.findElement(By.xpath(properties.getProperty("renewal.partner")));
		JavascriptExecutor jsThree = (JavascriptExecutor) driver;
		jsThree.executeScript("arguments[0].scrollIntoView();", renewal );
		renewal.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("save.partner")))).click();
		
		driver.close();

	}

}