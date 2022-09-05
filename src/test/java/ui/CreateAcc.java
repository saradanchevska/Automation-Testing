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
 * 
 * @author Sara.Danchevska
 *
 */

public class CreateAcc extends LoginButton {

	/**
	 * Automation script for creating a new Business Account throught 'Accounts' tab in Service App
	 * in Service App
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

		if (!attribute.equals("Service")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("app.launcer")))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("search.field")))).sendKeys("Service");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("service")))).click();
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("quarterly.performance")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("accounts.tab")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("new.account")))).click();

		WebElement radioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("business.type"))));
		radioButton.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("next.button")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("name.account")))).sendKeys("Sara Danchevska");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("phone.account")))).sendKeys("000/111-555");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("save.account")))).click();
		
		driver.close();
	}
}