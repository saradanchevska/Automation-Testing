package actions.slider.click.event;

import login.LoginButton;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is a class to perform copy and paste in Salesforce Aplication
 * @author Sara.Danchevska
 *
 */

public class WorkOrderKeyboardEvents extends LoginButton {

	/**
	 * Automation script for creating a new Work Order in 'Work Orders'
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("search.field")))).sendKeys("Work Orders");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("work.orders")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("new.workorder")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("status.new")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("status.progress")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("subject.order")))).sendKeys("This is an example for copy and paste!");
		
		WebElement sourcetextarea = driver.findElement(By.xpath(properties.getProperty("subject.order")));
		Actions action = new Actions(driver);
		action.keyDown(sourcetextarea, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
		WebElement destinationtextarea = driver.findElement(By.xpath(properties.getProperty("description.order")));
		action.keyDown(destinationtextarea, Keys.CONTROL).sendKeys("v").build().perform();
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("save.workorder")))).click();
		
		driver.close();

	}

}

