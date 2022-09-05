package actions.slider.click.event;

import login.LoginButton;
import org.openqa.selenium.interactions.Actions;
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
 * This is a class to perform right click in Salesforce Aplication
 * @author Sara.Danchevska
 *
 */
public class PackagesRightClick extends LoginButton {

	/**
	 * Automation script for creating a new Package throught 'Packages' in License Management App
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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("package.tab")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("new.package")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("name.package")))).sendKeys("Package 555");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("id.package")))).sendKeys("555");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("date.package")))).click();
		
		WebElement date = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("datenumber.package"))));
		date.sendKeys("25.06.2022");
		date.sendKeys(Keys.ENTER);
		
		WebElement owner = driver.findElement(By.xpath(properties.getProperty("owner.team")));

		Actions action = new Actions(driver);
		action.contextClick(owner).perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("save.package")))).click();

	}

}