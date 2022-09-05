package actions.handle.alert.mouse.drop;

import login.LoginButton;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is a class to perform drag and drop in Salesforce Application
 * @author Sara.Danchevska
 *
 */

public class PaymentAdjustmentsDragAndDrop extends LoginButton {

	/**
	 * Automation script for creating a new New Payment Adjustment throught 'Payment Adjustments' item in Salesforce Application
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("app.launcer")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("search.field")))).sendKeys("Payment Adjustments");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("payment")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("new.payment")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("color")))).click();	
		
		WebElement slider = driver.findElement(By.xpath(properties.getProperty("slider")));

		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, 385,-100).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("done.color")))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("description.color")))).sendKeys("This is an example for slider");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("account.color")))).sendKeys("Sara");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("acc.color")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("button.color")))).click();
		
		driver.close();

	}

}