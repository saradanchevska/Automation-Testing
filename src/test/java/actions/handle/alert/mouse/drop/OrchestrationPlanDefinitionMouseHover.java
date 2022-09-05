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
 * This is a class to perform mouse hover in Salesforce Application
 * @author Sara.Danchevska
 *
 */

public class OrchestrationPlanDefinitionMouseHover extends LoginButton {

	/**
	 * Automation script for creating a new Orchestration Plan Definition throught 'Orchestration Plan Definition' in Order Management App
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

		if (!attribute.equals("Order Management (OM)")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("app.launcer")))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("search.field")))).sendKeys("Order Management");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("management.tab")))).click();
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("order")))).click();
		
		WebElement element = driver.findElement(By.xpath(properties.getProperty("plans.tab")));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("definition.tab")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("new.definition")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("name.definition")))).sendKeys("Plan Definition");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("save.definition")))).click();
		
		driver.close();

	}

}