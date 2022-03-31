package utilClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utilClass1 {

	public static void movetoelement(WebDriver driver, WebElement Element)
	{
		Actions act = new Actions (driver);
		act.moveToElement(Element).perform();
	}
	
	
	
	
	public static boolean iselementvisible(WebDriver driver, WebElement Element)
	{
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(Element)).isDisplayed();		
	}
	
	
	
	public static List<String> getMultipleDataFromXcel(int firstRow, int lastRow ) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream ("src\\main\\resources\\DataSheet\\data.xlsx");
		List<String> dataList = new ArrayList<String>();
		
		Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet1");
		
		for(int i=firstRow; i<= lastRow; i++) 
		{
			try  // we have string and long value thats why we used try and catch 
			{
				String stringData = sheet.getRow(i).getCell(1).getStringCellValue();
				dataList.add(stringData);
			}
			catch(Exception e)
			{
				long intData = (long)sheet.getRow(i).getCell(1).getNumericCellValue();
				String string = String.valueOf(intData); // covnvert long into string value
				dataList.add(string);	
			}
		}
		return dataList;
		
	}
	
	
	public static void moveByoffset(WebDriver driver)
	{
		Actions act = new Actions (driver);
		act.moveByOffset(200, 0).release().build().perform();
		
	}
	
	public String getconfigData(String key) throws IOException
	{
		FileInputStream file = new FileInputStream ("configuration\\config.properties");
		
		Properties property = new Properties(); // create the object of properties class
		property.load(file); // load the config.properties file by using load method
		
		String c = property.getProperty(key); // get the value from config.properties file so used getproperty method
		return c;
		
	}
	
    public String screenCpature(WebDriver driver) throws IOException {
		
		Date date = new Date();
		String modifiedDate= new SimpleDateFormat("MM-dd-mm-hh-ss").format(date);
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("screenShot" + modifiedDate +".png");
		String path = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return path;
		}

}
