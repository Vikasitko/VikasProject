package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;
	public GenericUtils(WebDriver driver)
	{
		this.driver= driver;
	}
	
	public void switchWindowToChild()
	{
		 //window handle 
	    Set<String> allw = driver.getWindowHandles();
	    
	    Iterator<String> itr = allw.iterator();
	    String parentWindow = itr.next();
	    String childWindow = itr.next();
	    driver.switchTo().window(childWindow);
	}
	
	public void closeToChildWindow()
	{
		 driver.close();
	    Set<String> allw = driver.getWindowHandles();
	    
	    Iterator<String> itr = allw.iterator();
	    String parentWindow = itr.next();
	    //String childWindow = itr.next();
	    driver.switchTo().window(parentWindow);
	}

}
