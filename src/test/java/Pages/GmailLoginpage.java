package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.commonclass;
import util.property;

public class GmailLoginpage {
	
	@FindBy(id="identifierId")
	WebElement email;
	@FindBy(id="identifierNext")
	WebElement next;
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="(//div[@role='button'])[2]")
	WebElement next2;
	@FindBy(xpath="gb_vb")
	WebElement profilename;
	@FindBy (xpath = "//*[@id=\"gb\"]/div[2]/div[3]/div[1]/div[2]/div/a")
	WebElement profileicon;
	@FindBy (xpath="//a[@id='gb_71']")
	WebElement signout;
	
	property pc = new property();
	commonclass cc = new commonclass();
	
	String obj_rep = "C:\\Users\\Dinesh Sekar\\eclipse-workspace\\Test\\Property\\objectrepository.properties";
	String Env_rep = "C:\\Users\\Dinesh Sekar\\eclipse-workspace\\Test\\Property\\Environmentalvariables.properties";
	
	WebDriver driver = null;
	public WebDriverWait wait;
	public String profile_name = null;
	
	
	public GmailLoginpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void email(String username)
	{
		email.sendKeys(username);
	}

	public void clickNext()
	{
		next.click();
	}
	
	public void password(String pass_word)
	{
		password.sendKeys(pass_word);
	}
	
	public void clickNext2()
	{
		next2.click();
	}
	
	public String getProfilename()
	{
	   String profile_name = profilename.getText();
	   return profile_name;
	}
	
	public void click_profileicon()
	{
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(profileicon));
		profileicon.click();
	}
	
	public void logout()
	{
		wait.until(ExpectedConditions.elementToBeClickable(signout));
		signout.click();
	}

}
