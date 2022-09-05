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
 * 
 * @author Sara.Danchevska
 *
 */

public class AccountsImplicitWait extends LoginButton {

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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement title = driver.findElement(By.xpath(properties.getProperty("class")));
		String attribute = title.getAttribute("title");

		if (!attribute.equals("Configure Price Quote (CPQ)")) {
			driver.findElement(By.xpath(properties.getProperty("app.launcer"))).click();
			driver.findElement(By.xpath(properties.getProperty("search.field"))).sendKeys("CPQ");
			driver.findElement(By.xpath(properties.getProperty("cpq"))).click();
		}

		driver.findElement(By.xpath(properties.getProperty("order"))).click();
		driver.findElement(By.xpath(properties.getProperty("tab.accounts"))).click();
		driver.findElement(By.xpath(properties.getProperty("new.account"))).click();

		WebElement radioButton = driver.findElement(By.xpath(properties.getProperty("residential.button")));
		radioButton.click();

		driver.findElement(By.xpath(properties.getProperty("next.account"))).click();
		driver.findElement(By.xpath(properties.getProperty("name.acc"))).sendKeys("Sara Danchevska");
		driver.findElement(By.xpath(properties.getProperty("phone.acc"))).sendKeys("000/111-555");
		driver.findElement(By.xpath(properties.getProperty("save.acc"))).click();

		driver.close();
	}

}