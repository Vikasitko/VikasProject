package stepDefitions;

import java.io.IOException;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	TestContextSetup textContextSetup;
	
	public Hooks(TestContextSetup textContextSetup)
	{
		this.textContextSetup=textContextSetup; 
	}
	@After
	public void AfterScenario() throws IOException
	{
		textContextSetup.testBase.WebDriverManager().quit();
	}

	@AfterStep
	public void AddScreenShot(Scenario scenario) throws IOException
	{
		WebDriver driver =textContextSetup.testBase.WebDriverManager(); 
		if(scenario.isFailed())
		{
		//screen shot code
		File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent=FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(fileContent, "image/png", "image");
		}
	}
	
}
