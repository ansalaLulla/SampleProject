package testClasses;

import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilityClasses.ScreenShotClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.IOException;


public class BaseClass {
  
	WebDriver driver;
	public static Properties p;
	
	
	public static void readProperty() throws IOException
	{
		p=new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\configuration.properties");
		p.load(fs);
	}
	
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	  readProperty();
	  WebDriverManager.edgedriver().setup();
	  driver=new EdgeDriver();
	  driver.get(p.getProperty("url"));
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }
  
  @AfterMethod

  public void afterMethod(){
	  		driver.quit();
		
		
	}

}
