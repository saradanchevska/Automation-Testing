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
 * 
 * @author Sara.Danchevska
 *
 */

public class Assessments extends LoginButton {

	/**
	 * Automation script for creating a new Assessment throught 'Assessments' items
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
		XSSFSheet mySheet = myWorkbook.getSheetAt(3);
		XSSFDrawing myDrawing = mySheet.createDrawingPatriarch();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		//Screenshot 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("app.launcer")))).click();
		File screenshotAppLauncher = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAppLauncher, new File(".//screenshot//" + "appLauncher.png"));
		InputStream InputStreamAppLauncher = new FileInputStream(".//screenshot//" + "appLauncher.png");
		byte[] bytesAppLauncher = IOUtils.toByteArray(InputStreamAppLauncher);
		int idAppLauncher = myWorkbook.addPicture(bytesAppLauncher, Workbook.PICTURE_TYPE_JPEG);
		InputStreamAppLauncher.close();
		ClientAnchor anchorAppLauncher = new XSSFClientAnchor();
		anchorAppLauncher.setCol1(3);
		anchorAppLauncher.setRow1(2);
		XSSFPicture pictureAppLauncher = myDrawing.createPicture(anchorAppLauncher, idAppLauncher);		
		pictureAppLauncher.resize(0.8, 0.8);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("search.field")))).sendKeys("Assessments");
		
		//Screenshot 2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("assessments")))).click();
		File screenshotLogin = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotLogin, new File(".//screenshot//" + "newLogin.png"));
		InputStream InputStreamLogin = new FileInputStream(".//screenshot//" + "newLogin.png");
		byte[] bytesLogin = IOUtils.toByteArray(InputStreamLogin);
		int idLogin = myWorkbook.addPicture(bytesLogin, Workbook.PICTURE_TYPE_JPEG);
		InputStreamLogin.close();
		ClientAnchor anchorLogin = new XSSFClientAnchor();
		anchorLogin.setCol1(3);
		anchorLogin.setRow1(3);
		XSSFPicture pictureLogin = myDrawing.createPicture(anchorLogin, idLogin);		
		pictureLogin.resize(0.8, 0.8);

		// Screenshot 3
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("new.assessments")))).click();
		File screenshotAssessments = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAssessments, new File(".//screenshot//" + "newAssessments.png"));
		InputStream InputStreamAssessments = new FileInputStream(".//screenshot//" + "newAssessments.png");
		byte[] bytesAssessments = IOUtils.toByteArray(InputStreamAssessments);
		int idAssessments = myWorkbook.addPicture(bytesAssessments, Workbook.PICTURE_TYPE_JPEG);
		InputStreamAssessments.close();
		ClientAnchor anchorAssessments = new XSSFClientAnchor();
		anchorAssessments.setCol1(3);
		anchorAssessments.setRow1(4);
		XSSFPicture pictureAssessments = myDrawing.createPicture(anchorAssessments, idAssessments);
		pictureAssessments.resize(0.8, 0.8);

		//Screenshot 4
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("name.assessment")))).sendKeys("Example Assessment");
		File screenshotSave = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotSave, new File(".//screenshot//" + "newSave.png"));
		InputStream InputStreamSave = new FileInputStream(".//screenshot//" + "newSave.png");
		byte[] bytesSave = IOUtils.toByteArray(InputStreamSave);
		int idSave = myWorkbook.addPicture(bytesSave, Workbook.PICTURE_TYPE_JPEG);
		InputStreamSave.close();
		ClientAnchor anchorSave = new XSSFClientAnchor();
		anchorSave.setCol1(3);
		anchorSave.setRow1(5);
		XSSFPicture pictureSave = myDrawing.createPicture(anchorSave, idSave);
		pictureSave.resize(0.8, 0.8);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("save.assessment")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("after.save")))).click();
	
		FileOutputStream fileOutTwo = new FileOutputStream(System.getProperty("user.dir") + "\\src\\Screenshots.xlsx");
		myWorkbook.write(fileOutTwo);

		fileOutTwo.close();
		myWorkbook.close();

		driver.close();

	}

}