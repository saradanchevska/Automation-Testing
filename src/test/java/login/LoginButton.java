package login;

import java.io.FileInputStream;
import login.LoginButton;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Main class for all the scripts in Salesforce Application
 * @author Sara.Danchevska
 *
 */
public class LoginButton {
	
	public static WebDriver driver;

	/**
	 * Main class for login to the Salesforce application with the correct values of url, username and password
	 * 
	 * @throws IOException
	 */
	public static void login(String browser) throws IOException {

		if (browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\configuration.properties");
		Properties properties = new Properties();
		properties.load(fis);

		driver.get(properties.getProperty("url"));
		driver.findElement(By.id(properties.getProperty("username.id"))).sendKeys("team.seavus@partner-prod.com.vlocitysbx");
		driver.findElement(By.id(properties.getProperty("password.id"))).sendKeys("seavusQA123!");
		driver.findElement(By.name(properties.getProperty("login.button"))).click();

	}

}
