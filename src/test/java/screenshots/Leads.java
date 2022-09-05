package screenshots;

import login.LoginButton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFDrawing;

/**
 * This is a class to perform screenshot in Salesforce Aplication
 * @author Sara.Danchevska
 *
 */
public class Leads extends LoginButton {

	/**
	 * Automation script for creating a new Lead throught 'Leads' in License Management App
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
		
		FileInputStream excel = new FileInputStream(System.getProperty("user.dir") + "\\src\\Screenshots.xlsx");
		XSSFWorkbook myWorkbook = new XSSFWorkbook(excel);
		XSSFSheet mySheet = myWorkbook.getSheetAt(1);
		XSSFDrawing myDrawing = mySheet.createDrawingPatriarch();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement title = driver.findElement(By.xpath(properties.getProperty("class")));
		String attribute = title.getAttribute("title");

		if (!attribute.equals("License Management App")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("app.launcer")))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("search.field")))).sendKeys("License Management App");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("license")))).click();		
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("quarterly.performance")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("lead.tab")))).click();
		
		//Screenshot 1
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("new.lead")))).click();
		File screenshotLead = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotLead, new File(".//screenshot//" + "newLead.png"));
		InputStream InputStreamLead = new FileInputStream(".//screenshot//" + "newLead.png");
		byte[] bytesLead = IOUtils.toByteArray(InputStreamLead);
		int idLead = myWorkbook.addPicture(bytesLead, Workbook.PICTURE_TYPE_JPEG);
		InputStreamLead.close();
		ClientAnchor anchorLead = new XSSFClientAnchor();
		anchorLead.setCol1(3);
		anchorLead.setRow1(5);
		XSSFPicture pictureLead = myDrawing.createPicture(anchorLead, idLead);		
		pictureLead.resize(0.8, 0.8);
		
		//Screenshot 2
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("lead.information")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("salutation.lead")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("salutation.mrs")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("firstname.lead")))).sendKeys("Sara");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("lastname.lead")))).sendKeys("Danchevska");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("company.lead")))).sendKeys("Seavus");
		
		File screenshotInfoLead = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotInfoLead, new File(".//screenshot//" + "infoLead.png"));
		InputStream InputStreamInfoLead = new FileInputStream(".//screenshot//" + "infoLead.png");
		byte[] bytesInfoLead = IOUtils.toByteArray(InputStreamInfoLead);
		int idInfoLead = myWorkbook.addPicture(bytesInfoLead, Workbook.PICTURE_TYPE_JPEG);
		InputStreamInfoLead.close();
		ClientAnchor anchorInfoLead = new XSSFClientAnchor();
		anchorInfoLead.setCol1(3);
		anchorInfoLead.setRow1(6);
		XSSFPicture pictureInfoLead = myDrawing.createPicture(anchorInfoLead, idInfoLead);		
		pictureInfoLead.resize(0.8, 0.8);
		
		//Screenshot 3
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("save.lead")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("after.save")))).click();
		File screenshotSave = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotSave, new File(".//screenshot//" + "saveLead.png"));
		InputStream InputStreamSave = new FileInputStream(".//screenshot//" + "saveLead.png");
		byte[] bytesSave = IOUtils.toByteArray(InputStreamSave);
		int idSave = myWorkbook.addPicture(bytesSave, Workbook.PICTURE_TYPE_JPEG);
		InputStreamSave.close();
		ClientAnchor anchorSave = new XSSFClientAnchor();
		anchorSave.setCol1(3);
		anchorSave.setRow1(7);
		XSSFPicture pictureSave = myDrawing.createPicture(anchorSave, idSave);		
		pictureSave.resize(0.8, 0.8);
		
		FileOutputStream fileOutTwo = new FileOutputStream(System.getProperty("user.dir") + "\\src\\Screenshots.xlsx");
		myWorkbook.write(fileOutTwo);

		fileOutTwo.close();
		myWorkbook.close();

		driver.close();

	}

}