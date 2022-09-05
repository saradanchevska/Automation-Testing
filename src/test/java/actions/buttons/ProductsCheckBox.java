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

public class ProductsCheckBox extends LoginButton {

	/**
	 * Automation script for creating new Product in CPQ using actions and commands: checkbox
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

		if (!attribute.equals("Configure Price Quote (CPQ)")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("app.launcer")))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("search.field")))).sendKeys("CPQ");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("cpq")))).click();
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("order")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("product.tab")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("new.product")))).click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("name.product")))).sendKeys("Product");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("code.product")))).sendKeys("PRD");

		WebElement active = driver.findElement(By.xpath(properties.getProperty("product.active")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", active);
		active.click();

		WebElement orderable = driver.findElement(By.xpath(properties.getProperty("product.orderable")));
		JavascriptExecutor jsOne = (JavascriptExecutor) driver;
		jsOne.executeScript("arguments[0].scrollIntoView();", orderable);
		orderable.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("save.product")))).click();
		
		driver.close();

	}

}