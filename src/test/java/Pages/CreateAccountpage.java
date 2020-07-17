package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountpage {
	@FindBy(id="ow293")
	WebElement createaccountbutton;
	@FindBy(xpath="(//div[@class='jO7h3c'])[1]")
	WebElement formyself;
	@FindBy(id="firstName")
	WebElement firstname;
	@FindBy(id="lastName")
	WebElement lastname;
	@FindBy(id="username")
	WebElement username;
	@FindBy(xpath="//input[@name='Passwd']")
	WebElement password;
	@FindBy(xpath="//input[@name='ConfirmPasswd']")
	WebElement confirmpassword;
	@FindBy(id="accountDetailsNext")
	WebElement nextbutton;
	@FindBy(id="phoneNumberId")
	WebElement phonenumberid;
	@FindBy(xpath="(//div[@class='VfPpkd-RLmnJb'])[1]")
	WebElement nextbutton2;
	@FindBy(xpath="(//div[@class='VfPpkd-RLmnJb'])[2]")
	WebElement verifybutton;
	@FindBy(xpath="//input[@id='day']")
	WebElement birthdate;
	@FindBy(xpath="//select[@id='month']")
	WebElement monthdropdown;
	@FindBy(xpath="//input[@id='year']")
	WebElement birthyear;
	@FindBy(xpath="//select[@id='gender']")
	WebElement genderdropdown;
	@FindBy(xpath="//span[contains(text(),'Skip')]//following::div[1]")	
	WebElement skip;
	@FindBy(xpath="//div[@class='OZliR']//div[@role='button' and @id='termsofserviceNext']")
	WebElement IAgreebutton;
	
	WebDriver driver = null;	
	
	public CreateAccountpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void click_createAccount() throws InterruptedException
	{		
		Actions as = new Actions(driver);
	    as.moveToElement(createaccountbutton).click().build().perform();
	    Thread.sleep(4000);
	    as.moveToElement(formyself).click().build().perform();
		
	}
	
	/*public void click_Myselflink()
	{
		formyself.click();
	}*/
	
	public void Enter_fristname(String First_name)
	{
		firstname.sendKeys(First_name);
	}
	
	public void Enter_lastname(String Last_name)
	{
		lastname.sendKeys(Last_name);
	}
	
	public void Enter_username(String User_name)
	{
		username.sendKeys(User_name);
	}
	
	public void Enter_password(String Pass_word)
	{
		password.sendKeys(Pass_word);
	}
	
	public void Enter_confirmpassword(String confirm_password)
	{
		confirmpassword.sendKeys(confirm_password);
	}
	
	public void click_nextbutton()
	{
		nextbutton.click();
	}
	
	public void Enter_phonenumber(String phoneno)
	{
		phonenumberid.sendKeys(phoneno);
	}
	
	public void click_nextbutton2()
	{
		nextbutton2.click();
	}
	
	public void click_verify()
	{
		verifybutton.click();
	}
	
	public void Enter_Birthdate(String date)
	{
		birthdate.sendKeys(date);
	}
	
	public void Select_Birthmonth(String month)
	{
		monthdropdown.click();
		Select ss = new Select(monthdropdown);
		ss.selectByVisibleText(month);
	}
	
	public void Enter_BirthYear(String year)
	{
		birthyear.sendKeys(year);
	}
	
	public void Select_Gender(String gender)
	{
		genderdropdown.click();
		Select s2= new Select(genderdropdown);
		s2.selectByVisibleText(gender);
	}
	
	public void Click_YesIamIn() throws AWTException
	{
		
		
		
		/*Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB); 
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB); 
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB); 
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);*/
		skip.click();
	}
	
	public void Click_Iagree()
	{
		IAgreebutton.click();
	}
	
	

}
