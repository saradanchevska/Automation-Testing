package waits;

import login.LoginButton;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This is a class to perform Implicit Wait in Salesforce Application
 * @author Sara.Danchevska
 *
 */

public class LicensesImplicitWait extends LoginButton {

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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement title = driver.findElement(By.xpath(properties.getProperty("class")));
		String attribute = title.getAttribute("title");

		if (!attribute.equals("License Management App")) {
			driver.findElement(By.xpath(properties.getProperty("app.launcer"))).click();
			driver.findElement(By.xpath(properties.getProperty("search.field"))).sendKeys("License Management App");
			driver.findElement(By.xpath(properties.getProperty("license"))).click();
		}

		driver.findElement(By.xpath(properties.getProperty("quarterly.performance"))).click();
		driver.findElement(By.xpath(properties.getProperty("license.tab"))).click();
		driver.findElement(By.xpath(properties.getProperty("new.license"))).click();

		WebElement radioButton = driver.findElement(By.xpath(properties.getProperty("license.button")));
		radioButton.click();

		driver.findElement(By.xpath(properties.getProperty("next.license"))).click();
		driver.findElement(By.xpath(properties.getProperty("save.license"))).click();
		
		driver.close();

	}

}