package testClasses;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utilityClasses.ExcelReader;

public class DataProviderClass {
  
  
  
  @DataProvider(name="unsuccessfulllogin")
  public Object[][] dp() throws IOException {
	    return new Object[][] {
	      new Object[] { ExcelReader.getStringdata(2,4),ExcelReader.getStringdata(3,4) },
	      new Object[] { ExcelReader.getStringdata(2,5),ExcelReader.getIntegerdata(3,5) },
	      new Object[] { ExcelReader.getStringdata(2,6),ExcelReader.getStringdata(3,6) }
	    };
  }
  
  @DataProvider(name="successfulllogin")
  public Object[][] dp1() throws IOException {
    return new Object[][] {
      new Object[] { ExcelReader.getStringdata(2,1),ExcelReader.getStringdata(3,1) }
    
      
    };
  }
  
  
  
  }

  
  
  

