package ui;

import login.LoginButton;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is a class to perform Interactions with elements and tool commands
 * @author Sara.Danchevska
 *
 */

public class VerifyInterface extends LoginButton {

	/**
	 * Automation script to verify if the following new Interface is created throught 'Interface Implementations' in CPQ App
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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("interface.tab")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("search.interface")))).sendKeys("Interface1",Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("interface.space"))));		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("details.interface")))).click();
		
		driver.close();
	}
}