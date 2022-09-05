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

public class CreateInterfaceImplicitWait extends LoginButton {

	/**
	 * Automation script for creating a new Interface throught 'Interface Implementations' in CPQ App
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
		driver.findElement(By.xpath(properties.getProperty("interface.tab"))).click();
		driver.findElement(By.xpath(properties.getProperty("new.interface"))).click();
		driver.findElement(By.xpath(properties.getProperty("name.interface"))).sendKeys("Interface");
		driver.findElement(By.xpath(properties.getProperty("description.interface"))).sendKeys("It is an example for automation testing");
		driver.findElement(By.xpath(properties.getProperty("save.interface"))).click();
		
		driver.close();
	}
}