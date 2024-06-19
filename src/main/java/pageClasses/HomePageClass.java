package pageClasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.ExcelReader;
import utilityClasses.GeneralUtilities;

public class HomePageClass {
	

	WebDriver driver;
	
	GeneralUtilities objGenUtility = new GeneralUtilities();

    @FindBy(xpath = "//table//tr[@class='heading3']") WebElement homePageUserName;

    public HomePageClass(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    
  //Get the User name from Home Page

    public String getHomePageDashboardUserName(){

     //return  homePageUserName.getText();
    	return objGenUtility.getTextMethod(homePageUserName);

    }
    
    // Handle Alert by Accept
    
    public void handleAlert() {
    	
    	objGenUtility.acceptAlertMsg(driver);
    }
    
  //Get the text from Alert
    
    public String getTextAlertMsg() {
    	return objGenUtility.getTextOfAlertMsg(driver);
    }
    
 // read string data from excel 
    public String readStringData(int row,int column) throws IOException
	{
		return ExcelReader.getStringdata(row, column);
	}

}
