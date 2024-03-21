package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public LandingPage landingPage;
	WebDriver driver;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver= driver;
	}
	
	public LandingPage getLandingPage()
	{
	landingPage = new LandingPage(driver);	
	//returning landingPage 
	return landingPage;
	}


}
