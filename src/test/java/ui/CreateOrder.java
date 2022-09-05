package ui;

import login.LoginButton;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is a class to perform Interactions with elements and tool commands
 * @author Sara.Danchevska
 *
 */

public class CreateOrder extends LoginButton {

	/**
	 * Automation script for creating a new Order throught 'Orders' tab in CPQ App
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

		if (!attribute.equals("Configure Price Quote (CPQ)")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("app.launcer")))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("search.field")))).sendKeys("CPQ");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("cpq")))).click();
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("order")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("new.order")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("account.order")))).sendKeys("Sara Danchevska");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("name.order")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("order.input")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("order.date")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("order.price")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("order.list")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("order.save")))).click();
		
		driver.close();
	}
}

