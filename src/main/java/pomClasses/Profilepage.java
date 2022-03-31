package pomClasses;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClasses.utilClass1;

public class Profilepage extends utilClass1 {
	
WebDriver driver;
	
	@FindBy (xpath="//div[text()='Manage Addresses']")
	private WebElement manageaddress;
	
	@FindBy (xpath = "//div[text()='ADD A NEW ADDRESS']")
	private WebElement newaddress;
	
	@FindBy (xpath = "//textarea[@name='addressLine1']")
	private WebElement address;
	
	@FindBy (xpath = "//button[text()='Save']")
	private WebElement savebutton;
	
	@FindBy (xpath = "//div[@class='_1CeZIA']")
	private List<WebElement> listofaddress;
	
	
	public Profilepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickonmanageaddress()
	{
		iselementvisible(driver,manageaddress);
		manageaddress.click();
	}
	
	public void clickonnewaddress()
	{
		iselementvisible(driver,newaddress);
		newaddress.click();
	}
	
//	public void getDataForAddress(List<String> a) throws EncryptedDocumentException, IOException
//	{
//		//List<String> list = getMultipleDataFromXcel(0,3);
//		
//		for(int i=1; i<=4; i++)
//		{
//			WebElement element = driver.findElement(By.xpath("((//form)[2]//input)["+i+"]"));
//			element.sendKeys(a.get(i-1));
//		}
//	}
	
	public void getDataForAddress() throws EncryptedDocumentException, IOException
	{
		List<String> list = getMultipleDataFromXcel(0,3);
		
		for(int i=1; i<=4; i++)
		{
			WebElement element = driver.findElement(By.xpath("((//form)[2]//input)["+i+"]"));
			element.sendKeys(list.get(i-1));
		}
	}
	
	public void enteraddress()
	{
		iselementvisible(driver,address);
		address.sendKeys("Shuvira Niwas hadapsar pune");
	}
	
	public void clicksavebutton()
	{
		iselementvisible(driver,savebutton);
		savebutton.click();
	}
	
	public int countofaddress() throws InterruptedException
	{
		Thread.sleep(2000);
		return listofaddress.size();
		
	}

}
