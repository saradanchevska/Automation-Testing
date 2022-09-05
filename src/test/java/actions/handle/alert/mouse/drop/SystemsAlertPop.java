package actions.handle.alert.mouse.drop;

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
 * This is a class to perform alert pop in Salesforce Application
 * @author Sara.Danchevska
 *
 */

public class SystemsAlertPop extends LoginButton {

	/**
	 * Automation script for creating a new System throught 'Systems' tab in Order Management App
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		login("chrome");

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\configuration.properties");
		Properties properties = new Properties();
		properties.load(fis);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("class"))));
		String attribute = title.getAttribute("title");

		if (!attribute.equals("Order Management (OM)")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("app.launcer")))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("search.field")))).sendKeys("Order Management");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("management")))).click();
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("order")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("system.tab")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("new.system")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("url.system")))).sendKeys("www.system.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("name.system")))).sendKeys("System");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("save.system")))).click();
		
		driver.close();

	}

}