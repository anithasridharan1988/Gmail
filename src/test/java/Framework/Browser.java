package Framework;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

public class Browser {
	
	public WebDriver driver ;
	
	@Test
	public void launchbrowser()
	{
		/*String chromepath = "C:\\Users\\Anitha\\chromedriver.exe" ;
		System.setProperty("WebDriver.chrome.driver",chromepath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		//options.addArguments("start-maximized");
		options.addArguments("--disable-notifications");
		driver =new ChromeDriver(options); */
		
		String path = "C:\\Users\\Anitha\\geckodriver.exe" ;
		System.setProperty("WebDriver.firefox.driver",path);
		driver = new FirefoxDriver();
		
		
		
	}

}
