package actions.buttons;

import login.LoginButton;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is a class to perform dropdown in Selenium
 * @author Sara.Danchevska
 *
 */

public class EntityFiltersDropDown extends LoginButton {

	/**
	 * Automation script for creating new Vlocity Entity Filter in CPQ using actions and commands: dropdown
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

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("order.space")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("entity.tab")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("new.entity")))).click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("name.filter")))).sendKeys("Filter");

		WebElement first = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("type.filter"))));
		Select type = new Select(first);
		type.selectByIndex(2);

		WebElement second = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("criteria.filter"))));
		Select criteria = new Select(second);
		criteria.selectByIndex(2);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("save.filter")))).click();
		
		driver.close();

	}

}