package pomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClasses.utilClass1;

public class LogInpage extends utilClass1 {
	
	 WebDriver driver; // declare driver global variable
		
		
		@FindBy (xpath= "(//input[@type='text'])[2]") // by using pagefactory @FindBy annotation
		private WebElement emailid; // webelement will be private(variable)
		
		@FindBy (xpath="//input[@type='password']" )
		private WebElement password;
		
		@FindBy (xpath = "(//button[@type='submit'])[2]")
		private WebElement submitbutton;
		
		
		
		public LogInpage(WebDriver driver) // call constructor to initialize the variable and passing the parameter
		{
			PageFactory.initElements(driver, this);
			this.driver = driver; // assign the value to global variable
		}
		
		
		
		public void enteremailid() throws IOException // access the variables by using public method 
		{
			iselementvisible(driver,emailid);
			emailid.sendKeys(getconfigData("email"));
		}
		
		public void enterpassword() throws IOException
		{
			iselementvisible(driver,password);
			password.sendKeys(getconfigData("password"));
		}
		
		public void clicksubmitbutton()
		{
			iselementvisible(driver,submitbutton);
		    submitbutton.click();
		}


}
