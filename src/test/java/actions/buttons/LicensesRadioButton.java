package actions.buttons;

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
 * This is a class to perform radiobutton in Selenium
 * @author Sara.Danchevska
 *
 */

public class LicensesRadioButton extends LoginButton {

	/**
	 * Automation script for creating new Active License in License Management App using actions and commands: radio button
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

		if (!attribute.equals("License Management App")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("app.launcer")))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("search.field")))).sendKeys("License Management App");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("license")))).click();
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("quarterly.performance")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("license.tab")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("newLicenseButton")))).click();

		WebElement radioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("radioLicenseButton"))));
		radioButton.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("nextLicenseButton")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("saveLicenseButton")))).click();
		
		driver.close();

	}

}