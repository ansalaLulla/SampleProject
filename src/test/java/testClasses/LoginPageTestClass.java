package testClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;

public class LoginPageTestClass extends BaseClass {
	    
  

    LoginPageClass objLoginPage;
    HomePageClass objHomePage;
    
    
    @Test(priority = 0, dataProvider = "successfulllogin",dataProviderClass = DataProviderClass.class)

    public void verify_Successful_Login(String uname,String passwd) throws IOException{

    objLoginPage = new LoginPageClass(driver);

    objLoginPage.enterUserName(uname);
    objLoginPage.enterPassword(passwd);
    objLoginPage.clickLogin();
    
    objHomePage = new HomePageClass(driver);
    
    String actualUserName = objHomePage.getHomePageDashboardUserName();
    
    Assert.assertTrue(actualUserName.toLowerCase().contains(objHomePage.readStringData(5, 1)));
    
   }
    
    @Test(priority = 1, dataProvider = "unsuccessfulllogin",dataProviderClass = DataProviderClass.class)

    public void verify_Unsuccessful_Login(String uname,String passwd){

    objLoginPage = new LoginPageClass(driver);

    objLoginPage.enterUserName(uname);
    objLoginPage.enterPassword(passwd);
    objLoginPage.clickLogin();
    
    objHomePage = new HomePageClass(driver);
    
    String actualAlertMsg = objHomePage.getTextAlertMsg();
    
    objHomePage.handleAlert();
    
    String expectedAlertMsg = "User or Password is not valid";
    
    Assert.assertEquals(actualAlertMsg,expectedAlertMsg);
    
   }
    
    
    
    

}
