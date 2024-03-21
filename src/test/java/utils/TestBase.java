package utils;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	public WebDriver WebDriverManager()throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		String browser_properties = prop.getProperty("browser");
		String browser_maven=System.getProperty("browser");
		//result = testCondition?value1:value2    java terniary operator
		
		String browser = browser_maven!=null?browser_maven:browser_properties ;
		
		if(driver==null)
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromeDriver.exe");
		//WebDriverManager.chromedriver().setup();
//			ChromeOptions options =new ChromeOptions();
//			options.setBinary("C:\\Users\\vikas\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
//			options.addArguments("--remote-allow-origins=*");
//		   driver = new ChromeDriver(options);
		   driver = new ChromeDriver();
		   //driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
		     }
		     if(browser.equalsIgnoreCase("firefox"))
		      {
			//firefox code
		       }
		     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize(); 
		}
		
		return driver;
}
}
