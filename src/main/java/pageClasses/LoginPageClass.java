package pageClasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.ExcelReader;
import utilityClasses.GeneralUtilities;

public class LoginPageClass {
	
	WebDriver driver;
	
	GeneralUtilities objGenUtility = new GeneralUtilities();
	
	@FindBy(name= "uid" ) WebElement userNameTextbox;

	@FindBy(name= "password" ) WebElement passwordTextbox;

	@FindBy(name= "btnLogin" ) WebElement loginButton;
    

    public LoginPageClass(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //Enter user name in textbox

    public void enterUserName(String strUserName){

        //userNameTextbox.sendKeys(strUserName);
    	objGenUtility.typeText(userNameTextbox, strUserName);

    }

    //Enter password in password textbox

    public void enterPassword(String strPassword){

         //passwordTextbox.sendKeys(strPassword);
    	objGenUtility.typeText(passwordTextbox, strPassword);

    }
    
    // read string data from excel 
    public String readStringData(int row,int column) throws IOException
	{
		return ExcelReader.getStringdata(row, column);
	}
	
    // read integer data from excel
	public String readIntegerData(int row,int column) throws IOException
	{
		return ExcelReader.getIntegerdata(row, column);
	}

    //Click on login button

    public void clickLogin(){

            //loginButton.click();
    	objGenUtility.clickElement(loginButton);

    }
    

    

}
