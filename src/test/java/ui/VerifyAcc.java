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

public class VerifyAcc extends LoginButton {

	/**
	 * Automation script to verify if the following Business Account created throught 'Account' tab in Service App is with correct values
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("quarterly.performance")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("accounts.tab")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("search.account")))).sendKeys("S.D.",Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("account.space"))));		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("account.name")))).click();
		
		driver.close();
	}
}