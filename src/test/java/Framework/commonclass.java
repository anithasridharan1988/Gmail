package Framework;

import org.openqa.selenium.By;
import util.property;

public class commonclass {
	
	property p = new property();
	String obj_rep = "C:\\Users\\Dinesh Sekar\\eclipse-workspace\\Test\\Property\\objectrepository.properties";
	
	public String[] split(String value)
	{
		String[] splitstring = value.split("&");
		return splitstring;
	}
	
	public By findlocator(String locat, String value)
	{
		
		System.out.println("locat : "+locat);
		System.out.println("value : "+value);
		By locatorvalue = null;
		switch (locat)
		{
		case "id":
			locatorvalue = By.id(value);
		    break;
		
		
		case "name":
			locatorvalue = By.name(value);
			break;
		
		case "classname":
			locatorvalue = By.className(value);
			break;
		
		case "tagname":
			locatorvalue = By.tagName(value);
			break;
		
		case "xpath":
			locatorvalue = By.xpath(value);
			break;
		
		case "linkText":
			locatorvalue = By.linkText(value);
			break;
		
		case "partialLinkText":
			locatorvalue = By.partialLinkText(value);
			break;
			
		default :
			break;
		
		}
		System.out.println("locatorvalue : "+locatorvalue);
		return locatorvalue;
		
	}
	
	public By locatorfromprop(String value)
	{
		
		String[] loc_string = split(value);
	    String locator = loc_string[0];
		String locatorvalue = loc_string[1];
		By outputlocatorvalue = findlocator(locator,locatorvalue);
		System.out.println("outputlocatorvalue : "+outputlocatorvalue);
		return outputlocatorvalue;
			
	}

}
