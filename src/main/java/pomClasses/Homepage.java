package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClasses.utilClass1;

public class Homepage extends utilClass1 {
	
	 WebDriver driver;
		
		@FindBy (xpath="//div[text()='Vishal ']" )
		private WebElement profilename ;
		
		@FindBy (xpath="//div[text()='My Profile']/parent::a/parent::li")
	    private WebElement myprofile;
		

		@FindBy (xpath="(//li[@class='_2NOVgj'])[10]")
		private WebElement logoutTxt;
		
		public Homepage(WebDriver driver) // call constructor to initialize the variable and passing the parameter
		{
			PageFactory.initElements(driver, this);
			this.driver = driver; // assign the value to global variable
		}
		
		public void hovertoprofilename()
		{
			iselementvisible(driver, profilename);
			movetoelement(driver, profilename );
			
		}
		
		public void clickonmyprofile()
		{
			iselementvisible(driver, myprofile);
			myprofile.click();
			moveByoffset(driver);	
		}
		
		
		public String getlogoutTxt()
		{
			return logoutTxt.getText();
		}


}
