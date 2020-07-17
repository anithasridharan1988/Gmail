package Cortex.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Framework.Browser;
import Framework.commonclass;
import Pages.GmailLoginpage;
import util.excelread;
import util.property;

public class GmailLogin extends Browser{
	
	property pc = new property();
	commonclass cc = new commonclass();
	
	public String obj_rep = "C:\\Users\\Dinesh Sekar\\eclipse-workspace\\Test\\Property\\objectrepository.properties";
	public String Env_rep = "C:\\Users\\Dinesh Sekar\\eclipse-workspace\\Test\\Property\\Environmentalvariables.properties";
 
	public String filepath = "C:\\Users\\Dinesh Sekar\\eclipse-workspace\\Test\\Input";
	public String filename = "Loginuser.xlsx";
	public String sheetname = "input";
	
	@BeforeTest
	public void launchsite()
	{
		launchbrowser();
		driver.get(pc.propertyfile(obj_rep).getProperty("url"));
	}
	
	@DataProvider
	public String[][] readexcel() throws IOException
	{
		excelread read = new excelread();
		return read.readexceldata(filepath, filename, sheetname);
		 
	}
	
	@Test(priority=1,dataProvider="readexcel")
	public void validlogin(String user_name, String password) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);   
		GmailLoginpage gl = new GmailLoginpage(driver);
		gl.email(user_name);
		gl.clickNext();
		gl.password(password);
		gl.clickNext2();
		gl.click_profileicon();
        String actualprofilename = gl.profile_name;
		Assert.assertEquals(actualprofilename, user_name);
		System.out.println("Assert Passed : Logged in Successfully");
		gl.logout();
	
	}
	
	
	@AfterTest
	public void closebrower()
	{
		driver.close();
	}

}
