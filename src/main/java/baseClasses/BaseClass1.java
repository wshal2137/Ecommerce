package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass1 {
	
	public static WebDriver getWebdriver(String a)  
	{
		if(a.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Browser\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.flipkart.com/");
			
			driver.manage().window().maximize();
			
			return driver; 
			
		}
		else
		{
			System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Browser\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			
			driver.get("https://www.flipkart.com/");
			
			driver.manage().window().maximize();
			
			return driver; 
			
		}
		
	}


}
