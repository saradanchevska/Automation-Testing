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

public class AccountsRadioButton extends LoginButton {

	/**
	 * Automation script for creating new Residential Account in CPQ using actions and commands: radio button
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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("tab.accounts")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("new.account")))).click();

		WebElement radioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("residential.button"))));
		radioButton.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("next.account")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("name.acc")))).sendKeys("Sara Danchevska");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("phone.acc")))).sendKeys("000/111-555");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("save.acc")))).click();
		
		driver.close();
	}

}