package testClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import baseClasses.BaseClass1;
import pomClasses.Homepage;
import pomClasses.LogInpage;
import pomClasses.Profilepage;

public class textClass1 {
	
	WebDriver driver;
	LogInpage loginpage;
	Homepage homepage;
	Profilepage profilepage;
	
	ExtentReports reports; //declare global variable
	ExtentTest test;
	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeclass(String a)
	{
		reports = new ExtentReports("ExtentReports.html",true); // used for generating ExtentReport.html
		test = reports.startTest("textclass1");
		
		driver = BaseClass1.getWebdriver(a);
	}
	
	@BeforeMethod
	public void beforemethod()
	{
	   loginpage = new LogInpage(driver);
	   homepage = new Homepage(driver);
	   profilepage = new Profilepage(driver);
	}
	
	@Test
	public void verifyloginpage() throws IOException 
	{
		loginpage.enteremailid();
		loginpage.enterpassword();
		loginpage.clicksubmitbutton();
		
		homepage.hovertoprofilename();
		
		String txt = homepage.getlogoutTxt();
		Assert.assertEquals(txt, "Logout"); // hard asset Assertion used to validate the page
				
//		if(txt.equals("Logout"))
//		{
//			System.out.println("Test passed");
//		}
//		
//		else 
//		{
//			Assert.fail();	
//		}
		
		//Reporter.log("testcase passed");
		test.log(LogStatus.PASS, "verify loginpage");		
	}
	
//	@DataProvider(name="dataSet") // execute the test with multiple test data so user @DataProvider
//	public String [][] dataToTest()
//	{
//		String [][] data = {{"vishal","9766880538","411028","hadapsar"},{"akshay","7498785008","415001","satara"}};
//		return data;
//	}
//	
//	@Test(priority=1, dataProvider ="dataSet")
//	public void verifyhomepage(String name, String mobilenumber, String pincode, String locality) throws EncryptedDocumentException, IOException, InterruptedException 
//	{
//		homepage.hovertoprofilename();
//		homepage.clickonmyprofile();
//		
//		profilepage.clickonmanageaddress();
//		profilepage.clickonnewaddress();
//		
//		
//		List<String> dataList = new ArrayList<>();
//		dataList.add(name);
//		dataList.add(mobilenumber);
//		dataList.add(pincode);
//		dataList.add(locality);
//		profilepage.getDataForAddress(dataList);
//	}
	
	@Test(priority=1)
	public void verifyhomepage() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		homepage.hovertoprofilename();
		homepage.clickonmyprofile();
		
		profilepage.clickonmanageaddress();
		profilepage.clickonnewaddress();
		
		int beforecount = profilepage.countofaddress();
		System.out.println(beforecount);
		
		profilepage.getDataForAddress();
		profilepage.enteraddress();
		profilepage.clicksavebutton();
		
		int aftercount = profilepage.countofaddress();
		System.out.println(aftercount);
		
		Assert.assertEquals(aftercount, (beforecount+1));
		
		//Reporter.log("testcase passed");
		
		test.log(LogStatus.PASS, "verify homepage");
	}

	
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE) 
		{
			test.log(LogStatus.FAIL, test.addScreenCapture(profilepage.screenCpature(driver)), "Taken Screenshot");
		}
		//loginpage=null; // if we not using object then we can object send to garbage collection
		//System.gc();
	}
	
	@AfterClass
	public void afterclass()
	{
		reports.endTest(test);
		reports.flush();
		//driver.quit();
	}

}
