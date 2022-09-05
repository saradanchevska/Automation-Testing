package screenshots;

import login.LoginButton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is a class to perform screenshot in Salesforce Aplication
 * @author Sara.Danchevska
 *
 */

public class PricingPlans extends LoginButton {

	/**
	 * Automation script for creating a New Pricing Plan in 'Pricing Plans' items
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
		XSSFSheet mySheet = myWorkbook.getSheetAt(2);
		XSSFDrawing myDrawing = mySheet.createDrawingPatriarch();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("app.launcer")))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("search.field")))).sendKeys("Pricing Plans");
		
		//Screenshot 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("plans")))).click();
		File screenshotLogin = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotLogin, new File(".//screenshot//" + "newLogin.png"));
		InputStream InputStreamLogin = new FileInputStream(".//screenshot//" + "newLogin.png");
		byte[] bytesLogin = IOUtils.toByteArray(InputStreamLogin);
		int idLogin = myWorkbook.addPicture(bytesLogin, Workbook.PICTURE_TYPE_JPEG);
		InputStreamLogin.close();
		ClientAnchor anchorLogin = new XSSFClientAnchor();
		anchorLogin.setCol1(3);
		anchorLogin.setRow1(2);
		XSSFPicture pictureLogin = myDrawing.createPicture(anchorLogin, idLogin);		
		pictureLogin.resize(0.8, 0.8);
		
		//Screenshot 2
		File screenshotPricing = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotPricing, new File(".//screenshot//" + "newPricing.png"));
		InputStream InputStreamPricing = new FileInputStream(".//screenshot//" + "newPricing.png");
		byte[] bytesPricing = IOUtils.toByteArray(InputStreamPricing);
		int idPricing = myWorkbook.addPicture(bytesPricing, Workbook.PICTURE_TYPE_JPEG);
		InputStreamPricing.close();
		ClientAnchor anchorPricing = new XSSFClientAnchor();
		anchorPricing.setCol1(3);
		anchorPricing.setRow1(4);
		XSSFPicture picturePricing = myDrawing.createPicture(anchorPricing, idPricing);		
		picturePricing.resize(0.8, 0.8);
			
		//Screenshot 3
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("new.plan")))).click();
		File screenshotAssessments = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAssessments, new File(".//screenshot//" + "assessments.png"));
		InputStream InputStreamAssessments = new FileInputStream(".//screenshot//" + "assessments.png");
		byte[] bytesAssessments = IOUtils.toByteArray(InputStreamAssessments);
		int idAssessments = myWorkbook.addPicture(bytesAssessments, Workbook.PICTURE_TYPE_JPEG);
		InputStreamAssessments.close();
		ClientAnchor anchorAssessments = new XSSFClientAnchor();
		anchorAssessments.setCol1(3);
		anchorAssessments.setRow1(4);
		XSSFPicture pictureAssessments = myDrawing.createPicture(anchorAssessments, idAssessments);		
		pictureAssessments.resize(0.8, 0.8);
		
		//Screenshot 4
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("name.plan")))).sendKeys("Plan Example1211");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("code.plan")))).sendKeys("578963455");
		File screenshotExample = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotExample, new File(".//screenshot//" + "newExample.png"));
		InputStream InputStreamExample = new FileInputStream(".//screenshot//" + "newExample.png");
		byte[] bytesExample = IOUtils.toByteArray(InputStreamExample);
		int idExample = myWorkbook.addPicture(bytesExample, Workbook.PICTURE_TYPE_JPEG);
		InputStreamExample.close();
		ClientAnchor anchorExample = new XSSFClientAnchor();
		anchorExample.setCol1(3);
		anchorExample.setRow1(5);
		XSSFPicture pictureExample = myDrawing.createPicture(anchorExample, idExample);		
		pictureExample.resize(0.8, 0.8);
		
		//Screenshot 5
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("save.plan")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("after.plan")))).click();
		File screenshotSavePlan = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotSavePlan, new File(".//screenshot//" + "newSavePlan.png"));
		InputStream InputStreamSavePlan = new FileInputStream(".//screenshot//" + "newSavePlan.png");
		byte[] bytesSavePlan = IOUtils.toByteArray(InputStreamSavePlan);
		int idSavePlan = myWorkbook.addPicture(bytesSavePlan, Workbook.PICTURE_TYPE_JPEG);
		InputStreamSavePlan.close();
		ClientAnchor anchorSavePlan = new XSSFClientAnchor();
		anchorSavePlan.setCol1(3);
		anchorSavePlan.setRow1(6);
		XSSFPicture pictureSavePlan = myDrawing.createPicture(anchorSavePlan, idSavePlan);		
		pictureSavePlan.resize(0.8, 0.8);
		
		FileOutputStream fileOutTwo = new FileOutputStream(System.getProperty("user.dir") + "\\src\\Screenshots.xlsx");
		myWorkbook.write(fileOutTwo);

		fileOutTwo.close();
		myWorkbook.close();
		
		driver.close();


	}

}

