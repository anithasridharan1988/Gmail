package Cortex.Test;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Framework.Browser;
import Pages.CreateAccountpage;
import util.excelread;
import util.property;

public class CreateAccount extends Browser {
	
	property pc = new property();
	
	public String filepath = "C:\\Users\\Dinesh Sekar\\eclipse-workspace\\Test\\Input";
	public String filename = "CreateAccount.xlsx";
	public String sheetname = "TestAccount";
	public String obj_rep = "C:\\Users\\Dinesh Sekar\\eclipse-workspace\\Test\\Property\\objectrepository.properties";
	public String Env_rep = "C:\\Users\\Dinesh Sekar\\eclipse-workspace\\Test\\Property\\Environmentalvariables.properties";
	
	@BeforeTest
	public void login()
	{
		launchbrowser();
		driver.get("https://accounts.google.com/");
	}
	
	@DataProvider
	public String[][] data() throws IOException
	{
		excelread read = new excelread();
		return read.readexceldata(filepath, filename, sheetname);
		 
	}
	
	@Test(priority=0,dataProvider="data")
	public void createTestAccount(String Firstname,String Lastname,String Username,String Password,String confirmpassword,String phone_no,String birthdate,String birthmonth,String birthyear,String gendervalue) throws InterruptedException, AWTException
	{
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);   
		CreateAccountpage ac = new CreateAccountpage(driver);
		ac.click_createAccount();
		ac.Enter_fristname(Firstname);
		ac.Enter_lastname(Lastname);
		ac.Enter_username(Username);
		ac.Enter_password(Password);
		ac.Enter_confirmpassword(confirmpassword);
		ac.click_nextbutton();
		ac.Enter_phonenumber(phone_no); 
		ac.click_nextbutton2();
		Thread.sleep(8000); // Manually enter the security code and click verify button
		ac.Enter_Birthdate(birthdate);
		ac.Select_Birthmonth(birthmonth);
		ac.Enter_BirthYear(birthyear);
		ac.Select_Gender(gendervalue);
		ac.click_nextbutton2();
		Thread.sleep(5000);
		ac.Click_YesIamIn();
		ac.Click_Iagree();
		
	}
	
	@AfterTest
	public void closebrowser()
	{
		driver.close();
	}

}
